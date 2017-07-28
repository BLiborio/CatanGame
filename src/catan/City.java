package catan;

public class City extends Settlement{

	public City(String color) {
		super(color);
	}
	
	@Override
	public int numberOfResources(){
		return 2;
	}

}
