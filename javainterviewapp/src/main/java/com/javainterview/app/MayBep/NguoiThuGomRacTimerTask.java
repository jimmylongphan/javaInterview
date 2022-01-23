package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;
import java.util.TimerTask;

/**
 * Created on 1/22/2022.
 */
public class NguoiThuGomRacTimerTask extends TimerTask {
    private static final Logger logger = LogManager.getLogger(NguoiThuGomRacTimerTask.class);

    private static final String SWEEPING = "Sweeping all orders for low values";
    private static final String FOUND = "Found {} low value orders";

    private Bep bep;

    public NguoiThuGomRacTimerTask(Bep bep) {
        this.bep = bep;
    }

    @Override
    public void run() {
        logger.info(SWEEPING);
        long time = System.currentTimeMillis();
        List<GoiMon> list = bep.getExpiredGoiMons(time);
        logger.info(FOUND, list.size());
        if(!list.isEmpty()) {
            bep.removeExpiredGoiMons(time, list);
        }
    }
}
