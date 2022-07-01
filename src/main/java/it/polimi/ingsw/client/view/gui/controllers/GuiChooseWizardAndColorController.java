package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.ChooseColorAndDeck;
import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.rounds.SetUpRound;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class GuiChooseWizardAndColorController implements Initializable {

    /**
     * Reference to the scene
     */
    @FXML
    private AnchorPane scenePane;

    /**
     * Reference to wizard and color choice
     */
    @FXML
    private ImageView wizard1;
    @FXML
    private ImageView wizard2;
    @FXML
    private ImageView wizard3;
    @FXML
    private ImageView wizard4;
    @FXML
    private RadioButton white;
    @FXML
    private RadioButton grey;
    @FXML
    private RadioButton black;
    @FXML
    private Text wizardColor;

    /**
     * Image shadows
     */
    private ImageView lastLight = null;

    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     * Reference to the scene
     */
    private Scene scene;

    /**
     * Reference to the wizard
     */
    private String wizard;

    /**
     * Reference to the color
     */
    private String color;

    /**
     * Click on wizard1
     * @param mouseEvent
     */
    public void onWizardClick1(MouseEvent mouseEvent) {
        if (wizard1.getImage()!=null) {
            wizard = Wizard.GREEN_WIZARD.getId();
            setShadow(wizard1);
        }
    }

    /**
     * Click on wizard2
     * @param mouseEvent
     */
    public void onWizardClick2(MouseEvent mouseEvent) {
        if (wizard2.getImage()!=null) {
            wizard = Wizard.YELLOW_WIZARD.getId();
            setShadow(wizard2);
        }
    }

    /**
     * Click on wizard3
     * @param mouseEvent
     */
    public void onWizardClick3(MouseEvent mouseEvent) {
        if (wizard3.getImage()!=null) {
            wizard = Wizard.PURPLE_WIZARD.getId();
            setShadow(wizard3);
        }
    }

    /**
     * Click on wizard4
     * @param mouseEvent
     */
    public void onWizardClick4(MouseEvent mouseEvent) {
        if (wizard4.getImage()!=null) {
            wizard = Wizard.BLUE_WIZARD.getId();
            setShadow(wizard4);
        }
    }

    /**
     * Click on next button
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        checkWizardAndColor();
    }

    /**
     * Enter key is pressed
     * @param keyEvent
     * @throws IOException
     */
    public void onKeyPressed(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            checkWizardAndColor();
        }
    }

    /**
     * Checks if wizard and color are valid and changes scene
     * @throws IOException
     */
    private void checkWizardAndColor() throws IOException {
        if (wizard==null || color==null) {
            wizardColor.setText("You must select the wizard and the player color");
        } else {
            MessageMethod messageMethod = new ChooseColorAndDeck();
            ((ChooseColorAndDeck) messageMethod).setWizard(wizard);
            ((ChooseColorAndDeck) messageMethod).setPlayerColor(color);
            GUIController.getInstance().write(messageMethod);

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
        }
    }

    /**
     * Click on color white
     * @param mouseEvent
     */
    public void onColorClick1(MouseEvent mouseEvent) {
        color = PlayerColor.WHITE.getId();
    }

    /**
     * Click on color black
     * @param mouseEvent
     */
    public void onColorClick2(MouseEvent mouseEvent) {
        color = PlayerColor.BLACK.getId();
    }

    /**
     * Click on color grey
     * @param mouseEvent
     */
    public void onColorClick3(MouseEvent mouseEvent) {
        color = PlayerColor.GREY.getId();
    }

    /**
     * go to pianificationPhase scene
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/pianificationPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiPianificationPhaseController pianController = fxmlLoader.getController();
        pianController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * Initialize the scene
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Game game = GUIController.getInstance().getClient().getGame();
        ((SetUpRound)game.getCurrentRound()).getPlayerColor();
        if (!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.GREEN_WIZARD)) {
            wizard1.setMouseTransparent(true);
            wizard1.setOpacity(0.23);
        }
        if (!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.YELLOW_WIZARD)) {
            wizard2.setMouseTransparent(true);
            wizard2.setOpacity(0.23);
        }
        if (!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.PURPLE_WIZARD)) {
            wizard2.setMouseTransparent(true);
            wizard2.setOpacity(0.23);
        }
        if (!((SetUpRound)game.getCurrentRound()).getWizards().contains(Wizard.BLUE_WIZARD)){
            wizard3.setMouseTransparent(true);
            wizard3.setOpacity(0.23);
        }
        if (!((SetUpRound)game.getCurrentRound()).getPlayerColor().contains(PlayerColor.WHITE)){
            white.setDisable(false);
            white.setVisible(false);
        }
        if (!((SetUpRound)game.getCurrentRound()).getPlayerColor().contains(PlayerColor.BLACK)) {
            black.setVisible(false);
            black.setDisable(false);
        }
        if (!((SetUpRound)game.getCurrentRound()).getPlayerColor().contains(PlayerColor.GREY)) {
            grey.setVisible(false);
            grey.setDisable(false);
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
    private void setShadow(ImageView setImage){
        setImage.setEffect(new DropShadow(30, Color.DARKBLUE));
        if (lastLight!=null && lastLight!=setImage) {
            lastLight.setEffect(null);
        }
        lastLight = setImage;
    }

}
