package catan;

public class Port {
	
	public String color = null;
	public String portKind;
	
	public Port(String portKind){
		this.portKind = portKind;
	}
	
	public void setOwner(String color){
		this.color = color;
	}
	
	public String checkOwner(){
		return color;
	}

}
