package GUI.Main;

import Artifact.Artifact;
import Characters.AbstractCharacter;
import Characters.Player;
import Characters.classes.Mage;
import equipment.armor.Armor;
import equipment.weapon.Weapon;
import observer.Observer;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.List;


public class CharacterPanel extends JPanel implements Observer {

    public CharacterPanel(Player player) {
        this.player = player;
        this.player.addObserver(this);
        initCharacter();
    }

    private Player player;
    private JPanel playerInfo = new JPanel();
    private JPanel playerStats = new JPanel();
    private JPanel activeEquipment = new JPanel();
    private JPanel equipmentSpellsEffects = new JPanel();
    boolean active = false;

    //Alle Attribute
    JLabel playerName;
    JLabel level;
    JLabel race;
    JLabel clazz;
    JLabel hp;
    JLabel hpMax;
    JLabel str;
    JLabel dex;
    JLabel wis;
    JLabel inte;
    JLabel con;
    JLabel ac;
    JLabel mov;
    JLabel maxMov;


    JComboBox weapons;
    JComboBox armor;
    JComboBox artifact;
    JComboBox spells;

    public JPanel initCharacter() {
        this.setLayout(new BorderLayout(5, 5));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        setPlayerInfo();
        setPlayerStats();
        setPickablePanel();
        playerInfo.setBackground(new Color(72, 72, 72, 255));
        playerStats.setBackground(new Color(72, 72, 72, 255));
        activeEquipment.setBackground(new Color(72, 72, 72, 255));
        disableComponents(activeEquipment, active);
        disableComponents(playerStats, active);
        disableComponents(playerInfo, active);
        this.add(playerInfo, BorderLayout.NORTH);
        this.add(playerStats, BorderLayout.WEST);
        this.add(activeEquipment, BorderLayout.EAST);
        return this;
    }

    public void setPlayerInfo() {
        playerInfo.setLayout(new BoxLayout(playerInfo, BoxLayout.LINE_AXIS));
        playerName = new JLabel("Name: " + player.getName());
        playerName.setForeground(Color.WHITE);
        level = new JLabel("Level: " + 1);
        level.setForeground(Color.WHITE);
        race = new JLabel("Race: " + player.getRaceName());
        race.setForeground(Color.WHITE);
        clazz = new JLabel("Class: " + player.getClazzName());
        clazz.setForeground(Color.WHITE);
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
        playerStats.setLayout(new GridLayout(5, 2));

        hp = new JLabel("HP: " + player.getCurrentLifepoints());
        hp.setForeground(Color.WHITE);
        playerStats.add(hp);
        hpMax = new JLabel("Max HP: " + player.getMaxLifePoints());
        hpMax.setForeground(Color.WHITE);
        playerStats.add(hpMax);
        str = new JLabel("STR: " + player.getStrength());
        str.setForeground(Color.WHITE);
        playerStats.add(str);
        dex = new JLabel("DEX: " + player.getDexterity());
        dex.setForeground(Color.WHITE);
        playerStats.add(dex);
        wis = new JLabel("WIS: " + player.getWisdom());
        wis.setForeground(Color.WHITE);
        playerStats.add(wis);
        inte = new JLabel("INT: " + player.getInitiative());
        inte.setForeground(Color.WHITE);
        playerStats.add(inte);
        con = new JLabel("CON: " + player.getConstitution());
        con.setForeground(Color.WHITE);
        playerStats.add(con);
        ac = new JLabel("AC: " + player.getArmorClass());
        ac.setForeground(Color.WHITE);
        playerStats.add(ac);
        mov = new JLabel("MOV: " + player.getRemainingWalkingRange());
        mov.setForeground(Color.WHITE);
        playerStats.add(mov);
        maxMov = new JLabel("Max MOV: " + player.getWalkingrange());
        maxMov.setForeground(Color.WHITE);
        playerStats.add(maxMov);
    }

    private void setPickablePanel() {
        activeEquipment.setLayout(new GridLayout(4, 2, 5, 5));

        if (player.getWeapons().size() != 0) {
            weapons = new JComboBox();
            fillComboBox(weapons, player.getWeapons());
            weapons.setRenderer(new MyComboBoxRenderer());
            weapons.setSelectedItem(player.getCurrentWeapon());
        } else {
            weapons = new JComboBox();
        }
        if (player.getArmor().size() != 0) {
            armor = new JComboBox();
            fillComboBox(armor, player.getArmor());
            armor.setRenderer(new MyComboBoxRenderer());
            weapons.setSelectedItem(player.getCurrentarmor());
        } else {
            armor = new JComboBox();
        }
        if (player.getArtifact().size() != 0) {
            artifact = new JComboBox();
            fillComboBox(artifact, player.getArtifact());
            artifact.setRenderer(new MyComboBoxRenderer());
            weapons.setSelectedItem(player.getCurrentArtifact());
        } else {
            artifact = new JComboBox();
        }
        if (this.player.getClazz() instanceof Mage) {
            spells = new JComboBox(((Mage) this.player.getClazz()).getSpells().toArray());
            spells.setRenderer(new MyComboBoxRenderer());
        } else {
            spells = new JComboBox();
        }


        weapons.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                player.setCurrentWeapon((Weapon) e.getItem());
                System.out.println(e.getItem());
            }
        });

        armor.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                player.setCurrentarmor((Armor) e.getItem());
            }
        });
        artifact.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                player.setCurrentArtifact((Artifact) e.getItem());
            }
        });
        activeEquipment.add(weapons);
        activeEquipment.add(armor);
        activeEquipment.add(artifact);
        activeEquipment.add(spells);
        activeEquipment.add(createEffectsPanel());
        disableComponents(activeEquipment, active);

    }

    private JLabel createLabelWithValue(String type, Object value) {
        JLabel label = new JLabel(type + value);
        label.setForeground(Color.WHITE);
        return label;
    }

    private JPanel createEffectsPanel() {
        JPanel effectsPanel = new JPanel();
        effectsPanel.setLayout(new BoxLayout(effectsPanel, BoxLayout.PAGE_AXIS));
        effectsPanel.setBackground(new Color(72, 72, 72, 255));
        return effectsPanel;
    }

    public void toggleBorder() {
        if (active) {
            this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        } else {
            this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
        }
        disableComponents(activeEquipment, !active);
        disableComponents(playerInfo, !active);
        disableComponents(playerStats, !active);
        active = !active;
        this.repaint();
    }


    private void disableComponents(JPanel panel, boolean bool) {
        for (Component component : panel.getComponents()) {
            component.setEnabled(bool);
        }
    }

    @Override
    public void update(AbstractCharacter character) {
        updateAllValues();

//        System.out.println(player.getCurrentWeapon().getName());
    }

    private void updateAllValues() {

        playerName.setText("Name: " + player.getName());
        level.setText("Level: 1");
        race.setText("Race: " + player.getRaceName());
        clazz.setText("Class: " + player.getClazzName());
        hp.setText("HP: " + player.getCurrentLifepoints());
        hpMax.setText("Max HP: " + player.getMaxLifePoints());
        str.setText("STR: " + player.getStrength());
        dex.setText("DEX: " + player.getDexterity());
        wis.setText("WIS: " + player.getWisdom());
        inte.setText("INT: " + player.getIntelligence());
        con.setText("CON: " + player.getConstitution());
        ac.setText("AC: " + player.getArmorClass());
        mov.setText("MOV: " + player.getRemainingWalkingRange());
        maxMov.setText("Max Mov: " + player.getWalkingrange());


        Weapon safeCurrentWeapon = player.getCurrentWeapon();
        weapons.removeAllItems();
        fillComboBox(weapons, player.getWeapons());
        player.setCurrentWeapon(safeCurrentWeapon);
        weapons.setSelectedItem(player.getCurrentWeapon());

        Armor safeCurrentArmor = player.getCurrentarmor();
        armor.removeAllItems();
        fillComboBox(armor, player.getArmor());
        player.setCurrentarmor(safeCurrentArmor);
        armor.setSelectedItem(player.getCurrentarmor());

        Artifact safeCurrentArtifact = player.getCurrentArtifact();
        if(safeCurrentArtifact != null) {
            artifact.removeAllItems();
            fillComboBox(artifact, player.getArtifact());
            if (artifact.getItemCount() != 0) {
                artifact.setRenderer(new MyComboBoxRenderer());
            }
            player.setCurrentArtifact(safeCurrentArtifact);
            artifact.setSelectedItem(player.getCurrentArtifact());
        }
        if (player.getClazz() instanceof Mage) {
            spells.removeAllItems();
            fillComboBox(spells, ((Mage) player.getClazz()).getSpells());
        }
    }

    private void fillComboBox(JComboBox box, List<? extends Object> list) {
        for (Object object : list) {
            box.addItem(object);
        }
    }

    private static class MyComboBoxRenderer implements ListCellRenderer<Object> {
        @Override
        public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {

            Component component = new JLabel(value.getClass().getSimpleName());
            if (isSelected) {
                component.setBackground(list.getSelectionBackground());
                component.setForeground(list.getSelectionForeground());
            } else {
                component.setBackground(list.getBackground());
                component.setForeground(list.getForeground());
            }
            return component;
        }
    }
}
