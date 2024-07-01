package dsa.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Queue;
import javafx.util.Pair;
import java.util.LinkedList;


public class BinaryTree<T> {

    private Node<T> treeRoot;

    public BinaryTree(Node<T> root)
    {
        this.treeRoot = root;
    }

    // left data right
    private static <T> ArrayList<T> inOrder(Node<T> root, ArrayList<T> order)
    {
        if (root == null) return order;
        inOrder(root.left, order);
        order.add(root.value);
        inOrder(root.right, order);
        return order;
    }

    public ArrayList<T> inOrder()
    {
        return inOrder(treeRoot, new ArrayList<T>());
    }

    // left data right
    private ArrayList<T> preOrder(Node<T> root, ArrayList<T> order)
    {
        if (root == null) return order;
        order.add(root.value);
        preOrder(root.left, order);
        preOrder(root.right, order);
        return order;
    }

    public ArrayList<T> preOrder()
    {
        return preOrder(treeRoot, new ArrayList<T>());
    }

    // left data right
    private ArrayList<T> postOrder(Node<T> root, ArrayList<T> order)
    {
        if (root == null) return order;
        postOrder(root.left, order);
        postOrder(root.right, order);
        order.add(root.value);
        return order;
    }

    public ArrayList<T> postOrder()
    {
        return postOrder(treeRoot, new ArrayList<T>());
    }


    // left data right
    public ArrayList<T> levelOrder(ArrayList<T> answer, Queue<Node<T>> order)
    {
        if (order.isEmpty()) return answer;
        Node<T> temp = order.peek();
        order.remove();

        answer.add(temp.value);
        if (temp.left != null){
            order.add(temp.left);
        }
        if (temp.right != null){
            order.add(temp.right);
        }
        levelOrder(answer, order);
        return answer;
    }

    private static <T> Integer heightHelper(Node<T> root)
    {
        if (root == null) return 0;
        return Math.max(heightHelper(root.left), heightHelper(root.right))+1;
    }

    private static <T> Integer depthHelper(T value, Integer currDepth, Node<T> root)
    {
        if(root == null) return -1;
        if (root.value == value) return currDepth;
        return Math.max(
            depthHelper(value, currDepth+1, root.left),
            depthHelper(value, currDepth+1, root.right)
        );
    }

    private Integer diameterHelper(Node<T> root)
    {
        if (root == null) return 0;
        Integer heightLeft = heightHelper(root.left);
        Integer heightRight = heightHelper(root.right);
        return Math.max(
            heightLeft+heightRight+1,
            Math.max(
                diameterHelper(root.left),
                diameterHelper(root.right)
            )
        );
    }

    public Integer height()
    {
        return heightHelper(treeRoot);
    }

    public Integer diameter()
    {
        return diameterHelper(treeRoot);
    }

    public Integer depth(T value)
    {
        if (treeRoot == null) return -1;
        return depthHelper(value, 0, treeRoot);
    }

    public void print()
    {
        TreePrinter<T> printer = new TreePrinter<T>(treeRoot);
        printer.print();
    }

    public void leftViewOfTree()
    {
        ArrayList<T> answer = new ArrayList<T>();
        Queue<Pair<Node<T>, Integer>> order = new LinkedList<Pair<Node<T>, Integer>>();
        order.add(new Pair(treeRoot, 0));
        while(!order.isEmpty())
        {
            Node<T> temp = order.peek().getKey();
            Integer depth = order.peek().getValue();
            order.remove();
            if (answer.size() <= depth)
            {
                answer.add(temp.value);
            }
            if (temp.left != null){
                order.add(new Pair(temp.left, depth + 1));
            }
            if (temp.right != null){
                order.add(new Pair(temp.right, depth + 1));
            }
        }
        for(T val: answer)
        {
            System.out.print(val + " ");
        }
    }

    public void leftViewOfTree()
        {
            ArrayList<T> answer = new ArrayList<T>();
            Queue<Pair<Node<T>, Integer>> order = new LinkedList<Pair<Node<T>, Integer>>();
            order.add(new Pair(treeRoot, 0));
            while(!order.isEmpty())
            {
                Node<T> temp = order.peek().getKey();
                Integer depth = order.peek().getValue();
                order.remove();
                if (answer.size() <= depth)
                {
                    answer.add(temp.value);
                }
                if (temp.left != null){
                    order.add(new Pair(temp.left, depth + 1));
                }
                if (temp.right != null){
                    order.add(new Pair(temp.right, depth + 1));
                }
            }
            for(T val: answer)
            {
                System.out.print(val + " ");
            }
        }

        public void rightViewOfTree()
        {
            ArrayList<T> answer = new ArrayList<T>();
            Queue<Pair<Node<T>, Integer>> order = new LinkedList<Pair<Node<T>, Integer>>();
            order.add(new Pair(treeRoot, 0));
            while(!order.isEmpty())
            {
                Node<T> temp = order.peek().getKey();
                Integer depth = order.peek().getValue();
                order.remove();
                if (answer.size() <= depth)
                {
                    answer.add(temp.value);
                }

                if (temp.right != null){
                    order.add(new Pair(temp.right, depth + 1));
                }

                if (temp.left != null){
                    order.add(new Pair(temp.left, depth + 1));
                }
            }
            for(T val: answer)
            {
                System.out.print(val + " ");
            }
        }

        public void topViewOfTree()
        {
            ArrayList<T> answer = new ArrayList<T>();
            Queue<Pair<Node<T>, Integer>> order = new LinkedList<Pair<Node<T>, Integer>>();
            order.add(new Pair(treeRoot, 0));

            HashMap<Integer, T> traversal = new HashMap<Integer, T>();
            while(!order.isEmpty())
            {
                Node<T> temp = order.peek().getKey();
                Integer displacement = order.peek().getValue();
                order.remove();
                if (!traversal.containsKey(displacement))
                {
                    traversal.put(displacement, temp.value);
                }

                if (temp.left != null){
                    order.add(new Pair(temp.left, displacement - 1));
                }

                if (temp.right != null){
                    order.add(new Pair(temp.right, displacement + 1));
                }
            }

            ArrayList<Integer> distances = new ArrayList<Integer>();
            for(Integer key: traversal.keySet())
            {
                distances.add(key);
            }

            Collections.sort(distances);


            for(Integer distance: distances)
            {
                System.out.print(traversal.get(distance) + " ");
            }
        }

        public void bottomViewOfTree()
        {
            ArrayList<T> answer = new ArrayList<T>();
            Queue<Pair<Node<T>, Integer>> order = new LinkedList<Pair<Node<T>, Integer>>();
            order.add(new Pair(treeRoot, 0));

            HashMap<Integer, T> traversal = new HashMap<Integer, T>();
            while(!order.isEmpty())
            {
                Node<T> temp = order.peek().getKey();
                Integer displacement = order.peek().getValue();
                order.remove();

                traversal.put(displacement, temp.value);

                if (temp.left != null){
                    order.add(new Pair(temp.left, displacement - 1));
                }

                if (temp.right != null){
                    order.add(new Pair(temp.right, displacement + 1));
                }
            }

            ArrayList<Integer> distances = new ArrayList<Integer>();
            for(Integer key: traversal.keySet())
            {
                distances.add(key);
            }

            Collections.sort(distances);


            for(Integer distance: distances)
            {
                System.out.print(traversal.get(distance) + " ");
            }
        }
}