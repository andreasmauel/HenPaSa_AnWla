package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;
import Characters.Races.Dwarf;
import Characters.ViewDirection;
import Characters.classes.Fighter;
import Characters.classes.FightingStyle;
import Characters.classes.Mage;
import Characters.classes.Thief;
import GameController.dices.*;
import battlemap.AbstractPositions.CharacterPos;
import battlemap.Dungeon.Dungeon;
import battlemap.MapGeneration.StartDungeon;
import equipment.armor.ChainMail;
import equipment.weapon.*;
import observer.Observer;
import util.Attribute;

import java.util.ArrayList;
import java.util.HashMap;

public class GameController implements Observer {


    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Monster> monster = new ArrayList<Monster>();
    private Dungeon dungeon;
    private HashMap<String, IDice> dices = new HashMap<String, IDice>();
    private GameStart gameStart = new GameStart();
    private RoundController roundController;
    private StartDungeon map;

    public static boolean GAME_CONFIG = false;

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
        players.addAll(gameStart.run(this));
        Player player1 = new Player(1, "Dave", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH,  new Thief(), new Dart());
        Player player2 = new Player(2, "Berta", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH,  new Thief(), new Bow());
        Player player3 = new Player(3, "Hans", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH,  new Thief(), new Bow());
        Player player4 = new Player(4, "Guenter", 10, 10, 10, 10, 10, new Dwarf(), 10, 10, new ChainMail(), true, ViewDirection.NORTH,  new Thief(), new Bow());
        //this.players.add(player1);
        //this.players.add(player2);
        //this.players.add(player3);
        //this.players.add(player4);
        //this.roundController = new RoundController(players, monster, this);
        //this.map = new StartDungeon();
        //this.map.createMap(this.players, this);
        //this.map.getMainFrame().getStatusPanel().setActiveCharacter(this.roundController.getActivePlayer().getId());
        //this.monster = new ArrayList<>(map.getMonsters());
        System.out.println(players);
        System.out.println(monster);
        //this.addCharacterToObserver();
    }

    public StartDungeon getMap() {
        return map;
    }

    public void setMap(StartDungeon map) {
        this.map = map;
    }

    public void addCharacterToObserver() {
        for(Player player : players) {
            player.addObserver(this);
        }
        for(Monster monster : monster) {
            monster.addObserver(this);
        }
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

    @Override
    public void update(AbstractCharacter character) {
        System.out.println(character.getCurrentLifepoints());
        if(character.getCurrentLifepoints() == 0) {
            System.out.println(character.getX());
            System.out.println(character.getY());
            map.getDungeon().deleteCharacterPos(character.getX(), character.getY());
            map.getMainFrame().generateMap(map.getDungeon());
        }
    }
}
