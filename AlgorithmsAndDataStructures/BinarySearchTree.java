package AlgorithmsAndDataStructures;

public class BinarySearchTree {
	
    Node root; // Root of BST    
    // Constructor 
    BinarySearchTree() {  
        root = null;  
    }   
    // This method calls the method insertRec() 
    void insert(int key) { 
       root = insertRec(root, key); 
    }       
    // A recursive function to insert a new key in BST 
    Node insertRec(Node root, int key) {          	
    // Base case, if the tree is empty, create and return a new node with the specified key
    	if (root == null) { 
            root = new Node(key); 
            return root; 
        }   // Otherwise, recur down the tree
        if (key < root.key) root.left = insertRec(root.left, key);             
        else if (key > root.key) root.right = insertRec(root.right, key);             
        return root; // return the (unchanged) node pointer 
    } 
    // This method calls InorderRec() 
    void inorder()  { 
       inorderRec(root); 
    }  
    // A function to do inorder traversal of BST 
    void inorderRec(Node root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.print(root.key + " "); 
            inorderRec(root.right); 
        } 
    } 
    // Function that search a given key in BST 
    public Node search(Node root, int key) {         
        if (root==null || root.key==key)  return root; //root is null or key is present at root               
        if (root.key > key) return search(root.left, key); //val is greater than root's key               
        return search(root.right, key); //val is less than root's key 
    } 
    //Method that print the answer of search method
    void search(int key) {  	
    	if (search(root, key) != null) System.out.println("\nThe value "+key+" is in the tree");
    	else System.out.println("\nThe value is NOT in the tree");
    	}
    
    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree(); 
        /*   50 
           /     \ 
          30      70 
         /  \    /  \ 
       20   40  60   80 */
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        tree.inorder(); 
        tree.search(20);
        tree.search(55);
    } 
}