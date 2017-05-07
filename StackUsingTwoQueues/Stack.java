 /**
    *             Assignment1, COMP272
    * Class:      Stack.java
    * Purpose:    Represent/model an implementation of the stack interface using two queues.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class Stack {
	
	private Queue q1;			//first queue
	private Queue q2;			//second queue
	private Object top;			//element at the top of the stack
	
	
	/**
	 * Constructs a Stack instance. Initializes q1 and q2 by creating queues. 
	 */
	public Stack () {
		q1 = new Queue();
		q2 = new Queue();
	}
	
	
	/**
	 * Adds a new element to the top of the stack.
	 * @param element - element of the new Node instance
	 */
	public void push (Object element) {
		q1.enqueue(element);
		top = element;
		System.out.println(element);
	}
	
	/**
	 * Removes an element from the stack. If the queue is empty, the method returns null. 
	 * Otherwise it transfers all the elements from q1 to q2 until there is only one element
	 * left in the q1. That last element is removed from q1, stored in the popped variable
	 * and then afterwards, added to q2. The arrays names are then swapped and the popped 
	 * variable is returned. 
	 * @return popped - element that has been removed from the stack
	 */
	public Object pop () {
		if (q1.size() == 0)
			return "The stack is empty";
		while (q1.size() > 1) {
			top = q1.dequeue();
			q2.enqueue(top);
		}
		Object popped = q1.dequeue();
		Queue temp = q2;
		q2 = q1;
		q1 = temp;
		return popped;
	}
	
	/**
	 * Gets the element at the top of the stack.
	 * @return top - element at the top of the stack
	 */
	public Object getTop() {
		return top;
	}	

	/**
	 * Gets the size of a given Stack instance.
	 * @return q1.size() - number of nodes in the stack
	 */
	public int size() {
		return q1.size();
	}	
}
