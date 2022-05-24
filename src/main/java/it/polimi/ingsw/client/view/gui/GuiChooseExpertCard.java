package it.polimi.ingsw.client.view.gui;

import it.polimi.ingsw.client.Client;

import java.util.HashMap;
import java.util.Map;

public class GuiChooseExpertCard {

    /**
     * Map to match expert card with his path
     */
    private static HashMap<String, String> pathMap = new HashMap<>();

    /**
     * Default constructor
     */
    public GuiChooseExpertCard() {
        pathMap.put("39", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front1.jpg");
        pathMap.put("40", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front2.jpg");
        pathMap.put("41", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front3.jpg");
        pathMap.put("42", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front4.jpg");
        pathMap.put("43", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front5.jpg");
        pathMap.put("44", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front6.jpg");
        pathMap.put("47", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front7.jpg");
        pathMap.put("46", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front8.jpg");
        pathMap.put("47", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front9.jpg");
        pathMap.put("48", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front10.jpg");
        pathMap.put("49", "src/main/resources/Graphical_Assets/Personaggi/CarteTOT_front11.jpg");
    }

    /**
     * @param id expert card id
     * @return path of card graphical asset
     */
    public String getPath(String id) {
        return pathMap.get(id);
    }
}
