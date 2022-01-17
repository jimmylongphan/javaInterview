package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
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

    private Map<TempEnum, CaiKe> shelfMap;
    private PriorityQueue<GoiMon> priorityQueue;

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

        priorityQueue = new PriorityQueue<GoiMon>(Comparator.comparingLong(GoiMon::getExpirationTime));

        this.rwLock = new ReentrantReadWriteLock();
        this.readLock = rwLock.readLock();
        this.writeLock = rwLock.writeLock();
    }

    /**
     * add a order to a shelf
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

            CaiKe shelf = shelfMap.get(tempEnum);
            boolean added = shelf.addGoiMon(currentTimeMillis, goiMon);
            if (!added) {
                handleOverflow(currentTimeMillis, goiMon);
            } else {
                // order has been added to shelf
                // compute its expiration time
                goiMon.computeExpirationTime(currentTimeMillis);
                // add it to the priority queue
                priorityQueue.add(goiMon);
            }
        } finally {
            writeLock.unlock();
        }
    }

    private void handleOverflow(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            CaiKe shelf = shelfMap.get(TempEnum.ANY);
            shelf.addGoiMon(currentTimeMillis, goiMon);
            goiMon.computeExpirationTime(currentTimeMillis);
            // add it to the priority queue
            priorityQueue.add(goiMon);
        } finally {
            writeLock.unlock();
        }
    }

    public void removeGoiMon(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            TempEnum tempEnum = goiMon.getTempEnum();

            // try to remove from original shelf
            CaiKe shelf = shelfMap.get(tempEnum);
            if(!shelf.removeGoiMon(currentTimeMillis, goiMon)) {
                // original shelf does not have it
                // try overflow shelf
                shelf = shelfMap.get(TempEnum.ANY);
                shelf.removeGoiMon(currentTimeMillis, goiMon);
            }
        } finally {
            writeLock.unlock();
        }
    }
}
