package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

/**
 * Courier
 * Individual task to pick up and deliver the order
 * Scheduled to execute after a delay
 */
public class NguoiChayGiayTimerTask extends TimerTask {
    private static final Logger logger = LogManager.getLogger(NguoiChayGiayTimerTask.class);
    private static final String DELIVERED = "Order {} delivered at {}";

    private Bep bep;
    private GoiMon goiMon;

    NguoiChayGiayTimerTask(Bep bep, GoiMon goiMon) {
        this.bep = bep;
        this.goiMon = goiMon;
    }

    /**
     * After the delay, deliver the order
     */
    @Override
    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        logger.info(DELIVERED, goiMon.getId(), currentTimeMillis);
        bep.removeGoiMon(currentTimeMillis, goiMon);
    }
}
