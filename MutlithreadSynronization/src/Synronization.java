
class Counter
{
	int count;
	
	public synchronized void increament() 
	{
		++count;
	}
}
public class Synronization {

	public static void main(String[] args) throws Exception
	{
		Counter c= new Counter();
		
		Thread t1= new Thread( new Runnable() 
		{
			public void run() 
			{
				for(int i=0; i<1000; ++i)	c.increament();
			}
		});
		
		Thread t2= new Thread( new Runnable() 
		{
			public void run() 
			{
				for(int i=0; i<1000; ++i)	c.increament();
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count"+ c.count);		
	}
}
