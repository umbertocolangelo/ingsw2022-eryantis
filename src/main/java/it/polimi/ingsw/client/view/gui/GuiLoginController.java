package it.polimi.ingsw.client.view.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class GuiLoginController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() { welcomeText.setText("ERIANTYS");}

}
