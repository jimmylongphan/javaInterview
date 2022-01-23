package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Class representing the kitchen
 * This will contain the shelves that contain the orders.
 *
 * There will be a priority queue on the expirationTimes of the orders.
 */
public class Bep {
    private static final Logger logger = LogManager.getLogger(Bep.class);

    private static final String VALUE = "order {} has value {}";

    // map of temperature to the shelf
    private Map<TempEnum, CaiKe> shelfMap;

    // map of order id to the order
    private Map<String, GoiMon> allOrders;

    // 1 thread to write
    // multiple threads to read
    // reentrant means same thread can acquire it
    private ReadWriteLock rwLock;
    private Lock readLock;
    private Lock writeLock;

    /**
     * Constructor
     * Creates the 4 shelves based on their capacities
     * puts them into a map for fast access
     *
     * @param hotShelfCapacity
     * @param coldShelfCapacity
     * @param frozenShelfCapacity
     * @param overflowShelfCapacity
     */
    Bep(int hotShelfCapacity, int coldShelfCapacity, int frozenShelfCapacity, int overflowShelfCapacity) {
        CaiKe hotShelf = new CaiKe(TempEnum.HOT, hotShelfCapacity, 1);
        CaiKe coldShelf = new CaiKe(TempEnum.COLD, coldShelfCapacity, 1);
        CaiKe frozenShelf = new CaiKe(TempEnum.FROZEN, frozenShelfCapacity, 1);
        CaiKe overflowShelf = new CaiKe(TempEnum.ANY, overflowShelfCapacity, 2);

        this.shelfMap = new HashMap<>();
        this.shelfMap.put(TempEnum.HOT, hotShelf);
        this.shelfMap.put(TempEnum.COLD, coldShelf);
        this.shelfMap.put(TempEnum.FROZEN, frozenShelf);
        this.shelfMap.put(TempEnum.ANY, overflowShelf);

        this.allOrders = new HashMap<>();

        this.rwLock = new ReentrantReadWriteLock();
        this.readLock = rwLock.readLock();
        this.writeLock = rwLock.writeLock();
    }

    /**
     * add an order to a shelf
     * use write lock because shelves are being modified
     *
     * @param currentTimeMillis
     * @param goiMon
     */
    public void addGoiMon(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            // find out which shelf this plate belongs to
            TempEnum tempEnum = goiMon.getTempEnum();

            CaiKe shelf = getAvailableShelf(currentTimeMillis, tempEnum);

            // update the order with this shelf
            goiMon.shelf(currentTimeMillis, shelf);

            allOrders.put(goiMon.getId(), goiMon);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * remove an order
     * @param currentTimeMillis
     * @param goiMon
     */
    public void removeGoiMon(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            // get the shelf this order belongs to and remove
            goiMon.unshelf(currentTimeMillis);

            allOrders.remove(goiMon.getId());
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Get the shelf that matches temp
     * if temp is full, then try overflow
     * if overflow is full, then remove random from overflow
     *
     *
     * @param currentTimeMillis
     * @param tempEnum the temp of the order
     * @return a shelf to put the new order
     */
    private CaiKe getAvailableShelf(long currentTimeMillis, TempEnum tempEnum) {
        CaiKe shelf = shelfMap.get(tempEnum);
        // get matching shelf if available
        if (!shelf.isFull()) {
            return shelf;
        }

        // matching shelf is full check the overflow
        shelf = shelfMap.get(TempEnum.ANY);

        // overflow is full
        if (shelf.isFull()) {
            handleOverflow(currentTimeMillis, tempEnum);
        }

        // overflow has space
        return shelf;
    }

    /**
     * The desired shelf and overflow shelf is full
     */
    private void handleOverflow(long currentTimeMillis, TempEnum tempEnum) {
        // search for orders in overflow that is not matching tempEnum
        writeLock.lock();
        try {
            GoiMon toMove = null;
            GoiMon backup = null; // pick a random or first order from other shelf
            for(Map.Entry<String, GoiMon> entry : allOrders.entrySet()) {
                GoiMon goiMon = entry.getValue();

                if (goiMon.getCaiKe().getTempEnum() != TempEnum.ANY) {
                    // only process overflow orders
                    continue;
                }

                // we are in overflow
                TempEnum otherTemp = goiMon.getTempEnum();
                if(otherTemp == tempEnum) {
                    // skip orders that have same temp
                    continue;
                }

                // check if the shelf of this other order is not full
                CaiKe otherShelf = shelfMap.get(otherTemp);
                if(!otherShelf.isFull()) {
                    // move a desired order off of overflow
                    underflow(currentTimeMillis, goiMon);
                    return;
                }
            }

            // no free shelves, use the backup
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * This order is in overflow
     * move it from overflow to its available shelf
     * @param currentTimeMillis
     * @param goiMon goiMon to move
     */
    private void underflow(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            // unshelf from overflow
            goiMon.unshelf(currentTimeMillis);

            // re-add to available shelf
            addGoiMon(currentTimeMillis, goiMon);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Method to iterate through all orders and get low value ones
     * @param currentTimeMillis
     * @return
     */
    public List<GoiMon> getExpiredGoiMons(long currentTimeMillis) {
        readLock.lock();

        try {
            List<GoiMon> list = new LinkedList<>();

            for(Map.Entry<String, GoiMon> entry : allOrders.entrySet()) {
                GoiMon goiMon = entry.getValue();
                double value = goiMon.computeValue(currentTimeMillis);

                logger.debug(VALUE, goiMon.getId(), value);

                if (value <= 0) {
                    list.add(goiMon);
                }
            }

            return list;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * Remove all goimons from this list
     * @param currentTimeMillis
     * @param goiMons
     */
    public void removeExpiredGoiMons(long currentTimeMillis, List<GoiMon> goiMons) {
        writeLock.lock();

        try {
            for(GoiMon goiMon : goiMons) {
                removeGoiMon(currentTimeMillis, goiMon);
            }
        } finally {
            writeLock.unlock();
        }
    }

}
