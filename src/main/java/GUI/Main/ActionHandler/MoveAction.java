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

                    int diffX = x-dungeon.getCharacterByEntity(character).getMetaData().getPosX();
                    int diffY = y-dungeon.getCharacterByEntity(character).getMetaData().getPosY();
                    if(diffX<0)
                        diffX*=-1;
                    if(diffY<0)
                        diffY*=-1;

                    int range =  diffX + diffY;

                    if(range <= character.getRemainingRange()) {
                        character.setRemainingRange(character.getRemainingRange() - range);
                        character.setxPosition(x);
                        character.setyPosition(y);
                        dungeon.transferCharacterPos(x, y, dungeon.getCharacterByEntity(character));
                        dungeon.getCharacterPos(x, y).getMetaData().setPosX(x);
                        dungeon.getCharacterPos(x, y).getMetaData().setPosY(y);
                        DialogBox.ConsoleOut("Shuffles to: " + x + " " + y);
                        mainFrame.generateMap(dungeon);
                    }
                    else
                    {
                        DialogBox.ConsoleOut("I can't walk this far");
                    }
                }
                else
                {
                    DialogBox.ConsoleOut("Error when moving, couldnt find character Position");
                }

            }
            else {
                DialogBox.ConsoleOut("There is something in the way!");
            }
        }
        else
        {
            DialogBox.ConsoleOut("I cant walk any further");
        }
    }
}
