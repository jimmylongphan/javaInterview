package com.javainterview.app.ListInterview;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created on 10/1/2015.
 */
public class DoublyLinkedListTest {

    @Test
    public void testInsertAfterPos() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAfterPos(new ListNode(0), 0);
        dll.insertAfterPos(new ListNode(1), 0);
        dll.insertAfterPos(new ListNode(2), 1);
        dll.printList();
    }

    @Test
    public void testGetNode() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAfterPos(new ListNode(0), 0);
        dll.insertAfterPos(new ListNode(1), 0);
        dll.insertAfterPos(new ListNode(2), 1);

        ListNode node = dll.getNode(2);
        assertEquals(node.val, new ListNode(2).val);
    }

    @Test
    public void testReverseList() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAfterPos(new ListNode(0), 0);
        dll.insertAfterPos(new ListNode(1), 0);
        dll.insertAfterPos(new ListNode(2), 1);

        dll.reverseList(dll.head);

        ListNode node = dll.getNode(2);
        assertEquals(node.val, new ListNode(0).val);

        node = dll.getNode(0);
        assertEquals(node.val, new ListNode(2).val);
    }

    @Test
    public void testReverseRecursive() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAfterPos(new ListNode(0), 0);
        dll.insertAfterPos(new ListNode(1), 0);
        dll.insertAfterPos(new ListNode(2), 1);

        dll.reverseRecursive(dll.head);

        ListNode node = dll.getNode(2);
        assertEquals(node.val, new ListNode(0).val);

        node = dll.getNode(0);
        assertEquals(node.val, new ListNode(2).val);
    }

    @Test
    public void testReverseListCopy() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAfterPos(new ListNode(0), 0);
        dll.insertAfterPos(new ListNode(1), 0);
        dll.insertAfterPos(new ListNode(2), 1);

        ListNode newHead = dll.reverseListCopy(dll.head);
        dll.head = newHead;

        ListNode node = dll.getNode(2);
        assertEquals(node.val, new ListNode(0).val);

        node = dll.getNode(0);
        assertEquals(node.val, new ListNode(2).val);
    }

    @Test
    public void testDeleteAtPos() throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAfterPos(new ListNode(0), 0);
        dll.insertAfterPos(new ListNode(1), 0);
        dll.insertAfterPos(new ListNode(2), 1);

        ListNode node = dll.deleteAtPos(2);
        assertEquals(node.val, new ListNode(2).val);

        node = dll.deleteAtPos(1);
        assertEquals(node.val, new ListNode(1).val);
    }
}