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
    public static Dungeon dungeon;
    private HashMap<String, IDice> dices = new HashMap<String, IDice>();
    private GameStart gameStart = new GameStart();
    private FightController fightController = new FightController(players, monster);
    private RoundController roundController = new RoundController(players, monster);

    public GameController(){
        dices.put("four", new DiceFour());
        dices.put("eight", new DiceEight());
        dices.put("ten", new DiceTen());
        dices.put("twenty", new DiceTwenty());
    }

    public FightController getFightController(){
        return fightController;
    }

    public void gameStart(){
        players.addAll(gameStart.run());
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void setMonster(ArrayList<Monster> monster) {
        this.monster = monster;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public HashMap<String, IDice> getDices() {
        return dices;
    }

    public void setDices(HashMap<String, IDice> dices) {
        this.dices = dices;
    }

    public GameStart getGameStart() {
        return gameStart;
    }

    public void setGameStart(GameStart gameStart) {
        this.gameStart = gameStart;
    }

    public void setFightController(FightController fightController) {
        this.fightController = fightController;
    }

    public RoundController getRoundController() {
        return roundController;
    }

    public void setRoundController(RoundController roundController) {
        this.roundController = roundController;
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
