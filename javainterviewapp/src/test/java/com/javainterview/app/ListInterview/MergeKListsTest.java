package com.javainterview.app.ListInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 4/11/2016.
 */
public class MergeKListsTest {

    @Test
    public void testMergeKLists() throws Exception {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        a1.next = a2;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(5);
        b1.next = b2;

        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(6);
        c1.next = c2;

        MergeKLists mkl = new MergeKLists();
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = a1;
        listNodes[1] = b1;
        listNodes[2] = c1;

        ListNode result = mkl.mergeKLists(listNodes);

        for (int i = 1; i <= 6; i++) {
            Assert.assertEquals(result.value, i);
            result = result.next;
        }
    }
}