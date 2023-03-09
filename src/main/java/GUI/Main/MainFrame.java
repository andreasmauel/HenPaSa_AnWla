package GUI.Main;

import battlemap.Dungeon.Dungeon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    private JFrame jFrame = new JFrame();
    private JPanel dungeonPanel = new JPanel();
    private StatusFrame statusPanel = new StatusFrame();
    private DialogBox dialogBox = new DialogBox();

    public MainFrame()
    {
        jFrame.setLayout(null);
        jFrame.setSize(1920, 1080);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.repaint();
    }

    private void addTile(int x, int y, String path) throws IOException {
        File file = new File(path);
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        jFrame.add(jLabel);
    }

    public void generateMap(Dungeon dungeon) throws IOException {
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
                                addTile(posX, posY, "H:\\Graphics\\DoorTile_Locked.png");
                            } else if (dungeon.getTilePos(x, y).getMetaData().isPassable()) {
                                addTile(posX, posY, "H:\\Graphics\\DoorTile_open.png");
                            } else {
                                addTile(posX, posY, "H:\\Graphics\\DoorTile_closed.png");
                            }
                            break;
                        case CHEST:
                            break;
                        case WALL:
                            addTile(posX, posY, "H:\\Graphics\\WallTile.png");
                            break;
                        default:
                            addTile(posX, posY, "H:\\Graphics\\FloorTile.png");
                            break;
                    }
                }
                else
                {
                    addTile(posX, posY, "H:\\Graphics\\FloorTile.png");
                }
                if(dungeon.getEquipmentPos(x,y) != null) {

                }
                if(dungeon.getArtifactPos(x,y) != null) {

                }
                if(dungeon.getCharacterPos(x,y) != null) {

                }
            }
        }
        jFrame.repaint();
    }

    public void generateStatusScreen() throws IOException {
        jFrame.add(statusPanel.generateStatusBackground());
        jFrame.repaint();
    }

    public void generateDialogBox() throws IOException {
        jFrame.add(dialogBox.generateDialogBox());
        jFrame.repaint();
    }
}