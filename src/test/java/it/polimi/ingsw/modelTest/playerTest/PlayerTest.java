package it.polimi.ingsw.modelTest.playerTest;

import it.polimi.ingsw.model.enumerations.AssistantCard;
import it.polimi.ingsw.model.enumerations.PlayerColor;
import it.polimi.ingsw.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test of Player class
 */
public class PlayerTest {

    /**
     * Test of getPlayerCards method
     */
    @Test
    public void getPlayerCardsTest() {
        Player player = new Player("vittorio");
        ArrayList<AssistantCard> assist = player.getPlayedCards();
        assertTrue(assist.get(0).name() == "ONE_CARD" && assist.get(9).name() == "TEN_CARD");
    }

    /**
     * Test of playAssistantCard method
     */
    @Test
    public void playAssistantCardTest() {
        Player player = new Player("vittorio");
        AssistantCard assist = AssistantCard.TWO_CARD;
        player.playAssistantCard(assist);
        AssistantCard assist1 = AssistantCard.NINE_CARD;
        player.playAssistantCard(assist1);
        AssistantCard assist2 = AssistantCard.FIVE_CARD;
        player.playAssistantCard(assist2);
        assertTrue(player.getPlayedCards().size() == 7);
    }

    /**
     * Test of playAssistantCardValue method
     */
    @Test
    public void getPlayedCardValue() {
        Player player = new Player("vittorio");
        AssistantCard assist = AssistantCard.TWO_CARD;
        player.playAssistantCard(assist);
        assertTrue(player.getCardPlayedValue() == assist.getValue());
    }

    /**
     * Test of playAssistantCard method
     */
    @Test
    public void getPlayedValue() {
        Player player = new Player("vittorio");
        AssistantCard assist = AssistantCard.TWO_CARD;
        player.playAssistantCard(assist);
        assertTrue(player.getCardPlayed() == assist);
    }

    /**
     * Test of getName method
     */
    @Test
    public void getNameTest() {
        Player player = new Player("vittorio");
        assertTrue(player.getName().equals("vittorio"));
    }

    /**
     * Test of getWizard method
     */
    @Test
    public void getWizardTest() {
        Player player = new Player("vittorio");
        assertTrue(player.getWizard() == null);
    }

    /**
     * Test of geSchool method
     */
    @Test
    public void getSchoolTest() {
        Player player = new Player("vittorio");
        Player player1 = new Player("vittorio");
        player.setPlayerColor(PlayerColor.WHITE);
        assertTrue(player.getSchool() != player1.getSchool());
    }

    /**
     * Test of geCoins method
     */
    @Test
    public void getCoinsTest() {
        Player player = new Player("vittorio");
        player.setCoin(1);
        assertTrue(player.getCoins() == 1);
    }

    /**
     * Test of setPlayerColor method
     */
    @Test
    public void setPlayerColorTest() {
        Player player = new Player("vittorio");
        player.setPlayerColor(PlayerColor.WHITE);
        assertTrue(player.getPlayerColor() == PlayerColor.WHITE);
        assertTrue(player.getSchool() != null);
    }

    /**
     * Test of getPlayerColor method
     */
    @Test
    public void getPlayerColorTest() {
        Player player = new Player("vittorio");
        player.setPlayerColor(PlayerColor.WHITE);
        assertTrue(player.getPlayerColor() == PlayerColor.WHITE);
    }

    /**
     * Test of isDeckEnded method
     */
    @Test
    public void isDeckEndedTest() {
        Player player = new Player("vittorio");
        AssistantCard assist = AssistantCard.TWO_CARD;
        player.playAssistantCard(assist);
        AssistantCard assist1 = AssistantCard.ONE_CARD;
        player.playAssistantCard(assist1);
        AssistantCard assist2 = AssistantCard.THREE_CARD;
        player.playAssistantCard(assist2);
        AssistantCard assist3 = AssistantCard.FOUR_CARD;
        player.playAssistantCard(assist3);
        AssistantCard assist4 = AssistantCard.FIVE_CARD;
        player.playAssistantCard(assist4);
        AssistantCard assist5 = AssistantCard.SIX_CARD;
        player.playAssistantCard(assist5);
        AssistantCard assist6 = AssistantCard.SEVEN_CARD;
        player.playAssistantCard(assist6);
        AssistantCard assist7 = AssistantCard.EIGHT_CARD;
        player.playAssistantCard(assist7);
        AssistantCard assist8 = AssistantCard.NINE_CARD;
        player.playAssistantCard(assist8);
        AssistantCard assist9 = AssistantCard.TEN_CARD;
        player.playAssistantCard(assist9);
        assertTrue(player.isDeckEnded());

    }

    /**
     * Test of addCoin method
     */
    @Test
    public void addCoinsTest() {
        Player player = new Player("vittorio");
        player.setCoin(1);
        assertTrue(player.getCoins() == 1);

    }
}