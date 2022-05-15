package mvc.panels;

import mvc.ViewGUI;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class PlayerField extends JPanel {
    private ViewGUI view;
    public PlayerField(ViewGUI view, int weight, int height) {
        this.view = view;
        setLayout(null);
        setPreferredSize(new Dimension(weight,height));
    }
}
