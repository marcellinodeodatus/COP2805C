//Assignment 11: Sorting
//Deodatus Marcellino
//Due: 12/5/2018

/*Write an program for selection sort, insertion sort, and bubble sort,as shown below. 
 *Create an array of integers 1, 2, ….50. Shuffle it randomly. 
 *You should invoke each sort method in a separate thread. 
 *Each algorithm uses two nested loops. 
 *When the algorithm completes an iteration in the outer loop, put the thread to sleep for 0.5 seconds, and redisplay the array. 
*/

public class MainDriver {
		
	public static int[] generateRandom() {
		
		int[] arr = new int[10];
		System.out.println("printing the random numbers: ");
		for (int i = 0; i < arr.length; i++) {
			int n = (int) (Math.random() * 10 + 1);// creating random number from 0-50
			arr[i] = n; // store randomly generated number into array one by one
			System.out.print(arr[i] + " ");//print the 50 random numbers.
		}//end for-loop
		System.out.print("\n\n");
		return arr;	
	}//end method generateRandom
	
	
	public static void main(String[] args) {
	
	//create an array of 50 ints
	int array[] = generateRandom();
		
	//Bubble Sort
	BubbleSort bs1 = new BubbleSort(array);
	Thread t1 = new Thread(bs1); // Make bs1 as a Thread
	
	//Selection Sort
	SelectionSort ss1 = new SelectionSort(array);
	Thread t2 = new Thread(ss1);
	
	//Insertion Sort
	InsertionSort is1 = new InsertionSort(array);
	Thread t3 = new Thread(is1);
	
	//register to ThreadQueue, hand it to the OS
	t1.start();
	t2.start();
	t3.start();
	
	}//end main

}//end class MainDriver
