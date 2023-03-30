package GUI.Main.ActionHandler;

import battlemap.Dungeon.Dungeon;

public class PickUpAction extends ActionOption
{
    public PickUpAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Pick-up";
        this.actionEvent = "PICKUP";
    }

    @Override
    public void executeAction( String x, String y)
    {

    }
}
