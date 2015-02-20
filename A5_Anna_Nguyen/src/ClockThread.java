import java.util.Calendar;

public class ClockThread extends Thread implements Runnable{
	
	private ClockInterface clockInterface;
	boolean ticking = true;
	int hours;
	int minute;
	int second;

	public ClockThread(ClockInterface ci) {
		this.clockInterface=ci;
	}
	
	public void run(){
		//continuous loop updating the time once a second
		while (ticking == true) {
		        try {
		            Thread.sleep(900);
		        } catch (InterruptedException ex) { 
		        	ex.printStackTrace(); 
		
		        }
		        Calendar cal = Calendar.getInstance();
		        this.hours = cal.get(Calendar.HOUR_OF_DAY);
		        this.minute = cal.get(Calendar.MINUTE);
		        this.second = cal.get(Calendar.SECOND);
		        this.clockInterface.update(hours, minute, second);
		}
		
	}

}
