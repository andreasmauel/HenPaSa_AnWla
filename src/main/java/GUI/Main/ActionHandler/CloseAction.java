package GUI.Main.ActionHandler;

import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class CloseAction extends ActionOption
{
    public CloseAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
        this.actionName = "Close";
        this.actionEvent = "CLOSE";
    }

    @Override
    public void executeAction( int x, int y)
    {

    }
}
