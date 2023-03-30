package GameController;

import Characters.Monster;
import Characters.Player;
import Characters.Races.Dwarf;
import Characters.ViewDirection;
import Characters.classes.Fighter;
import Characters.classes.Thief;
import GameController.dices.*;
import battlemap.Dungeon.Dungeon;
import battlemap.MapGeneration.StartDungeon;
import equipment.armor.ChainMail;
import equipment.weapon.Bow;
import equipment.weapon.Dart;
import equipment.weapon.Rapier;
import equipment.weapon.Spear;
import util.Attribute;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController {


    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Monster> monster = new ArrayList<Monster>();
    private Dungeon dungeon;
    private HashMap<String, IDice> dices = new HashMap<String, IDice>();
    private GameStart gameStart = new GameStart();
    private RoundController roundController;
    private StartDungeon map;

    public GameController(){
        dices.put("four", new DiceFour());
        dices.put("eight", new DiceEight());
        dices.put("ten", new DiceTen());
        dices.put("twenty", new DiceTwenty());
        try {
            gameStart();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void gameStart() throws InterruptedException {
        players.addAll(gameStart.run());
        while(players.get(3) == null) {
            wait(100);
        }
        this.roundController = new RoundController(players, monster);
        this.map = new StartDungeon();
        this.map.createMap(this.players, this);
    }

    public StartDungeon getMap() {
        return map;
    }

    public void setMap(StartDungeon map) {
        this.map = map;
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
