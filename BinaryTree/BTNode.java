
/**
    *             Assignment2, COMP272
    * Class:      BTNode.java
    * Purpose:    Represent/model a node in the binary tree (element).
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 29, 2016
    * Version     1.0
    *
    */

public class BTNode {
		private Integer element;	//element contained in a given BTNode instance
		private BTNode left;		//left child of a given BTNode instance
		private BTNode right;		//right child of a given BTNode instance
		private BTNode parent;		//parent of a given BTNode instance
		
		/**
		 * Constructs a BTNode instance passing a parameter of type Integer to initialize
		 * the element of the new BTNode. 
		 * @param element - element of the new BTNode instance
		 */
		public BTNode (Integer element) {
			this.setElement(element);
		}
		
		/**
		 * Constructs a BTNode instance passing 4 parameters to initialize the variables 
		 * left, right, parent and element of the new BTNode.  
		 * @param left - left child of the new BTNode instance
		 * @param right - right child of the new BTNode instance
		 * @param parent - parent of the new BTNode instance
		 * @param element - element of the new BTNode instance
		 */
		public BTNode (BTNode left, BTNode right, BTNode parent, int element) {
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.setElement(element);
		}
		
		/**
		 * Gets the left child of a given BTNode instance.
		 * @return left - left child of a given BTNode instance
		 */
		public BTNode getLeft() {
			return left;
		}
		
		/**
		 * Sets the left child of a given BTNode instance.
		 * @param left - left child of a given BTNode instance
		 */
		public void setLeft(BTNode left) {
			this.left = left;
		}
		
		/**
		 * Gets the right child of a given BTNode instance.
		 * @return right - right child of a given BTNode instance
		 */
		public BTNode getRight() {
			return right;
		}
		
		/**
		 * Sets the right child of a given BTNode instance.
		 * @param right - right child of a given BTNode instance
		 */
		public void setRight(BTNode right) {
			this.right = right;
		}
		
		/**
		 * Gets the parent of a given BTNode instance.
		 * @return parent - parent of a given BTNode instance
		 */
		public BTNode getParent() {
			return parent;
		}
		
		/**
		 * Sets the parent of a given BTNode instance.
		 * @param parent - parent of a given BTNode instance
		 */
		public void setParent(BTNode parent) {
			this.parent = parent;
		}
		
		/**
		 * Gets the element of a given BTNode instance.
		 * @return element - element of a given BTNode instance
		 */
		public int getElement() {
			return element;
		}
		
		/**
		 * Sets the element of a given BTNode instance
		 * @param element - element of a given BTNode instance
		 */
		public void setElement(Integer element) {
			this.element = element;
		}

}

