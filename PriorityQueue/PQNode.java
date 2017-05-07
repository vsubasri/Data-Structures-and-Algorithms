 /**
    *             Assignment1, COMP272
    * Class:      PQNode.java
    * Purpose:    Represent/model a node in the priority queue (element key next).
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class PQNode {
	
	private int key; 		 //property that allows each PQNode instance to be ranked		 
	private Object element;	 //Object held in each PQNode instance
	private PQNode next;	 //pointer to the subsequent PQNode instance of a given PQNode instance
	
	/**
	 * Constructs a PQNode object passing parameter values for element, key 
	 * and next to set the values for these variables. 
	 * @param element - element held in each PQNode instance
	 * @param key - property of new PQNode that allows PQNodes to be compared and ranked
	 * @param next - pointer to the subsequent PQNode of a given PQNode instance
	 */	
	public PQNode (Object element, int key, PQNode next) {
		this.element = element;
		this.key = key;
		this.next = next;
	}
	
	/**
	 * Gets the key for a given PQNode instance
	 * @return key - property that allows each PQNode instance to be ranked
	 */
	public int getKey() {
		return key;
	}
	
	/**
	 * Sets the key for a given PQNode instance
	 * @param key - property that allows each PQNode instance to be ranked
	 */
	
	public void setKey(int key) {
		this.key = key;
	}
	
	/**
	 * Gets the element for a given PQNode instance
	 * @return element - element held in each PQNode instance
	 */
	public Object getElement() {
		return element; 
	}
	
	/**
	 * Sets the element for a given PQNode instance
	 * @param element - element held in each PQNode instance
	 */	
	public void setElement(Object element) {
		this.element = element;
	}
	
	/**
	 * Gets the subsequent PQNode instance for a given PQNode instance. 
	 * @return next - pointer to the subsequent PQNode instance of a given PQNode instance
	 */
	public PQNode getNext() {
		return next;
	}
	
	/**
	 * Sets the subsequent PQNode instance for a given PQNode instance. 
	 * @param next - pointer to the subsequent PQNode instance of a given PQNode instance
	 */
	public void setNext(PQNode next) {
		this.next = next;
	}
	
	
}
