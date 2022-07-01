package it.polimi.ingsw.modelTest.enumerationsTest;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of AssistantCard class
 */
public class AssistantCardTest {

    /**
     * test of getValue method
     */
    @Test
    public void getValueTest(){
        assertTrue(AssistantCard.ONE_CARD.getValue()==1);
        assertTrue(AssistantCard.TWO_CARD.getValue()==1);
        assertTrue(AssistantCard.THREE_CARD.getValue()==2);
        assertTrue(AssistantCard.FOUR_CARD.getValue()==2);
        assertTrue(AssistantCard.FIVE_CARD.getValue()==3);
        assertTrue(AssistantCard.SIX_CARD.getValue()==3);
        assertTrue(AssistantCard.SEVEN_CARD.getValue()==4);
        assertTrue(AssistantCard.EIGHT_CARD.getValue()==4);
        assertTrue(AssistantCard.NINE_CARD.getValue()==5);
        assertTrue(AssistantCard.TEN_CARD.getValue()==5);
    }
}
