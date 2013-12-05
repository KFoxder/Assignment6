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

public class Test9 extends TestHarness {

    public Test9(String s) { super(s); }

    public boolean test() {
	Graph<String,Integer> g = new Graph<String,Integer>();
	Node<String,Integer> n1;
	Node<String,Integer> n2;

	try {
	    n1 = g.addNode("Kevin");
	    n2 = g.addNode("Mark");
	    g.addEdge(n1, 1, n2);
	    g.addEdge(n1, 1, n2);
	    
	    return false;
	    
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