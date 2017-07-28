package catan;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Catan {

    private static final Dimension DEFAULT_SIZE = new Dimension(1200, 800);
    private static final Dimension BOARD_SIZE = new Dimension(600, 480);
	
    private Group boardRoot;
	private BorderPane generalGamePane;
	private HBox cardBox;
	private SubScene gameBoard;

    Catan() {
    }

    void init(Stage primaryStage) {
		generalGamePane = new BorderPane(); 
		cardBox = new HBox(); 
		boardRoot = new Group();
		gameBoard = new SubScene(boardRoot, BOARD_SIZE.getWidth(), BOARD_SIZE.getHeight());
		gameBoard.setFill(Color.LIGHTBLUE);
		generalGamePane.setCenter(gameBoard);
		generalGamePane.setBottom(new ScrollPane(cardBox)); 
		setupTiles(boardRoot);
        Scene myScene = new Scene(generalGamePane, DEFAULT_SIZE.getWidth(), DEFAULT_SIZE.getHeight());
        primaryStage.setScene(myScene);
        primaryStage.setResizable(false);
    }
    
    void setupTiles(Group boardRoot){
    		ArrayList<Tile> myTiles = new ArrayList<Tile>();
    		myTiles = addTiles(myTiles);
    		ArrayList<Tile> sortedTiles = pickTiles(myTiles);
    		placeTiles(sortedTiles, boardRoot);
    }

	private void placeTiles(ArrayList<Tile> sortedTiles, Group boardRoot) {
		//for (int i = 0; i < sortedTiles.size(); i++){
		//	boardRoot.getChildren().add(sortedTiles.get(i).getTileImage());
		//}
		//createFirstRow(boardRoot);
		//createSecondRow(boardRoot);
		//createThirdRow(boardRoot);
		//createFourthRow(boardRoot);
		//createFifthRow(boardRoot);
		createRows(boardRoot, sortedTiles);
	}
	
	private void createRows(Group root, ArrayList<Tile> sortedTiles){
		int row = 0;
		int i = 0;
		int numTiles = 0;
		while (numTiles < 19){
				Polygon hex = this.createHexagon((Math.abs(3-(row+1))*60)+i*120,row*90);
				hex.setFill(Color.AQUAMARINE);
				root.getChildren().add(hex);
				sortedTiles.get(numTiles).setTileLocation(((Math.abs(3-(row+1))*60)+i*120), (row*90));
				root.getChildren().add(sortedTiles.get(numTiles).returnTileImage());
				i++;
				numTiles++;
				if (nextRow(numTiles)){
					row ++;
					i = 0;
				}
		}		
	}
	
	private boolean nextRow(int numTiles) {
		return (numTiles == 3 || numTiles == 7 || numTiles == 12 || numTiles == 16);
	}

	private void createFirstRow(Group root){
		for (int i = 1; i < 4; i++){
			Polygon hex = this.createHexagon(i*120, 0);
			hex.setFill(Color.AQUAMARINE);
			root.getChildren().add(hex);
		}
	}
	
	private void createSecondRow(Group root){
		for (int i = 1; i < 5; i++){
			Polygon hex = this.createHexagon(i*120-60, 90);
			root.getChildren().add(hex);
		}
	}
	
	private void createThirdRow(Group root){
		for (int i = 1; i < 6; i++){
			Polygon hex = this.createHexagon(i*120-120, 180);
			root.getChildren().add(hex);
			hex.setFill(Color.YELLOWGREEN);
		}
	}
	
	private void createFourthRow(Group root){
		for (int i = 1; i < 5; i++){
			Polygon hex = this.createHexagon(i*120-60, 270);
			hex.setFill(Color.RED);
			root.getChildren().add(hex);
		}
	}
	
	private void createFifthRow(Group root){
		for (int i = 1; i < 4; i++){
			Polygon hex = this.createHexagon(i*120, 360);
			hex.setFill(Color.YELLOW);
			root.getChildren().add(hex);
		}
	}
	
	private Polygon createHexagon(double x, double y){
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[]{        
				   x, y+30.0, 
				   x, y+90.0, 
				   x+60.0, y+120.0,          
				   x+120.0, y+90.0, 
				   x+120.0, y+30.0,                   
				   x+60.0, y, 
				});
		return polygon;
	}

	private  ArrayList<Tile> pickTiles(ArrayList<Tile> myTiles) {
		ArrayList<Tile> sortedTiles = new ArrayList<Tile>();
		while (!myTiles.isEmpty()){
			int index = new Random().nextInt(myTiles.size());
			sortedTiles.add(myTiles.get(index));
			myTiles.remove(index);
		}
		return sortedTiles;
	}

	private ArrayList<Tile> addTiles(ArrayList<Tile> tiles) {
		for (int i = 0; i < 3; i++){
			Tile brick = new BrickTile();
			tiles.add(brick);
			Tile ore = new OreTile();
			tiles.add(ore);
		}
		for (int i = 0; i < 4; i++){
			Tile wood = new ForestTile();
			tiles.add(wood);
			Tile wheat = new WheatTile();
			tiles.add(wheat);
			Tile sheep = new SheepTile();
			tiles.add(sheep);
		}
		Tile desert = new DesertTile();
		tiles.add(desert);	
		return tiles;
	}
	
	
	
}
