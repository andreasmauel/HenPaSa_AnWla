package GameController;

import java.util.ArrayList;

public class FightController {
    private Player[] players;

    private Monster[] monsters;

    private ArrayList<AbstractCharacter> fightOrder;

    FightController(Player[] players, Monster[] monsters) {

    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    private void playerAction() {

    }

    private void checkFight() {

    }

    private void monsterActions() {

    }

    private void addToFight(AbstractCharacter character) {
        this.fightOrder.sort();
    }
}
