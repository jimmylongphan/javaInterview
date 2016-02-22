package com.javainterview.app.treeInterview;

import java.util.*;

/**
 * Created on 2/21/2016.
 *
 * DFS uses a stack (LIFO) - last in first out
 * 1. Push the root node on the stack.
 * 2. Loop until the stack is empty.
 * 3. Peek the top node of the stack.
 * 4. If the current node has unvisited children, visit them,
 *   add them to the stack.
 * 5. If there are no more unvisited children, we are done with this node, then pop.
 *
 * Big O()
 *  O(V + E)
 *  V: vertex, takes O(1) for stacking each vertex
 *  E: edge, count of all edges. We count the edges of each
 *  vertex only once when traversing.
 *
 * Applications
 * 1. detecting a cycle
 * 2. Used to find a path
 * 3. Strongly connected directed graph - each vertex has a path to every other vertex
 */
public class DepthFirstSearch {

    public void dfs(Node root) {
        Stack<Node> s = new Stack<Node>();
        // we visit the root node first
        root.visited = true;
        root.print();

        s.push(root);
        while(!s.isEmpty()) {
            // retrieve the current node
            // do not pop because there may be more children
            Node currentNode = s.peek();
            Node child = currentNode.getUnvisitedChild();

            if (child != null) {
                // child is not yet visited
                child.visited = true;
                child.print();
                // add the child to the stack and then traverse
                s.push(child);
            } else {
                // no more children to visit, we can pop the current node
                s.pop();
            }
        }
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public List<String> findPath(Node start, Node end) {
        Stack<Node> s = new Stack<Node>();
        List<String> path = new LinkedList<String>();
        Map<Node, Node> parentMap = new HashMap<Node, Node>();

        // visit the root node first
        start.visited = true;

        s.push(start);
        while(!s.isEmpty()) {
            // retrieve the current node
            // do not pop because there may be more children
            Node currentNode = s.peek();
            Node child = currentNode.getUnvisitedChild();

            // add the parent mapping
            parentMap.put(child, currentNode);

            if (child != null) {
                // visit child
                child.visited = true;
                s.push(child);

                if (child.value == end.value) {
                    // backtrack to find the node
                    Node backTrack = child;
                    while (backTrack != null) {
                        path.add(0, backTrack.toString());
                        backTrack = parentMap.get(backTrack);
                    }
                }
            } else {
                s.pop();
            }
        }

        return path;
    }

}
