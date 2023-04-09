package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {
    DNode head = getHead();
    DNode tail = getTail();
    int size = getSize();

    public CDLL() {
        super();
        head.setPrev(tail);
        tail.setNext(head);
    }

    public CDLL(DNode node) {
        super(node);
        head.setPrev(tail);
        tail.setNext(head);
        head.setNext(head);
        head.setPrev(head);
    }

    @Override
    public void insertHead(DNode node) {
        if (head == null) {
            super.insertHead(node);
            head.setPrev(tail);
            tail.setNext(head);
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
            head.setPrev(tail);
            tail.setNext(head);
        }
        size++;
    }

    @Override
    public void insertTail(DNode node) {
        if (tail == null) {
            super.insertTail(node);
            head.setPrev(tail);
            tail.setNext(head);
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            head.setPrev(tail);
            tail.setNext(head);
        }
        size++;
    }

    @Override
    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext();
        head.setPrev(tail);
        tail.setNext(head);
        size--;
    }

    @Override
    public void deleteTail() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        tail = tail.getPrev();
        tail.setNext(head);
        head.setPrev(tail);
        size--;
    }

    @Override
    public void delete(DNode node) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head == node) {
            deleteHead();
        } else if (tail == node) {
            deleteTail();
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
        }
    }

    @Override
    public void clear() {
        super.clear();
        head.setPrev(tail);
        tail.setNext(head);
    }
}
