package dsa.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import dsa.List.ListPrinter;

public class Main
{
    public static void main(String[] args)
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

          BinaryTree<Integer> tree = new BinaryTree<Integer>(node1);

          node1.left = node2;
          node1.right = node3;
          node2.left = node4;
          node2.right = node5;
          node5.right = node6;
          node6.right = node7;
          node7.right = node8;
          node4.right = node9;
          node9.right = node10;

          tree.print();

          System.out.print("inorder traversal: ");
          ArrayList<Integer> inorder_list = new ArrayList<Integer>();
          inorder_list = tree.inOrder();

          ListPrinter<Integer> ppl = new ListPrinter<Integer>(inorder_list);
          ppl.print();
          System.out.println();

          System.out.print("preorder traversal: ");

          ArrayList<Integer> preorder_list = new ArrayList<Integer>();
          preorder_list = tree.preOrder();

          ListPrinter<Integer> ppl1 = new ListPrinter<Integer>(preorder_list);
          ppl1.print();

          System.out.println();

          System.out.print("postorder traversal: ");

          ArrayList<Integer> postorder_list = new ArrayList<Integer>();
          postorder_list = tree.postOrder();

          ListPrinter<Integer> ppl2 = new ListPrinter<Integer>(postorder_list);
          ppl2.print();

          System.out.println();

          System.out.print("levelorder traversal: ");

          ArrayList<Integer> levelorder_list = new ArrayList<Integer>();
          Queue<Node<Integer>> levelorder = new LinkedList<Node<Integer>>();
          levelorder.add(node1);
          levelorder_list = tree.levelOrder(levelorder_list, levelorder);

          ListPrinter<Integer> ppl3 = new ListPrinter<Integer>(levelorder_list);
          ppl3.print();

          System.out.println();

          System.out.println("height of tree: " + tree.height());

          System.out.println("depth of 4 in tree: " + tree.depth(4));

          System.out.println("diameter of tree: " + tree.diameter());
      }
}