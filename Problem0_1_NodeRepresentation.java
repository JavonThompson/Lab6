// COSC 214 - Lab 6: Trees
// Name: Javon
// Problem 0.1: Tree Node Representation
//
// Complexity (n = number of nodes, h = tree height, w = widest level)
// Time: O(1) per node created
// Space: O(k) per node, where k = number of children in its list

import java.util.*;

public class Problem0_1_NodeRepresentation {

    // N-ary tree node (Problem 0.1)
    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(2));
        System.out.println("Root value: " + root.val);
        System.out.println("Number of children: " + root.children.size());
    }
}
