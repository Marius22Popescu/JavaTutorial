package AlgorithmsAndDataStructures;

public class MaxHeap {
	private int[] Heap; //the heap array, all the values will be stored here, the top of the heap is first element in the array
    private int size; //the size of the heap
    private int capacity;  //the capacity of the heap
  
    // Constructor
    public MaxHeap(int maxsize) { 
        this.capacity = maxsize; 
        this.size = 0; 
        Heap = new int[this.capacity + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    }   
    //returns the position of the parent of a given node position 
    private int parent(int pos) { 
    	return pos / 2; 
    	} 
    //returns the position of the left child of a given node position
    private int leftChild(int pos) { 
    	return (2 * pos); 
    	} 
    //returns the position of the right child of a given node position
    private int rightChild(int pos) { 
    	return (2 * pos) + 1; 
    	}  
    //returns true if the node at a passed position is leaf
    private boolean isLeaf(int pos) { 
        if (pos >= (size / 2) && pos <= size)
            return true;  
        return false; 
    } 
    //swap two nodes at the given positions
    private void swap(int x, int y) { 
        int temp = Heap[x];  
        Heap[x] = Heap[y]; 
        Heap[y] = temp; 
    }   
    // Recursive function to max heapify the given  subtree. This function assumes that the left and 
    // right subtrees are already heapified, we only need  to fix the root. 
    private void maxHeapify(int pos) { 
        if (isLeaf(pos)) 
            return;   
        if (Heap[pos] < Heap[leftChild(pos)]|| Heap[pos] < Heap[rightChild(pos)]) {   
            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
                swap(pos, leftChild(pos)); 
                maxHeapify(leftChild(pos)); 
            } 
            else { 
                swap(pos, rightChild(pos)); 
                maxHeapify(rightChild(pos)); 
            } 
        } 
    }   
    // Inserts a new element to max heap 
    public void insert(int element) { 
        Heap[++size] = element;   //insert the element at the next available index and increase the size
        // Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] > Heap[parent(current)]) { //while current is greater than parent swap with the parent
            swap(current, parent(current)); 
            current = parent(current); 
        } 
    } 
  
    public void print() { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : "+Heap[i]+" LEFT CHILD : "+Heap[2 * i]+" RIGHT CHILD :"+Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    }   
    // Remove an element from max heap 
    public int extractMax() { 
        int max = Heap[1]; 
        Heap[1] = Heap[size--]; //Copy the last node on the root and decrease the size in order to get rid of last element
        maxHeapify(1); 
        return max; 
    } 
  
    public static void main(String[] arg) { 
        System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
  
        maxHeap.print(); 
        System.out.println("The max val is " + maxHeap.extractMax()); 
    } 
}