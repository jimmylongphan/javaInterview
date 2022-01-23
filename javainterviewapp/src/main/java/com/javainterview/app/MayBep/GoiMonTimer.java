package com.javainterview.app.MayBep;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;


/**
 */
public class GoiMonTimer {
    private static final Logger logger = LogManager.getLogger(GoiMonTimer.class);
    private static final String READING = "Reading file {}";

    private final InputStream inputStream;
    private final ObjectMapper objectMapper;
    private JsonParser jsonParser;

    private int ordersPerSecond;
    private Timer timer;
    private long periodMilliseconds;
    private int maxOrders;
    private int orderCount;
    private Bep bep;
    private BlockingQueue blockingQueue;

    public GoiMonTimer(String fileName, int ordersPerSecond, int periodMilliseconds, int maxOrders, Bep bep, BlockingQueue queue) throws IOException {
        logger.info(READING, fileName);
        this.inputStream = new FileInputStream(fileName);
        this.objectMapper = new ObjectMapper();
        this.jsonParser = objectMapper.getFactory().createParser(inputStream);

        this.timer = new Timer("GoiMonTimer");
        this.ordersPerSecond = ordersPerSecond;
        this.periodMilliseconds = periodMilliseconds;
        this.maxOrders = maxOrders;
        this.bep = bep;
        this.blockingQueue = queue;
    }

    public void readStream() {
        try {
            // Check the first token
            if (jsonParser.nextToken() != JsonToken.START_ARRAY) {
                throw new IllegalStateException("Expected content to be an array");
            }

            // Iterate over the tokens until the end of the array
            // this is done over the timer
            TimerTask timerTask = new GoiMonTimerTask(timer, objectMapper, jsonParser, ordersPerSecond, maxOrders, bep, blockingQueue);
            timer.scheduleAtFixedRate(timerTask, 0, periodMilliseconds);
        } catch (IOException e) {
            timer.cancel();
            timer.purge();
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
