package GUI.Main.ActionHandler;

import GUI.Main.MainFrame;
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

    public ActionHandler(Dungeon dungeon, GameController gameController, MainFrame mainFrame)
    {
        attack = new AttackAction(dungeon, gameController, mainFrame);
        move = new MoveAction(dungeon, gameController, mainFrame);
        pickup = new PickUpAction(dungeon, gameController, mainFrame);
        open = new OpenAction(dungeon, gameController, mainFrame);
        close = new CloseAction(dungeon, gameController, mainFrame);
        unlock = new UnlockAction(dungeon, gameController, mainFrame);
        endTurn = new EndTurnAction(dungeon, gameController, mainFrame);
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
            aO.add(move);
            aO.add(open);
            aO.add(close);
            aO.add(unlock);
            aO.add(endTurn);

        } else if (tileType == TileType.POTION || tileType == TileType.ARMOR || tileType == TileType.WEAPON || tileType == TileType.MAGICAL)
        {
            aO.add(move);
            aO.add(pickup);
            aO.add(endTurn);

        } else if (tileType == TileType.WALL)
        {
            aO.add(endTurn);

        } else
        {
            aO.add(move);
            aO.add(endTurn);
        }
        return aO;
    }

}
