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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TestKB2 extends TestHarness {

	public TestKB2(String s) { super(s); }

	public boolean test() {
		Graph<String,Integer> g = new Graph<String,Integer>();

		try {
			
			//Actors(Nodes)
			Node<String,Integer> kevinBacon = g.addNode("Kevin Bacon");
			Node<String,Integer> mickeyRourke = g.addNode("Mickey Rourke");
			Node<String,Integer> marisaTomei = g.addNode("Marisa Tomei");
			Node<String,Integer> joePesci = g.addNode("Joe Pesci");
			Node<String,Integer> michaelSheen = g.addNode("Michael Sheen");
			Node<String,Integer> oliverPlatt = g.addNode("Oliver Platt");
			Node<String,Integer> matthewPerry = g.addNode("Matthew Perry");
			Node<String,Integer> dylanMcDermott = g.addNode("Dylan McDermott");
			Node<String,Integer> willFerrell = g.addNode("Will Ferrell");
			Node<String,Integer> zachGalifianakis = g.addNode("Zach Galifianakis");
			Node<String,Integer> bradleyCooper = g.addNode("Bradley Cooper");
			Node<String,Integer> adamSandler = g.addNode("Adam Sandler");
			Node<String,Integer> kevinJames = g.addNode("Kevin James");
			Node<String,Integer> robertDeNiro = g.addNode("Robert De Niro");
			Node<String,Integer> mattDamon = g.addNode("Matt Damon");
			Node<String,Integer> robertDowneyJr = g.addNode("Robert Downey Jr.");
			Node<String,Integer> judeLaw = g.addNode("Jude Law");
			Node<String,Integer> gwynethPaltrow = g.addNode("Gwyneth Paltrow");
			Node<String,Integer> chrisTucker = g.addNode("Chris Tucker");
			//Chris Tucker
			
			
			
			
			
			
			//Movies(Edges)
			g.addBiEdge("Kevin Bacon", 1, "Mickey Rourke"); //Diner
			g.addBiEdge("Mickey Rourke", 1, "Marisa Tomei"); //The Wrestler
			g.addBiEdge("Marisa Tomei", 1, "Joe Pesci"); //My Cousin Vinny
			g.addBiEdge("Kevin Bacon", 1, "Michael Sheen"); //Frost Nixon
			g.addBiEdge("Michael Sheen", 1, "Oliver Platt"); //Frost Nixon
			g.addBiEdge("Oliver Platt", 1, "Matthew Perry"); //Three to Tango
			g.addBiEdge("Matthew Perry", 1, "Dylan McDermott"); //Three to Tango
			g.addBiEdge("Dylan McDermott", 1, "Will Ferrell"); //The Campaign
			g.addBiEdge("Will Ferrell", 1, "Zach Galifianakis"); //The Campaign
			g.addBiEdge("Zach Galifianakis", 1, "Bradley Cooper"); //The Hangover
			g.addBiEdge("Marisa Tomei", 1, "Adam Sandler"); //Anger Management 
			g.addBiEdge("Adam Sandler", 1, "Kevin James"); //Grown Ups
			g.addBiEdge("Joe Pesci", 1, "Robert De Niro"); //Goodfellas
			g.addBiEdge("Robert De Niro", 1, "Matt Damon"); //The Good Shepard
			g.addBiEdge("Mickey Rourke", 1, "Robert Downey Jr."); //Iron Man 2
			g.addBiEdge("Robert Downey Jr.", 1, "Jude Law"); //Sherlock Holmes
			g.addBiEdge("Jude Law", 1, "Gwyneth Paltrow"); //Contagion
			g.addBiEdge("Robert De Niro", 1, "Chris Tucker"); //Silver Linings Playbook
			
			
			
			ArrayList actorsToFindPath = new ArrayList();
			actorsToFindPath.add(chrisTucker);
			actorsToFindPath.add(gwynethPaltrow);
			actorsToFindPath.add(mattDamon);
			actorsToFindPath.add(judeLaw);
			actorsToFindPath.add(zachGalifianakis);
			actorsToFindPath.add(oliverPlatt);
			
			
			
			DijkstrasAlgorithm da = new DijkstrasAlgorithm(g);
			da.execute(kevinBacon);
			Iterator iter = actorsToFindPath.iterator();
			while(iter.hasNext()){
				LinkedList<Node<String,Integer>> ll = da.getPath((Node<String,Integer>) iter.next());
				System.out.println("\n path: "+ll.toString());
			}
			
			
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