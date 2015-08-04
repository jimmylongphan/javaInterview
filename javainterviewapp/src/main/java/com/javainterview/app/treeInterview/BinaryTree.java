package TreeInterview;


public class Node {
    public int value;
    public Node left;
    public Node right;
}


public class BinaryTree {
    public static const Integer MIN = Integer.MIN;
    public static const Integer MAX = Integer.MAX;
    
    public boolean isBST( Node root, Integer min, Integer max) {
        if ( root == null ) {
            return true;
        }
        
        // check the current node
        if ( root.value > max || root.value < min ) {
            return false;
        }
        
        // left child must be BST
        boolean left = isBST( root.left, min, root.value );
        if ( !left ) {
            return false;
        }

        // right child must be BST
        boolean right = isBST( root.right, root.value, max);
        return right;
    }
}