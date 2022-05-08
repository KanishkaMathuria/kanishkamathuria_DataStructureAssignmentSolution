package com.greatlearning.binarysearchtree;

public class BinarySearchTree {

    public static Node node;
    static Node previousNode = null;
    static Node headNode = null;

    //  convert binary search tree to a skewed tree
    static void convertBSTToSkewed(Node root,
                                   int order)
    {

        if(root == null)
        {
            return;
        }

        // Condition to check the order in which the skewed tree to maintained
        if(order > 0)
        {
            convertBSTToSkewed(root.right, order);
        }
        else
        {
            convertBSTToSkewed(root.left, order);
        }
        Node rightNode = root.right;
        Node leftNode = root.left;

        //check if the root Node of the skewed tree is not defined
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            previousNode = root;
        }
        else
        {
            previousNode.right = root;
            root.left = null;
            previousNode = root;
        }

        if (order > 0)
        {
            convertBSTToSkewed(leftNode, order);
        }
        else
        {
            convertBSTToSkewed(rightNode, order);
        }
    }

    // Traverse the right skewed tree
    static void travRightSkewedTree(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        travRightSkewedTree(root.right);
    }

    // Driver Code
    public static void main (String[] args)
    {

        BinarySearchTree tree = new BinarySearchTree();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(55);

        // Order of the Skewed tree
        int order = 0;
        convertBSTToSkewed(node, order);
        travRightSkewedTree(headNode);
    }

}
