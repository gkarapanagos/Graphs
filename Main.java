/**
 * @author @author George Karapanagos (gkarapanagos) and Greg Port (gmport)
 * 
 *  The Main class runs the tests in the Examples class.
 */

import tester.*;

public class Main {
	 
	/**
	 * Examples of a Graph to be tested.
	 */
	static Examples E = new Examples ();
	
	/**
	  * Default constructor for Main
	  */
	/**
	 * Runs the checkExpects in the Examples class.
	 * @param args
	 */
	public static void main(String[] args) {
		Tester.run (E) ;	
	}

}
