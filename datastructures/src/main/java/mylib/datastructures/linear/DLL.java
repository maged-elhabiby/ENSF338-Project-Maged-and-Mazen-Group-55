package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

public class DLL {
    private DNode head;
    private DNode tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        size++;
    }

    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    public void insert(DNode node, int position) {
        if (position <= 0 || position > size + 1) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (position == 1) {
            insertHead(node);
        } else if (position == size + 1) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.getNext().setPrev(node);
            current.setNext(node);
            size++;
        }
    }

    public DNode search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void sort() {
        if (size <= 1) {
            return;
        }
    
        // Create a new list to store the sorted nodes
        DLL sortedList = new DLL();
    
        // Iterate through the original list and use sortedInsert() for each node
        DNode current = head;
        while (current != null) {
            DNode next = current.getNext();
    
            // Detach the current node from the original list
            current.setNext(null);
            current.setPrev(null);
    
            // Insert the current node into the sorted list
            sortedList.sortedInsert(current);
    
            current = next;
        }
    
        // Replace the original list with the sorted list
        head = sortedList.getHead();
        tail = sortedList.getTail();
        size = sortedList.getSize();
    }
    

    public void sortedInsert(DNode node) {
        if (head == null || head.getData() >= node.getData()) {
            node.setNext(head);
            if (head != null) {
                head.setPrev(node);
            }
            head = node;
            if (tail == null) {
                tail = node;
            }
            size++;
        } else {
            DNode current = head;
            while (current.getNext() != null && current.getNext().getData() < node.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            current.setNext(node);
            if (node.getNext() != null) {
                node.getNext().setPrev(node);
            } else {
                tail = node;
            }
            size++;
        }
    }

    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        }
        size--;
    }

    public void deleteTail() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        DNode prev = tail.getPrev();
        if (prev != null) {
            prev.setNext(null);
        }
        tail = prev;
        size--;
    }

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

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void print() {
        System.out.println("List length: " + size);
        System.out.print("List content: ");
        DNode current = head;
        while (current != null) {
            System.out.print(current.getData() + (current.getNext() != null ? " <-> " : ""));
            current = current.getNext();
        }
        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    public DNode getHead() {
        return this.head;
    }

    public DNode getTail() {
        return this.tail;
    }
}
