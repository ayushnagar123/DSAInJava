package dsa.tree.BinaryTree;

public class Node<T>
{
    Node<T> left = null;
    Node<T> right = null;

    T value;

    public Node(T val)
    {
        this.value = val;
    }
}