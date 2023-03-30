package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;

import java.util.ArrayList;

public class FightController {
    private boolean fightEnd;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private ArrayList<AbstractCharacter> fightOrder = new ArrayList<>();
    private AbstractCharacter currentCharacter;
    private int currentCharacterIndex = 0;

    public FightController(ArrayList<Player> players, ArrayList<Monster> monsters) {
        this.fightEnd = false;
        this.setPlayers(players);
        this.setMonsters(monsters);
        this.startFight();
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



    public void startFightRound() {
        currentCharacter.getEffects().triggerEffects();
        if (currentCharacter.getEffects().isSleepActive) {
            endFightRound();
        }
    }

    public void endFightRound() {
        if (this.monsters.isEmpty() || this.players.isEmpty()) {
            this.fightEnd();
            return ;
        }
        if (this.currentCharacterIndex == this.fightOrder.size() - 1) {
            this.currentCharacterIndex = 0;
            this.currentCharacter = this.fightOrder.get(this.currentCharacterIndex);
        } else {
            this.currentCharacterIndex ++;
            this.currentCharacter = this.fightOrder.get(this.currentCharacterIndex);
        }
    }

    public void fightEnd() {
        this.currentCharacterIndex = 0;
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

    private void startFight()    {
        for (Player player : this.players) {
            this.addToFight(player);
        }
        for (Monster monster : this.monsters) {
            this.addToFight(monster);
        }
        this.currentCharacter = this.fightOrder.get(this.currentCharacterIndex);
    }

    private void addToFight(AbstractCharacter character) {
        character.rollInitiative();
        this.fightOrder.add(character);
        this.fightOrder.sort(new AbstractCharacter.InitiativeComparator());
    }
}