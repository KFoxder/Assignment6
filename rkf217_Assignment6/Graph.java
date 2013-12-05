/**
 * A basic generic graph
 * <p>
 * This implements a basic directed graph with nodes and edges both having
 * their own generic type (nodes have labels of type T, edges have labels of
 * type L).
 * ***********************************************************************<br>
 * Computer Science 102: Data Structures<br>
 * New York University, Fall 2013,<br>
 * Lecturers: Eric Koskinen and Daniel Schwartz-Narbonne<br>
 * ***********************************************************************
 *
 * @author      Eric Koskinen <ejk@cs.nyu.edu>
 * @version     $Revision$
 * @since       2013-11-08
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class Graph<T, L> {

	// Add private data here.
	private HashMap<T,Node<T,L>> nodes;
	private ArrayList<Edge<T,L>> edges;

	public Graph() {
		nodes = new HashMap<T,Node<T,L>>();
		edges = new ArrayList<Edge<T,L>>();

	}

	/** 
	 * Look for an existing node with label @lab and return it.
	 * Return null if no such node exists.
	 */
	public Node<T,L> findNode(T lab) {

		for(Entry<T, Node<T, L>> n : nodes.entrySet()){
			if(n.getKey().equals(lab)){
				return n.getValue();
			}	
		}
		//If we get here, we haven't found it and return null.
		return null;
	}

	/** 
	 * Add a new node to the graph. The new node will have label {@link lab}
	 * unless a node consisting of {@link lab} already existed, in which case
	 * this method throws an {@link InvalidOperationException}.
	 */
	public Node<T,L> addNode(T lab) throws InvalidOperationException {
		if(lab==null){
			throw new InvalidOperationException("Cannot input null value into addNode().");
		}else{
			if(findNode(lab)==null){
				Node<T,L> newNode = new Node<T,L>(lab);
				nodes.put(lab, newNode);
				return newNode;
			}else{
				throw new InvalidOperationException("Cannot input same key value into graph.");
			}

		}

	}


	/** 
	 * Return a list of all of the nodes in the Graph.
	 */
	public List<Node<T,L>> getNodes() {

		//Iterate through hashmap and return List of nodes
		ArrayList<Node<T,L>> nodeList = new ArrayList<Node<T,L>>();
		for(Entry<T, Node<T, L>> n : nodes.entrySet()){
			nodeList.add(n.getValue());
		}

		return nodeList;


	}
	
	public List<Edge<T,L>> getEdges() {
		return edges;	
	}

	/** 
	 * Create an edge with label l. This node only succeeds if there
	 * is already a node with label n, and another node with label m.
	 * Note: this is a multi-graph: there may be multiple edges
	 * between two nodes, as long as they have distinct labels.
	 * Note also that this is a directed graph, so there is an important
	 * difference between addEdge(a,x,b) and addEdge(b,x,a).
	 *
	 * If a node with label n doesn't already exist, throws an
	 * InvalidOperationException. Same thing if a node with label m
	 * doesn't already exist.
	 */
	public Edge<T,L> addEdge(T n, L l, T m) throws InvalidOperationException {
		if(n==null||l==null||m==null){
			throw new InvalidOperationException("Cannot create edge with null values. Check your input to the addEdge() function");
		}else{
			Node<T,L> tail = findNode(n);
			Node<T,L> head = findNode(m);
			if(head!=null && tail!=null){
				//Check if there is an arc with same label and if its to the same node
				for(Edge<T,L> e:tail.getOutArcs()){
					if(e.getLabel().equals(l) && e.getHead().equals(head)){
						throw new InvalidOperationException("Edge with same label "+l.toString()+" already exists from node "+
								tail.toString()+" to "+head.toString());
					}
				}
				Edge<T,L> newEdge = new Edge<T,L>(l,head,tail);
				tail.addOutArc(newEdge);
				edges.add(newEdge);
				return newEdge;
			}else{
				throw new InvalidOperationException("Cannot add Edge if a node with label n and a node with label m do not exist already.");
			}
		}

	}

	/** 
	 * Variant of {@link addEdge} in which the Nodes are specified
	 * rather than node labels.
	 */
	public Edge<T,L> addEdge(Node<T,L> n, L l, Node<T,L> m) throws InvalidOperationException {

		if(n==null||l==null||m==null){
			throw new InvalidOperationException("Cannot create edge with null values. Check your input to the addEdge() function");
		}else{
			Node<T,L> head = m;
			Node<T,L> tail = n;
			if(head!=null && tail!=null){
				//Check if there is an arc with same label and if its to the same node
				for(Edge<T,L> e:tail.getOutArcs()){
					if(e.getLabel().equals(l) && e.getHead().equals(head)){
						throw new InvalidOperationException("Edge with same label "+l.toString()+" already exists from node "+
								tail.toString()+" to "+head.toString());
					}
				}
				Edge<T,L> newEdge = new Edge<T,L>(l,head,tail);
				tail.addOutArc(newEdge);
				edges.add(newEdge);
				return newEdge;
			}else{
				throw new InvalidOperationException("Cannot add Edge if a node with label n and a node with label m do not exist already.");
			}
		}

	}

	/** 
	 * Add an edge from n to m, as well as an edge from m to n.
	 */
	public void addBiEdge(T n, L l, T m) throws InvalidOperationException {

		if(n==null||l==null||m==null||n.equals(m)){
			throw new InvalidOperationException("Cannot create edge with null values or create an edge to the same node. Check your input ot the addEdge() function");
		}else{
			Node<T,L> front = findNode(n);
			Node<T,L> back = findNode(m);
			if(front!=null && back!=null){
				for(Edge<T,L> e:front.getOutArcs()){
					if(e.getLabel().equals(l) && e.getHead().equals(back)){
						throw new InvalidOperationException("Edge with same label "+l.toString()+" already exists from node "+
								back.toString()+" to "+front.toString());
					}
				}
				for(Edge<T,L> e:back.getOutArcs()){
					if(e.getLabel().equals(l) && e.getHead().equals(front)){
						throw new InvalidOperationException("Edge with same label "+l.toString()+" already exists from node "+
									front.toString()+" to "+back.toString());
					}
				}
				Edge<T,L> newEdge = new Edge<T,L>(l,front,back);
				back.addOutArc(newEdge);
				edges.add(newEdge);
				Edge<T,L> newEdge2 = new Edge<T,L>(l,back,front);
				front.addOutArc(newEdge2);
				edges.add(newEdge2);
				
			}else{
				throw new InvalidOperationException("Cannot add Edge if a node with label n and a node with label m do not exist already.");
			}
		}


	}

	/** 
	 * Display the graph as in the Assignment description
	 */
	public String toString() {

		StringBuilder string = new StringBuilder();
		for(Entry<T, Node<T, L>> n : nodes.entrySet()){
			string.append(n.getValue().toStringWithEdges());
		}
		
		return string.toString();

	}

}
