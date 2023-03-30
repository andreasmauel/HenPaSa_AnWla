package GUI.Main.ActionHandler;

import battlemap.Dungeon.Dungeon;

public class CloseAction extends ActionOption
{
    public CloseAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Close";
        this.actionEvent = "CLOSE";
    }

    @Override
    public void executeAction( int x, int y)
    {

    }
}
