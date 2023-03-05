
public class InsertionSort extends Thread{

	private int[] a;

	public InsertionSort(int[] array) {

		a = array;
	}//end constructor

	public void run() {

		int n = a.length;
		
		System.out.print("Insertion Sort:\n");

		for (int j = 1; j < n; j++) { 
			
			int key = a[j]; 
			int i = j - 1;
			while ((i > -1) && (a[i] > key)) {
				a[i + 1] = a[i];
				i--;
			}//end while

			a[i + 1] = key;
			
			try {
				Thread.sleep(500);
				
				//printing the sorted array
				for (int s = 0; s < n; s++)
				System.out.print(a[s] + " ");
				
				System.out.print("\n");
				
			} catch (Exception ex) {
				
				ex.getStackTrace();
				
			}//end catch

		}//end for loop
		
	}//end run

}//end class InsertionSort
