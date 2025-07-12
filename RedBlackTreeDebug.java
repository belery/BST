public class RedBlackTreeDebug {

    public static void main(String[] args) {
        testCase1();
        testCase2();
        testCase3();
    }

    private static void testCase1() {
        System.out.println("========================");
        System.out.println("TEST CASE 1: Basic Insertion");
        System.out.println("========================");

        RedBlackTree<Integer> tree = new RedBlackTree<>();

        System.out.println("\nInserting 10...");
        tree.insert(10);
        printTree(tree);

        System.out.println("\nInserting 5...");
        tree.insert(5);
        printTree(tree);

        System.out.println("\nInserting 15...");
        tree.insert(15);
        printTree(tree);

        System.out.println("\nInserting 3...");
        tree.insert(3);
        printTree(tree);

        System.out.println("\nInserting 7...");
        tree.insert(7);
        printTree(tree);
    }

    private static void testCase2() {
        System.out.println("\n\n========================");
        System.out.println("TEST CASE 2: Rotation Cases");
        System.out.println("========================");

        RedBlackTree<Integer> tree = new RedBlackTree<>();

        System.out.println("\nInserting 10...");
        tree.insert(10);
        printTree(tree);

        System.out.println("\nInserting 20...");
        tree.insert(20);
        printTree(tree);

        System.out.println("\nInserting 30 (Should trigger left rotation)...");
        tree.insert(30);
        printTree(tree);

        System.out.println("\nInserting 15...");
        tree.insert(15);
        printTree(tree);

        System.out.println("\nInserting 5...");
        tree.insert(5);
        printTree(tree);

        System.out.println("\nInserting 1 (Should trigger right rotation)...");
        tree.insert(1);
        printTree(tree);
    }

    private static void testCase3() {
        System.out.println("\n\n========================");
        System.out.println("TEST CASE 3: Color Flip Cases");
        System.out.println("========================");

        RedBlackTree<Integer> tree = new RedBlackTree<>();

        System.out.println("\nInserting 50...");
        tree.insert(50);
        printTree(tree);

        System.out.println("\nInserting 40...");
        tree.insert(40);
        printTree(tree);

        System.out.println("\nInserting 60...");
        tree.insert(60);
        printTree(tree);

        System.out.println("\nInserting 30 (Should trigger color flip)...");
        tree.insert(30);
        printTree(tree);

        System.out.println("\nInserting 45...");
        tree.insert(45);
        printTree(tree);

        System.out.println("\nInserting 55...");
        tree.insert(55);
        printTree(tree);

        System.out.println("\nInserting 70 (Should trigger color flip)...");
        tree.insert(70);
        printTree(tree);
    }

    private static void printTree(RedBlackTree<Integer> tree) {
        System.out.println("Current Tree Structure:");
        printTreeHelper(tree.root, 0);
    }

    private static void printTreeHelper(RedBlackTree.RBTreeNode<Integer> node, int depth) {
        if (node == null) {
            return;
        }

        printTreeHelper(node.right, depth + 1);

        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }

        if (node.isBlack) {
            System.out.println("B:" + node.item);
        } else {
            System.out.println("R:" + node.item);
        }

        printTreeHelper(node.left, depth + 1);
    }
}