package com.javainterview.app.ListInterview;

import com.javainterview.app.treeInterview.DepthFirstSearch;
import junit.framework.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 2/28/2016.
 */
public class DetectCycleTest {

    @Test
    public void testHasCycle() throws Exception {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);

        a.next = b;
        b.next = a;

        DetectCycle dc = new DetectCycle();
        boolean hasCycle = dc.hasCycle(a);
        Assert.assertTrue(hasCycle);
    }


    @Test
    public void testHasCycle2() throws Exception {
        ListNode a = new ListNode(1);
        ListNode b = a;

        a.next = b;

        DetectCycle dc = new DetectCycle();
        boolean hasCycle = dc.hasCycle(a);
        Assert.assertTrue(hasCycle);
    }
}