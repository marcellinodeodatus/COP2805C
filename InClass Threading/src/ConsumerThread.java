
public class ConsumerThread extends Thread {
	private SharedContainer sc;
	ConsumerThread(SharedContainer sc){
		super("Consumer");
		this.sc = sc;
	}
	public void run(){
		int n, total=0;
		do{
			try{
				Thread.sleep((int)(Math.random()*2000));
			}catch(Exception ex){
				System.out.println(ex.toString());
			}
			//Consume the item
			n = sc.getSharedItem();
			total += n;
		}while(n!=4);
		System.out.println(getName() +
						   " receiving total values: " + total +
						   "\nand is now terminating " + getName());
	}
}
