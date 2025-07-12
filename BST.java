
public class BST {
    public Node root;

    class Node {
        int item;
        Node rightNode;
        Node leftNode;

        public Node(int x) {
            this.leftNode = null;
            this.rightNode = null;
            this.item = x;
        }
    }

    private Node addNode(Node T, int x) {
        if (T == null) {
            T = new Node(x);
            return T;
        } else if (x > T.item) {
            T.rightNode = addNode(T.rightNode, x);
        } else if (x < T.item) {
            T.leftNode = addNode(T.leftNode, x);
        }
        return T;
    }

    private Node findNode(Node T, int x) {
        if (T == null) {
            return null;
        }
        if (x > T.item) {
            return findNode(T.rightNode, x);
        } else if (x < T.item) {
            return findNode(T.leftNode, x);
        } else {
            return T;
        }
    }

    private Node removeNode(Node T, int x) {
        if (T == null) {
            return null;
        }
        if (T.item > x) {
            T.leftNode = removeNode(T.leftNode, x);
        } else if (T.item < x) {
            T.rightNode = removeNode(T.rightNode, x);
        } else {
            if (T.leftNode == null) {
                return T.rightNode;
            } else if (T.rightNode == null) {
                return T.leftNode;
            }
            Node successor = findsuccessor(T.rightNode);
            T.item = successor.item;
            T.rightNode = removeNode(T.rightNode, successor.item);
        }
        return T;
    }

    private Node findsuccessor(Node T) {
        if (T.leftNode == null) {
            return T;
        } else {
            return findsuccessor(T.leftNode);
        }
    }

    
    public void add(int x) {
        root = addNode(root, x);
    }

    public void remove(int x) {
        root = removeNode(root, x);
    }

    public Node search(int x) {
        return findNode(root, x);
    }

}