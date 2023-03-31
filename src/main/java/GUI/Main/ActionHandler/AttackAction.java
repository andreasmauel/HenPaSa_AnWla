package GUI.Main.ActionHandler;

import Characters.AbstractCharacter;
import Characters.Monster;
import Characters.Player;
import GUI.Main.DialogBox;
import GUI.Main.MainFrame;
import GameController.GameController;
import GameController.RoundController;
import battlemap.Dungeon.Dungeon;

public class AttackAction extends ActionOption
{
    public AttackAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
        this.actionName = "Attack";
        this.actionEvent = "ATTACK";
    }

    @Override
    public void executeAction( int x, int y)
    {
        AbstractCharacter enemy = dungeon.getCharacterPos(x,y).getCharacter();
        Player character = this.gameController.getRoundController().getActivePlayer();
        if(dungeon.isInRange(character, character.getCurrentWeapon().getRange(), x, y)) {
            int damage = character.attack(enemy);
            DialogBox.ConsoleOut(enemy.getName() + " takes " + damage + " damage.");
            return;
        }
        DialogBox.ConsoleOut("Enemy is out of range");
        //TODO
    }
}
