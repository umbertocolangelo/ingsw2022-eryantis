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
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class GuiActionPhaseController implements Initializable {


    private String motherNature = "file:src/main/resources/Graphical_Assets/pawns/mothernature.png";
    private String yellow = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";
    private String red = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";
    private String blue = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";
    private String green = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";
    private String pink = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

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

    private LinkedList<ImageView> studentsIngress = new LinkedList<ImageView>();

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
        studentsIngress.add(studentIngress1);
        studentsIngress.add(studentIngress2);
        studentsIngress.add(studentIngress3);
        studentsIngress.add(studentIngress4);
        studentsIngress.add(studentIngress5);
        studentsIngress.add(studentIngress6);
        studentsIngress.add(studentIngress7);
        studentsIngress.add(studentIngress8);
        studentsIngress.add(studentIngress9);

        Game game=ControllerHandler.getInstance().getClient().getGame();

        for(int i = 0; i < game.getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++){
            switch (game.getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor()) {
                case RED -> {
                    studentsIngress.get(i).setImage(new Image(red));
                }
                case GREEN -> {
                    studentsIngress.get(i).setImage(new Image(green));
                }
                case BLUE -> {
                    studentsIngress.get(i).setImage(new Image(blue));
                }
                case PINK -> {
                    studentsIngress.get(i).setImage(new Image(pink));
                }
                case YELLOW -> {
                    studentsIngress.get(i).setImage(new Image(yellow));
                }


            }
        }



    }


}
