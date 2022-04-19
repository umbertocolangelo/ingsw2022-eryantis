package it.polimi.ingsw.model.enumerations;

/**
 * 
 */
public enum AssistantCard {
    ONE_CARD(1, 1),
    TWO_CARD(1, 2),
    THREE_CARD(2, 3),
    FOUR_CARD(2, 4),
    FIVE_CARD(3, 5),
    SIX_CARD(3, 6),
    SEVEN_CARD(4, 7),
    EIGHT_CARD(4, 8),
    NINE_CARD(5, 9),
    TEN_CARD(5, 10);

    private final int value;
    private final int num;


    /**
     * @param value is the value of MotherNature jumps allowed by the card
     * @param num
     */
    AssistantCard(int value, int num) {
        this.value = value;
        this.num = num;
    }

    public int getValue() {
        return value;
    }
    public int getNum() {
        return num;
    }


}