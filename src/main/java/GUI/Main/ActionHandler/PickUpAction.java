package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import battlemap.Dungeon.TileList;

public class PickUpAction extends ActionOption
{
    public PickUpAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
        this.actionName = "Pick-up";
        this.actionEvent = "PICKUP";
    }

    @Override
    public void executeAction( int x, int y)
    {
        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y)) {
            if(dungeon.fieldSearch(x,y) == TileList.ARTIFACTS)
            {

            }
            else if(dungeon.fieldSearch(x,y) == TileList.EQUIPMENT)
            {

            }
            mainFrame.generateMap(dungeon);
        }
        else {
            DialogBox.ConsoleOut("I cant reach that far!");
        }
    }
}
