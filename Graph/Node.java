/**
 *             Assignment3, COMP272
 * Class:      Node.java
 * Purpose:    Represent/model a node in the graph (element next previous).
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

public class Node {
		
		private Integer element;	//element held in each Node instance
		private Node next;		//pointer to the subsequent Node of a given Node instance
		private Node previous; 	//pointer to the previous Node of a given Node instance 
		/**
		 * Constructs a Node object passing parameter values for element, next and
		 * previous to set these values for these variables. 
		 * @param element - element held in each Node instance
		 * @param next - pointer to the subsequent Node of a given Node instance
		 * @param previous - pointer to the previous Node of a given Node instance 
		 */
		
		public Node (Integer element, Node next, Node previous) {
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
		
		/**
		 * Gets the element for a given Node instance
		 * @return element - element held in each Node instance
		 */
		
		public Integer getElement() {
				return element; 
		}
		
		/**
		 * Sets the element for a given Node instance
		 * @param element - element held in each Node instance
		 */
		
		public void setElement(Integer element) {
			this.element = element;
		}
		
		/**
		 * Gets the subsequent Node for a given Node instance. 
		 * @return next - pointer to the subsequent Node of a given Node instance
		 */
		
		public Node getNext() {
			return next;
		}
		
		/**
		 * Sets the subsequent Node for a given Node instance. 
		 * @param next - pointer to the subsequent Node of a given Node instance
		 */
		
		public void setNext(Node next) {
			this.next = next;
		}
		
		/**
		 * Gets the previous Node for a given Node instance. 
		 * @return previous - pointer to the previous Node of a given Node instance
		 */
		
		public Node getPrevious() {
			return previous;
		}
		
		/**
		 * Sets the previous Node for a given Node instance. 
		 * @param previous - pointer to the previous Node of a given Node instance
		 */

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		
	}
	
