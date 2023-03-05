
public class BadStudent extends Thread{
	//public void doHomeWork(){
	public void run(){
		for(int i=0; i<20; i++){
			System.out.println("I am playing the Game hard.");
			try{
				Thread.sleep(1000);
			}catch(Exception ex){
				ex.getStackTrace();
			}
		}
	}

}
