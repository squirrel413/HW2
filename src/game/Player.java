package game;

public enum Player {

    //enum Values
    RED,
    BLUE,
    NONE

    //Constructor
    private int playerColor;
    Player(int playerColor) {
        this.playerColor = playerColor;
    }
    //Methods
    public static Player[] values(){
        return values();
    }
}
