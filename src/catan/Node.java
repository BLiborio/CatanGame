package catan;

import java.util.ArrayList;

public class Node {
	
	    public String label;
	    public ArrayList<Node> adjacencyList;
	    public ArrayList<Road> roadList;
	    public Settlement settlement;
	    public Port port;
	    public ArrayList<Integer> boardNumbers;
	    public ArrayList<Integer> diceNumbers;
	    public ArrayList<Tile> assignedTiles;
	    
	    public Node (String label) {
	        this.label = label;
	    }

	    public void setNeighbour (Node neighbour) {
	    		if (!this.adjacencyList.contains(neighbour)) {
	    			this.adjacencyList.add(neighbour);
	    		}
	    }
	    
	    public void addRoad(Node end, String color){
	    		Road newRoad = new Road(this, end, color);
	    		if (!this.roadList.contains(newRoad)){
	    			this.roadList.add(newRoad);
	    		}  
	    		Road backRoad = new Road(end, this, color); // ensures road is added both ways
	    		if (!end.roadList.contains(backRoad)){
	    			end.roadList.add(backRoad);
	    		} 
	    }
	    
	    public void addRoadRecurse(Node end, String color){
    			Road newRoad = new Road(this, end, color);
    			if (!this.roadList.contains(newRoad)){
    				this.roadList.add(newRoad);
    				end.addRoadRecurse(this, color);
    			}  
    			else {
    				return;
    			}
	    }

}
