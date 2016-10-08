package com.javainterview.app.treeInterview;


import java.util.*;

/**
 * Created on 2/21/2016.
 *
 * BFS uses a Queue data structure.
 * This code prints out in breadthFirst search.
 *
 * QUEUE = FIFO (first-in-first-out)
 * 1. Push root node in the queue
 * 2. Loop until queue is empty
 * 3. Remove the node from the queue.
 * 4. If the node is not visited, check the left/right children
 *   and add them into the queue.
 *
 *   Big O()
 *   O(V + E)
 *   V: vertex, takes O(1) for queuing each vertex
 *   E: edge, count of all edges. We count the edges of each
 *   vertex only once when traversing.
 *
 * Applications:
 * 1. Unweighted graph: Shortest path is the path with least number of edges
 * 2. It is also mininum spanning tree
 * 3. Used to find all nodes in torrent
 * 4. It is a crawler in search engine:
 * 5.
 */
public class BreadthFirstSearch {

    public void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        // visit the root node first
        root.visited = true;
        root.print();

        // add the first node to the queue
        q.add(root);
        while (!q.isEmpty()) {
            // get the head of the list
            TreeNode currentTreeNode = q.remove();
            TreeNode child = null;

            // retrieve all unvisited children
            while ((child = currentTreeNode.getUnvisitedChild()) != null) {
                child.visited = true;
                child.print();
                q.add(child);
            }
        }
    }

    /**
     * This method prints the shortest path between two nodes in a binary tree.
     * Uses breadth first search since the graph is unweighted.
     * To print the path, we keep track of the parent node.
     *
     * Or we can keep a history of the path leading up to the current node.
     *
     * @param start
     * @param end
     * @return List of nodes that lead to the solution
     */
    public List<String> shortestPath(TreeNode start, TreeNode end) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<TreeNode, TreeNode>();
        List<String> path = new LinkedList<String>();

        // visit the start node
        start.visited = true;
        start.print();
        parentMap.put(start, null);

        // add the start node to the queue
        q.add(start);
        while (!q.isEmpty()) {
            // get the head of the list
            TreeNode currentTreeNode = q.remove();
            TreeNode child = null;

            // retrieve all unvisited children
            while ((child = currentTreeNode.getUnvisitedChild()) != null) {
                child.visited = true;
                child.print();
                q.add(child);

                // add the parent
                parentMap.put(child, currentTreeNode);

                // check if this is the end node
                if (child.value == end.value) {
                    TreeNode backTrack = child;
                    while (backTrack != null) {
                        // build the backtracking path
                        path.add(0, backTrack.toString());
                        // retrieve parent until null
                        backTrack = parentMap.get(backTrack);
                    }
                    return path;
                }
            }
        }

        return path;
    }

}
