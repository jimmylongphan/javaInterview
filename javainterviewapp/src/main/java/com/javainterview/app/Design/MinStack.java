package com.javainterview.app.Design;


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
/**
 * LeetCode 155 Min Stack
 * 
 * Company: Google, Uber, Zenefits, Amazon, Snapchat, Bloomberg
 * 
 * Tags: Stack, Design
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * Trick: Anytime we pop the stack, there should be a new
 * minimum. How do we get this new minimum without
 * traversing the stack?
 * 
 * We store just the differences between the min and the numbers in the stack.
 * If the difference is positive, then our min stays the stame.
 * If the difference is negative, then the new number is the mininum.
 * And we set the minimum.
 * 
 * Similar reasoning for pop and top.
 * Get the top value from the stack.
 * If the value is positive, then the current min is valid.
 * If the value is negative, then the current min needs to be updated.
 * We will subtract the difference from the current min to get the previous min.
 *
 */
public class MinStack {
    long min;
    Stack<Long> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();    
    }
    
    /**
     * if there are no elements, just store the min
     * 
     * If there are existing elements, just store
     * the difference.
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            // don't need anything in the stack
            stack.push(0L);
            // only store the min
            min = x;
        } else {
            // store the difference between min and x
            stack.push(x - min);
            // if the new number is smaller
            if (x < min) {
                // set the new min
                min = x;
            }
        }
    }
    
    /**
     * 
     * 
     */
    public void pop() {
        // nothing to pop
        if (stack.isEmpty()) {
            return;
        }
        
        // take the top off of the stack
        long pop = stack.pop();
        
        // if pop is negative
        // then we know that the pop was
        // smaller than the previous min
        if (pop < 0) {
            // pop is no longer in the stack
            // we must update our min to reflect this
            // we end up using a higher min
            // or a min before this pop
            min = min - pop;
        }
    }
    
    /**
     * Get the top of the stack
     * 
     */
    public int top() {
        // take the top difference
        long top = stack.peek();
        // if top is greater
        if (top > 0) {
            // return the original value
            // because top is the difference
            return (int)(top + min);
        } else {
            // if top is negative
            // then that means this top represents
            // the current min
            return (int) min;
        }
    }
    
    /**
     * @return returns the current minimum in the stack
     */
    public int getMin() {
        // type cast to int
        return (int) min;
    }
}