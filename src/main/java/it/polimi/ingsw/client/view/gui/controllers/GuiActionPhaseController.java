package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.pawns.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class GuiActionPhaseController implements Initializable {


    private String motherNaturePath = "file:src/main/resources/Graphical_Assets/pawns/mothernature.png";
    private String yellowPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";
    private String redPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";
    private String bluePath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";
    private String greenPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";
    private String pinkPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    /**
     *
     */
    @FXML
    private AnchorPane scenePane;
    @FXML
    private ImageView studentIngress1;
    @FXML
    private ImageView studentIngress2;
    @FXML
    private ImageView studentIngress3;
    @FXML
    private ImageView studentIngress4;
    @FXML
    private ImageView studentIngress5;
    @FXML
    private ImageView studentIngress6;
    @FXML
    private ImageView studentIngress7;
    @FXML
    private ImageView studentIngress8;
    @FXML
    private ImageView studentIngress9;
    @FXML
    private ImageView studentHallGreen1;
    @FXML
    private ImageView studentHallGreen2;
    @FXML
    private ImageView studentHallGreen3;
    @FXML
    private ImageView studentHallGreen4;
    @FXML
    private ImageView studentHallGreen5;
    @FXML
    private ImageView studentHallGreen6;
    @FXML
    private ImageView studentHallGreen7;
    @FXML
    private ImageView studentHallGreen8;
    @FXML
    private ImageView studentHallGreen9;
    @FXML
    private ImageView studentHallGreen10;
    @FXML
    private ImageView studentHallRed1;
    @FXML
    private ImageView studentHallRed2;
    @FXML
    private ImageView studentHallRed3;
    @FXML
    private ImageView studentHallRed4;
    @FXML
    private ImageView studentHallRed5;
    @FXML
    private ImageView studentHallRed6;
    @FXML
    private ImageView studentHallRed7;
    @FXML
    private ImageView studentHallRed8;
    @FXML
    private ImageView studentHallRed9;
    @FXML
    private ImageView studentHallRed10;
    @FXML
    private ImageView studentHallBlue1;
    @FXML
    private ImageView studentHallBlue2;
    @FXML
    private ImageView studentHallBlue3;
    @FXML
    private ImageView studentHallBlue4;
    @FXML
    private ImageView studentHallBlue5;
    @FXML
    private ImageView studentHallBlue6;
    @FXML
    private ImageView studentHallBlue7;
    @FXML
    private ImageView studentHallBlue8;
    @FXML
    private ImageView studentHallBlue9;
    @FXML
    private ImageView studentHallBlue10;
    @FXML
    private ImageView studentHallYellow1;
    @FXML
    private ImageView studentHallYellow2;
    @FXML
    private ImageView studentHallYellow3;
    @FXML
    private ImageView studentHallYellow4;
    @FXML
    private ImageView studentHallYellow5;
    @FXML
    private ImageView studentHallYellow6;
    @FXML
    private ImageView studentHallYellow7;
    @FXML
    private ImageView studentHallYellow8;
    @FXML
    private ImageView studentHallYellow9;
    @FXML
    private ImageView studentHallYellow10;
    @FXML
    private ImageView studentHallPink1;
    @FXML
    private ImageView studentHallPink2;
    @FXML
    private ImageView studentHallPink3;
    @FXML
    private ImageView studentHallPink4;
    @FXML
    private ImageView studentHallPink5;
    @FXML
    private ImageView studentHallPink6;
    @FXML
    private ImageView studentHallPink7;
    @FXML
    private ImageView studentHallPink8;
    @FXML
    private ImageView studentHallPink9;
    @FXML
    private ImageView studentHallPink10;



    /**
     *  Stores the list of ImageView for the students on the ingress
     */
    private LinkedList<ImageView> studentsIngress = new LinkedList<ImageView>();

    /**
     * Stores the list of ImageView for the green students on the hall
     */
    private LinkedList<ImageView> studentsHallGreen = new LinkedList<ImageView>();

    /**
     * Stores the list of ImageView for the red students on the hall
     */
    private LinkedList<ImageView> studentsHallRed = new LinkedList<ImageView>();

    /**
     * Stores the list of ImageView for the blue students on the hall
     */
    private LinkedList<ImageView> studentsHallBlue = new LinkedList<ImageView>();

    /**
     * Stores the list of ImageView for the yellow students on the hall
     */
    private LinkedList<ImageView> studentsHallYellow = new LinkedList<ImageView>();

    /**
     * Stores the list of ImageView for the pink students on the hall
     */
    private LinkedList<ImageView> studentsHallPink = new LinkedList<ImageView>();

    /**
     * Stores the list of students in the hall for every color
     */
    private Map<Color, LinkedList<ImageView>> hallLists = new HashMap<>();

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
     *
     * @throws IOException
     */
    public void changeScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/loading-view.fxml"));
        stage = (Stage)scenePane.getScene().getWindow();
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // populating the hallLists
        hallLists.put(Color.YELLOW, studentsHallYellow);
        hallLists.put(Color.BLUE, studentsHallBlue);
        hallLists.put(Color.GREEN, studentsHallGreen);
        hallLists.put(Color.RED, studentsHallRed);
        hallLists.put(Color.PINK, studentsHallPink);

        // populating the ImageView lists
        studentsIngress.add(studentIngress1);
        studentsIngress.add(studentIngress2);
        studentsIngress.add(studentIngress3);
        studentsIngress.add(studentIngress4);
        studentsIngress.add(studentIngress5);
        studentsIngress.add(studentIngress6);
        studentsIngress.add(studentIngress7);
        studentsIngress.add(studentIngress8);
        studentsIngress.add(studentIngress9);

        studentsHallBlue.add(studentHallBlue1);
        studentsHallBlue.add(studentHallBlue2);
        studentsHallBlue.add(studentHallBlue3);
        studentsHallBlue.add(studentHallBlue4);
        studentsHallBlue.add(studentHallBlue5);
        studentsHallBlue.add(studentHallBlue6);
        studentsHallBlue.add(studentHallBlue7);
        studentsHallBlue.add(studentHallBlue8);
        studentsHallBlue.add(studentHallBlue9);
        studentsHallBlue.add(studentHallBlue10);

        studentsHallGreen.add(studentHallGreen1);
        studentsHallGreen.add(studentHallGreen2);
        studentsHallGreen.add(studentHallGreen3);
        studentsHallGreen.add(studentHallGreen4);
        studentsHallGreen.add(studentHallGreen5);
        studentsHallGreen.add(studentHallGreen6);
        studentsHallGreen.add(studentHallGreen7);
        studentsHallGreen.add(studentHallGreen8);
        studentsHallGreen.add(studentHallGreen9);
        studentsHallGreen.add(studentHallGreen10);

        studentsHallRed.add(studentHallRed1);
        studentsHallRed.add(studentHallRed2);
        studentsHallRed.add(studentHallRed3);
        studentsHallRed.add(studentHallRed4);
        studentsHallRed.add(studentHallRed5);
        studentsHallRed.add(studentHallRed6);
        studentsHallRed.add(studentHallRed7);
        studentsHallRed.add(studentHallRed8);
        studentsHallRed.add(studentHallRed9);
        studentsHallRed.add(studentHallRed10);

        studentsHallYellow.add(studentHallYellow1);
        studentsHallYellow.add(studentHallYellow2);
        studentsHallYellow.add(studentHallYellow3);
        studentsHallYellow.add(studentHallYellow4);
        studentsHallYellow.add(studentHallYellow5);
        studentsHallYellow.add(studentHallYellow6);
        studentsHallYellow.add(studentHallYellow7);
        studentsHallYellow.add(studentHallYellow8);
        studentsHallYellow.add(studentHallYellow9);
        studentsHallYellow.add(studentHallYellow10);

        studentsHallPink.add(studentHallPink1);
        studentsHallPink.add(studentHallPink2);
        studentsHallPink.add(studentHallPink3);
        studentsHallPink.add(studentHallPink4);
        studentsHallPink.add(studentHallPink5);
        studentsHallPink.add(studentHallPink6);
        studentsHallPink.add(studentHallPink7);
        studentsHallPink.add(studentHallPink8);
        studentsHallPink.add(studentHallPink9);
        studentsHallPink.add(studentHallPink10);


        Game game=ControllerHandler.getInstance().getClient().getGame();

        // show students in ingress
        for(int i = 0; i < game.getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++){
            switch (game.getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor()) {
                case RED -> {
                    studentsIngress.get(i).setImage(new Image(redPath));
                }
                case GREEN -> {
                    studentsIngress.get(i).setImage(new Image(greenPath));
                }
                case BLUE -> {
                    studentsIngress.get(i).setImage(new Image(bluePath));
                }
                case PINK -> {
                    studentsIngress.get(i).setImage(new Image(pinkPath));
                }
                case YELLOW -> {
                    studentsIngress.get(i).setImage(new Image(yellowPath));
                }
            }
        }

        // show students in green hall

        for(Color color : Color.values()){
            for(int i = 0; i < game.getCurrentPlayer().getSchool().getHall().getLine(color).getStudents().size(); i++){
                switch (color) {
                    case RED -> {
                        hallLists.get(color).get(i).setImage(new Image(redPath));
                    }
                    case GREEN -> {
                        hallLists.get(color).get(i).setImage(new Image(greenPath));
                    }
                    case BLUE -> {
                        hallLists.get(color).get(i).setImage(new Image(bluePath));
                    }
                    case PINK -> {
                        hallLists.get(color).get(i).setImage(new Image(pinkPath));
                    }
                    case YELLOW -> {
                        hallLists.get(color).get(i).setImage(new Image(yellowPath));
                    }
                }
            }
        }

    }


}
