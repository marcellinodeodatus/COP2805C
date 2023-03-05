//Assignment 07
//Deodatus Marcellino
//11/7/2018

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Squares{

	public static void main(String[] args) {

		// bool that controls the program flow
		boolean looping = true;
		Scanner in = null;

		do{
			try {

				// get user input
				in = new Scanner(System.in);
				System.out.println("Enter an integer m ");
				int m = in.nextInt();
				if(m < 1) {
					throw new InputMismatchException();
				}

				// call the methods and print the result
				System.out.println("The smallest number n for m*n to be a perfect square is "+perfectSquare(m));
				System.out.println("m*n is "+(m*perfectSquare(m)));

				// if everything came to here, program executed correctly
				looping = false;
			} catch (InputMismatchException e) {
				System.err.println("Must enter a positive integer\n" + e);
			}
		} while(looping);

	}//end main

	private static ArrayList<Integer> factors(int m) {
		ArrayList<Integer> list = new ArrayList<>();

		// variables
		int temp = m, j = 2;

		//loop until temp gets down to 1
		while (temp != 1) {

			// if temp is divisible, add the divisor to the list and decrement temp
			if (temp % j == 0) {
				list.add(j);
				temp /= j;

				// if it is not divisible, increment the divisor
			} else {
				j++;
			}
		}
		return list;
	}//end method factors

	public static int perfectSquare(int m) {

		// factors of m
		ArrayList<Integer> factors = factors(m);

		// go through all the factors and remove the even
		for (int i = 0; i < factors.size() - 1; i++) {
			for (int j = i + 1; j < factors.size(); j++) {

				// if we find an even amount of duplicates, remove them both
				if (factors.get(i).equals(factors.get(j))) {
					factors.remove(j);
					factors.remove(i);

					// reset the loop back to the start
					i=-1;
					break;
				}
			}
		}

		// multiply all the values in the list
		int number = 1;
		for (int i : factors) {
			number *= i;
		}
		return number;
		
	}//end method perfectSquare
	
}//end class Squares