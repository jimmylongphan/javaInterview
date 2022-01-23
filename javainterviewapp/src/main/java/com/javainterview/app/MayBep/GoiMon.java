package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Order
 */
public class GoiMon {
    private static final Logger logger = LogManager.getLogger(GoiMon.class);

    // fields from json input
    private String id;
    private String name;
    private String temp;
    private int shelfLife;
    private float decayRate;

    // extra metadata
    private long shelfLifeMillis;
    private TempEnum tempEnum;  // handling temp as enum
    private long shelfTime;  // this is when the order is currently shelved
    private int shelfDecayModifier; // this is the decay modifier
    private List<Long> unshelfTimes; // keep track if this order moved shelves

    // The order will keep a reference to the shelf it is on
    private CaiKe caiKe;

    // 1 thread to write
    // multiple threads to read
    // reentrant means same thread can acquire it
    private ReadWriteLock rwLock;
    private Lock readLock;
    private Lock writeLock;

    /**
     * Constructor
     */
    public GoiMon() {
        this.rwLock = new ReentrantReadWriteLock();
        this.readLock = rwLock.readLock();
        this.writeLock = rwLock.writeLock();
        this.unshelfTimes = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public GoiMon setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GoiMon setName(String name) {
        this.name = name;
        return this;
    }

    public String getTemp() {
        return temp;
    }

    public GoiMon setTemp(String temp) {
        this.temp = temp;
        this.tempEnum = TempEnum.valueOf(temp.toUpperCase());
        return this;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public GoiMon setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
        this.shelfLifeMillis = shelfLife * 1000;
        return this;
    }

    public float getDecayRate() {
        return decayRate;
    }

    public GoiMon setDecayRate(float decayRate) {
        this.decayRate = decayRate;
        return this;
    }

    public TempEnum getTempEnum() {
        return tempEnum;
    }

    public GoiMon setTempEnum(TempEnum tempEnum) {
        this.tempEnum = tempEnum;
        return this;
    }

    public int getShelfDecayModifier() {
        return shelfDecayModifier;
    }

    public GoiMon setShelfDecayModifier(int shelfDecayModifier) {
        this.shelfDecayModifier = shelfDecayModifier;
        return this;
    }

    public CaiKe getCaiKe() {
        return caiKe;
    }

    public GoiMon setCaiKe(CaiKe caiKe) {
        this.caiKe = caiKe;
        return this;
    }

    /**
     * Compute the value of this order
     * Order will have values based on how many shelves it was shelved on
     *
     * @param currentTimeMillis
     */
    public double computeValue(long currentTimeMillis) {
        readLock.lock();
        try {
            long orderAge = currentTimeMillis - this.shelfTime;
            double value = (shelfLifeMillis - decayRate * orderAge * shelfDecayModifier) / shelfLife;
            return value;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * Method to shelf this order onto this shelf
     *
     * @param currentTimeMillis
     * @param shelf
     */
    public void shelf(long currentTimeMillis, CaiKe shelf) {
        writeLock.lock();
        try {
            // set current shelf values
            this.caiKe = shelf;
            this.shelfTime = currentTimeMillis;
            this.shelfDecayModifier = shelf.getShelfDecayModifier();

            // update the shelf
            shelf.addGoiMon(currentTimeMillis, this);
        } finally {
            writeLock.unlock();
        }
    }

    public CaiKe unshelf(long currentTimeMillis) {
        writeLock.lock();
        try {
            CaiKe shelf = this.caiKe;

            // if not already unshelved
            if (shelf != null) {
                // update the shelf
                shelf.removeGoiMon(currentTimeMillis, this);
            }

            // if this order is already on a shelf and it is reshelving
            // TODO
            // save the previous values

            // update any attributes needed to store values
            unshelfTimes.add(currentTimeMillis);

            // unlink
            this.caiKe = null;

            return shelf;
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String toString() {
        return "GoiMon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", temp='" + temp + '\'' +
                ", tempEnum=" + tempEnum +
                ", shelfLife=" + shelfLife +
                ", decayRate=" + decayRate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoiMon)) return false;
        GoiMon goiMon = (GoiMon) o;
        return getId().equals(goiMon.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
