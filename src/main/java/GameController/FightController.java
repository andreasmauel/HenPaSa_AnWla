package GameController;

import Characters.AbstractCharacter;
import Characters.Player;

import java.util.ArrayList;
import java.util.Collections;

public class FightController {
    private boolean fightEnd;
    private ArrayList<Player> players;
    private ArrayList<Player> monsters;
    private ArrayList<AbstractCharacter> fightOrder;
    private int currentPlayerIndex = 0;

    FightController(ArrayList<Player> players, ArrayList<Player> monsters) {
        this.fightEnd = false;
        this.setPlayers(players);
        this.setMonsters(monsters);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Player> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Player> monsters) {
        this.monsters = monsters;
    }

    public void startFight() {
        for (Player player : this.players) {
            this.addToFight(player);
        }
        for (Player monster : this.monsters) {
            this.addToFight(monster);
        }
        this.nextCharacter();
    }

    public Player nextCharacter() {
        if (this.monsters.isEmpty() || this.players.isEmpty()) {
            this.fightEnd = true;
        }
    }

    public boolean isFightEnd() {
        return fightEnd;
    }

    public void playerAction() {

    }

    public void monsterActions() {

    }

    private void addToFight(AbstractCharacter character) {
        character.rollInitiative();
        this.fightOrder.add(character);
        this.fightOrder.sort(new AbstractCharacter.InitiativeComperetor());
    }
}
