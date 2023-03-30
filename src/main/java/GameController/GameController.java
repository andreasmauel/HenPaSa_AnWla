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
        //players.addAll(gameStart.run());
        Player player1 = new Player("Dave", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH, new ArrayList<>(), new Thief(4, Attribute.CHARISMA, Attribute.CONSTITUTION, new ArrayList<Attribute>()), new Dart());
        Player player2 = new Player("Berta", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH, new ArrayList<>(), new Thief(4, Attribute.CHARISMA, Attribute.CONSTITUTION, new ArrayList<Attribute>()), new Rapier());
        Player player3 = new Player("Hans", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH, new ArrayList<>(), new Thief(4, Attribute.CHARISMA, Attribute.CONSTITUTION, new ArrayList<Attribute>()), new Bow());
        Player player4 = new Player("Guenter", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH, new ArrayList<>(), new Thief(4, Attribute.CHARISMA, Attribute.CONSTITUTION, new ArrayList<Attribute>()), new Spear());

        this.players.add(player1);
        this.players.add(player2);
        this.players.add(player3);
        this.players.add(player4);

        StartDungeon dungeon = new StartDungeon();
        dungeon.createMap(this.players, this);
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
