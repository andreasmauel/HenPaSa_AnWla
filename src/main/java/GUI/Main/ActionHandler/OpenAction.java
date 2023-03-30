package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class OpenAction extends ActionOption
{
    public OpenAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Open";
        this.actionEvent = "OPEN";
    }

    @Override
    public void executeAction( int x, int y)
    {
        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y))
            dungeon.getTilePos(x,y).open();
        else
            DialogBox.ConsoleOut("Das ist zu weit weg!");
    }
}
