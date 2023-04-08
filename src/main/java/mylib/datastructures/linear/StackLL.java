package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;

public class StackLL <T extends Comparable<T>> extends SLL{
    public StackLL(){
        super();
    }

    public void push(SNode<T> node) {
        super.insertHead(node);
    }

    public SNode<T> pop() {
        SNode<T> node = super.getHead();
        super.deleteHead();
        return node;
    }

    
}
