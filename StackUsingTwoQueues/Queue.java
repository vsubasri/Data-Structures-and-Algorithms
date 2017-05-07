 /**
    *             Assignment1, COMP272
    * Class:      Queue.java
    * Purpose:    Represent/model an implementation of the queue interface.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class Queue {
	
	private Node head = null;	//first node in the Queue
	private Node tail = null;	//last node in the Queue
	private int size = 0;		//number of nodes in the Queue
	
	/**
	 * Adds a new element at the end of the list. If the queue is empty the new element 
	 * is the head of the queue. Otherwise, the new node is next to the tail.
	 * @param element - element held in each Node instance
	 */
	public void enqueue (Object element) {
		Node newest = new Node (element, null);
		if (size == 0) {
			head = newest;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	/**
	 * Removes an element from the beginning of the list. If the queue is empty the method 
	 * returns null. Otherwise the head is removed and the Node next to the head is set to 
	 * the new head. If the queue is empty following the removal, the tail is set to null. 
	 * @return removed - element removed from the queue
	 */
	public Object dequeue () {
		if (size == 0)
			return null;
		Object removed = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) 
			tail = null;
		return removed;
	}

	/**
	 * Gets the size of the queue
	 * @return size - number of nodes in the queue
	 */
	public int size() {
		return size;
	}	
}
