package GUI.Main;

import Characters.Player;
import Characters.Races.Elf;
import Characters.ViewDirection;
import Characters.classes.Clazz;
import Characters.classes.Mage;
import Characters.classes.Thief;
import equipment.armor.LeatherArmor;
import equipment.armor.NoArmor;
import spells.Fireball;
import spells.Spell;
import util.Attribute;
import util.Effect;

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
        File file = new File(".\\Graphics\\Status.png");
        try {
            boxes = ImageIO.read(file);
        } catch (IOException e) {
            DialogBox.ConsoleOut("Couldn't load file " + file);
        }
        ImageIcon imageIcon = new ImageIcon(boxes);
        statusFrame = new JPanel()
        {
            @Override public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        };
        statusFrame.setLayout(new BoxLayout(statusFrame, BoxLayout.PAGE_AXIS));
        statusFrame.setBounds(1250,0, 430, 750);
//        statusFrame.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        for(Player player : players) {
            statusFrame.add(new CharacterPanel(player));
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

    public void setActiveCharacter(int p) throws IOException {
        for(CharacterPanel component : (CharacterPanel[])statusFrame.getComponents()) {
            if(component.active) {
                component.toggleBorder();
            }
        }
        if(p > 0 && p<5) {
            CharacterPanel panel = (CharacterPanel) statusFrame.getComponent(p - 1);
            panel.toggleBorder();
        }

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




