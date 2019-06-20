package AlgorithmsAndDataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class GraphDFSandBFS {
	// A graph is an array of adjacency lists. 
    // Size of array will be V (number of vertices in graph)
	static class Graph { 
        int V; 
        LinkedList<Integer> adjListArray[]; //adjacency list array          
        // constructor  
        Graph(int V) { 
            this.V = V; //no of vertices            
            adjListArray = new LinkedList[V]; // define the size of array as number of vertices
            // Create a new list for each vertex such that adjacent nodes can be stored 
            for(int i = 0; i < V ; i++) adjListArray[i] = new LinkedList<>(); 
        }
        // Adds an edge to an undirected graph 
        void addEdge(int src, int dest) {           
            adjListArray[src].add(dest); // Add an edge from src to dest.            
            adjListArray[dest].add(src); // Since graph is undirected, add an edge from dest to src also 
        }
        //function to print the adjacency list representation of graph 
        void printGraph() {        
            for(int vx = 0; vx < V; vx++) { 
                System.out.print("Adjacency list of vertex "+ vx+ " is: "); 
                for(Integer vertex: adjListArray[vx]){ 
                    System.out.print(vertex+", "); 
                } 
                System.out.println(""); 
            } 
        }
        // prints DFS traversal from a given source s 
        void BFS(int source){            
            boolean visited[] = new boolean[V];  // Mark all the vertices as not visited(By default set as false)                   
            LinkedList<Integer> queue = new LinkedList<Integer>();  // Create a queue for BFS                
            visited[source]=true; // Mark the current node as visited 
            queue.add(source); // and enqueue it 
            System.out.print("BFS: ");
            while (queue.size() != 0) {            
                source = queue.poll(); // Dequeue a vertex from queue and print it 
                System.out.print(source+", ");       
                // Get all adjacent vertices of the dequeued vertex s               
                Iterator<Integer> i = adjListArray[source].listIterator(); //create an iterator over the adjacency list of a vertex
                while (i.hasNext()) {  
                    int n = i.next(); 
                    if (!visited[n]) { // If a adjacent has not been visited, 
                        visited[n] = true; // then mark it visited 
                        queue.add(n); // and enqueue it 
                    } 
                } 
            } 
        } 
        // A recursive function used by DFS 
        void DFSUtil(int v,boolean visited[]){             
            visited[v] = true; // Mark the current node as visited 
            System.out.print(v+", "); //and print it                   
            Iterator<Integer> i = adjListArray[v].listIterator(); 
            while (i.hasNext()) { // Recur for all the vertices adjacent to this vertex
                int n = i.next(); 
                if (!visited[n]) DFSUtil(n, visited); 
            } 
        }       
        // The function to do DFS traversal. It uses recursive DFSUtil() 
        void DFS(int v){ 
            boolean visited[] = new boolean[V]; // Mark all the vertices as not visited(set as false by default in java)                 
            System.out.print("DFS: ");
            DFSUtil(v, visited); // Call the recursive helper function to print DFS traversal             
        } 
    }  
	
    // Driver program to test above functions 	
    public static void main(String args[]) { 
        // create the graph
        Graph graph = new Graph(7); 
        graph.addEdge(0, 1); 
        graph.addEdge(0, 2); 
        graph.addEdge(1, 2); 
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
        graph.addEdge(3, 4); 
        graph.addEdge(0, 5); 
        graph.addEdge(5, 6); 
        
        // print the adjacency list representation of the graph 
        graph.printGraph(); 
        graph.BFS(1);
        System.out.println("");
        graph.DFS(1);   	
    } 
}