 /**
    *             Assignment1, COMP272
    * Class:      TestSinglyLinkedList.java
    * Purpose:    Tests the SinglyLinkedList class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class TestSinglyLinkedList {

	public static void main (String[] args) {
		SinglyLinkedList test = new SinglyLinkedList();
		test.addLast("a2");
		test.addLast("a1");
		test.addLast("a3");
		test.addLast("a4");
		test.addLast("a6");
		test.addLast("a5");
		test.addLast("a7");
		test.addLast("a8");
		test.addLast("a10");
		test.addLast("a9");
		test.printList();
		test.swap("a2", "a1");		//test run 1
		test.printList();
		test.swap("a5", "a6");		//test run 2
		test.printList();
		test.swap("a9", "a10");		//test run 3
		test.printList();
		test.swap("a1", "a10");		//test run 4
		test.printList();
		test.swap(1, 2);			//test run 5
		test.printList();
	}
	
}
