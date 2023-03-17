package GameController;

import Characters.Monster;
import Characters.Player;

import java.util.ArrayList;

public class RoundController {

    private ArrayList<Player> players;
    private ArrayList<Player> monsters;

    RoundController(ArrayList<Player> players, ArrayList<Player> monsters) {
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

    public void performRound() {
        for (Player player : this.players) {
            this.playerAction(player);
            this.checkFight(player);
        }
    }

    private void monstersAction(Player monster) {

    }

    private void playerAction(Player player) {

    }

    private void checkFight(Player character) {

    }
}
