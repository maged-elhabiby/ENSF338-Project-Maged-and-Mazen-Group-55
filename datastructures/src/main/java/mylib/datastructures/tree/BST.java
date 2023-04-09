package mylib.datastructures.tree;


import mylib.datastructures.nodes.TNode;

public class BST {
    private TNode root;

    public BST() {
        this.root = null;
    }

    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    public BST(TNode obj) {
        this.root = obj;
    }

    public TNode getRoot() {
        return this.root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public void insert(int val) {
        this.root = insertRec(this.root, val);
    }

    private TNode insertRec(TNode node, int val) {
        if (node == null) {
            return new TNode(val, 0, null, null, null);
        }

        if (val < node.getData()) {
            node.setLeft(insertRec(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(insertRec(node.getRight(), val));
        }

        return node;
    }

    public void insert(TNode node) {
        this.root = insertRec(this.root, node);
    }

    private TNode insertRec(TNode root, TNode node) {
        if (root == null) {
            return node;
        }

        if (node.getData() < root.getData()) {
            root.setLeft(insertRec(root.getLeft(), node));
        } else if (node.getData() > root.getData()) {
            root.setRight(insertRec(root.getRight(), node));
        }

        return root;
    }

    public void delete(int val) {
        this.root = deleteRec(this.root, val);
    }

    private TNode deleteRec(TNode root, int val) {
        if (root == null) {
            System.out.println("Value not found in the tree.");
            return null;
        }

        if (val < root.getData()) {
            root.setLeft(deleteRec(root.getLeft(), val));
        } else if (val > root.getData()) {
            root.setRight(deleteRec(root.getRight(), val));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            root.setData(minValue(root.getRight()));
            root.setRight(deleteRec(root.getRight(), root.getData()));
        }
        return root;
    }

    private int minValue(TNode node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    public TNode search(int val) {
        return searchRec(this.root, val);
    }

    private TNode searchRec(TNode node, int val) {
        if (node == null || node.getData() == val) {
            return node;
        }

        if (val < node.getData()) {
            return searchRec(node.getLeft(), val);
        }
        return searchRec(node.getRight(), val);
    }

    public void printInOrder() {
        printInOrderRec(this.root);
        System.out.println();
    }

    private void printInOrderRec(TNode node) {
        if (node != null) {
            printInOrderRec(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrderRec(node.getRight());
        }
    }
    public void printBF() {
        int height = getHeight(this.root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(this.root, i);
            System.out.println();
        }
    }

    private void printGivenLevel(TNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.getData() + " ");
        } else if (level > 1) {
            printGivenLevel(node.getLeft(), level - 1);
            printGivenLevel(node.getRight(), level - 1);
        }
    }

    public int getHeight(TNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}



