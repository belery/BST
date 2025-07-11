public class BSTDebugger {
    public static void main(String[] args) {
        BST tree = new BST();

        System.out.println("=== 测试1: 空树操作 ===");
        testSearch(tree, 5, false);
        testRemove(tree, 5, "空树删除");

        System.out.println("\n=== 测试2: 单节点操作 ===");
        tree.add(5);
        System.out.println("添加5后的树结构:");
        printTree(tree.root);
        testSearch(tree, 5, true);
        testSearch(tree, 3, false);

        System.out.println("\n删除5:");
        tree.remove(5);
        testSearch(tree, 5, false);
        System.out.println("删除后的树结构:");
        printTree(tree.root);

        System.out.println("\n=== 测试3: 多节点添加 ===");
        int[] values = { 5, 3, 7, 2, 4, 6, 8 };
        for (int val : values) {
            tree.add(val);
        }
        System.out.println("添加序列 [5,3,7,2,4,6,8] 后的树结构:");
        printTree(tree.root);

        System.out.println("\n=== 测试4: 搜索测试 ===");
        testSearch(tree, 5, true);
        testSearch(tree, 3, true);
        testSearch(tree, 7, true);
        testSearch(tree, 4, true);
        testSearch(tree, 9, false);
        testSearch(tree, 1, false);

        System.out.println("\n=== 测试5: 删除叶子节点 ===");
        System.out.println("删除叶子节点2:");
        tree.remove(2);
        testSearch(tree, 2, false);
        printTree(tree.root);

        System.out.println("\n删除叶子节点8:");
        tree.remove(8);
        testSearch(tree, 8, false);
        printTree(tree.root);

        System.out.println("\n=== 测试6: 删除单子节点 ===");
        System.out.println("删除节点3 (有左子节点2):");
        tree.add(2); // 重新添加节点2
        printTree(tree.root);
        System.out.println("\n删除节点3:");
        tree.remove(3);
        testSearch(tree, 3, false);
        printTree(tree.root);

        System.out.println("\n=== 测试7: 删除双子节点 ===");
        System.out.println("当前树结构:");
        tree.add(3); // 重建原始结构
        tree.add(8);
        printTree(tree.root);

        System.out.println("\n删除根节点5:");
        tree.remove(5);
        testSearch(tree, 5, false);
        printTree(tree.root);

        System.out.println("\n=== 测试8: 删除不存在的节点 ===");
        testRemove(tree, 10, "删除不存在节点");
        printTree(tree.root);

        System.out.println("\n=== 最终树结构 ===");
        printTree(tree.root);
    }

    private static void testSearch(BST tree, int value, boolean shouldExist) {
        BST.Node node = tree.search(value);
        boolean found = (node != null);

        System.out.printf("搜索 %d: %s - %s%n",
                value,
                found ? "找到" : "未找到",
                (found == shouldExist) ? "✓" : ("✗ 期望: " + (shouldExist ? "存在" : "不存在")));
    }

    private static void testRemove(BST tree, int value, String testName) {
        System.out.println(testName + ":");
        tree.remove(value);
    }

    // 打印树结构（简单可视化）
    private static void printTree(BST.Node root) {
        System.out.println("当前BST结构:");
        printTreeHelper(root, 0);
    }

    private static void printTreeHelper(BST.Node node, int depth) {
        if (node == null) {
            printIndent(depth);
            System.out.println("null");
            return;
        }

        // 打印右子树
        printTreeHelper(node.rightNode, depth + 1);

        // 打印当前节点
        printIndent(depth);
        System.out.println(node.item);

        // 打印左子树
        printTreeHelper(node.leftNode, depth + 1);
    }

    private static void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
    }
}
