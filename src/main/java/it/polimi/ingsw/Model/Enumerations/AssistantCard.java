package it.polimi.ingsw.Model.Enumerations;

/**
 * 
 */
public enum AssistantCard {
    ONE_CARD(1),
    TWO_CARD(1),
    THREE_CARD(2),
    FOUR_CARD(2),
    FIVE_CARD(3),
    SIX_CARD(3),
    SEVEN_CARD(4),
    EIGHT_CARD(4),
    NINE_CARD(5),
    TEN_CARD(5);

    private final int value;


    /**
     *  @param value is the value of MotherNature jumps allowed by the card
     */
    AssistantCard(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}