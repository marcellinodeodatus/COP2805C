
public class ProducerThread extends Thread {
	private SharedContainer sc;
	public ProducerThread(SharedContainer sc){
		super("Producer");
		this.sc = sc;
	}
	public void run(){
		int n=0;
		while(n<5){
			try{
				Thread.sleep((int)(Math.random()*2000));
			}catch(Exception ex){
				System.out.println(ex.toString());
			}
			//produce an item
			sc.setSharedItem(n);
			n++;
		}
	}
}
