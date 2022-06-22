package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToIslandCard;
import it.polimi.ingsw.model.pawns.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseStudentsOnCardController implements Initializable {

    /**
     * References to paths of student images
     */
    private String yellowPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";
    private String redPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";
    private String bluePath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";
    private String greenPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";
    private String pinkPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    /**
     * References to paths of StudentOnCard expert cards
     */
    private String cardOnePath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front1.jpg"; //StudentOnIsland
    private String cardElevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front10.jpg"; //Student to hall
    private String cardSevenPath = "file:src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front6.jpg"; //Ingress cardSwap

    /**
     * Keep the reference to game
     */
    private Game game;

    /**
     * Reference to the stage
     */
    private Stage stage;

    /**
     * Reference to the scene
     */
    private Scene scene;

    /**
     * Reference to the expert card
     */
    private ExpertCard expertCard;

    /**
     * Reference to StudentToHall message
     */
    private MessageMethod messageMethodHall = new StudentToHall();

    /**
     * Reference to StudentToIsland message
     */
    private StudentToIsland messageMethodIsland = new StudentToIsland();

    /**
     * Reference to StudentSwap message
     */
    private IngressCardSwap messageMethodSwap=new IngressCardSwap();

    /**
     * Reference of the id of the selected expert card
     */
    private  String idExpertCard;


    @FXML
    private AnchorPane scenePane;
    @FXML
    private ImageView expertCardId;
    @FXML
    private ImageView studentCard1;
    @FXML
    private ImageView studentCard2;
    @FXML
    private ImageView studentCard3;
    @FXML
    private ImageView studentCard4;
    @FXML
    private ImageView studentCard5;
    @FXML
    private ImageView studentCard6;

    /**
     * @param student
     * @return
     */
    public Image getColorStudent(Student student) {
        switch (student.getColor()) {
            case RED -> {
                return new Image(redPath);
            }
            case GREEN -> {
                return new Image(greenPath);
            }
            case BLUE -> {
                return new Image(bluePath);
            }
            case PINK -> {
                return new Image(pinkPath);
            }
            case YELLOW -> {
                return  new Image(yellowPath);
            }
        }
        return null;
    }

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        game = GUIController.getInstance().getClient().getGame();
        idExpertCard = GUIController.getInstance().getIdExpertCardPlayed();
        if (game.getCardManager().getCurrentCard().getId().equals(game.getCardManager().getDeck().get(0).getId())) {
            expertCard = game.getCardManager().getDeck().get(0);
        } else if (game.getCardManager().getCurrentCard().getId().equals(game.getCardManager().getDeck().get(1).getId())) {
            expertCard = game.getCardManager().getDeck().get(1);
        } else {
            expertCard=game.getCardManager().getDeck().get(2);
        }
        switch (game.getCardManager().getCurrentCard().getId()) {
            case "48":
                expertCardId.setImage(new Image(cardElevenPath));
                studentCard1.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(0)));
                studentCard2.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(1)));
                studentCard3.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(2)));
                studentCard4.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(3)));
                break;
            case"38":
                expertCardId.setImage(new Image(cardOnePath));
                studentCard1.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(0)));
                studentCard2.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(1)));
                studentCard3.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(2)));
                studentCard4.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(3)));
                break;
            case "44":
                //It is necessary because this card lasts more than one turn
                expertCardId.setImage(new Image(cardSevenPath));
                studentCard1.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(0)));
                studentCard2.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(1)));
                studentCard3.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(2)));
                studentCard4.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(3)));
                studentCard5.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(2)));
                studentCard6.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(3)));
                break;
        }
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void onNextClick(MouseEvent mouseEvent) throws IOException {
        switch (game.getCardManager().getCurrentCard().getId()) {
            case "38":
                                GUIController.getInstance().setIdExpertCardPlayed("");
                GUIController.getInstance().setStudentToIsland(messageMethodIsland);
                changeToAction();
                break;
            case "44":
                GUIController.getInstance().setIdExpertCardPlayed("");
                GUIController.getInstance().setMessageMethodIngressCard(messageMethodSwap);
                changeToAction();
                break;
            case "48":
                GUIController.getInstance().setIdExpertCardPlayed("");
                GUIController.getInstance().write(messageMethodHall);
                break;
        }

    }

    /**
     * go to actionPhase scene
     */
    public void changeToAction() throws IOException {
        stage = new Stage();
        GUIController.getInstance().getStage().close();
        GUIController.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/actionPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiActionPhaseController actionController = fxmlLoader.getController();
        actionController.resize(stage);
    }

    /**
     * Click on student card 1
     * @param mouseEvent
     */
    public void onClickStudentCard1(MouseEvent mouseEvent) {
        switch (game.getCardManager().getCurrentCard().getId()) {
            case "48":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(0).getId());
                break;
            case "38":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(0).getId());
                break;
            case "44":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(0).getId());
                break;
        }
    }

    /**
     * Click on student card 2
     * @param mouseEvent
     */
    public void onClickStudentCard2(MouseEvent mouseEvent) {
        switch (game.getCardManager().getCurrentCard().getId()) {
            case "48":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(1).getId());
                break;
            case "38":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(1).getId());
                break;
            case "44":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(1).getId());
                break;
        }
    }

    /**
     * Click on student card 3
     * @param mouseEvent
     */
    public void onClickStudentCard3(MouseEvent mouseEvent) {
        switch (game.getCardManager().getCurrentCard().getId()) {
            case "48":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(2).getId());
                break;
            case "38":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(2).getId());
                break;
            case "44":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(2).getId());
                break;
        }
    }

    /**
     * Click on student card 4
     * @param mouseEvent
     */
    public void onClickStudentCard4(MouseEvent mouseEvent) {
        switch (idExpertCard) {
            case "48":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(3).getId());
                break;
            case "38":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(3).getId());
                break;
            case "44":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(3).getId());
                break;
        }
    }

    /**
     * Click on student card 5
     * @param mouseEvent
     */
    public void onClickStudentCard5(MouseEvent mouseEvent) {
        if (idExpertCard=="44") {
            ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(4).getId());
        }
    }

    /**
     * Click on student card 6
     * @param mouseEvent
     */
    public void onClickStudentCard6(MouseEvent mouseEvent) {
        if(idExpertCard=="44") {
            ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(5).getId());
        }
    }

    /**
     * Click on student card 7
     * @param mouseEvent
     */
    public void clickFinishExpertMove(MouseEvent mouseEvent) {
        GUIController.getInstance().write(new RoundEnd());
    }

    /**
     * Refresh the scene
     * @throws IOException
     */
    public void refresh() throws IOException {
        stage = GUIController.getInstance().getStage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/studentsOnCard-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
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
