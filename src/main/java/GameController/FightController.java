package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;

import java.util.ArrayList;

public class FightController {
    private ArrayList<Player> players;

    private ArrayList<Player> monsters;

    private ArrayList<AbstractCharacter> fightOrder;

    FightController(ArrayList<Player> players, ArrayList<Player> monsters) {
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

    private void playerAction() {

    }

    private void checkFight() {

    }

    private void monsterActions() {

    }

    private void addToFight(AbstractCharacter character) {
        this.fightOrder.sort(character);
    }
}
