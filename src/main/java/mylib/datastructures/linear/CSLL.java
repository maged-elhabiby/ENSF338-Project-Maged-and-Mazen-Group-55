package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL<T extends Comparable<T>> extends SLL<T> {
    private SNode<T> head;
    private SNode<T> tail;
    private int size;

    public CSLL() {
        super();
    }

    public CSLL(SNode<T> head) {
        super(head);
        this.tail.setNext(this.head); // make the list circular
    }

    @Override
    public void insertHead(SNode<T> node) {
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            node.setNext(this.head); // make the list circular
        } else {
            node.setNext(this.head);
            this.head = node;
            this.tail.setNext(this.head); // update tail reference to make the list circular
        }
        this.size++;
    }

    @Override
    public void insertTail(SNode<T> node) {
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            node.setNext(this.head); // make the list circular
        } else {
            node.setNext(this.head);
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    @Override
    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        this.head = this.head.getNext();
        this.tail.setNext(this.head); // update tail reference to make the list circular
        this.size--;
        if (isEmpty()) {
            this.tail = null;
        }
    }

    @Override
    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    
        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            SNode<T> current = this.head;
            while (current.getNext() != this.tail) {
                current = current.getNext();
            }
            current.setNext(this.head); // update next reference of second last node to make the list circular
            this.tail = current;
        }
        this.size--;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "sorted" : "not sorted"));
    
        System.out.print("List content: ");
        SNode<T> current = this.head;
        for (int i = 0; i < size; i++) { // use size variable to loop through the list
            System.out.print(current.getData());
            if (current.getNext() != this.head) { // check if we've reached the end of the circular list
                System.out.print(" -> ");
                current = current.getNext();
            } else {
                break;
            }
        }
        System.out.println();
    }
    
}
