package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GuiPortIpController implements Initializable {

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Text connection;

    @FXML
    private TextField port;

    @FXML
    private TextField ip;

    @FXML
    private Text currentIp;

    @FXML
    private Text currentPort;


    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     * Reference to the scene
     */
    private Scene scene;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        currentIp.setText("Your current target ip is " + GUIController.getInstance().getClient().getIp());
        currentPort.setText("Your current target port is " + GUIController.getInstance().getClient().getPort());
        if(GUIController.getInstance().getConnectionRefuse())
            connection.setText("Connection refused, click next to try again");

    }

    /**
     * click on next button
     * @param mouseEvent
     */
    public void onClickEvent(MouseEvent mouseEvent) throws IOException {
        if (port != null && ip != null) {
            if ((port.getText().matches(".*\\d.*") && port.getText().length()<6) && (ip.getText().matches( "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$") || ip.getText().equals("localhost"))) {
                GUIController.getInstance().getClient().setPort(Integer.parseInt(port.getText()));
                GUIController.getInstance().getClient().setIp(ip.getText());
            }
        }
        if (!GUIController.getInstance().getConnectionTrue()) {
            GUIController.getInstance().startClient();
            waiting();
        } else {
            connection.setText("Connection established, waiting for other players");
        }

    }

    /**
     *
     * @throws IOException
     */
    public void refresh() throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/portIp-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiPortIpController loginController = fxmlLoader.getController();
        loginController.resize(stage);
    }

    /**
     *
     * @throws IOException
     */
    public void login() throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiLoginController loginController = fxmlLoader.getController();
        loginController.resize(stage);
    }

    /**
     *
     * @throws IOException
     */
    public void waiting() throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiLoadingController loginController = fxmlLoader.getController();
        loginController.resize(stage);
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
