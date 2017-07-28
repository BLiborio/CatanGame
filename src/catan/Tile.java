package catan;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Tile {

	public int boardNumber;
	public int diceNumber;
	public String resource;
	public boolean thief;
	public Image myTileImage;
	public ImageView myTileImageView;
	private String tileImageName = null;
	
	public Tile(String resource, String tileImageName){
		this.resource = resource;
		this.tileImageName = tileImageName;
		this.getTileImage();
	}
	
	public ImageView getTileImage() {
		myTileImage = new Image("/tiles/" + tileImageName);
		myTileImageView = new ImageView(myTileImage);
		myTileImageView.setFitHeight(120);
		myTileImageView.setFitWidth(120);
		return myTileImageView;
	}
	
	public ImageView returnTileImage(){
		return myTileImageView;
	}
	
	public ImageView setTileLocation(double x, double y){
		myTileImageView.setX(x);
		myTileImageView.setY(y);
		return myTileImageView;
	}
	
	public void assignBoardNumber(int number){
		this.boardNumber = number;
	}
	
	public void assignDiceNumber(int number){
		this.diceNumber = number;
	}
	
	public void placeThief(){
		thief = true;
	}
	
	public void takeAwayThief(){
		thief = false;
	}
	
	public boolean hasThief(){
		return thief;
	}
	
}
