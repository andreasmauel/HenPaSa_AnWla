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
    public void executeAction( int x, int y)
    {

        //get player
        //dungeon.getCharacterByEntity(CurrentBoi);

        //get openable

        // open
    }
}
