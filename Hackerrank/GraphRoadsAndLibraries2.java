package Hackerrank;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
//The Ruler of HackerLand believes that every citizen of the country should have access to a library. Unfortunately, 
//HackerLand was hit by a tornado that destroyed all of its libraries and obstructed its roads! As you are the greatest 
//programmer of HackerLand, the ruler wants your help to repair the roads and build some new libraries efficiently.
//HackerLand has n cities numbered from 1 to n. The cities are connected by m bidirectional roads. A citizen has access to 
//a library if: Their city contains a library. They can travel by road from their city to a city containing a library.
//The cost of repairing any road is Croad dollars, and the cost to build a library in any city is Clib dollars.
//Find the minimum cost of making libraries accessible to all the citizens and print it on a new line.
public class GraphRoadsAndLibraries2 {
   	
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		long cost = 0;
	    long sTrees = 0;	 
	    TreeSet<Integer> unvisited = new TreeSet<Integer>();  
	    //fill the unvisited set with all the cities
	    for (int j = 1; j <= n; j++){
	    	unvisited.add(j);
	    } 
	    //Graph class
	    class Graph { 
	        int V; 
	        LinkedList<Integer> adjListArray[]; //adjacency list array  
	        boolean visited[];
	        // constructor  
	        Graph(int V) { 
	            this.V = V; //no of vertices            
	            adjListArray = new LinkedList[V+1]; // define the size of array as number of vertices             
	            for(int i = 1; i < V+1 ; i++) adjListArray[i] = new LinkedList<>();  // Create a new list for each vertex such that adjacent nodes can be stored  
	            visited = new boolean[V+1]; // Mark all the vertices as not visited(set as false by default in java)
	            visited[0] = true; //we will not use index 0
	        }
	        // Adds an edge to an undirected graph 
	        void addEdge(int src, int dest) {           
	            adjListArray[src].add(dest); // Add an edge from src to dest.            
	            adjListArray[dest].add(src); // Since graph is undirected, add an edge from dest to src also 
	        }
	        //Depth first search
	        void DFS(int v){             
	            visited[v] = true; // Mark the current node as visited 
	            unvisited.remove(v); 
	            Iterator<Integer> i = adjListArray[v].listIterator(); 
	            while (i.hasNext()) { // Recur for all the vertices adjacent to this vertex
	                int n = i.next(); 
	                if (!visited[n]) DFS(n); 
	            } 	            
	        }       
	    }  
	    //create and graph the edges to the graph
	    Graph graph = new Graph(n); 
	    //version with bigInteger
	    for (BigInteger bi = BigInteger.valueOf(cities.length-1); bi.compareTo(BigInteger.ZERO) >= 0; bi = bi.subtract(BigInteger.ONE)) {
	    	graph.addEdge(cities[bi.intValue()][0], cities[bi.intValue()][1]);
	    }
	    //version with long
//	    for (long i = 0; i<cities.length; i++) {  
//	    	graph.addEdge(cities[(int) i][0], cities[(int) i][1]);
//	    }
	    
	    //run DFS until visit all cities and count the unconnected graphs
	    while(!unvisited.isEmpty()) {
	    	graph.DFS(unvisited.first()); 
	    	sTrees++;  //update the number of individual trees (disconnected graphs)
	    }
	    
	    //calculate the cost    
	    if (c_lib <= c_road) cost = n*c_lib; // if the cost of library lower than for road, build just libraries 
	    else cost = (n - sTrees) * c_road + sTrees * c_lib;

	    return cost;
	    }
	
	public static void main(String args[]) { 
		int[][] cities = {{1, 2}, {1, 3}, {1, 4}};
	//	int[][] cities = {{1, 3}, {1, 2}, {3, 4}, {2, 4}, {2, 3}, {5, 6}};
	//	int[][] cities = {{1, 3}, {1, 2}, {3, 4}, {6, 4}, {2, 3}, {5, 6}};
		System.out.println("The coast is: "+roadsAndLibraries(6, 2, 1, cities));
    } 												
}
