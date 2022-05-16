package mvc;

import mvc.panels.*;
import mvc.util.CheckUtils;
import mvc.util.Coordinate;
import mvc.util.GameObject;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static mvc.util.Ranges.inRange;
import static seabattle.SeaBattle.*;


/**
 * ����� JFrame � ������� ���������� ����������� ������
 *
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class ViewGUI extends JFrame {
    private Coordinate coord;
    //������ ��� ���� ����
    private OnePlayerPanel onePlayerPanel;
    //������ ���� ������� �������
    private final int MAIN_SCREEN_WIDTH = 1080;
    private final int MAIN_SCREEN_HEIGHT = 674;

    public ViewGUI() {
        //����� ��� �������� ���������� ��� ����� �� �
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //�������� ����
        setTitle("������� ���");
        //������ ��������� �������
        setResizable(false);
        //������ ���� �������
        setVisible(true);
        //����� pack ������������� ����������� ������ ����������, ��� �� ���������� ��� ��������
        pack();
        //������ �� ������ ������
        setLocationRelativeTo(null);
        // ������ ������ ����������
        setIconImage(GameObject.getImage("icon"));
    }

    //����� ��� ������������� �������� ������
    public void initMainMenu() {
        //����� ������� JFrame, ���� �� �������, �� ���������� ����� ���������� � ����������� jPanel
        getContentPane().removeAll();
        //������ ��������� ����
        add(new MainPanel(this, MAIN_SCREEN_WIDTH, MAIN_SCREEN_HEIGHT));
        pack();
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
    }

    /**
     * ����� ��� ������������� ������ ������
     */

    public void initHelpPanel() {
        getContentPane().removeAll();
        //������ ������
        add(new HelpPanel(this, MAIN_SCREEN_WIDTH, MAIN_SCREEN_HEIGHT));

        pack();
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
    }

    /**
     * ����� ��� ������������� ������ �� ������ ������
     */
    public void initOnePlayerPanel() {
        getContentPane().removeAll();
        add(onePlayerPanel = new OnePlayerPanel(this, MAIN_SCREEN_WIDTH, MAIN_SCREEN_HEIGHT));
        GameField gameField = new GameField();
        //��������� ����
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //�������� ���������� �� � � � � ������� ��� �����
                int x = e.getX() / IMAGE_SIZE - 15;
                int y = e.getY() / IMAGE_SIZE - 3;
                System.out.println("��� ������� � viewGUI");
                System.out.println("�� �: " + (x) + "\n"
                        + "�� �: " + (y));
                //�������� ����� ����������
                coord = new Coordinate(x, y);
                //��������� ���������� �� ����� �� ������� �������� ����
                if (inRange(coord)) {
                    if(onePlayerPanel.getCountDeck() > 0) {
                        if(onePlayerPanel.getPlacement() > 0) {
                            GameField.drawShip(onePlayerPanel, coord);
                        } else {
                            CheckUtils.callInformationWindow("�� ������� ���������� ����������.");
                        }
                    } else {
                        CheckUtils.callInformationWindow("�� ������ ��� �������!");
                    }
                    CheckUtils.printImg(onePlayerPanel.getGameField1().getShipField());
                }
                repaint();
            }
        });
        pack();
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
    }
}
