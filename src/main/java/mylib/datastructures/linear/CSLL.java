package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {
    SNode head = getHead();
    SNode tail = getTail();
    int size = getSize();


    public CSLL() {
        super();
    }

    public CSLL(SNode head) {
        super(head);
        tail.setNext(head);
    }

    @Override
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
            tail.setNext(head);
        } else {
            node.setNext(head);
            tail.setNext(node);
            head = node;
        }
        size++;
    }

    @Override
    public void insertTail(SNode node) {
        if (tail == null) {
            head = node;
            tail = node;
            tail.setNext(head);
        } else {
            tail.setNext(node);
            node.setNext(head);
            tail = node;
        }
        size++;
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        } else if (head == tail) {
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
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        } else if (head == tail) {
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

    @Override
    public void clear() {
        super.clear();
        tail = null;
    }
}
