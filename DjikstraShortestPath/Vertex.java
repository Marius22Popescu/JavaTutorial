package DjikstraShortestPath;
import java.util.ArrayList;
//class to create nodes
public class Vertex {
  private int distToSource = Integer.MAX_VALUE; //assign initial the infinite value 
  private boolean settledVertex;
  private ArrayList<Path> EdgeList = new ArrayList<Path>(); 
  public int getDistanceFromSource() {
    return distToSource;
  }
  public void setDistanceFromSource(int distanceFromSource) {
    this.distToSource = distanceFromSource;
  }
  public boolean isSettled() {
    return settledVertex;
  }
  public void setSettled(boolean visited) {
    this.settledVertex = visited;
  }
  public ArrayList<Path> getEdges() {
    return EdgeList;
  }
  public void setEdges(ArrayList<Path> edges) {
    this.EdgeList = edges;
  }
}
