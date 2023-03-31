package GUI.Main.ActionHandler;

import Characters.Player;
import GUI.Main.CharacterPanel;
import GUI.Main.DialogBox;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import util.DistanceCalculator;

public class MoveAction extends ActionOption
{
    public MoveAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
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
                if(dungeon.getCharacterByEntity(character) != null) {
                    character.setxPosition(x);
                    character.setyPosition(y);
                    dungeon.transferCharacterPos(x, y, dungeon.getCharacterByEntity(character));

                    dungeon.deleteCharacterPos(dungeon.getCharacterByEntity(character).getMetaData().getPosX(),
                                               dungeon.getCharacterByEntity(character).getMetaData().getPosY());

                    character.setRemainingRange(character.getRemainingRange() - 0); //GEGANGENE RANGE MUSS NOCH ANGEGEBEN WERDEN
                    DialogBox.ConsoleOut("Shuffles to: " + x + " " + y);
                    mainFrame.generateMap(dungeon);
                }
                else
                {
                    DialogBox.ConsoleOut("Error when moving, couldnt find character Position");
                }

            }
        }
    }
}
