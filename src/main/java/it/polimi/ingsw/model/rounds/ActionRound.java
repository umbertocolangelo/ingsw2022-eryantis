package it.polimi.ingsw.model.rounds;

import it.polimi.ingsw.model.Game;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.*;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.pawns.MotherNature;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.LinkedList;

/**
 * 
 */
public class ActionRound implements RoundInterface {

    /**
     * Every time is called he set the current player, the player phase e change the player getting from the orderedlist
     */
    public ActionRound(Game game, Integer maxStudents) {
        this.game=game;
        this.maxStudents=maxStudents;
        this.game.setCurrentPlayer(this.game.getOrderedPLayerList().getFirst());
        this.currentPlayer=this.game.getCurrentPlayer();
        this.currentPlayer.setPlayerPhase(PlayerPhase.MOVING_STUDENTS);
        this.game.getCardManager().setCurrentCard(null);

    }
    /**
     * Keep the track if we already played a card in this round
     */
    private Boolean cardAlreadyPlayed=false;

    /**
     *Keep the reference to the current player
     */
    private Player currentPlayer;

    /**
     *Keep track of the number of students moved
     */
    private Integer studentsMoved = 0;

    /**
     *
     */
    private Integer maxStudents;
    /**
     *
     */
    private MotherNature motherNature;

    /**
     * Keep the reference to mothernature
     */
    private Game game;

    /**
     *
     */
     public LinkedList<Cloud> clouds= new LinkedList<>();
    /**
     *
     */
    private void checkWinner() {
        // TODO implement here
    }

    /**
     *
     * @return boolean  Check if the round ended end if we all the player played so create pianification
     */
    @Override
    public Boolean checkRoundEnded() {
        if(this.game.getOrderedPLayerList().isEmpty()) {
            /**
             *Resetto le clouds, noin sono sicuro del due o 3 giocatori
             */
            for(int i = 0; i< game.getPlayerList().size(); i++) {
                Cloud cloud=new Cloud();
                this.clouds.add(cloud);
                for(int j=0;(maxStudents==4 && j<4) || (maxStudents==3 && j<3);j++)
                    this.clouds.get(i).addStudent(this.game.getBag().newStudent());
            }
            game.setCloud(clouds);
            this.game.setRound(this.game.setPianificationnRoundState());
                return true;
        }
        if(this.currentPlayer.getPlayerPhase()==PlayerPhase.CHOOSING_CLOUD){
            LinkedList<Player> players=this.game.getOrderedPLayerList();
        players.removeFirst();
        this.game.setOrderedPLayerList(players);
            this.game.setRound(game.setActionRoundState(maxStudents));

        return true;
        }
        return false;
    }

    /**
     * @param student   The student present in the hall that we want to move
     * @return boolean          True if the student is moved correctly, false if it's not possible to move
     */
    public Boolean moveStudentIngressToHall(Student student) {
        if(this.currentPlayer.getPlayerPhase() != PlayerPhase.MOVING_STUDENTS || !this.currentPlayer.getSchool().getIngress().getStudents().contains(student))
        return false;
        this.studentsMoved++;
        if(this.studentsMoved==maxStudents) {
            currentPlayer.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
            return true;
        }

        return true;
    }

    /**
     * @param student       Student in the ingress
     * @param island        Island we want to put the student
     * @return              True if its not his last move
     */
    public Boolean moveStudentIngressToIsland(Student student, Island island) {
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.MOVING_STUDENTS || !this.currentPlayer.getSchool().getIngress().getStudents().contains(student))
            return false;
        this.studentsMoved++;
        if(this.studentsMoved==maxStudents) {
            currentPlayer.setPlayerPhase(PlayerPhase.MOVING_MOTHERNATURE);
            return true;
        }

        return true;
    }

    /**
     * @param jumps
     * @return
     */
    public Boolean moveMotherNature(Integer jumps) {
       if(currentPlayer.getPlayerPhase()!=PlayerPhase.MOVING_MOTHERNATURE || currentPlayer.getCardPlayedValue()<jumps)
        return false;
       else{
           return true;
       }
    }

    /**
     * @param assistantCard
     * @return
     */
    public Boolean playAssistantCard(AssistantCard assistantCard, Player player) {
        return null;
    }

    /**
     *
     * @param expertCard        We receive the expertCard and called the method needed for each expertCard
     * @return
     */
    public Boolean playExpertCard(ExpertCard expertCard,String string) {
        if(expertCard.getCost()>currentPlayer.getCoins() || cardAlreadyPlayed) //Non si possono giocare più di una carta per round
            return false;
        cardAlreadyPlayed=true; //Setto che ho giocato una carta
        game.getCardManager().setCurrentCard(expertCard);
        this.currentPlayer.setCoin(-(expertCard.getCost()));
        if(expertCard.getId().equals("38")){
            StudentToIslandCard expertCard1=(StudentToIslandCard) game.getCardManager().getCurrentCard();
            expertCard1.apply();
            game.setPreviousRound(this);
            game.setRound(this.game.setStudentToIslandState());
            return true;
        }
        if (expertCard.getId().equals("39"))
        {
            ProfessorControlCard expertCard1= (ProfessorControlCard) game.getCardManager().getCurrentCard();
            expertCard1.apply();
            return true;
        }
        if(expertCard.getId().equals("40"))
        {   Island island=new Island(); //lo chiediamo a id manager
            IslandInfluenceCard islandInfluenceCard=(IslandInfluenceCard) game.getCardManager().getCurrentCard();
             islandInfluenceCard.apply(island);
        }
        if(expertCard.getId().equals("41"))
        {
            TwoJumpCard expertCard1= (TwoJumpCard) game.getCardManager().getCurrentCard();
            expertCard1.apply();
            currentPlayer.twoMoreJumps();
        }
        if(expertCard.getId().equals("42")){
            TwoJumpCard twoJumpCard=(TwoJumpCard) game.getCardManager().getCurrentCard();
            twoJumpCard.apply();
        }

        if(expertCard.getId().equals("43"))
        {
            TowerInfluenceCard expertCard1= (TowerInfluenceCard) game.getCardManager().getCurrentCard();
            expertCard1.apply();
            return true;
        }
       if(expertCard.getId().equals("44")) {
          IngressCardSwapCard expertCard1=(IngressCardSwapCard) game.getCardManager().getCurrentCard();
           expertCard1.apply();
           this.game.setPreviousRound(this);
           this.game.setRound(this.game.setIngressCardSwapActionRound());
           return true;
       }
       if(expertCard.getId().equals("45")){
           Player player=new Player("Bo");
           TwoInfluenceCard twoInfluenceCard=new TwoInfluenceCard(game.getCardManager());
           twoInfluenceCard.apply(player);
       }
       if(expertCard.getId().equals("46")){
           Color color= Color.YELLOW;
           ColorInfluenceCard colorInfluenceCard= (ColorInfluenceCard) game.getCardManager().getCurrentCard();
           colorInfluenceCard.apply(color);

       }

     if(expertCard.getId().equals("47")){
        IngressHallSwapCard expertCard1=(IngressHallSwapCard) game.getCardManager().getCurrentCard();
         expertCard1.apply();
         game.setPreviousRound(this);
         game.setRound(game.setIngressHallSwapState());
         return true;
     }
        if(expertCard.getId().equals("48")){
            StudentToHallCard expertCard1=(StudentToHallCard) game.getCardManager().getCurrentCard();
            expertCard1.apply();
            game.setPreviousRound(this);
            game.setRound(game.setStudentToHallState());
            return true;
        }
        if(expertCard.getId().equals("49")){
            Color color =Color.RED;
            HallBagSwapCard expertCard1=(HallBagSwapCard) game.getCardManager().getCurrentCard();
            expertCard1.apply();
            this.expertMoveStudentToBag(game,color);
            return true;
        }
        //game.getCardManager().setCurrentCard(null);
        return false;
    }


    /**
     *
     * @param game
     * @param color         The reference to the color
     */
      private void expertMoveStudentToBag(Game game, Color color) {
        LinkedList <Player> players= this.game.getOrderedPLayerList();
        for(Player player : players){
            LinkedList<Student> students=player.getSchool().getHall().getLine(color).getStudents();
            for (int i=0 ; i<3 || students.isEmpty();i++){
                player.getSchool().getHall().getLine(color).removeStudent(students.removeLast());
            }
        }
        this.game.getCardManager().setCurrentCard(null);
    }

    @Override
    public Boolean chooseColorAndDeck(Player player, PlayerColor color, Wizard wizard) {
        return null;
    }


    /**
     * @param student
     * @param island
     * @return
     */
    public Boolean expertStudentToIsland(Student student, Island island) {
        // TODO implement here
        return null;
    }

    /**
     * @param studentCard
     * @param Ingress
     * @return
     */
    public Boolean expertIngressCardSwap(Student studentCard, Student Ingress) {
        return false;
    }

    /**
     *
     * @return
     */

    public Boolean finishExpertMove() {
        return null;
    }

    /**
     * @param studentHall
     * @param studentIngress
     * @return
     */
    public Boolean expertIngressHallSwap(Student studentHall, Student studentIngress) {
     return false;
    }



    /**
     * @param student
     * @return
     */
    public Boolean expertStudentToHall(Student student) {
       return false;
    }

    /**
     * @param cloud     The cloud chose from the
     * @return          True uf we can make the move
     */
    public Boolean chooseCloud(Cloud cloud) {
        if (this.currentPlayer.getPlayerPhase() != PlayerPhase.CHOOSING_CLOUD)
            return false;
        if (cloud.getStudents().size() == 0)
            return false;
        return true;

    }


    /**
     *Return the number of the students moved
     */
    public Integer getStudentsMoved(){
        return this.studentsMoved;
    }
}