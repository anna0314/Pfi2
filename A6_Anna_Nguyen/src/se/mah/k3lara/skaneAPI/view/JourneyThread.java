package se.mah.k3lara.skaneAPI.view;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;

import java.util.Calendar;

public class JourneyThread extends Thread{
	private GUI myGUI;
	private Parser myParser;
	//Parser översätter int till en String, i detta fall översätter den xml filen


	public JourneyThread(Parser parser, GUI gui){
		this.myParser = parser;
		this.myGUI = gui;
	}
	public void run(){
		String searchURL = Constants.getURL(myGUI.textField_from.getText(),myGUI.textField_till.getText(),1); 
		System.out.println(searchURL);							
		System.out.println("// Results when searching:");
		
		Journeys journeys = Parser.getJourneys(searchURL); //Omvandlar XML-filen till Journey klass.
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			myGUI.textArea_result2.append(journey.getStartStation()+" - "+ journey.getEndStation()+" Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. And it is "+journey.getDepTimeDeviation()+" min late");
		} 
		
	

}
	}
