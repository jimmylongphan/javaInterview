package com.javainterview.app.Caffeine;

public class Node<K, V> {
    long id;
    Action command;
    K key;
    V previousValue;

    /**
     *
     * @param id commitId
     * @param command The type of command we are executing
     * @param key the key of the node
     * @param previousValue the previous value for history and rollback
     */
    public Node(long id, Action command, K key, V previousValue) {
        this.id = id;
        this.command = command;
        this.key = key;
        this.previousValue = previousValue;
    }
}