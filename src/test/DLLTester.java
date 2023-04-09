package test;

import main.java.mylib.datastructures.linear.DLL;
import main.java.mylib.datastructures.nodes.DNode;

public class DLLTester {
    public static void main(String[] args) {
        DLL<Integer> myList = new DLL<Integer>();
        System.out.println("List length: " + myList.isEmpty()); // expected output: List length: true

        // insert nodes at head and tail of the list
        myList.insertHead(new DNode<Integer>(1));
        myList.insertTail(new DNode<Integer>(3));
        myList.insertHead(new DNode<Integer>(0));
        myList.insertTail(new DNode<Integer>(4));

        // print list content
        myList.print(); // expected output: List length: 4, Sorted status: not sorted, List content: 0 <-> 1 <-> 3 <-> 4

        // insert node at specific position
        myList.insert(new DNode<Integer>(2), 2);
        myList.print(); // expected output: List length: 5, Sorted status: not sorted, List content: 0 <-> 1 <-> 2 <-> 3 <-> 4

        // sort list
        myList.sort();
        myList.print(); // expected output: List length: 5, Sorted status: sorted, List content: 0 <-> 1 <-> 2 <-> 3 <-> 4

        // insert node into sorted list
        myList.sortedInsert(new DNode<Integer>(5));
        myList.print(); // expected output: List length: 6, Sorted status: sorted, List content: 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> 5

        // search for a node
        DNode<Integer> node = myList.search(2);
        System.out.println(node); // expected output: DNode@<hashcode>

        // delete head and tail nodes
        myList.deleteHead();
        myList.deleteTail();
        myList.print(); // expected output: List length: 4, Sorted status: sorted, List content: 1 <-> 2 <-> 3 <-> 4

        // delete a specific node
        myList.delete(node);
        myList.print(); // expected output: List length: 3, Sorted status: sorted, List content: 1 <-> 3 <-> 4

        // clear list
        myList.clear();
        myList.print(); // expected output: List length: 0, Sorted status: not sorted, List content:

        System.out.println("List length: " + myList.isEmpty()); // expected output: List length: true
    }
}