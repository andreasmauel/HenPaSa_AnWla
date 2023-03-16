package GUI.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StatusFrame
{

    public JLabel generateStatusBackground() throws IOException {
        File file = new File(".\\Graphics\\Status.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        jLabel.setBounds(1250,0, 430, 750);
        return jLabel;
    }

}
