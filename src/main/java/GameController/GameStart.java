package GameController;

import Characters.Player;
import Characters.Races.Dwarf;
import Characters.Races.Elf;
import Characters.Races.Human;
import Characters.Races.Race;
import Characters.ViewDirection;
import Characters.classes.Clazz;
import Characters.classes.Fighter;
import Characters.classes.FightingStyle;
import equipment.armor.Armor;
import equipment.armor.ChainMail;
import equipment.armor.LeatherArmor;
import equipment.weapon.Sword;
import equipment.weapon.Weapon;
import util.Attribute;
import util.Effect;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

import static javax.swing.BoxLayout.LINE_AXIS;

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

        createMapSelection(jPanelBoxLayoutY);

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
        statusLabel.setBounds(25, 400,300, 40);
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
                        jDialog.setTitle("Bitte wichtigste Eigenschaften auswählen");
                        jDialog.setSize(300,190);
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
                        JLabel chooseArmor = new JLabel("Rüstung wählen (Lederpanzer gewährt Pfeil u. Bogen):");
                        chooseArmor.setBounds(10, 75, 250, 20);
                        jPanel.add(chooseArmor);
                        JComboBox armorChoice = new JComboBox(new String[]{"Kettenpanzer", "Lederpanzer"});
                        armorChoice.setBounds(10, 85, 250, 20);
                        jPanel.add(armorChoice);
                        JLabel chooseEquipment = new JLabel("Ausrüstung wählen");
                        chooseEquipment.setBounds(10, 95, 250, 20);
                        jPanel.add(chooseEquipment);
                        JComboBox equipmentChoice = new JComboBox(new String[]{"", "Geschicklichkeit"});
                        equipmentChoice.setBounds(10, 105, 250, 20);
                        jPanel.add(equipmentChoice);
                        JLabel chooseFightingStyle = new JLabel("Kampfstil wählen");
                        chooseFightingStyle.setBounds(10, 115, 250, 20);
                        jPanel.add(chooseFightingStyle);
                        JComboBox fightingStyleChoice = new JComboBox(new String[]{"Bogenschießen", "Nahkampf", "Verteidigung"});
                        fightingStyleChoice.setBounds(10, 115, 250, 20);
                        jPanel.add(fightingStyleChoice);
                        JButton finish = new JButton("Auswahl bestätigen");
                        finish.setBounds(100, 140, 160, 20);
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
                                ArrayList<Effect> effects = new ArrayList<>();
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
                                //ToDo Weapon Selection
                                Weapon primaryWeapon;
                                Weapon secondaryWeapon = new Sword();
                                FightingStyle fightingStyle;
                                if (fightingStyleChoice.getSelectedItem().toString() == "Bogenschießen")
                                    fightingStyle = FightingStyle.BOWSHOOTING;
                                if (fightingStyleChoice.getSelectedItem().toString() == "Nahkampf")
                                    fightingStyle = FightingStyle.CLOSECOMBAT;
                                else fightingStyle = FightingStyle.DEFENSE;
                                Clazz fighter = new Fighter(primaryAttribute, Attribute.CONSTITUTION, savingThrows, secondaryWeapon, fightingStyle);
                                Player player = new Player(nameSelection.getText(), dexterity, intelligence, strength, constitution, wisdom, race, walkingRange, armorClass, armor, true, ViewDirection.NORTH,effects, fighter);
                                //players.add(playerCount, player);
                            }

                        });

                        jDialog.setModal(true);
                        jDialog.setVisible(true);
                    }
                    else if (clazzString == "Dieb"){
                        String primary = "Stärke";
                        String secondary = "Konstitution";
                        JDialog jDialog = new JDialog();
                        jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jDialog.setTitle("Bitte wichtigste Eigenschaften auswählen");
                        jDialog.setSize(300,190);
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
                        JButton finish = new JButton("Auswahl bestätigen");
                        finish.setBounds(100, 110, 160, 20);
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
                                int walkingRange = 5;
                                //Player player = new Player(dexterity, intelligence, strength, constitution, wisdom, race, walkingRange, race, armorClass,);
                            }
                        });

                        jDialog.setModal(true);
                        jDialog.setVisible(true);
                    }
                    if (clazzString == "Zauberer"){
                        //clazz = new Clazz()
                    }
                    //players.set(count, new Player());
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

    public void createMapSelection(JPanel jPanelRoot){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanelRoot.add(jPanel);
        JLabel playerCountLabel = new JLabel("Wähle ein Spielfeld:");
        playerCountLabel.setBounds(25, 0, 300, 40);
        jPanel.add(playerCountLabel);
    }
}
