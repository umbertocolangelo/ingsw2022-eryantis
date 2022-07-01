package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseColorCardController implements Initializable {

    /**
     * Reference to the anchor pane to resize
     */
    @FXML
    private AnchorPane scenePane;

    /**
     * Shadows
     */
    private ImageView lastLight = null;

    /**
     * Reference to color to send at the model
     */
    private String color;

    @FXML
    private ImageView colorBlue;
    @FXML
    private ImageView colorYellow;
    @FXML
    private ImageView colorRed;
    @FXML
    private ImageView colorPink;
    @FXML
    private ImageView colorGreen;

    /**
     * Reference to paths of students images
     */
    private String yellowPath = "/Graphical_Assets/pawns/student_yellow.png";
    private String redPath = "/Graphical_Assets/pawns/student_red.png";
    private String bluePath = "/Graphical_Assets/pawns/student_blue.png";
    private String greenPath = "/Graphical_Assets/pawns/student_green.png";
    private String pinkPath = "/Graphical_Assets/pawns/student_pink.png";

    /**
     * Initialize the scene
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colorBlue.setImage(new Image(getClass().getResourceAsStream(bluePath)));
        colorGreen.setImage(new Image(getClass().getResourceAsStream(greenPath)));
        colorPink.setImage(new Image(getClass().getResourceAsStream(pinkPath)));
        colorYellow.setImage(new Image(getClass().getResourceAsStream(yellowPath)));
        colorRed.setImage(new Image(getClass().getResourceAsStream(redPath)));
    }

    /**
     * Click on select color button
     * @param mouseEvent
     */
    public void clickSelectColor(MouseEvent mouseEvent) {
        if (color != null) {
            MessageMethod messageMethod = new PlayExpertCard();
            switch (GUIController.getInstance().getIdExpertCardPlayed()) {
                case "46":
                    GUIController.getInstance().setIdExpertCardPlayed();
                    ((PlayExpertCard) messageMethod).setExpertCard("46");
                    ((PlayExpertCard) messageMethod).setParameter(color);
                    GUIController.getInstance().write(messageMethod);
                    break;
                case "49":
                    GUIController.getInstance().setIdExpertCardPlayed();
                    ((PlayExpertCard) messageMethod).setExpertCard("49");
                    ((PlayExpertCard) messageMethod).setParameter(color);
                    GUIController.getInstance().write(messageMethod);
                    break;
            }
        }
    }

    /**
     * Click on blue
     * @param mouseEvent
     */
    public void clickOnBlue(MouseEvent mouseEvent) {
        setShadow(colorBlue);
        color = "8";
    }

    /**
     * Click on red
     * @param mouseEvent
     */
    public void clickOnRed(MouseEvent mouseEvent) {
        setShadow(colorRed);
        color = "10";
    }

    /**
     * Click on yellow
     * @param mouseEvent
     */
    public void clickOnYellow(MouseEvent mouseEvent) {
        setShadow(colorYellow);
        color = "7";
    }

    /**
     * Click on green
     * @param mouseEvent
     */
    public void clickOnGreen(MouseEvent mouseEvent) {
        setShadow(colorGreen);
        color = "9";
    }

    /**
     * Click on pink
     * @param mouseEvent
     */
    public void clickOnPink(MouseEvent mouseEvent) {
        setShadow(colorPink);
        color = "11";
    }

    /**
     * Window resize
     * @param stage Stage
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

    /**
     * Sets shadows on images
     * @param setImage
     */
    private void setShadow(ImageView setImage) {
        setImage.setEffect(new DropShadow(30, javafx.scene.paint.Color.BLUE));
        if (lastLight!=null && !lastLight.equals(setImage)) {
            lastLight.setEffect(null);
        }
        lastLight = setImage;
    }
}
