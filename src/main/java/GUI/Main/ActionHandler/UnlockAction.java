package GUI.Main.ActionHandler;

import Characters.AbstractCharacter;
import Characters.Player;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class UnlockAction extends ActionOption
{
    public UnlockAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Unlock";
        this.actionEvent = "UNLOCK";
    }

    @Override
    public void executeAction( int x, int y)
    {

        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y))
        {

        }
    }
}
