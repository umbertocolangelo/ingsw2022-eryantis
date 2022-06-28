package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.ChoosingAssistant;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GuiPianificationPhaseController implements Initializable {

    @FXML
    private AnchorPane scenePane;
    @FXML
    private Text label;

    /**
     * References to the assistant cards
     */
    @FXML
    private ImageView card1;
    @FXML
    private ImageView card2;
    @FXML
    private ImageView card3;
    @FXML
    private ImageView card4;
    @FXML
    private ImageView card5;
    @FXML
    private ImageView card6;
    @FXML
    private ImageView card7;
    @FXML
    private ImageView card8;
    @FXML
    private ImageView card9;
    @FXML
    private ImageView card10;

    /**
     * Keep the reference to the last image that has the light up
     */
    private ImageView lastLight = null;

    /**
     * Reference to the assistant card selected
     */
    private String assistantCard;

    /**
     * References to the stage
     */
    private Stage stage;

    /**
     * References to the scene
     */
    private Scene scene;

    /**
     * Select card 1
     * @param mouseEvent
     */
    public void onCard1Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.ONE_CARD.getId();
        setShadow(card1);
    }

    /**
     * Select card 2
     * @param mouseEvent
     */
    public void onCard2Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.TWO_CARD.getId();
        setShadow(card2);
    }

    /**
     * Select card 3
     * @param mouseEvent
     */
    public void onCard3Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.THREE_CARD.getId();
        setShadow(card3);
    }

    /**
     * Select card 4
     * @param mouseEvent
     */
    public void onCard4Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.FOUR_CARD.getId();
        setShadow(card4);
    }

    /**
     * Select card 5
     * @param mouseEvent
     */
    public void onCard5Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.FIVE_CARD.getId();
        setShadow(card5);
    }

    /**
     * Select card 6
     * @param mouseEvent
     */
    public void onCard6Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.SIX_CARD.getId();
        setShadow(card6);
    }

    /**
     * Select card 7
     * @param mouseEvent
     */
    public void onCard7Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.SEVEN_CARD.getId();
        setShadow(card7);
    }

    /**
     * Select card 8
     * @param mouseEvent
     */
    public void onCard8Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.EIGHT_CARD.getId();
        setShadow(card8);
    }

    /**
     * Select card 9
     * @param mouseEvent
     */
    public void onCard9Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.NINE_CARD.getId();
        setShadow(card9);
    }

    /**
     * Select card 10
     * @param mouseEvent
     */
    public void onCard10Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.TEN_CARD.getId();
        setShadow(card10);
    }

    /**
     * Click on next button
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        if (assistantCard==null) {
            label.setText("You must select an assistant card");
        } else {
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
            GuiLoadingController loadingController = fxmlLoader.getController();
            loadingController.resize(stage);
            stage.setWidth(width);
            stage.setHeight(height);
            stage.setX(x);
            stage.setY(y);
            MessageMethod messageMethod = new ChoosingAssistant();
            ((ChoosingAssistant) messageMethod).setAssistantCard(assistantCard);
            GUIController.getInstance().write(messageMethod);
        }
    }

    /**
     * go to actionPhase scene
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/actionPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiActionPhaseController actionController = fxmlLoader.getController();
        actionController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * Sets images in pianification phase
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (GUIController.getInstance().getCardPlayed()==true) {
            label.setText("You played a card that has been already played, please pick another one");
        }

        GUIController.getInstance().setCardPlayed(true);
        Game game = GUIController.getInstance().getClient().getGame();

        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.ONE_CARD)) {
            card1.setMouseTransparent(true);
            card1.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.TWO_CARD)) {
            card2.setMouseTransparent(true);
            card2.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.THREE_CARD)) {
            card3.setMouseTransparent(true);
            card3.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.FOUR_CARD)) {
            card4.setMouseTransparent(true);
            card4.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.FIVE_CARD)) {
            card5.setMouseTransparent(true);
            card5.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.SIX_CARD)) {
            card6.setMouseTransparent(true);
            card6.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.SEVEN_CARD)) {
            card7.setMouseTransparent(true);
            card7.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.EIGHT_CARD)) {
            card8.setMouseTransparent(true);
            card8.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.NINE_CARD)) {
            card9.setMouseTransparent(true);
            card9.setOpacity(0.23);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.TEN_CARD)) {
            card10.setMouseTransparent(true);
            card10.setOpacity(0.23);
        }
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

    /**
     * Sets shadows on images
     * @param setImage
     */
    private void setShadow(ImageView setImage) {
        setImage.setEffect(new DropShadow(30, Color.DARKBLUE));
        if (lastLight!=null && lastLight!=setImage) {
            lastLight.setEffect(null);
        }
        lastLight = setImage;
    }
}
