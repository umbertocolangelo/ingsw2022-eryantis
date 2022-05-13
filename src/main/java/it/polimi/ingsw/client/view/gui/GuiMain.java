package it.polimi.ingsw.client.view.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiMain.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        primaryStage.setTitle("Eriantys");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
