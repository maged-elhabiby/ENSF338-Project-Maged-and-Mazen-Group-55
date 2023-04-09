package main.java.mylib.datastructures.linear;

import main.java.mylib.datastructures.nodes.SNode;

public class SLL {
    private SNode head;
    private SNode tail;
    private int size;

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    // Helper method to check if the list is sorted
    private boolean isSorted() {
        if (size <= 1) {
            return true;
        }
        SNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    // Helper method to find the previous node of a given node
    private SNode findPrevious(SNode node) {
        SNode current = head;
        while (current != null && current.getNext() != node) {
            current = current.getNext();
        }
        return current;
    }

    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(SNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(SNode node, int position) {
        if (position <= 0 || position > size + 1) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public void sortedInsert(SNode node) {
        if (!isSorted()) {
            sort();
        }

        if (head == null || head.getData() >= node.getData()) {
            insertHead(node);
        } else {
            SNode current = head;
            while (current.getNext() != null && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public SNode search(int data) {
        SNode current = head;
        while (current != null) {
            if (current.getData() == data) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext();
        size--;
    }

    public void deleteTail() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        SNode prev = findPrevious(tail);
        prev.setNext(null);
        tail = prev;
        size--;
    }

    public void delete(SNode node) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head == node) {
            deleteHead();
        } else {
            SNode prev = findPrevious(node);
            if (prev == null) {
                throw new IllegalArgumentException("Node not found");
            }
            prev.setNext(node.getNext());
            if (tail == node) {
                tail = prev;
            }
            size--;
        }
    }

    public void sort() {
        if (size <= 1) {
            return;
        }

        SNode sorted = null;
        SNode current = head;

        while (current != null) {
            SNode next = current.getNext();
            sortedInsert(current);
            current = next;
        }
        head = sorted;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Not sorted"));

        System.out.print("List content: ");
        SNode current = head;
        while (current != null) {
            System.out.print(current.getData() + (current.getNext() != null ? " -> " : ""));
            current = current.getNext();
        }
        System.out.println();
    }
    public int getSize() {
        return this.size;
    }

    public SNode getHead() {
        return this.head;
    }

    public SNode getTail() {
        return this.tail;
    }
    
    
}

