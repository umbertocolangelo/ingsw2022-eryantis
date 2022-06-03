package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import it.polimi.ingsw.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseExpertCardController implements Initializable {

    /**
     *
     */
    private Game game;

    /**
     *
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;
    //show all expert cards, 1 opacity the available ones and like in the background the others

    private String cardOnePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front1.jpg";
    private String cardTwoPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front12.jpg";
    private String cardThreePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front2.jpg";
    private String cardFourPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front3.jpg";
    private String cardFivePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front4.jpg";
    private String cardSixPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front5.jpg";
    private String cardSevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front6.jpg";
    private String cardEightPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front7.jpg";
    private String cardNinePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front8.jpg";
    private String cardTenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front9.jpg";
    private String cardElevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front10.jpg";
    private String cardTwelvePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front11.jpg";

    @FXML
    private ImageView expertCard1;

    @FXML
    private ImageView expertCard2;

    @FXML
    private ImageView expertCard3;
    /**
     * go back to action phase
     * @param mouseEvent
     */
    public void onBackClick(MouseEvent mouseEvent) throws IOException {
        stage = ControllerHandler.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/actionPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * choose the selected card
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) {

    }

    public void clickOnExpert1(MouseEvent mouseEvent) {
        switch (game.getCardManager().getDeck().get(0).getId()) {
            case "38":
                MessageMethod messageMethod38=new PlayExpertCard();
                ((PlayExpertCard)messageMethod38).setExpertCard("38");
                ControllerHandler.getInstance().write(messageMethod38);
                break;
            case "39":
              MessageMethod messageMethod39=new PlayExpertCard();
                ((PlayExpertCard)messageMethod39).setExpertCard("39");
                ControllerHandler.getInstance().write(messageMethod39);
                break;
            case "40":

                break;
            case "41":
                MessageMethod messageMethod41=new PlayExpertCard();
                ((PlayExpertCard)messageMethod41).setExpertCard("41");
                ControllerHandler.getInstance().write(messageMethod41);
                break;
            case "42":

                break;
            case "43":
                MessageMethod messageMethod43=new PlayExpertCard();
                ((PlayExpertCard)messageMethod43).setExpertCard("43");
                ControllerHandler.getInstance().write(messageMethod43);
                break;
            case "44":
                MessageMethod messageMethod44=new PlayExpertCard();
                ((PlayExpertCard)messageMethod44).setExpertCard("44");
                ControllerHandler.getInstance().write(messageMethod44);
                break;
            case "45":
                MessageMethod messageMethod45=new PlayExpertCard();
                ((PlayExpertCard)messageMethod45).setExpertCard("45");
                ControllerHandler.getInstance().write(messageMethod45);
                break;
            case "46":
                MessageMethod messageMethod46=new PlayExpertCard();
                ((PlayExpertCard)messageMethod46).setExpertCard("46");
                ControllerHandler.getInstance().write(messageMethod46);
                break;
            case "47":
                MessageMethod messageMethod47=new PlayExpertCard();
                ((PlayExpertCard)messageMethod47).setExpertCard("47");
                ControllerHandler.getInstance().write(messageMethod47);
                break;
            case "48":

                break;
        }
    }

    public void clickOnExpert2(MouseEvent mouseEvent) {
        switch (game.getCardManager().getDeck().get(1).getId()) {
            case "38":
                MessageMethod messageMethod38=new PlayExpertCard();
                ((PlayExpertCard)messageMethod38).setExpertCard("38");
                ControllerHandler.getInstance().write(messageMethod38);
                break;
            case "39":
                MessageMethod messageMethod39=new PlayExpertCard();
                ((PlayExpertCard)messageMethod39).setExpertCard("39");
                ControllerHandler.getInstance().write(messageMethod39);
                break;
            case "40":

                break;
            case "41":
                MessageMethod messageMethod41=new PlayExpertCard();
                ((PlayExpertCard)messageMethod41).setExpertCard("41");
                ControllerHandler.getInstance().write(messageMethod41);
                break;
            case "42":

                break;
            case "43":
                MessageMethod messageMethod43=new PlayExpertCard();
                ((PlayExpertCard)messageMethod43).setExpertCard("43");
                ControllerHandler.getInstance().write(messageMethod43);
                break;
            case "44":
                MessageMethod messageMethod44=new PlayExpertCard();
                ((PlayExpertCard)messageMethod44).setExpertCard("44");
                ControllerHandler.getInstance().write(messageMethod44);
                break;
            case "45":
                MessageMethod messageMethod45=new PlayExpertCard();
                ((PlayExpertCard)messageMethod45).setExpertCard("45");
                ControllerHandler.getInstance().write(messageMethod45);
                break;
            case "46":

            case "47":
                MessageMethod messageMethod47=new PlayExpertCard();
                ((PlayExpertCard)messageMethod47).setExpertCard("47");
                ControllerHandler.getInstance().write(messageMethod47);
                break;
            case "48":
                MessageMethod messageMethod48=new PlayExpertCard();
                ((PlayExpertCard)messageMethod48).setExpertCard("48");
                ControllerHandler.getInstance().write(messageMethod48);

                break;
            case "49":
                break;
        }
    }

    public void clickOnExpert3(MouseEvent mouseEvent) {
        switch (game.getCardManager().getDeck().get(2).getId()) {
            case "38":
                MessageMethod messageMethod38=new PlayExpertCard();
                ((PlayExpertCard)messageMethod38).setExpertCard("38");
                ControllerHandler.getInstance().write(messageMethod38);
                break;
            case "39":
                MessageMethod messageMethod39=new PlayExpertCard();
                ((PlayExpertCard)messageMethod39).setExpertCard("39");
                ControllerHandler.getInstance().write(messageMethod39);
                break;
            case "40":

                break;
            case "41":
                MessageMethod messageMethod41=new PlayExpertCard();
                ((PlayExpertCard)messageMethod41).setExpertCard("41");
                ControllerHandler.getInstance().write(messageMethod41);
                break;
            case "42":

                break;
            case "43":
                MessageMethod messageMethod43=new PlayExpertCard();
                ((PlayExpertCard)messageMethod43).setExpertCard("43");
                ControllerHandler.getInstance().write(messageMethod43);
                break;
            case "44":
                MessageMethod messageMethod44=new PlayExpertCard();
                ((PlayExpertCard)messageMethod44).setExpertCard("44");
                ControllerHandler.getInstance().write(messageMethod44);
                break;
            case "45":
                MessageMethod messageMethod45=new PlayExpertCard();
                ((PlayExpertCard)messageMethod45).setExpertCard("45");
                ControllerHandler.getInstance().write(messageMethod45);
                break;
            case "46":
                MessageMethod messageMethod46=new PlayExpertCard();
                ((PlayExpertCard)messageMethod46).setExpertCard("46");
                ControllerHandler.getInstance().write(messageMethod46);
                break;
            case "47":
                MessageMethod messageMethod47=new PlayExpertCard();
                ((PlayExpertCard)messageMethod47).setExpertCard("47");
                ControllerHandler.getInstance().write(messageMethod47);
                break;
            case "48":
                break;
        }
    }

    public void setImageExpertCard(String id, ImageView expertCard){
        switch (id){
            case"38":
                expertCard.setImage(new Image(cardOnePath));
                break;
            case"39":
                expertCard.setImage(new Image(cardTwoPath));
                break;
            case"40":
                expertCard.setImage(new Image(cardThreePath));
                break;
            case"41":
                expertCard.setImage(new Image(cardFourPath));
                break;
            case"42":
                expertCard.setImage(new Image(cardFivePath));
                break;
            case"43":
                expertCard.setImage(new Image(cardSixPath));
                break;
            case"44":
                expertCard.setImage(new Image(cardSevenPath));
                break;
            case"45":
                expertCard.setImage(new Image(cardEightPath));
            case"46":
                expertCard.setImage(new Image(cardNinePath));
                break;
            case"47":
                expertCard.setImage(new Image(cardTenPath));
                break;
            case"48":
                expertCard.setImage(new Image(cardElevenPath));
                break;
            case"49":
                expertCard.setImage(new Image(cardTwelvePath));
                break;
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
         game=ControllerHandler.getInstance().getClient().getGame();
        setImageExpertCard(game.getCardManager().getDeck().get(0).getId(),expertCard1);
        setImageExpertCard(game.getCardManager().getDeck().get(1).getId(),expertCard2);
        setImageExpertCard(game.getCardManager().getDeck().get(2).getId(),expertCard3);
    }
}
