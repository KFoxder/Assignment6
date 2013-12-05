/**
 * Test2 -- Example test class testing {@link DijkstrasAlgorithm}
 * <p>
 * This test creates a Graph with a few nodes/edges and runs the algorithm,
 * using the graph found 
 * <a href="http://en.wikipedia.org/wiki/Dijkstra's_algorithm">here</a>
 * ***********************************************************************<br>
 * Computer Science 102: Data Structures<br>
 * New York University, Fall 2013,<br>
 * Lecturers: Eric Koskinen and Daniel Schwartz-Narbonne<br>
 * ***********************************************************************
 *
 * @author      Eric Koskinen       <ejk@cs.nyu.edu>
 * @version     $Revision$
 * @since       2013-11-25
 */

import java.util.LinkedList;

public class Test5 extends TestHarness {

	public Test5(String s) { super(s); }

	public boolean test() {
		Graph<String,Integer> g = new Graph<String,Integer>();

		// Construct the graph from wikipedia:
		Node<String,Integer> n1;
		Node<String,Integer> n2;

		try {
			n1 = g.addNode("Kevin");
			n2 = g.addNode("Mark");
			g.addEdge(n1, 1, n1);
			g.addEdge("Kevin", 3, "Kevin");
			g.addEdge(n2, 1, n2);
			g.addEdge("Mark", 3, "Mark");
			System.out.println(g.toString());

			return true;

		} catch (InvalidOperationException e) {
			e.printStackTrace();
			return false;
		}

	}
}