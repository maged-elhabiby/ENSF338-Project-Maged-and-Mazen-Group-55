/**
@author Maged El Habiby <a
href="mailto:maged.elhabiby@ucalgary.ca">maged.elhabiby@ucalgary.ca</a>
@author Mazen El Habiby <a
 href="mailto:mazen.elhabiby@ucalgary.ca">mazen.elhabiby@ucalgary.ca</a>
 */

package mylib.datastructures.tree;
import mylib.datastructures.nodes.TNode;

/**
 * A class representing a binary search tree (BST) data structure.
*/ 
public class BST {
    private TNode root;

/**
     * Default constructor that initializes an empty BST.
     */
    public BST() {
        this.root = null;
    }

    /**
     * Parameterized constructor that initializes a BST with a single node.
     *
     * @param val the data value of the root node
     */
    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);
    }

    /**
     * Parameterized constructor that initializes a BST with a given root node.
     *
     * @param obj the root node
     */
    public BST(TNode obj) {
        this.root = obj;
    }

    /**
     * Returns the root node of this BST.
     *
     * @return the root node
     */
    public TNode getRoot() {
        return this.root;
    }

    /**
     * Sets the root node of this BST.
     *
     * @param root the new root node
     */
    public void setRoot(TNode root) {
        this.root = root;
    }


    /**
     * Inserts a new node with the specified data value into this BST.
     * 
     * @param val the data value to insert
     */
    public void insert(int val) {
        this.root = insertRec(this.root, val);
    }

    /**
     * A helper method to recursively insert a new node with the specified data value into the BST.
     * 
     * @param node the current node
     * @param val the data value to insert
     * @return the updated node after insertion
     */
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

    /**
     * Inserts a new node into this BST.
     * 
     * @param node the node to insert
     */
    public void insert(TNode node) {
        this.root = insertRec(this.root, node);
    }

    /**
     * A helper method to recursively insert a new node into the BST.
     * 
     * @param root the current root node
     * @param node the node to insert
     * @return the updated root node after insertion
     */
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

    /**
     * Deletes a node with the specified data value from this BST.
     * 
     * @param val the data value to delete
     */
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

    /**
     * Finds the minimum data value in the subtree rooted at the given node.
     *
     * @param node the root node of the subtree to search for the minimum value
     * @return the minimum data value in the subtree
     */
    private int minValue(TNode node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    /**
     * Searches for a node with the specified data value in this BST.
     *
     * @param val the data value to search for
     * @return the node with the specified data value if found, null otherwise
     */
    public TNode search(int val) {
        return searchRec(this.root, val);
    }

    /**
     * A helper method to recursively search for a node with the specified data value in the BST.
     *
     * @param node the current node
     * @param val the data value to search for
     * @return the node with the specified data value if found, null otherwise
     */
    private TNode searchRec(TNode node, int val) {
        if (node == null || node.getData() == val) {
            return node;
        }

        if (val < node.getData()) {
            return searchRec(node.getLeft(), val);
        }
        return searchRec(node.getRight(), val);
    }

    /**
     * Prints the data values of this BST in in-order traversal.
     */  
    public void printInOrder() {
        printInOrderRec(this.root);
        System.out.println();
    }

    /**
     * A helper method to recursively print the data values of the BST in in-order traversal.
     *
     * @param node the current node
     */
    private void printInOrderRec(TNode node) {
        if (node != null) {
            printInOrderRec(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrderRec(node.getRight());
        }
    }


    /**
     * Prints the data values of this BST in a breadth-first manner.
     */
    public void printBF() {
        int height = getHeight(this.root);
        for (int i = 1; i <= height; i++) {
            printGivenLevel(this.root, i);
            System.out.println();
        }
    }

    /**
     * A helper method to print the data values of the BST at the specified level.
     *
     * @param node the current node
     * @param level the level to print the data values from
     */
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

    /**
     * Returns the height of this BST.
     *
     * @param node the current node
     * @return the height of the BST
     */
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



