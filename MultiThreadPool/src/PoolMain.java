import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Testable implements Runnable
	{
		String message;
		
		public Testable(String message) {
			this.message= message;
		}
		public void run() {
			System.out.println(Thread.currentThread().getName()+" (Start) message = "+ message);
			try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
			System.out.println(Thread.currentThread().getName()+" (End)");
		}
	}


public class PoolMain {
	public static void main(String[] args) {
		
		ExecutorService Es= Executors.newFixedThreadPool(7);
		
		for(int i=0; i<10; ++i) {
			Runnable r= new Testable(""+i);
			Es.execute(r);
		}
		
		Es.shutdown();
		while(!Es.isTerminated()) {	}
		System.out.print("Finished All thread");
	}
}
