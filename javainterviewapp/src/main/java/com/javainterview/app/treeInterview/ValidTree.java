package com.javainterview.app.treeInterview;

import java.util.*;

/**
 * Given nodes from 0 to n -1
 * List of undirected edges(pair of nodes).
 *
 * Check whether the edges create a valid tree
 *
 * A valid tree:
 * There are no cycles in the tree
 *
 * Solution:
 * Keep a map of a node and a set of its connected edges.
 * It's an undirected graph, so we will add the the edge for both directions.
 *
 * Use a queue for BFS.
 * Keep a set to track whether this node has already been visited.
 *
 * Using BFS, start from node 0.
 *   Check if we already visited this node, then return false.
 *
 * Get all connected nodes from the current node
 *   Add the connected nodes to the queue.
 *   Remove the current node from all the connected nodes in the edge map.
 *   Remove the current node from the set to show that we already visited it.
 *
 * Explanation:
 * As we are adding children to the set using BFS.
 * If there is a cycle, eventually a child node is actually a parent node.
 *   Then it will appear in the visited set.
 *   Then we know there is a cycle and return false.
 *
 * Finally we check that the size of the set is N, which means all nodes
 * are connected in the graph.
 *   If the size is different, then a node is not connected.
 */
public class ValidTree {

    public boolean validTree(int numNodes, int[][] edges) {
        // error checks
        if (numNodes < 1) {
            return false;
        }

        // map to store information on edges
        Map<Integer, Set<Integer>> edgeMap = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < numNodes; i++) {
            // initialize all sets in the map
            edgeMap.put(i, new HashSet<Integer>());
        }

        // in the map store all nodes and their connected nodes
        for (int[] edge : edges) {
            // keep track of one direction
            edgeMap.get(edge[0]).add(edge[1]);

            // add other direction
            edgeMap.get(edge[1]).add(edge[0]);
        }

        Set<Integer> processedNodes = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        // add the first node
        queue.add(0);
        while (!queue.isEmpty()) {
            int currentNode = queue.remove();

            // set already contains this node
            // then there is a cycle
            if (processedNodes.contains(currentNode)) {
                return false;
            }

            // for this node, get the set of all connected nodes
            Set<Integer> connectedNodes = edgeMap.get(currentNode);

            // loop through all connected nodes
            for (int connectedNode : connectedNodes) {
                // add this connected node to the queue
                queue.add(connectedNode);

                // remove the current node from the connected node's list
                edgeMap.get(connectedNode).remove(currentNode);
            }

            // add this current node to the processed set
            processedNodes.add(currentNode);
        }

        // in an acyclic graph, each node is connected only once to the graph
        return processedNodes.size() == numNodes;
    }
}