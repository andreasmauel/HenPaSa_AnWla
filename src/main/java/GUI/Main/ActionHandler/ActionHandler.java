package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import battlemap.Meta.TileType;

import java.util.ArrayList;

public class ActionHandler
{
    public ActionOption attack;
    public ActionOption move;
    public ActionOption pickup;
    public ActionOption open;
    public ActionOption close;
    public ActionOption unlock;
    public ActionOption endTurn;

    public ActionHandler(Dungeon dungeon, GameController gameController)
    {
        attack = new AttackAction(dungeon, gameController);
        move = new MoveAction(dungeon, gameController);
        pickup = new PickUpAction(dungeon, gameController);
        open = new OpenAction(dungeon, gameController);
        close = new CloseAction(dungeon, gameController);
        unlock = new UnlockAction(dungeon, gameController);
        endTurn = new EndTurnAction(dungeon, gameController);
    }

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
