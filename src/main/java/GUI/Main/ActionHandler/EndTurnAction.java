package GUI.Main.ActionHandler;

import GUI.Main.MainFrame;
import GUI.Main.DialogBox;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

import java.io.IOException;

public class EndTurnAction extends ActionOption
{
    public EndTurnAction(Dungeon dungeon, GameController gameController, MainFrame mainframe) {
        super(dungeon, gameController, mainframe);
        this.actionName = "End Turn";
        this.actionEvent = "ENDTURN";
    }

    @Override
    public void executeAction( int x, int y) {
        this.gameController.getRoundController().getActivePlayer().setRemainingWalkingRange(gameController.getRoundController().getActivePlayer().getWalkingrange());
        int nextPlayer = this.gameController.getRoundController().nextRound();
        this.mainFrame.getStatusPanel().setActiveCharacter(nextPlayer);
        DialogBox.ConsoleOut("Spieler " + gameController.getRoundController().getActivePlayer().getId() + " ist am Zug");
    }
}
