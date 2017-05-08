  /**
    *             Assignment4, CS2210
    * Class:      Record.java
    * Purpose:    Represent/model a record.
    *
    * @author:    Valli Subasri
    * Student ID: 250697148
    * Date:       November 20, 2016
    * Version     1.0
    *
    */

public class Record {
	
	private Key k; 			//key for a given Record
	private String data;	//data for a given Record

	/* Constructor for Record that is stored in each node of the binary tree. Takes parameters for 
	 * key and data. */
	public Record(Key k, String data) {
		this.k = k;
		this.data = data;
	}
	
	/* Returns key for a given Record instance */
	public Key getKey() {
		return k;
	}
	
	/* Returns data for a given Record instance */
	public String getData() {
		return data;
	}
	
}
