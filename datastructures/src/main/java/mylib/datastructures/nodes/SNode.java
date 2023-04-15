/**
 * A class representing a node in a singly linked list.
 */
package mylib.datastructures.nodes;

public class SNode {
    private int  data;
    private SNode next;
    /**
     * Constructor that initializes the node with a data value and sets the next pointer to null.
     *
     * @param data the data value of the new node
     */
    public SNode(int data){
        this.data = data;
        this.next = null;
    }
    /**
     * Retrieves the data value of the node.
     *
     * @return the data value of the node
     */
    public int getData(){
        return this.data;
    }
    /**
     * Sets the data value of the node.
     *
     * @param data the new data value of the node
     */
    public void setData(int data) {
        this.data = data;
    }
    /**
     * Retrieves the next node in the singly linked list.
     *
     * @return the next node in the list
     */
    public SNode getNext(){
        return this.next;
    }
    /**
     * Sets the next node in the singly linked list.
     *
     * @param next the new next node in the list
     */
    public void setNext(SNode next){
        this.next = next;
    }
}
