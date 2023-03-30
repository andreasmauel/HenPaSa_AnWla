package GUI.Main.ActionHandler;

import battlemap.Dungeon.Dungeon;

public class UnlockAction extends ActionOption
{
    public UnlockAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Pick-up";
        this.actionEvent = "PICKUP";
    }

    @Override
    public void executeAction( String x, String y)
    {
        //Get Player
        //get door
        //check for key
        //make roll to unlock
        //remove key
        //unlocked door
    }
}
