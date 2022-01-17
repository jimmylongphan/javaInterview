package com.javainterview.app.Caffeine;

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
    private final int size;
    private Map<K, V> dataStore;

    // store the actions for a transaction
    // used for the begin, rollback, and commit commands
    private List<Node> commitLog;

    // single counter for all actions
    private static long idCounter;

    // locking mechanism
    // allows multiple readers, 1 writer
    // If another thread is writing, readers are blocked
    // If another thread is reading, writer is blocked
    // Lock readLock = lock.readLock();
    // Lock writeLock = lock.writeLock();
    // reentrant means the same thread and recursively lock
    private ReadWriteLock lock;
    private Lock readLock;
    private Lock writeLock;

    /**
     * Constructor to intialize the key value store
     */
    public KVStore() {
        this.size = 10;
        this.dataStore = new HashMap<K, V>();
        this.commitLog = new LinkedList<Node>();
        this.lock = new ReentrantReadWriteLock();
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
    }

    /**
     * reader method
     * @param key
     * @return
     */
    public V get(K key) {
        try {
            readLock.lock();
            V val = dataStore.get(key);
            return val;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * writer method
     * @param key
     * @param value
     */
    public long set(K key, V value) {
        try {
            writeLock.lock();

            // create an entry into our logs
            V previousValue = dataStore.put(key, value);
            Node<K, V> node = new Node(idCounter++, Action.SET, key, previousValue);

            // add this to the end of our action logs
            commitLog.add(node);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        return idCounter-1;
    }

    /**
     * writer method
     * same as delete
     * @param key
     */
    public long unset(K key) {
        try {
            writeLock.lock();

            // create an entyr into our logs
            V previousValue = dataStore.remove(key);
            Node node = new Node(idCounter++, Action.UNSET, key, previousValue);

            // add this to the end of our action logs
            commitLog.add(node);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        return idCounter-1;
    }

    /**
     * Reader method
     * Reuse the get method
     *
     * @param key
     * @return
     */
    public boolean exists(K key) {
        try {
            readLock.lock();
            boolean exists = dataStore.containsKey(key);
            return exists;
        } finally {
            readLock.unlock();
        }
    }

    /**
     * We are beginning a transaction
     */
    public void begin() {
        writeLock.lock();
    }

    /**
     * we are ending the transaction
     */
    public void commit() {
        writeLock.unlock();
    }


    public void rollback(long commitId) {
        try {
            writeLock.lock();

            if(commitId > KVStore.idCounter) {
                // this is an invalid id
                return;
            }

            // undo all commits until the commitId is reached
            // start from end and go to id
            ListIterator<Node> iter = commitLog.listIterator(commitLog.size());

            // traverse backwards
            while (iter.hasPrevious()) {
                Node<K, V> node = iter.previous();
                // compare with the target commit id
                if (node.id != commitId) {
                    // perform the rollback
                    dataStore.put(node.key, node.previousValue);

                    // already performed rollback on this node
                    // remove the element called by next or previous
                    iter.remove();
                } else {
                    // rollback to this state

                    // TODO - what do we want

                    // found the target commitId
                    // perform the rollback
                    // dataStore.put(node.key, node.previousValue);

                    // cleanup this iterator
                    // already perform rollback on this node
                    // iter.remove();

                    // we are done with rollback
                    break;
                }
            }

        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        KVStore<Integer, String> kvStore = new KVStore<>();

        Scanner in = new Scanner(System.in);
        String input = in.next();
        int key;
        String data;
        long commitId;
        while(input.compareToIgnoreCase("exit") != 0) {
            System.out.println(input);

            if (input.compareToIgnoreCase("GET") == 0) {
                key = in.nextInt();
                data = kvStore.get(key);
                System.out.println(String.format("k: %d, d: %s", key, data));
            } else if (input.compareToIgnoreCase("SET") == 0) {
                key = in.nextInt();
                data = in.next();
                commitId = kvStore.set(key, data);
                System.out.println(String.format("SET k: %d, commidId: %d", key, commitId));
            } else if (input.compareToIgnoreCase("UNSET") == 0) {
                key = in.nextInt();
                commitId = kvStore.unset(key);
                System.out.println(String.format("UNSET k: %d, commidId: %d", key, commitId));
            } else if (input.compareToIgnoreCase("EXISTS") == 0) {
                key = in.nextInt();
                boolean exists = kvStore.exists(key);
                System.out.println(String.format("k: %d, exists: %s", key, exists));
            } else if (input.compareToIgnoreCase("BEGIN") == 0) {
                kvStore.begin();
            } else if (input.compareToIgnoreCase("COMMIT") == 0) {
                kvStore.commit();
            } else if (input.compareToIgnoreCase("ROLLBACK") == 0) {
                commitId = in.nextLong();
                kvStore.rollback(commitId);
            }
            input = in.next();
        }
    }

}
