package GUI.Main.ActionHandler;

import battlemap.Dungeon.Dungeon;

public class OpenAction extends ActionOption
{
    public OpenAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Open";
        this.actionEvent = "OPEN";
    }

    @Override
    public void executeAction( String x, String y)
    {
        //get player
        //get openable
        // open
    }
}
