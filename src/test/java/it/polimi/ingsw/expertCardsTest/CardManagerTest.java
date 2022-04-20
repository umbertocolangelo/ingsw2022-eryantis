package it.polimi.ingsw.expertCardsTest;

import it.polimi.ingsw.model.calculations.professor.ProfessorManager;
import it.polimi.ingsw.model.expertCards.CardManager;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Bag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardManagerTest {
        /**
         * Test the getMotherNature method
         */

        @Test
        public void getMotherNatureTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            assertTrue(cardManager.getMotherNature() == motherNature);
        }

        /**
         * Test setUpCards method
         */

        @Test
        public void getCardsTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            cardManager.getCardsTest();
            assertTrue(cardManager.getThreeExpertCards().size() == 3);

        }

        /**
         * Test setCurrentCard method
         */

        @Test
        public void setCurrentCardTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            cardManager.getCardsTest();
            ExpertCard expertCard = cardManager.getThreeExpertCards().get(0);
            cardManager.setCurrentCard(expertCard);
            assertTrue(cardManager.getCurrentCard() == expertCard);

        }

        /**
         * Test getCurrentCard method
         */

        @Test
        public void getCurrentCardTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            cardManager.getCardsTest();
            ExpertCard expertCard = cardManager.getThreeExpertCards().get(0);
            cardManager.setCurrentCard(expertCard);
            assertTrue(cardManager.getCurrentCard() == expertCard);

        }

        /**
         * Test the gePlayerList method
         */

        @Test
        public void getPlayerListTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            assertTrue(cardManager.getPlayerList().get(0).getName() == "vittorio");
        }

        /**
         * Test the getBag method
         */

        @Test
        public void getBagTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            assertTrue(cardManager.getBag() == bag);
        }


        /**
         * Test getThreeExpertCards method
         */

        @Test
        public void getThreeExpertCardTest() {
            MotherNature motherNature = new MotherNature();
            ArrayList<Player> player = new ArrayList<Player>();
            player.add(new Player("vittorio"));
            Bag bag = new Bag();
            CardManager cardManager = new CardManager(motherNature, player, bag);
            cardManager.getCardsTest();
            assertTrue(cardManager.getThreeExpertCards().size() == 3);
        }
}

