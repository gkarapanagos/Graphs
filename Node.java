/**
 * @author @author George Karapanagos (gkarapanagos) and Greg Port (gmport)
 * 
 * The Node class contains the name of the city and a list of all the destinations
 * for which there is a direct flight from this city. 
 */

import java.util.LinkedList;

public class Node {
	private String cityname;
	private LinkedList<Node> getsTo;
	
	/**
	 * Constructor of Class Node
	 * @param String cityname
	 */
	public Node(String cityname){
		this.cityname = cityname;
		this.getsTo = new LinkedList<Node>();
	}
	
	/**
	 * Adds a direct flight between this Node and the given one
	 * @param Node toNode
	 */
	public void addEdge(Node toNode){
		if (getsTo.contains(toNode)){}
		else{
			this.getsTo.add(toNode);
		}
	}
	
	/**
	 * Returns the name of the city of this Node
	 * @return String
	 */
	public String getName(){
		return this.cityname;
	}
	
	/**
	 * Returns all the destinations from this Node
	 * @return LinkedList<Node>
	 */
	public LinkedList<Node> getDestination(){
		return this.getsTo;
	}
}
