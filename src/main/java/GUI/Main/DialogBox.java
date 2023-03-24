package GUI.Main;

import javax.swing.*;
import java.awt.*;

public class DialogBox
{
    public static JTextArea textbox = new JTextArea();
    private JScrollPane scrollArea = new JScrollPane();

    public JScrollPane generateDialogBox()
    {
        scrollArea.setViewportView(textbox);
        scrollArea.setBounds(0,750, 1250, 240);
        textbox.setLineWrap(true);
        textbox.setWrapStyleWord(true);
        textbox.setFont(new Font("Impact", Font.PLAIN, 20));
        textbox.setBackground(new Color(72, 72, 72, 255));
        textbox.setForeground(Color.WHITE);
        textbox.setEditable(false);

        return scrollArea;
    }
    public static void ConsoleOut(String output)
    {
        textbox.append(output);
        textbox.append("\n");
    }
}
