package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.ChoosingAssistant;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.AssistantCard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class GuiPianificationPhaseController implements Initializable {

    /**
     *
     */
    @FXML
    private AnchorPane scenePane;

    /**
     *
     */
    @FXML
    private ImageView card1;

    /**
     *
     */
    @FXML
    private ImageView card2;

    /**
     *
     */
    @FXML
    private ImageView card3;

    /**
     *
     */
    @FXML
    private ImageView card4;

    /**
     *
     */
    @FXML
    private ImageView card5;

    /**
     *
     */
    @FXML
    private ImageView card6;

    /**
     *
     */
    @FXML
    private ImageView card7;

    /**
     *
     */
    @FXML
    private ImageView card8;

    /**
     *
     */
    @FXML
    private ImageView card9;

    /**
     *
     */
    @FXML
    private ImageView card10;

    /**
     *
     */
    @FXML
    private Text label;

    /**
     *
     */
    private String assistantCard;

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
     */
    private AnchorPane anchorPane;


    /**
     * click to show rules
     * @param mouseEvent
     */
    public void onRulesClick(MouseEvent mouseEvent) {

    }

    /**
     * select card 1
     * @param mouseEvent
     */
    public void onCard1Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.ONE_CARD.getId();
    }

    /**
     * select card 2
     * @param mouseEvent
     */
    public void onCard2Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.TWO_CARD.getId();
    }

    /**
     * select card 3
            * @param mouseEvent
     */
    public void onCard3Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.THREE_CARD.getId();
    }

    /**
     * select card 4
     * @param mouseEvent
     */
    public void onCard4Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.FOUR_CARD.getId();
    }

    /**
     * select card 5
     * @param mouseEvent
     */
    public void onCard5Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.FIVE_CARD.getId();
    }

    /**
     * select card 6
     * @param mouseEvent
     */
    public void onCard6Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.SIX_CARD.getId();
    }

    /**
     * select card 7
     * @param mouseEvent
     */
    public void onCard7Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.SEVEN_CARD.getId();
    }

    /**
     * select card 8
     * @param mouseEvent
     */
    public void onCard8Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.EIGHT_CARD.getId();
    }

    /**
     * select card 9
     * @param mouseEvent
     */
    public void onCard9Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.NINE_CARD.getId();
    }

    /**
     * select card 10
     * @param mouseEvent
     */
    public void onCard10Click(MouseEvent mouseEvent) {
        assistantCard = AssistantCard.TEN_CARD.getId();
    }

    /**
     * click on next button
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        if(assistantCard==null) {
            label.setText("You must select an assistant card");
        }
        else {
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

            MessageMethod messageMethod = new ChoosingAssistant();
            ((ChoosingAssistant) messageMethod).setAssistantCard(assistantCard);
            ControllerHandler.getInstance().write(messageMethod);
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/actionPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiActionPhaseController actionController = fxmlLoader.getController();
        actionController.resize(stage, scene);
    }

    /**
     * TODO
     * @param mouseEvent
     */
    public void lightUp(MouseEvent mouseEvent) {

    }


    /**
     *
     * @param mouseEvent
     */
    public void turnOff(MouseEvent mouseEvent) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ControllerHandler.getInstance().getCardPlayed()==true) {
            label.setText("You played a card that has been already played, pick another one");
        }
        ControllerHandler.getInstance().setCardPlayed(true);
        Game game = ControllerHandler.getInstance().getClient().getGame();
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.ONE_CARD)) {
            card1.setVisible(false);
            card1.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.TWO_CARD)) {
            card2.setVisible(false);
            card2.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.THREE_CARD)) {
            card3.setVisible(false);
            card3.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.FOUR_CARD)) {
            card4.setVisible(false);
            card4.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.FIVE_CARD)) {
            card5.setVisible(false);
            card5.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.SIX_CARD)) {
            card6.setVisible(false);
            card6.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.SEVEN_CARD)) {
            card7.setVisible(false);
            card7.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.EIGHT_CARD)) {
            card8.setVisible(false);
            card8.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.NINE_CARD)) {
            card9.setVisible(false);
            card9.setDisable(false);
        }
        if (!game.getCurrentPlayer().getAssistantCard().contains(AssistantCard.TEN_CARD)) {
            card10.setVisible(false);
            card10.setDisable(false);
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

        //scenePane.translateXProperty().bind(scene.widthProperty().subtract(scenePane.widthProperty().divide(2)));
        //scenePane.translateYProperty().bind(scene.heightProperty().subtract(scenePane.heightProperty().divide(2)));

        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            double scaleX = newVal.doubleValue()/width;
            scenePane.setScaleX(scaleX);
            scenePane.setTranslateX(scenePane.getTranslateX() + (newVal.doubleValue()-oldVal.doubleValue())/2);
            //scenePane.setCenterShape(true);
        });

        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            double scaleY = newVal.doubleValue()/height;
            scenePane.setScaleY(scaleY);
            scenePane.setTranslateY(scenePane.getTranslateY() + (newVal.doubleValue()-oldVal.doubleValue())/2);
            //scenePane.setCenterShape(true);
        });
    }

    /**
     *
     */
    public void closeStage() {
        this.stage.close();
    }

    /**
     *
     * @return
     */
    public Stage getStage() {
        return stage;
    }

}
