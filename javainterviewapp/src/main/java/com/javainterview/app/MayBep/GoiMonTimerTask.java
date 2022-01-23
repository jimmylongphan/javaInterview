package com.javainterview.app.MayBep;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;

/**
 * Created on 1/16/2022.
 */
public class GoiMonTimerTask extends TimerTask {
    private static final Logger logger = LogManager.getLogger(GoiMonTimerTask.class);
    private static final String READ = "read {} orders";
    private static final String FINISHED = "Finished reading {} orders.";

    private final Timer timer;
    private final ObjectMapper objectMapper;
    private JsonParser jsonParser;
    private int numOrders;
    private int maxOrders;
    private int totalOrders;
    private Bep bep;
    private BlockingQueue blockingQueue;

    public GoiMonTimerTask(Timer timer, ObjectMapper objectMapper, JsonParser jsonParser, int numOrders, int maxOrders, Bep bep, BlockingQueue blockingQueue) {
        this.timer = timer;
        this.objectMapper = objectMapper;
        this.jsonParser = jsonParser;
        this.numOrders = numOrders;
        this.maxOrders = maxOrders;
        this.totalOrders = 0;
        this.bep = bep;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int currentNumOrders = 0;
            // read orders while both
            // not end of file
            // number of desired orders
            while (jsonParser.nextToken() != JsonToken.END_ARRAY
                    && currentNumOrders < numOrders && totalOrders < maxOrders) {
                // Read a contact instance using ObjectMapper and do something with it
                GoiMon goiMon = objectMapper.readValue(jsonParser, GoiMon.class);

                // add it to the kitchen
                // the kitchen will determine the shelf
                bep.addGoiMon(currentTimeMillis, goiMon);

                // add it to the queue for the couriers
                blockingQueue.add(goiMon);

                currentNumOrders++;
                totalOrders++;
            }
            logger.info(READ, currentNumOrders);

            if (totalOrders >= maxOrders) {
                cancel();
                timer.cancel(); // cancel the parent timer
                logger.info(FINISHED, totalOrders);
            }
        } catch (Exception e) {
            cancel();
            logger.warn(e.getMessage());
            e.printStackTrace();
        }
    }

}
