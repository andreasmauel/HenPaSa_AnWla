package GUI.Main.ActionHandler;

import Characters.Monster;
import Characters.Player;
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
        //WELCHER GEGENER STEHET AUF DEM FELD
        Player character = this.gameController.getRoundController().getActivePlayer();
        if(dungeon.isInRange(character, character.getCurrentWeapon().getRange(), x, y)) {
            character.attack(null);
        }
        //TODO
    }
}
