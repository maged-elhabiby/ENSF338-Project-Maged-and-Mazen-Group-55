/**
 * A Queue data structure implementation using a Singly Linked List (SLL) as the underlying data structure.
 */

package mylib.datastructures.linear;
import mylib.datastructures.nodes.SNode;


public class QueueLL extends SLL{
    /**
     * Default constructor that initializes the queue with a null head object.
     */
    public QueueLL() {
        super();
    }
    /**
     * Overloaded constructor that creates a queue with the given head node.
     *
     * @param head the head node of the new queue
     */
    public QueueLL(SNode head) {
        super(head);
    }
    /**
     * This method is overridden to prevent its misuse in the queue implementation.
     */
    @Override
    public void insertHead(SNode node) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the queue implementation.
     */
    @Override
    public void insert(SNode node, int position) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the queue implementation.
     */
    @Override
    public void sortedInsert(SNode node) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the queue implementation.
     */
    @Override
    public void deleteTail() {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the queue implementation.
     */
    @Override
    public void delete(SNode node) {
        // Override with empty body to prevent misuse
    }
    /**
     * This method is overridden to prevent its misuse in the queue implementation.
     */
    @Override
    public void sort() {
        // Override with empty body to prevent misuse
    }
    /**
     * Adds a new node to the tail of the queue.
     *
     * @param node the node to be added to the queue
     */
    public void enqueue(SNode node) {
        super.insertTail(node);
    }
    /**
     * Removes and returns the head node from the queue.
     *
     * @return the head node of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public SNode dequeue() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        SNode headNode = super.getHead();
        super.deleteHead();
        return headNode;
    }
    /**
     * Returns the head node of the queue without removing it.
     *
     * @return the head node of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public SNode peek() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return super.getHead();
    }
}
