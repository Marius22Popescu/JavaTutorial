package DjikstraShortestPath;
import java.util.ArrayList;

public class Graph {
  private Vertex[] N;
  private Path[] P;
  private int nodes; //will keep count of number of nodes
  private int edges; //will keep count of number of edges
  //the constructor that will create the graph
  public Graph(Path[] edges) {
    this.P = edges;
    // This will create the nodes. 
    this.nodes = calculateNoOfNodes(edges);
    this.N = new Vertex[this.nodes];
    for (int n = 0; n < this.nodes; n++) {
      this.N[n] = new Vertex();
    }
    // adding edges to nodes
    this.edges = edges.length;
    for (int edgeToAdd = 0; edgeToAdd < this.edges; edgeToAdd++) {
      this.N[edges[edgeToAdd].getPrevious()].getEdges().add(edges[edgeToAdd]);
      this.N[edges[edgeToAdd].getNext()].getEdges().add(edges[edgeToAdd]);
    }
  }
  //This method will calculate the calculate the number o nodes from the edges passed
  //as parameters. It returns a integer: the number of nodes. 
  private int calculateNoOfNodes(Path[] edges) {
    int noOfNodes = 0;
    for (Path e : edges) {
      if (e.getNext() > noOfNodes)
        noOfNodes = e.getNext();
      if (e.getPrevious() > noOfNodes)
        noOfNodes = e.getPrevious();
    }
    noOfNodes++;
    return noOfNodes;
  }
  
  public void calculateShortestDistances() {
    // node 0 as source
    this.N[0].setDistanceFromSource(0);
    int nextNode = 0;
    // visit every node
    for (int i = 0; i < this.N.length; i++) {
      // loop around the edges of current node
      ArrayList<Path> currentNodeEdges = this.N[nextNode].getEdges();
      for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
        int neighbourIndex = currentNodeEdges.get(joinedEdge).findNeighbour(nextNode);
        // only if not visited
        if (!this.N[neighbourIndex].isSettled()) {
          int tentative = this.N[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
          if (tentative < N[neighbourIndex].getDistanceFromSource()) {
            N[neighbourIndex].setDistanceFromSource(tentative);
          }
        }
      }
      // all neighbours checked so node visited
      N[nextNode].setSettled(true);
      // next node must be with shortest distance
      nextNode = getNodeShortestDistanced();
   }
  }

  private int getNodeShortestDistanced() {
    int storedNodeIndex = 0;
    int storedDist = Integer.MAX_VALUE;
    for (int i = 0; i < this.N.length; i++) {
      int currentDist = this.N[i].getDistanceFromSource();
      if (!this.N[i].isSettled() && currentDist < storedDist) {
        storedDist = currentDist;
        storedNodeIndex = i;
      }
    }
    return storedNodeIndex;
  }
  // display result
  public void showResult() {
	  String output = "";  
    for (int i = 0; i < this.N.length; i++) {
    output += ("\nThe shortest distance from source node to node " + i + " is " + N[i].getDistanceFromSource());
    }
    System.out.println(output);
  }
  public Vertex[] getNodes() {
    return N;
  }
  public int getNoOfNodes() {
    return nodes;
  }
  public Path[] getEdges() {
    return P;
  }
  public int getNoOfEdges() {
    return edges;
  }
}