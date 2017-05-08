
/**
    *             Assignment2, COMP272
    * Class:      TestHashTable.java
    * Purpose:    Tests the HashTable class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 29, 2016
    * Version     1.0
    *
    */

public class TestHashTable {

	public static void main (String[] args) {
		HashTable ht = new HashTable(20);
		ht.add(1);
		ht.add(5);
		ht.add(21);
		ht.add(26);
		ht.add(39);
		ht.add(14);
		ht.add(15);
		ht.add(16);
		ht.add(17);
		ht.add(18);
		ht.add(19);
		ht.add(20);
		ht.add(111);
		ht.add(145);
		ht.add(146);
		
		System.out.print(ht.toString());	
	}
}
