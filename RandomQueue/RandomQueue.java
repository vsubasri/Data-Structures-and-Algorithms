 /**
    *             Assignment1, COMP272
    * Class:      RandomQueue.java
    * Purpose:    Represent/model an implementation of the random queue interface.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

import java.util.Random;

public class RandomQueue {
	
	private Object[] data;	//array containing all the elements in the random queue
	private int front = 0;	//index of beginning of the random queue
	private int size = 0;	//number of nodes in the queue
	private Random rand;	//generates a random number 
	
	/**
	 * Constructor for the RandomQueue class. Accepts a parameter for the size
	 * of the data array.
	 * @param capacity - size of random queue
	 */
	public RandomQueue (int capacity) {
		if (capacity <= 0) throw new RuntimeException ("Invalid capacity!");
		data = new Object[capacity];
		rand = new Random();
	}
	
	/**
	 * Gets the size of the queue
	 * @return size - size of the queue
	 */

	public int size () {
		return size;
	}
	
	/**
	 * Indicates whether or not the queue is empty.
	 * @return true if the queue is empty, false if it isn't
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Adds a new element to the random queue. 
	 * @param e - element of the new node added to the random queue
	 */
	public void add (Object e) {
		if (size() == data.length) throw new IllegalStateException ("Queue is full");
		int avail = (front + size) % data.length;
		data[avail] = e;
		size++;
	}
	
	/**
	 * Removes a random element from the queue. 
	 * @return removed - element removed from the queue
	 */
	public Object remove() {
		if (size == 0) {
			System.out.println("Empty Queue");
			return null;
		}
		int random = rand.nextInt(size);
		Object removed = data[random]; 
		if (random != size-1) 
			data[random] = data[size-1];
			data[size-1] = null;
		size--;
		System.out.printf("deleted %s from queue\n", removed);
		return removed;
	}
	
	/**
	 * Prints a formatted version of the random queue.
	 */
	public void printList() {
		int curr = front;
		while (data[curr] != null) {
			System.out.print(data[curr] + " ");
			curr++;
		}
		System.out.println();
	}
}
