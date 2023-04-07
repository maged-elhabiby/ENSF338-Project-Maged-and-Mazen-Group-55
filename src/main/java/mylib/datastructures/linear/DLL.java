package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL<T extends Comparable<T>> extends SLL<T>{
    private DNode head;
    private DNode tail;

    public DLL(){
        this.head = null;
        this.tail = null;
    }
    
    public DLL(DNode<T> head){
        super(head);
        this.head = head;
        this.tail = head;
    }

    @Override
    public void insertHead(Node<T> node)
}
