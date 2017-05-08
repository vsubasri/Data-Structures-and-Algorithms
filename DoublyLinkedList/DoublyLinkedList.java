 /**
    *             Assignment1, COMP272
    * Class:      DoublyLinkedList.java
    * Purpose:    Represent/model a doubly linked list.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class DoublyLinkedList {

	private Node header;		//header sentinel 
	private Node trailer;		//trailer sentinel
	private int size;			//number of nodes in the list
	
	/**
	 * Constructs a new empty DoublyLinkedList instance. Sets the next pointer of the
	 * header to trailer and the previous pointer of the trailer to the header. 
	 */
	public DoublyLinkedList () {
		header = new Node (null, null, null);
		trailer = new Node (null, trailer, null);
		trailer.setPrevious(header);
		size = 0;
	}
	
	/**
	 * Gets the size of a given DoublyLinkedList instance
	 * @return size - number of nodes in the list
	 */
	public int size () {
		return size;
	}
	
	/**
	 * Determines if the list is empty or not
	 * @return true if the list is empty, false if it isn't
	 */
	public boolean isEmpty () {
		return size == 0;
	}
	
	/**
	 * Adds a new element between two adjacent nodes. 
	 * @param e - element of the new node
	 * @param successor - node next to the new node
	 * @param predecessor - node prior to the new node
	 */
	public void addBetween (Object e, Node successor, Node predecessor) {
		Node newest = new Node (e, successor, predecessor);
		successor.setPrevious(newest);
		predecessor.setNext(newest);
		size++;
	}
	
	/**
	 * Adds an element at the beginning of the list.  
	 * @param e - element held in the new Node instance
	 */
	public void addFirst (Object e) {
		addBetween (e, header.getNext(), header); 
	}
	
	/**
	 * Adds an element at the end of the list.
	 * @param e - element of the new Node 
	 */
	public void addLast (Object e) {
		addBetween (e, trailer, trailer.getPrevious());
	}
	
	/**
	 * Removes a node.
	 * @param node - node to be removed
	 * @return node.getElement() - element of the node that has been removed
	 */
	public Object remove (Node node) {
		if (isEmpty()) return null;
		Node predecessor = node.getPrevious();
		Node successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrevious(predecessor);
		size--;
		return node.getElement();
	}
	
	/**
	 * Removes the first element in the list.
	 * @return header.getNext().getElement() - element of the node that has been removed
	 */
	public Object removeFirst() {
		return remove(header.getNext());
	}
	
	/**
	 * Removes the last element in the list.
	 * @return trailer.getPrevious().getElement() - element of the node that has been removed
	 */
	public Object removeLast() {
		return remove(trailer.getPrevious());
	}
	
	/**
	 * If x and y are the same, do nothing. Find element x and y; if x or y does
	 * not exist or x and y are not beside each other do nothing. If x is next to the 
	 * header set the pointers for x and y accordingly. If y is next to the header 
	 * set the pointers for x and y accordingly. Otherwise adjust the next pointers 
	 * for x, y, and the nodes previous to x and y.  
	 * @param x - first element to be swapped
	 * @param y - second element to be swapped
	 */
	public void swap (Object x, Object y) {
		
		//if the two elements being swapped are the same, don't do anything
		
		if (x == y) return;
		
		//find x
		Node prevX = null;
		Node currX = header.getNext();
		
		while (currX != null && currX.getElement() != x) { 
			prevX = currX;
			currX = currX.getNext();
		}
 		
		//find y
		Node prevY = null;
		Node currY = header.getNext();
		
		while (currY != null && currY.getElement() != y) { 
			prevY = currY;
			currY = currY.getNext();
		}
		
		//if x does not exist, y does not exist or x and y are not beside each other
		
		if (currX == null || currY == null || (currX.getNext() != currY 
				&& currY.getNext() != currX)) {
			return;
		}
		
		//if x is next to the header
		
		if (currX == header.getNext()) {
			currX.setNext(currY.getNext());
			currY.setNext(currX);
			header.setNext(currY);
			return;
		}
		
		//if y is next to the header
		
		if (currY == header.getNext()) {
			currY.setNext(currX.getNext());
			currX.setNext(currY);
			header.setNext(currX);
			return;
		}
		
		//if neither x or y is next to the header, adjust the next pointers accordingly
		
		prevX.setNext(currY);
		prevY.setNext(currX);
		Node temp = currY.getNext(); 
		currY.setNext(currX.getNext());
		currX.setNext(temp);
	}
	
	/**
	 * Prints a formatted version of a DoublyLinkedList instance.
	 */
	public void printList () {
		Node start = header.getNext();
		while (start != null && start != trailer) {
			System.out.print(start.getElement() + " ");
			start = start.getNext();
		}	
		System.out.println("");
	}
}
