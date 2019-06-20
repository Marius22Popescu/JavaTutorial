package AlgorithmsAndDataStructures;

public class MinHeap {
	int Heap[]; //the heap array, all the values will be stored here, the top of the heap is first element in the array
	int size; //the size of the heap
	int capacity; //the capacity of the heap
	//the constructor
	MinHeap(int capacity){
		this.capacity = capacity;
		Heap = new int [capacity +1];
		Heap[0] = Integer.MIN_VALUE;
	}
	//returns the position of the parent of a given node position
	private int parent(int pos) {
		return pos/2;
	}
	//returns the position of the left child of a given node position
	private int leftChild(int pos ) {
		return pos*2;
	}
	//returns the position of the right child of a given node position
	private int rightChild(int pos) {
		return pos*2 + 1;
	}
	//returns true if the node at a passed position is leaf
	boolean isLeaf(int pos) {
		if (pos > (size/2) && pos <= size)
			return true;
		return false;
	}
	//swap two nodes at the given positions
	private void swap (int x, int y) {
		int temp = Heap[x];
		Heap[x] = Heap[y];
		Heap[y] = temp;
	}
	//minHeapify the Heap starting at the given position
	private void minHeapify (int pos) {
		if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
			if (Heap[pos] > Heap[leftChild(pos)]){
				swap(pos, leftChild(pos));
				minHeapify(leftChild(pos));
			}
			else {
				swap(pos, rightChild(pos));
				minHeapify(rightChild(pos));
			}
		}
	}
	//method that will insert a new node on the heap
	public void insert (int value) {
		Heap[++size] = value;
		// Traverse up and fix violated property 
        int current = size; 
        while (Heap[current] < Heap[parent(current)]) { //while current is lower than parent swap with the parent
            swap(current, parent(current)); 
            current = parent(current); 
        } 
	}
	//print the heap info
	public void print() {
		for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : "+Heap[i]+" LEFT CHILD : "+Heap[2 * i]+" RIGHT CHILD :"+Heap[2 * i + 1]); 
            System.out.println(); 
        } 
	}
	//get the min value
	public int extractMin() {
		int min = Heap[1];
		Heap[1] = Heap[size--]; //Copy the last node on the root and decrease the size in order to get rid of last element
		minHeapify(1); 
		return min;	
	}
	
	public static void main(String[] arg) { 
        System.out.println("The Max Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
  
        minHeap.print(); 
        System.out.println("The max val is " + minHeap.extractMin()); 
    } 
}
