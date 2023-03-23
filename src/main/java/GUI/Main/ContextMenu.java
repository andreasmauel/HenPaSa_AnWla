package GUI.Main;

import battlemap.Meta.TileType;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ContextMenu
{

    private JPanel menu;
    private JLabel tileType;

    public JPanel generateContextMenu() throws IOException {
        tileType = new JLabel();
        tileType.setBounds(10,10, 430, 30);
        tileType.setFont(new Font("Impact", Font.PLAIN, 30));
        tileType.setBackground(new Color(72, 72, 72, 255));
        tileType.setForeground(Color.WHITE);
        tileType.setText("ENTITY");

        JLabel actionLabel = new JLabel();
        actionLabel.setBounds(10,40, 80, 30);
        actionLabel.setFont(new Font("Impact", Font.PLAIN, 20));
        actionLabel.setBackground(new Color(72, 72, 72, 255));
        actionLabel.setForeground(Color.WHITE);
        actionLabel.setText("Actions: ");

        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(1250,750, 430, 240);
        menu.setBackground(new Color(72, 72, 72, 255));
        menu.add(actionLabel);
        menu.add(tileType);
        menu.setForeground(Color.WHITE);
        menu.setBorder(BorderFactory.createLineBorder(Color.black));
        return menu;
    }

    public void displayTileType(TileType tile)
    {
        if(tile == null)
            tileType.setText("FLOOR");
        else
            tileType.setText(tile.name());
        tileType.repaint();
    }



}
