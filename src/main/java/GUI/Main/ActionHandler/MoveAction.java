package GUI.Main.ActionHandler;

import Characters.Player;
import GUI.Main.DialogBox;

import GameController.RoundController;
import battlemap.Dungeon.Dungeon;

public class MoveAction extends ActionOption
{
    public MoveAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Move";
        this.actionEvent = "MOVE";
    }

    public void executeAction(Player player, int x, int y) {

        DialogBox.ConsoleOut("Shuffles to: " +x+" "+y);
    }
}
