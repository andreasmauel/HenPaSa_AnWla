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
        //Get Player
        //get door
        //check for key
        //make roll to unlock
        //remove key
        //unlocked door

       // if(dungeon.isInRange(CurrentBoi, 1, x, y))
       // {
            //dungeon.getTilePos(x, y).open();
           // Player curBoi = new Player();
            // curBoi.arti

        //}
    }
}
