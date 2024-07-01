import dsa.tree.BinaryTree.BinaryTree;
import dsa.tree.BinaryTree.Node;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    Node<Integer> root = new Node<Integer>(1);

    BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
    tree.print();
  }
}