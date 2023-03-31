package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class OpenAction extends ActionOption
{
    public OpenAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
        this.actionName = "Open";
        this.actionEvent = "OPEN";
    }

    @Override
    public void executeAction( int x, int y)
    {
        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y)) {
            dungeon.getTilePos(x, y).open();
            mainFrame.generateMap(dungeon);
        }
        else
            DialogBox.ConsoleOut("Its too far away!");
    }
}
