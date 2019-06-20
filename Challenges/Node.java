package Challenges;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private int x;
	private int y;
	private List <String> adjacencyList;
	private int distance;
	boolean visited = false;
	boolean target = false;
	 Node (int x, int y, String name) {
		 this.x = x;
		 this.y = y;
		 this.name = name;
		 adjacencyList = new ArrayList<String>();
		 distance = Integer.MAX_VALUE - 5; //assign initial the infinite value
	 }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public List<String> getAdjacencyList() {
		return adjacencyList;
	}
	public void addToAdjacencyList(String elem) {
		adjacencyList.add(elem);
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setVisited () {
		this.visited = true;
	}
	public boolean getVisited() {
		return visited;
	}
	public void setTarget() {
		this.target = true;
	}
	public boolean getTarget() {
		return target;
	}	
}