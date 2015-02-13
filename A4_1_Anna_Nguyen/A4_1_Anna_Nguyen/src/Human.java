
public class Human {
	private Dog dog;
	private String name;

	
	public Human(String name){
			this.name=name;
		}
				
	
		
	
	public String getName(){
		return this.name;
	}

	public void buyDog(Dog dog){
		this.dog=dog;
	}
	
	public String getInfo(){  
		
		String info ="";
		
		if(dog == null){
	 	info = " äger ingen hund"; 
	 	return name + info;
	 	
		}else{

 		info = info+this.getName() + " äger en hund som heter " + this.dog.getName(); 
 		return info;
		}
		
		

	}
}

	





	


