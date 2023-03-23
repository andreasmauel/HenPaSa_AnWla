package GUI.Main.ActionHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionOption extends JMenuItem
{
    protected String actionName;
    protected String actionEvent;

    protected ButtonListener buttonListener = new ButtonListener();

    protected class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getActionCommand() == getActionEvent())
            {
                executeAction();
            }
        }
    }

    public ActionOption()
    {
        super();
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
    public void executeAction()
    {

    }

}
