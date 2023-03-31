package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;
import GUI.Main.DialogBox;
import util.DistanceCalculator;


import java.util.ArrayList;

public class RoundController {
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private ArrayList<AbstractCharacter> turnOrder = new ArrayList<>();
    private int index = 0;
    private FightController fightController;
    private AbstractCharacter activeCharacter;
    private GameController gameController;
    private boolean fightActive = false;

    RoundController(ArrayList<Player> players, ArrayList<Monster> monsters, GameController gameController) {
        this.setPlayers(players);
        this.setMonsters(monsters);
        this.gameController = gameController;
        this.setTurnOrder();
    }

    private void setTurnOrder() {
        this.turnOrder.addAll(this.players);
        this.turnOrder.addAll(this.monsters);
    }

    public boolean isFightActive() {
        return fightActive;
    }

    public void setFightActive(boolean fightActive) {
        this.fightActive = fightActive;
    }

    public Player getActivePlayer() {
        return players.get(index);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setActiveCharacter(AbstractCharacter activeCharacter) {
        this.activeCharacter = activeCharacter;
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

    public void nextRound() {
        if (this.fightActive) {
            this.fightController.nextRound();
        }
        this.index ++;
        if (this.index >= this.turnOrder.size()) {
            this.index = 0;
        }
        if (!this.fightActive) {
            if (this.checkFight()) {
                DialogBox.ConsoleOut("Monster gesichtet. Kampf beginnt!!!");
                this.fightActive = true;
                ArrayList<Monster> monstersInFight = new ArrayList<>();
                for (Monster monster : this.monsters) {
                    if (DistanceCalculator.isRange(activeCharacter, 5, monster.getX(), monster.getY())) {
                        monstersInFight.add(monster);
                    }
                }
                this.fightController = new FightController(this.players, monstersInFight, this.gameController);
            }
        }
        this.activeCharacter = this.turnOrder.get(this.index);
    }

    private boolean checkFight() {
        boolean isInFightRange = false;
        if (this.activeCharacter instanceof Monster) {
            for (Player player : this.players) {
                return DistanceCalculator.isRange(activeCharacter, 3, player.getX(), player.getY());
            }
        } else if (this.activeCharacter instanceof  Player) {
            for (Monster monster : this.monsters) {
                return DistanceCalculator.isRange(activeCharacter, 3, monster.getX(), monster.getY());
            }
        }
       return isInFightRange;
    }
}
