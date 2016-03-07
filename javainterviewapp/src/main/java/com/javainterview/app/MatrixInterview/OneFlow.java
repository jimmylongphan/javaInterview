package com.javainterview.app.MatrixInterview;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Created on 9/27/2015.
 * Facebook
 *
 * Given an n*n matrix of ones and zeroes. Find if there is a path of ones from
 * the left side to the right side.
 *
 * You can only move if the next point has same value.
 * If starting point is a 1, then next point is a 1.
 *
 * Bonus if you can return the path as well.
 */
public class OneFlow {

    /**
     * Given an incoming point, search through all the directions.
     * If the destination point is at the edge, then we are done and return the result.
     * If we are not done, then continue the recursive call.
     * If results come back, then we know this path is used and so both the incoming and destination
     * points are needed.
     *
     * Return both those points.
     *
     * If nothing is returned from the recursive calls, then we know that there is no path there.
     *
     * @param pt      incoming point
     * @param visited list of all visited points
     * @param matrix  origin matrix
     * @return points that can be used to find a path
     */
    private List<Point> searchPath(Point pt, Map<Point, Boolean> visited, int[][] matrix) {
        // create a two dimensional array
        // representing all the possible movements
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // keep track of the path
        List<Point> result = new ArrayList<Point>();

        // loop through all directions
        for (int[] direction : directions) {
            // use the direction to get a new point
            Point destination = new Point(pt.x + direction[0], pt.y + direction[1]);

            // boundary check
            if (destination.x < 0 || destination.x >= matrix.length ||
                    destination.y < 0 || destination.y >= matrix.length) {
                continue;
            }

            // check if the new destination does not have the same value
            // or if it has already been visited
            if (matrix[destination.x][destination.y] != matrix[pt.x][pt.y] ||
                    visited.containsKey(destination)) {
                continue;
            }

            // mark this destination as visited
            visited.put(destination, true);

            // we reached the end
            // we know the incoming point and the destination point are needed
            if (destination.y == 0 || destination.y == matrix.length - 1) {
                result.add(pt);
                result.add(destination);
                // if we want to continue finding paths, then don't return results
                return result;
            }

            // continue search for flow
            // if something returned, we know the incoming point and the
            // searched points are needed
            List<Point> points = searchPath(destination, visited, matrix);
            if (points.size() > 0) {
                result.add(pt);
                result.addAll(points);
                // if we want to continue finding paths, then don't return results
                return result;
            }
        }

        // check if we reached the end then return this point
        return result;
    }


    /**
     * Given an incoming point, search through all the directions.
     *
     * @param pt      incoming point
     * @param visited list of all visited points
     * @param matrix  origin matrix
     */
    private void searchAllExistance(Point pt, Map<Point, Boolean> visited, int[][] matrix) {
        // create a two dimensional array
        // representing all the possible movements
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // keep track of the path
        List<Point> result = new ArrayList<Point>();

        // loop through all directions
        for (int[] direction : directions) {
            // use the direction to get a new point
            Point destination = new Point(pt.x + direction[0], pt.y + direction[1]);

            // boundary check
            if (destination.x < 0 || destination.x >= matrix.length ||
                    destination.y < 0 || destination.y >= matrix.length) {
                continue;
            }

            // check if the new destination does not have the same value
            // or if it has already been visited
            if (matrix[destination.x][destination.y] != matrix[pt.x][pt.y] ||
                    visited.containsKey(destination)) {
                continue;
            }

            // mark this destination as visited
            visited.put(destination, true);

            // continue search for flow
            // if something returned, we know the incoming point and the
            // searched points are needed
            searchAllExistance(destination, visited, matrix);
        }
    }

    /**
     * Calls the depth first search method to find a path.
     *
     * Compares all visited nodes, if there is a node on both sides, then we found a path.
     *
     * Alternatively, we can return the list of nodes if a path is found.
     *
     * @param start  beginning point
     * @param matrix origin matrix
     * @return true if we found a path
     */
    public boolean findPathExists(Point start, int[][] matrix) {
        // add the starting point to visited map
        Map<Point, Boolean> visited = new HashMap<Point, Boolean>();
        visited.put(start, true);

        // search for all possible paths
        searchAllExistance(start, visited, matrix);

        // if any of the nodes are on opposite edges, then it is true
        boolean leftSide = false;
        boolean rightSide = false;

        // loop through all visited nodes
        // counter intuitive
        // Column 0 and column length -1 must be visited
        // y coordinate is the column
        for (Point p : visited.keySet()) {
            if (p.y == 0) {
                leftSide = true;
            } else if (p.y == matrix.length - 1) {
                rightSide = true;
            }
            if (leftSide && rightSide) {
                return true;
            }
        }

        // could not find a path
        return false;
    }

    /**
     * Calls the depth first search method to find a path.
     *
     * Compares all visited nodes, if there is a node on both sides, then we found a path.
     *
     * Alternatively, we can return the list of nodes if a path is found.
     *
     * @param start  beginning point
     * @param matrix origin matrix
     * @return true if we found a path
     */
    public List<Point> findPath(Point start, int[][] matrix) {
        // add the starting point to visited map
        Map<Point, Boolean> visited = new HashMap<Point, Boolean>();
        visited.put(start, true);

        // search for all possible paths
        List<Point> points = searchPath(start, visited, matrix);

        return points;
    }

}
