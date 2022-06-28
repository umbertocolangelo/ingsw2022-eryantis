package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseColorCard implements Initializable {

    /**
     *
     */
    @FXML
    private AnchorPane scenePane;

    /**
     *
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
    private String yellowPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";
    private String redPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";
    private String bluePath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";
    private String greenPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";
    private String pinkPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colorBlue.setImage(new Image(bluePath));
        colorGreen.setImage(new Image(greenPath));
        colorPink.setImage(new Image(pinkPath));
        colorYellow.setImage(new Image(yellowPath));
        colorRed.setImage(new Image(redPath));
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickSelectColor(MouseEvent mouseEvent) {
        if (color != null) {
            MessageMethod messageMethod = new PlayExpertCard();
            switch (GUIController.getInstance().getIdExpertCardPlayed()) {
                case "46":
                    GUIController.getInstance().setIdExpertCardPlayed("");
                    ((PlayExpertCard) messageMethod).setExpertCard("46");
                    ((PlayExpertCard) messageMethod).setParameter(color);
                    GUIController.getInstance().write(messageMethod);
                    break;
                case "49":
                    GUIController.getInstance().setIdExpertCardPlayed("");
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
        color = "8";
    }

    /**
     * Click on red
     * @param mouseEvent
     */
    public void clickOnRed(MouseEvent mouseEvent) {
        color = "10";
    }

    /**
     * Click on yellow
     * @param mouseEvent
     */
    public void clickOnYellow(MouseEvent mouseEvent) {
        color = "7";
    }

    /**
     * Click on green
     * @param mouseEvent
     */
    public void clickOnGreen(MouseEvent mouseEvent) {
        color = "9";
    }

    /**
     * Click on pink
     * @param mouseEvent
     */
    public void clickOnPink(MouseEvent mouseEvent) {
        color = "11";
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
