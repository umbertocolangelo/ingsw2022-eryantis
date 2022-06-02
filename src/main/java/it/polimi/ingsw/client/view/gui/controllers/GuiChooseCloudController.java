package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.ChooseStudentsFromCloud;
import it.polimi.ingsw.message.MessageMethod;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class GuiChooseCloudController {

    /**
     *
     */
    @FXML
    Button buttonNext;

    /**
     *
     */
    private String cloud;

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     *
     * @param mouseEvent
     */
    public void chooseCloud1(MouseEvent mouseEvent) {
        cloud = "50";
    }

    /**
     *
     * @param mouseEvent
     */
    public void chooseCloud2(MouseEvent mouseEvent) {
        cloud = "51";
    }

    /**
     *
     * @param mouseEvent
     */
    public void chooseCloud3(MouseEvent mouseEvent) {
        cloud = "52";
    }

    /**
     * click on start button
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
        MessageMethod messageMethod = new ChooseStudentsFromCloud();
        ((ChooseStudentsFromCloud)messageMethod).setCloud(cloud);
        ControllerHandler.getInstance().write(messageMethod);
    }

    /**
     *
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage= ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/pianificationPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void clickOnExpert1(MouseEvent mouseEvent) {
    }

    public void clickOnExpert2(MouseEvent mouseEvent) {
    }

    public void clickOnExpert3(MouseEvent mouseEvent) {
    }

    public void onBackClick(MouseEvent mouseEvent) {
    }
}
