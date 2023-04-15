/**
 * A Circular Doubly Linked List (CDLL) data structure that extends the Doubly Linked List (DLL).
 * Both the head and tail nodes point to each other, creating a circular list.
 */
package mylib.datastructures.linear;
import mylib.datastructures.nodes.DNode;

public class CDLL extends DLL {

    /**
     * Default constructor that initializes the circular list with a null head object.
     */
    public CDLL() {
        super();
    }

    /**
     * Overloaded constructor that creates a circular list with the given head node.
     *
     * @param head the head node of the new circular list
     */
    public CDLL(DNode head) {
        super(head);
        head.setNext(head);
        head.setPrev(head);
    }

    /**
     * Inserts a node at the head of the circular list.
     *
     * @param node the node to be inserted at the head
     */
    @Override
    public void insertHead(DNode node) {
        if (getSize() == 0) {
            super.insertHead(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            super.insertHead(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }

    /**
     * Inserts a node at the tail of the circular list.
     *
     * @param node the node to be inserted at the tail
     */
    @Override
    public void insertTail(DNode node) {
        if (getSize() == 0) {
            super.insertTail(node);
            node.setNext(node);
            node.setPrev(node);
        } else {
            super.insertTail(node);
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }

    /**
     * Deletes the head node of the circular list.
     */
    @Override
    public void deleteHead() {
        if (getSize() == 0) {
            throw new IllegalStateException("List is empty");
        } else if (getSize() == 1) {
            clear();
        } else {
            super.deleteHead();
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }

    /**
     * Deletes the tail node of the circular list.
     */
    @Override
    public void deleteTail() {
        if (getSize() == 0) {
            throw new IllegalStateException("List is empty");
        } else if (getSize() == 1) {
            clear();
        } else {
            super.deleteTail();
            getHead().setPrev(getTail());
            getTail().setNext(getHead());
        }
    }
}
