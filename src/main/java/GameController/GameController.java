package GameController;

import Characters.Monster;
import Characters.Player;
import GameController.dices.*;
import battlemap.Dungeon.Dungeon;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController {


    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Monster> monster = new ArrayList<Monster>();
    private Dungeon dungeon;
    private HashMap<String, IDice> dices = new HashMap<String, IDice>();

    private FightController fightController = new FightController(players, monster);

    public FightController getFightController(){
        return fightController;
    }
    private GameStart gameStart = new GameStart();
    GameController(){
        dices.put("four", new DiceFour());
        dices.put("eight", new DiceEight());
        dices.put("ten", new DiceTen());
        dices.put("twenty", new DiceTwenty());
    }

    public void gameStart(){
        players.addAll(gameStart.run());
    }

    public void roundStart(){

    }

    public void roundEnd(){

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Monster> getMonster() {
        return monster;
    }
}
