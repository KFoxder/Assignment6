/**
 * Test Class -- The main function that registers and executes tests.
 * <p>
 * Register your new tests in this file by extending {@link Test#main(String[])}
 * <p>
 * ***********************************************************************<br>
 * Computer Science 102: Data Structures<br>
 * New York University, Fall 2013,<br>
 * Lecturers: Eric Koskinen and Daniel Schwartz-Narbonne<br>
 * ***********************************************************************
 *
 * @author      Eric Koskinen       <ejk@cs.nyu.edu>
 * @version     $Revision$
 * @since       2013-09-01
 */

public class Test {

	public static void main(String [] args) {

		TestKB KB = new TestKB("KB");
		TestKB2 KB2 = new TestKB2("KB2");
		Test1 t1 = new Test1("t1");
		Test2 t2 = new Test2("t2");
		Test3 t3 = new Test3("t3");
		Test4 t4 = new Test4("t4");
		Test5 t5 = new Test5("t5");
		Test6 t6 = new Test6("t6");
		Test7 t7 = new Test7("t7");
		Test9 t9 = new Test9("t9");
		Test10 t10 = new Test10("t10");
		Test11 t11 = new Test11("t11");
		Test12 t12 = new Test12("t12");
		Test13 t13 = new Test13("t13");
		Test14 t14 = new Test14("t14");
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		// %%%%% Register your new tests here, by extending this method %%%%%
		// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


		TestHarness.run();
	}
}