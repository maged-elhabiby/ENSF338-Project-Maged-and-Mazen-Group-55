/**
 * A Stack data structure implementation using a Singly Linked List (SLL) as the underlying data structure.
 */
package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL {
    /**
     * Default constructor that initializes the stack with a null head object.
     */
    public StackLL() {
        super();
    }
    /**
     * Overloaded constructor that creates a stack with the given head node.
     *
     * @param head the head node of the new stack
     */
    public StackLL(SNode head) {
        super(head);
    }
    /**
     * This method is overridden to prevent its misuse in the stack implementation.
     */
    @Override
    public void insertTail(SNode node) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the stack implementation.
     */
    @Override
    public void insert(SNode node, int position) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the stack implementation.
     */
    @Override
    public void sortedInsert(SNode node) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the stack implementation.
     */
    @Override
    public void deleteTail() {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the stack implementation.
     */
    @Override
    public void delete(SNode node) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the stack implementation.
     */
    @Override
    public void sort() {
        // Override with empty body to prevent misuse
    }

    /**
     * Adds a new node to the top of the stack.
     *
     * @param node the node to be added to the stack
     */
    public void push(SNode node) {
        super.insertHead(node);
    }
    /**
     * Removes and returns the top node from the stack.
     *
     * @return the top node of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public SNode pop() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        SNode headNode = super.getHead();
        super.deleteHead();
        return headNode;
    }
    /**
     * Returns the top node of the stack without removing it.
     *
     * @return the top node of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public SNode peek() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        return super.getHead();
    }
}
