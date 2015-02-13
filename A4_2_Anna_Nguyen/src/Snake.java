
public class Snake extends Animal{
	private boolean poisonus;
	

	public Snake (String latinName, boolean poisonus){
		super(latinName);
	}

	
	public boolean isPoisonus(){
	 return poisonus;
	}

	@Override
	public String getInfo() {
		
		String poison = "poisonus.";
		String notPoison = "not poisonus.";
		
		String info = "";
		info= "The Snake named " + getFriendlyName() + " Latin: " +super.getLatinName() +" is " ;
		
		if(isPoisonus()==true) {
			return info + poison;
			} else {
				return info + notPoison;
		
		
			}
	}
}
