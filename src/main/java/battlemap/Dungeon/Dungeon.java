package battlemap.Dungeon;

import battlemap.AbstractPositions.ArtifactPos;
import battlemap.AbstractPositions.CharacterPos;
import battlemap.AbstractPositions.EquipmentPos;
import battlemap.AbstractPositions.TilePos;

public class Dungeon
{
    private TilePos[][] tiles;
    private CharacterPos[][] characters;
    private EquipmentPos[][] equipment;
    private ArtifactPos[][] artifacts;
    private String name;

    public Dungeon(int xMax, int yMax, String name)
    {
        if(name.isBlank())
        {
            this.name = "Dungeon of Dragons";
        }
        else
        {
            this.name = name;
        }


        if(xMax>10 && yMax>10)
        {
            tiles = new TilePos[xMax][yMax];
            characters = new CharacterPos[xMax][yMax];
            equipment = new EquipmentPos[xMax][yMax];
            artifacts = new ArtifactPos[xMax][yMax];
        }
        else
        {
            tiles = new TilePos[10][10];
            characters = new CharacterPos[10][10];
            equipment = new EquipmentPos[10][10];
            artifacts = new ArtifactPos[10][10];
        }
    }

    public TilePos getTilePos(int x, int y)
    {
        try
        {
            return tiles[x][y];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public CharacterPos getCharacterPos(int x, int y)
    {
        try
        {
            return characters[x][y];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public EquipmentPos getEquipmentPos(int x, int y)
    {
        try
        {
            return equipment[x][y];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public ArtifactPos getArtifactPos(int x, int y)
    {
        try
        {
            return artifacts[x][y];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public String getName()
    {
        return name;
    }
}
