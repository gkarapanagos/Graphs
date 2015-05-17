/**
 * @author @author George Karapanagos (gkarapanagos) and Greg Port (gmport)
 * 
 * The Graph class contains method to create a network of routes of air 
 * flights and methods to add new ones or view subsets of the network
 */

import java.util.LinkedList;

public class Graph {
	private LinkedList<Node> nodes;
	
	/**
	 * Constructor for Graph class
	 * Creates a new empty LinkedList of Nodes
	 */
	public Graph(){
		this.nodes = new LinkedList<Node>();
	}
	
	
	/**
	 * Adds a new Node to the network of flights
	 * @param String cityname
	 * @return Node
	 */
	public Node newNode(String cityname){
	    Node newN = new Node(cityname);
	    this.nodes.add(newN);
	    return newN;
	  }
	
	
	/**
	 * Adds a direct flight between two cities (nodes)
	 * @param Node from
	 * @param Node to
	 */
	public void addDirectedEdge(Node from, Node to){
	    from.addEdge(to);
	    to.addEdge(from);
	}
	
	/**
	 * Returns subsets of the network of airlines Each subset contains only
	 * cities which are interconnected with flights (even indirect)
	 * @return LinkedList<Network>
	 */
	public LinkedList<Network> getNetworks(){
		LinkedList<Network> networks = new LinkedList<Network>();
		LinkedList<String> visited = new LinkedList<String>();
		for(Node n: this.nodes){
			if(!(visited.contains(n.getName()))){
				Network a = new Network();
				a.addToNetwork(visited,n);
				networks.add(a);
				for (String s: a.cities){
					visited.add(s);
				}
			}
		}
		return networks;
	}

}
