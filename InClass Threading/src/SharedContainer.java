
public class SharedContainer {
	private int sharedItem = -1;
	private boolean itemReady = true;

	public synchronized int getSharedItem() {
		while(itemReady){
			try{
				wait();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		itemReady = true;
		notify();
		System.out.println(Thread.currentThread().getName() +
				   " getting Item " + sharedItem);
		return sharedItem;
	}

	public synchronized void setSharedItem(int sharedItem) {
		while(!itemReady){
			try{
				wait();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() +
						   " setting Item " + sharedItem);
		this.sharedItem = sharedItem;
		itemReady = false;
		notify();
	}

}
