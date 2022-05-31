package it.polimi.ingsw.client.view.gui.controllers;

import it.polimi.ingsw.model.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiActionPhaseController implements Initializable {

    /**
     *
     */
    @FXML
    private AnchorPane scenePane;

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


        /**
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(0).getColor()== Color.RED){
            studentIngress2.setImage(new Image("/home/vittorio/IdeaProjects/ingsw2022-AM29/src/main/java/it/polimi/ingsw/client/view/gui/images/cerchi.png"));
                }
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(1).getColor()== Color.RED){
            studentIngress3.setImage(new Image("/home/vittorio/IdeaProjects/ingsw2022-AM29/src/main/java/it/polimi/ingsw/client/view/gui/images/cerchi.png"));
            }
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(2).getColor()== Color.RED){
            studentIngress4.setImage(new Image("/home/vittorio/IdeaProjects/ingsw2022-AM29/src/main/java/it/polimi/ingsw/client/view/gui/images/cerchi.png"));
        }
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(3).getColor()== Color.RED){
            studentIngress5.setImage(new Image("/home/vittorio/IdeaProjects/ingsw2022-AM29/src/main/java/it/polimi/ingsw/client/view/gui/images/cerchi.png"));
        }
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(4).getColor()== Color.RED){
            studentIngress6.setImage(new Image("/home/vittorio/IdeaProjects/ingsw2022-AM29/src/main/java/it/polimi/ingsw/client/view/gui/images/cerchi.png"));
        }
        if(game.getCurrentPlayer().getSchool().getIngress().getStudents().get(5).getColor()== Color.RED){
            studentIngress7.setImage(new Image("/home/vittorio/IdeaProjects/ingsw2022-AM29/src/main/java/it/polimi/ingsw/client/view/gui/images/cerchi.png"));
        }
         */
    }


}
