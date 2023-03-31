package GUI.Main.ActionHandler;

import Characters.AbstractCharacter;
import Characters.Player;
import GUI.Main.DialogBox;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import battlemap.Meta.TileType;

public class UnlockAction extends ActionOption
{
    public UnlockAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
        this.actionName = "Unlock";
        this.actionEvent = "UNLOCK";
    }

    @Override
    public void executeAction( int x, int y)
    {

        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y))
        {
            if(dungeon.getTilePos(x,y).getMetaData().getTileType()== TileType.DOOR)
                if(dungeon.getTilePos(x,y).getDoor().isLocked()) {
                    dungeon.getTilePos(x, y).getDoor().unlock(gameController.getDices().get("twenty").rollDice());
                }
            else {
                    DialogBox.ConsoleOut("Its already unlocked");
                }
            if(dungeon.getTilePos(x,y).getMetaData().getTileType()== TileType.CHEST)
                if(dungeon.getTilePos(x,y).getChest().isLocked()) {
                    dungeon.getTilePos(x, y).getChest().unlock(gameController.getDices().get("twenty").rollDice());
                }
                else {
                    DialogBox.ConsoleOut("Its already unlocked");
                }
        }
        else
            DialogBox.ConsoleOut("Its too far away!");
    }
}
