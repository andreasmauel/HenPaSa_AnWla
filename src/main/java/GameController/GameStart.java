package GameController;

import Characters.Player;
import Characters.Races.Dwarf;
import Characters.Races.Elf;
import Characters.Races.Human;
import Characters.Races.Race;
import Characters.ViewDirection;
import Characters.classes.*;
import equipment.armor.Armor;
import equipment.armor.ChainMail;
import equipment.armor.LeatherArmor;
import equipment.armor.NoArmor;
import equipment.weapon.*;
import util.Attribute;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

public class GameStart {
    private final String OPENING_DIALOG = "Find all three keys and defeat the ultimate evil";
    private final String CHOOSE_NAME = "Enter your Character's Name";
    private final String CHOOSE_RACE = "Choose a race for your Character";
    private final String CHOOSE_CLASS = "Choose a class for your Character";
    private final String CONFIGURE_PLAYER_CHAR = "";
    private final String GAME_TITLE = "Dungeon Crawler";
    private ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Player> run(){
        gameStartScreen();
        return this.players;
    }

    private void gameStartScreen(){
        JFrame jFrame = new JFrame(this.GAME_TITLE);
        jFrame.setSize(1920, 1080);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel jPanelBoxLayoutY = new JPanel();
        jPanelBoxLayoutY.setLayout(new BoxLayout(jPanelBoxLayoutY, BoxLayout.Y_AXIS));
        JPanel jPanelBoxLayoutX = new JPanel();
        jPanelBoxLayoutX.setLayout(new BoxLayout(jPanelBoxLayoutX, BoxLayout.X_AXIS));
        jFrame.add(jPanelBoxLayoutY);
        jPanelBoxLayoutY.add(jPanelBoxLayoutX);

        for (int i = 0; i < 4; i++){
            createPlayerGui(jPanelBoxLayoutX, i);
        }

        createMapSelection(jPanelBoxLayoutY, jFrame);

        jFrame.setVisible(true);
    }
    private void createPlayerGui(JPanel jPanelRoot, int playerCount) {
        final int count = playerCount;
        final String[] name = {""};
        int displayPlayerCount = ++playerCount;
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanelRoot.add(jPanel);
        JLabel playerCountLabel = new JLabel("Spieler " + displayPlayerCount + ":");
        playerCountLabel.setBounds(25, 5, 300, 40);
        jPanel.add(playerCountLabel);
        JLabel nameSelectionLabel = new JLabel(this.CHOOSE_NAME);
        nameSelectionLabel.setBounds(25, 50, 300, 40);
        jPanel.add(nameSelectionLabel);
        JTextField nameSelection = new JTextField();
        nameSelection.setBounds(25, 100, 300, 40);
        jPanel.add(nameSelection);

        JLabel classSelectionLabel = new JLabel(this.CHOOSE_CLASS);
        classSelectionLabel.setBounds(25, 150, 300, 40);
        jPanel.add(classSelectionLabel);
        JComboBox classSelection = new JComboBox(new String[]{"", "Kämpfer", "Zauberer", "Dieb"});
        classSelection.setBounds(25, 200, 300, 40);
        jPanel.add(classSelection);
        JLabel raceSelectionLabel = new JLabel(this.CHOOSE_RACE);
        raceSelectionLabel.setBounds(25, 250, 300, 40);
        jPanel.add(raceSelectionLabel);
        JComboBox raceSelection = new JComboBox(new String[]{"", "Zwerg", "Elf", "Hobbit", "Mensch"});
        raceSelection.setBounds(25, 300, 300, 40);
        jPanel.add(raceSelection);

        JButton finnishButton = new JButton("Erstelle Spieler");
        finnishButton.setBounds(25, 360,300, 40);
        jPanel.add(finnishButton);
        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(25, 400,330, 40);
        jPanel.add(statusLabel);
        finnishButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                name[0] = nameSelection.getText();
                String clazzString = classSelection.getSelectedItem().toString();
                String raceString = raceSelection.getSelectedItem().toString();
                System.out.println(name[0] +" " + clazzString +" " + raceString);
                if (Objects.equals(name[0], "") || clazzString == "" || raceString == ""){
                    statusLabel.setText("Bitte alle Felder ausfüllen!");
                } else {
                    Clazz clazz;
                    Race race;
                    if (clazzString == "Kämpfer"){
                        String primary = "Stärke";
                        String secondary = "Konstitution";
                        JDialog jDialog = new JDialog();
                        jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jDialog.setTitle("Zusätzliche Eigenschaften auswählen");
                        jDialog.setSize(300,400);
                        JPanel jPanel = new JPanel();
                        jPanel.setLayout(null);
                        jDialog.add(jPanel);

                        JLabel primaryLabel = new JLabel("Wichtigste Eigenschaft wählen:");
                        primaryLabel.setBounds(10, 5, 250, 20);
                        jPanel.add(primaryLabel);
                        JComboBox primaryCombo= new JComboBox(new String[]{"Stärke", "Geschicklichkeit"});
                        primaryCombo.setBounds(10, 35, 250, 20);
                        jPanel.add(primaryCombo);
                        JLabel secondaryLabel = new JLabel("Zweitwichtigste Eigenschaft: " + secondary);
                        secondaryLabel.setBounds(10, 65, 250, 20);
                        jPanel.add(secondaryLabel);
                        JLabel chooseArmor = new JLabel("<html>Rüstung wählen: <br/>(Lederpanzer gewährt Pfeil u. Bogen)</html>");
                        chooseArmor.setBounds(10, 95, 250, 30);
                        jPanel.add(chooseArmor);
                        JComboBox armorChoice = new JComboBox(new String[]{"Kettenpanzer", "Lederpanzer"});
                        armorChoice.setBounds(10, 135, 250, 20);
                        jPanel.add(armorChoice);
                        JLabel chooseEquipment = new JLabel("Ausrüstung wählen");
                        chooseEquipment.setBounds(10, 165, 250, 20);
                        jPanel.add(chooseEquipment);
                        JComboBox equipmentChoice1 = new JComboBox(new String[]{"Dolch", "Wurfpfeil", "Handaxt", "Streitaxt", "Speer", "Schwert", "Degen", "Pfeil und Bogen"});
                        equipmentChoice1.setBounds(10, 195, 250, 20);
                        jPanel.add(equipmentChoice1);
                        JComboBox equipmentChoice2 = new JComboBox(new String[]{"Dolch", "Wurfpfeil", "Handaxt", "Streitaxt", "Speer", "Schwert", "Degen", "Pfeil und Bogen"});
                        equipmentChoice2.setBounds(10, 225, 250, 20);
                        jPanel.add(equipmentChoice2);
                        JLabel chooseFightingStyle = new JLabel("Kampfstil wählen");
                        chooseFightingStyle.setBounds(10, 255, 250, 20);
                        jPanel.add(chooseFightingStyle);
                        JComboBox fightingStyleChoice = new JComboBox(new String[]{"Bogenschießen", "Nahkampf", "Verteidigung"});
                        fightingStyleChoice.setBounds(10, 285, 250, 20);
                        jPanel.add(fightingStyleChoice);
                        JButton finish = new JButton("Auswahl bestätigen");
                        finish.setBounds(100, 335, 160, 20);
                        jPanel.add(finish);
                        finish.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int dexterity = 10;
                                int intelligence = 10;
                                int strength = 10;
                                int constitution = 10;
                                int wisdom = 10;
                                Race race = getRace(raceString);
                                int armorClass = 13;
                                int walkingRange = 5;
                                Armor armor;
                                if (armorChoice.getSelectedItem().toString() == "Lederpanzer")
                                    armor = new LeatherArmor();
                                else armor = new ChainMail();
                                Attribute primaryAttribute;
                                if (primaryCombo.getSelectedItem().toString() == "Stärke")
                                    primaryAttribute = Attribute.STRENGTH;
                                else
                                    primaryAttribute = Attribute.DEXTERITY;
                                ArrayList<Attribute> savingThrows = new ArrayList<Attribute>();
                                savingThrows.add(Attribute.STRENGTH);
                                savingThrows.add(Attribute.DEXTERITY);
                                if(equipmentChoice1.getSelectedItem().toString() == "Dolch") {
                                    Weapon primaryWeapon = new Dagger();
                                } else if (equipmentChoice1.getSelectedItem().toString() == "Wurfpfeil") {
                                    Weapon primaryWeapon = new Dart();
                                } else if (equipmentChoice1.getSelectedItem().toString() == "Handaxt") {
                                    Weapon primaryWeapon = new HandAxe();
                                } else if (equipmentChoice1.getSelectedItem().toString() == "Streitaxt") {
                                    Weapon primaryWeapon = new BattleAxe();
                                } else if (equipmentChoice1.getSelectedItem().toString() == "Speer") {
                                    Weapon primaryWeapon = new Spear();
                                }else if (equipmentChoice1.getSelectedItem().toString() == "Schwert") {
                                    Weapon primaryWeapon = new Sword();
                                } else if (equipmentChoice1.getSelectedItem().toString() == "Degen") {
                                    Weapon primaryWeapon = new Rapier();
                                } else if(equipmentChoice1.getSelectedItem().toString() == "Pfeil und Bogen"){
                                    Weapon primaryWeapon = new Bow();
                                }

                                if(equipmentChoice2.getSelectedItem().toString() == "Dolch") {
                                    Weapon primaryWeapon = new Dagger();
                                } else if (equipmentChoice2.getSelectedItem().toString() == "Wurfpfeil") {
                                    Weapon primaryWeapon = new Dart();
                                } else if (equipmentChoice2.getSelectedItem().toString() == "Handaxt") {
                                    Weapon primaryWeapon = new HandAxe();
                                } else if (equipmentChoice2.getSelectedItem().toString() == "Streitaxt") {
                                    Weapon primaryWeapon = new BattleAxe();
                                } else if (equipmentChoice2.getSelectedItem().toString() == "Speer") {
                                    Weapon primaryWeapon = new Spear();
                                }else if (equipmentChoice2.getSelectedItem().toString() == "Schwert") {
                                    Weapon primaryWeapon = new Sword();
                                } else if (equipmentChoice2.getSelectedItem().toString() == "Degen") {
                                    Weapon primaryWeapon = new Rapier();
                                } else if(equipmentChoice2.getSelectedItem().toString() == "Pfeil und Bogen"){
                                    Weapon primaryWeapon = new Bow();
                                }
                                Weapon primaryWeapon = new Sword();
                                Weapon secondaryWeapon = new Sword();
                                FightingStyle fightingStyle;
                                if (fightingStyleChoice.getSelectedItem().toString() == "Bogenschießen")
                                    fightingStyle = FightingStyle.BOWSHOOTING;
                                if (fightingStyleChoice.getSelectedItem().toString() == "Nahkampf")
                                    fightingStyle = FightingStyle.CLOSECOMBAT;
                                else fightingStyle = FightingStyle.DEFENSE;
                                Clazz fighter = new Fighter(primaryAttribute, Attribute.CONSTITUTION, savingThrows, secondaryWeapon, fightingStyle);
                                Player player = new Player(count + 1, nameSelection.getText(), dexterity, intelligence, strength, constitution, wisdom, race, walkingRange, armorClass, armor, true, ViewDirection.NORTH, fighter, primaryWeapon);
                                players.add(count, player);
                                jDialog.setVisible(false);
                                jDialog.dispatchEvent(new WindowEvent(
                                        jDialog, WindowEvent.WINDOW_CLOSING));
                            }

                        });

                        jDialog.setModal(true);
                        jDialog.setVisible(true);
                    }
                    else if (clazzString == "Dieb"){
                        String primary = "Geschicklichkeit";
                        String secondary = "Intelligenz";
                        JDialog jDialog = new JDialog();
                        jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jDialog.setTitle("Zusätzliche Eigenschaften auswählen");
                        jDialog.setSize(300,220);
                        JPanel jPanel = new JPanel();
                        jPanel.setLayout(null);
                        jDialog.add(jPanel);

                        JLabel primaryLabel = new JLabel("Wichtigste Eigenschaft: " + primary);
                        primaryLabel.setBounds(10, 5, 250, 20);
                        jPanel.add(primaryLabel);
                        JLabel secondaryLabel = new JLabel("Zweitwichtigste Eigenschaft: " + secondary);
                        secondaryLabel.setBounds(10, 35, 250, 20);
                        jPanel.add(secondaryLabel);
                        JLabel chooseEquipment = new JLabel("Ausrüstung wählen");
                        chooseEquipment.setBounds(10, 65, 250, 20);
                        jPanel.add(chooseEquipment);
                        JComboBox equipmentChoice = new JComboBox(new String[]{"Dolch", "Wurfpfeil", "Handaxt", "Streitaxt", "Speer", "Schwert", "Degen", "Pfeil und Bogen"});
                        equipmentChoice.setBounds(10, 95, 250, 20);
                        jPanel.add(equipmentChoice);
                        JButton finish = new JButton("Auswahl bestätigen");
                        finish.setBounds(100, 145, 160, 20);
                        jPanel.add(finish);
                        finish.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int dexterity = 10;
                                int intelligence = 10;
                                int strength = 10;
                                int constitution = 10;
                                int wisdom = 10;
                                Race race = getRace(raceString);
                                int armorClass = 10;
                                Armor armor = new LeatherArmor();
                                int walkingRange = 5;
                                Thief thief = new Thief();
                                Player player = new Player(count, nameSelection.getText(), dexterity, intelligence, strength, constitution, wisdom, race, walkingRange, armorClass, armor, true, ViewDirection.NORTH, thief, new Rapier());
                                players.add(count, player);
                                jDialog.setVisible(false);
                                jDialog.dispatchEvent(new WindowEvent(
                                        jDialog, WindowEvent.WINDOW_CLOSING));
                            }
                        });

                        jDialog.setModal(true);
                        jDialog.setVisible(true);
                    }
                    if (clazzString == "Zauberer"){
                        String primary = "Intelligenz";
                        String secondary = "Konstitution";
                        JDialog jDialog = new JDialog();
                        jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jDialog.setTitle("Zusätzliche Eigenschaften auswählen");
                        jDialog.setSize(300,240);
                        JPanel jPanel = new JPanel();
                        jPanel.setLayout(null);
                        jDialog.add(jPanel);

                        JLabel primaryLabel = new JLabel("Wichtigste Eigenschaft: " + primary);
                        primaryLabel.setBounds(10, 5, 250, 20);
                        jPanel.add(primaryLabel);
                        JLabel secondaryLabel = new JLabel("Zweitwichtigste Eigenschaft wählen: ");
                        secondaryLabel.setBounds(10, 35, 250, 20);
                        jPanel.add(secondaryLabel);
                        JComboBox secondaryCombo= new JComboBox(new String[]{"Konstitution", "Geschicklichkeit"});
                        secondaryCombo.setBounds(10, 65, 250, 20);
                        jPanel.add(secondaryCombo);
                        JLabel chooseEquipment = new JLabel("Ausrüstung wählen");
                        chooseEquipment.setBounds(10, 95, 250, 20);
                        jPanel.add(chooseEquipment);
                        JComboBox equipmentChoice = new JComboBox(new String[]{"Dolch", "Wurfpfeil", "Handaxt", "Streitaxt", "Speer", "Schwert", "Degen", "Pfeil und Bogen"});
                        equipmentChoice.setBounds(10, 125, 250, 20);
                        jPanel.add(equipmentChoice);
                        JButton finish = new JButton("Auswahl bestätigen");
                        finish.setBounds(100, 175, 160, 20);
                        jPanel.add(finish);
                        finish.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int dexterity = 10;
                                int intelligence = 10;
                                int strength = 10;
                                int constitution = 10;
                                int wisdom = 10;
                                Race race = getRace(raceString);
                                int armorClass = 10;
                                Armor armor = new NoArmor();
                                int walkingRange = 5;
                                Attribute secondary;
                                if (secondaryCombo.getSelectedItem().toString() == "Konstitution")
                                    secondary = Attribute.CONSTITUTION;
                                else
                                    secondary = Attribute.DEXTERITY;
                                Mage mage = new Mage(secondary);
                                Player player = new Player(count, nameSelection.getText(), dexterity, intelligence, strength, constitution, wisdom, race, walkingRange, armorClass, armor, true, ViewDirection.NORTH, mage, new Spear());
                                players.add(count, player);
                                jDialog.setVisible(false);
                                jDialog.dispatchEvent(new WindowEvent(
                                        jDialog, WindowEvent.WINDOW_CLOSING));
                            }
                        });

                        jDialog.setModal(true);
                        jDialog.setVisible(true);
                    }
                }
            }
        });
    }

    private Race getRace(String raceString){
        if (raceString == "Zwerg")
            return new Dwarf();
        if (raceString == "Elfe")
            return new Elf();
        if (raceString == "Hobbit")
            return new Elf();
        else return new Human();
    }

    public void createMapSelection(JPanel jPanelRoot, JFrame jFrame){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanelRoot.add(jPanel);
        JLabel playerCountLabel = new JLabel("Wähle ein Spielfeld:");
        playerCountLabel.setBounds(25, 0, 300, 40);
        jPanel.add(playerCountLabel);

        JButton jButton = new JButton("Abenteuer beginnen");
        jButton.setBounds(100, 175, 160, 20);
        jPanel.add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (players.get(0) != null && players.get(1) != null && players.get(2) != null ) {
                    jFrame.setVisible(false);
                    jFrame.dispatchEvent(new WindowEvent(
                            jFrame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
    }
}
