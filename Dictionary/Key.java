 /**
    *             Assignment4, CS2210
    * Class:      Key.java
    * Purpose:    Represent/model a key.
    *
    * @author:    Valli Subasri
    * Student ID: 250697148
    * Date:       November 20, 2016
    * Version     1.0
    *
    */

public class Key {
	
	private String word;	//key word associated with record
	private int type;		//type of record
	
	/* A constructor which returns a new Key with the specified word and type. */
	public Key(String word, int type) {
		this.word = word;
		this.type = type;
	}
	
	/* Returns the word in the Key */
	public String getWord() {
		return word;
	}
	
	/* Returns the type in the Key */
	public int getType() {
		return type;
	}
	
	/* Returns 0 if this key is equal to k, returns -1 if this key is smaller than k, and it 
	 * returns 1 otherwise. */
	public int compareTo(Key k) {
		if (k.word.equals(word)) {
			if (k.type == type) {
				return 0;
			}
			else if (k.type < type) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if (k.word.compareTo(word) < 0) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
