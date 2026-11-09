// COSC 214 - Lab 6: Trees
// Name: Javon
// Problem 0.2: Manual Tree Construction
//
// Complexity (n = number of nodes, h = tree height, w = widest level)
// Time: O(1), always builds exactly 4 nodes
// Space: O(1)

import java.util.*;

public class Problem0_2_ManualConstruction {

    // N-ary tree node (Problem 0.1)
    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    //     1
    //   / | \
    //  2  3  4
    static Node buildSampleTree() {
        Node root = new Node(1);

        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        return root;
    }

    public static void main(String[] args) {
        Node root = buildSampleTree();
        System.out.print("Root: " + root.val + ", children: ");
        for (Node child : root.children) {
            System.out.print(child.val + " ");
        }
        System.out.println();
    }
}
