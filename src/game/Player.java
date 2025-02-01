package game;

public enum Player {

    //enum Values
    RED("Red"),
    BLUE("Blue"),
    NONE("None");

    private final String player;
    //Constructor
    Player (String player) {
        this.player = player;
    }

    //Methods
    //will not override values and valueOf as enum inherently has them
    public String getLabel() {
     return player;
    }
}
