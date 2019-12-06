package com.javainterview.app.MatrixInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on 11/23/2019.
 * Prepare the Bunnies' Escape
 * ===========================
 *
 * You're awfully close to destroying the LAMBCHOP doomsday device and freeing Commander
 * Lambda's bunny prisoners, but once they're free of the prison blocks,
 * the bunnies are going to need to escape Lambda's space station via the escape pods as quickly as possible.
 * Unfortunately, the halls of the space station are a maze of corridors and dead ends that will be a
 * deathtrap for the escaping bunnies. Fortunately, Commander Lambda has put you in charge of a remodeling
 * project that will give you the opportunity to make things a little easier for the bunnies.
 * Unfortunately (again), you can't just remove all obstacles between the bunnies and the escape pods
 * - at most you can remove one wall per escape pod path, both to maintain structural integrity of the
 * station and to avoid arousing Commander Lambda's suspicions.
 *
 * You have maps of parts of the space station, each starting at a prison exit and
 * ending at the door to an escape pod. The map is represented as a matrix of 0s and 1s,
 * where 0s are passable space and 1s are impassable walls.
 * The door out of the prison is at the top left (0,0)
 * and the door into an escape pod is at the bottom right (w-1,h-1).
 *
 * Write a function solution(map) that generates the length of the shortest path from the prison door to the escape pod,
 * where you are allowed to remove one wall as part of your remodeling plans.
 * The path length is the total number of nodes you pass through, counting both the entrance and exit nodes.
 * The starting and ending positions are always passable (0). The map will always be solvable,
 * though you may or may not need to remove a wall. The height and width of the map can be from 2 to 20.
 * Moves can only be made in cardinal directions; no diagonal moves are allowed.
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
 * solution.solution([[0, 1, 1, 0], [0, 0, 0, 1], [1, 1, 0, 0], [1, 1, 1, 0]])
 * Output:
 * 7
 *
 * Input:
 * solution.solution([[0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 1], [0, 1, 1, 1, 1, 1], [0, 0, 0, 0, 0, 0]])
 * Output:
 * 11
 *
 * -- Java cases --
 * Input:
 * Solution.solution({{0, 1, 1, 0}, {0, 0, 0, 1}, {1, 1, 0, 0}, {1, 1, 1, 0}})
 * Output:
 * 7
 *
 * Input:
 * Solution.solution({{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}})
 * Output:
 * 11
 */
public class BunnyEscape {

    public static int[][] dims = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static int solution(int[][] map) {
        // initial call without modifications
        int length = bfs(map);

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[0].length; c++) {
                // remove just this position and call solution
                if (map[r][c] == 1) {
                    map[r][c] = 0;
                    int currentLength = bfs(map);
                    length = Math.min(length, currentLength);

                    // restore the modification
                    map[r][c] = 1;
                }
            }
        }

        return length;
    }

    /**
     * Marking 2 is visited
     *
     * @param map
     * @return
     */
    public static int bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        // add the start entrance door
        q.add(new int[]{0, 0});

        boolean found = false;
        int width = map[0].length;
        int height = map.length;
        boolean[][] visited = new boolean[height][width];
        int[][] distance = new int[height][width];

        while (!q.isEmpty()) {
            int[] current = q.poll();  // get current location

            // check if we are at the end
            if (current[0] == height - 1 && current[1] == width - 1) {
                return distance[current[0]][current[1]] + 1;
            }

            // iterate through the 4 possible directions
            for (int[] dim : dims) {
                int r = current[0] + dim[0];  // new row
                int c = current[1] + dim[1];  // new col

                // boundary check
                if (r >= 0 && r < height && c >= 0 && c < width) {
                    if (visited[r][c] == true) {
                        continue;
                    }
                    // check if new point is 0
                    if (map[r][c] == 0) {
                        q.add(new int[]{r, c});
                        visited[r][c] = true;
                        // update the distance for the new node
                        distance[r][c] = distance[current[0]][current[1]] + 1;
                    }
                }
            }
        }

        // not found return max value
        return Integer.MAX_VALUE;
    }

}
