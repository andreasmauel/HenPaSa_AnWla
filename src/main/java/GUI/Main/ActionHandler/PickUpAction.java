package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class PickUpAction extends ActionOption
{
    public PickUpAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Pick-up";
        this.actionEvent = "PICKUP";
    }

    @Override
    public void executeAction( int x, int y)
    {

    }
}
