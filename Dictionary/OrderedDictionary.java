  /**
    *             Assignment4, CS2210
    * Class:      OrderedDictionary.java
    * Purpose:    Represent/model an ordered dictionary.
    *
    * @author:    Valli Subasri
    * Student ID: 250697148
    * Date:       November 20, 2016
    * Version     1.0
    *
    */

public class OrderedDictionary implements OrderedDictionaryADT{
	
	private BinaryTree b;	//represents binary tree to hold dictionary 
	
	/* Constructor for ordered dictionary.*/
	public OrderedDictionary() {
		b = new BinaryTree();
	}
	
	/* Returns the Record object with key k, or it returns null if such a record is
	not in the dictionary. */
	public Record find (Key k) {
		if (b.find(k) != null) {
			return b.find(k).getElement();
		}
		return null;
	}
	
	/* Inserts r into the ordered dictionary. It throws a DictionaryException if a
	record with the same key as r is already in the dictionary. */
	public void insert (Record r) throws DictionaryException {
		if (find(r.getKey()) != null) {
			throw new DictionaryException("This record already exists in the dictionary");
		}
		else {
			b.insert(r);
		}
	}
	
	/* Removes the record with Key k from the dictionary. It throws a
	DictionaryException if the record is not in the dictionary. */
	public void remove (Key k) throws DictionaryException {
		if (b.find(k) == null) {
			throw new DictionaryException("This record does not exist in the dictionary");
		}
		else {
			b.remove(k);
		}
	}
	
	/* Returns the successor of k (the record from the ordered dictionary with
	smallest key larger than k); it returns null if the given key has no
	successor. The given key DOES NOT need to be in the dictionary. */
	public Record successor (Key k) {
		return b.successor(k);
	}
	
	/* Returns the predecessor of k (the record from the ordered dictionary with
	largest key smaller than k; it returns null if the given key has no
	predecessor. The given key DOES NOT need to be in the dictionary. */
	public Record predecessor (Key k) {
		return b.predecessor(k);
	}
	
	/* Returns the record with smallest key in the ordered dictionary. Returns null
	if the dictionary is empty. */
	public Record smallest () {
		return b.smallest();
	}
	
	/* Returns the record with largest key in the ordered dictionary. Returns null
	if the dictionary is empty. */
	public Record largest () {
		return b.largest();
	}

}
