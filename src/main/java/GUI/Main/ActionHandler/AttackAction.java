package GUI.Main.ActionHandler;

import GameController.GameController;
import GameController.RoundController;
import battlemap.Dungeon.Dungeon;

public class AttackAction extends ActionOption
{
    public AttackAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Attack";
        this.actionEvent = "ATTACK";
    }

    @Override
    public void executeAction( int x, int y)
    {
    }
}
