/*Assignment 03
 * Deodatus Marcellino
 * */
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		
		//create array of numbers, words, and radius
		Integer[] num = {1,2,3};
		String[] word = {"red", "green", "blue"};
		Double[] radius = {3.0, 2.9, 5.9};
		
		//print the arrays
		System.out.println(max(num));
		System.out.println(max(word));
		System.out.println("Circle radius: " +max(radius));
	
	}//end main


	//comparable method
	public static <E extends Comparable<E>> E max(E[] list) {
		
		E maxValue = list[0]; //set the first value in the array as maximum

		
		for (int i = 1; i < list.length; i++) {
		if (list[i].compareTo(maxValue) > 0) 
		//if value in list[i] is greater than max and is positive(greater than 0), the max value is replaced by list[i]
		
		maxValue = list[i];
		}
		  
		return maxValue;
		
		}//end method Comparable
	
}//end class Driver