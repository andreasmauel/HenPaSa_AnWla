package GUI.Main.ActionHandler;

import Main.DialogBox;

public class MoveAction extends ActionOption
{
    public MoveAction()
    {
        super();
        this.actionName = "Move";
        this.actionEvent = "MOVE";
    }

    @Override
    public void executeAction( String x, String y)
    {
        DialogBox.ConsoleOut("Shuffles to: " +x+" "+y);
    }
}
