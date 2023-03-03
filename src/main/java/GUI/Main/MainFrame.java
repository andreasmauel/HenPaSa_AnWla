package GUI.Main;

import battlemap.Dungeon.Dungeon;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainFrame {
    public static JFrame jFrame = new JFrame();

    public static void main(String[] args) throws IOException {
        jFrame.setLayout(null);
        jFrame.setSize(1315, 789);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int x=0; x<=1250; x+=50)
        {
            for(int y=0; y<=700; y+=50)
            {
                if(x==0 || y ==0 || x== 1250 || y== 700)
                {
                    addTile(x,y,"H:\\Pictures\\WallTile.png");
                }else
                {
                    addTile(x,y,"H:\\Pictures\\FloorTile.png");
                }

            }
        }
        jFrame.repaint();
    }

    public static void addTile(int x, int y, String path) throws IOException {
        File file = new File(path);
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        jFrame.add(jLabel);
    }

    public static void generateMap(Dungeon dungeon) throws IOException {
        for(int x = 0; x <= dungeon.getxMax(); x++)
        {
            int posX = x*50;
            for (int y = 0; y <= dungeon.getyMax(); y++)
            {
                int posY = y*50;
                switch (dungeon.getTilePos(x,y).getMetaData().getTileType())
                {
                    case DOOR:
                        if(dungeon.getTilePos(x,y).getLockable().isLocked())
                        {
                            addTile(posX,posY,"H:\\Pictures\\DoorTile_Locked.png");
                        }
                        else if(dungeon.getTilePos(x,y).getMetaData().isPassable())
                        {
                            addTile(posX,posY,"H:\\Pictures\\DoorTile_open.png");
                        }
                        else
                        {
                            addTile(posX,posY,"H:\\Pictures\\DoorTile_closed.png");
                        }
                        break;
                    case CHEST:
                        break;
                    case WALL:
                        addTile(posX,posY,"H:\\Pictures\\WallTile.png");
                        break;
                    default:
                        addTile(x,y,"H:\\Pictures\\FloorTile.png");
                        break;
                }

                dungeon.getEquipmentPos(x,y);
                dungeon.getArtifactPos(x,y);
                dungeon.getCharacterPos(x,y);
            }
        }
    }
}