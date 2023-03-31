package GUI.Main.ActionHandler;

import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

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

    }
}
