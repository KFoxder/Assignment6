/**
 * Test1 -- Example test class extending {@link TestHarness}
 * <p>
 * Tests findNode on empty Graph
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

public class Test4 extends TestHarness {

    public Test4(String s) { super(s); }

    public boolean test() {
	Graph<String,Integer> g = new Graph<String,Integer>();
	Node<String,Integer> n1;

	try {
	    n1 = g.findNode("H");
	    System.out.println(g.toString());
	    
	} catch (Exception e) {
		e.printStackTrace();
	    return false;
	}

	// Make sure n1's toStringWithEdges() works correctly
	if(!(n1==null))
	    return false;

	System.out.println(g.toString());
	return true;
    }

}