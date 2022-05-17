    module it.polimi.ingsw.client.view.gui {
        requires javafx.controls;
        requires javafx.fxml;

        requires org.controlsfx.controls;
        requires java.desktop;

        opens it.polimi.ingsw.client.view.gui to javafx.fxml;
        exports it.polimi.ingsw.client.view.gui;
            exports it.polimi.ingsw;
            opens it.polimi.ingsw to javafx.fxml;
    }