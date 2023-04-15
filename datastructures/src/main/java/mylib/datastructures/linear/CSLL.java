/**
 * A Circular Singly Linked List (CSLL) data structure that extends the Singly Linked List (SLL).
 * The last node in the list points back to the head node, creating a circular list.
 */
package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    /**
     * Default constructor that initializes the circular list with a null head object.
     */
    public CSLL() {
        super();
    }
    /**
     * Overloaded constructor that creates a circular list with the given head node.
     *
     * @param head the head node of the new circular list
     */
    public CSLL(SNode head) {
        super(head);
        getTail().setNext(head);
    }
    /**
     * Inserts a node at the head of the circular list.
     *
     * @param node the node to be inserted at the head
     */
    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
        getTail().setNext(getHead());
    }
    /**
     * Inserts a node at the tail of the circular list.
     *
     * @param node the node to be inserted at the tail
     */
    @Override
    public void insertTail(SNode node) {
        super.insertTail(node);
        getTail().setNext(getHead());
    }
    /**
     * Inserts a node at the specified position in the circular list.
     *
     * @param node the node to be inserted
     * @param position the position at which the node should be inserted (1-indexed)
     */
    @Override
    public void insert(SNode node, int position) {
        super.insert(node, position);
        if (position == getSize()) {
            getTail().setNext(getHead());
        }
    }
    /**
     * Deletes the head node of the circular list.
     */
    @Override
    public void deleteHead() {
        if (getSize() == 1) {
            clear();
        } else {
            super.deleteHead();
            getTail().setNext(getHead());
        }
    }
    /**
     * Deletes the tail node of the circular list.
     */
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
