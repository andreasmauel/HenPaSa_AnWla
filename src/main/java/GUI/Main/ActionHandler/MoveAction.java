package GUI.Main.ActionHandler;

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
    {
        //DialogBox.ConsoleOut("Shuffles to: " +x+" "+y);
    }
}
