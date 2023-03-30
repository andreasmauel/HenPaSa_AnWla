package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

public class MoveAction extends ActionOption
{
    public MoveAction(Dungeon dungeon, GameController gameController)
    {
        super(dungeon, gameController);
        this.actionName = "Move";
        this.actionEvent = "MOVE";
    }

    @Override
    public void executeAction( int x, int y)
    {
        this.gameController.getRoundController().getActivePlayer();
        DialogBox.ConsoleOut("Shuffles to: " +x+" "+y);
    }
}
