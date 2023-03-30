package GUI.Main.ActionHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionOption
{
    protected String actionName = "Action";
    protected String actionEvent = "NULL";

    protected ButtonListener buttonListener = new ButtonListener();

    protected class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String event = e.getActionCommand();
            String[] command = event.split(",");
            if(command[0].equals(getActionEvent()))
            {
                executeAction(command[1], command[2]);
            }
        }
    }

    public ActionOption()
    {

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
    public void executeAction( String x, String y)
    {

    }

}
