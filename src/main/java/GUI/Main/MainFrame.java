package GUI.Main;

import battlemap.Dungeon.Dungeon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

    public MainFrame(Dungeon dungeon) throws IOException {
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
        generateStatusScreen();
        statusPanel.setActiveCharacter(1);
        generateDialogBox();
        generateContextMenu();


        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private void addTile(int x, int y, String path) throws IOException {
        File file = new File(path);
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        dungeonPanel.add(jLabel);
    }

    private void generateMap(Dungeon dungeon) throws IOException {
        for(int x = 0; x < dungeon.getxMax(); x++)
        {
            int posX = x*50;
            for (int y = 0; y < dungeon.getyMax(); y++)
            {
                int posY = y*50;
                if(dungeon.getTilePos(x,y) != null) {
                    switch (dungeon.getTilePos(x, y).getMetaData().getTileType()) {
                        case DOOR:
                            if (dungeon.getTilePos(x, y).getLockable().isLocked()) {
                                addTile(posX, posY, ".\\Graphics\\DoorTile_Locked.png");
                            } else if (dungeon.getTilePos(x, y).getMetaData().isPassable()) {
                                addTile(posX, posY, ".\\Graphics\\DoorTile_open.png");
                            } else {
                                addTile(posX, posY, ".\\Graphics\\DoorTile_closed.png");
                            }
                            break;
                        case CHEST:
                            break;
                        case WALL:
                            addTile(posX, posY, ".\\Graphics\\WallTile.png");
                            break;
                        default:
                            addTile(posX, posY, ".\\Graphics\\FloorTile.png");
                            break;
                    }
                }
                else if(dungeon.getCharacterPos(x,y) != null) {
                    switch (dungeon.getCharacterPos(x, y).getMetaData().getTileType()) {
                        case PLAYER:
                            addTile(posX, posY, ".\\Graphics\\fighter.png");
                            break;
                        case MONSTER:
                            addTile(posX, posY, ".\\Graphics\\monster_orc.png");
                            break;
                        default:
                            addTile(posX, posY, ".\\Graphics\\FloorTile.png");
                            break;
                    }
                }
                else if(dungeon.getEquipmentPos(x,y) != null) {

                }
                else if(dungeon.getArtifactPos(x,y) != null) {

                }
                else
                {
                    addTile(posX, posY, ".\\Graphics\\FloorTile.png");
                }
            }
        }
        jFrame.repaint();
    }

    private void generateStatusScreen() throws IOException {
        jFrame.add(statusPanel.generateStatusBackground());
        jFrame.repaint();
    }

    private void generateDialogBox() throws IOException {
        jFrame.add(dialogBox.generateDialogBox());
        jFrame.repaint();
    }

    private void generateContextMenu() throws IOException {
        jFrame.add(contextMenu.generateContextMenu());
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
                        contextMenu.displayTileType(dungeon.getTilePos(x, y).getMetaData().getTileType());
                        break;
                    case CHARACTERS:
                        contextMenu.displayTileType(dungeon.getCharacterPos(x, y).getMetaData().getTileType());
                        break;
                    case EQUIPMENT:
                        contextMenu.displayTileType(dungeon.getEquipmentPos(x, y).getMetaData().getTileType());
                        break;
                    case ARTIFACTS:
                        contextMenu.displayTileType(dungeon.getArtifactPos(x, y).getMetaData().getTileType());
                        break;
                    default:
                        contextMenu.displayTileType(null);
                        break;
                }
            }
        }
    }
}