package it.polimi.ingsw.client.view;

import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.Controller;
import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.enumerations.Color;
import it.polimi.ingsw.model.enumerations.Wizard;
import it.polimi.ingsw.model.expertCards.ExpertCard;
import it.polimi.ingsw.model.expertCards.deck.IngressCardSwapCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToHallCard;
import it.polimi.ingsw.model.expertCards.deck.StudentToIslandCard;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
import it.polimi.ingsw.model.player.Player;
import it.polimi.ingsw.model.rounds.SetUpRound;

import java.util.Scanner;

public class CLI {

    /**
     * Keep the reference to the Client
     */
    private Client client;

    /**
     * Keep the reference to the controller
     */
    private Controller controller;

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
     * @param controller    Keep the reference to the controller
     */
    public CLI(Client client, Controller controller){
        this.client = client;
        this.controller = controller;
    }

    /**
     * Get the thread witch will run the chooseColorAndDeck method
     * @return thread
     */
    public Thread chooseColorAndDeck() {

        Thread t = new Thread(() -> {
            System.out.println("Before starting, choose your deck and your wizard!");
            for (Wizard wizard: ((SetUpRound) client.getGame().getCurrentRound()).getWizards()) {
                System.out.println(wizard.getColor() + " Wizard");
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
            ((ChooseColorAndDeck) messageMethod).setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)));
            System.out.println("Pick the color\n");
            System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor());
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().size()-1) {
                    System.out.println("You entered a wrong or too high value, please try again.");
                    input = scanner.nextLine();
            }
            System.out.println("Color selected " + ((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)) + "\n");
            ((ChooseColorAndDeck) messageMethod).setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)));
            controller.write(messageMethod);
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
            System.out.println("All right! Now pick the assistant card to use in this turn.");
            System.out.println((client.getGame().getCurrentPlayer()).getAssistantCard());
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getAssistantCard().size()-1) {
                System.out.println("You entered a wrong or too high value, please try again.");
                input = scanner.nextLine();
            }
            MessageMethod messageMethod = new ChoosingAssistant();
            ((ChoosingAssistant) messageMethod).setAssistantCard(client.getGame().getCurrentPlayer().getAssistantCard().get(Integer.parseInt(input)).getId());
            //messageMethod.setWizard(((SetUpRound) client.getGame().getCurrentRound()).getWizards().get(Integer.parseInt(input)));
            //messageMethod.setPlayerColor(((SetUpRound) client.getGame().getCurrentRound()).getplayerColor().get(Integer.parseInt(input)));
            controller.write(messageMethod);
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
            System.out.println("It's your turn, " + client.getGame().getCurrentPlayer().getName() + " Here's your Ingress:");
            for(int i=0;i<client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size();i++) {
               System.out.println("Student " + client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor() + " Number " + i + "\n");
            }
            System.out.println("Choose 3 students in your ingress and place each one or in the hall or on an island!");
            input = scanner.nextLine();
            while (input=="" || !input.matches("[0-9]+") || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size()-1) {
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }
            System.out.println("Where do you want to move this student? 0 Hall 1 Island");
            input1 = scanner.nextLine();
            while (!(input1.equals("1") || input1.equals("0"))) {
                System.out.println("Ops! You entered a wrong value!");
                input1 = scanner.nextLine();
            }
            if (input1.equals("0")) {
                MessageMethod hallMessageMethod = new MovingStudentsFromIngressToHall();
                System.out.println(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(Integer.parseInt(input)).getId());
                ((MovingStudentsFromIngressToHall) hallMessageMethod).setStudent(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(Integer.parseInt(input)).getId());
                controller.write(hallMessageMethod);
            }
            else if (input1.equals("1")) {
                System.out.println("On which island do you want to move the student to? Select the Group Number\n");
                int ind0 = 0;
                for (IslandInterface islandInterface: client.getGame().getIslandManager().getIslands()) {
                    if (islandInterface.getTowers()==null) {
                        System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "        Current students: " + islandInterface.getStudents() + "\nNo tower\n");
                    }
                    else
                        System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "        Current students: " + islandInterface.getStudents() + "\nTower " + islandInterface.getTowers() + " color: " + islandInterface.getTowers() + "\n");
                    ind0++;
                }
                input1 = scanner.nextLine();
                while (input1 =="" || Integer.parseInt(input1)>client.getGame().getIslandManager().getIslands().size()-1) {
                    System.out.println("Ops! You entered a wrong or too high value, choose again!");
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
                        System.out.println("Island " + island.getId() + "\nGroupNumber " + ind1 + "\nCurrent students: " + island.getStudents() + "\n Tower " + island.getTowers().get(0).getId() + " color: " + island.getTowers().get(0).getColor() + "\n");
                        ind1++;
                    }
                    input2 = scanner.nextLine();
                    while (input2=="" || Integer.parseInt(input2)>client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getSize()-1) {
                        System.out.println("Ops! You entered a wrong or too high value, choose again!");
                        input2 = scanner.nextLine();
                    }
                    ((MovingStudentFromIngressToIsland) islandMessageMethod).setIsland(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getIslandGroupElements().get(Integer.parseInt(input2)).getId());
                }
                else {
                    ((MovingStudentFromIngressToIsland) islandMessageMethod).setIsland(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input1)).getIslandGroupElements().get(0).getId());
                }
                controller.write(islandMessageMethod);
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
            System.out.println("Now you can move Mother Nature!\nHow many jumps do you want Mother Nature to do? (max " + client.getGame().getCurrentPlayer().getCardPlayedValue() + " jumps available)");
            int ind = 0;
            for (IslandInterface islandInterface : client.getGame().getIslandManager().getIslands()) {
                if (islandInterface.getTowers()==null) {
                    System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind + "\nCurrent students: " + islandInterface.getStudents() + "\nNo tower\n");
                }
                else
                    System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind + "\nCurrent students: " + islandInterface.getStudents() + "\nTower " + islandInterface.getTowers().get(0).getId() + " color: " + islandInterface.getTowers() + "\n");
                ind++;
            }
            input = scanner.nextLine();
            while (input=="" || Integer.parseInt(input)>client.getGame().getCurrentPlayer().getCardPlayedValue() || input=="0") {
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }
            MessageMethod messageMethod = new MovingMotherNature();
            ((MovingMotherNature) messageMethod).setJumps(Integer.parseInt(input));
            controller.write(messageMethod);
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
            System.out.println(client.getGame().getClouds());
            System.out.println("Now you can choose the group of students you want among the available clouds!");
            input = scanner.nextLine();

            while (input=="" || Integer.parseInt(input)>client.getGame().getClouds().size()-1 || client.getGame().getClouds().get( Integer.parseInt(input)).getStudents().isEmpty()) {
                System.out.println("Ops! You entered a wrong or too high value or the cloud is empty, choose again!");
                input = scanner.nextLine();
            }

            MessageMethod messageMethod = new ChooseStudentsFromCloud();
            ((ChooseStudentsFromCloud) messageMethod).setCloud(client.getGame().getClouds().get(Integer.parseInt(input)));
            controller.write(messageMethod);
        });
        t.start();
        return t;
    }


    public Thread choosingExpertCardOrMoving() {

        Thread t = new Thread(() -> {
            if(client.getGame().getCardManager().getCurrentCard()!=null){
                System.out.println("You cannot play another ExpertCard in this turn because it has already been played a expertCard in this round");
                Thread k = movingStudentsFromIngress();
                try {
                    k.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("If you want to play an Expert Card click 0 to visualize the three Expert card available, otherwise select 1 to move the student");
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
                    Thread d = movingStudentsFromIngress();
                    try {
                        d.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        return t;
    }

    public Thread playExpertCard(){
    Thread t = new Thread(() -> {
        Boolean tooPoor=true;
        Boolean playedCard=false;
        int i=0;
        while(tooPoor) {
            for (ExpertCard expertCard : client.getGame().getCardManager().getDeck()) {
                System.out.println("Expert Card " + i + " " + expertCard + " this card costs " + expertCard.getCost());
                i++;
            }

            System.out.println("Those are the ExpertCard available, select one if you want to play it , if you changed your mind and want to move the student write exit: ");

            input = scanner.nextLine();
            while (!(input.equals("1") || input.equals("0") || (input.equals("2")) || input.equals("exit"))) {
                System.out.println("Ops! You entered a wrong value!");
                input = scanner.nextLine();
            }
            if (input.equals("exit")) {
                tooPoor = false;
                Thread f = movingStudentsFromIngress();
                try {
                    f.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getCost() > client.getGame().getCurrentPlayer().getCoins()) {
                    System.out.println("This card costs too much , you can't afford it\n\n");

                } else {
                    //Qui probabilmente si gioca la carte
                    tooPoor = false;
                    System.out.println("Hai giocato questa Carta " + client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)));
                    MessageMethod messageMethod = new PlayExpertCard();
                    ((PlayExpertCard) messageMethod).setExpertCard(client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId());

                    if (client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("46") || client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals( "49")) {
                        System.out.println("This card needs a color to be selected, select the color\n");
                        System.out.println(Color.values());
                        System.out.println("\nYou must enter   YELLOW=0  BLUE=1  GREEN=2  RED=3  PINK=4");

                        input = scanner.nextLine();
                        while (!(input.equals("0") || input.equals("1") || (input.equals("2")) || input.equals("3") || input.equals("4"))) {
                            System.out.println("Ops! You entered a wrong value!");
                            input = scanner.nextLine();
                        }
                        ((PlayExpertCard) messageMethod).setParameter(Color.getColor(Integer.parseInt(input)).getId());
                        playedCard=true;
                    }

                    if (!playedCard && client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals( "42") ) {
                        int ind0 = 0;
                        System.out.println("This card needs a island to be selected where we put the deny token, select the island\n");
                        for (IslandInterface islandInterface: client.getGame().getIslandManager().getIslands()) {
                            if (islandInterface.getTowers()==null) {
                                System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "\nCurrent students: " + islandInterface.getStudents() + "\nNo tower\n");
                            }
                            else
                                System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "\nCurrent students: " + islandInterface.getStudents() + "\nTower " + islandInterface.getTowers() + " color: " + islandInterface.getTowers() + "\n");
                            ind0++;
                        }
                        System.out.println("On which island do you want to move the student to?");
                        input = scanner.nextLine();
                        while (input =="" || Integer.parseInt(input)>client.getGame().getIslandManager().getIslands().size()-1) {
                            System.out.println("Ops! You entered a wrong or too high value, choose again!");
                            input = scanner.nextLine();
                        }
                        ((PlayExpertCard) messageMethod).setParameter(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input)).getId());
                        playedCard=true;

                    }

                    if( !playedCard && client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals( "40"))
                    {
                        //Da capire island interface nella carta prima era solo un island
                    }

                    if(!playedCard && client.getGame().getCardManager().getDeck().get(Integer.parseInt(input)).getId().equals("45")) {
                        System.out.println("This card need a player to select, select one\n");
                        int c = 0;
                        for (Player p : client.getGame().getPlayerList())
                            System.out.println("To select the player named " + p.getName() + " you need to write " + c + "\n");
                        c++;
                        input = scanner.nextLine();
                        while ((!(input.equals("0") || input.equals("1")) && client.getGame().getPlayerList().size() == 2) || (!((input.equals("0")) || input.equals("1") || input.equals("2")) && client.getGame().getPlayerList().size() == 3)) {
                            System.out.println("Ops! You entered a wrong value!");
                            input = scanner.nextLine();
                        }
                        ((PlayExpertCard) messageMethod).setParameter(client.getGame().getPlayerList().get(Integer.parseInt(input)).getId());
                    }

                    controller.write(messageMethod);
                }

            }
        }

    });
        t.start();
        return t;
    }


    public Thread ingressCardSwap() {
        Thread t = new Thread(() -> {
            System.out.println("You select the card that allow to swap the student present in the ingress with a student present in the card , \nif you want to end the effect of this cart press exit otherwise press enter\n");
            MessageMethod messageMethod;
            input = scanner.nextLine();
            if(input=="exit") {
                messageMethod = new RoundEnd();
            }
            else {
                messageMethod = new IngressCardSwap();
                System.out.println("Select the player from your ingress \n");
                for (int i = 0; i < client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++) {
                    System.out.println("Student " + client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor() + " Number " + i + "\n");
                }
                input = scanner.nextLine();
                while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input) > client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size() - 1) {
                    System.out.println("Ops! You entered a wrong or too high value, choose again!");
                    input = scanner.nextLine();
                }
                ((IngressCardSwap)messageMethod).setStudentIngress(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get( Integer.parseInt(input)).getId());
                System.out.println("Select a player from the Card \n");
                for (int i = 0; i < ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size() - 1; i++) {
                    System.out.println("Student " + ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(i).getColor() + " Number " + i + "\n");
                }
                input = scanner.nextLine();
                while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input) >( ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()- 1 )){
                    System.out.println("Ops! You entered a wrong or too high value, choose again!");
                    input = scanner.nextLine();
                }
                ((IngressCardSwap)messageMethod).setStudentCard(((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get( Integer.parseInt(input)).getId());
            }
            controller.write(messageMethod);


        });
        t.start();
        return t;
    }



    public Thread ingressHallSwap() {
        Thread t = new Thread(() -> {
                System.out.println("You select the card that allow to swap the student present in the ingress with a student present in the card , \nif you want to end the effect of this cart press exit otherwise press enter\n");
                MessageMethod messageMethod;
                 input = scanner.nextLine();
                if(input=="exit") {
                    messageMethod = new RoundEnd();
                }
                else {
                    messageMethod = new IngressHallSwap();
                    System.out.println("Select the player from your ingress  \n");
                    for (int i = 0; i < client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size(); i++) {
                        System.out.println("Student " + client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor() + " Number " + i + "\n");
                    }
                    input = scanner.nextLine();
                    while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input) > client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size() - 1) {
                        System.out.println("Ops! You entered a wrong or too high value, choose again!");
                        input = scanner.nextLine();
                    }
                    ((IngressHallSwap)messageMethod).setStudentIngress(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get( Integer.parseInt(input)).getId());
                    System.out.println("Select a player from your Hall \n");
                    System.out.println("First you have to select the color of the line, YELLOW=0  BLUE=1  GREEN=2  RED=3  PINK=4\n");
                    for(Color c : Color.values()) {

                        for (int i = 0; i < client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).getStudents().size();i++) {
                            System.out.println("Student " +  client.getGame().getCurrentPlayer().getSchool().getHall().getLine(c).getColor() + " Number " + i + "\n");
                        }
                        System.out.println("\n");
                    }
                    System.out.println("Select the color of the line, YELLOW=0  BLUE=1  GREEN=2  RED=3  PINK=4 \n");
                    input = scanner.nextLine();
                    while (!(input.equals("0") || input.equals("1") || (input.equals("2")) || input.equals("3") || input.equals("4"))) {
                        System.out.println("Ops! You entered a wrong value!");
                        input = scanner.nextLine();
                    }
                    System.out.println("Write the number of the student in the correspondent line");
                    String input1=scanner.nextLine();
                    while(input1 == "" || !input1.matches("[0-9]+") || Integer.parseInt(input1) > client.getGame().getCurrentPlayer().getSchool().getHall().getLine(Color.getColor(Integer.parseInt(input))).getStudents().size() - 1) {
                        System.out.println("Ops! You entered a wrong value!");
                        input1 = scanner.nextLine();
                    }
                    ((IngressHallSwap)messageMethod).setStudentHall(client.getGame().getCurrentPlayer().getSchool().getHall().getLine(Color.getColor(Integer.parseInt(input))).getStudents().get(Integer.parseInt(input1)).getId());
                }
                controller.write(messageMethod);



        });
        t.start();
        return t;
    }

    public Thread studentToHall() {
        Thread t = new Thread(() -> {
            System.out.println("You have to select the student from the card you want to put in the Hall, those are the students present on the card\n");
            for (int i = 0; i < ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size() - 1; i++) {
                System.out.println("Student " + ((StudentToHallCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(i).getColor() + " Number " + i + "\n");
            }
            input = scanner.nextLine();
            while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input) >( ((StudentToHallCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()- 1 )){
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }
            MessageMethod messageMethod=new StudentToHall();
            ((StudentToHall)messageMethod).setStudentToHall(((StudentToHallCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(Integer.parseInt(input)).getId());
            controller.write(messageMethod);
        });
        t.start();
        return t;
    }


    public Thread studentToIsland() {
        Thread t = new Thread(() -> {
            Integer ind0=0;
            System.out.println("You have to select the student from the card");
            for (int i = 0; i < ((IngressCardSwapCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size() - 1; i++) {
                System.out.println("Student " + ((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(i).getColor() + " Number " + i + "\n");
            }
            input = scanner.nextLine();
            while (input == "" || !input.matches("[0-9]+") || Integer.parseInt(input) >( ((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().size()- 1 )){
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }

            MessageMethod messageMethod=new StudentToIsland();
            ((StudentToIsland)messageMethod).setStudent(((StudentToIslandCard) client.getGame().getCardManager().getCurrentCard()).getStudents().get(Integer.parseInt(input)).getId());

            System.out.println("On which island do you want to put the student?");

            for (IslandInterface islandInterface: client.getGame().getIslandManager().getIslands()) {
                if (islandInterface.getTowers()==null) {
                    System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "\nCurrent students: " + islandInterface.getStudents() + "\nNo tower\n");
                }
                else
                    System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "\nCurrent students: " + islandInterface.getStudents() + "\nTower " + islandInterface.getTowers() + " color: " + islandInterface.getTowers() + "\n");
                ind0++;
            }
            System.out.println("On which island do you want to move the student to?");
            input = scanner.nextLine();
            while (input =="" || Integer.parseInt(input)>client.getGame().getIslandManager().getIslands().size()-1) {
                System.out.println("Ops! You entered a wrong or too high value, choose again!");
                input = scanner.nextLine();
            }

            ((StudentToIsland)messageMethod).setIsland(client.getGame().getIslandManager().getIslands().get(Integer.parseInt(input)).getId());

            controller.write(messageMethod);

        });
        t.start();
        return t;
    }



}
