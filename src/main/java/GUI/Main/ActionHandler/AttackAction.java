package GUI.Main.ActionHandler;

import GameController.FightController;
import GameController.GameController;
import GameController.RoundController;

public class AttackAction extends ActionOption {


    public AttackAction()
    {
        super();
        this.actionName = "Attack";
        this.actionEvent = "ATTACK";
    }

    @Override
    public void executeAction( String x, String y) {

    }
}
