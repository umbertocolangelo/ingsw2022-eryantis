package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.IsFirst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    private Integer numOfPlayers = null;

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
     * @throws IOException
     */
    public void onStartClick(MouseEvent mouseEvent) throws IOException {
        checkPlayersAndMode();
    }

    /**
     * Enter key is pressed
     * @param keyEvent
     * @throws IOException
     */
    public void onKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            checkPlayersAndMode();
        }
    }

    /**
     * Checks if number of players and mode are valid and changes scene
     * @throws IOException
     */
    private void checkPlayersAndMode() throws IOException {
        if (numOfPlayers==null || expertModeOrClassic==null) {
            label.setText("You must select both the options");
            return;
        }

        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiLoadingController controller = fxmlLoader.getController();
        controller.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
        IsFirst isFirst = new IsFirst();
        isFirst.setGameMode(expertModeOrClassic);
        isFirst.setPlayers(numOfPlayers);
        GUIController.getInstance().write(isFirst);
    }

    /**
     * go to chooseDeckAndColor scene
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/deckAndColor-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiChooseWizardAndColorController deckController = fxmlLoader.getController();
        deckController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * Click on two players game
     */
    public void twoPlayers(MouseEvent mouseEvent) {
        numOfPlayers = 2;
    }

    /**
     * Click on three players game
     */
    public void threePlayers(MouseEvent mouseEvent) {
        numOfPlayers = 3;
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

        double height = stage.getScene().getHeight();
        double width = stage.getScene().getWidth();

        //stage min sizes
        stage.setMinHeight(450);
        stage.setMinWidth(800);

        //horizontal listener
        stage.getScene().widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = (newVal.doubleValue()/width);
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        //vertical listener
        stage.getScene().heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = (newVal.doubleValue()/height);
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }

}
