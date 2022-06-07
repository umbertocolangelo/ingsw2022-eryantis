package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.IsFirst;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiIsFirstController {

    /**
     *
     */
    @FXML
    AnchorPane scenePane;

    /**
     *
     */
    @FXML
    private Label label;

    /**
     *
     */
    @FXML
    private RadioButton threePlayers;

    /**
     *
     */
    @FXML
    private RadioButton expertMode;

    /**
     *
     */
    @FXML
    private RadioButton classicMode;

    /**
     *
     */
    private Integer numOfPLayers;

    /**
     *
     */
    private Boolean expertModeOrClassic;

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     * click on start button
     * @param mouseEvent
     */
    public void onStartClick(MouseEvent mouseEvent) throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiLoadingController controller = fxmlLoader.getController();
        controller.resize(stage, scene);

        if (numOfPLayers==null || expertModeOrClassic==null) {
            label.setText("You must select both the options");
        } else {
            IsFirst isFirst = new IsFirst();
            isFirst.setGameMode(expertModeOrClassic);
            isFirst.setPlayers(numOfPLayers);
            ControllerHandler.getInstance().write(isFirst);
        }
    }

    /**
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/deckAndColor-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiChooseWizardAndColorController deckController = fxmlLoader.getController();
        deckController.resize(stage, scene);
    }

    /**
     *
     */
    public void twoPlayers(MouseEvent mouseEvent) {
        numOfPLayers = 2;
    }

    /**
     *
     */
    public void threePlayers(MouseEvent mouseEvent) {
        numOfPLayers = 3;
    }

    /**
     * @param mouseEvent
     */
    public void classicGame(MouseEvent mouseEvent) {
        expertModeOrClassic = false;
    }

    /**
     * @param mouseEvent
     */
    public void expertGame(MouseEvent mouseEvent) {
        expertModeOrClassic = true;
    }

    /**
     *
     */
    public void resize(Stage stage, Scene scene) {
        double height = stage.getHeight();
        double width = stage.getWidth();

        stage.setMinHeight(450);
        stage.setMinWidth(800);

        //scenePane.translateXProperty().bind(scene.widthProperty().subtract(scenePane.widthProperty().divide(2)));
        //scenePane.translateYProperty().bind(scene.heightProperty().subtract(scenePane.heightProperty().divide(2)));

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
            //scenePane.setCenterShape(true);

        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
            //scenePane.setCenterShape(true);
        });
    }

    /**
     *
     */
    public void closeStage() {
        this.stage.close();
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

}
