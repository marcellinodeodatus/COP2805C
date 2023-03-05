
public class MainDriver {
	public static void main(String[] args) {
		GoodStudent gs1 = new GoodStudent();
		Thread t1 = new Thread(gs1);
		BadStudent bs1 = new BadStudent();
		Thread t2 = new Thread(bs1);
		//gs1.doHomeWork();
		//bs1.doHomeWork();
		t1.start();
		t2.start();
		System.out.println("The end of this program");
		SharedContainer sc = new SharedContainer();
		ProducerThread pt  = new ProducerThread(sc);
		ConsumerThread ct = new ConsumerThread(sc);
		pt.start();
		ct.start();
	}
}
