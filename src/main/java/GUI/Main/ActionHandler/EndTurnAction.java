package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class EndTurnAction extends ActionOption
{
    public EndTurnAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "End Turn";
        this.actionEvent = "ENDTURN";
    }

    @Override
    public void executeAction( int x, int y)
    {

    }
}
