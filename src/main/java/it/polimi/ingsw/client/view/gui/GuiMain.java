package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.view.gui.controllers.GUIController;
import it.polimi.ingsw.client.view.gui.controllers.GuiStartController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application {

    /**
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Eriantys");
        stage.setScene(scene);
        stage.show();

        GuiStartController startController = fxmlLoader.getController();
        startController.resize(stage);
    }

    /**
     *Start the application
     */
    public void launchApp() {
        launch();
    }

}
