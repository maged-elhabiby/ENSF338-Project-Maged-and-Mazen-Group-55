package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {
   


    public CSLL() {
        super();
    }

    public CSLL(SNode head) {
        super(head);
        head.setNext(head);
    }

    @Override
    public void insertHead(SNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            node.setNext(node);
        } else {
            node.setNext(head);
            tail.setNext(node);
            head = node;
        }
        size++;
    }

    @Override
    public void insertTail(SNode node) {
        if (isEmpty()) {
            head = node;
            tail = node;
            node.setNext(node);
        } else {
            node.setNext(head);
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    @Override
    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail.setNext(head.getNext());
            head = head.getNext();
        }
        size--;
    }

    @Override
    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            SNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(head);
            tail = current;
        }
        size--;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}