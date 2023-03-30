package battlemap.MapGeneration;

import Characters.Monster;
import Characters.Player;
import Characters.Races.Hobbit;
import Characters.Races.Human;
import Characters.ViewDirection;
import Characters.classes.Fighter;
import Characters.classes.FightingStyle;
import Characters.classes.Mage;
import Characters.classes.Thief;
import GUI.Main.MainFrame;
import battlemap.Dungeon.Dungeon;
import battlemap.Lockables.Door;
import battlemap.Meta.TileType;
import equipment.armor.ChainMail;
import equipment.armor.LeatherArmor;
import equipment.weapon.BattleAxe;
import util.Attribute;

import java.io.IOException;
import java.util.ArrayList;

public class NoviceDungeon
{
    private Dungeon dungeon;
    private MainFrame mainFrame;

    public static void main(String[] args) throws IOException {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player("Ben",16,10,12,14,0,new Human(),5,10,new ChainMail(), false, ViewDirection.NORTH, null, new Fighter(10, Attribute.STRENGTH, Attribute.DEXTERITY, new ArrayList<Attribute>(), new BattleAxe(), FightingStyle.CLOSECOMBAT)));
        players.add(new Player("Lisa",16,10,12,14,0,new Human(),5,10,new ChainMail(), false, ViewDirection.NORTH, null, new Mage(10, Attribute.STRENGTH, Attribute.DEXTERITY, new ArrayList<Attribute>())));
        players.add(new Player("Tim",16,10,12,14,0,new Human(),5,10,new ChainMail(), false, ViewDirection.NORTH, null, new Thief(10, Attribute.STRENGTH, Attribute.DEXTERITY, new ArrayList<Attribute>())));
        players.add(new Player("Brian",16,10,12,14,0,new Human(),5,10,new ChainMail(), false, ViewDirection.NORTH, null, new Fighter(10, Attribute.STRENGTH, Attribute.DEXTERITY, new ArrayList<Attribute>(), new BattleAxe(), FightingStyle.CLOSECOMBAT)));
        NoviceDungeon map = new NoviceDungeon();
        map.createMap(players);
    }

    public NoviceDungeon(){
    }

    public Dungeon createMap(ArrayList<Player> players)
    {
        dungeon = new Dungeon(25, 15, "Novice Dungeon");
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
                    //dungeon.setChestPos(x,y,TileType.CHEST,new Chest(false, 5, new Equipment(), new Artifact()));
                    generated[x][y] = true;
                }

                if(y==7 && x==4 && generated[x][y] != true)
                {
                    //dungeon.setEquipmentPos(x,y,TileType.WEAPON,new Equipment());
                    generated[x][y] = true;
                }

                if(y==3 && x==1 && generated[x][y] != true)
                {
                    //dungeon.setArtifactPos(x,y,TileType.MAGICAL,new Artifact());
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
                    dungeon.setCharacterPos(x,y,TileType.MONSTER,new Monster("Goblin", 14, 10, 8, 10, 8, new Hobbit(), 5, 15, new LeatherArmor(), true, ViewDirection.SOUTH, null));
                    generated[x][y] = true;
                }
                //SET MONSTERS
            }
        }
        mainFrame = new MainFrame(dungeon);
        return dungeon;
    }
}