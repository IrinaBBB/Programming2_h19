package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class UnweightedGraphModifiedDFS<V> extends UnweightedGraph<V> {
    /**
     * Construct an empty graph
     */
    public UnweightedGraphModifiedDFS() {
    }

    /**
     * Construct a graph from vertices and edges stored in arrays
     */
    public UnweightedGraphModifiedDFS(V[] vertices, int[][] edges) {

        super(vertices, edges);
    }

    /**
     * Construct a graph from vertices and edges stored in List
     */
    public UnweightedGraphModifiedDFS(List<V> vertices, List<Edge> edges) {
        super(vertices, edges);
    }

    /**
     * Construct a graph for integer vertices 0, 1, 2 and edge list
     */
    public UnweightedGraphModifiedDFS(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    /**
     * Construct a graph from integer vertices 0, 1, and edge array
     */
    public UnweightedGraphModifiedDFS(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }



}