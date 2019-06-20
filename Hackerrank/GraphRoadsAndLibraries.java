package Hackerrank;

import java.util.ArrayList;
import java.util.TreeSet;

//The Ruler of HackerLand believes that every citizen of the country should have access to a library. Unfortunately, 
//HackerLand was hit by a tornado that destroyed all of its libraries and obstructed its roads! As you are the greatest 
//programmer of HackerLand, the ruler wants your help to repair the roads and build some new libraries efficiently.
//HackerLand has n cities numbered from 1 to n. The cities are connected by m bidirectional roads. A citizen has access to 
//a library if: Their city contains a library. They can travel by road from their city to a city containing a library.
//The cost of repairing any road is Croad dollars, and the cost to build a library in any city is Clib dollars.
//Find the minimum cost of making libraries accessible to all the citizens and print it on a new line.

public class GraphRoadsAndLibraries {
	public static void main (String[] args) {
		int[][] cities = {{1, 3}, {1, 2}, {3, 4}, {2, 4}, {2, 3}, {5, 6}};
		System.out.println(roadsAndLibraries(6, 2, 1, cities));
	}
	 static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
	        long cost = 0;
	        int sTrees = 0;	        
	        TreeSet<Integer> unvisited = new TreeSet<Integer>();
	        
	        for (int j = 1; j <= n; j++){
	            unvisited.add(j);
	        } 

	    while (!unvisited.isEmpty()){
	        TreeSet<Integer> spanningTree = new TreeSet<Integer>();
	        for (int i = 0; i < cities.length; i++){
	        	System.out.println(cities[i][0]+" "+cities[i][1]);
	        	System.out.println("unvisited: "+unvisited);
		    	System.out.println("spanningTree: "+spanningTree);
		    	
	            if (spanningTree.isEmpty() && unvisited.contains(cities[i][0]) && unvisited.contains(cities[i][1])) {
	                spanningTree.add(cities[i][0]);
	                unvisited.remove(cities[i][0]);
	                spanningTree.add(cities[i][1]);
	                unvisited.remove(cities[i][1]);
	            }
	            if (spanningTree.contains(cities[i][0]) && !spanningTree.contains(cities[i][1])) {
	            spanningTree.add(cities[i][1]);
	            unvisited.remove(cities[i][1]);
	            }
	            if (spanningTree.contains(cities[i][1]) && !spanningTree.contains(cities[i][0])){
	            spanningTree.add(cities[i][0]);
	            unvisited.remove(cities[i][0]);
	            }
	        }
	        sTrees++;
	    }
	    if (c_lib <= c_road) cost = n*c_lib;
	    else cost = (n - sTrees) * c_road + sTrees * c_lib;

	    return cost;
	    }
}