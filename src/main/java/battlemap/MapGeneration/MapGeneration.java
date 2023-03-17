package battlemap.MapGeneration;

import Characters.AbstractCharacter;
import GUI.Main.MainFrame;
import battlemap.Dungeon.Dungeon;
import battlemap.Meta.TileType;

import java.io.IOException;

public class MapGeneration
{
    private Dungeon dungeon;
    private MainFrame mainFrame;

    public static void main(String[] args) throws IOException {
        MapGeneration map = new MapGeneration();
    }

    public MapGeneration() throws IOException {
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


                if(x==2 && y ==11 && generated[x][y] != true)
                {
                    // dungeon.setCharacterPos(x,y,TileType.PLAYER,new AbstractCharacter());
                    generated[x][y] = true;
                }
                if(x==2 && y ==7 && generated[x][y] != true)
                {
                    // dungeon.setCharacterPos(x,y,TileType.MONSTER,new AbstractCharacter());
                    generated[x][y] = true;
                }
            }
        }

        mainFrame = new MainFrame(dungeon);
    }
}
