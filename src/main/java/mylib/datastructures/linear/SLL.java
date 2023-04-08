package main.java.mylib.datastructures.linear;

import java.util.Comparator;

import main.java.mylib.datastructures.nodes.SNode;

public class SLL<T> {
    private SNode<T> head;
    private SNode<T> tail;
    private int size;
    private Comparator<T> comparator;

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.comparator = null;
    }

    public SLL(Comparator<T> comparator) {
        this();
        this.comparator = comparator;
    }

    public SLL(SNode<T> node) {
        this.head = node;
        this.tail = node;
        this.size = 1;
        this.comparator = null;
    }

    public SLL(SNode<T> node, Comparator<T> comparator) {
        this(node);
        this.comparator = comparator;
    }

    public SNode<T> getTail() {
        return tail;
    }
    public SNode<T> getHead() {
        return head;
    }
    public void insertHead(SNode<T> node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(SNode<T> node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(SNode<T> node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode<T> current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    public void sortedInsert(SNode<T> node) {
        if (comparator == null) {
            throw new IllegalStateException("Comparator not set");
        }

        if (!isSorted()) {
            sort();
        }

        if (isEmpty() || comparator.compare(node.getData(), head.getData()) < 0) {
            insertHead(node);
        } else {
            SNode<T> current = head;
            while (current.getNext() != null && comparator.compare(node.getData(), current.getNext().getData()) > 0) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            if (current == tail) {
                tail = node;
            }
            size++;
        }
    }

    public SNode<T> search(T data) {
        SNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void deleteTail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (head == tail) {
            head = tail = null;
        } else {
            SNode<T> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            tail.setNext(null);
        }
        size--;
    }

    public void delete(T data) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (head.getData().equals(data)) {
            deleteHead();
        } else {
            SNode<T> current = head;
            while (current.getNext() != null && !current.getNext().getData().equals(data)) {
                current = current.getNext();
            }
    
            if (current.getNext() != null) {
                if (current.getNext() == tail) {
                    tail = current;
                }
                current.setNext(current.getNext().getNext());
                size--;
            }
        }
    }
    
    public void sort() {
        if (comparator == null) {
            throw new IllegalStateException("Comparator not set");
        }
    
        if (size <= 1) {
            return;
        }
    
        SNode<T> current = head;
        while (current != null) {
            SNode<T> next = current.getNext();
            while (next != null) {
                if (comparator.compare(current.getData(), next.getData()) > 0) {
                    T temp = current.getData();
                    current.setData(next.getData());
                    next.setData(temp);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }
    
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    public void print() {
        System.out.println("List length: " + size);
        System.out.println("Sorted status: " + (isSorted() ? "Sorted" : "Unsorted"));
        System.out.print("List content: ");
    
        SNode<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + (current.getNext() != null ? " -> " : ""));
            current = current.getNext();
        }
        System.out.println();
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public boolean isSorted() {
        if (comparator == null) {
            throw new IllegalStateException("Comparator not set");
        }
    
        SNode<T> current = head;
        while (current != null && current.getNext() != null) {
            if (comparator.compare(current.getData(), current.getNext().getData()) > 0) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
    
    public int getSize() {
        return size;
    }
}    
