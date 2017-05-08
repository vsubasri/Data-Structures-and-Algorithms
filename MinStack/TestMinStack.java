 /**
    *             Assignment1, COMP272
    * Class:      TestMinStack.java
    * Purpose:    Tests the MinStack class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 28, 2016
    * Version     1.0
    *
    */

public class TestMinStack {
	public static void main (String[] args) {
		MinStack test = new MinStack();
		test.push("a1", 5);					//test run 1
		test.push(2, 15);					//test run 2
		test.push(1.23, 0);					//test run 3
		test.push("", 10);					//test run 4
		System.out.println(test.size());	//test run 5
		test.min();							//test run 7
		test.pop();							//test run 8
		test.pop();							//test run 9
		test.pop();							//test run 10
		test.pop();							//test run 11
		test.pop();							//test run 12
		System.out.println(test.size());	//test run 6
	
	}
}
