package battlemap.MapGeneration;

import Artifact.Cloak;
import Artifact.HealingPotion;
import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;
import Characters.Races.Elf;
import Characters.Races.Hobbit;
import Characters.Races.Human;
import Characters.ViewDirection;
import Characters.classes.*;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import battlemap.Lockables.Chest;
import battlemap.Lockables.Door;
import battlemap.Meta.TileType;
import equipment.armor.ChainMail;
import equipment.armor.LeatherArmor;
import equipment.armor.NoArmor;
import equipment.weapon.BattleAxe;
import equipment.weapon.Dagger;
import equipment.weapon.Rapier;
import equipment.weapon.Spear;
import spells.Fireball;
import util.Attribute;
import util.Effect;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartDungeon
{
    private Dungeon dungeon;
    private MainFrame mainFrame;
    private ArrayList<Monster> monsters = new ArrayList<>();
    public  StartDungeon(){

    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public Dungeon createMap(ArrayList<Player> players, GameController gameController)
    {
        dungeon = new Dungeon(25, 15, "Start Dungeon");
        boolean[][] generated = new boolean[dungeon.getxMax()][dungeon.getyMax()];

        for(int x = 0; x < dungeon.getxMax(); x++)
        {
            for (int y = 0; y < dungeon.getyMax(); y++)
            {
                if(x==0 || x == dungeon.getxMax()-1 || y==0 || y==dungeon.getyMax()-1)
                {
                    dungeon.setStructurePos(x,y, TileType.WALL);
                    generated[x][y] = true;
                }
                if(x== 5 && y!= 3 && generated[x][y] != true)
                {
                    dungeon.setStructurePos(x,y, TileType.WALL);
                    generated[x][y] = true;
                }
                if(y== 9 && x<16 && x!= 2 && x!=7 && generated[x][y] != true)
                {
                    dungeon.setStructurePos(x,y, TileType.WALL);
                    generated[x][y] = true;
                }

                if(y<9 && x==15 && y!= 4 && generated[x][y] != true)
                {
                    dungeon.setStructurePos(x,y, TileType.WALL);
                    generated[x][y] = true;
                }

                if(y>9 && x==10 && y!= 11 && generated[x][y] != true)
                {
                    dungeon.setStructurePos(x,y, TileType.WALL);
                    generated[x][y] = true;
                }

                if(y>9 && x==15 && generated[x][y] != true)
                {
                    dungeon.setStructurePos(x,y, TileType.WALL);
                    generated[x][y] = true;
                }

                if(y==3 && x==5 && generated[x][y] != true)
                {
                    dungeon.setDoorPos(x,y,TileType.DOOR,new Door(false,10));
                    generated[x][y] = true;
                }

                if(y==11 && x==10 && generated[x][y] != true)
                {
                    dungeon.setDoorPos(x,y,TileType.DOOR,new Door(false,15));
                    generated[x][y] = true;
                }

                if(y==4 && x==15 && generated[x][y] != true)
                {
                    dungeon.setDoorPos(x,y,TileType.DOOR,new Door(false,25));
                    generated[x][y] = true;
                }

                if(y==1 && x==2 && generated[x][y] != true)
                {
                    dungeon.setChestPos(x,y,TileType.CHEST,new Chest(false, 5, new Rapier(), new Cloak()));
                    generated[x][y] = true;
                }

                if(y==7 && x==4 && generated[x][y] != true)
                {
                    dungeon.setEquipmentPos(x,y,TileType.WEAPON,new Spear());
                    generated[x][y] = true;
                }

                if(y==3 && x==1 && generated[x][y] != true)
                {
                    dungeon.setArtifactPos(x,y,TileType.MAGICAL,new HealingPotion(3));
                    generated[x][y] = true;
                }


//              MAKE CHARACTERS
                if(x==2 && y ==11 && generated[x][y] != true) {
                    dungeon.setCharacterPos(x, y, TileType.PLAYER,players.get(0));
                    generated[x][y] = true;
                }
                if(x==3 && y ==11 && generated[x][y] != true) {
                    dungeon.setCharacterPos(x, y, TileType.PLAYER,players.get(1));
                    generated[x][y] = true;
                }
                if(x==2 && y ==12 && generated[x][y] != true) {
                    dungeon.setCharacterPos(x, y, TileType.PLAYER,players.get(2));
                    generated[x][y] = true;
                }
                if(x==3 && y ==12 && generated[x][y] != true) {
                    dungeon.setCharacterPos(x, y, TileType.PLAYER,players.get(3));
                    generated[x][y] = true;
                }
                //MAKE CHARACTERS

                //SET MONSTERS
                if(x==2 && y ==7 && generated[x][y] != true)
                {
                    Monster monster = new Monster(5, "Goblin", 14, 10, 8, 10, 8, new Hobbit(), 5, 15, new LeatherArmor(), true, ViewDirection.SOUTH, new Dagger());
                    dungeon.setCharacterPos(x,y,TileType.MONSTER,monster);
                    generated[x][y] = true;
                    monster.setxPosition(2);
                    monster.setyPosition(7);
                    monsters.add(monster);
                }
                if(x==3 && y ==4 && generated[x][y] != true)
                {
                    Monster monster2 = new Monster(5, "Goblin", 14, 10, 8, 10, 8, new Hobbit(), 5, 15, new LeatherArmor(), true, ViewDirection.SOUTH, new Dagger());
                    dungeon.setCharacterPos(x,y,TileType.MONSTER, monster2);
                    generated[x][y] = true;
                    monster2.setxPosition(3);
                    monster2.setyPosition(4);
                    monsters.add(monster2);
                }
                if(x==8 && y ==3 && generated[x][y] != true)
                {
                    Monster monster3 = new Monster(5, "Goblin", 14, 10, 8, 10, 8, new Hobbit(), 5, 15, new LeatherArmor(), true, ViewDirection.SOUTH, new Dagger());
                    dungeon.setCharacterPos(x,y,TileType.MONSTER,monster3);
                    generated[x][y] = true;
                    monster3.setxPosition(8);
                    monster3.setyPosition(3);
                    monsters.add(monster3);
                }
                if(x==10 && y ==5 && generated[x][y] != true)
                {
                    Monster monster4 = new Monster(5, "Goblin", 14, 10, 8, 10, 8, new Hobbit(), 5, 15, new LeatherArmor(), true, ViewDirection.SOUTH, new Dagger());
                    dungeon.setCharacterPos(x,y,TileType.MONSTER, monster4);
                    generated[x][y] = true;
                    monster4.setxPosition(10);
                    monster4.setyPosition(5);
                    monsters.add(monster4);
                }
                //SET MONSTERS
            }
        }
        mainFrame = new MainFrame(dungeon, gameController, players);
        return dungeon;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public Dungeon getDungeon() {
        return dungeon;
    }
}