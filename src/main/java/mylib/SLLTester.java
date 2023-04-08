package main.java.mylib;
import main.java.mylib.datastructures.linear.SLL;
import main.java.mylib.datastructures.nodes.SNode;

public class SLLTester {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<>();
        list.insertHead(new SNode<>(2));
        list.insertHead(new SNode<>(1));
        list.insertTail(new SNode<>(4));
        list.insertTail(new SNode<>(3));
        list.insert(new SNode<>(5), 2);
        list.sortedInsert(new SNode<>(0));

        list.print(); // expected output: List length: 6, Sorted status: Sorted, List content: 0 -> 1 -> 2 -> 5 -> 3 -> 4

        list.deleteHead();
        list.deleteTail();
        list.delete(new Integer(2));

        list.print(); // expected output: List length: 3, Sorted status: Unsorted, List content: 1 -> 5 -> 3

        list.sort();
        list.print(); // expected output: List length: 3, Sorted status: Sorted, List content: 1 -> 3 -> 5

        SNode<Integer> node = list.search(3);
        if (node != null) {
            System.out.println("Node found: " + node.getData()); // expected output: Node found: 3
        } else {
            System.out.println("Node not found");
        }

        list.clear();
        list.print(); // expected output: List length: 0, Sorted status: Unsorted, List content: 
    }
}
