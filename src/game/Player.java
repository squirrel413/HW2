package game;

public enum Player {

    //enum Values
    RED,
    BLUE,
    NONE;


    //Methods
    //will not override values and valueOf as enum inherently has them
    public String getLabel() {
     if (this.equals(Player.RED))
        return "Red";
     if (this.equals(Player.BLUE))
         return "Blue";
     else
         return "None";

    }
}
