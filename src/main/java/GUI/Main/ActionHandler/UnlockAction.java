package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class UnlockAction extends ActionOption
{
    public UnlockAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Pick-up";
        this.actionEvent = "PICKUP";
    }

    @Override
    public void executeAction( int x, int y)
    {
        //Get Player
        //get door
        //check for key
        //make roll to unlock
        //remove key
        //unlocked door
    }
}
