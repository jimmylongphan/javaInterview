package com.javainterview.app.KeyValueStore;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static Action convertAction(String command) {
        try {
            Action action = Action.valueOf(command.toUpperCase());
            return action;
        } catch (IllegalArgumentException e) {

        }
        return null;
    }

    public static void shell() {
        KVStore<String, String> kvStore = new KVStore<>();

        Scanner in = new Scanner(System.in);
        String input = "";
        String key;
        String data;
        long commitId;
        while(input.compareToIgnoreCase("exit") != 0) {
            System.out.print("> ");
            input = in.next();

            if (input.compareToIgnoreCase("GET") == 0) {
                key = in.next();
                data = kvStore.get(key);
                commitId = kvStore.getTransactionIdCounter();
                System.out.println(String.format("key: %s, data: %s, commidId: %d", key, data, commitId));
            } else if (input.compareToIgnoreCase("SET") == 0) {
                key = in.next();
                data = in.next();
                kvStore.set(key, data);
                commitId = kvStore.getTransactionIdCounter();
                System.out.println(String.format("SET key: %s, commidId: %s", key, commitId));
            } else if (input.compareToIgnoreCase("UNSET") == 0) {
                key = in.next();
                kvStore.unset(key);
                commitId = kvStore.getTransactionIdCounter();
                System.out.println(String.format("UNSET key: %s, commidId: %d", key, commitId));
            } else if (input.compareToIgnoreCase("EXISTS") == 0) {
                key = in.next();
                boolean exists = kvStore.exists(key);
                System.out.println(String.format("k: %s, exists: %s", key, exists));
            } else if (input.compareToIgnoreCase("BEGIN") == 0) {
                kvStore.begin();
            } else if (input.compareToIgnoreCase("COMMIT") == 0) {
                kvStore.commit();
            } else if (input.compareToIgnoreCase("ROLLBACK") == 0) {
                long oldId = kvStore.getTransactionIdCounter();
                kvStore.rollback();
                commitId = kvStore.getTransactionIdCounter();
                System.out.println(String.format("ROLLBACK oldId: %d, commidId: %d", oldId, commitId));
            } else if (input.compareToIgnoreCase("COUNT") == 0) {
                data = in.next();
                int count = kvStore.count(data);
                commitId = kvStore.getTransactionIdCounter();
                System.out.println(String.format("COUNT data: %s, count: %d, commidId: %d", data, count, commitId));
            }
        }
    }

    public static void readFile() throws Exception {
        KVStore<String, Integer> kvStore = new KVStore<String, Integer>();

        // read in the file
        File f = new File("resources/inputs/TRANSACTIONS_3.txt");
        FileReader fileReader = new FileReader(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // read line by line
        String line;
        while ( (line = bufferedReader.readLine()) != null) {
            // System.out.println(String.format("processing %s", line));

            String[] tokens = line.split(" ");
            String command = tokens[0];
            String key;
            Integer value;

            if(command.compareToIgnoreCase("GET") == 0) {
                key = tokens[1];
                if(kvStore.exists(key)) {
                    value = kvStore.get(key);
                } else {
                    value = null;
                }
                System.out.println(value);
            } else if(command.compareToIgnoreCase("SET") == 0) {
                key = tokens[1];
                value = Integer.parseInt(tokens[2]);
                kvStore.set(key, value);
            } else if(command.compareToIgnoreCase("UNSET") == 0) {
                key = tokens[1];
                kvStore.unset(key);
            } else if(command.compareToIgnoreCase("EXISTS") == 0) {
                key = tokens[1];
                boolean exists = kvStore.exists(key);
                System.out.println(exists);
            } else if(command.compareToIgnoreCase("BEGIN") == 0) {
                kvStore.begin();
            } else if(command.compareToIgnoreCase("ROLLBACK") == 0) {
                kvStore.rollback();
            } else if(command.compareToIgnoreCase("COMMIT") == 0) {
                // map already has latest data
                kvStore.commit();
            } else {
                throw new Exception("Unsupported command");
            }
        }
        // depending on command, read 1 or 2 arguments

        // execute the database methods
    }

    public static void main(String[] args) throws Exception {
        shell();
    }
}
