package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;

import battlemap.Dungeon.Dungeon;

public class MoveAction extends ActionOption
{
    public MoveAction(Dungeon dungeon)
    {
        super(dungeon);
        this.actionName = "Move";
        this.actionEvent = "MOVE";
    }

    @Override
    public void executeAction( int x, int y)
    public static void executeAction(String x, String y)
    {
        //DialogBox.ConsoleOut("Shuffles to: " +x+" "+y);
    }
}
