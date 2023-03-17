package GameController;

import Characters.Player;

import javax.swing.*;
import java.util.ArrayList;

public class GameStart {
    private final String OPENING_DIALOG = "Find all three keys and defeat the ultimate evil";
    private final String CHOOSE_NAME = "Enter your Character's Name";
    private final String CHOOSE_RACE = "Choose a race for your Character";
    private final String CHOOSE_CLASS = "Choose a class for your Character";
    private final String CONFIGURE_PLAYER_CHAR = "";
    private final String GAME_TITLE = "Dungeon Crawler";
    public ArrayList<Player> run(){
        gameStartScreen();
        ArrayList<Player> players = new ArrayList<>();
        return players;
    }

    private void gameStartScreen(){
        JFrame jFrame = new JFrame(this.GAME_TITLE);
        jFrame.setSize(1920, 1080);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel jPanelBoxLayout = new JPanel();
        jPanelBoxLayout.setLayout(new BoxLayout(jPanelBoxLayout, BoxLayout.X_AXIS));
        jFrame.add(jPanelBoxLayout);

        for (int i = 0; i < 4; i++){
            createPlayerGui(jPanelBoxLayout, i);
        }

        jFrame.setVisible(true);
    }
    private void createPlayerGui(JPanel jPanelRoot, int playerCount) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanelRoot.add(jPanel);
        playerCount ++;
        JLabel playerCountLabel = new JLabel("Spieler " + playerCount + ":");
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
        JComboBox classSelection = new JComboBox(new String[]{"Kämpfer", "Zauberer", "Dieb"});
        classSelection.setBounds(25, 200, 300, 40);
        jPanel.add(classSelection);
        JLabel raceSelectionLabel = new JLabel(this.CHOOSE_RACE);
        raceSelectionLabel.setBounds(25, 250, 300, 40);
        jPanel.add(raceSelectionLabel);
        JComboBox raceSelection = new JComboBox(new String[]{"Zwerg", "Elf", "Hobbit", "Mensch"});
        raceSelection.setBounds(25, 300, 300, 40);
        jPanel.add(raceSelection);
    }
}
