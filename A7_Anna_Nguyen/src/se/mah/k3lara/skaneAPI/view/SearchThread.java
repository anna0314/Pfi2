package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.model.Line;
import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class SearchThread extends Thread {
	private GUI myGUI;
	private Parser myParser;
	private boolean searching = true;

	public SearchThread(GUI gui, Parser parser){
	this.myGUI=gui;
	this.myParser=parser;
	}
	
	public void run(){
		while(searching ==true){
			Lines lines = Parser.getStationResults(new Station("80046"));
			for (Line l : lines.getLines()) {
			myGUI.textAreaLinje.append(l.getLine()+"\n");
			myGUI.textAreaDestination.append(l.getTowards()+"\n");
			int H = l.getDepTime().get(Calendar.HOUR_OF_DAY);
			int M = l.getDepTime().get(Calendar.MINUTE);
			myGUI.textAreaAvgang.append(String.format("%02d",  H)+":"+String.format("%02d", M)+"\n");
			myGUI.textAreaDelayed.append(l.getDepTimeDeviation()+"minuter"+"\n");
				try{
						Thread.sleep(1000);
				} catch (InterruptedException ex) { 
						//ex.printStackTrace(); 
        	}
				
		}
	}
}
}