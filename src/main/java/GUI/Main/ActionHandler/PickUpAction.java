package GUI.Main.ActionHandler;

import GUI.Main.DialogBox;
import GUI.Main.MainFrame;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import battlemap.Dungeon.TileList;
import battlemap.Meta.TileType;
import equipment.armor.Armor;
import equipment.weapon.Weapon;

public class PickUpAction extends ActionOption
{
    public PickUpAction(Dungeon dungeon, GameController gameController, MainFrame mainframe)
    {
        super(dungeon, gameController, mainframe);
        this.actionName = "Pick-up";
        this.actionEvent = "PICKUP";
    }

    @Override
    public void executeAction( int x, int y)
    {
        if(dungeon.isInRange(this.gameController.getRoundController().getActivePlayer(), 1, x, y)) {
            if(dungeon.fieldSearch(x,y) == TileList.ARTIFACTS)
            {
                if(this.gameController.getRoundController().getActivePlayer().getArtifact().size() == 0) {
                    this.gameController.getRoundController().getActivePlayer().setCurrentArtifact(dungeon.getArtifactPos(x,y).getArtifact());
                }
                this.gameController.getRoundController().getActivePlayer().addArtifact(dungeon.getArtifactPos(x,y).getArtifact());

                DialogBox.ConsoleOut("You picked up a: "+dungeon.getArtifactPos(x,y).getArtifact().getClass().getSimpleName());
                dungeon.deleteArtifactPos(x,y);
            }
            else if(dungeon.fieldSearch(x,y) == TileList.EQUIPMENT)
            {
                if(dungeon.getEquipmentPos(x,y).getMetaData().getTileType() == TileType.WEAPON)
                {
                    this.gameController.getRoundController().getActivePlayer().addWeapons((Weapon) dungeon.getEquipmentPos(x,y).getEquipment());
                } else if (dungeon.getEquipmentPos(x,y).getMetaData().getTileType() == TileType.ARMOR) {
                    this.gameController.getRoundController().getActivePlayer().addArmor((Armor) dungeon.getEquipmentPos(x, y).getEquipment());
                }
                DialogBox.ConsoleOut("You picked up a: "+dungeon.getEquipmentPos(x,y).getEquipment().getName());
                dungeon.deleteEquipmentPos(x,y);
            }
            mainFrame.generateMap(dungeon);
        }
        else {
            DialogBox.ConsoleOut("I cant reach that far!");
        }
    }
}
