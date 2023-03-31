package GUI.Main.ActionHandler;

import Characters.AbstractCharacter;
import Characters.Player;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class UnlockAction extends ActionOption
{
    public UnlockAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
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
