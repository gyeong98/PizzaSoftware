package com.example.project4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Main class that runs the program
 * @author Geon Yeong Kim, Henry Tao
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Welcome to RUPizzeria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * runs the program.
     * @param args start.
     */
    public static void main(String[] args) {
        launch();
    }
}