package com.javainterview.app.MayBep;

import java.util.Objects;

/**
 * Order
 */
public class GoiMon {
    // fields from json input
    private String id;
    private String name;
    private String temp;
    private int shelfLife;
    private float decayRate;

    // extra metadata
    private long shelfLifeMillis;
    private TempEnum tempEnum;  // handling temp as enum
    private long startTime;  // this is when the order was created
    private long expirationTime; // this is the expected expiration time of the order
    private double value; // this is the value of the order
    private int shelfDecayModifier; // this is the decay modifier

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

    public long getExpirationTime() {
        return expirationTime;
    }

    public GoiMon setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
        return this;
    }

    public double getValue() {
        return value;
    }

    public GoiMon setValue(double value) {
        this.value = value;
        return this;
    }

    public int getShelfDecayModifier() {
        return shelfDecayModifier;
    }

    public GoiMon setShelfDecayModifier(int shelfDecayModifier) {
        this.shelfDecayModifier = shelfDecayModifier;
        return this;
    }

    public long getStartTime() {
        return startTime;
    }

    public GoiMon setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Using the Order Value formula, we can compute the shelf life
     * and the exact time the value will be 0
     *
     * value = (shelfLife - decayRate * orderAge * shelfDecayModifier) / shelfLife
     *
     * Since value will be 0, we will solve for orderAge.
     *
     * 0 = (shelfLife - decayRate * orderAge * shelfDecayModifier) / shelfLife
     * 0 = shelfLife - decayRate * orderAge * shelfDecayModifier
     * decayRate * orderAge * shelfDecayModifier = shelfLife
     *
     * orderAge = shelfLife / (decayRate * shelfDecayModifier)
     * orderAge will be in milliseconds to be consistent
     *
     * We add orderAge to the current time stamp to get the expiration time
     */
    public void computeExpirationTime(long currentTimeMillis) {
        long orderAge = (long) (shelfLifeMillis / (decayRate * shelfDecayModifier));
        this.expirationTime = currentTimeMillis + orderAge;
    }

    public void computeValue(long currentTimeMillis) {
        long orderAge = currentTimeMillis - this.startTime;
        this.value = (shelfLifeMillis - decayRate * orderAge * shelfDecayModifier) / shelfLife;
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
