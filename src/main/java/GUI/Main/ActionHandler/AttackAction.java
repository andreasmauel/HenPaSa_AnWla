package GUI.Main.ActionHandler;

import GameController.FightController;
import GameController.GameController;
import GameController.RoundController;

public class AttackAction extends ActionOption {


    public AttackAction()
import battlemap.Dungeon.Dungeon;

public class AttackAction extends ActionOption
{
    public AttackAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Attack";
        this.actionEvent = "ATTACK";
    }

    @Override
    public void executeAction( String x, String y) {
    public void executeAction( int x, int y)
    {

    }
}
