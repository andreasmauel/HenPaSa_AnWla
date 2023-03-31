package GUI.Main.ActionHandler;

import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ActionOption
{
    protected String actionName = "Action";
    protected String actionEvent = "NULL";

    protected Dungeon dungeon;
    protected GameController gameController;
    protected MainFrame mainFrame;

    protected ButtonListener buttonListener = new ButtonListener();

    protected class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String event = e.getActionCommand();
            String[] command = event.split(",");
            if(command[0].equals(getActionEvent()))
            {
                int x = Integer.parseInt(command[1]);
                int y = Integer.parseInt(command[2]);
                try {
                    executeAction(x, y);
                } catch (Exception exception) {
                    System.out.println("HEY FEHLER HIER!!!!!!!!!");
                }

            }
        }
    }

    public ActionOption(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        this.dungeon = dungeon;
        this.gameController = gameController;
        this.mainFrame = mainframe;
    }

    @Override
    public String toString() {
        return actionName;
    }

    public String getActionName()
    {
        return actionName;
    }
    public String getActionEvent()
    {
        return actionEvent;
    }

    public ButtonListener getButtonListener()
    {
        return buttonListener;
    }
    public void executeAction(int x, int y) throws IOException {

    }

}
