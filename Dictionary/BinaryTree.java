  /**
    *             Assignment4, CS2210
    * Class:      BinaryTree.java
    * Purpose:    Represent/model a binary tree (element).
    *
    * @author:    Valli Subasri
    * Student ID: 250697148
    * Date:       November 20, 2016
    * Version     1.0
    *
    */

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree {
	
	private Node r;		//root of binary tree
	private int n;		//number of elements in the binary tree
	
	/* Constructor for binary tree */
	public BinaryTree () {
		r = null; 
	}
	
	/* Getter for root of binary tree */
	public Node getRoot() {
		return r;
	}
	
	/* Gets the size of the binary tree */
	public int size() {
		return n;
	}
	
	/* Search for a key in the tree. Starts at the root of the tree and if k is less than the current
	 * then traverse the left child. If k is greater than the current node traverse the right child. 
	 * If x is equal to the current node then return that node, otherwise return null as the node does
	 * not exist in the tree. */
	public Node find (Key k) {
		
		Node curr = r; 
		
		while (curr != null) {
			
			//key is less than key of current node being traversed
			if (k.compareTo(curr.getElement().getKey()) == -1) {
				curr = curr.getLeft();
			}
			
			//key is greater than key of current node being traversed
			else if (k.compareTo(curr.getElement().getKey()) == 1) {
				curr = curr.getRight();
			}
			
			//key is equal to key of current node being traversed 
			else {
				return curr;	
			}
		}	
		return null;	
	}
	

	/* If the tree is empty make the new record the root of the tree. Otherwise traverse the 
	 * tree looking for the record previous to the record to be added. If the record already 
	 * exists nothing is done. If the record to be added is less than the previous record it is 
	 * added as a left child, otherwise it is added as a right child. */
	public void insert (Record r) {
		
		//if tree is empty, make the new record the root
		if (this.r == null) {
			this.r = new Node(r);
		}
		
		else {
			Node curr = this.r;
			Node prev = null;
			
			while (curr != null) {
				prev = curr;
				
				//key is less than key of current node being traversed
				if (r.getKey().compareTo(curr.getElement().getKey()) == -1) {
					curr = curr.getLeft();
				}
				
				//key is greater than key of current node being traversed
				else if (r.getKey().compareTo(curr.getElement().getKey()) == 1) {
					curr = curr.getRight();
				}
				
				//record already exists in dictionary
				else {
					return;
				}
			}
			
			//create new node containing record r
			Node x = new Node(r);
			
			//record to be inserted is smaller than previous record
			if (r.getKey().compareTo(prev.getElement().getKey()) == -1) {
					prev.setLeft(x);
			}
			
			//record to be inserted is larger than previous record 
			else {
					prev.setRight(x);
			}
			
			//adjust parent of newly added record
			x.setParent(prev);
		}
		
		n++;
		
	}
	
	/* Removes node x from the binary tree if it has one or no children. */
	public void removeone(Node x) {
		Node curr, parent;
		
		if (x.getLeft() != null) {
			curr = x.getLeft();
		} 
		else {
			curr = x.getRight();
		}
		
		if (x == r) {
			r = curr;
			parent = null;
		} 
		else {
			parent = x.getParent();
			if (parent.getLeft() == x) {
				parent.setLeft(curr);
			} 
			else {
				parent.setRight(curr); 
			}
		}
		
		if (curr != null) {
			curr.setParent(parent);
		}
		n--;
	}
	
	/* Removes the node u from the binary search tree (even if it has more than one child).
	 * If u has more than one child the element in node you is replaced with the element of 
	 * the left most node, u, of curr's right subtree. Then u is removed using a helped function. */
	public void remove(Key k) {	
		
		Node curr = find(k);		
		
		if (curr.getLeft() == null || curr.getRight() == null) {
			removeone(curr);
		} 
		else {
			Node u = curr.getRight();
			
			//find the record with the largest key value smaller than k	
			while (u.getLeft() != null) {
				u = u.getLeft();
			}
			
			curr.setElement(u.getElement());
			removeone(u);
		}
	}
	
	/* Returns the record from the ordered dictionary with smallest key larger than k. It returns null 
	 * if the given key has no successor. First checks if the binary tree is empty, if so it returns 
	 * null. Creates a stack to and an ArrayList to store all the elements of the in order traversal 
	 * in the order that they occur. Stores the root in a temporary variable. The method checks to 
	 * see if the temporary variable is empty, if it has a value then it is added to the stack 
	 * and the new value of the temporary variable is its left child. If the temporary variable 
	 * is empty then the top element of stack is removed and stored in the it. The element of the 
	 * Node that has just been removed is added to the ArrayList. The temporary variable now becomes 
	 * its right child. This continues on until the stack is empty and the temporary variable is 
	 * null. To find the element following k the method finds the index of the smallest element larger
	 * than k in the ArrayList. */
	public Record successor (Key k) {
		if (r == null) {
			return null;
		}
		
		ArrayList<Record> order = new ArrayList<Record>();
		Stack<Node> stack = new Stack<Node>();
		Node temp = r;
		
		while (!stack.isEmpty() || temp != null ) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			}
			else {
				temp = stack.pop();
				order.add(temp.getElement());
				temp = temp.getRight();
			}
		}
		
		int index = 0; 
		int count = 1;
		
		for (Record curr : order) {
			count++;
			if (curr.getKey().compareTo(k) == 1) {
				index = order.indexOf(curr);
				break;
			}
			if (count > order.size()) {
				System.out.println("No element with a larger key value exists.");
				return null;
			}
		}
			return order.get(index);
		
	}
	
	/* Returns the record from the ordered dictionary with largest key smaller than k. It returns null 
	 * if the given key has no predecessor. First checks if the binary tree is empty, if so it returns 
	 * null. Creates a stack to and an ArrayList to store all the elements of the in order traversal 
	 * in the order that they occur. Stores the root in a temporary variable. The method checks to 
	 * see if the temporary variable is empty, if it has a value then it is added to the stack 
	 * and the new value of the temporary variable is its left child. If the temporary variable 
	 * is empty then the top element of stack is removed and stored in the it. The element of the 
	 * Node that has just been removed is added to the ArrayList. The temporary variable now becomes 
	 * its right child. This continues on until the stack is empty and the temporary variable is 
	 * null. To find the element following k the method finds the index of the largest element smaller
	 * than k in the ArrayList. */
	public Record predecessor (Key k) {
		if (r == null) {
			return null;
		}
	
		ArrayList<Record> order = new ArrayList<Record>();
		Stack<Node> stack = new Stack<Node>();
		Node temp = r;
		
		while (!stack.isEmpty() || temp != null ) {
			if (temp != null) {
				stack.push(temp);
				temp = temp.getLeft();
			}
			else {
				temp = stack.pop();
				order.add(temp.getElement());
				temp = temp.getRight();
			}
		}
		
		int index = 0; 
		
		for (Record curr : order) {
			if (curr.getKey().compareTo(k) != -1) {
				index = order.indexOf(curr) - 1;
				break;
			}
		}

		try {
			return order.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("No element with a smaller key value exists.");
			return null;
		}
	}
	
	/* Returns the record with smallest key in the ordered dictionary. Returns null
	if the dictionary is empty. */
	public Record smallest () {
		if (size() == 0) {
			return null;
		}
		Node curr = r;
		while (curr.getLeft() != null) {
			curr = curr.getLeft();
		}
		return curr.getElement();
	}
	
	/* Returns the record with largest key in the ordered dictionary. Returns null
	if the dictionary is empty. */
	public Record largest () {
		if (size() == 0) {
			return null;
		}
		Node curr = r;
		while (curr.getRight() != null) {
			curr = curr.getRight();
		}
		return curr.getElement();
	}
	
}
