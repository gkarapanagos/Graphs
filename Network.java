/**
 * @author @author George Karapanagos (gkarapanagos) and Greg Port (gmport)
 * 
 * The Network class contains method to create a Network of cities
 * that are interconnected with direct or indirect flights
 */

import java.util.LinkedList;

public class Network {
 LinkedList<String> cities;
 
 /**
  * Constructor for class Network
  * Creates a new empty LinkedList of Strings
  */
 public Network(){
  this.cities = new LinkedList<String>();
 }
 
 /**
  * Adds the given city to the Network
  * @param Node city
  */
 public void addCity(Node city){
  if (this.cities.contains(city)){}
  else{
   this.cities.add(city.getName());
  }
 }
 
 /**
  * Add the given city to the Network
  * Only if that city hasn't been visited yet
  * @param LinkedList<String> visited
  * @param Node city
  */
 public void addToNetwork(LinkedList<String> visited,Node city) {
  if (visited.contains(city.getName())) {
   
  }
  else{
   this.addCity(city);
   visited.add(city.getName());
   for (Node w: city.getDestination()){
    this.addToNetwork(visited, w);
   }
  }
 }
 
 /**
  * Checks whether the given Network has the same cities
  * as this Network in its LinkedList<String>
  * @param Network that
  * @return boolean
  */
 public boolean equals(Network that){
  boolean check = false;
  for (String f: that.cities){
   if (this.cities.contains(f)){
    check = true;
   }
   else{
    return false;
   }
  }
  return check;
 }
}
