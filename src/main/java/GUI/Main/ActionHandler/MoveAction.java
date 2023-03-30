package GUI.Main.ActionHandler;

import Characters.Player;
import GUI.Main.CharacterPanel;
import GUI.Main.DialogBox;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import util.DistanceCalculator;

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
        Player character = this.gameController.getRoundController().getActivePlayer();
        if(character.getRemainingRange() > 0) {
            boolean isInRange = dungeon.isInRange(character, character.getWalkingrange(), x, y);
            if(isInRange) {
                character.setxPosition(x);
                character.setyPosition(y);
                //MOVE BILD

                character.setRemainingRange(character.getRemainingRange() - 0); //GEGANGENE RANGE MUSS NOCH ANGEGEBEN WERDEN

            }
            DialogBox.ConsoleOut("Shuffles to: " + x + " " + y);
        }
    }
}
