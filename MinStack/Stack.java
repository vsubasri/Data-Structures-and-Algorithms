 /**
    *             Assignment1, COMP272
    * Class:      Stack.java
    * Purpose:    Represent/model an implementation of the stack interface.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */
public class Stack {

	private Node head = null; 	//first node in the stack
	private int size = 0;		//number of nodes in the stack
	
	/**
	 * Gets the size of a given Stack instance
	 * @return size - number of nodes in the stack
	 */
	public int size () {
		return size; 
	}
	
	/**
	 * Gets the element of the node at the top of the stack
	 * @return head.getElement() - 
	 */
	public Object topElement () {
		return head.getElement();
	}
	
	/**
	 * Gets the key of the node at the top of the stack
	 * @return head.key() - key 
	 */
	public int topKey () {
		return head.getKey();
	}
	
	/**
	 * Adds an element with an associated key to the top of the stack. 
	 * @param e - element of the new Node instance
	 * @param key - key of the new Node instance
	 */
	public void push (Object e, int key) {
		head = new Node (e, key, head);
		size++;
	}
	
	/**
	 * Removes the node at the top of the stack.
	 * @return answer - element of the node at the top of the stack that was removed
	 */
	public Object pop () {
		if (size() == 0) 
			return null;
		Object answer = head.getElement();
		head = head.getNext();
		size--;
		return answer;
	}
	
	/**
	 * Determines whether or not the stack is empty. 
	 * @return true if the stack is empty, false if it isn't 
	 */
	public boolean isEmpty () {
		return size == 0;
	}
	
}
