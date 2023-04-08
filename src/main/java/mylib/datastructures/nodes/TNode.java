package main.java.mylib.datastructures.nodes;

public class TNode {
    private int data;
    private int balance;
    private TNode parent;
    private TNode left;
    private TNode right;
    
    public TNode(){
        this.data = 0;
        this.balance = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public TNode(int data, int balance, TNode parent, TNode left, TNode right){
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    
    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getBalance(){
        return this.balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public TNode getLeft(){
        return this.left;
    }

    public void setLeft(TNode left){
        this.left = left;
    }

    public TNode getRight(){
        return this.right;
    }

    public void setRight(TNode right){
        this.right = right;
    }

    public TNode getParent(){
        return this.parent;
    }

    public void setParent(TNode parent){
        this.parent = parent;
    }

    // Print node information
    public void print(){
        System.out.println("Node data: " + this.data);
        System.out.println("Node balance: " + this.balance);
    }
    @Override
    public String toString(){
        return String.valueOf(this.data);
    }

    public int getHeight() {
        return 0;
    }
}
