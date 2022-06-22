package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.IsFirst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiIsFirstController {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Label label;

    /**
     * Reference to the number of players selected
     */
    private Integer numOfPLayers = null;

    /**
     * Reference to selected mode
     */
    private Boolean expertModeOrClassic = null;

    /**
     * Reference to stage
     */
    private Stage stage;

    /**
     * Reference to scene
     */
    private Scene scene;

    /**
     * Click on start button
     * @param mouseEvent
     */
    public void onStartClick(MouseEvent mouseEvent) throws IOException {

        if (numOfPLayers==null || expertModeOrClassic==null) {
            label.setText("You must select both the options");
            return;
        }

        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiLoadingController controller = fxmlLoader.getController();
        controller.resize(stage);

        IsFirst isFirst = new IsFirst();
        isFirst.setGameMode(expertModeOrClassic);
        isFirst.setPlayers(numOfPLayers);
        GUIController.getInstance().write(isFirst);
    }

    /**
     * go to chooseDeckAndColor scene
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/deckAndColor-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiChooseWizardAndColorController deckController = fxmlLoader.getController();
        deckController.resize(stage);
    }

    /**
     * Click on two players game
     */
    public void twoPlayers(MouseEvent mouseEvent) {
        numOfPLayers = 2;
    }

    /**
     * Click on three players game
     */
    public void threePlayers(MouseEvent mouseEvent) {
        numOfPLayers = 3;
    }

    /**
     * Click on classic mode
     * @param mouseEvent
     */
    public void classicGame(MouseEvent mouseEvent) {
        expertModeOrClassic = false;
    }

    /**
     * Click on expert mode
     * @param mouseEvent
     */
    public void expertGame(MouseEvent mouseEvent) {
        expertModeOrClassic = true;
    }

    /**
     * Window resize
     */
    public void resize(Stage stage) {
        double height = stage.getHeight();
        double width = stage.getWidth();

        //stage min sizes
        stage.setMinHeight(450);
        stage.setMinWidth(800);

        //horizontal listener
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        //vertical listener
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }

}
