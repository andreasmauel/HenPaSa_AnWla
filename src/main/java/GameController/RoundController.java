package GameController;

import Characters.Monster;
import Characters.Player;
import GUI.Main.ActionHandler.MoveAction;

import java.util.ArrayList;

public class RoundController {

    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;

    private static FightController fightController = new FightController(players, monsters);

    RoundController(ArrayList<Player> players, ArrayList<Monster> monsters) {
        this.setPlayers(players);
        this.setMonsters(monsters);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public void performRound() {
        Player player = getActivePlayer();
        if(getActivePlayer() != null){
            endRound();
        }
       this.playerAction(player);
       this.checkFight(player);
       
    }

    private void endRound() {
    }

    private void monstersAction(Monster monster) {

    }

    private void playerAction(Player player) {

    }

    private void checkFight(Player character) {
/*        if(.contains(instanceof Monster)){
*            fightController.startFightRound(new EffectController());
* TODO: funktion des Sichtfeldes noch erwartet
*/        }

    public Player getActivePlayer() {
        for (Player player : players) {
            return player;
        }
        return null;
    }

    public void move(Player player){
        int x = player.getX();
        int y = player.getY();

        String xcord = null;
        String ycord = null;
        MoveAction.executeAction(xcord,ycord);
    }
    }

