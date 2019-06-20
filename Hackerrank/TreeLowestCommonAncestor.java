package Hackerrank;
// You are given pointer to the root of the binary search tree and two values v1 and v2. You need to return 
//the lowest common ancestor (LCA) of v1 and v2 in the binary search tree.
class Node1{
	int data;
	Node1 left;
	Node1 right;
	Node1 (int val){
		data = val;
		left = right = null;
	}
}

class Tree{
	Node1 root;
	Tree(){
		root = null;
	}
}

public class TreeLowestCommonAncestor {
	
	public static void main (String[] args) {
		Tree tree = new Tree();
		tree.root = new Node1(4);
		tree.root.left = new Node1(2);
		tree.root.right = new Node1 (7);
		tree.root.left.left = new Node1(1);
		tree.root.left.right = new Node1(3);
		tree.root.right.left = new Node1(6);
		
		System.out.println("The  lowest common ancester is: "+ lca(tree.root, 3, 6).data);
		System.out.println("The  lowest common ancester is: "+ lca(tree.root, 1, 3).data);
		System.out.println("The  lowest common ancester is: "+ lca(tree.root, 6, 7).data);
	}
	//The value of a common ancestor has to always be between the two values in question.
	private static Node1 lca(Node1 root, int v1, int v2) {
		if (root.data < v1 && root.data < v2) return lca(root.right, v1, v2); //if root is smaller than vertexes
		if (root.data > v1 && root.data > v2) return lca(root.left, v1, v2); //if root is bigger than vertexes
		return root; //else if is between vertexes the root is the lowest common divisor
	}
}
