
public class BubbleSort extends Thread {

	private int[] a;
	
	public BubbleSort(int[] array) {

		a = array;
	}

	public void run() {
		
		int n = a.length;
		int temp = 0;
		
		System.out.print("Bubble Sort:\n");
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 1; j < (n - i); j++) {

				if (a[j - 1] > a[j]) {
				
					temp = a[j - 1];

					a[j - 1] = a[j];

					a[j] = temp;
				}//end if

			}//end inner loop
			
			try {
				Thread.sleep(500);
				
				
				
				
				//printing the sorted array		
				for (int s = 0; s < a.length; s++) {
					
					System.out.print(a[s] + " ");
	
				}//end for-loop
				
				System.out.print("\n");
				
			} catch (Exception ex) {
				
				ex.getStackTrace();
				
			}//end catch
		
		}//end outer loop	
	
	}//end run()
	
}//end class BubbleSort

