package com.javainterview.app.ListInterview;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 4/11/2016.
 */
public class MergeTwoListsTest {

    @Test
    public void testMergeTwoLists() throws Exception {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        a1.next = a2;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        b1.next = b2;

        MergeTwoLists mtl = new MergeTwoLists();
        ListNode result = mtl.mergeTwoLists(a1, b1);
        ListNode current = result;

        // loop through and compare with expected results
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(current.value, i);
            current = current.next;
        }
    }
}