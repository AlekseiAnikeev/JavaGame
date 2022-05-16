package mvc.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mvc.ViewGUI;

import static mvc.util.GameObject.getImage;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class HelpPanel extends JPanel {
    private ViewGUI view;
    private JButton mainMenuButton;
    private JTextField infoField;
    private JButton startGameButton;
    private JButton exitButton;
    private JButton restartGameButton;

    public HelpPanel(ViewGUI view, int weight, int height) {
        this.view = view;
        setLayout(null);
        setPreferredSize(new Dimension(weight, height));
        Icon onePlayer = new ImageIcon(getImage("mainMenuButton"));
        mainMenuButton = new JButton(onePlayer);
        mainMenuButton.setBounds(796,592,265,82);
        add(mainMenuButton);

        mainMenuButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.initMainMenu();
            }
        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D d2 = (Graphics2D) g;
        //d2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        d2.drawImage(getImage("mainUpNew"), 0, 0, this);
        d2.drawImage(getImage("helpPanel"), 0, 274, this);
    }
}
