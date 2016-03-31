package com.javainterview.app.treeInterview;

/**
 * Given nodes from 0 to n -1
 * List of undirected edges(pair of nodes).
 * 
 * Check whether the edges create a valid tree
 * 
 * A valid tree:
 *   There are no cycles in the tree
 * 
 * Solution:
 *   Keep a map of a node and a set of its connected edges.
 *   It's an undirected graph, so we will add the the edge for both directions.
 * 
 *   Use a queue for BFS.
 *   Keep a set to track whether this node has already been visited.
 * 
 *   Using BFS, start from node 0.
 *   Check if we already visited this node, then return false.
 * 
 *   Get all connected nodes from the current node
 *   Add the connected nodes to the queue.
 *   Remove the current node from all the connected nodes in the edge map.
 *   Remove the current node from the set to show that we already visited it.
 * 
 *   Explanation:
 *     As we are adding children to the set using BFS.
 *     If there is a cycle, eventually a child node is actually a parent node.
 *     Then it will appear in the visited set.
 *     Then we know there is a cycle and return false.
 * 
 *     Finally we check that the size of the set is N, which means all nodes
 *     are connected in the graph.
 *     If the size is different, then a node is not connected.
 *   
 */
public class ValidTree {
    
    public boolean validTree(int n, int[][] edges) {
        // error checks
        if ( n < 1 ) {
            return false;
        }
        
        // map to store information on edges
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i < n; i++) {
            // initialize all sets in the map
            map.put(i, new HashSet<>());
        }
        
        // in the map store all nodes and their connected nodes
        for(int[] edge: edges) {
            // keep track of one direction
            map.get(edge[0]).add(edge[1]);
            
            // add other direction
            map.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // add the first node
        queue.add(0);
        while(!queue.isEmpty()) {
            int top = queue.remove();
            
            // set already contains this node
            // then there is a cycle
            if (set.contains(top)) {
                return false;
            }
            
            // for this node, get the set of all connected nodes
            Set<Integer> connectedNodes = map.get(top);
            
            // loop through all connected nodes
            for (int connectedNode : connectedNodes) {
                // add this connected node to the queue
                queue.add(connectedNode);
                
                // remove the top node from the connected node
                map.get(connectedNode).remove(top);
            }
            
            // add this top node to the set
            // if the set already contains this top node again, there is a cycle
            set.add(top);
        }
        
        // in an acyclic graph, each node is connected only once to the graph
        return set.size() == n;
    }
}