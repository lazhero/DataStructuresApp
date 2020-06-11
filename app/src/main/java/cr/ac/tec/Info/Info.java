package cr.ac.tec.Info;

import java.io.Serializable;

public class Info implements Serializable {
    private int[] ID;
    private int[] Stars;
    private int[] Coins;
    public int[] getID(){
        return ID;
    }
    public int[] getStars(){
        return Stars;
    }
    public int[] getCoins(){
        return Coins;
    }

    public void setStars(int[] stars) {
        Stars = stars;
    }

    public void setCoins(int[] coins) {
        Coins = coins;
    }

    public void setID(int[] ID) {
        this.ID = ID;
    }
}
