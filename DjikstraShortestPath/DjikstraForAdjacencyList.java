package DjikstraShortestPath;

public class DjikstraForAdjacencyList {
	//utility function to find the vertex with min distance, from the set of vertices not yet included in shortest path tree  
    int minDistance(int dist[], Boolean sptSet[]) {  
        int min = Integer.MAX_VALUE; // Initialize min value 
        int min_index=-1; //Initialize min index
        for (int v = 0; v < dist.length; v++) 
            if (sptSet[v] == false && dist[v] <= min){ 
                min = dist[v]; 
                min_index = v; 
            }   
        return min_index; 
    }   
    //utility function to print the constructed distance array 
    void printSolution(int dist[], int n) { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < dist.length; i++) System.out.println(i+" \t\t "+dist[i]); 
    }  
    // Dijkstra's single source shortest path for a graph represented using adjacency matrix representation 
    void dijkstra(int graph[][], int src){
    	int vertexNo = graph.length;
        int dist[] = new int[vertexNo]; // The output array. dist[i] will hold the shortest distance from src to i   
        // sptSet[i] will be true if vertex i is included in shortest path tree 
        //or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[vertexNo];          
        for (int i = 0; i < vertexNo; i++) { 
            dist[i] = Integer.MAX_VALUE; // Initialize all distances as INFINITE
            sptSet[i] = false;  // and stpSet[] as false 
        }  
        dist[src] = 0;  // Distance of source vertex from itself is always 0         
        for (int x = 0; x < vertexNo-1; x++) { // Find shortest path for all vertices 
            int u = minDistance(dist, sptSet); // Pick the minimum distance vertex from the set of vertices not yet processed.            
            sptSet[u] = true; // Mark the picked vertex as processed   
            // Update dist value of the adjacent vertices of the picked vertex. 
            for (int y = 0; y < vertexNo; y++)   
            	// Update dist[v] only if is not in sptSet, there is an edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[y] && graph[u][y]!=0 &&  dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][y] < dist[y]) 
                    dist[y] = dist[u] + graph[u][y]; 
        }  
        // print the constructed distance array 
        printSolution(dist, vertexNo); 
    }   
    // Driver method 
    public static void main (String[] args) {        
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},  // create the graph
                                   {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
                                   {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
                                   {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
                                   {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
                                   {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
                                   {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
                                   {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
                                   {0, 0, 2, 0, 0, 0, 6, 7, 0} 
                                 }; 
        DjikstraForAdjacencyList t = new DjikstraForAdjacencyList(); 
        t.dijkstra(graph, 0); 
    } 
}
