package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.view.gui.controllers.ControllerHandler;
import it.polimi.ingsw.client.view.gui.controllers.GuiStartController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application {

    /**
     * @param stage
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void start(Stage stage) throws IOException {
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Eriantys");
        stage.setScene(scene);
        stage.show();

        GuiStartController startController = fxmlLoader.getController();
        startController.resize(stage, scene);
    }

    /**
     *
     */
    public void launchApp() {
        launch();
    }

}
