package GameController;

import javax.swing.*;

public class GameStart {
    private final String OPENING_DIALOG = "Find all three keys and defeat the ultimate evil";
    private final String CHOOSE_NAME = "Enter your Character's Name";
    private final String CONFIGURE_PLAYER_CHAR = "";
    private final String GAME_TITLE = "Dungeon Crawler";
    public void run(){
        gameStartScreen();
    }

    private void gameStartScreen(){
        JFrame jFrame = new JFrame(this.GAME_TITLE);
        jFrame.setSize(1920, 1080);
        jFrame.setVisible(true);
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
    }
}
