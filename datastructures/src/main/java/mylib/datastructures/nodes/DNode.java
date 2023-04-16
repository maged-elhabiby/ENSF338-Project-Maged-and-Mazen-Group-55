/**
@author Maged El Habiby <a
href="mailto:maged.elhabiby@ucalgary.ca">maged.elhabiby@ucalgary.ca</a>
@author Mazen El Habiby <a
 href="mailto:mazen.elhabiby@ucalgary.ca">mazen.elhabiby@ucalgary.ca</a>
 */

package mylib.datastructures.nodes;

/**
 * A class representing a node in a doubly linked list.
 */
public class DNode {
    private int data;
    private DNode prev;
    private DNode next;
    /**
     * Constructor that initializes the node with a data value and sets the previous and next pointers to null.
     *
     * @param data the data value of the new node
     */
    public DNode(int data){
        this.data = data;
        this.prev = null;
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
    public void setData(int data){
        this.data = data;
    }
    /**
     * Retrieves the previous node in the doubly linked list.
     *
     * @return the previous node in the list
     */
    public DNode getPrev(){
        return this.prev;
    }
    /**
     * Sets the previous node in the doubly linked list.
     *
     * @param prev the new previous node in the list
     */
    public void setPrev(DNode prev){
        this.prev = prev;
    }
    /**
     * Retrieves the next node in the doubly linked list.
     *
     * @return the next node in the list
     */
    public DNode getNext(){
        return this.next;
    }
    /**
     * Sets the next node in the doubly linked list.
     *
     * @param next the new next node in the list
     */
    public void setNext(DNode next){
        this.next = next;
    }
}
