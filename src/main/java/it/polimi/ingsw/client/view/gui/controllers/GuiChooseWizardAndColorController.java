package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiChooseWizardAndColorController {

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     * click on wizard1
     * @param mouseEvent
     */
    public void onWizardClick1(MouseEvent mouseEvent) {
        //appear next button (?)
    }

    /**
     * click on wizard2
     * @param mouseEvent
     */
    public void onWizardClick2(MouseEvent mouseEvent) {
        //appear next button (?)
    }

    /**
     * click on wizard3
     * @param mouseEvent
     */
    public void onWizardClick3(MouseEvent mouseEvent) {
        //appear next button (?)
    }

    /**
     * click on wizard4
     * @param mouseEvent
     */
    public void onWizardClick4(MouseEvent mouseEvent) {
        //appear next button (?)
    }

    /**
     * click on next button
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * click on color white
     * @param mouseEvent
     */
    public void onColorClick1(MouseEvent mouseEvent) {

    }

    /**
     * click on color black
     * @param mouseEvent
     */
    public void onColorClick2(MouseEvent mouseEvent) {

    }

    /**
     * click on color grey
     * @param mouseEvent
     */
    public void onColorClick3(MouseEvent mouseEvent) {

    }

}
