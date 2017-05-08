
/**
    *             Assignment2, COMP272
    * Class:      BinaryTree.java
    * Purpose:    Represent/model a binary tree.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 29, 2016
    * Version     1.0
    *
    */

public class BinaryTree {
	
	/**
	 * The root of this tree
	 */
	private BTNode r;
	
	/**
	 * Number of nodes in the tree
	 */
	private int n;
	
	/**
	 * Create a new instance of the BinaryTree class. Initializes the root to null.
	 */
	public BinaryTree() {
		r = null;	
	}

	/**
	 * Gets the root of the binary tree
	 * @return r - root of the binary tree
	 */
	public BTNode getRoot() {
		return r;
	}
	
	/**
	 * Sets the root of the binary tree
	 * @param root - new BTnode to set the root to
	 */
	public void setRoot(BTNode root) {
		r = root;
	}
	
	/**
	 * Computes the size (number of BTNodes) of the tree
	 * @return n - the number of BTNodes in the tree
	 */
	public int size() {
		return n;
	}
		
	/**
	 * Determines if the binary tree is empty or not.
	 * @return true if it is empty, false if it isn't
	 */
	public boolean isEmpty() {
		return r == null;
	}
		
	/**
	 * Search for a value in the tree. Start at the root of the tree and if x is less than the root
	 * then traverse the left child. If x is greater than the root traverse the right child. Continue
	 * down the tree traversing until the node previous to x is found.
	 * @return prev - the last node on the search path for x
	 */
	public BTNode findLast(int x) {
		BTNode w = r, prev = null;
		while (w != null) {
			prev = w;
			if (x < w.getElement()) {
				w = w.getLeft();
			} else if (x > w.getElement()) {
				w = w.getRight();
			} else {
				return w;
			}
		}
		return prev;
	}
	
	/**
	 * Add the node u as a child of node p, assuming p has no child
	 * where u should be added. If the node to be added has no parent add it 
	 * as the root of the tree. Otherwise, if it is less than its parent add it 
	 * as the left child, and if it is greater than its parent add it as the right
	 * child. Otherwise return false. Set the parent of u as p and increment size. 
	 * @param p - parent node of node u that is being added
	 * @param u - node that is being added to the binary tree
	 * @return true if the child was added, false otherwise
	 */
	public boolean addChild(BTNode p, BTNode u) {
		if (p == null) {
			r = u;              // inserting into empty tree
		} else {
			if (u.getElement() < p.getElement()) {
				p.setLeft(u);
			} else if (u.getElement() > p.getElement()) {
				p.setRight(u);
			} else {
				return false;   // u.x is already in the tree
			}
			u.setParent(p);
		}
		n++;
		return true;		
	}

	/**
	 * Adds a new value to the Binary Tree. 
	 * @param x - element to be added to binary tree
	 * @return calls addChild method passing parameter of p the parent node to x and a new node 
	 * containing element x
	 */
	public boolean add(Integer x) {
		BTNode p = findLast(x);
		return addChild(p, new BTNode(x));		
	}

	/**
	 * Adds a new node to the Binary Tree.
	 * @param x - element to be added to the binary tree
	 * @return calls method addChild passing parameter of p the parent node to x and x the node
	 * to be added
	 */
	public boolean add(BTNode x) {
		BTNode p = findLast(x.getElement());
		return addChild(p, x);
	}
	
	/**
	 * Remove the node u -- assuming u has at most one child
	 * @param u - the node being removed from the binary tree
	 */
	public void splice(BTNode u) {
		BTNode s, p;
		if (u.getLeft() != null) {
			s = u.getLeft();
		} else {
			s = u.getRight();
		}
		if (u == r) {
			r = s;
			p = null;
		} else {
			p = u.getParent();
			if (p.getLeft() == u) {
				p.setLeft(s);
			} else {
				p.setRight(s); 
			}
		}
		if (s != null) {
			s.setParent(p);
		}
		n--;
	}
	
	/**
	 * Remove the node u -- assuming u has at most one child. If the node u
	 * to be removed has a left child then set it to s, otherwise set s to the 
	 * right child. If u is the root then set the new root to s otherwise check
	 * if u is the right child or left child of its parent and replace it accordingly.
	 * If s is not null set its parent to p. Increment size.
	 * @param u - the node being removed from the binary tree
	 */
	public void remove(BTNode u) {
		if (u.getLeft() == null || u.getRight() == null) {
			splice(u);
		} else {
			BTNode w = u.getRight();
			while (w.getLeft() != null) 
				w = w.getLeft();
			u.setElement(w.getElement());
			splice(w);
		}
	}

	/**
	 * Tests whether a binary tree satisfies the search tree order property at every node.
	 * @return call to isValidBST method passing root, min value of an Integer and the max value
	 * of an Integer as parameters and returns true if this method returns true and false if 
	 * this method returns false
	 */
	public boolean isValid(BTNode root) {
	     return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * If the binary tree is empty the method returns true. If the root's element is greater
	 * than the minimum value and less than the maximum value, and its left and right child are 
	 * valid then the method returns true. To check the left and right child of each BTNode the
	 * isValidBST method is called recursively for every right and left child. If these conditions
	 * aren't met the the method returns false.
	 * @param node - root of the binary tree 
	 * @param min - minimum value for a given left child
	 * @param max - maximum value for a given right child
	 * @return true if the search tree order property is met and false if it isn't
	 */
	private boolean isValidBST(BTNode node, int min, int max) {
	     if(node == null)
	         return true;
	     if(node.getElement() > min && node.getElement() < max
	         && isValidBST(node.getLeft(), min, node.getElement())
	         && isValidBST(node.getRight(), node.getElement(), max))
	         return true;
	     else 
	         return false;
	}
	
  	/**
	 * Gets the element in the BTNode next to a given BTNode when doing a preorder traversal.
	 * First checks if the binary tree is empty, if so it returns null. Creates a stack to
	 * facilitate the preOrder traversal and an ArrayList to store all the elements of the
	 * preOrder traversal in the order that they occur. Next, adds the root to the stack. 
	 * While the stack isn't empty the top element of the stack is removed and stored in a
	 * temporary variable -- this element is added to the ArrayList. If the element that
	 * has just been removed has a right child it is added to the stack. If it has a left
	 * child it is added to the stack. This continues until all the elements in the binary tree
	 * have been added to the ArrayList. To find the element next to x in the pre order traversal
	 * the method finds the index of x in the ArrayList and then gets the element in the 
	 * ArrayList with an index 1 higher than that element.
	 * @param x - element of a given BTNode instance in the binary tree
	 * @return order.get(index) - element next to x in a pre order traversal
	 */
	public Integer preOrderNext(Integer x) {
		if (r == null) return null;
		BTNode temp = r;
		Stack<BTNode> stack = new Stack<BTNode>();
		ArrayList<Integer> order = new ArrayList<Integer>();
		stack.push(r);
		while (!stack.isEmpty()) {
			temp = stack.pop();
			order.add(temp.getElement());
			if (temp.getRight() != null) 
				stack.push(temp.getRight());
			if (temp.getLeft() != null) 
				stack.push(temp.getLeft());
		}
		int index = order.indexOf(x);
		if (index == -1) {
			System.out.println("This element does not exist in the binary tree");
			return null;
		}
		else {
			index++;
		}	
		try {
			return order.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("This is the last element in the traversal.");
			return null;
		}
	}
	
	/**
	 * Gets the element in the BTNode next to a given BTNode when doing a postorder traversal.
	 * First checks if the binary tree is empty, if so it returns null. Creates a stack to
	 * facilitate the postOrder traversal and an ArrayList to store all the elements of the
	 * postOrder traversal in the order that they occur. Adds the root to the stack. While moving
	 * down the binary tree add the current element's left child to the stack, if there is no 
	 * left child add the right child to the stack and if there are no more children  add the 
	 * current element to the ArrayList and pop the top element of the stack. While moving up from
	 * the left if the previous node was the left child  and if there is a right child add that to
	 * the stack, otherwise add the current element to the ArrayList and remove the top element 
	 * from the stack. When moving up from the right if the previous element was the right child 
	 * then add the current element to the ArrayList and remove the top element from the stack.
	 * This continues until all the elements in the binary tree have been added to the ArrayList. 
	 * To find the element next to x in the post order traversal the method finds the index of x 
	 * in the ArrayList and then gets the element in the ArrayList with an index 1 higher than 
	 * that element.  
	 * @param x - element of a given BTNode instance in the binary tree
	 * @return order.get(index) - element next to x in a post order traversal
	 */
	public Integer postOrderNext (Integer x) {
		if (r == null) return null;
		ArrayList<Integer> order = new ArrayList<Integer>();
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode prev = null;
		BTNode current = r;
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.peek();						
			//moving down
			if (prev == null || prev.getLeft() == current || prev.getRight() == current) {
				if (current.getLeft() != null) {
					stack.push(current.getLeft());		
				}
				else if (current.getRight() != null) {
					stack.push(current.getRight());
				}
				else {
					order.add(current.getElement());
					stack.pop();
				}
			}
			//moving up from the left 
			if (prev == current.getLeft()) {
				if (current.getRight() != null) {
					stack.push(current.getRight());
				}
				else {
					order.add(current.getElement());
					stack.pop();
				}
			}
			//moving up from right
			if (prev == current.getRight()) {
				order.add(current.getElement());
				stack.pop();
			}
			prev = current;
		}
		int index = order.indexOf(x);
		if (index == -1) {
			System.out.println("This element does not exist in the binary tree");
			return null;
		}
		else {
			index++;
		}	
		try {
			return order.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("This is the last element in the traversal.");
			return null;
		}
	}
	
	/**
	 * Gets the element in the BTNode next to a given BTNode when doing an in order traversal.
	 * First checks if the binary tree is empty, if so it returns null. Creates a stack to
	 * facilitate the in order traversal and an ArrayList to store all the elements of the
	 * in order traversal in the order that they occur. Stores the root in a temporary variable  
	 * The method checks to see if the temporary variable is empty, if it has a value then it is
	 * added to the stack and the new value of the temporary variable is its left child. If the
	 * temporary variable is empty then the top element of stack is removed and stored in the it.
	 * The element of the BTNode that has just been removed is added to the ArrayList. The 
	 * temporary variable now becomes its right child. This continues on until the stack is
	 * empty and the temporary variable is null. To find the element next to x in the in order 
	 * traversal the method finds the index of x in the ArrayList and then gets the element in the 
	 * ArrayList with an index 1 higher than that element.
	 * @param x - element of a given BTNode instance in the binary tree
	 * @return order.get(index) - element next to x in an in order traversal
	 */
	public Integer inOrderNext (Integer x) {
		if (r == null) return null;
		ArrayList<Integer> order = new ArrayList<Integer>();
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode temp = r;
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
		int index = order.indexOf(x);
		if (index == -1) {
			System.out.println("This element does not exist in the binary tree");
			return null;
		}
		else {
			index++;
		}	
		try {
			return order.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("This is the last element in the traversal.");
			return null;
		}

	}
	
}
