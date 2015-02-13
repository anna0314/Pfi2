
public class Cat extends Mammal {
	private int numberOfLives;
	
	public Cat(String latinName, int gestationTime, int numberOfLives){
		super(latinName, gestationTime);
		this.numberOfLives=numberOfLives;
	
}



	public int getNumberOfLives(){
		return this.numberOfLives;
}


	public void setNumberOfLives(int lives){
		this.numberOfLives = lives;
	
}

	@Override
	public String getInfo() {
	
		return "The cat named " + getFriendlyName() + " with the latin name "+ super.getLatinName() + " has the gestation time " + super.getGestationTime()+" days and has "+numberOfLives+" lives." ;
}

}
