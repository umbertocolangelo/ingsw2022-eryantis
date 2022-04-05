package it.polimi.ingsw.enumerationsTest;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssistantCardTest {

    @Test
    public void getValueTest(){
        assertTrue(AssistantCard.ONE_CARD.getValue()==1);
    }
}
