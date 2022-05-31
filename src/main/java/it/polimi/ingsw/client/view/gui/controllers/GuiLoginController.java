package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GuiLoginController implements Initializable {

    /**
     *
     */
    @FXML
    TextField insertName;

    @FXML
    Label equalName;

    private Boolean equal=false;

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
        if(insertName.getText().matches(".*\\d.*")){
            equalName.setText("The username contains numbers, it not possible to enter numbers");

        }else  if (insertName.getText().isEmpty() ) {
            equalName.setText("The username cannot be empty");
        }else{
                stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
            scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setScene(scene);
            stage.show();
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
        stage= ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/deckAndColor-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void changeSceneIsFirst() throws IOException {
        stage= ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/isfirst-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void changeSceneEqual() throws IOException {
        ControllerHandler.getInstance().setEqual();
        stage= ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(ControllerHandler.getInstance().getEqual()){
            equalName.setText("You inserted a username already used");
            System.out.println("Helllo");
        }
    }
}
