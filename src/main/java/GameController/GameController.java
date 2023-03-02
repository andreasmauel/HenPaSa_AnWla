package GameController;

import battlemap.Dungeon.Dungeon;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController
{
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> monster = new ArrayList<Player>();
    private Dungeon dungeon;
    private HashMap<String, IDice> dices = new HashMap<String, IDice>();
    GameController(){
        dices.put("four", new DiceFour());
        dices.put("eight", new DiceEight());
        dices.put("ten", new DiceTen());
        dices.put("twenty", new DiceTwenty());
    }

    public void gameStart(){

    }

    public void roundStart(){

    }

    public void roundEnd(){

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> getMonster() {
        return monster;
    }
}
