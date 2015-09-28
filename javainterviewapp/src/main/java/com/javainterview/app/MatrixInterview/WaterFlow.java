package com.javainterview.app.MatrixInterview;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created on 9/27/2015.
 *
 * Find if there is a mountain where when it rains, water can flow into both
 * Pacific and Atlantic ocean.
 * Water flows from higher to equal or lower elevation.
 * The mountain will comprise of points that are accessible from both oceans.
 *
 * Pacific Ocean: left and top side of matrix
 * Atlantic Ocean: right and bottom side of matrix
 *
 * Given a n*n matrix, number in each node means elevation.
 *
 * How can we get all nodes that water can flow to both oceans?
 * The idea is to start from known points such as the pacific and atlantic sides.
 * Then for each point, search for a path upwards to higher elevation.
 *
 * The points that can accessed by both oceans will be this mountain.
 */
public class WaterFlow {

    /**
     * This method searches for a new point.
     * Since we originate from the ocean, we need to go to higher or equal elevation.
     * Has boundary search.
     * Recursive calls if a new higher elevation point is found.
     *
     * @param pt      origin point
     * @param visited map keeping track of all visited points
     * @param matrix  original matrix
     */
    private void search(Point pt, HashMap<Point, Boolean> visited, int[][] matrix) {
        // create a two dimensional array
        // representing the 4 possible directions from a point
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // loop through all directions
        for (int[] direction : directions) {
            // Using the current point and a direction
            // Create a point destination
            Point destination = new Point(pt.x + direction[0], pt.y + direction[1]);

            // boundary check
            if (destination.x < 0 || destination.x >= matrix.length ||
                    destination.y < 0 || destination.y >= matrix.length) {
                continue;
            }

            // if new destination has a lower elevation
            // or if we already visited the new point
            // then it is not a path from the mountain
            if (matrix[destination.x][destination.y] < matrix[pt.x][pt.y] ||
                    visited.containsKey(destination)) {
                // then skip the destination
                continue;
            }

            // mark this destination as visited
            visited.put(destination, true);

            // continue the flow search with the new point
            // new point has a higher elevation
            search(destination, visited, matrix);
        }
    }

    /**
     * In a two dimensional array, top left corner is {0,0}.
     * Initialize all points along the left and top side as visited for pacific ocean.
     * Then search for paths
     *
     * Runtime: O(n^2)
     * For every node in either ocean, we recursively search for a path
     * Space:  O(n)
     * Keeping maps of visited nodes
     *
     * @param matrix original matrix
     * @return list of all points that are accessible from both oceans
     */
    public List<Point> findMountain(int[][] matrix) {
        int length = matrix.length;

        // initialize all points for pacific side
        HashMap<Point, Boolean> visitedPacific = new HashMap<Point, Boolean>();
        // search every path from the vertical line along left side of matrix
        for (int i = 0; i < length; ++i) {
            Point p = new Point(0, i);
            visitedPacific.put(p, true);
            search(p, visitedPacific, matrix);
        }
        // search every path from the horizontal line along top side of matrix
        for (int i = 0; i < length; ++i) {
            Point p = new Point(i, 0);
            visitedPacific.put(p, true);
            search(p, visitedPacific, matrix);
        }

        // initialize all visited points for atlantic side
        HashMap<Point, Boolean> visitedAtlantic = new HashMap<Point, Boolean>();
        // search every path from the vertical line along right side of matrix
        for (int i = 0; i < length; ++i) {
            Point p = new Point(length - 1, i);
            visitedAtlantic.put(p, true);
            search(p, visitedAtlantic, matrix);
        }
        // search every path from the horizontal line along bottom side of matrix
        for (int i = 0; i < length; ++i) {
            Point p = new Point(i, length - 1);
            visitedAtlantic.put(p, true);
            search(p, visitedAtlantic, matrix);
        }

        // go through the visited atlantic points
        // if there is a visited point from atlantic ocean
        // that can also be accessed by the pacific ocean
        // then there is a path between the two oceans
        ArrayList<Point> result = new ArrayList<Point>();
        for (Point key : visitedAtlantic.keySet()) {
            if (visitedPacific.containsKey(key)) {
                result.add(key);
            }
        }

        return result;
    }
}
