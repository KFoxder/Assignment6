import java.util.List;

/**
 * Test1 -- Example test class extending {@link TestHarness}
 * <p>
 * Tests adding edge twice
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

public class Test13 extends TestHarness {

    public Test13(String s) { super(s); }

    public boolean test() {
	Graph<String,Integer> g = new Graph<String,Integer>();
	Node<String,Integer> n1;
	Node<String,Integer> n2;

	try {
	    n1 = g.addNode("Kevin");
	    n2 = g.addNode("Mark");
	    g.addEdge(n1, 1, n2);
	    g.addBiEdge("Kevin", 3, "Mark");
	    g.addEdge("Kevin", 5, "Mark");
	    g.addEdge(n1, 6, n2);
	    
	    List<Edge<String,Integer>> edges = g.getEdges();
	    if(edges.size()!=5){
	    	return false;
	    }
	    List<Node<String,Integer>> nodes = g.getNodes();
	    if(nodes.size()!=2){
	    	return false;
	    }
	    return true;
	    
	} catch (InvalidOperationException e) {
		//e.printStackTrace();
	    return true;
	} catch (Exception e){
		//e.printStackTrace();
		return false;
	}

	// Make sure n1's toStringWithEdges() works correctly
    }

}