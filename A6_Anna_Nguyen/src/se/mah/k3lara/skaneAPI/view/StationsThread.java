package se.mah.k3lara.skaneAPI.view;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import se.mah.k3lara.skaneAPI.model.Station;

import java.util.ArrayList;


public class StationsThread extends Thread{
	private GUI myGUI;
	private Parser myParser;
	//Parser översätter int till en String, i detta fall översätter den xml filen


	public StationsThread(Parser parser, GUI gui){
		this.myParser = parser;
		this.myGUI = gui;
	}
	public void run(){
		
		//Create ArrayList for the stations
		ArrayList<Station> searchStations = new ArrayList<Station>();		
		//searches for the stations in the API
		searchStations.addAll(Parser.getStationsFromURL(myGUI.textField_hallplats.getText()));

		//Loops through the Stations and prints to the textArea
		for(Station station : searchStations){
			for (Station s: searchStations){
				myGUI.textArea_result.append(s.getStationName() + "   StationNummer: "
						+ s.getStationNbr() + "    latitud: " + s.getLatitude()
						+ "   longitude: " + s.getLongitude() + "\n");
			}
	}
}
}