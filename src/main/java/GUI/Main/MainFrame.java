package GUI.Main;

import Characters.Player;
import GameController.GameController;
import battlemap.Dungeon.Dungeon;
import battlemap.Meta.TileType;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainFrame {
    private JFrame jFrame = new JFrame();
    private JPanel dungeonPanel = new JPanel();
    private StatusFrame statusPanel = new StatusFrame();
    private DialogBox dialogBox = new DialogBox();
    private ContextMenu contextMenu = new ContextMenu();
    private Dungeon dungeon;

    private class MouseDetector extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e) {
            handleTileClick(e);
        }
    }

    private MouseDetector mouseClick = new MouseDetector();

    public MainFrame(Dungeon dungeon, GameController gameController, ArrayList<Player> players){
        jFrame.setLayout(null);
        jFrame.setSize(1920, 1080);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.repaint();
        dungeonPanel.setBounds(0,0, 1250, 750);
        dungeonPanel.addMouseListener(mouseClick);
        dungeonPanel.setLayout(null);
        jFrame.add(dungeonPanel);
        this.dungeon = dungeon;
        generateMap(this.dungeon);
        generateStatusScreen(players);
//        statusPanel.setActiveCharacter(1);
        generateDialogBox();
        generateContextMenu(this.dungeon, gameController);


        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private void addTile(int x, int y, String path) {
        File file = new File(path);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            DialogBox.ConsoleOut("Couldn't read file " + file);
        }
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        dungeonPanel.add(jLabel);
    }

    private void addRotTile(int x, int y, String path) throws IOException
    {
        File file = new File(path);
        BufferedImage bufferedImage = ImageIO.read(file);

        // The required drawing location
        int drawLocationX = x;
        int drawLocationY = y;

// Rotation information

        double rotationRequired = Math.toRadians (90);
        double locationX = bufferedImage.getWidth() / 2;
        double locationY = bufferedImage.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        ImageIcon imageIcon = new ImageIcon(op.filter(bufferedImage, null));
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        dungeonPanel.add(jLabel);
    }

    private void generateMap(Dungeon dungeon) {
        for(int x = 0; x < dungeon.getxMax(); x++)
        {
            int posX = x*50;
            for (int y = 0; y < dungeon.getyMax(); y++)
            {
                int posY = y*50;
                if(dungeon.getCharacterPos(x,y) != null) {
                    switch (dungeon.getCharacterPos(x, y).getMetaData().getTileType()) {
                        case PLAYER:
                            switch(dungeon.getCharacterPos(x, y).getCharacter().getClazzName())
                            {
                                case "Mage":
                                    addTile(posX, posY, ".\\Graphics\\mage.png");
                                    break;
                                case "Thief":
                                    addTile(posX, posY, ".\\Graphics\\thief.png");
                                    break;
                                case "Fighter":
                                    addTile(posX, posY, ".\\Graphics\\fighter.png");
                                    break;
                                default:
                                    addTile(posX, posY, ".\\Graphics\\fighter.png");
                                    break;
                            }
                            break;
                        case MONSTER:
                            addTile(posX, posY, ".\\Graphics\\monster_orc.png");
                            break;
                        default:
                            addTile(posX, posY, ".\\Graphics\\FloorTile.png");
                            break;
                    }
                }
                else if(dungeon.getTilePos(x,y) != null) {
                    switch (dungeon.getTilePos(x, y).getMetaData().getTileType()) {
                        case DOOR:
                            try{
                            if(dungeon.getTilePos(x, y-1).getMetaData().getTileType() == TileType.WALL)
                            {
                                if (dungeon.getTilePos(x, y).getDoor().isLocked()) {
                                    addRotTile(posX, posY, ".\\Graphics\\DoorTile_Locked.png");
                                } else if (dungeon.getTilePos(x, y).getMetaData().isPassable()) {
                                    addRotTile(posX, posY, ".\\Graphics\\DoorTile_open.png");
                                } else {
                                    addRotTile(posX, posY, ".\\Graphics\\DoorTile_closed.png");
                                }
                            }
                            else
                            {
                                if (dungeon.getTilePos(x, y).getDoor().isLocked()) {
                                    addTile(posX, posY, ".\\Graphics\\DoorTile_Locked.png");
                                } else if (dungeon.getTilePos(x, y).getMetaData().isPassable()) {
                                    addTile(posX, posY, ".\\Graphics\\DoorTile_open.png");
                                } else {
                                    addTile(posX, posY, ".\\Graphics\\DoorTile_closed.png");
                                }
                            }
                            } catch (Exception e )
                            {
                                if (dungeon.getTilePos(x, y).getDoor().isLocked()) {
                                    addTile(posX, posY, ".\\Graphics\\DoorTile_Locked.png");
                                } else if (dungeon.getTilePos(x, y).getMetaData().isPassable()) {
                                    addTile(posX, posY, ".\\Graphics\\DoorTile_open.png");
                                } else {
                                    addTile(posX, posY, ".\\Graphics\\DoorTile_closed.png");
                                }
                            }
                            break;
                        case CHEST:
                            if (dungeon.getTilePos(x, y).getChest().isLocked()) {
                                addTile(posX, posY, ".\\Graphics\\ChestTile_Locked.png");
                            } else if (dungeon.getTilePos(x, y).getChest().getArtifactLoot() == null && dungeon.getTilePos(x, y).getChest().getEquipmentLoot() == null) {
                                addTile(posX, posY, ".\\Graphics\\ChestTile_open.png");
                            } else {
                                addTile(posX, posY, ".\\Graphics\\ChestTile_closed.png");
                            }
                            break;
                        case WALL:
                            addTile(posX, posY, ".\\Graphics\\WallTile.png");
                            break;
                        default:
                            addTile(posX, posY, ".\\Graphics\\FloorTile.png");
                            break;
                    }
                }
                else if(dungeon.getEquipmentPos(x,y) != null) {
                    addTile(posX, posY, ".\\Graphics\\ItemTile.png");
                }
                else if(dungeon.getArtifactPos(x,y) != null) {
                    addTile(posX, posY, ".\\Graphics\\ArtifactTile.png");
                }
                else
                {
                    addTile(posX, posY, ".\\Graphics\\FloorTile.png");
                }
            }
        }
        jFrame.repaint();
    }

    private void generateStatusScreen(ArrayList<Player> players){
        jFrame.add(statusPanel.generateStatusBackground(players));
        jFrame.repaint();
    }

    private void generateDialogBox(){
        jFrame.add(dialogBox.generateDialogBox());
        jFrame.repaint();
    }

    private void generateContextMenu(Dungeon dungeon, GameController gameController){
        jFrame.add(contextMenu.generateContextMenu(dungeon, gameController));
        jFrame.repaint();
    }

    private void handleTileClick(MouseEvent e)
    {
        if(e.getX() < 1250 || e.getY() < 750) {
        if (e.getButton() == MouseEvent.BUTTON1)
        {
            int x = (e.getX() - e.getX()%50)/50;
            int y = (e.getY() - e.getY()%50)/50;
                switch (dungeon.fieldSearch(x, y)) {
                    case TILES:
                        contextMenu.displayTileType(dungeon.getTilePos(x, y).getMetaData().getTileType(),x,y);
                        break;
                    case CHARACTERS:
                        contextMenu.displayTileType(dungeon.getCharacterPos(x, y).getMetaData().getTileType(),x,y);
                        break;
                    case EQUIPMENT:
                        contextMenu.displayTileType(dungeon.getEquipmentPos(x, y).getMetaData().getTileType(),x,y);
                        break;
                    case ARTIFACTS:
                        contextMenu.displayTileType(dungeon.getArtifactPos(x, y).getMetaData().getTileType(),x,y);
                        break;
                    default:
                        contextMenu.displayTileType(null,x,y);
                        break;
                }
            }
        }
    }
}