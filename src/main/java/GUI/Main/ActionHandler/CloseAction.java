package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;
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
        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y)) {
            dungeon.getTilePos(x, y).close();
            mainFrame.generateMap(dungeon);
        }
        else
            DialogBox.ConsoleOut("Das ist zu weit weg!");
    }
}
