/**
 * A singly linked list (SLL) implementation.
 * This class represents a singly linked list of SNode objects.
 * It provides methods to insert, delete, search, and sort nodes in the list.
 */
package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class SLL {
    private SNode head;
    private SNode tail;
    private int size;
    /**
     * Default constructor.
     * Initializes an empty singly linked list.
     */

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    /**
     * Constructor with a head node.
     * Initializes a singly linked list with a given head node.
     * @param head The head node of the list.
     */
    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    /**
     * Helper method to check if the list is sorted in ascending order.
     * @return true if the list is sorted, false otherwise.
     */
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

    /**
     * Helper method to find the previous node of a given node in the list.
     * @param node The node for which the previous node is to be found.
     * @return The previous node if found, or null if the given node is the head or not found in the list.
     */    
    private SNode findPrevious(SNode node) {
        SNode current = head;
        while (current != null && current.getNext() != node) {
            current = current.getNext();
        }
        return current;
    }
    /**
     * Inserts a node at the head of the list.
     * @param node The node to be inserted.
     */
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
    /**
     * Inserts a node at the tail of the list.
     * @param node The node to be inserted.
     */
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
    /**
     * Inserts a node at a specified position in the list.
     * @param node The node to be inserted.
     * @param position The position at which the node should be inserted (1-indexed).
     * @throws IllegalArgumentException If the position is not valid.
     */
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 1; i < position; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }
    /**
     * Inserts a node into a sorted list while maintaining its sorted order.
     * If the list is not sorted, it will be sorted first.
     * @param node The node to be inserted.
     */
    public void sortedInsert(SNode node) {
        if (!isSorted()) {
            sort();
        }

        if (head == null || head.getData() >= node.getData()) {
            insertHead(node);
        } else {
            SNode current = head;
            SNode previous = null;
    
            while (current != null && current.getData() < node.getData()) {
                previous = current;
                current = current.getNext();
            }
    
            node.setNext(current);
            previous.setNext(node);
    
            if (current == null) {
                tail = node;
            }
    
            size++;
        }
    }
    
    /**
     * Searches for a node in the list.
     * @param node The node to be searched for.
     * @return The node if found, or null if not found.
     */
    public SNode search(SNode node) {
        SNode current = head;
        while (current != null) {
            if (current == node) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }    
    /**
     * Deletes the head node of the list.
     * @throws IllegalStateException If the list is empty.
     */
    public void deleteHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.getNext();
        size--;
    }
    /**
     * Deletes the tail node of the list.
     * @throws IllegalStateException If the list is empty.
     */
    public void deleteTail() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        SNode prev = findPrevious(tail);
        prev.setNext(null);
        tail = prev;
        size--;
    }
    /**
     * Deletes a specified node from the list.
     * @param node The node to be deleted.
     * @throws IllegalStateException If the list is empty.
     * @throws IllegalArgumentException If the node is not found.
     */
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
    /**
     * Sorts the list in ascending order.
     */
    public void sort() {
        if (size <= 1) {
            return;
        }

        SLL sortedList = new SLL();
        SNode current = head;

        while (current != null) {
            SNode next = current.getNext();
            current.setNext(null); // Disconnect the node from the original list
            sortedList.sortedInsert(current);
            current = next;
        }
        head = sortedList.getHead();
        tail = sortedList.getTail();
    }

    /**
     * Removes all nodes from the list.
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Prints the list's length, sorted status, and content.
     */
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
    /**
     * Returns the number of nodes in the list.
     * @return The size of the list.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns the head node of the list.
     * @return The head node.
     */
    public SNode getHead() {
        return this.head;
    }

    /**
     * Returns the tail node of the list.
     * @return The tail node.
     */

    public SNode getTail() {
        return this.tail;
    }
    
}