package catan;

public class Road {
	
	public String color;
	public Node start;
	public Node end;

	public Road(Node start, Node end, String color) {
		this.start = start;
		this.end = end;
		this.color = color;
	}

}
