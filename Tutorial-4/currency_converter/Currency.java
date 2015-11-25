package currency_converter;

public class Currency{
	private String name;
	private double rate = 0;
		
	// Constructor that enables creation of currency objects
	Currency (String name, double rate) {
		this.name = name;
		this.rate = rate;
		}
	
	// getter and setter methods for the Currency instances
	public String getName(){
		return this.name;
	}
	public double getRate(){
		return this.rate;
	}
	public void setName(String newName){
		this.name = newName;
	}
	public void setRate(double newRate){
		this.rate = newRate;
	}
	
}



