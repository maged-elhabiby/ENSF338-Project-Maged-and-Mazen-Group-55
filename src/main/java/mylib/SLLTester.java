package main.java.mylib;

import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;

public class SLLTester {
    public static void main(String[] args) {
        SLL<Integer> myList = new SLL<Integer>();
        System.out.println("List length: " + myList.isEmpty()); // expected output: List length: true

        // insert nodes at head and tail of the list
        myList.insertHead(new SNode<Integer>(1));
        myList.insertTail(new SNode<Integer>(3));
        myList.insertHead(new SNode<Integer>(0));
        myList.insertTail(new SNode<Integer>(4));

        // print list content
        myList.print(); // expected output: List length: 4, Sorted status: not sorted, List content: 0 -> 1 -> 3 -> 4

        // insert node at specific position
        myList.insert(new SNode<Integer>(2), 2);
        myList.print(); // expected output: List length: 5, Sorted status: not sorted, List content: 0 -> 1 -> 2 -> 3 -> 4

        // sort list
        myList.sort();
        myList.print(); // expected output: List length: 5, Sorted status: sorted, List content: 0 -> 1 -> 2 -> 3 -> 4

        // insert node into sorted list
        myList.sortedInsert(new SNode<Integer>(5));
        myList.print(); // expected output: List length: 6, Sorted status: sorted, List content: 0 -> 1 -> 2 -> 3 -> 4 -> 5

        // search for a node
        SNode<Integer> node = myList.search(2);
        System.out.println(node); // expected output: SNode@<hashcode>

        // delete head and tail nodes
        myList.deleteHead();
        myList.deleteTail();
        myList.print(); // expected output: List length: 4, Sorted status: sorted, List content: 1 -> 2 -> 3 -> 4

        // delete a specific node
        myList.delete(node);
        myList.print(); // expected output: List length: 3, Sorted status: sorted, List content: 1 -> 3 -> 4

        // clear list
        myList.clear();
        myList.print(); // expected output: List length: 0, Sorted status: not sorted, List content:

        System.out.println("List length: " + myList.isEmpty()); // expected output: List length: true
    }
}
