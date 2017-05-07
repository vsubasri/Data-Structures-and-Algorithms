 /**
    *             Assignment1, COMP272
    * Class:      SinglyLinkedList.java
    * Purpose:    Represent/model a singly linked list.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class SinglyLinkedList {

	private Node head = null;	//head node of the list
	private Node tail = null;	//tail node of the list 
	private int size = 0;		//number of nodes in the list
	
	/**
	 * Adds new element to the end of the list. If the list is empty the new element is the 
	 * head of the list. Otherwise the new element is added next to the tail and the tail 
	 * is set to the new element. 
	 * @param element - element of the new Node instance
	 */
	public void addLast (Object element) {
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
	 * Removes the first node in the list. If the list is empty, returns null. Otherwise
	 * the head is set to the node next to it. If the list following removal is empty, the
	 * tail is set to null. 
	 * @return removed - element of the first node in the list that has just been removed
	 */
	public Object removeFirst () {
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
	 * Adds an element to the beginning of the list by setting it to the new head and before
	 * the old head. If the list is empty, the new node is also the tail.  
	 * @param element - element of the new Node instance
	 */
	public void addFirst (Object element) {
		head = new Node (element, head);
		if (size == 0)
			tail = head;
		size++;
	}
	
	/**
	 * Gets the size of a given SinglyLinkedList instance.
	 * @return size - number of nodes in the list
	 */
	public int size() {
		return size;
	}	
	
	/**
	 * Indicates whether or not the list is empty.
	 * @return true if the list is empty, false if it isn't
	 */
	public boolean isEmpty () {
		return size == 0;
	}
	
	/**
	 * If x and y are the same, do nothing. Find element x and y; if x or y does
	 * not exist or x and y are not beside each other do nothing. Otherwise if x
	 * or y is the head of the list, set other element's node to be the head of the list.
	 * Otherwise, set that element's previous node to the next node of the other element.
	 * Lastly, the next pointers for x and y are switched.  
	 * @param x - first element to be swapped
	 * @param y - second element to be swapped
	 */
	public void swap (Object x, Object y) {
		if (x == y) return;
		
		// find x
		
		Node prevX = null;
		Node currX = head;
		
		while (currX != null && currX.getElement() != x) {
			prevX = currX;
			currX = currX.getNext();
		}
		
		//find y
		
		Node prevY = null;
		Node currY = head;
		
		while (currY != null && currY.getElement() != y) {
			prevY = currY;
			currY = currY.getNext();
		}
		
		//if x or y does not exist, or x and y are not beside each other, do nothing
		
		if (currX == null || currY == null || (currX.getNext() != currY && currY.getNext() != currX)
		||(currY.getNext() != currX && currX.getNext() != currY)) {
			return;
		}
		
		//adjust pointers for x and y accordingly
		
		if (prevX != null) {
			prevX.setNext(currY);
		}
		else {
			head = currY;
		}
		
		if (prevY != null) {
			prevY.setNext(currX);
		}
		else {
			head = currX;
		}
		
		Node temp = currX.getNext(); 
		currX.setNext(currY.getNext());
		currY.setNext(temp);
	}
	
	/**
	 * Prints a formatted version of the SinglyLinkedList instance.
	 */
	public void printList () {
		Node start = head;
		while (start != null) {
			System.out.print(start.getElement() + " ");
			start = start.getNext();
		}	
		System.out.println("");
	}
}
