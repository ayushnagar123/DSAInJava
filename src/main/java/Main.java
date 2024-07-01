import dsa.tree.BinaryTree.BinaryTree;
import dsa.tree.BinaryTree.Node;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    Node<Integer> root = new Node<Integer>(1);

    BinaryTree<Integer> tree = new BinaryTree<Integer>(root);
    tree.print();
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}