package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    // Update the default constructor to initialize the circular list with a null head object
    public CSLL() {
        super();
    }

    // Update the overloaded constructor to create a circular list with the given head node
    public CSLL(SNode head) {
        super(head);
        getTail().setNext(head);
    }

    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
        getTail().setNext(getHead());
    }

    @Override
    public void insertTail(SNode node) {
        super.insertTail(node);
        getTail().setNext(getHead());
    }

    @Override
    public void insert(SNode node, int position) {
        super.insert(node, position);
        if (position == getSize()) {
            getTail().setNext(getHead());
        }
    }

    @Override
    public void deleteHead() {
        if (getSize() == 1) {
            clear();
        } else {
            super.deleteHead();
            getTail().setNext(getHead());
        }
    }

    @Override
    public void deleteTail() {
        if (getSize() == 1) {
            clear();
        } else {
            super.deleteTail();
            getTail().setNext(getHead());
        }
    }

   
}
