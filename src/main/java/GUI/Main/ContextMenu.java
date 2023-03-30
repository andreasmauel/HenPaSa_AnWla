package GUI.Main;

import GUI.Main.ActionHandler.ActionHandler;
import GUI.Main.ActionHandler.ActionOption;
import battlemap.Dungeon.Dungeon;
import battlemap.Meta.TileType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class ContextMenu
{

    private JPanel menu;
    private JLabel tileType;
    private JButton confirm;
    private JComboBox options;

    private ActionHandler handler;
    private int posX;
    private int posY;

    private ConfirmListener confirmListener = new ConfirmListener();

    private class ConfirmListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                try{

                ActionOption item = (ActionOption) event.getItem();
                if(item != null)
                {
                    confirm.setActionCommand(item.getActionEvent() + "," + posX + "," + posY);
                }
                }
                catch(Exception e)
                {

                }
            }
        }
    }

    public JPanel generateContextMenu(Dungeon dungeon){

        handler = new ActionHandler(dungeon);

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

        options = new JComboBox();
        options.addItemListener(confirmListener);
        options.setBounds(90, 40, 340, 30);

        confirm = new JButton();
        confirm.setText("Execute");
        confirm.setActionCommand("NULL,0,0");
        confirm.addActionListener(handler.attack.getButtonListener());
        confirm.addActionListener(handler.close.getButtonListener());
        confirm.addActionListener(handler.move.getButtonListener());
        confirm.addActionListener(handler.pickup.getButtonListener());
        confirm.addActionListener(handler.open.getButtonListener());
        confirm.addActionListener(handler.unlock.getButtonListener());
        confirm.setBounds(10, 200, 80, 30);

        menu = new JPanel();
        menu.setLayout(null);
        menu.setBounds(1250,750, 430, 240);
        menu.setBackground(new Color(72, 72, 72, 255));
        menu.add(confirm);
        menu.add(options);
        menu.add(actionLabel);
        menu.add(tileType);
        menu.setForeground(Color.WHITE);
        menu.setBorder(BorderFactory.createLineBorder(Color.black));
        return menu;
    }

    public void displayTileType(TileType tile, int x, int y)
    {
        if(tile == null)
            tileType.setText("FLOOR");
        else
            tileType.setText(tile.name());
        tileType.repaint();

        posX= x;
        posY= y;

        options.removeAllItems();

        int brk = 0;

        for(ActionOption aO: handler.getOptions(tile)){
            options.addItem(aO);
            if(brk ==0) {
                confirm.setActionCommand(aO.getActionEvent() + "," + x + "," + y);
                brk++;
            }
        }


    }



}
