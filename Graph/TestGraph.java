/**
 *             Assignment3, COMP272
 * Class:      TestGraph.java
 * Purpose:    Tests Graph and AdjacencyLists classes.
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

public class TestGraph {
	public static void main(String[] args) {
		Graph g = new AdjacencyLists(16);
		g.addEdge(0, 5);
		g.addEdge(0, 4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 0);
		g.addEdge(2, 5);
		g.addEdge(2, 3);
		g.addEdge(2, 1);
		g.addEdge(3, 6);
		g.addEdge(3, 2);
		g.addEdge(4, 8);
		g.addEdge(4, 0);
		g.addEdge(5, 9);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(6, 10);
		g.addEdge(6, 9);
		g.addEdge(6, 7);
		g.addEdge(6, 3);
		g.addEdge(7, 14);
		g.addEdge(7, 6);
		g.addEdge(8, 13);
		g.addEdge(8, 12);
		g.addEdge(8, 9);
		g.addEdge(8, 4);
		g.addEdge(9, 8);
		g.addEdge(9, 6);
		g.addEdge(9, 5);
		g.addEdge(10, 14);
		g.addEdge(10, 6);
		g.addEdge(11, 15);
		g.addEdge(12, 8);
		g.addEdge(13, 14);
		g.addEdge(13, 8);
		g.addEdge(14, 15);
		g.addEdge(14, 13);
		g.addEdge(14, 10);
		g.addEdge(14, 7);
		g.addEdge(15, 14);
		g.addEdge(15, 11);
		
		System.out.println("Depth First Traversal from g: ");
		AdjacencyLists.dfs(g,6);

		System.out.println("\n\nBreadth First Traversal from b: ");
		AdjacencyLists.bfs(g,1);
		
		System.out.println("\nVisit each edge in every direction: ");
		for (String i : (AdjacencyLists.dfs2(g, 6))) {
			System.out.print(i + " ");
		};

		
	}
}