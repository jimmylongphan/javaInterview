package com.javainterview.app.DynamicInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 11/5/2016.
 */
public class MinimumCostPathTest {

    @Test
    public void testMinCost() throws Exception {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        MinimumCostPath mcp = new MinimumCostPath();
        int minCost = mcp.minCost(cost, 2, 2);

        Assert.assertEquals(8, minCost);
    }


}