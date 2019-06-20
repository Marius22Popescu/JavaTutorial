package Hackerrank;
//The kingdom of Zion has cities connected by bidirectional roads. There is a unique path between any pair of cities. 
//Morpheus has found out that the machines are planning to destroy the whole kingdom. If two machines can join forces, 
//they will attack. Neo has to destroy roads connecting cities with machines in order to stop them from joining forces. 
//There must not be any path connecting two machines. Each of the roads takes an amount of time to destroy, and only 
//one can be worked on at a time. Given a list of edges and times, determine the minimum time to stop the attack.
//Complete the function minTime it must return an integer representing the minimum time to cut off access between the machines.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Node{
    private int name;
    private HashMap <Integer, Integer> adjList; 
    private boolean machine;
    private boolean visited;
    private int distance;
    private ArrayList <int []>path;

    Node(int name){
        this.name = name;
        adjList = new HashMap <Integer, Integer> ();
        machine = false;
    }
    public int getName(){
        return name;
    }
    public void addToAdjList(int vx, int time){
        adjList.put(vx, time);
    }
    public HashMap<Integer, Integer> getAdjList (){
        return adjList;
    }
    public boolean isMachine(){
        return machine;
    }
    public void setMachine(){
        machine = true;
    }
}

public class GraphMatrix {
	
	static int minTime(int[][] roads, int[] machines) {
		int minT = 0;
		//Create the graph
        HashMap <Integer, Node> graph = new HashMap <Integer, Node>();
        ArrayList <Integer> roadsToDestroy = new ArrayList <Integer>();
        for (int i = 0; i < roads.length; i++){           
            if (graph.get(roads[i][0]) == null){
                Node n1 = new Node(roads[i][0]);
                n1.addToAdjList(roads[i][1], roads[i][2]);
                graph.put(roads[i][0], n1);
            }
            else graph.get(roads[i][0]).addToAdjList(roads[i][1], roads[i][2]);
            if (graph.get(roads[i][1]) == null){
                Node n1 = new Node(roads[i][1]);
                n1.addToAdjList(roads[i][0], roads[i][2]);
                graph.put(roads[i][1], n1);
            }
            else graph.get(roads[i][1]).addToAdjList(roads[i][0], roads[i][2]);
        }
        //mark the nodes that are machines
        for (int j = 0; j < machines.length; j++){
            graph.get(machines[j]).setMachine();
        }
        
        Iterator <Integer> it = graph.keySet().iterator();
        while(it.hasNext()){
        	if(graph.get(it.next()).isMachine()) djikstra(graph, graph.get(it.next()));
        }
        return minT;

    }
	
	private static void djikstra(HashMap<Integer, Node> graph, Node node) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		System.out.println("ghjhh");
	}

}
