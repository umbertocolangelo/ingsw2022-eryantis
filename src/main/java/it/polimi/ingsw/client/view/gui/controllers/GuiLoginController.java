package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GuiLoginController implements Initializable {

    /**
     *
     */
    @FXML
    AnchorPane scenePane;

    /**
     *
     */
    @FXML
    TextField insertName;

    /**
     *
     */
    @FXML
    Label equalName;

    /**
     *
     */
    private Boolean equal = false;

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
        if (insertName.getText().matches(".*\\d.*")) {
            equalName.setText("The username contains numbers, it not possible to enter numbers");
        } else if (insertName.getText().isEmpty()) {
            equalName.setText("The username cannot be empty");
        } else {
            stage = new Stage();
            ControllerHandler.getInstance().getStage().close();
            ControllerHandler.setStage(stage);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
            scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setScene(scene);
            stage.setTitle("Eriantys");
            stage.show();

            GuiLoadingController loadingController = fxmlLoader.getController();
            loadingController.resize(stage, scene);

            ControllerHandler.getInstance().write(insertName.getText());

            if (ControllerHandler.getInstance().getEqual() == false) {
                ControllerHandler.getInstance().receiveMessage();
            }
        }
    }

    /**
     *
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
     * @throws IOException
     */
    public void changeSceneIsFirst() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/isfirst-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiIsFirstController firstController = fxmlLoader.getController();
        firstController.resize(stage, scene);
    }

    /**
     *
     * @throws IOException
     */
    public void changeSceneEqual() throws IOException {
        ControllerHandler.getInstance().setEqual();
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ControllerHandler.getInstance().getEqual()) {
            equalName.setText("You inserted a username already used");
            System.out.println("Username already used");
        }
    }

    /**
     *
     */
    public void resize(Stage stage, Scene scene) {
        double height = stage.getHeight();
        double width = stage.getWidth();

        stage.setMinHeight(450);
        stage.setMinWidth(800);

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
        });
    }

}
