/**
 *             Assignment3, COMP272
 * Class:      Graph.java
 * Purpose:    Represent/model a graph.
 *
 * @author:    Valli Subasri
 * Student ID: 3286510
 * Date:       August 30, 2016
 * Version     1.0
 *
 */

import java.util.Deque;
import java.util.List;

public interface Graph {
	

	/**
	 * This interface represents a directed graph whose vertices are
	 * indexed by 0,...,nVertices()-1
	 * @author morin
	 *
	 */
		public int nVertices();
		public void addEdge(int i, int j);
		public void removeEdge(int i, int j);
		public boolean hasEdge(int i, int j);
		public List<Integer> outEdges(int i);
		public List<Integer> inEdges(int i);
	    public Integer getLastAvailOnStack(Integer currentVertex, Deque<Integer> stack);
}
