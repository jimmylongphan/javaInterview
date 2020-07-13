package com.javainterview.app.inputs;

import java.io.*;
import java.util.Scanner;

/**
 * Created on 10/15/2016.
 */
public class Inputs {
    public static void readFile(String fileName) throws IOException {
        File f = new File(fileName);
        FileReader fileReader;
        FileWriter fileWriter;

        fileReader = new FileReader(f);
        fileWriter = new FileWriter(f);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // read from file
        String line;
        while( (line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // write to file
        bufferedWriter.write("foo");
        bufferedWriter.close();
    }

    public static class Inner{
        int i;
    }

    public static void readIntegers(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int value = scan.nextInt();
            System.out.println(value);
        }
        scan.close();
    }

    public static void readString(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(s);
    }

    public static void main(String args[]) {
        Inputs inputs = new Inputs();
        Inner inner = new Inner();
    }
}
