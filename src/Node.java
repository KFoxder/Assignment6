/**
 * The Node component of a graph, consisting of a label with generic type T,
 * and {@link outArcs} to edges which have labels of generic type L.
 * <p>
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
import java.util.List;
import java.util.ArrayList;

public class Node<T, L> {
	enum status{
		UNDISCOVERED,
		DISCOVERED,
		FINISHED
	}
	private status stat;
	private T label;
	private ArrayList<Edge<T,L>> outArcs;

	public Node(T l) { label = l; outArcs = new ArrayList<Edge<T,L>>();}

	/** 
	 * Getters and Setters
	 */
	public T getLabel() { return label; }
	public void setLabel(T l) { label = l; }
	public List<Edge<T,L>> getOutArcs() {
		return outArcs;
	}
	public void addOutArc(Edge<T,L> e) {
		outArcs.add(e);
	}
	public void setStatus(status s){
		this.stat = s;
	}
	public status getStatus(){
		return this.stat;
	}


	/** 
	 * Returns a string of the form:
	 * Node(foo)
	 * where "foo" is generated by the label's toString() method
	 */
	public String toString() {
		return "Node("+label.toString()+")";
	}

	/** 
	 * Returns a string of the form:
	 * Node(foo)
	 *   --Edge(53)->Node(bar)
	 *   --Edge(31)->Node(jaz)
	 *   --Edge(98)->Node(zip)
	 * where each outbound edge from the current node is represented, 
	 * and the destination node X is printed via X's toString() method
	 * (not X's toStringWithEdges() method)
	 */
	public String toStringWithEdges() { 
		StringBuilder sb = new StringBuilder(toString()+"\n");
		for (Edge<T,L> e : outArcs) {
			sb.append("  --"+e.toString()+"-->"+e.getTail().toString()+"\n");
		}
		return sb.toString();
	}

}
