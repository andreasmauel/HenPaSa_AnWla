package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;
import GUI.Main.ActionHandler.AttackAction;

import java.util.ArrayList;
import java.util.Collections;

public class FightController {
    private boolean fightEnd;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private ArrayList<AbstractCharacter> fightOrder;
    private AbstractCharacter currentCharacter;
    private int currentPlayerIndex = 0;

    public FightController(ArrayList<Player> players, ArrayList<Monster> monsters) {
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

    public void startFightRound() {
        currentCharacter.getEffects();
        EffectController effectController = new EffectController();


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
        this.fightOrder.sort(new AbstractCharacter.InitiativeComparator());
    }
}