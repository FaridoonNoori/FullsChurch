package AtomicPack;

import java.util.concurrent.atomic.AtomicInteger;

class counter {
	
	//two way that we can make Thread safe
	// 1) Synchronization the method
	// 2) Using Atomic wrapper class
	
	AtomicInteger count= new AtomicInteger();
	
	public  void increament() {
		count.getAndIncrement();
	}
}

public class AtomicMain {
	public static void main(String[] args) throws Exception {
		counter ct= new counter();
		
	  
		Thread t1= new Thread(()-> 
		{
			for(int i=0; i<1000; ++i) ct.increament();			
		});
		
		Thread t2= new Thread(()-> {
			for(int i=0; i<1000; ++i) ct.increament();	
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		
		t2.join();
		
		System.out.print(ct.count);
		
	}	
}
