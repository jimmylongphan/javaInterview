package com.javainterview.app.KeyValueStore;

/**
 * Store the individual actions as a historical node
 *
 * @param <K> generic key type
 * @param <V> generic value type
 */
public class KVStoreHistoryNode<K, V> {
    long transactionId;  // this is the transactionId
    Action command;  // command of this action
    K key; // key of object
    V previousValue; // value of this current node

    /**
     *
     * @param transactionId commitId
     * @param command The type of command we are executing
     * @param key the key of the node
     * @param previousValue the previous value for history and rollback
     */
    public KVStoreHistoryNode(long transactionId, Action command, K key, V previousValue) {
        this.transactionId = transactionId;
        this.command = command;
        this.key = key;
        this.previousValue = previousValue;
    }

    public K getKey() {
        return this.key;
    }

    public KVStoreHistoryNode<K, V> setKey(K key) {
        this.key = key;
        return this;
    }

    public V getPreviousValue() {
        return this.previousValue;
    }

    public KVStoreHistoryNode<K, V> setPreviousValue(V previousValue) {
        this.previousValue = previousValue;
        return this;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public KVStoreHistoryNode<K, V> setTransactionId(long transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Action getCommand() {
        return command;
    }

    public KVStoreHistoryNode<K, V> setCommand(Action command) {
        this.command = command;
        return this;
    }
}