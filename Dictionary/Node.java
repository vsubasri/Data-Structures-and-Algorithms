 /**
    *             Assignment4, CS2210
    * Class:      Node.java
    * Purpose:    Represent/model a node in the binary tree.
    *
    * @author:    Valli Subasri
    * Student ID: 250697148
    * Date:       November 20, 2016
    * Version     1.0
    *
    */

public class Node {
	
		private Record element;	//element contained in a given Node instance
		private Node left;		//left child of a given Node instance
		private Node right;		//right child of a given Node instance
		private Node parent;	//parent of a given Node instance
		
		/* Constructs a Node instance passing a parameter of type Record to initialize
		 * the element of the new Node. */
		public Node (Record element) {
			this.setElement(element);
		}
		
		/* Constructs a Node instance passing 4 parameters to initialize the variables 
		 * left, right, parent and element of the new Node. */
		public Node (Node left, Node right, Node parent, Record element) {
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.setElement(element);
		}
		
		/* Gets the left child of a given Node instance. */
		public Node getLeft() {
			return left;
		}
		
		/* Sets the left child of a given Node instance. */
		public void setLeft(Node left) {
			this.left = left;
		}
		
		/* Gets the right child of a given Node instance.*/
		public Node getRight() {
			return right;
		}
		
		/* Sets the right child of a given Node instance. */
		public void setRight(Node right) {
			this.right = right;
		}
		
		/* Gets the parent of a given Node instance. */
		public Node getParent() {
			return parent;
		}
		
		/* Sets the parent of a given Node instance. */
		public void setParent(Node parent) {
			this.parent = parent;
		}
		
		/* Gets the element of a given Node instance. */
		public Record getElement() {
			return element;
		}
		
		/* Sets the element of a given Node instance */
		public void setElement(Record element) {
			this.element = element;
		}

}

