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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.ResourceBundle;

public class GuiActionPhaseController implements Initializable {

    /**
     * Path to mother nature image file
     */
    private String motherNaturePath = "file:src/main/resources/Graphical_Assets/pawns/mothernature.png";

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
     * Path to yellow professor image file
     */
    private String yellowProfessorPath = "file:src/main/resources/Graphical_Assets/pawns/professor_yellow.png";

    /**
     * Path to red professor image file
     */
    private String redProfessorPath = "file:src/main/resources/Graphical_Assets/pawns/professor_red.png";

    /**
     * Path to green professor image file
     */
    private String greenProfessorPath = "file:src/main/resources/Graphical_Assets/pawns/professor_green.png";

    /**
     * Path to pink professor image file
     */
    private String pinkProfessorPath = "file:src/main/resources/Graphical_Assets/pawns/professor_pink.png";

    /**
     * Path to blue professor image file
     */
    private String blueProfessorPath = "file:src/main/resources/Graphical_Assets/pawns/professor_blue.png";

    /**
     * AnchorPane reference
     */
    @FXML
    private AnchorPane scenePane;

    /**
     * professor ImageView reference
     */
    @FXML
    private ImageView professorGreen;
    @FXML
    private ImageView professorRed;
    @FXML
    private ImageView professorYellow;
    @FXML
    private ImageView professorPink;
    @FXML
    private ImageView professorBlue;

    /**
     * tower ImageView reference
     */
    @FXML
    private ImageView tower1;
    @FXML
    private ImageView tower2;
    @FXML
    private ImageView tower3;
    @FXML
    private ImageView tower4;
    @FXML
    private ImageView tower5;
    @FXML
    private ImageView tower6;
    @FXML
    private ImageView tower7;
    @FXML
    private ImageView tower8;

    /**
     * student on island 1 ImageView reference
     */
    @FXML
    private ImageView student1island1;
    @FXML
    private ImageView student2island1;
    @FXML
    private ImageView student3island1;
    @FXML
    private ImageView student4island1;
    @FXML
    private ImageView student5island1;
    @FXML
    private ImageView student6island1;
    @FXML
    private ImageView student7island1;
    @FXML
    private ImageView student8island1;
    @FXML
    private ImageView student9island1;
    @FXML
    private ImageView student10island1;
    @FXML
    private ImageView student11island1;
    @FXML
    private ImageView student12island1;
    @FXML
    private ImageView student13island1;
    @FXML
    private ImageView student14island1;
    @FXML
    private ImageView student15island1;
    @FXML
    private ImageView student16island1;
    @FXML
    private ImageView student17island1;
    @FXML
    private ImageView student18island1;
    @FXML
    private ImageView student19island1;
    @FXML
    private ImageView student20island1;

    /**
     * student on island 2 ImageView reference
     */
    @FXML
    private ImageView student1island2;
    @FXML
    private ImageView student2island2;
    @FXML
    private ImageView student3island2;
    @FXML
    private ImageView student4island2;
    @FXML
    private ImageView student5island2;
    @FXML
    private ImageView student6island2;
    @FXML
    private ImageView student7island2;
    @FXML
    private ImageView student8island2;
    @FXML
    private ImageView student9island2;
    @FXML
    private ImageView student10island2;
    @FXML
    private ImageView student11island2;
    @FXML
    private ImageView student12island2;
    @FXML
    private ImageView student13island2;
    @FXML
    private ImageView student14island2;
    @FXML
    private ImageView student15island2;
    @FXML
    private ImageView student16island2;
    @FXML
    private ImageView student17island2;
    @FXML
    private ImageView student18island2;
    @FXML
    private ImageView student19island2;
    @FXML
    private ImageView student20island2;

    /**
     * student on island 1 ImageView reference
     */
    @FXML
    private ImageView student1island3;
    @FXML
    private ImageView student2island3;
    @FXML
    private ImageView student3island3;
    @FXML
    private ImageView student4island3;
    @FXML
    private ImageView student5island3;
    @FXML
    private ImageView student6island3;
    @FXML
    private ImageView student7island3;
    @FXML
    private ImageView student8island3;
    @FXML
    private ImageView student9island3;
    @FXML
    private ImageView student10island3;
    @FXML
    private ImageView student11island3;
    @FXML
    private ImageView student12island3;
    @FXML
    private ImageView student13island3;
    @FXML
    private ImageView student14island3;
    @FXML
    private ImageView student15island3;
    @FXML
    private ImageView student16island3;
    @FXML
    private ImageView student17island3;
    @FXML
    private ImageView student18island3;
    @FXML
    private ImageView student19island3;
    @FXML
    private ImageView student20island3;

    /**
     * student on island 4 ImageView reference
     */
    @FXML
    private ImageView student1island4;
    @FXML
    private ImageView student2island4;
    @FXML
    private ImageView student3island4;
    @FXML
    private ImageView student4island4;
    @FXML
    private ImageView student5island4;
    @FXML
    private ImageView student6island4;
    @FXML
    private ImageView student7island4;
    @FXML
    private ImageView student8island4;
    @FXML
    private ImageView student9island4;
    @FXML
    private ImageView student10island4;
    @FXML
    private ImageView student11island4;
    @FXML
    private ImageView student12island4;
    @FXML
    private ImageView student13island4;
    @FXML
    private ImageView student14island4;
    @FXML
    private ImageView student15island4;
    @FXML
    private ImageView student16island4;
    @FXML
    private ImageView student17island4;
    @FXML
    private ImageView student18island4;
    @FXML
    private ImageView student19island4;
    @FXML
    private ImageView student20island4;

    /**
     * student on island 5 ImageView reference
     */
    @FXML
    private ImageView student1island5;
    @FXML
    private ImageView student2island5;
    @FXML
    private ImageView student3island5;
    @FXML
    private ImageView student4island5;
    @FXML
    private ImageView student5island5;
    @FXML
    private ImageView student6island5;
    @FXML
    private ImageView student7island5;
    @FXML
    private ImageView student8island5;
    @FXML
    private ImageView student9island5;
    @FXML
    private ImageView student10island5;
    @FXML
    private ImageView student11island5;
    @FXML
    private ImageView student12island5;
    @FXML
    private ImageView student13island5;
    @FXML
    private ImageView student14island5;
    @FXML
    private ImageView student15island5;
    @FXML
    private ImageView student16island5;
    @FXML
    private ImageView student17island5;
    @FXML
    private ImageView student18island5;
    @FXML
    private ImageView student19island5;
    @FXML
    private ImageView student20island5;

    /**
     * student on island 6 ImageView reference
     */
    @FXML
    private ImageView student1island6;
    @FXML
    private ImageView student2island6;
    @FXML
    private ImageView student3island6;
    @FXML
    private ImageView student4island6;
    @FXML
    private ImageView student5island6;
    @FXML
    private ImageView student6island6;
    @FXML
    private ImageView student7island6;
    @FXML
    private ImageView student8island6;
    @FXML
    private ImageView student9island6;
    @FXML
    private ImageView student10island6;
    @FXML
    private ImageView student11island6;
    @FXML
    private ImageView student12island6;
    @FXML
    private ImageView student13island6;
    @FXML
    private ImageView student14island6;
    @FXML
    private ImageView student15island6;
    @FXML
    private ImageView student16island6;
    @FXML
    private ImageView student17island6;
    @FXML
    private ImageView student18island6;
    @FXML
    private ImageView student19island6;
    @FXML
    private ImageView student20island6;

    /**
     * student on island 7 ImageView reference
     */
    @FXML
    private ImageView student1island7;
    @FXML
    private ImageView student2island7;
    @FXML
    private ImageView student3island7;
    @FXML
    private ImageView student4island7;
    @FXML
    private ImageView student5island7;
    @FXML
    private ImageView student6island7;
    @FXML
    private ImageView student7island7;
    @FXML
    private ImageView student8island7;
    @FXML
    private ImageView student9island7;
    @FXML
    private ImageView student10island7;
    @FXML
    private ImageView student11island7;
    @FXML
    private ImageView student12island7;
    @FXML
    private ImageView student13island7;
    @FXML
    private ImageView student14island7;
    @FXML
    private ImageView student15island7;
    @FXML
    private ImageView student16island7;
    @FXML
    private ImageView student17island7;
    @FXML
    private ImageView student18island7;
    @FXML
    private ImageView student19island7;
    @FXML
    private ImageView student20island7;

    /**
     * student on island 8 ImageView reference
     */
    @FXML
    private ImageView student1island8;
    @FXML
    private ImageView student2island8;
    @FXML
    private ImageView student3island8;
    @FXML
    private ImageView student4island8;
    @FXML
    private ImageView student5island8;
    @FXML
    private ImageView student6island8;
    @FXML
    private ImageView student7island8;
    @FXML
    private ImageView student8island8;
    @FXML
    private ImageView student9island8;
    @FXML
    private ImageView student10island8;
    @FXML
    private ImageView student11island8;
    @FXML
    private ImageView student12island8;
    @FXML
    private ImageView student13island8;
    @FXML
    private ImageView student14island8;
    @FXML
    private ImageView student15island8;
    @FXML
    private ImageView student16island8;
    @FXML
    private ImageView student17island8;
    @FXML
    private ImageView student18island8;
    @FXML
    private ImageView student19island8;
    @FXML
    private ImageView student20island8;

    /**
     * student on island 9 ImageView reference
     */
    @FXML
    private ImageView student1island9;
    @FXML
    private ImageView student2island9;
    @FXML
    private ImageView student3island9;
    @FXML
    private ImageView student4island9;
    @FXML
    private ImageView student5island9;
    @FXML
    private ImageView student6island9;
    @FXML
    private ImageView student7island9;
    @FXML
    private ImageView student8island9;
    @FXML
    private ImageView student9island9;
    @FXML
    private ImageView student10island9;
    @FXML
    private ImageView student11island9;
    @FXML
    private ImageView student12island9;
    @FXML
    private ImageView student13island9;
    @FXML
    private ImageView student14island9;
    @FXML
    private ImageView student15island9;
    @FXML
    private ImageView student16island9;
    @FXML
    private ImageView student17island9;
    @FXML
    private ImageView student18island9;
    @FXML
    private ImageView student19island9;
    @FXML
    private ImageView student20island9;

    /**
     * student on island 10 ImageView reference
     */
    @FXML
    private ImageView student1island10;
    @FXML
    private ImageView student2island10;
    @FXML
    private ImageView student3island10;
    @FXML
    private ImageView student4island10;
    @FXML
    private ImageView student5island10;
    @FXML
    private ImageView student6island10;
    @FXML
    private ImageView student7island10;
    @FXML
    private ImageView student8island10;
    @FXML
    private ImageView student9island10;
    @FXML
    private ImageView student10island10;
    @FXML
    private ImageView student11island10;
    @FXML
    private ImageView student12island10;
    @FXML
    private ImageView student13island10;
    @FXML
    private ImageView student14island10;
    @FXML
    private ImageView student15island10;
    @FXML
    private ImageView student16island10;
    @FXML
    private ImageView student17island10;
    @FXML
    private ImageView student18island10;
    @FXML
    private ImageView student19island10;
    @FXML
    private ImageView student20island10;

    /**
     * student on island 11 ImageView reference
     */
    @FXML
    private ImageView student1island11;
    @FXML
    private ImageView student2island11;
    @FXML
    private ImageView student3island11;
    @FXML
    private ImageView student4island11;
    @FXML
    private ImageView student5island11;
    @FXML
    private ImageView student6island11;
    @FXML
    private ImageView student7island11;
    @FXML
    private ImageView student8island11;
    @FXML
    private ImageView student9island11;
    @FXML
    private ImageView student10island11;
    @FXML
    private ImageView student11island11;
    @FXML
    private ImageView student12island11;
    @FXML
    private ImageView student13island11;
    @FXML
    private ImageView student14island11;
    @FXML
    private ImageView student15island11;
    @FXML
    private ImageView student16island11;
    @FXML
    private ImageView student17island11;
    @FXML
    private ImageView student18island11;
    @FXML
    private ImageView student19island11;
    @FXML
    private ImageView student20island11;

    /**
     * student on island 1 ImageView reference
     */
    @FXML
    private ImageView student1island12;
    @FXML
    private ImageView student2island12;
    @FXML
    private ImageView student3island12;
    @FXML
    private ImageView student4island12;
    @FXML
    private ImageView student5island12;
    @FXML
    private ImageView student6island12;
    @FXML
    private ImageView student7island12;
    @FXML
    private ImageView student8island12;
    @FXML
    private ImageView student9island12;
    @FXML
    private ImageView student10island12;
    @FXML
    private ImageView student11island12;
    @FXML
    private ImageView student12island12;
    @FXML
    private ImageView student13island12;
    @FXML
    private ImageView student14island12;
    @FXML
    private ImageView student15island12;
    @FXML
    private ImageView student16island12;
    @FXML
    private ImageView student17island12;
    @FXML
    private ImageView student18island12;
    @FXML
    private ImageView student19island12;
    @FXML
    private ImageView student20island12;

    /**
     * student on island 13 ImageView reference
     */
    @FXML
    private ImageView student1island13;
    @FXML
    private ImageView student2island13;
    @FXML
    private ImageView student3island13;
    @FXML
    private ImageView student4island13;
    @FXML
    private ImageView student5island13;
    @FXML
    private ImageView student6island13;
    @FXML
    private ImageView student7island13;
    @FXML
    private ImageView student8island13;
    @FXML
    private ImageView student9island13;
    @FXML
    private ImageView student10island13;
    @FXML
    private ImageView student11island13;
    @FXML
    private ImageView student12island13;
    @FXML
    private ImageView student13island13;
    @FXML
    private ImageView student14island13;
    @FXML
    private ImageView student15island13;
    @FXML
    private ImageView student16island13;
    @FXML
    private ImageView student17island13;
    @FXML
    private ImageView student18island13;
    @FXML
    private ImageView student19island13;
    @FXML
    private ImageView student20island13;

    /**
     * student on island 14 ImageView reference
     */
    @FXML
    private ImageView student1island14;
    @FXML
    private ImageView student2island14;
    @FXML
    private ImageView student3island14;
    @FXML
    private ImageView student4island14;
    @FXML
    private ImageView student5island14;
    @FXML
    private ImageView student6island14;
    @FXML
    private ImageView student7island14;
    @FXML
    private ImageView student8island14;
    @FXML
    private ImageView student9island14;
    @FXML
    private ImageView student10island14;
    @FXML
    private ImageView student11island14;
    @FXML
    private ImageView student12island14;
    @FXML
    private ImageView student13island14;
    @FXML
    private ImageView student14island14;
    @FXML
    private ImageView student15island14;
    @FXML
    private ImageView student16island14;
    @FXML
    private ImageView student17island14;
    @FXML
    private ImageView student18island14;
    @FXML
    private ImageView student19island14;
    @FXML
    private ImageView student20island14;

    /**
     * student on island 5 ImageView reference
     */
    @FXML
    private ImageView student1island15;
    @FXML
    private ImageView student2island15;
    @FXML
    private ImageView student3island15;
    @FXML
    private ImageView student4island15;
    @FXML
    private ImageView student5island15;
    @FXML
    private ImageView student6island15;
    @FXML
    private ImageView student7island15;
    @FXML
    private ImageView student8island15;
    @FXML
    private ImageView student9island15;
    @FXML
    private ImageView student10island15;
    @FXML
    private ImageView student11island15;
    @FXML
    private ImageView student12island15;
    @FXML
    private ImageView student13island15;
    @FXML
    private ImageView student14island15;
    @FXML
    private ImageView student15island15;
    @FXML
    private ImageView student16island15;
    @FXML
    private ImageView student17island15;
    @FXML
    private ImageView student18island15;
    @FXML
    private ImageView student19island15;
    @FXML
    private ImageView student20island15;

    /**
     * student on island 16 ImageView reference
     */
    @FXML
    private ImageView student1island16;
    @FXML
    private ImageView student2island16;
    @FXML
    private ImageView student3island16;
    @FXML
    private ImageView student4island16;
    @FXML
    private ImageView student5island16;
    @FXML
    private ImageView student6island16;
    @FXML
    private ImageView student7island16;
    @FXML
    private ImageView student8island16;
    @FXML
    private ImageView student9island16;
    @FXML
    private ImageView student10island16;
    @FXML
    private ImageView student11island16;
    @FXML
    private ImageView student12island16;
    @FXML
    private ImageView student13island16;
    @FXML
    private ImageView student14island16;
    @FXML
    private ImageView student15island16;
    @FXML
    private ImageView student16island16;
    @FXML
    private ImageView student17island16;
    @FXML
    private ImageView student18island16;
    @FXML
    private ImageView student19island16;
    @FXML
    private ImageView student20island16;

    /**
     * student on island 17 ImageView reference
     */
    @FXML
    private ImageView student1island17;
    @FXML
    private ImageView student2island17;
    @FXML
    private ImageView student3island17;
    @FXML
    private ImageView student4island17;
    @FXML
    private ImageView student5island17;
    @FXML
    private ImageView student6island17;
    @FXML
    private ImageView student7island17;
    @FXML
    private ImageView student8island17;
    @FXML
    private ImageView student9island17;
    @FXML
    private ImageView student10island17;
    @FXML
    private ImageView student11island17;
    @FXML
    private ImageView student12island17;
    @FXML
    private ImageView student13island17;
    @FXML
    private ImageView student14island17;
    @FXML
    private ImageView student15island17;
    @FXML
    private ImageView student16island17;
    @FXML
    private ImageView student17island17;
    @FXML
    private ImageView student18island17;
    @FXML
    private ImageView student19island17;
    @FXML
    private ImageView student20island17;

    /**
     * student on island 18 ImageView reference
     */
    @FXML
    private ImageView student1island18;
    @FXML
    private ImageView student2island18;
    @FXML
    private ImageView student3island18;
    @FXML
    private ImageView student4island18;
    @FXML
    private ImageView student5island18;
    @FXML
    private ImageView student6island18;
    @FXML
    private ImageView student7island18;
    @FXML
    private ImageView student8island18;
    @FXML
    private ImageView student9island18;
    @FXML
    private ImageView student10island18;
    @FXML
    private ImageView student11island18;
    @FXML
    private ImageView student12island18;
    @FXML
    private ImageView student13island18;
    @FXML
    private ImageView student14island18;
    @FXML
    private ImageView student15island18;
    @FXML
    private ImageView student16island18;
    @FXML
    private ImageView student17island18;
    @FXML
    private ImageView student18island18;
    @FXML
    private ImageView student19island18;
    @FXML
    private ImageView student20island18;

    /**
     * student on island 19 ImageView reference
     */
    @FXML
    private ImageView student1island19;
    @FXML
    private ImageView student2island19;
    @FXML
    private ImageView student3island19;
    @FXML
    private ImageView student4island19;
    @FXML
    private ImageView student5island19;
    @FXML
    private ImageView student6island19;
    @FXML
    private ImageView student7island19;
    @FXML
    private ImageView student8island19;
    @FXML
    private ImageView student9island19;
    @FXML
    private ImageView student10island19;
    @FXML
    private ImageView student11island19;
    @FXML
    private ImageView student12island19;
    @FXML
    private ImageView student13island19;
    @FXML
    private ImageView student14island19;
    @FXML
    private ImageView student15island19;
    @FXML
    private ImageView student16island19;
    @FXML
    private ImageView student17island19;
    @FXML
    private ImageView student18island19;
    @FXML
    private ImageView student19island19;
    @FXML
    private ImageView student20island19;

    /**
     * student on island 20 ImageView reference
     */
    @FXML
    private ImageView student1island20;
    @FXML
    private ImageView student2island20;
    @FXML
    private ImageView student3island20;
    @FXML
    private ImageView student4island20;
    @FXML
    private ImageView student5island20;
    @FXML
    private ImageView student6island20;
    @FXML
    private ImageView student7island20;
    @FXML
    private ImageView student8island20;
    @FXML
    private ImageView student9island20;
    @FXML
    private ImageView student10island20;
    @FXML
    private ImageView student11island20;
    @FXML
    private ImageView student12island20;
    @FXML
    private ImageView student13island20;
    @FXML
    private ImageView student14island20;
    @FXML
    private ImageView student15island20;
    @FXML
    private ImageView student16island20;
    @FXML
    private ImageView student17island20;
    @FXML
    private ImageView student18island20;
    @FXML
    private ImageView student19island20;
    @FXML
    private ImageView student20island20;

    /**
     * student ingress ImageView reference
     */
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

    /**
     * student hall pink ImageView reference
     */
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

    /**
     * student hall red ImageView reference
     */
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

    /**
     * student hall red ImageView reference
     */
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

    /**
     * student hall yellow ImageView reference
     */
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

    /**
     * student hall pink ImageView reference
     */
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
     *  Island ImageView reference
     */
    @FXML
    private ImageView island1;
    @FXML
    private ImageView island2;
    @FXML
    private ImageView island3;
    @FXML
    private ImageView island4;
    @FXML
    private ImageView island5;
    @FXML
    private ImageView island6;
    @FXML
    private ImageView island7;
    @FXML
    private ImageView island8;
    @FXML
    private ImageView island9;
    @FXML
    private ImageView island10;
    @FXML
    private ImageView island11;
    @FXML
    private ImageView island12;

    /**
     * Third cloud ImageView reference
     */
    @FXML
    private ImageView cloud3;

    /**
     * Student on cloud one ImageView reference
     */
    @FXML
    private ImageView student1Cloud1;
    @FXML
    private ImageView student2Cloud1;
    @FXML
    private ImageView student3Cloud1;
    @FXML
    private ImageView student4Cloud1;

    /**
     * Student on cloud two ImageView reference
     */
    @FXML
    private ImageView student1Cloud2;
    @FXML
    private ImageView student2Cloud2;
    @FXML
    private ImageView student3Cloud2;
    @FXML
    private ImageView student4Cloud2;

    /**
     * Student on cloud one ImageView reference
     */
    @FXML
    private ImageView student1Cloud3;
    @FXML
    private ImageView student2Cloud3;
    @FXML
    private ImageView student3Cloud3;
    @FXML
    private ImageView student4Cloud3;

    /**
     * expert card Button reference
     */
    @FXML
    private Button expertCardButton;

    /**
     * communication Text reference
     */
    @FXML
    private Text communication;

    /**
     * finish expert move Button reference
     */
    @FXML
    private Button finishExpertMove;

    /**
     * mother nature ImageView reference
     */
    @FXML
    private ImageView motherNature1;
    @FXML
    private ImageView motherNature2;
    @FXML
    private ImageView motherNature3;
    @FXML
    private ImageView motherNature4;
    @FXML
    private ImageView motherNature5;
    @FXML
    private ImageView motherNature6;
    @FXML
    private ImageView motherNature7;
    @FXML
    private ImageView motherNature8;
    @FXML
    private ImageView motherNature9;
    @FXML
    private ImageView motherNature10;
    @FXML
    private ImageView motherNature11;
    @FXML
    private ImageView motherNature12;

    /**
     *
     */
    private Student studentOnRound;

    /**
     *
     */
    private LinkedList<ImageView> studentOnCloud=new LinkedList<>();

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
     * Stores the ImageView the professor of each color
     */
    private Map<Color, ImageView> professors = new HashMap<>();

    /**
     * Stores the list of ImageView for the islands
     */
    private LinkedList<ImageView> islands = new LinkedList<ImageView>();

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

        GuiPianificationPhaseController pianificationController = fxmlLoader.getController();
        pianificationController.resize(stage, scene);
    }

    /**
     * @param student whose image is returned
     * @return a new Image object of the student
     */
    public Image getImageStudent(Student student) {
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
     * @param color of professor whose image is returned
     * @return a new Image object of professor
     */
    public Image getImageProfessor(Color color){
        switch (color) {
            case RED -> {
                return new Image(redProfessorPath);
            }
            case GREEN -> {
                return new Image(greenProfessorPath);
            }
            case BLUE -> {
                return new Image(blueProfessorPath);
            }
            case PINK -> {
                return new Image(pinkProfessorPath);
            }
            case YELLOW -> {
                return new Image(yellowProfessorPath);
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


        game = ControllerHandler.getInstance().getClient().getGame();
        ControllerHandler.getInstance().setCardPlayed(false);

        if (game.getGameMode()==false || game.getCardManager().getCurrentCard()!=null && ControllerHandler.getInstance().getFinishTurn()) {
            expertCardButton.setVisible(false);
        }
        if (game.getCurrentRound().getId()==null) {
          finishExpertMove.setVisible(false);
          finishExpertMove.setDisable(false);
        }

        // show elements on the screen

        showMotherNature();;
        showStudentsHall();
        showStudentsIngress();
        showClouds();
        showText();
        showProfessors();

    }

    /**
     * shows the professors on the screen
     */
    public void showProfessors(){

        professors.put(Color.GREEN,professorGreen);
        professors.put(Color.RED,professorRed);
        professors.put(Color.YELLOW,professorYellow);
        professors.put(Color.PINK,professorPink);
        professors.put(Color.BLUE,professorBlue);

        for(Color color : Color.values()){
            if(game.getCurrentPlayer().getSchool().getHall().getLine(color).isProfessor()){
                professors.get(color).setImage(getImageProfessor(color));
            }
        }
    }

    /**
     * shows the communication text on the screen
     */
    private void showText(){

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

        if(ControllerHandler.getInstance().getIdExpertCardPlayed()!=null){
            if(ControllerHandler.getInstance().getIdExpertCardPlayed().equals("40") ||ControllerHandler.getInstance().getIdExpertCardPlayed().equals("42") ){
                communication.setText("You selected a card that needs an island as parameter, pick an island");
            }
        }

    }

    /**
     * shows the cloud on the screen
     */
    private void showClouds(){
        if (!game.getClouds().get(0).getStudents().isEmpty()) {
            student1Cloud1.setImage(getImageStudent(game.getClouds().get(0).getStudents().get(0)));
            student2Cloud1.setImage(getImageStudent(game.getClouds().get(0).getStudents().get(1)));
            student3Cloud1.setImage(getImageStudent(game.getClouds().get(0).getStudents().get(2)));
            if (game.getPlayerList().size()==3) {
                student4Cloud1.setImage(getImageStudent(game.getClouds().get(0).getStudents().get(3)));
            }
        }
        if (!game.getClouds().get(1).getStudents().isEmpty()) {
            student1Cloud2.setImage(getImageStudent(game.getClouds().get(1).getStudents().get(0)));
            student2Cloud2.setImage(getImageStudent(game.getClouds().get(1).getStudents().get(1)));
            student3Cloud2.setImage(getImageStudent(game.getClouds().get(1).getStudents().get(2)));
            if (game.getPlayerList().size()==3) {
                student4Cloud2.setImage(getImageStudent(game.getClouds().get(1).getStudents().get(3)));
            }
        }
        if (game.getPlayerList().size()==3) {
            if (!game.getClouds().get(2).getStudents().isEmpty()) {
                student1Cloud3.setImage(getImageStudent(game.getClouds().get(2).getStudents().get(0)));
                student2Cloud3.setImage(getImageStudent(game.getClouds().get(2).getStudents().get(1)));
                student3Cloud3.setImage(getImageStudent(game.getClouds().get(2).getStudents().get(2)));
                student4Cloud3.setImage(getImageStudent(game.getClouds().get(2).getStudents().get(3)));
            }
        } else {
            cloud3.setImage(null);
        }

    }

    /**
     * shows mother nature on the screen
     */
    private void showMotherNature(){
        MotherNature motherNature = game.getMotherNature();
        switch (motherNature.getIsland().getId()) {
            case "26":
                motherNature1.setImage(new Image(motherNaturePath));
                idIsland = 26;
                break;
            case "27":
                motherNature2.setImage(new Image(motherNaturePath));
                idIsland = 27;
                break;
            case "28":
                motherNature3.setImage(new Image(motherNaturePath));
                idIsland = 28;
                break;
            case "29":
                motherNature4.setImage(new Image(motherNaturePath));
                idIsland = 29;
                break;
            case "30":
                motherNature5.setImage(new Image(motherNaturePath));
                idIsland=30;
                break;
            case "31":
                motherNature6.setImage(new Image(motherNaturePath));
                idIsland = 31;
                break;
            case "32":
                motherNature7.setImage(new Image(motherNaturePath));
                idIsland = 32;
                break;
            case "33":
                motherNature8.setImage(new Image(motherNaturePath));
                idIsland = 33;
                break;
            case "34":
                motherNature9.setImage(new Image(motherNaturePath));
                idIsland = 34;
                break;
            case "35":
                motherNature10.setImage(new Image(motherNaturePath));
                idIsland = 35;
                break;
            case "36":
                motherNature11.setImage(new Image(motherNaturePath));
                idIsland = 36;
                break;
            case "37":
                motherNature12.setImage(new Image(motherNaturePath));
                idIsland = 37;
                break;
        }
    }

    /**
     * shows the students in the ingress
     */
    private void showStudentsIngress(){

        studentsIngress.add(studentIngress1);
        studentsIngress.add(studentIngress2);
        studentsIngress.add(studentIngress3);
        studentsIngress.add(studentIngress4);
        studentsIngress.add(studentIngress5);
        studentsIngress.add(studentIngress6);
        studentsIngress.add(studentIngress7);
        studentsIngress.add(studentIngress8);
        studentsIngress.add(studentIngress9);

        for (int i = 0; i < game.getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++) {
            switch (game.getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor()) {
                case RED -> {
                    studentsIngress.get(i).setImage(new Image(redStudentPath));
                }
                case GREEN -> {
                    studentsIngress.get(i).setImage(new Image(greenStudentPath));
                }
                case BLUE -> {
                    studentsIngress.get(i).setImage(new Image(blueStudentPath));
                }
                case PINK -> {
                    studentsIngress.get(i).setImage(new Image(pinkStudentPath));
                }
                case YELLOW -> {
                    studentsIngress.get(i).setImage(new Image(yellowStudentPath));
                }
            }
        }
    }

    /**
     * shows the students in the hall
     */
    private void showStudentsHall(){

        // populating the hallLists

        hallLists.put(Color.YELLOW, studentsHallYellow);
        hallLists.put(Color.BLUE, studentsHallBlue);
        hallLists.put(Color.GREEN, studentsHallGreen);
        hallLists.put(Color.RED, studentsHallRed);
        hallLists.put(Color.PINK, studentsHallPink);

        // populating the ImageView lists

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

        // show students in hall

        for (Color color : Color.values()) {
            for (int i = 0; i < game.getCurrentPlayer().getSchool().getHall().getLine(color).getStudents().size(); i++) {
                switch (color) {
                    case RED -> {
                        hallLists.get(color).get(i).setImage(new Image(redStudentPath));
                    }
                    case GREEN -> {
                        hallLists.get(color).get(i).setImage(new Image(greenStudentPath));
                    }
                    case BLUE -> {
                        hallLists.get(color).get(i).setImage(new Image(blueStudentPath));
                    }
                    case PINK -> {
                        hallLists.get(color).get(i).setImage(new Image(pinkStudentPath));
                    }
                    case YELLOW -> {
                        hallLists.get(color).get(i).setImage(new Image(yellowStudentPath));
                    }
                }
            }
        }
    }

    /**
     *
     * @return jumps The number of jumps that motherNature should do
     */
    public Integer calculateJumps(Integer idIslandTarget,Integer idIslandMotherNature ){
        Integer jumps = 0;
       while (idIslandTarget!=idIslandMotherNature){
           idIslandMotherNature++;
           if(idIslandMotherNature==37) {
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
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()<=calculateJumps(26,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(26, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("26");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("26");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else if (game.getCurrentRound().getId()==3) {
           StudentToIsland messageMethod=ControllerHandler.getInstance().getStudentToIsland();
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
            ((MovingMotherNature)movingMotherNature).setJumps(calculateJumps(27, idIsland));
            ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("27");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("27");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else if (game.getCurrentRound().getId()==3) {
             StudentToIsland messageMethod=ControllerHandler.getInstance().getStudentToIsland();
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
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("28");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("28");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else if (game.getCurrentRound().getId()==3) {
           StudentToIsland messageMethod=ControllerHandler.getInstance().getStudentToIsland();
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
           if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(29,idIsland) ) {
               MessageMethod movingMotherNature = new MovingMotherNature();
               ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(29, idIsland));
               ControllerHandler.getInstance().write(movingMotherNature);
           } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
               MessageMethod messageMethod = new PlayExpertCard();
               switch (ControllerHandler.getInstance().getIdExpertCardPlayed()){
                   case"40":
                       ((PlayExpertCard)messageMethod).setExpertCard("40");
                       ((PlayExpertCard)messageMethod).setParameter("29");
                       break;
                   case"42":
                       ((PlayExpertCard)messageMethod).setExpertCard("42");
                       ((PlayExpertCard)messageMethod).setParameter("29");
                       break;
               }
               ControllerHandler.getInstance().setCardNeedIsland(false);
               ControllerHandler.getInstance().setIdExpertCardPlayed("");
               ControllerHandler.getInstance().write(messageMethod);
           }
        } else if (game.getCurrentRound().getId()==3 ) {
            StudentToIsland messageMethod=ControllerHandler.getInstance().getStudentToIsland();
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
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue() >= calculateJumps(30, idIsland) ) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(30, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()){
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("30");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("30");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
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
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(31,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(31, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("31");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("31");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
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
            if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(32,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(32, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("32");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("32");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
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
                MessageMethod movingMotherNature= new MovingMotherNature();
                ((MovingMotherNature)movingMotherNature).setJumps(calculateJumps(33,idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("33");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("33");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else if (game.getCurrentRound().getId()==3) {
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
             if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(34,idIsland)) {
                 MessageMethod movingMotherNature = new MovingMotherNature();
                 ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(34, idIsland));
                 ControllerHandler.getInstance().write(movingMotherNature);
             } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                 MessageMethod messageMethod = new PlayExpertCard();
                 switch (ControllerHandler.getInstance().getIdExpertCardPlayed()){
                     case"40":
                         ((PlayExpertCard)messageMethod).setExpertCard("40");
                         ((PlayExpertCard)messageMethod).setParameter("34");
                         break;
                     case"42":
                         ((PlayExpertCard)messageMethod).setExpertCard("42");
                         ((PlayExpertCard)messageMethod).setParameter("34");
                         break;
                 }
                 ControllerHandler.getInstance().setCardNeedIsland(false);
                 ControllerHandler.getInstance().setIdExpertCardPlayed("");
                 ControllerHandler.getInstance().write(messageMethod);
             }
        } else if(game.getCurrentRound().getId()==3) {
            StudentToIsland messageMethod=ControllerHandler.getInstance().getStudentToIsland();
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
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(35,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(35, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod = new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("35");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("35");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else if (game.getCurrentRound().getId()==3) {
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
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(36, idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(36, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod=new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()){
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("36");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("36");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
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
            if(game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE && game.getCurrentPlayer().getCardPlayed().getValue()>=calculateJumps(37,idIsland)) {
                MessageMethod movingMotherNature = new MovingMotherNature();
                ((MovingMotherNature) movingMotherNature).setJumps(calculateJumps(37, idIsland));
                ControllerHandler.getInstance().write(movingMotherNature);
            } else if (ControllerHandler.getInstance().getCardNeedIsland()) {
                MessageMethod messageMethod=new PlayExpertCard();
                switch (ControllerHandler.getInstance().getIdExpertCardPlayed()) {
                    case"40":
                        ((PlayExpertCard)messageMethod).setExpertCard("40");
                        ((PlayExpertCard)messageMethod).setParameter("37");
                        break;
                    case"42":
                        ((PlayExpertCard)messageMethod).setExpertCard("42");
                        ((PlayExpertCard)messageMethod).setParameter("37");
                        break;
                }
                ControllerHandler.getInstance().setCardNeedIsland(false);
                ControllerHandler.getInstance().setIdExpertCardPlayed("");
                ControllerHandler.getInstance().write(messageMethod);
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
        }else {
            if (studentMoving != null && !ControllerHandler.getInstance().getCardNeedIsland()) {
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
            if (studentMoving != null && !ControllerHandler.getInstance().getCardNeedIsland()) {
                switch (studentMoving) {
                    case RED -> {
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
    public void clickOnYellowLine(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()!=null) {
            if (game.getCurrentRound().getId()==0){
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
        } else {
            if (studentMoving != null && !ControllerHandler.getInstance().getCardNeedIsland()) {
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
            if(game.getCurrentRound().getId()==1 && !game.getCurrentPlayer().getSchool().getHall().getLine(Color.PINK).getStudents().isEmpty() && studentOnRound!=null) {
                MessageMethod messageMethod = new IngressHallSwap();
                ((IngressHallSwap) messageMethod).setStudentIngress(studentOnRound.getId());
                ((IngressHallSwap)messageMethod).setStudentHall(game.getCurrentPlayer().getSchool().getHall().getLine(Color.PINK).getStudents().getLast().getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        } else {
            if (studentMoving != null && !ControllerHandler.getInstance().getCardNeedIsland()) {
                switch (studentMoving) {
                    case PINK -> {
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
            if (studentMoving != null && !ControllerHandler.getInstance().getCardNeedIsland()) {
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
        if (game.getCurrentRound().getId()==null) {
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS && !ControllerHandler.getInstance().getCardNeedIsland()) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0).getColor();
            }
        } else if (game.getCurrentRound().getId()==1) {
            studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress2(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId()==null) {
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase() == PlayerPhase.MOVING_STUDENTS && !ControllerHandler.getInstance().getCardNeedIsland()) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1).getColor();
            }
        } else if (game.getCurrentRound().getId()==1) {
           studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1);
        } else if (game.getCurrentRound().getId()==2) {
            MessageMethod messageMethod = new StudentToHall();
            ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1).getId());
            ControllerHandler.getInstance().write(messageMethod);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress3(MouseEvent mouseEvent) {
        if (game.getCurrentRound().getId() == null && !ControllerHandler.getInstance().getCardNeedIsland()) {
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2).getColor();
            }
        } else if (game.getCurrentRound().getId()==1) {
            studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2);
        } else if (game.getCurrentRound().getId()==2) {
            MessageMethod messageMethod = new StudentToHall();
            ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2).getId());
            ControllerHandler.getInstance().write(messageMethod);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress4(MouseEvent mouseEvent) {
        if(game.getCurrentRound().getId()==null && !ControllerHandler.getInstance().getCardNeedIsland()) {
            //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3).getColor();
            }
        } else if (game.getCurrentRound().getId()==1) {
            studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3);
        } else if (game.getCurrentRound().getId()==2) {
            MessageMethod messageMethod = new StudentToHall();
            ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3).getId());
            ControllerHandler.getInstance().write(messageMethod);
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress5(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size()>4) {
            if (game.getCurrentRound().getId()==null) {
                //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
                if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS) {
                    ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4).getId());
                    studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4).getColor();
                }
            } else if (game.getCurrentRound().getId()==1 && !ControllerHandler.getInstance().getCardNeedIsland()) {
                studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4);
            } else if (game.getCurrentRound().getId()==2) {
                MessageMethod messageMethod = new StudentToHall();
                ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4).getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress6(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size()>5) {
            if (game.getCurrentRound().getId()==null) {
                //Da controllare se nella CLI viene fatto il controllo se ci sono studenti nella hall
                if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS && !ControllerHandler.getInstance().getCardNeedIsland()) {
                    ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                    studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getColor();
                }
            } else if (game.getCurrentRound().getId()==1) {
                studentOnRound=(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5));
            } else if (game.getCurrentRound().getId()==2) {
                MessageMethod messageMethod = new StudentToHall();
                ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress7(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size()>6) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS && game.getCurrentRound().getId() == null && !ControllerHandler.getInstance().getCardNeedIsland()) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(6).getColor();
            } else if (game.getCurrentRound().getId()==1 || game.getCurrentRound().getId()==1) {
                studentOnRound=game.getCurrentPlayer().getSchool().getIngress().getStudents().get(6);
            } else if (game.getCurrentRound().getId()==2) {
                MessageMethod messageMethod = new StudentToHall();
                ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(6).getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress8(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size()>7) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS && game.getCurrentRound().getId()==null && !ControllerHandler.getInstance().getCardNeedIsland()) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(7).getColor();
            } else if (game.getCurrentRound().getId() == 1 || game.getCurrentRound().getId()==1) {
                studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(7);
            } else if (game.getCurrentRound().getId()==2) {
                MessageMethod messageMethod = new StudentToHall();
                ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(7).getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        }
    }

    /**
     *
     * @param mouseEvent
     */
    public void clickOnIngress9(MouseEvent mouseEvent) {
        if (game.getCurrentPlayer().getSchool().getIngress().getStudents().size()>8) {
            if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS && game.getCurrentRound().getId() == null && !ControllerHandler.getInstance().getCardNeedIsland()) {
                ((MovingStudentsFromIngressToHall) studentOnHall).setStudent(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getId());
                studentMoving = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(8).getColor();
            } else if (game.getCurrentRound().getId() == 1 || game.getCurrentRound().getId() == 1 ) {
                studentOnRound = game.getCurrentPlayer().getSchool().getIngress().getStudents().get(8);
            } else if (game.getCurrentRound().getId()==2){
                MessageMethod messageMethod = new StudentToHall();
                ((StudentToHall)messageMethod).setStudentToHall(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(8).getId());
                ControllerHandler.getInstance().write(messageMethod);
            }
        }
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnCloud2(MouseEvent mouseEvent) throws IOException {
        if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD && !ControllerHandler.getInstance().getCardNeedIsland()) {
            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ((ChooseStudentsFromCloud)messageMethod).setCloud(game.getClouds().get(1).getId());
            ControllerHandler.getInstance().write(messageMethod);
            //refresh();
            showLoading();
        }
    }

    /**
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnCloud3(MouseEvent mouseEvent) throws IOException {
        if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD && game.getPlayerList().size()==3 && !ControllerHandler.getInstance().getCardNeedIsland()) {
            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ((ChooseStudentsFromCloud)messageMethod).setCloud(game.getClouds().get(2).getId());
            ControllerHandler.getInstance().write(messageMethod);
            // refresh();
            showLoading();
        }
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void clickOnCloud1(MouseEvent mouseEvent) throws IOException {
        if (game.getCurrentPlayer().getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD && !ControllerHandler.getInstance().getCardNeedIsland()) {
            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ((ChooseStudentsFromCloud)messageMethod).setCloud(game.getClouds().get(0).getId());
            ControllerHandler.getInstance().write(messageMethod);
            //refresh();
            showLoading();
        }
    }

    public void showLoading() throws IOException{
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

        loadingController.setWaitText();
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void clickPlayExpertCard(MouseEvent mouseEvent) throws IOException {
        if (game.getGameMode()==true && game.getCardManager().getCurrentCard()==null && !ControllerHandler.getInstance().getCardNeedIsland()) {
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
        if (game.getCardManager().getCurrentCard()!=null && !ControllerHandler.getInstance().getCardNeedIsland()) {
            ControllerHandler.getInstance().write(new RoundEnd());
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
}
