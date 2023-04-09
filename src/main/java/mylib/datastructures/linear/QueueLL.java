package main.java.mylib.datastructures.linear;
import main.java.mylib.datastructures.nodes.SNode;


public class QueueLL extends SLL{
    public QueueLL() {
        super();
    }

    public QueueLL(SNode head) {
        super(head);
    }

    @Override
    public void insertHead(SNode node) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void insert(SNode node, int position) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void sortedInsert(SNode node) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void deleteTail() {
        // Override with empty body to prevent misuse
    }

    @Override
    public void delete(SNode node) {
        // Override with empty body to prevent misuse
    }

    @Override
    public void sort() {
        // Override with empty body to prevent misuse
    }

    public void enqueue(SNode node) {
        super.insertTail(node);
    }

    public SNode dequeue() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        SNode headNode = super.getHead();
        super.deleteHead();
        return headNode;
    }

    public SNode peek() {
        if (super.getSize() == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return super.getHead();
    }
}
