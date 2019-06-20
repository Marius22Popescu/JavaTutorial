package Hackerrank;

import java.util.HashMap;
import java.util.HashSet;
//In this challenge, there is a connected undirected graph where each of the nodes is a color. 
//Given a color, find the shortest path connecting any two nodes of that color. Each edge has a weight of . 
//If there is not a pair or if the color is not found, print .
public class GraphNearestClone {
	
	public static class Vertex{
		private int name;
		private long color;
		private int distance;
		boolean visited;
		private HashSet<Integer> adjList;
		
		Vertex(int name, long color){
			this.name = name;
			this.color = color;
			this.distance = Integer.MAX_VALUE;
			this.visited = false;
			adjList = new HashSet<Integer>();
		}
		public int getName() {
			return name;
		}
		public long getColor() {
			return color;
		}
		public void addToAdjList(int e) {
			adjList.add(e);
		}
		public HashSet<Integer> getAdjList(){
			return adjList;
		}
		public void setVisited() {
			this.visited = true;
		}
		public boolean getVisited() {
			return visited;
		}
		public void setDistance(int d) {
			this.distance = d;
		}
		public int getDistance() {
			return distance;
		}
		public void resetNode() {
			this.distance = Integer.MAX_VALUE;
			this.visited = false;
		}
	}
	
	static int findShortest (int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {	
		int minimum = Integer.MAX_VALUE; //returning value
		//create the graph
		HashMap <Integer, Vertex> graph = new HashMap<Integer, Vertex>();
		for (int i = 0; i < graphNodes; i++) { 
			Vertex v = new Vertex(i+1, ids[i]);
			graph.put(v.getName(), v);
		}
		//update the adjacency list
		int l = graphTo.length;
		for (int i = 0; i < l; i++) {
			graph.get(graphFrom[i]).addToAdjList(graphTo[i]);
			graph.get(graphTo[i]).addToAdjList(graphFrom[i]);
		}
		//find the shortest path connecting two vertexes of the same color 
		for (int i = 1; i < graphNodes+1; i++) { //run djikstras for each node of the desired color
			if (graph.get(i).getColor()== val) {
				int temp = findMinium(graph, i); //find the shortest path given a starting vertex
				if (temp < minimum && temp != 0) minimum = temp;
			}
		}
		if(minimum == Integer.MAX_VALUE) minimum = -1;
		return minimum;
	}
	//this method will find the shortest path for a given vertex to a vertex with the same color 
	private static int findMinium(HashMap<Integer, Vertex> graph, int v) {
		int min = Integer.MAX_VALUE;
		//reset all nodes in the graph
		for (Integer vr: graph.keySet()) {
			graph.get(vr).resetNode();
		}

		graph.get(v).setDistance(0);//set the distance for the starting vertex 0
		graph.get(v).setVisited(); //update visited
		djikstra(graph, v);  //run djikstra 
		//find the minimum distance for the given color
		for (int j = 1; j < graph.size()+1; j++) {
			if (graph.get(j).getDistance() < min && graph.get(j).getColor() == graph.get(v).getColor() && graph.get(j).getDistance() != 0) {
				
				min = graph.get(j).getDistance();
			}
		}
		return min;
	}

	private static void djikstra(HashMap<Integer, Vertex> graph, int next) {
		for (int x =0; x < graph.size(); x++) {
			for (int a: graph.get(next).getAdjList()) { //for each vertex in adjacency list
				if (graph.get(a).getDistance() > graph.get(next).getDistance()+1) //distance of neighbor+1 < distance of current
					graph.get(a).setDistance(graph.get(next).getDistance()+1); //update the distance
			}
			next = getNext(graph); 
			if (!graph.get(next).getVisited()) {
				graph.get(next).setVisited(); //update visited
				djikstra(graph, next);
			}
			else break;
		}
	}

	//This method will return the next node
	private static Integer getNext(HashMap<Integer, Vertex> graph) {
		int next = 1;
		int length = Integer.MAX_VALUE;
		for (int x: graph.keySet()) { //for each vertex in the graph find the lower distance
			if( length > graph.get(x).getDistance() && !graph.get(x).visited) {
				next = x;
				length = graph.get(x).getDistance();
			}
		}
		return next;
	}

	public static void main (String[] Args) {
		int nodes = 5;
		int graphFrom[] = {1, 1, 2, 3};
		int graphTo[] = {2, 3, 4, 5};
		long[] ids = {1, 2, 3, 3, 2};
		int val = 2;
		System.out.println("The answer is: " + findShortest(nodes, graphFrom, graphTo, ids, val));
	}
}