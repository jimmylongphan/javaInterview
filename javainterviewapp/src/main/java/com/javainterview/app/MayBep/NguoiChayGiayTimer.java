package com.javainterview.app.MayBep;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;

/**
 * Courier Timer
 * This thread will handle the tasks
 * It is a consumer on a blocking queue.
 * Whenever there is a new order, generate a random delay and schedule a task
 */
public class NguoiChayGiayTimer implements Runnable {
    private static final Logger logger = LogManager.getLogger(NguoiChayGiayTimer.class);

    private static final String DELIVER = "order id: {} will be delivered in {} milliseconds";
    private static final int TWO = 2;

    private Timer timer;
    private Bep bep;
    private BlockingQueue<GoiMon> blockingQueue;
    private Random random;

    public NguoiChayGiayTimer(Bep bep, BlockingQueue blockingQueue) {
        this.timer = new Timer("NguoiChayGiayTimer");
        this.bep = bep;
        this.blockingQueue = blockingQueue;
        this.random = new Random();
    }

    /**
     * Get values between 2-6
     * generate random 0-4, then add 2
     * @param goiMon
     * @return the random delay in milliseconds
     */
    public long calculateDelay(GoiMon goiMon) {
        int seconds = TWO + random.nextInt(5);
        long milliseconds = seconds * 1000;
        return milliseconds;
    }

    @Override
    public void run() {
        while (true) {
            try {
                GoiMon goiMon = blockingQueue.take();
                long delay = calculateDelay(goiMon);

                logger.info(DELIVER, goiMon.getId(), delay);
                NguoiChayGiayTimerTask timerTask = new NguoiChayGiayTimerTask(bep, goiMon);
                timer.schedule(timerTask, delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
