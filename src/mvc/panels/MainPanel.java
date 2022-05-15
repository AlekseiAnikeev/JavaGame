package mvc.panels;

import mvc.ViewGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static mvc.util.GameObject.getImage;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class MainPanel extends JPanel{
ViewGUI view;
    private JButton onePlayerButton;
    private JButton twoPlayerButton;
    private JButton helpButton;


    public MainPanel(ViewGUI view, int width, int height) {
        this.view = view;
        setLayout(null);

        setPreferredSize(new Dimension(
                width,
                height));
        Icon onePlayer = new ImageIcon(getImage("onePlayer"));
        Icon twoPlayer = new ImageIcon(getImage("twoPlayers"));
        Icon helpIcon = new ImageIcon(getImage("helpIcon"));

        onePlayerButton = new JButton(onePlayer);
        twoPlayerButton = new JButton(twoPlayer);
        helpButton = new JButton(helpIcon);

        onePlayerButton.setBounds(412, 274, 256, 104);
        twoPlayerButton.setBounds(412, 411, 256, 104);
        helpButton.setBounds(412, 550, 256, 104);

        add(onePlayerButton);
        add(twoPlayerButton);
        add(helpButton);
        onePlayerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("111");
                view.initOnePlayerPanel();
            }
        });

        helpButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("123");
                view.initHelpPanel();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D d2 = (Graphics2D) g;
        d2.drawImage(getImage("mainUpNew"), 0, 0, this);
        d2.drawImage(getImage("mainL"), 0, 274, this);
        d2.drawImage(getImage("mainR"), 668, 274, this);
    }

}
