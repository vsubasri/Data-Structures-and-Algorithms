 /**
    *             Assignment1, COMP272
    * Class:      PriorityQueue.java
    * Purpose:    Represent/model a priority queue.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class PriorityQueue {
		
	private PQNode head = null;	//first PQNode in the priority queue
	private PQNode tail = null;	//last PQNode in the priority queue
	private int size = 0; 		//number of PQNodes in the priority queue
	
	/**
	 * Gets the size of the priority queue.
	 * @return size - number of nodes in the priority queue
	 */
	public int size () {
		return size;
	}
	
	/**
	 * Adds a PQNode instance to the priority queue. Passes values for 
	 * element and key to set the element and key values of the new PQNode instance.
	 * @param element - element of the new PQNode instance
	 * @param key - value of the new PQNode instance that allows it to be ranked
	 * in the priority queue
	 */
	public void add (Object element, int key) {
		head = new PQNode(element, key, head);
		if (size() == 0) {
			tail = head;
		}
		size++;
	}
	
	/**
	 * If the priority queue is empty, the method returns null. If there is only one PQNode
	 * in the priority queue the minimum removed is automatically the element of that PQNode.
	 * Otherwise the method iterates through the priority queue to find the element with the 
	 * lowest key value -- that PQNode is subsequently removed.
	 * @return minimum.getElement() - the element of the PQNode with the lowest key value
	 */
	public Object deletMin() {
		
		//if the priority queue is empty return null
		
		if (size() == 0) {
			System.out.println("Priority queue is empty!");
			return null;
		}
		
		//if there is only one PQNode in the priority queue then it is the head, so remove the head
		
		if (head.getNext() == null) {
			size = 0;
			Object removed = head.getElement();
			head = null;
			System.out.printf("Deleted %s from queue\n", removed);;
			return removed;
		}
		
		PQNode current = head.getNext(); 	//current PQNode during iteration
		PQNode prevCur = head;				//PQNode previous to current PQNode during iteration
		PQNode minimum = head;				//minimum PQNode
		PQNode prevMin = null;				//PQNode previous to minimum PQNode
		
		/* While there is another PQNode in the priority queue, compare its key value to the 
		 * key value of the presently minimum element, if its key is less then set it to be 
		 * the minimum. 
		 */
		
		while (current != null) {
			if (current.getKey() <= minimum.getKey()) {
				prevMin = prevCur;
				minimum = current;	
			}
			prevCur = current;
			current = current.getNext();			
		}	
		
		//if the minimum is the head then set the head to the PQNode next to the minimum 

		if (minimum == head) {
			head = minimum.getNext();
		}
		
		//if the minimum is the tail then set the tail to node before the minimum
		else if (minimum == tail) {
			prevMin.setNext(null);
			tail = prevMin;
		}
		
		/* if the minimum is not the head/tail then set the next pointer of the PQNode previous 
		 * to the minimum to the PQNode next to the minimum. 
		 */
		
		else {
			prevMin.setNext(minimum.getNext());
						
		}
		
		size--;
		Object min = minimum.getElement();
		minimum = null;
		System.out.printf("Deleted %s from queue\n", min);
		return min;
	}
	
	/**
	 * Prints a formatted version of a given PriorityQueue instance. 
	 */
	public void printQueue() {
		PQNode curr = head;
		while (curr != null) {
			System.out.print(curr.getElement() + ", ");
			curr = curr.getNext();
		}
		System.out.println();
	}
}
		
	
