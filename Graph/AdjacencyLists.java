/**
 *             Assignment3, COMP272
 * Class:      AdjacencyLists.java
 * Purpose:    Represent/model a adjacency lists to implement the graph interface.
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyLists implements Graph {
	
	private int n;	//number of vertices
	
	private List<Integer>[] adj;	//list of vertices with their associated edges
	
	protected static byte white = 0, grey = 1, black = 2;

	/**
	 * Creates a graph of using adjacency lists.
	 * @param n0 - number of vertices
	 */
	@SuppressWarnings("unchecked")
	public AdjacencyLists(int n0) {
		n = n0;
		adj = (List<Integer>[])new List[n];
		for (int i = 0; i < n; i++) 
			adj[i] = new Stack<Integer>();
	}
	
	/**
	 * Gets the number of vertices for a given graph instance. 
	 */
	public int nVertices() {
		return n;
	}
	
	/**
	 * Adds an edge to a give graph instance
	 */
	public void addEdge(int i, int j) {
		adj[i].add(j);
	}

	/**
	 * Checks if a give graph instance has the specified edge.
	 */
	public boolean hasEdge(int i, int j) {
		return adj[i].contains(j);
	}

	/**
	 * Returns a list of all the source vertices given a target vertex.
	 */
	public List<Integer> inEdges(int i) {
		List<Integer> edges = new Stack<Integer>();
		for (int j = 0; j < n; j++)
			if (adj[j].contains(i))	edges.add(j);
		return edges;
	}
	
	/**
	 * Returns a list of all the target vertices given a source vertex.
	 */
	public List<Integer> outEdges(int i) {
		return adj[i];
	}

	/**
	 * Removes a specified edge if it exists in the graph.
	 */
	public void removeEdge(int i, int j) {
		Iterator<Integer> it = adj[i].iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}	
	}
	
	/**
	 * Traverses a graph by starting at a specific vertex and visiting its neighbours
	 * followed by its neighbours neighbours etc. It uses a queue that initially contains
	 * only the beginning vertex. It then repeatedly extracts an element from the queue
	 * and adds its neighbours to the queue, provided that these neighbours have never been
	 * in the queue before.
	 * @param g - graph to be traversed
	 * @param r - vertex to begin traversal at 
	 */
	public static void bfs(Graph g, int r) {
		boolean[] seen = new boolean[g.nVertices()];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(r);
		seen[r] = true;
		while (!q.isEmpty()) {
			int i = q.remove();
			for (Integer j : g.outEdges(i)) {
				if (!seen[j]) {
					System.out.println(convert(i) + " => " + convert(j));
					q.add(j);
					seen[j] = true;
				}
			}
		}
	}
	
	/**
	 * It starts by visiting r. When visiting a vertex i, i is first marked as grey. 
	 * Next, i's adjacency list is scanned and any white vertex in the list is recursively
	 * visited. The traversal is done when i is coloured black.
	 * @param g - graph to be traversed
	 * @param r - vertex to begin traversal at
	 */
	public static void dfs(Graph g, int r) {
		byte[] c = new byte[g.nVertices()];
		Stack<Integer> s = new Stack<Integer>();
		s.push(r);
		while (!s.isEmpty()) {
			int i = s.pop();
			if (c[i] == white) {
				c[i] = grey;
				System.out.print(convert(i) + " ");
				for (int j : g.outEdges(i))
					s.push(j);
			}
		}
	}
	
	
	/**
	 * Traverses each edge in each direction once.
	 * @param graph
	 * @param startVertex
	 * @return
	 */
    public static List<String> dfs2(Graph graph, Integer startVertex) {
        List<String> path = new LinkedList<String>();

        //To prioritize unseen vertices over backtracking.
        Deque<Integer> stack = new ArrayDeque<Integer>();

        //To keep track of which vertices have been traversed.
        stack.push(startVertex);
        
        Integer currentVertex = startVertex;

        while (!stack.isEmpty()) {
            Integer nextVisitable = null;

            for (Integer target : graph.outEdges(currentVertex)) {
                if (graph.hasEdge(currentVertex, target)) {
                    if (!stack.contains(target)) {
                        nextVisitable = target;
                    }
                }

            }

            /*Backtrack if need be. Pick the neighboring vertex that is farthest away
             * from the "root" (bottom of stack).
             */
            if (nextVisitable == null) {
                nextVisitable = graph.getLastAvailOnStack(currentVertex, stack);
            }

            //If subsequent node, traverse the edge to it, removing it from the graph.
            if (nextVisitable != null) {
                graph.removeEdge(currentVertex, nextVisitable);
                path.add(convert(currentVertex));
                stack.add(currentVertex);

                currentVertex = nextVisitable;

            } else {
                stack.pop();
            }
        }

        path.add(convert(currentVertex));

        return path;
    }
	
   /**
    * Returns the last (top-most/most recent) navigatable vertex on the stack, or none if
    * there are no vertices available.
    */
    public Integer getLastAvailOnStack(Integer currentVertex, Deque<Integer> stack) {  
        Iterator<Integer> it = stack.descendingIterator();

        while (it.hasNext()) {
            Integer next = it.next();
            if (hasEdge(currentVertex, next)) {
                return next;
            }
        }

        return null;
    }
	/**
	 * Converts a numerical representation for a vertex to its appropriate letter value.
	 * @param i - integer representation of vertex
	 * @return letter between a and p depending on i
	 */
	public static String convert (int i) {
		switch (i) {
		case 0: 
			return "a";
		case 1: 
			return "b";
		case 2: 
			return "c";
		case 3: 
			return "d";
		case 4: 
			return "e";
		case 5: 
			return "f";
		case 6: 
			return "g";
		case 7: 
			return "h";
		case 8: 
			return "i";
		case 9: 
			return "j";
		case 10: 
			return "k";
		case 11: 
			return "l";
		case 12: 
			return "m";
		case 13: 
			return "n";
		case 14: 
			return "o";
		default: 
			return "p";
		}
	}
	
}
