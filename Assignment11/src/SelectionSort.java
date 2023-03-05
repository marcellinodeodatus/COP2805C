
public class SelectionSort extends Thread {

private int[] a;
	
	public SelectionSort(int[] array) {

		a = array;
	}//end constructor
	
	public void run() {
		
		int n = a.length;
		
		System.out.print("Selection Sort:\n");
		
		for(int i = 0; i < a.length; i++) {
			
			int index = i;
			
			for (int j = i + 1; j < a.length; j++) {
				
				if (a[j] < a[index]) {
				
					index = j;// searching for lowest index
					
				}//end if
				
			}//end inner for-loop
			
			try {
				Thread.sleep(500);
				
				//printing the sorted array
				for (int s = 0; s < n; s++)
				System.out.print(a[s] + " ");
				
				System.out.print("\n");
				
			} catch (Exception ex) {
				
				ex.getStackTrace();
				
			}//end catch
			
			// now swapping of two element in array
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		
		}//end outer for-loop
		
	}//end run()
	
}//end class SelectionSort
