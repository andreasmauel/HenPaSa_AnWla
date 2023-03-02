package battlemap.Meta;

public class MetaData
{
    private boolean isPassable;
    private boolean isVisible;
    private TileType tileType;
    private int posX;
    private int posY;

    public MetaData(int posX, int posY, TileType tileType, boolean isPassable, boolean isVisible)
    {
        this.posX = posX;
        this.posY = posY;
        this.tileType = tileType;
        this.isPassable = isPassable;
        this.isVisible = isVisible;
    }

    public int getPosX()
    {
        return posX;
    }

    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public int getPosY()
    {
        return posY;
    }

    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public TileType getTileType()
    {
        return tileType;
    }

    public void setTileType(TileType tileType)
    {
        this.tileType = tileType;
    }

    public boolean isPassable()
    {
        return isPassable;
    }

    public void setPassable(boolean passable)
    {
        isPassable = passable;
    }

    public boolean isVisible()
    {
        return isVisible;
    }

    public void setVisible(boolean visible)
    {
        isVisible = visible;
    }
}
