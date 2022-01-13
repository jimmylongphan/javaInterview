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
    private Map<K, KVStoreHistoryNode<K, V>> currentValues;

    // count the number of used values
    private Map<V, Integer> valuesCount;

    // store the actions in a Deque
    // each transaction is a separate level in the map
    // supports nested levels
    private Map<Long, Deque<KVStoreHistoryNode<K, V>>> historyPerTransaction;

    // this is the current transaction
    private Deque<KVStoreHistoryNode<K, V>> historyNodes;

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
        this.currentValues = new HashMap<K, KVStoreHistoryNode<K, V>>();
        this.valuesCount = new HashMap<V, Integer>();
        this.historyNodes = new LinkedList<>();
        this.historyPerTransaction = new HashMap<>();

        this.historyPerTransaction.put(transactionIdCounter, historyNodes);
    }

    public void printHistoryPerTransaction() {
        System.out.println(this.historyPerTransaction.toString());
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
            KVStoreHistoryNode<K, V> node = currentValues.get(key);
            // reading data
            return node.getPreviousValue();
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
            KVStoreHistoryNode<K, V> node = new KVStoreHistoryNode(transactionIdCounter, Action.SET, key, value);
            currentValues.put(key, node);
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
            KVStoreHistoryNode<K, V> oldNode = currentValues.get(key);

            if(!rollback) {
                if (oldNode == null) {
                    oldNode = new KVStoreHistoryNode(transactionIdCounter, Action.SET, key, null);
                }

                long transactionIdOfNode = oldNode.getTransactionId();
                // pair this node and its value to its proper transaction list
                this.historyPerTransaction.get(transactionIdOfNode).add(oldNode);
            } else {
                // if there is no transaction,
                // then just set the current values
            }

            V oldVal = oldNode == null ? null : oldNode.getPreviousValue();
            updateCountsAndValues(key, value, oldVal);
        } finally {
            printHistoryPerTransaction();
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
            this.historyPerTransaction.put(this.transactionIdCounter, historyNodes);
        } finally {
            printHistoryPerTransaction();
            writeLock.unlock();
        }
    }

    /**
     * Commit means you cannot rollback
     * The values stay in currentValues
     *
     * Continue with the previous transaction
     * @return
     */
    public Deque<KVStoreHistoryNode<K, V>> commit() {
        // current transactions are removed
        // cannot rollback
        // values stay
        writeLock.lock();

        try {
            Deque<KVStoreHistoryNode<K, V>> rollBackHistory;
            if(transactionIdCounter > 0) {
                rollBackHistory = historyPerTransaction.remove(this.transactionIdCounter);
                this.transactionIdCounter--;

                // continue with the previous transaction
                historyNodes = historyPerTransaction.get(this.transactionIdCounter);
            } else {
                // interate through very first history
                rollBackHistory = historyPerTransaction.get(this.transactionIdCounter);

                // restart the original state
                historyNodes = new LinkedList<>();
                historyPerTransaction.put(transactionIdCounter, historyNodes);
            }
            return rollBackHistory;
        } finally {
            printHistoryPerTransaction();
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
        writeLock.lock();
        try {
            // drop current history
            // implement the historical values from the history
            Deque<KVStoreHistoryNode<K, V>> log = commit();

            System.out.println(String.format("rollback transactionId: %d, log size: %d", transactionIdCounter, log.size()));

            // initialize the iterator to be at the end
            Iterator<KVStoreHistoryNode<K, V>> it = log.iterator();

            while(it.hasNext()) {
                KVStoreHistoryNode<K, V> n = it.next();

                K key = n.getKey();
                V previousValue = n.getPreviousValue();

                System.out.println(String.format("Inside rollback: commitId: %d, key: %s, value: %s", n.getTransactionId(), n.getKey(), n.getPreviousValue()));

                // set and unset support updating the values and the counts
                // reuse their methods
                // set rollback parameter to prevent storing history again
                set(key, previousValue, true);
            }
        } finally {
            writeLock.unlock();
        }
    }
}
