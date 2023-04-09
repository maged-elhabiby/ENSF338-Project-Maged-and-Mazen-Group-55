package main.java.mylib.datastructures.tree;
import main.java.mylib.datastructures.nodes.TNode;

public class AVL extends BST{
    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
    }

    public AVL(TNode obj) {
        super();
        setRoot(createAVLFromTree(obj));
    }

    @Override
    public void setRoot(TNode root) {
        if (root != null) {
            super.setRoot(createAVLFromTree(root));
        } else {
            super.setRoot(null);
        }
    }

    private TNode createAVLFromTree(TNode node) {
        if (node == null) {
            return null;
        }

        TNode newNode = new TNode(node.getData(), 0, null, null, null);
        newNode.setLeft(createAVLFromTree(node.getLeft()));
        newNode.setRight(createAVLFromTree(node.getRight()));
        return balance(newNode);
    }

    @Override
    public void insert(int val) {
        TNode node = new TNode(val, 0, null, null, null);
        insert(node);
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        setRoot(balance(getRoot()));
    }

    private TNode balance(TNode node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }

        node.setLeft(balance(node.getLeft()));
        node.setRight(balance(node.getRight()));

        return node;
    }

    private int getBalanceFactor(TNode node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        TNode temp = newRoot.getLeft();

        newRoot.setLeft(node);
        node.setRight(temp);

        return newRoot;
    }

    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        TNode temp = newRoot.getRight();

        newRoot.setRight(node);
        node.setLeft(temp);

        return newRoot;
    }

    @Override
    public void delete(int val) {
        if (search(val) != null) {
            super.delete(val);
            setRoot(balanceAfterDeletion(getRoot()));
        } else {
            System.out.println("Value not found in the tree.");
        }
    }

    private TNode balanceAfterDeletion(TNode node) {
        if (node == null) {
            return null;
        }

        int balanceFactor = getBalanceFactor(node);

        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) <= 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) >= 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }

        node.setLeft(balanceAfterDeletion(node.getLeft()));
        node.setRight(balanceAfterDeletion(node.getRight()));

        return node;
    }
}