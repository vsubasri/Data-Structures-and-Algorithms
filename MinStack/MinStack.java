 /**
    *             Assignment1, COMP272
    * Class:      MinStack.java
    * Purpose:    Represent/model a stack that keeps track of the minimum element.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class MinStack {
	
	private Object min;			//minimum element in the stack
	private Stack stack;		//contains a sequence of elements
	private Stack minStack;		//contains the minimum values associated with stack
	private int size;			//size of the MinStack instance
	
	/**
	 * Constructor for MinStack class. Creates a new stack for both stack and minStack.
	 */
	public MinStack () {
		stack = new Stack();
		minStack = new Stack();
	}
	
	/**
	 * Adds a new to the stack. If the new node has a key value lower than that of the top of
	 * the minStack, then the new Node gets added to the minStack.
	 * @param e - element to be added to stack
	 * @param key - key value of element to be added to stack--allows the Node to be ranked
	 */
	public void push (Object e, int key) {
		if (stack.isEmpty() || key <= minStack.topKey()) {
			minStack.push(e,key);
			min = e;
		}
		stack.push(e, key);
		size++;
		System.out.println("Pushed: " + e);
	}
	
	/**
	 * Removes the node at the top of the stack as long as the stack is not empty. If
	 * the key of the node being removed is equal to the key of the node at the top of 
	 * the minstack, then the node is also removed from the minstack. 
	 * @return answer - element of the node at the top of the stack that was removed
	 */
	public Object pop () {
		if (stack.isEmpty()) {
			System.out.println("The stack is empty!");
			return null;
		}
		if (minStack.topKey() == stack.topKey()) {
			minStack.pop();
			if (minStack.size() != 0) {
				min = minStack.topElement();
			}
		}	
		Object answer = stack.topElement();
		stack.pop();
		size--;
		System.out.println("Popped: " + answer);
		return answer;
	}
	
	/**
	 * Gets the element with the lowest key value in the stack (ie. the minimum element) 
	 * @return min - element with the lowest key value associated with it
	 */
	public Object min () {
		if (minStack.isEmpty()) {
			System.out.print("The stack is empty!");
			return null;
		}
		System.out.println("Minimum: " + min);
		return min;
	}
	
	/**
	 * Gets the size of the stack
	 * @return number of nodes in the stack
	 */
	public int size() {
		return size;
	}
	
}
