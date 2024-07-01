package dsa.tests.tree.BinaryTree;

import org.junit.Before;
import org.junit.Test;
import dsa.tree.BinaryTree.*;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

class BinaryTreeTest
{
  private BinaryTree<Integer> binaryTree;

  @Before
  public void setup()
  {
    Node<Integer> node1 = new Node<Integer>(1);
    Node<Integer> node2 = new Node<Integer>(2);
    Node<Integer> node3 = new Node<Integer>(3);
    Node<Integer> node4 = new Node<Integer>(4);
    Node<Integer> node5 = new Node<Integer>(5);
    Node<Integer> node6 = new Node<Integer>(6);
    Node<Integer> node7 = new Node<Integer>(7);
    Node<Integer> node8 = new Node<Integer>(8);
    Node<Integer> node9 = new Node<Integer>(9);
    Node<Integer> node10 = new Node<Integer>(10);

    binaryTree = new BinaryTree<Integer>(node1);
    binaryTree.print();
  }

  @Test
  public void testInOrderTraversal()
  { 
    List<Integer> expected = Arrays.asList(4, 2, 5, 1, 3, 7, 6);
    List<Integer> actual = binaryTree.inOrder();

    assertEquals(expected, actual);
  }

  @Test
  public void testPreOrderTraversal()
  { 
    List<Integer> expected = Arrays.asList(1, 2, 4, 9, 10, 5, 6, 7, 8, 3);
    List<Integer> actual = binaryTree.preOrder();
  
    assertEquals(expected, actual);
  }

  @Test
  public void testPostOrderTraversal()
  { 
    List<Integer> expected = Arrays.asList(1, 2, 4, 9, 10, 5, 6, 7, 8, 3);
    List<Integer> actual = binaryTree.postOrder();

    assertEquals(expected, actual);
  }
}