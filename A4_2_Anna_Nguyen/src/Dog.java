public class Dog extends Mammal  {
	private boolean stupid;

	
	public Dog(String latinName, int gestationTime, boolean stupid){
		
		super(latinName, gestationTime);
		this.stupid = stupid;

	}
	
	public Dog (String friendlyName, String latinName, int gestationTime, boolean stupid){
	
		super(latinName, gestationTime);
		this.stupid = stupid;
		super.setFriendlyName(friendlyName);
	
	}
	
	
	public boolean isStupid(){
		return stupid;
	}

	@Override
	public String getInfo() {
		
		String stupid = "stupid.";
		String notStupid = "not stupid.";
		
		String info = "";
		info= "The dog named " +super.getFriendlyName() + " Latin: " +super.getLatinName()+ " has the gestation time " + super.getGestationTime()  +" days and is ";
		
		if(isStupid()==true) {
			return info + stupid;
			} else {
				return info + notStupid;
		
		
			}	
	
	}	
}

