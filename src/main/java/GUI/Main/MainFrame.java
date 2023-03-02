package GUI.Main;

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
                    addWallTile(x,y);
                }else
                {
                    addFloorTile(x,y);
                }

            }
        }
        jFrame.repaint();
    }

    public static void addFloorTile(int x, int y) throws IOException {
        File file = new File("H:\\Pictures\\FloorTile.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        jFrame.add(jLabel);
    }

    public static void addWallTile(int x, int y) throws IOException {
        File file = new File("H:\\Pictures\\WallTile.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(x,y, 50, 50);
        jFrame.add(jLabel);
    }
}