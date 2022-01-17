package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * A class representing a shelf
 *
 * Has 3 attributes related to the order
 * Shelf
 */
public class CaiKe {
    private static final Logger logger = LogManager.getLogger(CaiKe.class);

    private static final String ADD_ORDER = "%s shelf added order id: %s";
    private static final String REMOVE_ORDER = "%s shelf removed order id: %s, delay: %d";
    private static final String DOES_NOT_HAVE_ORDER = "%s shelf does not contain order id: %s";

    private int shelfDecayModifier;
    private TempEnum tempEnum;
    private int maxCapacity;
    private Set<GoiMon> goiMons;

    public CaiKe(TempEnum tempEnum, int maxCapacity, int shelfDecayModifier) {
        this.shelfDecayModifier = shelfDecayModifier;
        this.tempEnum = tempEnum;
        this.maxCapacity = maxCapacity;

        this.goiMons = new HashSet<>();
    }

    public TempEnum getTempEnum() {
        return tempEnum;
    }

    public CaiKe setTempEnum(TempEnum tempEnum) {
        this.tempEnum = tempEnum;
        return this;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public CaiKe setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public Set<GoiMon> getGoiMons() {
        return goiMons;
    }

    public CaiKe setGoiMons(Set<GoiMon> goiMons) {
        this.goiMons = goiMons;
        return this;
    }

    public boolean addGoiMon(long currentTimeMillis, GoiMon goiMon) {
        if (isFull()) {
            return false;
        }

        logger.info(String.format(ADD_ORDER, this.tempEnum.toString(), goiMon.getId()));
        this.goiMons.add(goiMon);
        // since this order is now on this shelf
        // update its shelfDecayModifier
        goiMon.setShelfDecayModifier(this.shelfDecayModifier);

        goiMon.computeExpirationTime(currentTimeMillis);
        return true;
    }

    public boolean removeGoiMon(long currentTimeMillis, GoiMon goiMon) {
        if (!contains(goiMon)) {
            logger.info(String.format(DOES_NOT_HAVE_ORDER, this.tempEnum.toString(), goiMon.getId()));
            return false;
        }

        long delay = currentTimeMillis - goiMon.getStartTime();
        logger.info(String.format(REMOVE_ORDER, this.tempEnum.toString(), goiMon.getId(), delay));
        this.goiMons.remove(goiMon);

        return true;
    }

    public boolean isFull() {
        return this.maxCapacity == this.goiMons.size();
    }

    public int size() {
        return this.goiMons.size();
    }

    public boolean contains(GoiMon goiMon) {
        return this.goiMons.contains(goiMon);
    }
}
