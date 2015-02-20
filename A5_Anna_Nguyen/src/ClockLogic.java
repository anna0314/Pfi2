
public class ClockLogic implements ClockInterface{
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	public int myHour;
	public int myMinute;
	public int mySecond;
		
	public ClockLogic(DigitalClockGUI clockIn){
		clockGUI = clockIn;
		
		//create and start a new updating thread. Calls the run() method when started
		Thread myThread = new Thread(new ClockThread(this));
		myThread.start(); 
	}
	
	public void setAlarm (int hours, int minute){
		alarmHour = hours;
		alarmMinute = minute;
		
	}
	public void clearAlarm(){
		alarmHour = 25;
		alarmMinute = 61;
		
	}
	@Override
	public void update(int hours, int minute, int second) {
		//sets 0 if number is single digit 
		String zeroH = "";
		String zeroM = "";
		String zeroS = "";

		if(hours<10){
			zeroH = "0"+zeroH;
		}
			
		if(minute<10){
			zeroM = "0"+zeroM;
		}
		
		if(second<10){
			zeroS= "0"+zeroS;
		}
		//Convert into String
		String H = zeroH + Integer.toString(hours);
		String M = zeroM + Integer.toString(minute);
		String S = zeroS + Integer.toString(second);
		
		//Gather everything in one String
		String time = H + ":" + M + ":" + S;
		
		//For the DigitalClockGUI class
		clockGUI.setTimeOnLabel(time);
		
		//variables to check the alarm
		myHour = hours;
		myMinute = minute;
		mySecond = second;
		
		//if the alarm time matches with the real time, the alarm will run in the GUI class
		if(alarmHour == myHour)
			if(alarmMinute == myMinute){
			clockGUI.alarm(true);
			
		}
	}
	
}
