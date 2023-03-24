package GameController;

import Characters.Player;
import Characters.Races.Race;
import Characters.classes.Clazz;

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
                        JButton finish = new JButton("Auswahl bestätigen");
                        finish.setBounds(100, 110, 160, 20);
                        jPanel.add(finish);
                        finish.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                            }
                        });

                        jDialog.setModal(true);
                        jDialog.setVisible(true);
                    }
                    if (clazzString == "Dieb"){
                        //clazz = new Clazz()
                    }
                    if (clazzString == "Zauberer"){
                        //clazz = new Clazz()
                    }
                    //players.set(count, new Player());
                }
            }
        });
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
