package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Timer;

/**
 * Waste checker
 * Creates a timer that will trigger every sweep period
 *
 */
public class NguoiThuGomRacTimer {
    private static final Logger logger = LogManager.getLogger(NguoiThuGomRacTimer.class);

    private Timer timer;
    private long sweepPeriod;
    private Bep bep;

    public NguoiThuGomRacTimer(Bep bep, long sweepPeriod) {
        this.timer = new Timer("NguoiThuGomRac");
        this.bep = bep;
        this.sweepPeriod = sweepPeriod;
    }

    public void sweep() {
        NguoiThuGomRacTimerTask timerTask = new NguoiThuGomRacTimerTask(bep);
        timer.scheduleAtFixedRate(timerTask, 0, sweepPeriod);
    }
}
