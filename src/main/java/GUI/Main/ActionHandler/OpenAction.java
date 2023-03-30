package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class OpenAction extends ActionOption
{
    public OpenAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
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
