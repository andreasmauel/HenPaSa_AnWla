package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;


public class MoveAction extends ActionOption
{
    public MoveAction()
    {
        super();
        this.actionName = "Move";
        this.actionEvent = "MOVE";
    }

    @Override
    public static void executeAction(String x, String y)
    {
        DialogBox.ConsoleOut("Shuffles to: " +x+" "+y);
    }
}
