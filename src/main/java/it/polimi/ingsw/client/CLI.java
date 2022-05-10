package it.polimi.ingsw.client;

import it.polimi.ingsw.message.*;
import it.polimi.ingsw.model.islands.Island;
import it.polimi.ingsw.model.islands.IslandInterface;
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
            System.out.println(client.getGame().getClouds().get(0).getId());
            System.out.println(client.getGame().getClouds().get(0).getStudents().get(0).getId());
            System.out.println("Before starting, choose your deck and your wizard!\nSelect a color from 0 to the number of wizard(s) available.");
            System.out.println(((SetUpRound) client.getGame().getCurrentRound()).getWizards());
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
            for (int i =0; i<client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size();i++) {
                System.out.println(client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getId());
            }
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
            System.out.println("It's your turn, " + client.getGame().getCurrentPlayer().getName() + "\nChoose 3 students in your ingress and place each one or in the hall or on an island!");
                for(int i=0;i<client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().size();i++) {
                   System.out.println("Student " + client.getGame().getCurrentPlayer().getSchool().getIngress().getStudents().get(i).getColor() + " Number " + i + "\n");
                }
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
                    System.out.println("On which island do you want to move the student to?");
                    int ind0 = 0;
                    for (IslandInterface islandInterface: client.getGame().getIslandManager().getIslands()) {
                        System.out.println("Island " + islandInterface.getId() + "\nGroupNumber " + ind0 + "\nCurrent students: " + islandInterface.getStudents() + "\n Tower " + islandInterface.getTowers() + " color: " + islandInterface.getTowers() + "\n");
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
            System.out.println("Now you can move Mother Nature!\nHow many jumps do you want Mother Nature to do? (you have at least" + client.getGame().getCurrentPlayer().getCardPlayedValue() + "jumps available)");
            System.out.println(client.getGame().getIslandManager().getIslands());
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

}
