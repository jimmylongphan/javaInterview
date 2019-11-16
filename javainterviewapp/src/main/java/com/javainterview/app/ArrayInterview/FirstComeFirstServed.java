package com.javainterview.app.ArrayInterview;

import java.util.List;

/**
 * Created on 11/16/2019.
 */
public class FirstComeFirstServed {
    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        int takeoutIndex = 0;
        int dineinIndex = 0;
        int servedIndex = 0;

        while (servedIndex < servedOrders.length) {
            if (takeoutIndex < takeOutOrders.length && servedOrders[servedIndex] == takeOutOrders[takeoutIndex]) {
                servedIndex++;
                takeoutIndex++;
            } else if (dineinIndex < dineInOrders.length && servedOrders[servedIndex] == dineInOrders[dineinIndex]) {
                servedIndex++;
                dineinIndex++;
            } else {
                return false;
            }
        }

        return true;
    }


    public static boolean checkFifo(List<Integer> take_out_orders, List<Integer> dine_in_orders, List<Integer> served_orders) {
        // order in either takeout or dine in must be maintained in the served_orders

        int takeoutIndex = 0;
        int dineinIndex = 0;
        int servedIndex = 0;
        while (servedIndex < served_orders.size()) {
            if (takeoutIndex < take_out_orders.size() && served_orders.get(servedIndex) == take_out_orders.get(takeoutIndex)) {
                servedIndex++;
                takeoutIndex++;
            } else if (dineinIndex < dine_in_orders.size() && served_orders.get(servedIndex) == dine_in_orders.get(dineinIndex)) {
                servedIndex++;
                dineinIndex++;
            } else {
                return false;
            }
        }

        return true;
    }

}
