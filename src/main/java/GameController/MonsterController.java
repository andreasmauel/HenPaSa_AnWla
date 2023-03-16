package GameController;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;
import battlemap.Dungeon.Dungeon;
import util.DistanceCalculator;

public class MonsterController {

    Monster monster;
    Player[] players;
    Dungeon dungeon;

    AbstractCharacter nearestEnemy;

    public MonsterController(Monster monster , Player[] players, Dungeon dungeon) {
        this.monster = monster;
        this.players = players;
        this.dungeon = dungeon;

    }

    public void attack() {
      if(distanceToNearestEnemy() < this.monster.getRange()) {
          this.monster.attack(this.nearestEnemy);
      }
    }


    public AbstractCharacter getNearestPlayer() {

        int distance = Integer.MAX_VALUE;
        AbstractCharacter nearestCharacter = null;
        for(Player player : players) {
           int distancePlayer = DistanceCalculator.getDistanceBetweenCharacters(player, this.monster);
           if(distancePlayer < distance) {
               distance = distancePlayer;
               this.nearestEnemy = player;
           }
        }
        return this.nearestEnemy;
    }

    public int distanceToNearestEnemy() {
        return DistanceCalculator.getDistanceBetweenCharacters(this.nearestEnemy, this.monster);
    }



}
