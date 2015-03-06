package se.mah.k3lara.skaneAPI.model;

import java.util.Calendar;

public class Line {
	private String line;
	private Calendar depTime;
	private String depTimeDeviation;
	
	private String name;
	private String isTimingPoint;
	private String stopPoint;
	private String lineTypeId;
	private String lineTypeName;
	private String towards;
	private String depDeviationAffect;
	private String trainNo;
	private String runNo;
	
	
	public Line() {
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public Calendar getDepTime() {
		return depTime;
	}
	public void setDepTime(Calendar depTime) {
		this.depTime = depTime;
	}
	public String getDepTimeDeviation() {
		return depTimeDeviation;
	}
	public void setDepTimeDeviation(String depTimeDeviation) {
		this.depTimeDeviation = depTimeDeviation;
	}
	
	//More methods here for the rest of the tags
	//And perhaps some special methods ????
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getIsTimingPoint(){
		return isTimingPoint;
	}
	public void setIsTimingPoint(String isTimingPoint){
		this.isTimingPoint = isTimingPoint;
	}
	
	public String getStopPoint(){
		return stopPoint;
	}
	public void setStopPoint(String stopPoint){
		this.stopPoint = stopPoint;
	}
	
	public String getLineTypeId(){
		return lineTypeId;
	}
	public void setLineTypeId(String lineTypeId){
		this.lineTypeId = lineTypeId;
	}
	
	public String getLineTypeName(){
		return lineTypeName;
	}
	public void setLineTypeName(String lineTypeName){
		this.lineTypeName = lineTypeName;
	}
	
	public String getTowards(){
		return towards;
	}
	public void setTowards(String towards){
		this.towards = towards;
	}
	
	public String getDepDeviationAffect(){
		return depDeviationAffect;
	}
	public void setDepDeviationAffect(String depDeviationAffect){
		this.depDeviationAffect = depDeviationAffect;
	}
	
	public String getTrainNo(){
		return trainNo;
	}
	public void setTrainNo(String trainNo){
		this.trainNo = trainNo;
	}
	
	public String getRunNo(){
		return runNo;
	}
	public void setRunNo(String runNo){
		this.runNo = runNo;
	}
}
