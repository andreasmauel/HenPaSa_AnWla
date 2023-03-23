package GUI.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StatusFrame
{

    private JPanel statusFrame;
    private BufferedImage boxes;

    public JPanel generateStatusBackground() throws IOException {
        statusFrame = new JPanel();
        statusFrame.setLayout(null);
        statusFrame.setBounds(1250,0, 430, 750);

        File file = new File(".\\Graphics\\Status.png");
        boxes = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(boxes);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(0,0, 430, 750);

        statusFrame.add(jLabel);

        return statusFrame;
    }

    public void setActiveCharacter(int p) throws IOException {
        File file;
        switch(p)
        {
            case 1:
                file = new File(".\\Graphics\\Status_P1_selected.png");
                break;
            case 2:
                file = new File(".\\Graphics\\Status_P2_selected.png");
                break;
            case 3:
                file = new File(".\\Graphics\\Status_P3_selected.png");
                break;
            case 4:
                file = new File(".\\Graphics\\Status_P4_selected.png");
                break;
            default:
                file = new File(".\\Graphics\\Status_MO_selected.png");
                break;
        }

        boxes = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(boxes);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(0,0, 430, 750);

        statusFrame.remove(0);
        statusFrame.add(jLabel);
        statusFrame.repaint();
    }

}
