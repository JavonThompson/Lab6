// Time: O(n), visits every node once
// Space: O(h) for the recursion stack (O(n) worst case for a chain)

import java.util.*;

public class Problem1_1_CountNodes {

    // N-ary tree node (Problem 0.1)
    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // Test tree:
    //          1
    //       /  |  \
    //      3   2   4
    //     / \      |
    //    5   6     9
    //              |
    //              7
    static Node buildTestTree() {
        Node root = new Node(1);
        Node n3 = new Node(3), n2 = new Node(2), n4 = new Node(4);
        Node n5 = new Node(5), n6 = new Node(6), n9 = new Node(9), n7 = new Node(7);
        root.children.add(n3);
        root.children.add(n2);
        root.children.add(n4);
        n3.children.add(n5);
        n3.children.add(n6);
        n4.children.add(n9);
        n9.children.add(n7);
        return root;
    }

    static int countNodes(Node root) {
        if (root == null) return 0;

        int count = 1;
        for (Node child : root.children) {
            count += countNodes(child);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Count nodes: " + countNodes(buildTestTree()) + " (expected 8)");
        System.out.println("Empty tree:  " + countNodes(null) + " (expected 0)");
    }
}
