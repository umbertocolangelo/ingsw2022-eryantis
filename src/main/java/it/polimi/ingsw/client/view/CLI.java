package it.polimi.ingsw.client.view;

import it.polimi.ingsw.client.CLIController;
import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.enumerations.*;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToIslandCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.pawns.Student;
import it.polimi.ingsw.model.pawns.Tower;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.SetUpRound;
import it.polimi.ingsw.model.studentSuppliers.Cloud;

import java.util.Scanner;

public class CLI {

    /**
     * Keep the reference to the Client
     */
    private Client client;

    /**
     * Keep the reference to the CLIController
     */
    private CLIController CLIController;

    /**
     * The input we get from the keyboard
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     *Is where we store the input from keyboard
     */
    private String input;

    /**
     * Default constructor
     * @param client        Keep the reference to the client
     * @param CLIController    Keep the reference to the CLIController
     */
    public CLI(Client client, CLIController CLIController){
        this.client = client;
        this.CLIController = CLIController;
    }

    /**
     * Get the thread witch will run the chooseColorAndDeck method
     * @return thread
     */
    public Thread chooseColorAndDeck() {

        Thread t = new Thread(() -> {
            Integer index=0;
            System.out.println("Before starting, choose your deck and your wizard!");
            for (Wizard wizard: ((SetUpRound) client.getGame().getCurrentRound()).getWizards()) {
                System.out.println(wizard.getColor() + "  Wizard " +index);
                index++;
            }
            System.out.println("Select a color from 0 to the number of wizard(s) available");
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>((SetUpRound) client.getGame().getCurrentRound()).getWizards().size()-1)
            {
                System.out.println("You entered a wrong or too high value, please try again.");
                input = scanner.nextLine();
            }
                System.out.println("Wizard selected " + ((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)) + "\n");
            MessageMethod messageMethod = new ChooseColorAndDeck();
            ((ChooseColorAndDeck) messageMethod).setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)).getId());
            System.out.println("Pick the color\n");
            index=0;
            for(PlayerColor color : ((SetUpRound) client.getGame().getCurrentRound()).getplayerColor()) {
                System.out.println(color + "  PlayerColor " + index);
                index++;
            }
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().size()-1) {
                    System.out.println("You entered a wrong or too high value, please try again.");
                    input = scanner.nextLine();
            }
            System.out.println("Color selected " + ((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)) + "\n");
            ((ChooseColorAndDeck) messageMethod).setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)).getId());
            CLIController.write(messageMethod);
        });
        t.start();
        return t;

    }


    /**
     * If we lost the connection client
     * @return thread
     */
    public Thread connectionLost() {

        Thread t = new Thread(() -> {
            System.out.println("The server lost your connection");
        });
        t.start();
        return t;
    }

    /**
     * If we lost the connection from a client
     * @return thread
     */
    public Thread clientLost(String nameClientLost) {

        Thread t = new Thread(() -> {
            System.out.println("The player "+ nameClientLost + "has been disconnected");

        });
        t.start();
        return t;
    }

    /**
     * Get the thread to run the play assistantCArd action
     * @return thread
     */
    public Thread playerIsPlus() {

        Thread t = new Thread(() -> {
            System.out.println("The game has been created and you are not necessary");

        });
        t.start();
        return t;
    }

    /**
     * Get the thread to run the play assistantCArd action
     * @return thread
     */
    public Thread choosingAssistant() {

        Thread t = new Thread(() -> {
            Integer index = 0;
            for(Player player:client.getGame().getPlayerList()){
                if(!(player.getName().equals(client.getNamePlayer())) && player.getCardPlayed()!=null)
                    System.out.println("Player " + client.getNamePlayer() + " played the card " + player.getCardPlayed());
            }
            System.out.println("\nAll right! Now pick the assistant card to use in this turn.");

            for(AssistantCard assistantCard : (client.getGame().getCurrentPlayer()).getAssistantCard() ) {
                System.out.println("Insert " + index + " to play " + assistantCard.name() + " with value: " + assistantCard.getValue());
                index++;
            }
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getAssistantCard().size()-1) {
                System.out.println("You entered a wrong or too high value, please try again.");
                input = scanner.nextLine();
            }
            MessageMethod messageMethod = new ChoosingAssistant();
            ((ChoosingAssistant) messageMethod).setAssistantCard(client.getGame().getCurrentPlayer().getAssistantCard().get(Integer.parseInt(input)).getId());

            CLIController.write(messageMethod);
        });
        t.start();
        return t;
    }

    /**
     * Get the thread to run the movement of the students from school ingress
     * @return thread
     */
    public Thread movingStudentsFromIngress() {

        Thread t = new Thread(( ) -> {
            String input1;
            String input2;
            showIsland();
            System.out.println("\nIt's your turn, " + client.getGame().getCurrentPlayer().getName() + " here's you Hall:\n" );
            showSchool();
            System.out.println("Choose 3 students in your ingress and place each one or in the hall or on an island!");
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size()-1) {
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }
            System.out.println("Where do you want to move this student? 0 Hall 1 Island");
            input1 = scanner.nextLine();
            while (!(input1.equals("1") || input1.equals("0"))) {
                System.out.println("Ops! You entered a wrong value!\nWhere do you want to move this student? 0 Hall 1 Island");
                input1 = scanner.nextLine();
            }
            if (input1.equals("0")) {
                MessageMethod hallMessageMethod = new MovingStudentsFromIngressToHall();
                ((MovingStudentsFromIngressToHall) hallMessageMethod).setStudent(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(Integer.parseInt(input)).getId());
                CLIController.write(hallMessageMethod);
            }
            else if (input1.equals("1")) {
                System.out.println("On which island do you want to move the student to? Select the Group Number\n");
                showIsland();
                input1 = scanner.nextLine();
                while (input1 =="" || Integer.parseInt(input1)>client.getGame().getIslandManager().getIslands().size()-1) {
                    System.out.println("Ops! You entered a wrong or too high value, choose again!\nOn which island do you want to move the student to?");
                    input1 = scanner.nextLine();
                }
                MessageMethod islandMessageMethod = new MovingStudentFromIngressToIsland();
                ((MovingStudentFromIngressToIsland) islandMessageMethod).setStudent(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(Integer.parseInt(input)).getId());
                if ((client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).isGrouped())) {
                    System.out.println("On which island of this group do you want to move the student to?");
                    int ind1 = 0;
                    for (Island island: client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getIslandGroupElements()) {
                        if (island.getTowers().isEmpty()) {
                            System.out.println("Island " + island.getId() + "\nGroupNumber " + ind1 + "\nCurrent students: " + island.getStudents() + "\nNo tower\n");
                        }
                        System.out.println("Island " + island.getId() + "\nGroupNumber " + ind1 + "\nCurrent students: " + island.getStudents() + "\nTower " + island.getTowers().get(0).getId() + " color: " + island.getTowers().get(0).getColor() + "\n");
                        ind1++;
                    }
                    input2 = scanner.nextLine();
                    while (input2=="" || Integer.parseInt(input2)>client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getSize()-1) {
                        System.out.println("Ops! You entered a wrong or too high value, choose again!\nOn which island of this group do you want to move the student to?");
                        input2 = scanner.nextLine();
                    }
                    ((MovingStudentFromIngressToIsland) islandMessageMethod).setIsland(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getIslandGroupElements().get(Integer.parseInt(input2)).getId());
                }
                else {
                    ((MovingStudentFromIngressToIsland) islandMessageMethod).setIsland(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getIslandGroupElements().get(0).getId());
                }

                CLIController.write(islandMessageMethod);
            }
        });
        t.start();
        return t;
    }

    /**
     * Get the thread to move mother nature on the desired island
     * @return thread
     */
    public Thread movingMotherNature() {

        Thread t = new Thread(() -> {
            showSchool();
            System.out.println("\n");
            showIsland();
            System.out.println("\nNow you can move Mother Nature!\nHow many jumps do you want Mother Nature to do? (you have from 1 to " + client.getGame().getCurrentPlayer().getCardPlayedValue() + " jumps available)");
            input = scanner.nextLine();

            while (input.equals("") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getCardPlayedValue() || input.equals("0")) {
                System.out.println("Ops! You entered a wrong or too high value, choose again!\nHow many jumps do you want Mother Nature to do? (you have from 1 to " + client.getGame().getCurrentPlayer().getCardPlayedValue() + " jumps available)");
                input = scanner.nextLine();
            }

            MessageMethod messageMethod = new MovingMotherNature();
            ((MovingMotherNature) messageMethod).setJumps(Integer.parseInt(input));

            CLIController.write(messageMethod);
        });
        t.start();
        return t;
    }

    /**
     * Get the thread to choose the group of students you want among the available clouds
     * @return thread
     */
    public Thread choosingStudentsFromClouds() {

        Thread t = new Thread(() -> {
            int index = 0;
            for (Cloud cloud: client.getGame().getClouds()) {
                if (cloud.getStudents().size()==0) {
                    System.out.println(index + ": Cloud (Already selected)");
                } else {
                    System.out.println(index + ": Cloud");
                    for (Student student: cloud.getStudents()) {
                        System.out.print(student.getColor() + "    Student ");
                    }
                }
                System.out.println("\n");
                index++;
            }
            System.out.println("\n");
            System.out.println("Now you can choose the group of students you want among the available clouds!");
            input = scanner.nextLine();

            while (input=="" || Integer.parseInt(input)>client.getGame().getClouds().size()-1 || client.getGame().getClouds().get(Integer.parseInt(input)).getStudents().isEmpty()) {
                System.out.println("Ops! You entered a wrong or too high value or the cloud is empty, choose again!");
                input = scanner.nextLine();
            }

            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ((ChooseStudentsFromCloud) messageMethod).setCloud(client.getGame().getClouds().get(Integer.parseInt(input)).getId());

            CLIController.write(messageMethod);
        });
        t.start();
        return t;
    }

    /**
     *
     * @return
     */
    public Thread choosingExpertCardOrMoving() {

        Thread t = new Thread(() -> {
            if (client.getGame().getGameMode()) {
                if (client.getGame().getCardManager().getCurrentCard()!=null) {
                    System.out.println("You cannot play another ExpertCard in this turn because it has already been played an ExpertCard in this round\n");
                    goBack();
                } else {
                    System.out.println("If you want to play an Expert Card click 0 to visualize the three Expert card available, otherwise click 1");
                    input = scanner.nextLine();
                    while (!(input.equals("1") || input.equals("0"))) {
                        System.out.println("Ops! You entered a wrong value!");
                        input = scanner.nextLine();
                    }
                    if (input.equals("0")) {
                        System.out.println("You have " + client.getGame().getCurrentPlayer().getCoins() + " coins");
                        Thread g = playExpertCard();
                        try {
                            g.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        goBack();
                    }
                }
            } else {
                goBack();
            }
        });
        t.start();
        return t;
    }

    /**
     *
     * @return
     */
    public Thread playExpertCard() {

        Thread t = new Thread(() -> {
            Boolean tooPoor = true;
            Boolean playedCard = false;
            int i = 0;
            while(tooPoor) {
                for (ExpertCard expertCard : client.getGame().getCardManager().getDeck()) {
                    System.out.println("Expert Card " + i + " " + expertCard + " this card costs " + expertCard.getCost());
                    i++;
                }

                System.out.println("Those are the ExpertCards available, select one if you want to play it, if you changed your mind and want to move the student write 'exit': ");

                input = scanner.nextLine();
                while (!(input.equals("1") || input.equals("0") || (input.equals("2")) || input.equals("exit"))) {
                    System.out.println("Ops! You entered a wrong value!");
                    input = scanner.nextLine();
                }
                if (input.equals("exit")) {
                    tooPoor = false;
                    goBack();
                } else {
                    if (client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getCost()>client.getGame().getCurrentPlayer().getCoins()) {
                        System.out.println("This card costs too much, you can't afford it\n\n");
                    } else {
                        tooPoor = false;
                        System.out.println("Card selected: " + client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)));
                        MessageMethod messageMethod = new PlayExpertCard();
                        ((PlayExpertCard) messageMethod).setExpertCard(client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId());

                        if (client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("46") || client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("49")) {
                            System.out.println("This card needs a color to be selected, select the color\n");
                            System.out.println(Color.values());
                            System.out.println("\nYou must enter   YELLOW=0  BLUE=1  GREEN=2  RED=3  PINK=4");

                            input = scanner.nextLine();
                            while (!(input.equals("0") || input.equals("1") || (input.equals("2")) || input.equals("3") || input.equals("4"))) {
                                System.out.println("Ops! You entered a wrong value!");
                                input = scanner.nextLine();
                            }
                            ((PlayExpertCard) messageMethod).setParameter(Color.getColor(Integer.parseInt(input)).getId());
                            playedCard = true;
                        }

                        if (!playedCard && client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("42") ) {
                            System.out.println("This card needs a island to be selected where we put the deny token, select the island\n");
                            showIsland();
                            System.out.println("On which island do you want to move the student to?");
                            input = scanner.nextLine();
                            while (input =="" || Integer.parseInt(input)>client.getGame().getIslandManager().getIslands().size()-1) {
                                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                                input = scanner.nextLine();
                            }
                            ((PlayExpertCard) messageMethod).setParameter(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input)).getId());
                            playedCard = true;

                        }

                        if(!playedCard && client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("40")) {
                            //Da capire island interface nella carta prima era solo un island
                        }

                        if(!playedCard && client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("45")) {
                            System.out.println("This card need a player to select, select one\n");
                            int c = 0;
                            for (Player p : client.getGame().getPlayerList()) {
                                System.out.println("To select the player named " + p.getName() + " you need to write " + c + "\n");
                                c++;
                            }
                            input = scanner.nextLine();
                            while ((!(input.equals("0") || input.equals("1")) && client.getGame().getPlayerList().size() == 2) || (!((input.equals("0")) || input.equals("1") || input.equals("2")) && client.getGame().getPlayerList().size() == 3)) {
                                System.out.println("Ops! You entered a wrong value!");
                                input = scanner.nextLine();
                            }
                            ((PlayExpertCard)messageMethod).setParameter(client.getGame().getPlayerList().get(Integer.parseInt(input)).getId());
                        }

                        CLIController.write(messageMethod);
                    }
                }
            }
        });
        t.start();
        return t;
    }

    /**
     *
     * @return
     */
    public Thread ingressCardSwap() {
        Thread t = new Thread(() -> {
            System.out.println("You select the card that allow to swap the student present in the ingress with a student present in the car.\nIf you want to end the effect of this cart press 0, otherwise press 1\n");
            MessageMethod messageMethod;
            input = scanner.nextLine();
            while(!(input.equals("0") || input.equals("1"))){
                System.out.println("You entered a wrong value, insert again\nIf you want to end the effect of this cart press 0, otherwise press 1");
                input = scanner.nextLine();
            }
            if(input.equals("0")) {
                messageMethod = new RoundEnd();
            }
            else {
                messageMethod = new IngressCardSwap();
                System.out.println("Select the student from your Ingress: \n");
                showSchool();
                input = scanner.nextLine();
                while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size()-1) {
                    System.out.println("Ops! You entered a wrong or too high value, choose again!");
                    input = scanner.nextLine();
                }
                ((IngressCardSwap)messageMethod).setStudentIngress(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get( Integer.parseInt(input)).getId());
                System.out.println("Select a student from the Card: \n");
                for (int i=0; i<((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()-1; i++) {
                    System.out.println("Student " + ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(i).getColor() + " Number " + i + "\n");
                }
                input = scanner.nextLine();
                while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input) >( ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()-1)) {
                    System.out.println("Ops! You entered a wrong or too high value, choose again!");
                    input = scanner.nextLine();
                }
                ((IngressCardSwap)messageMethod).setStudentCard(((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get( Integer.parseInt(input)).getId());
            }
            CLIController.write(messageMethod);

        });
        t.start();
        return t;
    }

    /**
     *
     * @return
     */
    public Thread ingressHallSwap() {
        Thread t = new Thread(() -> {

            System.out.println("You select the card that allow to swap the student present in the ingress with a student present in the card , \nif you want to end the effect of this cart press 0 otherwise press 1\n");
            MessageMethod messageMethod;
            input = scanner.nextLine();
            while(!(input.equals("0") || input.equals("1"))) {
                System.out.println("You entered a wrong value, insert again.");
                input=scanner.nextLine();
            }
            if(input.equals("0")) {
                messageMethod = new RoundEnd();
            }
            else {
                messageMethod = new IngressHallSwap();
                System.out.println("Select the student from your Ingress: \n");
                showSchool();
                input = scanner.nextLine();
                while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size()-1) {
                    System.out.println("Ops! You entered a wrong or too high value, choose again!");
                    input = scanner.nextLine();
                }
                ((IngressHallSwap)messageMethod).setStudentIngress(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get( Integer.parseInt(input)).getId());
                System.out.println("Select a student from your Hall \n");
                for(Color c : Color.values()) {
                    for (int i = 0; i < client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).getStudents().size();i++) {
                        System.out.print("Student " +  client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).getColor() + " Number " + i + "\n");
                    }
                    if (!client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).getStudents().isEmpty())
                    System.out.println("\n");
                }

                System.out.println("Select the color of the line, YELLOW=0  BLUE=1  GREEN=2  RED=3  PINK=4 \n");
                input = scanner.nextLine();
                while (!(input.equals("0") || input.equals("1") || (input.equals("2")) || input.equals("3") || input.equals("4")) ) {
                    System.out.println("Ops! You entered a wrong value or you dont have any student in this line");
                    input = scanner.nextLine();
                }
                while (client.getGame().getCurrentPlayer().getSchool().getHall().getLine(Color.getColor(Integer.parseInt(input))).getStudents().isEmpty()){
                    System.out.println("The line you selected is empty");
                    input = scanner.nextLine();
                    while (!(input.equals("0") || input.equals("1") || (input.equals("2")) || input.equals("3") || input.equals("4"))){
                        System.out.println("Ops! You entered a wrong value or you dont have any student in this line");
                        input = scanner.nextLine();
                    }
                }

                System.out.println("Write the number of the student in the correspondent line");
                String input1 = scanner.nextLine();
                while(input1 == "" || !input1.matches("[0-9]+") || Integer.parseInt(input1) > client.getGame().getCurrentPlayer().getSchool().getHall().getLine(Color.getColor(Integer.parseInt(input))).getStudents().size()-1) {
                    System.out.println("Ops! You entered a wrong value!");
                    input1 = scanner.nextLine();
                }
                ((IngressHallSwap)messageMethod).setStudentHall(client.getGame().getCurrentPlayer().getSchool().getHall().getLine(Color.getColor(Integer.parseInt(input))).getStudents().get(Integer.parseInt(input1)).getId());
            }
            CLIController.write(messageMethod);

        });
        t.start();
        return t;
    }

    /**
     *
     * @return
     */
    public Thread studentToHall() {
        Thread t = new Thread(() -> {
            System.out.println("You have to select the student from the card you want to put in the Hall, those are the students present on the card\n");
            for (int i = 0; i<((StudentToHallCard)client.getGame().getCardManager().getCurrentCard()).getStudents().size()-1; i++) {
                System.out.println("Student " + ((StudentToHallCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(i).getColor() + " Number " + i + "\n");
            }
            input = scanner.nextLine();
            while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input)>(((StudentToHallCard)client.getGame().getCardManager().getCurrentCard()).getStudents().size()-1)) {
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }
            MessageMethod messageMethod = new StudentToHall();
            ((StudentToHall)messageMethod).setStudentToHall(((StudentToHallCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(Integer.parseInt(input)).getId());

            CLIController.write(messageMethod);
        });
        t.start();
        return t;
    }

    /**
     *
     * @return
     */
    public Thread studentToIsland() {
        Thread t = new Thread(() -> {
            System.out.println("You have to select the student from the card you want to put in the Hall, those are the students present on the card\n");
            for (int i=0; i<((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()-1; i++) {
                System.out.println("Student " + ((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(i).getColor() + " Number " + i + "\n");
            }
            input = scanner.nextLine();
            while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input)>(((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()-1)){
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }

            MessageMethod messageMethod = new StudentToIsland();
            ((StudentToIsland)messageMethod).setStudent(((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(Integer.parseInt(input)).getId());

            System.out.println("On which island do you want to put the student?");
            showIsland();
            System.out.println("On which island do you want to move the student to?");
            input = scanner.nextLine();
            while (input =="" || Integer.parseInt(input)>client.getGame().getIslandManager().getIslands().size()-1) {
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }
            ((StudentToIsland)messageMethod).setIsland(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input)).getId());
            CLIController.write(messageMethod);

        });
        t.start();
        return t;
    }

    /**
     *
     */
    private void showIsland(){
        int ind0 = 0;
        for (IslandInterface islandInterface: client.getGame().getIslandManager().getIslands()) { // for every islandInterface element
            if (islandInterface.getTowers()==null) {
                System.out.print("\n" + ind0 + ": Island " + "\nCurrent students:  ");
                for (int k=0;k<islandInterface.getStudents().size();k++) {
                    System.out.print(islandInterface.getStudents().get(k).getColor() + "   ");
                }
                System.out.println("\nNo tower");
                if (islandInterface.getId()==client.getGame().getMotherNature().getIsland().getId()) {
                    System.out.println("MotherNature is here !");
                }
            } else {
                if (!islandInterface.isGrouped()) { // if the islandInterface element is an Island
                    System.out.print("\n" + ind0 + ": Island " + "\nCurrent students: ");
                } else {
                    System.out.print("\n" + ind0 + ": Group of island " + "\nCurrent students: ");
                }
                for(int k=0; k<islandInterface.getStudents().size(); k++) {
                    System.out.print(islandInterface.getStudents().get(k).getColor() + "    " );
                }
                System.out.print("\n");
                if(islandInterface.isGrouped()) {
                    System.out.println("Towers: " + islandInterface.getTowers().get(0).getColor() + "     number of Towers: " + islandInterface.getTowers().size());
                } else {
                    for (Tower h : islandInterface.getTowers())
                        System.out.println("Towers: " + islandInterface.getTowers().get(0).getColor() + "     number of Towers: " + islandInterface.getTowers().size());
                }
                if (islandInterface.getId()==client.getGame().getMotherNature().getIsland().getId()) {
                    System.out.println("MotherNature is here !");
                }
            }
            ind0++;
        }
    }

    /**
     *
     */
    private void showSchool() {
        for (Color c :Color.values()) {
            System.out.println("In the " + c +"  line you have " + client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).getStudents().size() + " student");
            for (Player player : client.getGame().getPlayerList()) {
                if (player.getSchool().getHall().getLine(c).isProfessor() && !player.getName().equals(client.getNamePlayer())) {
                    System.out.println("The player "+ player.getName() + " has the professor " + c +" with " + player.getSchool().getHall().getLine(c).getStudents().size() + " students");
                }
            }
            if (client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).isProfessor()) {
                System.out.println("You have the professor for the color  " + c);
            }
        }

        System.out.println("\nHere's your Ingress:\n ");
        for (int i=0; i<client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++) {
            System.out.println("Student " + client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor() + " Number " + i );
        }
    }

    /**
     *
     */
    private void goBack() {
        Thread d;
        if (client.getGame().getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_MOTHERNATURE) {
            d = movingMotherNature();
        } else if (client.getGame().getCurrentPlayer().getPlayerPhase()==PlayerPhase.MOVING_STUDENTS) {
            d = movingStudentsFromIngress();
        } else {
            d = choosingStudentsFromClouds();
        }
        try {
            d.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
