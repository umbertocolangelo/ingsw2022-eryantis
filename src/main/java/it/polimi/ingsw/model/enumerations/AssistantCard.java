package it.polimi.ingsw.model.enumerations;

/**
 * 
 */
public enum AssistantCard {
    ONE_CARD(1, 1, "16"),
    TWO_CARD(1, 2, "17"),
    THREE_CARD(2, 3, "18"),
    FOUR_CARD(2, 4, "19"),
    FIVE_CARD(3, 5, "20"),
    SIX_CARD(3, 6, "21"),
    SEVEN_CARD(4, 7, "22"),
    EIGHT_CARD(4, 8, "23"),
    NINE_CARD(5, 9, "24"),
    TEN_CARD(5, 10, "25");

    private final int value;
    private final int num;
    private final String id;


    /**
     * @param value is the value of MotherNature jumps allowed by the card
     * @param num
     */
    AssistantCard(int value, int num, String id) {
        this.value = value;
        this.num = num;
        this.id = id;
    }

    /**
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * @return
     */
    public int getNum() {
        return num;
    }

    /**
     *
     */
    public String getId() { return id; }

}