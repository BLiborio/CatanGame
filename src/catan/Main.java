package catan;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Initializes cell society and shows the stage.
     *
     * @param primaryStage the primary screen containing the scene
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Catan");
        Catan catan = new Catan();
        catan.init(primaryStage);
        primaryStage.show();
    }
}