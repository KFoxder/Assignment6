/**
 * Test1 -- Example test class extending {@link TestHarness}
 * <p>
 * Tests adding null value as node
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

public class Test7 extends TestHarness {

	public Test7(String s) { super(s); }

	public boolean test() {
		Graph<String,Integer> g = new Graph<String,Integer>();
		Node<String,Integer> n1;
		Node<String,Integer> n2;

		try {
			n1 = g.addNode(null);
			return false;

		} catch (InvalidOperationException e) {
			//e.printStackTrace();
			return true;
		} catch (Exception e){
			//e.printStackTrace();
			return false;
		}
	}

}