package DjikstraShortestPath;
public class Path {
  private int Previous;
  private int Next;
  private int path;
  //create the path between two nodes a previous and a next
  public Path(int previous, int Next, int pathLength) {
    this.Previous = previous;  //the previous node
    this.Next = Next;      //the next node
    this.path = pathLength;  //the path length from previous to next nodes
  }
  public int getPrevious() {
    return Previous;
  }
  public int getNext() {
    return Next;
  }
  public int getLength() {
    return path;
  }
  // This method will find the neighboring node of a supplied node
  public int findNeighbour(int n) {
    if (this.Previous == n) {
      return this.Next;
    } else {
      return this.Previous;
   }
  }
}