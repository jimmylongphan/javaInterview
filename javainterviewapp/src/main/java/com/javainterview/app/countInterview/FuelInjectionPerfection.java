package com.javainterview.app.countInterview;

/**
 * Google Foobar 3.3
 *
 * Created on 11/24/2019.
 *
 * Fuel Injection Perfection
 * =========================
 *
 * Commander Lambda has asked for your help to refine the automatic quantum antimatter fuel injection system for her
 * LAMBCHOP doomsday device. It's a great chance for you to get a closer look at the LAMBCHOP -
 * and maybe sneak in a bit of sabotage while you're at it - so you took the job gladly.
 *
 * Quantum antimatter fuel comes in small pellets, which is convenient since the many moving parts of the
 * LAMBCHOP each need to be fed fuel one pellet at a time. However, minions dump pellets in bulk into the fuel intake.
 * You need to figure out the most efficient way to sort and shift the pellets down to a single pellet at a time.
 *
 * The fuel control mechanisms have three operations:
 *
 * 1) Add one fuel pellet
 * 2) Remove one fuel pellet
 * 3) Divide the entire group of fuel pellets by 2 (due to the destructive energy released when a quantum antimatter
 * pellet is cut in half, the safety controls will only allow this to happen if there is an even number of pellets)
 *
 * Write a function called solution(n) which takes a positive integer as a string and returns the minimum number of
 * operations needed to transform the number of pellets to 1. The fuel intake control panel can only display a
 * number up to 309 digits long, so there won't ever be more pellets than you can express in that many digits.
 *
 * For example:
 * solution(4) returns 2: 4 -> 2 -> 1
 * solution(15) returns 5: 15 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * Languages
 * =========
 *
 * To provide a Python solution, edit solution.py
 * To provide a Java solution, edit Solution.java
 *
 * Test cases
 * ==========
 * Your code should pass the following test cases.
 * Note that it may also be run against hidden test cases not shown here.
 *
 * -- Python cases --
 * Input:
 * solution.solution('15')
 * Output:
 * 5
 *
 * Input:
 * solution.solution('4')
 * Output:
 * 2
 *
 * -- Java cases --
 * Input:
 * Solution.solution('4')
 * Output:
 * 2
 *
 * Input:
 * Solution.solution('15')
 * Output:
 * 5
 */
public class FuelInjectionPerfection {
    public static int[] costMemoization;

    public static int solution(String x) {
        int pellets = Integer.parseInt(x);
        // initialize array of cost
        int result = shiftOperations(pellets);
        return result;
    }

    /**
     * Idea:
     * Look at the value of pellets in the form of binary
     * Get the binary down to 1 as fast as possible
     * 1. add 1
     * 2. subtract 1
     * 3. shift right if it is 0
     *
     * If rightmost is 0, always shift right
     * If the value contains 111 but is not exactly 3 (111)
     *   - add 1 to shift the bits
     *   - 1111 add 1 = 10000 -> now can shift right 4 times
     * If the value is like 101 or exactly 111, subtract 1
     *   - 0101 sub 1 = 0100 -> shift right 2
     *   - 111 sub 1 = 110 -> shift right 2
     *   - 011
     *
     * @param pellets
     * @return
     */
    public static int shiftOperations(int pellets) {
        int result = 0;
        while (pellets != 1) {
            if (pellets % 2 == 0) {
                // there is a 0 in the rightmost digit
                pellets /= 2;
            } else if (pellets != 3 && (pellets & 3) == 3) {
                // there are 111 in the binary
                pellets++;
            } else {
                pellets--;
            }
            result++;
        }
        return result;
    }

    /**
     * Dynamic programming solution
     * Minimum cost to reach value of pellets
     *
     * @param pellets
     * @return
     */
    public static int minCostOperations(int pellets) {
        int cost = 0;

        if (pellets < 1) {
            // do not want to use this value
            return Integer.MAX_VALUE;
        }

        // base case
        if (pellets == 1) {
            return 1;
        }

        // pellets still greater than 1
        int add1 = minCostOperations(pellets + 1);
        int sub1 = minCostOperations(pellets - 1);
        int div2 = Integer.MAX_VALUE;

        if (pellets % 2 == 0) {
            div2 = minCostOperations(pellets / 2);
        }

        return cost;
    }

    /**
     * Brute force algorithm
     * start from 1 and multiply by 2 until over under pellets
     *
     * @param pellets
     * @return
     */
    public static int countOperations(int pellets) {
        int current = 1;
        int pre = current;
        int count = 0;

        while (current < pellets) {
            pre = current;
            current *= 2;
            count++;
        }

        // if our current matches pellets
        if (current == pellets) {
            return count;
        }

        // if current is greater then compare the distances
        int currentDistance = current - pellets;
        int preDistance = pellets - pre;

        // get the smaller difference either over or under
        int distance = Math.min(currentDistance, preDistance);

        // return the operations of distance added with the power of 2
        return distance + count;
    }
}

/**
 * Python
 * def answer(n):
 * n=int(n)
 * res = 0
 *
 * while(n!=1):
 * if(n%2==0):
 * n=n/2
 * elif((n==3) or ((n+1)&n) > ((n-1)&(n-2))):
 * n-=1
 * else:
 * n+=1
 * res+=1
 * return res
 */