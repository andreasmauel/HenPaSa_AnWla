package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class CloseAction extends ActionOption
{
    public CloseAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Close";
        this.actionEvent = "CLOSE";
    }

    @Override
    public void executeAction( int x, int y)
    {

    }
}
