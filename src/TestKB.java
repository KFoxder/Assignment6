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

public class TestKB extends TestHarness {

	public TestKB(String s) { super(s); }

	public boolean test() {
		Graph<String,Integer> g = new Graph<String,Integer>();

		try {
			Node<String,Integer> sourceNode = g.addNode("Kevin Bacon");
			g.addNode("Mickey Rourke");
			g.addNode("Marisa Tomei");
			Node<String,Integer> endNode = g.addNode("Joe Pesci");
			g.addEdge("Kevin Bacon", 1, "Mickey Rourke");
			g.addEdge("Mickey Rourke", 1, "Marisa Tomei");
			g.addEdge("Marisa Tomei", 1, "Joe Pesci");
			DijkstrasAlgorithm da = new DijkstrasAlgorithm(g);
			da.execute(sourceNode);
			LinkedList<Node<String,Integer>> ll = da.getPath(endNode);
			System.out.println("\n path: "+ll.toString());
			
			return true;

		} catch (InvalidOperationException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}