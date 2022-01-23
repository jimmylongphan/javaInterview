package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A class representing a shelf
 *
 * Has 3 attributes related to the order
 * Shelf
 */
public class CaiKe {
    private static final Logger logger = LogManager.getLogger(CaiKe.class);

    private static final String SHELVING = "{} shelf is shelving order: {} at: {}";
    private static final String UNSHELVING = "{} shelf is unshelving order: {} at: {}";

    private int shelfDecayModifier;
    private TempEnum tempEnum;
    private int maxCapacity;
    private int currentCapacity;

    // private Set<GoiMon> goiMons;

    // 1 thread to write
    // multiple threads to read
    // reentrant means same thread can acquire it
    private ReadWriteLock rwLock;
    private Lock readLock;
    private Lock writeLock;

    public CaiKe(TempEnum tempEnum, int maxCapacity, int shelfDecayModifier) {
        this.shelfDecayModifier = shelfDecayModifier;
        this.tempEnum = tempEnum;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;

        // this.goiMons = new HashSet<>();

        this.rwLock = new ReentrantReadWriteLock();
        this.readLock = rwLock.readLock();
        this.writeLock = rwLock.writeLock();
    }

    public TempEnum getTempEnum() {
        return tempEnum;
    }

    public CaiKe setTempEnum(TempEnum tempEnum) {
        this.tempEnum = tempEnum;
        return this;
    }

    public int getShelfDecayModifier() {
        return shelfDecayModifier;
    }

    public CaiKe setShelfDecayModifier(int shelfDecayModifier) {
        this.shelfDecayModifier = shelfDecayModifier;
        return this;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public CaiKe setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public void addGoiMon(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            logger.info(SHELVING, tempEnum, goiMon.getId(), currentTimeMillis);
            this.currentCapacity++;
        } finally {
            writeLock.unlock();
        }
    }

    public void removeGoiMon(long currentTimeMillis, GoiMon goiMon) {
        writeLock.lock();

        try {
            this.currentCapacity--;
            logger.info(UNSHELVING, tempEnum, goiMon.getId(), currentTimeMillis);
        } finally {
            writeLock.unlock();
        }
    }

    public boolean isFull() {
        readLock.lock();
        try {
            return this.maxCapacity == this.currentCapacity;
        } finally {
            readLock.unlock();
        }
    }

    public int size() {
        readLock.lock();
        try {
            return this.currentCapacity;
        } finally {
            readLock.unlock();
        }
    }
}
