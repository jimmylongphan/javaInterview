package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created on 1/16/2022.
 */
public class MayBep {
    private static final Logger logger = LogManager.getLogger(MayBep.class);

    public static void main(String[] args) {

        String ordersFileName = "C:\\Users\\SupraSaiyaJim\\IdeaProjects\\javaInterview\\javainterviewapp\\src\\main\\java\\com\\javainterview\\app\\MayBep\\orders.json";
        int ordersPerSecond = 2;
        int maxOrders = 1000;
        int periodMilliseconds = 1000;
        int hotShelfCapacity = 10;
        int coldShelfCapacity = 10;
        int frozenShelfCapacity = 10;
        int overflowShelfCapacity = 15;
        int sweepPeriodMilliseconds = 1000;

        try {
            BlockingQueue queue = new LinkedBlockingDeque();

            // create the shelves
            Bep bep = new Bep(hotShelfCapacity, coldShelfCapacity, frozenShelfCapacity, overflowShelfCapacity);

            // setup the sweeper
            NguoiThuGomRacTimer nguoiThuGomRacTimer = new NguoiThuGomRacTimer(bep, sweepPeriodMilliseconds);
            // nguoiThuGomRacTimer.sweep();

            // setup order readers
            GoiMonTimer goiMonTimer = new GoiMonTimer(ordersFileName, ordersPerSecond, periodMilliseconds, maxOrders, bep, queue);
            goiMonTimer.readStream();

            // setup couriers
            NguoiChayGiayTimer nguoiChayGiayTimer = new NguoiChayGiayTimer(bep, queue);
            nguoiChayGiayTimer.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
