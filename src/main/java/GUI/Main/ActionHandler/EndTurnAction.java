package GUI.Main.ActionHandler;

import GameController.GameController;
import battlemap.Dungeon.Dungeon;

import java.io.IOException;

public class EndTurnAction extends ActionOption
{
    public EndTurnAction(Dungeon dungeon, GameController gameController) {
        super(dungeon, gameController);
        this.actionName = "End Turn";
        this.actionEvent = "ENDTURN";
    }

    @Override
    public void executeAction( int x, int y) throws IOException {
        this.gameController.getRoundController().nextRound();
        this.gameController.getMap().getMainFrame().getStatusPanel().setActiveCharacter(gameController.getRoundController().getActivePlayer().getId());
    }
}
