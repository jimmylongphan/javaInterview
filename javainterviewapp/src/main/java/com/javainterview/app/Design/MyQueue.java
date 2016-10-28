package com.javainterview.app.Design;

import java.util.Stack;

/**
 * LeetCode 232 Implement Queue using Stacks
 *
 * Company: Microsoft, Bloomberg
 * Tags: Stack, Design
 *
 *
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 *
 * Notes:
 * You must use only standard operations of a stack --
 * which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively.
 * You may simulate a stack by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a stack.
 * You may assume that all operations are valid
 * (for example, no pop or peek operations will be called on an empty queue).
 *
 * Created on 10/15/2016.
 *
 * Idea:
 * We maintain two stacks.
 * The first stack or the input stack will store values.
 * Then we will empty the stack onto the second stack or output stack.
 *
 * This will maintain the FIFO order of the input.
 *
 */
public class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
        // put contents of the input stack onto the output stack if needed
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.add(input.pop());
            }
        }
        // return the contents of output
        return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
