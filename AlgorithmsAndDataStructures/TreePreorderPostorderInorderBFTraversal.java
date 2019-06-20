package AlgorithmsAndDataStructures;
//The tree is typically traversed in two ways:
//	- Breath First Traversal(Level Order Traversal),
//	- Depth First Traversal, that can be in tree ways:
//			- Inorder Traversal (Left-Root-Right)
//			- Preorder Traversal (Root-Left-Right)
//			- Postorder Traversal (Left-Right-Root).

public class TreePreorderPostorderInorderBFTraversal {
		
	Node root; // The root of the tree
	//Constructor
	TreePreorderPostorderInorderBFTraversal(){
		root = null;
	}
		
	void inorderPrint(Node node) {
		if (node == null) return;
		inorderPrint(node.left); //recur on the left child
		System.out.print(node.key + " "); //print the data on the node
		inorderPrint(node.right); //recur on the right child
	}
		
	void preorderPrint(Node node) {
		if (node == null) return;
		System.out.print(node.key + " "); //print the data on the node
		preorderPrint(node.left); //recur on the left child
		preorderPrint(node.right); //recur on the right child
	}
		
	void postorderPrint(Node node) {
		if (node == null) return;			
		postorderPrint(node.left); //recur on the left child
		postorderPrint(node.right); //recur on the right child
		System.out.print(node.key + " "); //print the data on the node
	}
	// Wrappers over above recursive functions 
	void inorderPrint()   {     inorderPrint(root);  } 
	void preorderPrint()  {     preorderPrint(root);   } 
    void postorderPrint()  {     postorderPrint(root);  }
    
    // function to print Breath First traversal of tree
    void printBFTraversal() { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) printGivenLevel(root, i); 
    } 
    // method that compute the height of the tree
    int height(Node root) { 
        if (root == null) return 0; 
        else{ 
            int lheight = height(root.left); //compute the height of left subtree
            int rheight = height(root.right); //compute the height of right subtree
            if (lheight > rheight) return(lheight+1); // use the larger one 
            else return(rheight+1);  
        } 
    }   
    // method that prints nodes at the given level recursively it is a helper for BFTraversal
    void printGivenLevel (Node root, int level) { 
        if (root == null) return; 
        if (level == 1) System.out.print(root.key + " "); 
        else if (level > 1) { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
		
	public static void main(String[] args) {
	    TreePreorderPostorderInorderBFTraversal tree = new TreePreorderPostorderInorderBFTraversal();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		System.out.print("Depth First traversal of binary tree:");
		System.out.print("\n	- Inorder traversal of binary tree is:   ");
		tree.inorderPrint();
		System.out.print("\n	- Preorder traversal of binary tree is:  ");
		tree.preorderPrint();
		System.out.print("\n	- Postorder traversal of binary tree is: ");
		tree.postorderPrint();
		System.out.print("\nBreadth First traversal(Level lraversal) is:     ");
		tree.printBFTraversal();
	}
}