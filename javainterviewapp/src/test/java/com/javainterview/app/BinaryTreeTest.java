
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import TreeInterview.BinaryTree;
import TreeInterview.BinaryTree.Node;

import java.lang.Integer;

public class BinaryTreeTest {
    
    BinaryTree binaryTree;
    
	@BeforeSuite
	public void testBeforeSuite() {
		System.out.println("testBeforeSuite() creating BinaryTree");
		binaryTree = new BinaryTree();
	}
	
	@Test
	public void checkSmall() {
		BinaryTree.Node node = binaryTree.new Node();
		node.value = 50;
		node.left = binaryTree.new Node();
		node.left.value = 25;
		node.right = binaryTree.new Node();
		node.right.value = 75;

		boolean isBST = binaryTree.isBST( node, Integer.MIN_VALUE, Integer.MAX_VALUE );		

	    assertTrue(isBST);
	}
	
	@Test
	public void negTest() {
		BinaryTree.Node node = binaryTree.new Node();
		node.value = 50;
		node.left = binaryTree.new Node();
		node.left.value = 75;

		boolean isBST = binaryTree.isBST( node, Integer.MIN_VALUE, Integer.MAX_VALUE );		

	    assertFalse(isBST);
	}
}