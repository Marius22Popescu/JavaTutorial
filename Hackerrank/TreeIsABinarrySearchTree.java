package Hackerrank;

class Node2{
	int data;
	Node2 left;
	Node2 right;
	Node2(int data){
		this.data = data;
		left = right = null;
	}
}
class Tree1{
	Node2 root;
	Tree1(){
		root = null;
	}
}
public class TreeIsABinarrySearchTree {	
	static boolean checkBST(Node2 root) {
		return check (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //the node root will always bee between the left and right subtree
	private static boolean check(Node2 root, int min, int max) {
		if (root == null) return true; //we reach the end of tree then is true
		if (root.data <= min || root.data >= max) return false; 
		return check(root.left, min, root.data) && check(root.right, root.data, max); //set the root as max and min 
	}

	public static void main (String[] args) {
		Tree1 tree = new Tree1();
		tree.root = new Node2(4);
		tree.root.left = new Node2(2);
		tree.root.right = new Node2(6);
		tree.root.left.left = new Node2(1);
		tree.root.left.right = new Node2(3);
		tree.root.right.right = new Node2(7);
		tree.root.right.left = new Node2(5);
		
		Tree1 tree1 =new Tree1();
		tree1.root = new Node2(8);
		tree1.root.left = new Node2(4);
		tree1.root.right = new Node2(13);
		tree1.root.left.left = new Node2(2);
		tree1.root.left.left.left = new Node2(1);
		tree1.root.left.left.right = new Node2(3);
		tree1.root.left.right = new Node2(6);
		tree1.root.left.right.left = new Node2(5);
		tree1.root.left.right.right = new Node2(7);
		tree1.root.right.left = new Node2(10);
		tree1.root.right.left.left = new Node2(9);
		tree1.root.right.left.right = new Node2(11);
		tree1.root.right.right = new Node2(14);
		tree1.root.right.right.left  = new Node2(12);
		tree1.root.right.right.right = new Node2(15);
		
		System.out.println(checkBST(tree.root));
	}
}