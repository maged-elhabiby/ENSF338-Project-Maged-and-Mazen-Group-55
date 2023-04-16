/**
@author Maged El Habiby <a
href="mailto:maged.elhabiby@ucalgary.ca">maged.elhabiby@ucalgary.ca</a>
@author Mazen El Habiby <a
 href="mailto:mazen.elhabiby@ucalgary.ca">mazen.elhabiby@ucalgary.ca</a>
 */

package mylib.datastructures.tree;
import mylib.datastructures.nodes.TNode;

/**
 * An AVL tree implementation extending the basic binary search tree (BST) class.
 */
public class AVL extends BST{

    /**
     * Default constructor for an empty AVL tree.
     */
    public AVL() {
        super();
    }

    /**
     * Constructor for an AVL tree with a single node containing the specified data value.
     *
     * @param val the data value of the root node
     */
    public AVL(int val) {
        super(val);
    }

    /**
     * Constructor for an AVL tree created from an existing tree node.
     *
     * @param obj the existing tree node
     */
    public AVL(TNode obj) {
        super();
        setRoot(createAVLFromTree(obj));
    }

    /**
     * Sets the root node of this AVL tree after balancing the input node.
     *
     * @param root the input root node
     */
    @Override
    public void setRoot(TNode root) {
        if (root != null) {
            super.setRoot(createAVLFromTree(root));
        } else {
            super.setRoot(null);
        }
    }

    /**
     * Creates a balanced AVL tree from the given tree node.
     *
     * @param node the root node of the tree to balance
     * @return the root node of the balanced AVL tree
     */
    private TNode createAVLFromTree(TNode node) {
        if (node == null) {
            return null;
        }

        TNode newNode = new TNode(node.getData(), 0, null, null, null);
        newNode.setLeft(createAVLFromTree(node.getLeft()));
        newNode.setRight(createAVLFromTree(node.getRight()));
        return balance(newNode);
    }

    /**
     * Inserts a node with the specified data value into this AVL tree and balances the tree.
     *
     * @param val the data value to insert
     */
    @Override
    public void insert(int val) {
        TNode node = new TNode(val, 0, null, null, null);
        insert(node);
    }

    /**
     * Inserts a node into this AVL tree and balances the tree.
     *
     * @param node the node to insert
     */
    @Override
    public void insert(TNode node) {
        super.insert(node);
        setRoot(balance(getRoot()));
    }

    /**
     * Balances the given node in the AVL tree.
     *
     * @param node the node to balance
     * @return the balanced node
     */
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

    /**
     * Computes the balance factor of the given node.
     *
     * @param node the node to compute the balance factor for
     * @return the balance factor of the node
     */
    private int getBalanceFactor(TNode node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    /**
     * Performs a left rotation on the given node.
     *
     * @param node the node to rotate
     * @return the new root node after rotation
     */
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        TNode temp = newRoot.getLeft();

        newRoot.setLeft(node);
        node.setRight(temp);

        return newRoot;
    }

    /**
     * Performs a right rotation on the given node.
     *
     * @param node the node to rotate
     * @return the new root node after rotation
     */
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        TNode temp = newRoot.getRight();

        newRoot.setRight(node);
        node.setLeft(temp);

        return newRoot;
    }

    /**
     * Deletes a node with the specified data value from this AVL tree and balances the tree.
     *
     * @param val the data value to delete
     */
    @Override
    public void delete(int val) {
        if (search(val) != null) {
            super.delete(val);
            setRoot(balanceAfterDeletion(getRoot()));
        } else {
            System.out.println("Value not found in the tree.");
        }
    }

    /**
     * Balances the AVL tree after deletion.
     *
     * @param node the root node of the subtree to balance
     * @return the balanced node after deletion
     */
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