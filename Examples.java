/**
 * @author @author George Karapanagos (gkarapanagos) and Greg Port (gmport)
 * 
 * The Examples class contains an example Graph with given example routes to 
 * check whether the Networks work correctly with the Graph's methods.
 * 
 */
import tester.* ;
import java.util.LinkedList;

public class Examples {
 
 /**
  * Constructor for Examples
  * Calls the initGraph() method
  */
 Examples(){
  initGraph();
 }
 
 private Graph G = new Graph();
 private Node bost, worc, hart, chic, denv, phoe, hous, tuls;
 
 /**
  * Adds all the cities' Nodes to the graph
  * Adds the direct routes between the cities
  */
 public void initGraph(){
  bost = G.newNode("Boston");
  worc = G.newNode("Worcester");
  hart = G.newNode("Hartford");
  chic = G.newNode("Chicago");
  denv = G.newNode("Denver");
  phoe = G.newNode("Phoenix");
  hous = G.newNode("Houston");
  tuls = G.newNode("Tulsa");

  G.addDirectedEdge(bost, worc);
     G.addDirectedEdge(bost, hart);
     
     G.addDirectedEdge(chic, denv);
     
     G.addDirectedEdge(phoe, hous);
     G.addDirectedEdge(hous, tuls);
 }
 
 /**
  * Returns whether the getNetworks() method works as expected
  * @return boolean
  */
 boolean NetworkCheck() {
  Network network1 = new Network();
  network1.addCity(bost);
  network1.addCity(worc);
  network1.addCity(hart);
  
  Network network2 = new Network();
  network2.addCity(chic);
  network2.addCity(denv);
  
  Network network3 = new Network();
  network3.addCity(phoe);
  network3.addCity(hous);
  network3.addCity(tuls);
  
  LinkedList<Network> x = G.getNetworks();

  boolean check = false;
  for( Network o : x){
   check = o.equals(network1) || o.equals(network2) || o.equals(network3);
  }
  return check;
 }
 
 /**
  * Returns whether the equals(Network that) method works as expected
  * @return boolean
  */
 boolean equalsCheck(){
  Network network4 = new Network();
  network4.addCity(bost);
  network4.addCity(worc);
  network4.addCity(hart);
  
  Network network5 = new Network();
  network5.addCity(worc);
  network5.addCity(hart);
  network5.addCity(bost);
  
  return network4.equals(network5);
 }
 
 
 /**
  * Tests the NetworkCheck() method
  * @param t
  * @return boolean
  */
 boolean testNetworks(Tester t){
  return t.checkExpect(NetworkCheck(), true);
 }
 
 /**
  * Tests the equalsCheck() method
  * @param t
  * @return boolean
  */
 boolean testEquals(Tester t){
  return t.checkExpect(equalsCheck(), true);
 }
 
 /**
  * Returns a boolean telling whether a city is successfully added to a network
  * @return boolean
  */
 boolean addCityCheck(){
   Network y = new Network();
   y.addCity(bost);
   if(y.cities.contains("Boston")){
     return true;
   }
   else
        return false;
 }
 
 /**
  * Tests the addCityCheck() method
  * @param t
  * @return boolean
  */
 boolean testAddCity(Tester t){
  return t.checkExpect(addCityCheck(), true);
 }
 
 /**
  * Tests that the getName() method returns the name of the Node
  * @param t
  * @return boolean
  */
 boolean testGetName(Tester t){
  return t.checkExpect(bost.getName(), "Boston");
 }
 
 /**
  * Returns a boolean telling whether getDestination obtained all nodes that are edges to a given node
  * @return boolean
  */
 boolean getDestinationCheck(){
   LinkedList<Node> z = bost.getDestination();
   if(z.contains(worc) && z.contains(hart)){
     return true;
   }
   else
        return false;
 }
 
 /**
  * Tests that the getDestination() method returns a list of nodes that the node has edges with
  * @param t
  * @return boolean
  */
 boolean testGetDestination(Tester t){
  return t.checkExpect(getDestinationCheck(), true);
 }
}
