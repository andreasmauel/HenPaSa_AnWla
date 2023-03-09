package GameController;

import Characters.Monster;
import Characters.Player;

public class RoundController {

    private Player[] players;
    private Monster[] monsters;

    RoundController(Player[] players, Monster[] monsters) {
        this.setPlayers(players);
        this.setMonsters(monsters);
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

    public void

    private void playerAction(Player[] players) {

    }

    private void checkFight() {

    }
}
