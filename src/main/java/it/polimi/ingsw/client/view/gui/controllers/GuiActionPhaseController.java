package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.PlayerPhase;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;

public class GuiActionPhaseController implements Initializable {

    /**
     *
     */
    private String motherNaturePath = "file:src/main/resources/Graphical_Assets/pawns/mothernature.png";

    /**
     *
     */
    private String yellowPath = "file:src/main/resources/Graphical_Assets/pawns/student_yellow.png";

    /**
     *
     */
    private String redPath = "file:src/main/resources/Graphical_Assets/pawns/student_red.png";

    /**
     *
     */
    private String bluePath = "file:src/main/resources/Graphical_Assets/pawns/student_blue.png";

    /**
     *
     */
    private String greenPath = "file:src/main/resources/Graphical_Assets/pawns/student_green.png";

    /**
     *
     */
    private String pinkPath = "file:src/main/resources/Graphical_Assets/pawns/student_pink.png";

    /**
     *
     */
    private String islandMotherNature="file:src/main/resources/Graphical_Assets/pawns/islandMotherNature.png";

    /**
     *
     */
    @FXML
    private AnchorPane scenePane;

    /**
     *
     */
    @FXML
    private ImageView studentIngress1;

    /**
     *
     */
    @FXML
    private ImageView studentIngress2;

    /**
     *
     */
    @FXML
    private ImageView studentIngress3;

    /**
     *
     */
    @FXML
    private ImageView studentIngress4;

    /**
     *
     */
    @FXML
    private ImageView studentIngress5;

    /**
     *
     */
    @FXML
    private ImageView studentIngress6;

    /**
     *
     */
    @FXML
    private ImageView studentIngress7;
    /**
     *
     */
    @FXML
    private ImageView studentIngress8;

    /**
     *
     */
    @FXML
    private ImageView studentIngress9;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen1;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen2;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen3;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen4;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen5;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen6;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen7;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen8;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen9;

    /**
     *
     */
    @FXML
    private ImageView studentHallGreen10;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed1;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed2;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed3;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed4;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed5;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed6;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed7;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed8;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed9;

    /**
     *
     */
    @FXML
    private ImageView studentHallRed10;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue1;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue2;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue3;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue4;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue5;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue6;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue7;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue8;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue9;

    /**
     *
     */
    @FXML
    private ImageView studentHallBlue10;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow1;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow2;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow3;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow4;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow5;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow6;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow7;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow8;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow9;

    /**
     *
     */
    @FXML
    private ImageView studentHallYellow10;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink1;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink2;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink3;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink4;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink5;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink6;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink7;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink8;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink9;

    /**
     *
     */
    @FXML
    private ImageView studentHallPink10;

    /**
     *
     */
    @FXML
    private ImageView island1;

    /**
     *
     */
    @FXML
    private ImageView island2;

    /**
     *
     */
    @FXML
    private ImageView island3;

    /**
     *
     */
    @FXML
    private ImageView island4;

    /**
     *
     */
    @FXML
    private ImageView island5;

    /**
     *
     */
    @FXML
    private ImageView island6;

    /**
     *
     */
    @FXML
    private ImageView island7;

    /**
     *
     */
    @FXML
    private ImageView island8;

    /**
     *
     */
    @FXML
    private ImageView island9;

    /**
     *
     */
    @FXML
    private ImageView island10;

    /**
     *
     */
    @FXML
    private ImageView island11;

    /**
     *
     */
    @FXML
    private ImageView island12;

    /**
     *
     */
    @FXML
    private ImageView greenLine;

    /**
     *
     */
    @FXML
    private ImageView student1Cloud1;

    /**
     *
     */
    @FXML
    private ImageView student2Cloud1;

    /**
     *
     */
    @FXML
    private ImageView student3Cloud1;

    /**
     *
     */
    @FXML
    private ImageView student4Cloud1;

    /**
     *
     */
    @FXML
    private ImageView student1Cloud2;

    /**
     *
     */
    @FXML
    private ImageView student2Cloud2;

    /**
     *
     */
    @FXML
    private ImageView student3Cloud2;

    /**
     *
     */
    @FXML
    private ImageView student4Cloud2;

    /**
     *
     */
    @FXML
    private ImageView student1Cloud3;

    /**
     *
     */
    @FXML
    private ImageView student2Cloud3;

    /**
     *
     */
    @FXML
    private ImageView student3Cloud3;

    /**
     *
     */
    @FXML
    private ImageView student4Cloud3;

    /**
     *
     */
    @FXML
    private ImageView cloud3;

    /**
     *
     */
    @FXML
    private Button expertCardButton;

    /**
     *
     */
    @FXML
    private Label communication;

    /**
     *
     */
    @FXML
    private Button finishExpertMove;

    /**
     *
     */
    private Student studentOnRound;

    /**
     *
     */
    private LinkedList<ImageView> studentOnCloud = new LinkedList<>();

    /**
     * Variable need to calculate the jumps for MotherNature
     */
     private Integer idIsland;

    /**
     *
     */
    private Color studentMoving;

    /**
     * Keep the reference to the Game
     */
    private Game game;

    /**
     *
     */
    private MessageMethod studentOnHall = new MovingStudentsFromIngressToHall();

    /**
     * Stores the list of ImageView for the island
     */
    private LinkedList<ImageView> island = new LinkedList<ImageView>();

    /**
     * Stores the list of ImageView for the students on the ingress
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
     * @throws IOException
     */
    public void changeScene() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/pianificationPhase-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.setTitle("Eriantys");
        stage.show();

        GuiActionPhaseController pianController = fxmlLoader.getController();
        pianController.resize(stage, scene);
    }

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
        //switch (game.getCurrentPlayer().)
        game = ControllerHandler.getInstance().getClient().getGame();
        MotherNature motherNature = game.getMotherNature();
        if (game.getGameMode()==false || game.getCardManager().getCurrentCard()!=null && ControllerHandler.getInstance().getFinishTurn()) {
            expertCardButton.setVisible(false);
        }
        if (game.getCurrentRound().getId()==null) {
          finishExpertMove.setVisible(false);
          finishExpertMove.setDisable(false);
        }
        switch (motherNature.getIsland().getId()) {
            case "26":
                island1.setImage(new Image(islandMotherNature));
                idIsland = 26;
                break;
            case "27":
                island2.setImage(new Image(islandMotherNature));
                idIsland = 27;
                break;
            case "28":
                island3.setImage(new Image(islandMotherNature));
                idIsland = 28;
                break;
            case "29":
                island4.setImage(new Image(islandMotherNature));
                idIsland = 29;
                break;
            case "30":
                island5.setImage(new Image(islandMotherNature));
                idIsland = 30;
                break;
            case "31":
                island6.setImage(new Image(islandMotherNature));
                idIsland = 31;
                break;
            case "32":
                island7.setImage(new Image(islandMotherNature));
                idIsland = 32;
                break;
            case "33":
                island8.setImage(new Image(islandMotherNature));
                idIsland = 33;
                break;
            case "34":
                island9.setImage(new Image(islandMotherNature));
                idIsland = 34;
                break;
            case "35":
                island10.setImage(new Image(islandMotherNature));
                idIsland = 35;
                break;
            case "36":
                island11.setImage(new Image(islandMotherNature));
                idIsland = 36;
                break;
            case "37":
                island12.setImage(new Image(islandMotherNature));
                idIsland = 37;
                break;
        }

       /*
       island.add(island1);
        island.add(island2);
       island.add(island3);
        island.add(island4);
        island.add(island5);
        island.add(island6);
        island.add(island7);
       island.add(island8);
       island.add( island9);
       island.add(island10);
       island.add(island11);
        island.add(island12);
        */

        if (game.getCurrentRound().getId()==null) {
            communication.setText("Normal round");
        }
        else {
            switch (game.getCurrentRound().getId()) {
                case 0:
                    communication.setText("You are in student on island round");
                    break;
                case 1:
                    communication.setText("You are in ingress Hall swap");
                    break;
                case 2:
                    communication.setText("You are in studentOn Island round");
                    break;
                case 3:
                    communication.setText("You are in student on card round");
                    break;
            }
        }

        if (!game.getClouds().get(0).getStudents().isEmpty()) {
            student1Cloud1.setImage(getColorStudent(game.getClouds().get(0).getStudents().get(0)));
            student2Cloud1.setImage(getColorStudent(game.getClouds().get(0).getStudents().get(1)));
            student3Cloud1.setImage(getColorStudent(game.getClouds().get(0).getStudents().get(2)));
            if (game.getPlayerList().size()==3) {
                student4Cloud1.setImage(getColorStudent(game.getClouds().get(0).getStudents().get(3)));
            }
        }
        if(!game.getClouds().get(1).getStudents().isEmpty()) {
            student1Cloud2.setImage(getColorStudent(game.getClouds().get(1).getStudents().get(0)));
            student2Cloud2.setImage(getColorStudent(game.getClouds().get(1).getStudents().get(1)));
            student3Cloud2.setImage(getColorStudent(game.getClouds().get(1).getStudents().get(2)));
            if (game.getPlayerList().size()==3) {
                student4Cloud2.setImage(getColorStudent(game.getClouds().get(1).getStudents().get(3)));
            }
        }
        if (game.getPlayerList().size()==3) {
            if (!game.getClouds().get(2).getStudents().isEmpty()) {
                student1Cloud3.setImage(getColorStudent(game.getClouds().get(2).getStudents().get(0)));
                student2Cloud3.setImage(getColorStudent(game.getClouds().get(2).getStudents().get(1)));
                student3Cloud3.setImage(getColorStudent(game.getClouds().get(2).getStudents().get(2)));
                student4Cloud3.setImage(getColorStudent(game.getClouds().get(2).getStudents().get(3)));
            }
        } else {
            cloud3.setImage(null);
        }

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

        // show students in ingress
        for (int i = 0; i < game.getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++) {
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
        for (Color color : Color.values()) {
            for (int i = 0; i < game.getCurrentPlayer().getSchool().getHall().getLine(color).getStudents().size(); i++) {
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

    /**
     *
     * @return jumps The number of jumps that motherNature should do
     */
    public Integer calculateJumps(Integer idIslandTarget,Integer idIslandMotherNature ) {
        Integer jumps = 0;
       while (idIslandTarget!=idIslandMotherNature) {
           idIslandMotherNature++;
           if (idIslandMotherNature==37) {
               idIslandMotherNature = 26;
           }
           jumps++;
       }
       return jumps;
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland1(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()<=calculateJumps(26,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(26, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3) {
           StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
           (messageMethod).setIsland("26");
           ControllerHandler.getInstance().write(messageMethod);
           ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }


    /**
     *
     * @param mouseEvent
     */
    public void clickIsland2(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(27,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(27, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3) {
             StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
             (messageMethod).setIsland("27");
             ControllerHandler.getInstance().write(messageMethod);
             ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland3(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue() >= calculateJumps(28, idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(28, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3) {
           StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("28");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland4(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
           if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(29,idIsland)) {
               MessageMethod movingMotherNature = new MovingMotherNature();
               ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(29, idIsland));
               ControllerHandler.getInstance().write(movingMotherNature);
           }
        } else if (game.getCurrentRound().getId()==3 ) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("29");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland5(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(30, idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature)movingMotherNature).setJumps(calculateJumps(30, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("30");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland6(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(31,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(31, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3 && studentOnRound!=null) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("31");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland7(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(32,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(32, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3 ) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("32");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland8(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(33,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature)movingMotherNature).setJumps(calculateJumps(33,idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3 ) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("33");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland9(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
             if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(34,idIsland)) {
                 MessageMethod movingMotherNature = new MovingMotherNature();
                 ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(34, idIsland));
                 ControllerHandler.getInstance().write(movingMotherNature);
             }
        } else if (game.getCurrentRound().getId()==3 ) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("34");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland10(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(35,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(35, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        }else if (game.getCurrentRound().getId()==3) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("35");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland11(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue() >= calculateJumps(36, idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(36, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3 && studentOnRound!=null) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("36");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickIsland12(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(37,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(37, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            }
        } else if (game.getCurrentRound().getId()==3 && studentOnRound!=null) {
            StudentToIsland messageMethod = ControllerHandler.getInstance().getStudentToIsland();
            (messageMethod).setIsland("37");
            ControllerHandler.getInstance().write(messageMethod);
            ControllerHandler.getInstance().setStudentToIsland(new StudentToIsland());
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnGreenLine(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()!=null) {
            //greenLine.setEffect(new DropShadow(20,null));
            if (game.getCurrentRound().getId()==0) {
                IngressCardSwap ingressCardSwap = ControllerHandler.getInstance().getMessageMethod();
                ingressCardSwap.setStudentIngress(game.getCurrentPlayer().getSchool().getHall().getLine(Color.GREEN).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(ingressCardSwap);
                ControllerHandler.getInstance().setMessageMethodIngressCard(new IngressCardSwap());
            }
            if (game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(Color.GREEN).getStudents().isEmpty() && studentOnRound!=null) {
                MessageMethod messageMethod = new IngressHallSwap();
                ((IngressHallSwap) messageMethod).setStudentIngress(studentOnRound.getId());
                ((IngressHallSwap) messageMethod).setStudentHall(game.getCurrentPlayer().getSchool().getHall().getLine(Color.GREEN).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else {
            if (studentMoving != null) {
                switch (studentMoving) {
                    case GREEN -> {
                        ControllerHandler.getInstance().write(studentOnHall);
                        studentOnHall = new MovingStudentsFromIngressToHall();
                    }
                }
            }
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnRedLine(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()!=null) {
            if (game.getCurrentRound().getId()==0) {
                IngressCardSwap ingressCardSwap = ControllerHandler.getInstance().getMessageMethod();
                ingressCardSwap.setStudentIngress(game.getCurrentPlayer().getSchool().getHall().getLine(Color.RED).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(ingressCardSwap);
                ControllerHandler.getInstance().setMessageMethodIngressCard(new IngressCardSwap());
            }
            if (game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(Color.RED).getStudents().isEmpty() && studentOnRound != null) {
                MessageMethod messageMethod = new IngressHallSwap();
                ((IngressHallSwap) messageMethod).setStudentIngress(studentOnRound.getId());
                ((IngressHallSwap) messageMethod).setStudentHall(game.getCurrentPlayer().getSchool().getHall().getLine(Color.RED).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(messageMethod);
            }

        } else {
            if (studentMoving != null) {
                switch (studentMoving) {
                    case RED -> {
                        ControllerHandler.getInstance().write(studentOnHall);
                        studentOnHall = new MovingStudentsFromIngressToHall();
                    }
                }
            }
        }
    }

    public void clikOnYellowLine(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()!=null){
            if(game.getCurrentRound().getId()==0){
                IngressCardSwap ingressCardSwap = ControllerHandler.getInstance().getMessageMethod();
                ingressCardSwap.setStudentIngress(game.getCurrentPlayer().getSchool().getHall().getLine(Color.YELLOW).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(ingressCardSwap);
                ControllerHandler.getInstance().setMessageMethodIngressCard(new IngressCardSwap());
            }
            if(game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(Color.YELLOW).getStudents().isEmpty() && studentOnRound!=null) {
                MessageMethod messageMethod = new IngressHallSwap();
                ((IngressHallSwap) messageMethod).setStudentIngress(studentOnRound.getId());
                ((IngressHallSwap) messageMethod).setStudentHall(game.getCurrentPlayer().getSchool().getHall().getLine(Color.YELLOW).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        }else {
            if (studentMoving != null) {
                switch (studentMoving) {
                    case YELLOW -> {
                        ControllerHandler.getInstance().write(studentOnHall);
                        studentOnHall = new MovingStudentsFromIngressToHall();
                    }
                }
            }
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnPinkLine(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()!=null) {
            if (game.getCurrentRound().getId()==0) {
                IngressCardSwap ingressCardSwap = ControllerHandler.getInstance().getMessageMethod();
                ingressCardSwap.setStudentIngress(game.getCurrentPlayer().getSchool().getHall().getLine(Color.PINK).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(ingressCardSwap);
                ControllerHandler.getInstance().setMessageMethodIngressCard(new IngressCardSwap());
            }
            if (game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(Color.PINK).getStudents().isEmpty() && studentOnRound!=null) {
                MessageMethod messageMethod = new IngressHallSwap();
                ((IngressHallSwap) messageMethod).setStudentIngress(studentOnRound.getId());
                ((IngressHallSwap)messageMethod).setStudentHall(game.getCurrentPlayer().getSchool().getHall().getLine(Color.PINK).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else {
            if (studentMoving != null) {
                switch (studentMoving) {
                    case PINK -> {
                        ControllerHandler.getInstance().write(studentOnHall);
                        studentOnHall = new MovingStudentsFromIngressToHall();
                    }
                }
            }
        }
    }

    public void clickOnBlueLine(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()!=null) {
            if (game.getCurrentRound().getId()==0) {
                IngressCardSwap ingressCardSwap = ControllerHandler.getInstance().getMessageMethod();
                ingressCardSwap.setStudentIngress(game.getCurrentPlayer().getSchool().getHall().getLine(Color.BLUE).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(ingressCardSwap);
                ControllerHandler.getInstance().setMessageMethodIngressCard(new IngressCardSwap());
            }
            if (game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(Color.BLUE).getStudents().isEmpty() && studentOnRound!=null) {
                MessageMethod messageMethod = new IngressHallSwap();
                ((IngressHallSwap) messageMethod).setStudentIngress(studentOnRound.getId());
                ((IngressHallSwap)messageMethod).setStudentHall(game.getCurrentPlayer().getSchool().getHall().getLine(Color.BLUE).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else {
            if (studentMoving != null) {
                switch (studentMoving) {
                    case BLUE -> {
                        ControllerHandler.getInstance().write(studentOnHall);
                        studentOnHall = new MovingStudentsFromIngressToHall();
                    }
                }
            }
        }

    }

    /**
     * Refresh the page after a move has been made
     * @throws IOException
     */
    public void refresh() throws IOException {
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
     *
     * @throws IOException
     */
    public void sceneStudentOnCard() throws IOException {
        stage = new Stage();
        ControllerHandler.getInstance().getStage().close();
        ControllerHandler.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/studentsOnCard-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setScene(scene);
        stage.show();

        GuiChooseStudentsOnCardController studentsController = fxmlLoader.getController();
        studentsController.resize(stage, scene);
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress1(MouseEvent mouseEvent) {
        if(game.getCurrentRound().getId()==null){
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0).getColor();
            }
        } else if(game.getCurrentRound().getId()==1) {
            studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress2(MouseEvent mouseEvent) {
        if(game.getCurrentRound().getId()==null){
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1).getColor();
            }
        }else   if(game.getCurrentRound().getId()==1)
            {
           studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0);
            }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress3(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId() == null) {
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2).getColor();
            }
        } else if (game.getCurrentRound().getId() == 1 ) {
            studentOnRound  =game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress4(MouseEvent mouseEvent) {
            if(game.getCurrentRound().getId()==null){
                //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
                if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS) {
                    ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3).getId());
                    studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3).getColor();
                }
            }else   if(game.getCurrentRound().getId()==1)             {
                studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3);
                }
    }

    public void clickOnIngress5(MouseEvent mouseEvent) {
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().size()>4) {
            if(game.getCurrentRound().getId()==null){
                //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
                if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS) {
                    ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4).getId());
                    studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4).getColor();
                }
            }else   if(game.getCurrentRound().getId()==1 )
            {
               studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4);
            }
        }

    }

    public void clickOnIngress6(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size() > 5) {
            if(game.getCurrentRound().getId()==null){
                //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
                if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS) {
                    ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                    studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getColor();
                }
            }else   if(game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getColor()).getStudents().isEmpty())
            {
                studentOnRound=(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5));
            }
        }
    }

    public void clickOnIngress7(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size() > 6) {
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS && game.getCurrentRound().getId() == null) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(6).getColor();
            } else if (game.getCurrentRound().getId() == 1 || game.getCurrentRound().getId() == 1 ) {
                studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(6);
            }
        }
    }

    public void clickOnIngress8(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size() > 7) {
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS && game.getCurrentRound().getId() == null) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(7).getColor();
            } else if (game.getCurrentRound().getId() == 1 || game.getCurrentRound().getId() == 1 ) {
              studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(7);

            }
        }
    }


    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress9(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size() > 8) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS && game.getCurrentRound().getId() == null) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(8).getColor();
            } else if (game.getCurrentRound().getId() == 1 || game.getCurrentRound().getId() == 1 ) {
               studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(8);
            }
        }
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnCloud2(MouseEvent mouseEvent) throws IOException {
        if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD) {
            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ( (ChooseStudentsFromCloud)messageMethod).setCloud(game.getClouds().get(1).getId());
            ControllerHandler.getInstance().write(messageMethod);
           // refresh();

        }
    }

    /**
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnCloud3(MouseEvent mouseEvent) throws IOException {
        if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD && game.getPlayerList().size()==3) {
            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ( (ChooseStudentsFromCloud)messageMethod).setCloud(game.getClouds().get(2).getId());
            ControllerHandler.getInstance().write(messageMethod);
           // refresh();
        }
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnCloud1(MouseEvent mouseEvent) throws IOException {
        if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD) {
            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ((ChooseStudentsFromCloud)messageMethod).setCloud(game.getClouds().get(0).getId());
            ControllerHandler.getInstance().write(messageMethod);
            //refresh();
        }
    }

    public void clickPlayExpertCard(MouseEvent mouseEvent) throws IOException {
        if (game.getGameMode()==true && game.getCardManager().getCurrentCard()==null) {
            stage = new Stage();
            ControllerHandler.getInstance().getStage().close();
            ControllerHandler.setStage(stage);

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/expertCard-view.fxml"));
            scene = new Scene(fxmlLoader.load(), 1280, 720);
            stage.setScene(scene);
            stage.show();

            GuiChooseExpertCardController expertController = fxmlLoader.getController();
            expertController.resize(stage, scene);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickFinishExpertMove(MouseEvent mouseEvent) {
        ControllerHandler.getInstance().write(new RoundEnd());
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
}
