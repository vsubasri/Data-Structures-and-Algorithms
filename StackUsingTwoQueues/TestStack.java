 /**
    *             Assignment1, COMP272
    * Class:      TestStack.java
    * Purpose:    Tests the stack class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class TestStack {
	
	public static void main (String[] args) {
		
		Stack stack = new Stack();
		stack.push("abc");					//test run 1
		stack.push(5);						//test run 2
		stack.push("");						//test run 3
		stack.push(15.5);					//test run 4
		System.out.println(stack.pop());	//test run 5
		System.out.println(stack.pop());	//test run 6
		System.out.println(stack.pop());	//test run 7
		System.out.println(stack.pop());	//test run 8
		System.out.println(stack.pop());	//test run 9
	}
}
