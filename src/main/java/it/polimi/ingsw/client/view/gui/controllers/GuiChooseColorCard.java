package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseColorCard implements Initializable {

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


    private String yellowPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";
    private String redPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";
    private String bluePath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";
    private String greenPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";
    private String pinkPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colorBlue.setImage(new Image(bluePath));
        colorGreen.setImage(new Image(greenPath));
        colorPink.setImage(new Image(pinkPath));
        colorYellow.setImage(new Image(yellowPath));
        colorRed.setImage(new Image(redPath));
    }

    public void clickSelectColor(MouseEvent mouseEvent) {
        if(color!=null){
            MessageMethod messageMethod= new PlayExpertCard();
            switch (ControllerHandler.getInstance().getIdExpertCardPlayed()){
                case"44":
                    ControllerHandler.getInstance().setIdExpertCardPlayed("");
                    ((PlayExpertCard)messageMethod).setExpertCard("44");
                    ((PlayExpertCard)messageMethod).setParameter(color);
                    ControllerHandler.getInstance().write(messageMethod);
                case"49":
                    ControllerHandler.getInstance().setIdExpertCardPlayed("");
                    ((PlayExpertCard)messageMethod).setExpertCard("49");
                    ((PlayExpertCard)messageMethod).setParameter(color);
                    ControllerHandler.getInstance().write(messageMethod);
            }

        }
    }

    public void clickOnBlue(MouseEvent mouseEvent) {
        color = "8";
    }

    public void clickOnRed(MouseEvent mouseEvent) {
        color="10";
    }

    public void clickOnYellow(MouseEvent mouseEvent) {
        color="7";
    }

    public void clickOnGreen(MouseEvent mouseEvent) {
        color="9";
    }

    public void clickOnPink(MouseEvent mouseEvent) {
        color="11";
    }
}
