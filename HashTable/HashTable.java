
/**
    *             Assignment2, COMP272
    * Class:      HashTable.java
    * Purpose:    Represent/model a hash table.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 29, 2016
    * Version     1.0
    *
    */

public class HashTable {
	
	Integer[] t; //the table 
		
	private int size = 0; 		//the number of non-null entries in the table 
	private int d = 0;			//number of deletions 
	private Integer del = -1;	//integer to represent a deleted value in the table

	/**
	 * Constructor for hash table. Passes a parameter value to create a HashTable of that size. 
	 * @param tableSize - capacity of the entire table
	 */
	public HashTable (Integer tableSize) {
		t = new Integer[tableSize];
	}
	
	/**
	 * Division hash function that calculates a hash code by finding the modulo of an integer x.
	 * @param x - integer value
	 * @return the hash code for integer x  
	 */
	public Integer hash (Integer x) {
		return x % 13; 
	}
	
	/**
	 * If the integer to be added already exists, the method returns false. Otherwise
	 * the hash code of the integer is generated. If there is no element at that index
	 * in the array then x is stored in that location. Otherwise the hash table is 
	 * linearly probed to see if the subsequent location is empty. When an empty location
	 * is found, x is added there. Size is incremented
	 * @param x - integer to be added to the hash table 
	 * @return true if the integer has been added, false if it hasn't 
	 */
	public boolean add (Integer x) {
		if (find(x) != null) 
			return false;
		Integer i = hash(x);
		while (t[i] != null && t[i] != del) {
			i = (i == t.length-1) ? 0 : i + 1; //increment i
		}
		t[i] = x;
		size++;
		return true;
	}
	
	/**
	 * The method first checks the array for the element at the index of the hash value of x.
	 * If it is empty then null is returned. If it is not equal to x then the array is linearly
	 * probed by checking subsequent elements in the array until a non-null value is found. 
	 * If x is found, it is returned. 
	 * @param x - integer to be found
	 * @return t[i] - integer that has been found
	 */
	public Integer find (Integer x) {
		Integer i = hash(x);
		while (t[i] != null) {
			if (t[i] == x && t[i] != del) {
				return x;
			}
			i = (i == t.length-1) ? 0 : i + 1; //increment i
		}
		return t[i];
	}
	
	/**
	 * If x is not in the hash table null is returned. Otherwise the hash table is 
	 * searched for the integer x, once found the location of the array it is found 
	 * at is set to null. 
	 * @param x - integer x to be removed
	 * @return t[i] - integer that has been removed
	 */
	public Integer remove (Integer x) {
		Integer i = hash(x);
		while (t[i] != null) {
			Integer y = t[i];
			if (y == x) {
				t[i] = del;
				size--;
				d++;
				return y;
			}
			i = (i == t.length-1) ? 0 : i + 1; //increment i
		}
		return null;
	}
	
	/**
	 * Gets the number of non null entries in the hash table
	 * @return size - number of non null entries in the hash table
	 */
	public Integer size () {
		return size;
	}
		
	/**
	 * Prints a formatted version of the hash table. 
	 */
	public String toString() {
		String table = "|";
		for (Integer hashed : t) {
			table += "   " + hashed + "   |";			
		}
		return table;
	}

	/**
	 * Gets the number of deletions
	 * @return d - number of deletions
	 */
	public int getDel() {
		return d;
	}

}
