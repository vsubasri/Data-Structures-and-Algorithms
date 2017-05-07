 /**
    *             Assignment1, COMP272
    * Class:      TestPriorityQueue.java
    * Purpose:    Tests the priority queue class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class TestPriorityQueue {

	public static void main (String[] args) {
		
		PriorityQueue pq = new PriorityQueue();
		pq.add("a1", 5);					//test run 1
		pq.printQueue();					
		pq.add(2, 15);						//test run 2
		pq.printQueue();
		pq.add(1.23, 0);					//test run 3
		pq.printQueue();
		pq.add("", 10);						//test run 4
		pq.printQueue();
		System.out.println(pq.size());		//test run 5
		pq.deletMin();						//test run 6
		pq.deletMin();						//test run 7
		pq.deletMin();						//test run 8
		pq.deletMin();						//test run 9
		pq.deletMin();						//test run 10
		
	}
}

