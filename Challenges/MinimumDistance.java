package Challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumDistance {
	public static void main (String[] args) {
		int [][] area = {{ 1, 0, 0,},
						 {1, 0, 0,},
						 {1, 1, 9 }};
		
		int [][] area2 = {{ 1, 1, 1, 0, 0, 1},
						  { 1, 0, 1, 0, 1, 0},
						  { 1, 0, 1, 1, 0, 0},
						  { 0, 1, 1, 1, 1, 0},
						  { 1, 0, 1, 0, 0, 1},
						  { 9, 1, 1, 1, 0, 1}};
		
		System.out.println(minimumDistance(area2.length, area2.length, area2));
	}

	private static int minimumDistance(int i, int j, int[][] area) {
		HashMap <String, Node> graph = new HashMap <String, Node> (); //hash map that will keep the graph
		String end = "";
		String name = ""; 
		//Add the path to the unvisited list
		for (int y = 0; y < i; y++) {
			for (int x = 0; x < j; x++) {
				if (area[y][x] != 0) {
					name = String.valueOf(y)+String.valueOf(x); //create the name string
					Node n = new Node (x, y, name);		//create the node
					//create the adjacency list
					if(x+1 < j && area[y][x+1] != 0) n.addToAdjacencyList(String.valueOf(y)+ String.valueOf(x+1));
					if(x -1 >= 0 && area[y][x-1] != 0) n.addToAdjacencyList(String.valueOf(y)+ String.valueOf(x-1));
					if(y+1 < i && area[y+1][x] != 0) n.addToAdjacencyList(String.valueOf(y+1)+ String.valueOf(x));
					if(y-1 >= 0 && area[y-1][x] != 0) n.addToAdjacencyList(String.valueOf(y-1)+ String.valueOf(x));
					if (x==0 && y==0) n.setDistance(0); //set the distance to 0 for the starting node
					if (area[y][x] == 9) {
						end = String.valueOf(y)+String.valueOf(x); //save the name of the end in a variable
						n.setTarget(); // mark the target
					}
					graph.put(name, n); //add the node to the graph
				}
			}		
		}
		
		String next = "00"; //start from 00
		for (int nd = 0; nd < graph.size(); nd++) { //for each node
			if (graph.get(next).getVisited() == false) { //if unvisited
				graph.get(next).setVisited(); // make it visited
				for (int k = 0; k < graph.get(next).getAdjacencyList().size(); k++) { //for each node in the adjacency list
					String adjName = graph.get(next).getAdjacencyList().get(k);  //get the name
					int adjDistance = graph.get(adjName).getDistance(); //get the distance for the node from the adjacency list
					int currDistance = graph.get(next).getDistance(); //get the distance for the current node
					currDistance++; // update the distance
					if (currDistance < adjDistance) { //if distance of node from adjList greater like from current node plus one 						
						graph.get(adjName).setDistance(currDistance); //update it					
					}
				}
				next = getMinDistance(next , graph); // update the next node to the node from adjList with the smallest distance 
			}
		}		
		return graph.get(end).getDistance(); //return the distance for the target
	}
	//this method will return the name of the node from the adjacency list with the smallest distance 
	private static String getMinDistance(String next, HashMap<String, Node> graph) {
		int d = Integer.MAX_VALUE;
		String name = "";
		for (String n : graph.keySet()) {
			if (graph.get(n).getDistance() < d && !graph.get(n).getVisited()) { //if not visited and distance lower
				d = graph.get(n).getDistance(); //update distance
				name = graph.get(n).getName(); //update name
			}
		}		
		return name;
	}
}