 /**
    *             Assignment1, COMP272
    * Class:      Node.java
    * Purpose:    Represent/model a node in the minstack (element key next).
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class Node {
		
		private int key; 		//property that allows each Node instance to be ranked
		private Object element;	//element held in each Node instance
		private Node next;		//pointer to the subsequent Node of a given Node instance
		
		/**
		 * Constructs a Node object passing parameter values for element and
		 * next to set these values for these variables. 
		 * @param element - element held in each Node instance
		 * @param key - property that allows each Node instance to be ranked
		 * @param next - pointer to the subsequent Node of a given Node instance
		 */
		
		public Node (Object element, int key, Node next) {
			this.element = element;
			this.key = key;
			this.next = next;
		}
		
		/**
		 * Gets the element for a given Node instance
		 * @return element - element held in each Node instance
		 */
		
		public Object getElement() {
				return element; 
		}
		
		/**
		 * Sets the element for a given Node instance
		 * @param element - element held in each Node instance
		 */
		
		public void setElement(Object element) {
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
		 * Gets the key for a given Node instance
		 * @return key - property that allows each Node instance to be ranked
		 */
		
		public int getKey() {
			return key;
		}
		
		/**
		 * Sets the key for a given Node instance
		 * @param key - property that allows each Node instance to be ranked
		 */
		
		public void setKey(int key) {
			this.key = key;
		}
		
		
	}
