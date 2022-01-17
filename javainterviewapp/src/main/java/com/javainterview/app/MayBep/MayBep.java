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
        int maxOrders = 3;
        int periodMilliSeconds = 1000;
        int hotShelfCapacity = 0;
        int coldShelfCapacity = 0;
        int frozenShelfCapacity = 0;
        int overflowShelfCapacity = 0;

        try {
            BlockingQueue queue = new LinkedBlockingDeque();

            Bep bep = new Bep(hotShelfCapacity, coldShelfCapacity, frozenShelfCapacity, overflowShelfCapacity);

            GoiMonTimer goiMonTimer = new GoiMonTimer(ordersFileName, ordersPerSecond, periodMilliSeconds, maxOrders, bep, queue);
            goiMonTimer.readStream();

            NguoiChayGiayTimer nguoiChayGiayTimer = new NguoiChayGiayTimer(bep, queue);
            nguoiChayGiayTimer.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
