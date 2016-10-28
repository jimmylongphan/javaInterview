package com.javainterview.app.inputs;

import java.util.Scanner;

/**
 * Created on 10/15/2016.
 */
public class Inputs {
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
