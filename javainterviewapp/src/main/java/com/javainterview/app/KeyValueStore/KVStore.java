package com.javainterview.app.KeyValueStore;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Coding Exercise: In-Memory Data Store
 * You can expect 90 minutes of collaborative work with your interviewer.
 * You'll be asked to implement a simple in memory key/value store that takes input
 * via STDIN and sends output to STDOUT. The goal of this exercise is to implement
 * GET,
 * SET,
 * UNSET and
 * EXISTS commands along with commands for transaction support using
 * BEGIN,
 * ROLLBACK and
 * COMMIT. Each command will come in via STDIN separated by new lines.
 * You may write this in any language of your choosing. You might not get all the way through,
 * but we'll be looking for how you approach the problem and the general concepts you apply.
 *
 * Please provide me with your Github account username so we can add you to our coding exercise
 * repo before the session begins. I strongly advise you to check that the IDE you plan on using
 * is ready to go before your interview sessions. We also ask that you have Zoom installed as
 * you'll be asked to share your screen with the interviewer.
 *
 * https://leetcode.com/problems/design-in-memory-file-system/
 * https://leetcode.com/problems/design-log-storage-system/
 * https://leetcode.com/discuss/interview-question/279913/Key-Value-Store-with-transaction
 * https://github.com/zackdever/vsims
 */

// Use Generics
public class KVStore<K, V> {
    // we may want to have a size limit to the memory store
    private int size;

    // this is the current and most recent values
    private Map<K, V> currentValues;

    // count the number of used values
    private Map<V, Integer> valuesCount;

    // store the actions in a Deque
    // each transaction is a separate level in the stack
    // supports nested levels
    private Stack<Deque<KVStoreHistoryNode>> historyPerTransaction;

    // this is the current transaction
    private Deque<KVStoreHistoryNode> historyNodes;

    // we can use a transactionId if we want to compare
    // single counter for all actions
    private long transactionIdCounter;

    // 1 thread to write
    // multiple threads to read
    // reentrant means same thread can acquire it
    private ReadWriteLock rwLock;
    private Lock readLock;
    private Lock writeLock;

    public KVStore() {
        this.rwLock = new ReentrantReadWriteLock();
        this.readLock = rwLock.readLock();
        this.writeLock = rwLock.writeLock();

        this.transactionIdCounter = 0;
        this.currentValues = new HashMap<K, V>();
        this.valuesCount = new HashMap<V, Integer>();
        this.historyNodes = new LinkedList<>();
        this.historyPerTransaction = new Stack<Deque<KVStoreHistoryNode>>();

        this.historyPerTransaction.push(historyNodes);
    }

    public long getTransactionIdCounter() {
        return transactionIdCounter;
    }

    public KVStore<K, V> setTransactionIdCounter(long transactionIdCounter) {
        this.transactionIdCounter = transactionIdCounter;
        return this;
    }

    /**
     * Retrieve the most recent values
     *
     * @param key
     * @return value of the key
     */
    public V get(K key) {
        readLock.lock();
        try {
            // reading data
            return currentValues.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public int count(V value) {
        readLock.lock();
        try {
            // reading data
            return valuesCount.get(value);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * Helper method to update counts and values
     *
     * @param key
     * @param value
     * @param oldValue
     */
    private void updateCountsAndValues(K key, V value, V oldValue) {
        writeLock.lock();

        try {
            // upate new counts
            valuesCount.putIfAbsent(value, 0);
            valuesCount.computeIfPresent(value, (k, v) -> v + 1);

            // update old counts
            valuesCount.putIfAbsent(oldValue, 0);
            valuesCount.computeIfPresent(oldValue, (k, v) -> v - 1);

            // set the recent value
            currentValues.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void set(K key, V value) {
        set(key, value, false);
    }

    /**
     * Check if we are in a transaction
     * then save the current state of the node
     * store it in our transactions deque
     *
     * @param key
     * @param value
     * @param rollback if true, we do not want to update history transactions
     */
    private void set(K key, V value, boolean rollback) {
        writeLock.lock();
        try {
            V oldVal = currentValues.get(key);

            if(!rollback) {
                // store the old value
                // will be null if not exists
                KVStoreHistoryNode n = new KVStoreHistoryNode(transactionIdCounter, Action.SET, key, oldVal);
                // add to the list
                historyNodes.add(n);
            } else {
                // if there is no transaction,
                // then just set the current values
            }

            updateCountsAndValues(key, value, oldVal);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Check if we are in a transaction
     * then save the current state of the node
     * store it in our transactions deque
     * set the value to null
     *
     * @param key
     */
    public void unset(K key) {
        unset(key, false);
    }

    /**
     *
     * @param key
     * @param rollback if true, we do not want to update history transactions
     */
    private void unset(K key, boolean rollback) {
        set(key, null, rollback);
    }

    /**
     * check if the key exists
     *
     * @param key
     * @return true if exists
     */
    public boolean exists(K key) {
        readLock.lock();

        try {
            return currentValues.containsKey(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * Save our current transactions onto the stack
     * Will be used for rollback later
     *
     * current transactions is always on the stack
     */
    public void begin() {
        writeLock.lock();
        try {
            // create a new transactions
            historyNodes = new LinkedList<>();
            this.transactionIdCounter++;

            // push this new one onto the stack
            this.historyPerTransaction.push(historyNodes);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Commit means you cannot rollback
     * The values stay in currentValues
     *
     * Continue with the previous transaction
     */
    public void commit() {
        // current transactions are removed
        // cannot rollback
        // values stay
        writeLock.lock();

        try {
            if(transactionIdCounter > 0) {
                historyPerTransaction.pop();
                this.transactionIdCounter--;

                // continue with the previous transaction
                historyNodes = historyPerTransaction.peek();
            } else {
                // no more history
                // keep current values
                historyNodes = new LinkedList<>();
            }
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Pop the current transactions off of the stack
     *
     * Iterate backwards in the list of actions
     * set the current values from the list
     *
     * NOTE: commit will decrement the transactionIdCounter
     */
    public void rollback() {
        // cannot rollback if at original state
        if(transactionIdCounter == 0) {
            return;
        }

        writeLock.lock();
        try {
            // go backwards on the list and execute the values
            Deque<KVStoreHistoryNode> log = historyNodes;

            // initialize the iterator to be at the end
            Iterator<KVStoreHistoryNode> it = log.descendingIterator();

            while(it.hasNext()) {
                KVStoreHistoryNode<K, V> n = it.next();

                K key = n.getKey();
                V previousValue = n.getPreviousValue();

                // set and unset support updating the values and the counts
                // reuse their methods
                // set rollback parameter to prevent storing history again
                set(key, previousValue, true);
            }

            // finalize the reversal by committing which pops the stack
            // and sets the current transaction list
            commit();
        } finally {
            writeLock.unlock();
        }
    }
}
