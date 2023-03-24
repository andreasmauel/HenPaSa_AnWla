package GUI.Main.ActionHandler;

import battlemap.Meta.TileType;

import java.util.ArrayList;

public class ActionHandler
{
    public ActionOption attack = new AttackAction();
    public ActionOption move = new MoveAction();
    public ActionOption pickup = new PickUpAction();
    public ActionOption open = new OpenAction();
    public ActionOption close = new CloseAction();
    public ActionOption unlock = new UnlockAction();
    public ActionOption endTurn = new EndTurnAction();

    public ArrayList<ActionOption> getOptions(TileType tileType)
    {
        ArrayList<ActionOption> aO = new ArrayList<ActionOption>();
        if (tileType == TileType.PLAYER || tileType == TileType.MONSTER)
        {
            aO.add(attack);
            aO.add(endTurn);

        } else if (tileType == TileType.DOOR || tileType == TileType.CHEST)
        {
            aO.add(attack);
            aO.add(move);
            aO.add(open);
            aO.add(close);
            aO.add(unlock);
            aO.add(endTurn);

        } else if (tileType == TileType.POTION || tileType == TileType.ARMOR || tileType == TileType.WEAPON || tileType == TileType.MAGICAL)
        {
            aO.add(attack);
            aO.add(move);
            aO.add(pickup);
            aO.add(endTurn);

        } else if (tileType == TileType.WALL)
        {
            aO.add(attack);
            aO.add(endTurn);

        } else
        {
            aO.add(move);
            aO.add(endTurn);
        }
        return aO;
    }

}
