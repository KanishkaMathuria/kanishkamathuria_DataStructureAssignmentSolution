package com.greatlearning.binarysearchtree;

public class Node {

    int val;
    Node left, right;

    // Node allocator function
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}
