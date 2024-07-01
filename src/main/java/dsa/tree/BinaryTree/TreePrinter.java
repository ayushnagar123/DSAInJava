package dsa.tree.BinaryTree;

import dsa.utils.PrintInterface;

public class TreePrinter<T> implements PrintInterface
{
    Node<T> treeRoot;

    TreePrinter(Node<T> root)
    {
        treeRoot = root;
    }
    
    private static <T> void printTree(Node<T> node, String prefix, boolean isLeft) {
      if (node == null) {
          System.out.println("Empty tree");
          return;
      }

      if (node.right != null) {
          printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
      }

      System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.value);

      if (node.left != null) {
          printTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
      }
    }

    public void print()
    {
        printTree(treeRoot, "", true);
    }
}
