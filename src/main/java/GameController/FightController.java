package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;

import java.util.ArrayList;
import java.util.Collections;

public class FightController {
    private boolean fightEnd;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private ArrayList<AbstractCharacter> fightOrder;
    private AbstractCharacter currentCharacter;
    private int currentPlayerIndex = 0;

    FightController(ArrayList<Player> players, ArrayList<Monster> monsters) {
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

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public void startFight() {
        for (Player player : this.players) {
            this.addToFight(player);
        }
        for (Monster monster : this.monsters) {
            this.addToFight(monster);
        }
        this.currentCharacter = this.fightOrder.get(this.currentPlayerIndex);
    }

    public void startFightRound(EffectController effectController) {
        effectController.activeEffects(); // active effects
        for(AbstractCharacter character: fightOrder) {
            if(character instanceof Monster){
                monsterActions((Monster) character);
            } else {
                playerAction(character, target);
            }
        }
        endFightRound();
        //TODO effect aktive?, character actions, round end
    }

    public void endFightRound() {
        if (this.monsters.isEmpty() || this.players.isEmpty()) {
            this.fightEnd();
            return ;
        }
    }

    public void fightEnd() {
        this.currentPlayerIndex = 0;
        this.fightEnd = true;
    }

    public boolean isFightEnd() {
        return fightEnd;
    }

    public void playerAction(Player player, AbstractCharacter target) {
        player.attack(target);
    }

    public void monsterActions(Monster monster) {
        monster.attack(players.get(0));
    }

    private void addToFight(AbstractCharacter character) {
        character.rollInitiative();
        this.fightOrder.add(character);
        this.fightOrder.sort(new AbstractCharacter.InitiativeComperetor());
    }
}
