package it.polimi.ingsw.client.view.gui.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        if(GUIController.getInstance().getConnectionRefuse()){
            connection.setText("Connection refused");
            GUIController.getInstance().getClient().setPort(65432);
            GUIController.getInstance().getClient().setIp("localhost");
        }
    }

    /**
     * click on next button
     * @param mouseEvent
     */
    public void onClickEvent(MouseEvent mouseEvent) throws IOException {
        checkPortAndIp();
    }

    /**
     * Enter key is pressed
     * @param keyEvent
     * @throws IOException
     */
    public void onKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            checkPortAndIp();
        }
    }

    /**
     * Checks if the port and ip are valid and changes scene
     * @throws IOException
     */
    private void checkPortAndIp() throws IOException{
        if (!port.getText().isEmpty() || !ip.getText().isEmpty()) { // if one input field is not empty
            if (!port.getText().isEmpty() && !ip.getText().isEmpty()) { // if the input fields are not empty
                if ((port.getText().matches(".*\\d.*") && port.getText().length() < 6) && (ip.getText().matches("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$") || ip.getText().equals("localhost"))) {
                    GUIController.getInstance().getClient().setPort(Integer.parseInt(port.getText()));
                    GUIController.getInstance().getClient().setIp(ip.getText());
                } else {
                    // bad inputs passed
                    connection.setText("You inserted a wrong value");
                    return;
                }
            }else{
                connection.setText("Please insert both ip and port values");
                return;
            }
        }
        if (!GUIController.getInstance().getConnectionTrue()) {
            GUIController.getInstance().startClient();
            loading();
        } else {
            connection.setText("Connection established, waiting for other players");
        }
    }

    /**
     * Show portIp-view
     * @throws IOException
     */
    public void refresh() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/portIp-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiPortIpController loginController = fxmlLoader.getController();
        loginController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * Show login-view scene
     * @throws IOException
     */
    public void login() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiLoginController loginController = fxmlLoader.getController();
        loginController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * Show loading screen
     * @throws IOException
     */
    public void loading() throws IOException {
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
        GuiLoadingController loginController = fxmlLoader.getController();
        loginController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
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
