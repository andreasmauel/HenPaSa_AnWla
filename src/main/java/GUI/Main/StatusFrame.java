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

    public JPanel generateStatusBackground(){
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


        Clazz thief = new Thief(10, Attribute.DEXTERITY, Attribute.CONSTITUTION, new ArrayList<Attribute>());
        Mage mage = new Mage(10, Attribute.DEXTERITY, Attribute.CONSTITUTION, new ArrayList<Attribute>());
        mage.addSpell(new Fireball());
        Player player = new Player("Gustav", 10,10,10,10,
                1,new Elf(), 5,3, new NoArmor(), true, ViewDirection.EAST,
                new ArrayList<Effect>(), thief);
        Player player2 = new Player("Ronaldo", 10,10,10,10,
                1,new Elf(), 5,3, new LeatherArmor(), true, ViewDirection.EAST,
                new ArrayList<Effect>(), mage);
//        player2.addEffect(Effect.REDUCEATTACK);
//        player2.addEffect(Effect.HIDE);
//        player2.addEffect(Effect.SLEEP);
//        player.addEffect(Effect.REDUCEATTACK);
//        player.addEffect(Effect.HIDE);
//        player.addEffect(Effect.ARMOR);

        statusFrame.add(new CharacterPanel(player));
        statusFrame.add(new CharacterPanel(player));
        statusFrame.add(new CharacterPanel(player));
        statusFrame.add(new CharacterPanel(player2));

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
