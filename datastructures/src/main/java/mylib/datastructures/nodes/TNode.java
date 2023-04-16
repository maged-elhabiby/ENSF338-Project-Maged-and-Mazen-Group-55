package mylib.datastructures.nodes;

public class TNode {
    private int data;
    private int balance;
    private TNode parent;
    private TNode left;
    private TNode right;

    /**
     * Default constructor that initializes an empty node.
     */
    public TNode(){
        this.data = 0;
        this.balance = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    /**
     * Parameterized constructor that initializes a node with specified values.
     * 
     * @param data the data value of the node
     * @param balance the balance factor of the node
     * @param parent the parent node
     * @param left the left child node
     * @param right the right child node
     */
    public TNode(int data, int balance, TNode parent, TNode left, TNode right){
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
        
    /**
     * Returns the data value of this node.
     *
     * @return the data value
     */
    public int getData(){
        return this.data;
    }

    /**
     * Sets the data value of this node.
     *
     * @param data the new data value
     */
    public void setData(int data){
        this.data = data;
    }

    /**
     * Returns the balance factor of this node.
     *
     * @return the balance factor
     */
    public int getBalance(){
        return this.balance;
    }

    /**
     * Sets the balance factor of this node.
     *
     * @param balance the new balance factor
     */
    public void setBalance(int balance){
        this.balance = balance;
    }

    /**
     * Returns the left child node of this node.
     *
     * @return the left child node
     */
    public TNode getLeft(){
        return this.left;
    }

    /**
     * Sets the left child node of this node.
     *
     * @param left the new left child node
     */
    public void setLeft(TNode left){
        this.left = left;
    }

    /**
     * Returns the right child node of this node.
     *
     * @return the right child node
     */
    public TNode getRight(){
        return this.right;
    }

    /**
     * Sets the right child node of this node.
     *
     * @param right the new right child node
     */
    public void setRight(TNode right){
        this.right = right;
    }

    /**
     * Returns the parent node of this node.
     *
     * @return the parent node
     */
    public TNode getParent(){
        return this.parent;
    }

    /**
     * Sets the parent node of this node.
     *
     * @param parent the new parent node
     */
    public void setParent(TNode parent){
        this.parent = parent;
    }

    /**
     * Prints the data and balance factor of this node.
     */
    public void print(){
        System.out.println("Node data: " + this.data);
        System.out.println("Node balance: " + this.balance);
    }

    /**
     * Returns the string representation of this node's data value.
     *
     * @return a string representing the data value
     */
    @Override
    public String toString(){
        return String.valueOf(this.data);
    }

    /**
    * Returns the height of TNode, which is 0.
    */
    public int getHeight() {
        return 0;
    }
}
