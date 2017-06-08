package audelaurent.schottentotten.Model;

/**
 * Created by Aude on 01/06/2017.
 */

public class Player {
    private static final String TAG = "Player";
    public String name;
    public Board playerBoard;
    public Hand playerHand;

    public Player(String name) {
        this.name = name;
        playerBoard = new Board();
        playerHand = new Hand();
    }

    public Board getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(Board playerBoard) {
        this.playerBoard = playerBoard;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }


}
