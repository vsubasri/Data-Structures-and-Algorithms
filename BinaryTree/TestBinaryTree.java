
/**
    *             Assignment2, COMP272
    * Class:      TestBinaryTree.java
    * Purpose:    Tests the binary tree class.
    *
    * @author:    Valli Subasri
    * Student ID: 3286510
    * Date:       August 29, 2016
    * Version     1.0
    *
    */

public class TestBinaryTree {
	
	public static void main (String[] args) {

		//test preorder, postorder, inorder methods
		BinaryTree bt = new BinaryTree();
		bt.add(42);
		bt.add(25);
		bt.add(65);
		bt.add(12);
		bt.add(37);
		bt.add(13);
		bt.add(30);
		bt.add(43);
		bt.add(87);
		bt.add(99);
		bt.add(9);
		System.out.println(bt.preOrderNext(13));		//test run 1
		System.out.println(bt.postOrderNext(13));		//test run 2
		System.out.println(bt.inOrderNext(13));			//test run 3
		bt.preOrderNext(99);							//test run 4
		bt.postOrderNext(42);							//test run 5
		bt.inOrderNext(99);								//test run 6
		bt.preOrderNext(1);								//test run 7
		bt.postOrderNext(1);							//test run 8
		bt.inOrderNext(1);								//test run 9
		
		//test isValid method
		BinaryTree bt2 = new BinaryTree();
		bt2.add(3);
		bt2.add(2);
		bt2.add(1);
		bt2.add(4);
		bt2.add(5);
		
		System.out.println(bt2.isValid(bt2.getRoot()));		//test run 1
		
		BinaryTree tree = new BinaryTree();
        tree.setRoot(new BTNode(1));
        tree.getRoot().setLeft(new BTNode(2));
        tree.getRoot().setRight(new BTNode(3));
        tree.getRoot().getLeft().setLeft(new BTNode(4));
        tree.getRoot().getLeft().setRight(new BTNode(5));
 		
		System.out.println(tree.isValid(tree.getRoot()));	//test run 2

	}
	
}
