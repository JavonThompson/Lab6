import java.util.*;

// Problem 0.1: Tree Node Representation
// Time: O(1)  Space: O(1)
class Node {
    int val;
    List<Node> children;

    Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

// Problem 4.1: Binary Node
// Time: O(1)  Space: O(1)
class BNode {
    int val;
    BNode left, right;

    BNode(int val) {
        this.val = val;
    }
}

public class Lab6Trees {

    // Problem 0.2: Manual Tree Construction
    // Time: O(1)  Space: O(1)
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

    // Problem 1.1: Count Nodes
    // Time: O(n)  Space: O(h)
    static int countNodes(Node root) {
        if (root == null) return 0;

        int count = 1;
        for (Node child : root.children) {
            count += countNodes(child);
        }
        return count;
    }

    // Problem 1.2: Height of Tree
    // Time: O(n)  Space: O(h)
    static int height(Node root) {
        if (root == null) return 0;

        int maxHeight = 0;
        for (Node child : root.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return 1 + maxHeight;
    }

    // Problem 1.3: Count Leaf Nodes
    // Time: O(n)  Space: O(h)
    static int countLeaves(Node root) {
        if (root == null) return 0;

        if (root.children.size() == 0) return 1;

        int count = 0;
        for (Node child : root.children) {
            count += countLeaves(child);
        }
        return count;
    }

    // Problem 2.1: Preorder Traversal
    // Time: O(n)  Space: O(h)
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        for (Node child : root.children) {
            preorder(child);
        }
    }

    // Problem 2.2: Postorder Traversal
    // Time: O(n)  Space: O(h)
    static void postorder(Node root) {
        if (root == null) return;

        for (Node child : root.children) {
            postorder(child);
        }
        System.out.print(root.val + " ");
    }

    // Problem 2.3: Level Order Traversal (BFS)
    // Time: O(n)  Space: O(n)
    static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + " ");

            for (Node child : curr.children) {
                queue.add(child);
            }
        }
    }

    // Problem 3.1: Iterative Preorder
    // Time: O(n)  Space: O(n)
    static void iterativePreorder(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.val + " ");

            for (int i = curr.children.size() - 1; i >= 0; i--) {
                stack.push(curr.children.get(i));
            }
        }
    }

    // Problem 3.2: Maximum Value
    // Time: O(n)  Space: O(h)
    static int findMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int max = root.val;
        for (Node child : root.children) {
            max = Math.max(max, findMax(child));
        }
        return max;
    }

    // Problem 3.3: Search
    // Time: O(n)  Space: O(h)
    static boolean search(Node root, int target) {
        if (root == null) return false;

        if (root.val == target) return true;

        for (Node child : root.children) {
            if (search(child, target)) return true;
        }
        return false;
    }

    // Problem 4.2: Inorder Traversal
    // Time: O(n)  Space: O(h)
    static void inorder(BNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Problem 4.3: Check Balanced Tree
    // Time: O(n)  Space: O(h)
    static int checkHeight(BNode root) {
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1;

        int right = checkHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    static boolean isBalanced(BNode root) {
        return checkHeight(root) != -1;
    }

    // Problem 5.1: Level Order List
    // Time: O(n)  Space: O(n)
    static List<List<Integer>> levelOrderList(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);

                for (Node child : curr.children) {
                    queue.add(child);
                }
            }
            result.add(level);
        }
        return result;
    }

    // Problem 5.2: Max Depth
    // Time: O(n)  Space: O(h)
    static int maxDepth(Node root) {
        if (root == null) return 0;

        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return 1 + depth;
    }

    // Problem 6.1: LeetCode 589 N-ary Tree Preorder Traversal
    // Time: O(n)  Space: O(n)
    static List<Integer> preorderList(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    static void preorderHelper(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);
        for (Node child : node.children) {
            preorderHelper(child, result);
        }
    }

    // Problem 6.2: LeetCode 590 N-ary Tree Postorder Traversal
    // Time: O(n)  Space: O(n)
    static List<Integer> postorderList(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    static void postorderHelper(Node node, List<Integer> result) {
        if (node == null) return;

        for (Node child : node.children) {
            postorderHelper(child, result);
        }
        result.add(node.val);
    }

    // Problem 6.3: LeetCode 429 N-ary Tree Level Order Traversal
    // Time: O(n)  Space: O(n)
    static List<List<Integer>> levelOrderLeetCode(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                level.add(curr.val);
                for (Node child : curr.children) {
                    queue.add(child);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        Node sample = buildSampleTree();

        Node tree = new Node(1);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n9 = new Node(9);
        Node n7 = new Node(7);
        tree.children.add(n3);
        tree.children.add(n2);
        tree.children.add(n4);
        n3.children.add(n5);
        n3.children.add(n6);
        n4.children.add(n9);
        n9.children.add(n7);

        BNode b = new BNode(4);
        b.left = new BNode(2);
        b.right = new BNode(6);
        b.left.left = new BNode(1);
        b.left.right = new BNode(3);
        b.right.right = new BNode(7);

        BNode skew = new BNode(1);
        skew.right = new BNode(2);
        skew.right.right = new BNode(3);

        System.out.print("0.2 Sample tree preorder: ");
        preorder(sample);
        System.out.println();

        System.out.println("1.1 Count nodes: " + countNodes(tree));
        System.out.println("1.2 Height: " + height(tree));
        System.out.println("1.3 Count leaves: " + countLeaves(tree));

        System.out.print("2.1 Preorder: ");
        preorder(tree);
        System.out.println();

        System.out.print("2.2 Postorder: ");
        postorder(tree);
        System.out.println();

        System.out.print("2.3 Level order: ");
        levelOrder(tree);
        System.out.println();

        System.out.print("3.1 Iterative preorder: ");
        iterativePreorder(tree);
        System.out.println();

        System.out.println("3.2 Max value: " + findMax(tree));
        System.out.println("3.3 Search 6: " + search(tree, 6));
        System.out.println("3.3 Search 8: " + search(tree, 8));

        System.out.print("4.2 Inorder: ");
        inorder(b);
        System.out.println();

        System.out.println("4.3 Balanced tree: " + isBalanced(b));
        System.out.println("4.3 Skewed tree: " + isBalanced(skew));

        System.out.println("5.1 Level order list: " + levelOrderList(tree));
        System.out.println("5.2 Max depth: " + maxDepth(tree));

        System.out.println("6.1 LeetCode 589: " + preorderList(tree));
        System.out.println("6.2 LeetCode 590: " + postorderList(tree));
        System.out.println("6.3 LeetCode 429: " + levelOrderLeetCode(tree));
    }
}
