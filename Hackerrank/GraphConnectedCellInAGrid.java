package Hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//Consider a matrix where each cell contains either a 0 or a 1 and any cell containing a 1 is called a filled cell. 
//Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally.
//If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to at 
//least one other cell in the region but is not necessarily directly connected to all the other cells in the region.
//Given an n x m matrix, find and print the number of cells in the largest region in the matrix.

class Vertex{
	private int name;
	private ArrayList <Integer> adjacencyList;	
	boolean visited;
	Vertex(int name){
		this.name = name;
		adjacencyList = new ArrayList();
		visited = false;
	}
	public int getName() {
		return name;
	}
	public void addToAdjList(int n) {
		this.adjacencyList.add(n);
	}
	public ArrayList getAdjList() {
		return adjacencyList;
	}
	public void setVisited() {
		this.visited = true;
	}
	public boolean getVisited() {
		return visited;
	}
}

public class GraphConnectedCellInAGrid {
	
	private static int maxRegion(int[][] arr) {		
		int size = 0;	
		//create the graph
		HashMap <Integer, Vertex> graph = new HashMap <Integer, Vertex> ();
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[y].length; x++) {
				if (arr[y][x] == 1) {
					int name = Integer.valueOf(String.valueOf(y)+String.valueOf(x));
					Vertex v = new Vertex(name);
					//add to the vertex the adjacency list
					if ((x+1)< arr[y].length && arr[y][x+1]==1) addAdjiacent(y, x+1, v);
					if (0<=(x-1) && arr[y][x-1]==1) addAdjiacent(y, x-1, v);
					if ((y+1)< arr.length && (x+1)< arr[y].length && arr[y+1][x+1]==1) addAdjiacent(y+1, x+1, v);
					if ((y+1)< arr.length && arr[y+1][x]==1) addAdjiacent(y+1, x, v);
					if ((y+1)< arr.length && 0<=(x-1) && arr[y+1][x-1]==1) addAdjiacent(y+1, x-1, v);
					if (0 <= (y-1) && (x+1)< arr[y].length && arr[y-1][x+1]==1) addAdjiacent(y-1, x+1, v);
					if (0 <= (y-1) && arr[y-1][x]==1) addAdjiacent(y-1, x, v);
					if (0 <= (y-1) && 0<=(x-1) && arr[y-1][x-1]==1) addAdjiacent(y-1, x-1, v);	
					graph.put(v.getName(), v); //add node to the graph
					}
				}
			}
		//Iterate through graph and do DFS
		Iterator <Integer> iter = graph.keySet().iterator();
		while(iter.hasNext() && !graph.get(iter.next()).getVisited()) {
			ArrayList<Integer> path = new ArrayList <Integer> (); //Array that will keep the path of DFS
			if (iter.hasNext()) {
				DFS(iter.next(), graph, path);
			}
			int c = path.size(); //the size of path will be the size of region
			if (size < c) size = c; //update the size if is greater than previous one
		}	
		return size;
	}

	private static void DFS(int name, HashMap<Integer, Vertex> graph, ArrayList<Integer> path) {
		graph.get(name).setVisited();
		path.add(777);	//add a element to the path
		@SuppressWarnings("unchecked")
		Iterator<Integer> it = graph.get(name).getAdjList().iterator();
		while (it.hasNext()) {
			int n = it.next();
			if(!graph.get(n).getVisited()) {
				DFS(n, graph, path);
			}
		}
	}
	
	private static void addAdjiacent(int a, int b, Vertex v) {
		String name = String.valueOf(a) + String.valueOf(b);
		v.addToAdjList(Integer.parseInt(name));
	}
	
	public static void main(String [] args) {
		int arr[][] = {{1, 1, 0, 0, 0, 1},
					   {0, 1, 1, 0, 0, 0},
					   {0, 0, 0, 1, 0, 0}};
		
		int arr2[][] = {{1, 0, 0, 1, 0, 1, 0, 0},
					    {0, 0, 0, 0, 0, 0, 0, 1},
					    {1, 0, 1, 0, 1, 0, 0, 0},
					    {0, 0, 0, 0, 0, 0, 1, 0},
					    {1, 0, 0, 1, 0, 0, 0, 0},
					    {0, 0, 0, 0, 0, 0, 0, 1},
					    {0, 1, 0, 0, 0, 1, 0, 0}};
		
		int size = maxRegion(arr);
		System.out.println("The size is: "+size);
 	}
}