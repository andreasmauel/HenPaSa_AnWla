package battlemap.Dungeon;

import Artifact.Artifact;
import battlemap.AbstractPositions.ArtifactPos;
import battlemap.AbstractPositions.CharacterPos;
import battlemap.AbstractPositions.EquipmentPos;
import battlemap.AbstractPositions.TilePos;
import battlemap.Lockables.Chest;
import battlemap.Lockables.Door;
import battlemap.Meta.TileType;
import battlemap.Positions.*;
import equipment.Equipment;

public class Dungeon
{
    private TilePos[][] tiles;
    private CharacterPos[][] characters;
    private EquipmentPos[][] equipment;
    private ArtifactPos[][] artifacts;
    private String name;
    private int xMax;
    private int yMax;

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

        if (xMax > 25)
            this.xMax=25;
        else if (xMax<10)
        {
            this.xMax = 10;
        }

        if (yMax > 15)
            this.yMax=15;
        else if (yMax<10)
        {
            this.yMax  =10;
        }
            tiles = new TilePos[this.xMax][this.yMax];
            characters = new CharacterPos[this.xMax][this.yMax];
            equipment = new EquipmentPos[this.xMax][this.yMax];
            artifacts = new ArtifactPos[this.xMax][this.yMax];
    }

    public void transferTilePos(int x, int y, TilePos tile)
    {
        tiles[x][y] = tile;
    }

    public void setDoorPos(int x, int y, TileType type, Door door)
    {
        switch(type)
        {
            case DOOR:
                tiles[x][y] = new DoorPos(x,y,door);
                break;
            default:
                tiles[x][y] = null;
                break;
        }
    }

    public void setChestPos(int x, int y, TileType type, Chest chest)
    {
        switch(type)
        {
            case CHEST:
                tiles[x][y] = new ChestPos(x,y,chest);
                break;
            default:
                tiles[x][y] = null;
                break;
        }
    }

    public void setStructurePos(int x, int y, TileType type)
    {
        switch(type)
        {
            case WALL:
                tiles[x][y] = new WallPos(x,y);
                break;
            default:
                tiles[x][y] = null;
                break;
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

    public void transferCharacterPos(int x, int y, CharacterPos character)
    {
        characters[x][y] = character;
    }

    public void setCharacterPos(int x, int y, TileType type, AbstractCharacter character)
    {
        switch(type)
        {
            case PLAYER:
                characters[x][y] = new PlayerPos(x,y,character);
                break;
            case MONSTER:
                characters[x][y] = new MonsterPos(x,y,character);
                break;
            default:
                characters[x][y] = null;
                break;
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

    public void setEquipmentPos(int x, int y, TileType type, Equipment equipment)
    {
        switch(type)
        {
            case ARMOR:
                this.equipment[x][y] = new ArmorPos(x,y,equipment);
                break;
            case WEAPON:
                this.equipment[x][y] = new WeaponPos(x,y,equipment);
                break;
            default:
                this.equipment[x][y] = null;
                break;
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

    public void setArtifactPos(int x, int y, TileType type, Artifact artifact)
    {
        switch(type)
        {
            case MAGICAL:
                artifacts[x][y] = new MagicalPos(x,y,artifact);
                break;
            case POTION:
                artifacts[x][y] = new PotionPos(x,y,artifact);
                break;
            default:
                artifacts[x][y] = null;
                break;
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

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }
}
