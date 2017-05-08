 /**
    *             Assignment1, COMP272
    * Class:      TestRandomQueue.java
    * Purpose:    Tests the RandomQueue class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class TestRandomQueue {

	public static void main(String[] args) {
		
		RandomQueue rq = new RandomQueue(12);
		rq.add('a');			//test run 1
		rq.printList();
		rq.add("string");		//test run 2
		rq.printList();
		rq.add(1);				//test run 3
		rq.printList();
		rq.remove();			//test run 4
		rq.printList();
		rq.remove();			//test run 5
		rq.printList();
		rq.remove();			//test run 6
		rq.remove();			//test run 7
	}
}
