package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.MessageMethod;
import it.polimi.ingsw.message.PlayExpertCard;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToIslandCard;
import it.polimi.ingsw.model.pawns.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class GuiChooseExpertCardController implements Initializable {

    /**
     *
     */
    @FXML
    AnchorPane scenePane;

    /**
     * Keep the reference to the last image light up
     */
    private ImageView  lastLight;

    /**
     * Used to have the id of the selected expert card
     */
    private String idExpert;

    /**
     * Reference to game
     */
    private Game game;

    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     *
     */
    private Scene scene;

    /**
     * Path to yellow student image file
     */
    private String yellowStudentPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";

    /**
     * Path to red student image file
     */
    private String redStudentPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";

    /**
     * Path to blue student image file
     */
    private String blueStudentPath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";

    /**
     * Path to green student image file
     */
    private String greenStudentPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";

    /**
     * Path to pink student image file
     */
    private String pinkStudentPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    /**
     *
     */
    private String cardOnePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front1.jpg";

    /**
     *
     */
    private String cardTwoPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front12.jpg";

    /**
     *
     */
    private String cardThreePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front2.jpg";

    /**
     *
     */
    private String cardFourPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front3.jpg";

    /**
     *
     */
    private String cardFivePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front4.jpg";

    /**
     *
     */
    private String cardSixPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front5.jpg";

    /**
     *
     */
    private String cardSevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front6.jpg";

    /**
     *
     */
    private String cardEightPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front7.jpg";

    /**
     *
     */
    private String cardNinePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front8.jpg";

    /**
     *
     */
    private String cardTenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front9.jpg";

    /**
     *
     */
    private String cardElevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front10.jpg";

    /**
     *
     */
    private String cardTwelvePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front11.jpg";

    @FXML
    private ImageView expertCard1;

    @FXML
    private ImageView expertCard2;

    @FXML
    private ImageView expertCard3;

    @FXML
    private Text coins;

    @FXML
    private Text communication;

    @FXML
    private Text costCard1;

    @FXML
    private Text costCard2;

    @FXML
    private Text costCard3;

    @FXML
    private ImageView card1student1;
    @FXML
    private ImageView card1student2;
    @FXML
    private ImageView card1student3;
    @FXML
    private ImageView card1student4;
    @FXML
    private ImageView card1student5;
    @FXML
    private ImageView card1student6;
    @FXML
    private ImageView card2student1;
    @FXML
    private ImageView card2student2;
    @FXML
    private ImageView card2student3;
    @FXML
    private ImageView card2student4;
    @FXML
    private ImageView card2student5;
    @FXML
    private ImageView card2student6;
    @FXML
    private ImageView card3student1;
    @FXML
    private ImageView card3student2;
    @FXML
    private ImageView card3student3;
    @FXML
    private ImageView card3student4;
    @FXML
    private ImageView card3student5;
    @FXML
    private ImageView card3student6;

    /**
     * go back to action phase
     * @param mouseEvent
     */
    public void onBackClick(MouseEvent mouseEvent) throws IOException {
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
     * choose the selected card
     * @param mouseEvent
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        if (idExpert!=null) {
            switch (idExpert) {
                case "38":
                    MessageMethod messageMethod38 = new PlayExpertCard();
                    GUIController.getInstance().setIdExpertCardPlayed("38");
                    ((PlayExpertCard) messageMethod38).setExpertCard("38");
                    GUIController.getInstance().write(messageMethod38);
                    break;
                case "39":
                    MessageMethod messageMethod39 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod39).setExpertCard("39");
                    GUIController.getInstance().write(messageMethod39);
                    break;
                case "40":
                    GUIController.getInstance().setIdExpertCardPlayed("40");
                    GUIController.getInstance().setCardNeedIsland(true);
                    sceneAction();
                    break;
                case "41":
                    MessageMethod messageMethod41 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod41).setExpertCard("41");
                    GUIController.getInstance().write(messageMethod41);
                    break;
                case "42":
                    GUIController.getInstance().setIdExpertCardPlayed("42");
                    GUIController.getInstance().setCardNeedIsland(true);
                    sceneAction();
                    break;
                case "43":
                    MessageMethod messageMethod43 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod43).setExpertCard("43");
                    GUIController.getInstance().write(messageMethod43);
                    break;
                case "44":
                    MessageMethod messageMethod44 = new PlayExpertCard();
                    GUIController.getInstance().setIdExpertCardPlayed("44");
                    ((PlayExpertCard) messageMethod44).setExpertCard("44");
                    GUIController.getInstance().write(messageMethod44);
                    break;
                case "45":
                    scenePlayer();
                    break;
                case "46":
                    GUIController.getInstance().setIdExpertCardPlayed("46");
                    sceneColor();
                    break;
                case "47":
                    MessageMethod messageMethod47 = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod47).setExpertCard("47");
                    GUIController.getInstance().write(messageMethod47);
                    break;
                case "48":
                    MessageMethod messageMethod48 = new PlayExpertCard();
                    GUIController.getInstance().setIdExpertCardPlayed("48");
                    ((PlayExpertCard) messageMethod48).setExpertCard("48");
                    GUIController.getInstance().write(messageMethod48);
                    break;
                case "49":
                    GUIController.getInstance().setIdExpertCardPlayed("49");
                    GUIController.getInstance().setIdExpertCardPlayed("49");
                    sceneColor();
                    break;
            }
        }
    }

    /**
     * Click on the first (of the three) expert card randomly choose for the game
     * @param mouseEvent
     */
    public void clickOnExpert1(MouseEvent mouseEvent) throws IOException {
       if (game.getCardManager().getDeck().get(0).getCost()>game.getCurrentPlayer().getCoins()) {
           communication.setText("You can not afford this card");
       } else {
           idExpert = game.getCardManager().getDeck().get(0).getId();
           setShadow(expertCard1);
       }
    }

    /**
     * Click on the second (of the three) expert card randomly choose for the game
     * @param mouseEvent
     */
    public void clickOnExpert2(MouseEvent mouseEvent) {
        if (game.getCardManager().getDeck().get(1).getCost()>game.getCurrentPlayer().getCoins()) {
            communication.setText("You can not afford this card");
        } else {
            idExpert = game.getCardManager().getDeck().get(1).getId();
            setShadow(expertCard2);
        }
    }

    /**
     * Click on the third (of the three) expert card randomly choose for the game
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnExpert3(MouseEvent mouseEvent) throws IOException {
        if (game.getCardManager().getDeck().get(2).getCost()>game.getCurrentPlayer().getCoins()) {
            communication.setText("You can not afford this card");
        } else {
            idExpert = game.getCardManager().getDeck().get(2).getId();
            setShadow(expertCard3);
        }
    }

    /**
     * Sets expert card images
     * @param id
     * @param expertCard
     */
    public void setImageExpertCard(String id, ImageView expertCard, int position){
        switch (id) {
            case"38":
                expertCard.setImage(new Image(cardOnePath));
                showStudents(position,((StudentToIslandCard) game.getCardManager().getDeck().get(position-1)).getStudents());
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
                showStudents(position,((IngressCardSwapCard) game.getCardManager().getDeck().get(position-1)).getStudents());
                break;
            case"45":
                expertCard.setImage(new Image(cardEightPath));
                break;
            case"46":
                expertCard.setImage(new Image(cardNinePath));
                break;
            case"47":
                expertCard.setImage(new Image(cardTenPath));
                break;
            case"48":
                expertCard.setImage(new Image(cardElevenPath));
                showStudents(position,((StudentToHallCard) game.getCardManager().getDeck().get(position-1)).getStudents());
                break;
            case"49":
                expertCard.setImage(new Image(cardTwelvePath));
                break;
        }
    }

    private void showStudents(int position, LinkedList<Student> students){
        LinkedList<ImageView> images = new LinkedList<>();
        switch (position){
            case 1:
                images.add(card1student1);
                images.add(card1student2);
                images.add(card1student3);
                images.add(card1student4);
                images.add(card1student5);
                images.add(card1student6);
                break;
            case 2:
                images.add(card2student1);
                images.add(card2student2);
                images.add(card2student3);
                images.add(card2student4);
                images.add(card2student5);
                images.add(card2student6);
                break;
            case 3:
                images.add(card3student1);
                images.add(card3student2);
                images.add(card3student3);
                images.add(card3student4);
                images.add(card3student5);
                images.add(card3student6);
                break;
        }
        for(int i = 0; i<students.size(); i++){
            images.get(i).setImage(getImageStudent(students.get(i)));
        }
    }


    /**
     * @param student whose image is returned
     * @return a new Image object of student
     */
    private Image getImageStudent(Student student) {
        switch (student.getColor()) {
            case RED -> {
                return new Image(redStudentPath);
            }
            case GREEN -> {
                return new Image(greenStudentPath);
            }
            case BLUE -> {
                return new Image(blueStudentPath);
            }
            case PINK -> {
                return new Image(pinkStudentPath);
            }
            case YELLOW -> {
                return new Image(yellowStudentPath);
            }
        }
        return null;
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = GUIController.getInstance().getClient().getGame();
        setImageExpertCard(game.getCardManager().getDeck().get(0).getId(),expertCard1, 1);
        setImageExpertCard(game.getCardManager().getDeck().get(1).getId(),expertCard2,2);
        setImageExpertCard(game.getCardManager().getDeck().get(2).getId(),expertCard3,3);
        coins.setText("You have " + game.getCurrentPlayer().getCoins() + " coins");
        costCard1.setText("Cost: " + game.getCardManager().getDeck().get(0).getCost());
        costCard2.setText("Cost: " + game.getCardManager().getDeck().get(1).getCost());
        costCard3.setText("Cost: " + game.getCardManager().getDeck().get(2).getCost());
    }

    /**
     * go to studentOnCard scene
     * @throws IOException
     */
    public void sceneStudentOnCard() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/studentsOnCard-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiChooseStudentsOnCardController studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * go to selectColor scene
     * @throws IOException
     */
    public void sceneColor() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/selectColorCard-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiChooseColorCardController studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * go to actionPhase scene
     * @throws IOException
     */
    public void sceneAction() throws IOException {
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
        GuiActionPhaseController studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setX(x);
        stage.setY(y);
    }

    /**
     * go to selectPlayerCard scene
     * @throws IOException
     */
    public void scenePlayer() throws IOException {
        stage = GUIController.getInstance().getStage();
        double x = stage.getX();
        double y = stage.getY();
        double width = stage.getWidth();
        double height = stage.getHeight();
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/selectPlayerCard-view.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();
        GuiSelectPlayerCardController studentsController = fxmlLoader.getController();
        studentsController.resize(stage);
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
