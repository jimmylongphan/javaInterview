package com.javainterview.app.MatrixInterview;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a m x n 2D grid with initialized values
 * -1: obstacle
 * 0:  gate
 * INF - empty room.  Integer.MAX
 *
 * For every empty room, fill it with the distance to the nearest gate
 *
 * Solution:
 * Store all target gates into a queue.
 *
 * Use BFS on all gates.
 *
 * For every child node visited, it is 1 distance away from the previous
 * node. Then add this child into the queue.
 *
 * It is O(m x N) because it is potentially visiting all nodes
 *
 *
 * Breadth first search goes level by level.
 * This ensures that each adjacent node that is closest will be handled
 * first.
 *
 * If we used Depth first search, then we will fill in all the nodes
 * starting at one gate.  This will cause the values to overwrite each other.
 * Still usable if we check if the adjacent node has a larger value.
 */
public class WallsAndGates {

    // keep a list to track all neighboring nodes
    // 2 dimensional array
    // each entry contains the row and col change
    int dimensions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        // check valid size
        if (rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        // create entries for all gates
        Queue<int[]> nodeList = new LinkedList<int[]>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    nodeList.add(new int[]{i, j});
                }
            }
        }

        // loop through gates and their child nodes
        while (!nodeList.isEmpty()) {
            int[] node = nodeList.remove();

            // retrieve neighboring indices
            for (int dimension[] : dimensions) {
                int row = node[0] + dimension[0];
                int col = node[1] + dimension[1];

                // boundary check
                if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) {
                    continue;
                }

                // if it is not an empty room, then skip
                if (rooms[row][col] != Integer.MAX_VALUE) {
                    continue;
                }

                // The target node is one step away from the previous entry's
                // distance to a gate.
                // If the current node is a gate, then it is 0 + 1
                // If the current node is 1 away from a gate, then it is 1 + 1
                rooms[row][col] = rooms[node[0]][node[1]] + 1;

                // add this new node into the list
                nodeList.add(new int[]{row, col});
            }
        }
    }
}