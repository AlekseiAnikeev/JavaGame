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
 * класс JFrame в котором выбираются необходимые панели
 *
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class ViewGUI extends JFrame {
    private Coordinate coord;
    //Панель для соло игры
    private OnePlayerPanel onePlayerPanel;
    //размер окна игровых панелей
    private final int MAIN_SCREEN_WIDTH = 1080;
    private final int MAIN_SCREEN_HEIGHT = 674;

    public ViewGUI() {
        //метод для закрытия приложения при клике на Х
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //название окна
        setTitle("Морской Бой");
        //запрет изменения размера
        setResizable(false);
        //делаем окно видимым
        setVisible(true);
        //метод pack устанавливает минимальный размер контейнера, что бы отобразить все элементы
        pack();
        //запуск по центру экрана
        setLocationRelativeTo(null);
        // делаем иконку приложения
        setIconImage(GameObject.getImage("icon"));
    }

    //метод для инициализации основной панели
    public void initMainMenu() {
        //метод очистки JFrame, если не вызвать, то сохранится часть интерфейса с предыдущего jPanel
        getContentPane().removeAll();
        //Панель основного меню
        add(new MainPanel(this, MAIN_SCREEN_WIDTH, MAIN_SCREEN_HEIGHT));
        pack();
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
    }

    /**
     * метод для инициализации панели помощи
     */

    public void initHelpPanel() {
        getContentPane().removeAll();
        //Панель помощи
        add(new HelpPanel(this, MAIN_SCREEN_WIDTH, MAIN_SCREEN_HEIGHT));

        pack();
        setLocationRelativeTo(null);
        revalidate();
        setVisible(true);
    }

    /**
     * метод для инициализации панели на одного игрока
     */
    public void initOnePlayerPanel() {
        getContentPane().removeAll();
        add(onePlayerPanel = new OnePlayerPanel(this, MAIN_SCREEN_WIDTH, MAIN_SCREEN_HEIGHT));
        GameField gameField = new GameField();
        //слушатель мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //получаем координату по х и у с курсора при клике
                int x = e.getX() / IMAGE_SIZE - 15;
                int y = e.getY() / IMAGE_SIZE - 3;
                System.out.println("мыш адаптер в viewGUI");
                System.out.println("по х: " + (x) + "\n"
                        + "по у: " + (y));
                //получаем новую координату
                coord = new Coordinate(x, y);
                //проверяем координату на выход за пределы игрового поля
                if (inRange(coord)) {
                    if(onePlayerPanel.getCountDeck() > 0) {
                        if(onePlayerPanel.getPlacement() > 0) {
                            GameField.drawShip(onePlayerPanel, coord);
                        } else {
                            CheckUtils.callInformationWindow("Не выбрана ориентация размещения.");
                        }
                    } else {
                        CheckUtils.callInformationWindow("Не выбран тип корабля!");
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
