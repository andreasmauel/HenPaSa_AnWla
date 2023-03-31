package GUI.Main;

import Characters.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class StatusFrame

{
    private JPanel statusFrame;
    private BufferedImage boxes;

    public JPanel generateStatusBackground(ArrayList<Player> players){
        statusFrame = new JPanel();
        statusFrame.setLayout(new BoxLayout(statusFrame, BoxLayout.PAGE_AXIS));
        statusFrame.setBounds(1250,0, 430, 750);
//        statusFrame.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        int playerCount = 1;
        for(Player player : players) {
            statusFrame.add(new CharacterPanel(player));
            playerCount ++;
        }
        JLabel jLabel = new JLabel( );
//        jLabel.setIcon(imageIcon);
//        jLabel.setBounds(0,0, 430, 750);
//        statusFrame.add(jLabel);

        for( Component component : statusFrame.getComponents()) {
            component.setBackground(new Color(72, 72, 72, 255));
        }
        return statusFrame;
    }

    public void setActiveCharacter(int p) {
        for(Component component : statusFrame.getComponents()) {
            CharacterPanel panel = (CharacterPanel) component;
            if(panel.active) {
                panel.toggleBorder();
            }
        }
        if(p > 0 && p<5) {
            CharacterPanel panel = (CharacterPanel) statusFrame.getComponent(p - 1);
            panel.toggleBorder();
        }
        this.statusFrame.revalidate();
    }

//        boxes = ImageIO.read(file);
//        ImageIcon imageIcon = new ImageIcon(boxes);
//        JLabel jLabel = new JLabel();
//        jLabel.setIcon(imageIcon);
//        jLabel.setBounds(0,0, 430, 750);
//
//        statusFrame.remove(0);
//        statusFrame.add(jLabel);
//        statusFrame.repaint();
    }




