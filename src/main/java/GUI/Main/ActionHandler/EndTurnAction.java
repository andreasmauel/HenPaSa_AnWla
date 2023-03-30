package GUI.Main.ActionHandler;

import battlemap.Dungeon.Dungeon;

public class EndTurnAction extends ActionOption
{
    public EndTurnAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "End Turn";
        this.actionEvent = "ENDTURN";
    }

    @Override
    public void executeAction( String x, String y)
    {

    }
}
