package GUI.Main;

import Characters.AbstractCharacter;
import Characters.Player;
import Characters.classes.Mage;
import util.Effect;

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
    JPanel activeEquipment = new JPanel();
    JPanel equipmentSpellsEffects = new JPanel();


    public JPanel initCharacter() {
        this.setLayout(new BorderLayout(5, 5));
        setPlayerInfo();
        setPlayerStats();
        setPickablePanel();
        this.add(playerInfo, BorderLayout.NORTH);
        this.add(playerStats, BorderLayout.WEST);
        this.add(activeEquipment, BorderLayout.EAST);
        return this;
    }

    public void setPlayerInfo() {
        playerInfo.setLayout(new BoxLayout(playerInfo, BoxLayout.LINE_AXIS));
        JLabel playerName = new JLabel("Name: " + player.getName());
        JLabel level = new JLabel("Level: " + 1);
        JLabel race = new JLabel("Race: " + player.getRaceName());
        JLabel clazz = new JLabel("Class: " + player.getClazzName());
        playerInfo.add(Box.createVerticalStrut(5));
        playerInfo.add(playerName);
        playerInfo.add(Box.createVerticalStrut(20));
        playerInfo.add(level);
        playerInfo.add(Box.createVerticalStrut(20));
        playerInfo.add(race);
        playerInfo.add(Box.createVerticalStrut(20));
        playerInfo.add(clazz);
        playerInfo.add(Box.createVerticalStrut(5));
    }

    private void setPlayerStats() {
        playerStats.setLayout(new GridLayout(4, 2));

        playerStats.add(createLabelWithValue("HP: ", player.getLifepoints()));
        playerStats.add(createLabelWithValue("Max HP: ", player.calculateMaxLivepoints()));
        playerStats.add(createLabelWithValue("STR: ", player.getStrenght()));
        playerStats.add(createLabelWithValue("DEX: ", player.getDexterity()));
        playerStats.add(createLabelWithValue("WIS: ", player.getWisdom()));
        playerStats.add(createLabelWithValue("INT: ", player.getInitiative()));
        playerStats.add(createLabelWithValue("CON: ", player.getConstitution()));
        playerStats.add(createLabelWithValue("Max MOV: ", player.getWalkingrange()));

    }

    private void setPickablePanel() {
        activeEquipment.setLayout(new GridLayout(4, 2));
        JComboBox weapons;
        JComboBox armor;
        JComboBox artifact;
        JComboBox spells;
        if (player.getWeapons().size() != 0) {
            weapons = new JComboBox(player.getWeapons().toArray());
        } else {
            weapons = new JComboBox();
        }
        if (player.getWeapons().size() != 0) {
            armor = new JComboBox(player.getArmor().toArray());
        } else {
            armor = new JComboBox();
        }
        if (player.getWeapons().size() != 0) {
            artifact = new JComboBox(player.getArtifact().toArray());
        } else {
            artifact = new JComboBox();
        }
        if (player.getWeapons().size() != 0) {
            spells = new JComboBox();
        } else {
            spells = new JComboBox();
        }
        if (this.player.getClazz() instanceof Mage) {
            spells = new JComboBox();
        } else {
            spells = new JComboBox();
        }
        JLabel remainingMovement = new JLabel();

        activeEquipment.add(weapons);
        activeEquipment.add(armor);
        activeEquipment.add(artifact);
        activeEquipment.add(spells);
        activeEquipment.add(remainingMovement);
        activeEquipment.add(createEffectsPanel());

    }

    private JLabel createLabelWithValue(String type, Object value) {
        return new JLabel(type + value);
    }

    private JPanel createEffectsPanel() {
        JPanel effectsPanel = new JPanel();
        effectsPanel.setLayout(new BoxLayout(effectsPanel, BoxLayout.LINE_AXIS));
        for (Effect effect : player.getEffects()) {
            effectsPanel.add(new JLabel(effect.name()));
        }
        return effectsPanel;
    }

}
