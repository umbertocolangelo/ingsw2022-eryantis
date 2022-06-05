package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToIslandCard;
import it.polimi.ingsw.model.pawns.Student;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiChooseStudentsOnCardController implements Initializable {

    private String yellowPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";
    private String redPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";
    private String bluePath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";
    private String greenPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";
    private String pinkPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    /**
     *
     */
    private ExpertCard expertCard;

    /**
     *
     */
    private MessageMethod messageMethodHall=new StudentToHall();

    /**
     *
     */
    private  MessageMethod messageMethodIsland=new StudentToIsland();
    /**
     *
     */
    private MessageMethod messageMethodSwap=new IngressCardSwap();

    /**
     *
     */
    private  String idExpertCard;


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
     *
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
        Game game=ControllerHandler.getInstance().getClient().getGame();
         idExpertCard =ControllerHandler.getInstance().getIdExpertCardPlayed();


        if(idExpertCard==game.getCardManager().getDeck().get(0).getId())
            expertCard=game.getCardManager().getDeck().get(0);
        else if(idExpertCard==game.getCardManager().getDeck().get(1).getId())
            expertCard=game.getCardManager().getDeck().get(1);
        else
            expertCard=game.getCardManager().getDeck().get(2);

        switch (idExpertCard){
            case "":
                expertCardId.setImage(new Image());
                studentCard1.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(0)));
                studentCard2.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(1)));
                studentCard3.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(2)));
                studentCard4.setImage(getColorStudent(((StudentToHallCard)expertCard).getStudents().get(3)));
                break;

            case"":
                expertCardId.setImage(new Image());
                studentCard1.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(0)));
                studentCard2.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(1)));
                studentCard3.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(2)));
                studentCard4.setImage(getColorStudent(((StudentToIslandCard)expertCard).getStudents().get(3)));
                break;
            case "":
                expertCardId.setImage(new Image());

                studentCard1.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(0)));
                studentCard2.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(1)));
                studentCard3.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(2)));
                studentCard4.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(3)));
                studentCard5.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(2)));
                studentCard6.setImage(getColorStudent(((IngressCardSwapCard)expertCard).getStudents().get(3)));
        }


    }

    public void onNextClick(MouseEvent mouseEvent) {
            MessageMethod messageMethod=new PlayExpertCard();
        ((PlayExpertCard)messageMethod).setExpertCard(idExpertCard);
        ControllerHandler.getInstance().write(messageMethod);
    }


    /**
     *
     * @param mouseEvent
     */
    public void onClickStudentCard1(MouseEvent mouseEvent) {
        switch (idExpertCard){
            case "":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(0).getId());
                break;
            case "d":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(0).getId());
                break;
            case " ":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(0).getId());

        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void onClickStudentCard2(MouseEvent mouseEvent) {
        switch (idExpertCard){
            case "":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(1).getId());
                break;
            case "d":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(1).getId());
                break;
            case " ":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(1).getId());

        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void onClickStudentCard3(MouseEvent mouseEvent) {
        switch (idExpertCard){
            case "":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(2).getId());
                break;
            case "d":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(2).getId());
                break;
            case " ":
                MessageMethod messageMethodSwap=new IngressCardSwap();
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(2).getId());

        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void onClickStudentCard4(MouseEvent mouseEvent) {
        switch (idExpertCard){
            case "":
                ((StudentToHall)messageMethodHall).setStudentToHall(((StudentToHallCard)expertCard).getStudents().get(3).getId());
                break;
            case "d":
                ((StudentToIsland)messageMethodIsland).setStudent(((StudentToIslandCard)expertCard).getStudents().get(3).getId());
                break;
            case " ":
                ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(3).getId());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void onClickStudentCard5(MouseEvent mouseEvent) {
        if(idExpertCard=="")
            ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(4).getId());
    }

    /**
     *
     * @param mouseEvent
     */
    public void onClickStudentCard6(MouseEvent mouseEvent) {
        if(idExpertCard=="")
            ((IngressCardSwap)messageMethodSwap).setStudentCard(((IngressCardSwapCard)expertCard).getStudents().get(5).getId());
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickFinishExpertMove(MouseEvent mouseEvent) {
        ControllerHandler.getInstance().write(new RoundEnd());
    }

}
