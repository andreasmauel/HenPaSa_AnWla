package GUI.Main;

import Characters.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CharacterPanel extends JPanel {

    public CharacterPanel(Player player) {
        this.player = player;
        initCharacter();
    }
    Player player;
    JPanel playerInfo = new JPanel();
    JPanel playerStats = new JPanel();
    JPanel activeEquipment  = new JPanel();
    JPanel equipmentSpellsEffects = new JPanel();


    public JPanel initCharacter() {
        this.setLayout(new BorderLayout(5,5));
        setPlayerInfo();
        this.add(playerInfo, BorderLayout.NORTH);
        return this;
    }

    public void setPlayerInfo() {
        playerInfo.setLayout(new BoxLayout(playerInfo, BoxLayout.LINE_AXIS));
        JLabel playerName = new JLabel("Name: " +player.getName());
        JLabel level = new JLabel("Level: " + 1) ;
        JLabel race = new JLabel("Race: " + player.getRace());
        JLabel clazz = new JLabel("Class: " + player.getClazzName());
        playerInfo.add(playerName);
        playerInfo.add(level);
        playerInfo.add(race);
        playerInfo.add(clazz);
    }

}
