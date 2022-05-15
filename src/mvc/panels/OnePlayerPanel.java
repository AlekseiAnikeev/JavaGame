package mvc.panels;

import mvc.GameField;
import mvc.ViewGUI;
import seabattle.SeaBattle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static mvc.util.GameObject.getImage;
import static seabattle.SeaBattle.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 06.05.2022
 */
public class OnePlayerPanel extends JPanel {
    private ViewGUI view;
    private JButton exitButton;
    private JButton startButton;
    public JButton clearingTheFieldButton;
    private JRadioButton oneDeck;
    private JRadioButton twoDeck;
    private JRadioButton threeDeck;
    private JRadioButton fourDeck;
    private JRadioButton vertical;
    private JRadioButton horizontal;
    private ButtonGroup groupShip;
    private ButtonGroup shipOrientation;
    private Font font;
    private JLabel gameField;
    private JLabel addShipLabel;
    private JLabel addShipLabelName;
    private JLabel ship;
    private JLabel labelOrientation;
    private JLabel clearingTheField;
    private GameField gameField1;


    public OnePlayerPanel(ViewGUI view, int weight, int height) {
        this.view = view;
        gameField1 = new GameField();
        setLayout(null);
        setPreferredSize(new Dimension(weight, height));
        font = new Font("lobster", Font.BOLD, 22);
        initButton();
        addShipLabel();
        initShipLabelName();
        initOrientationAndButton();

        groupShip = new ButtonGroup();
        shipOrientation = new ButtonGroup();

        shipOrientation.add(vertical);
        shipOrientation.add(horizontal);

        groupShip.add(oneDeck);
        groupShip.add(twoDeck);
        groupShip.add(threeDeck);
        groupShip.add(fourDeck);


        add(oneDeck);
        add(twoDeck);
        add(threeDeck);
        add(fourDeck);
        add(vertical);
        add(horizontal);
        add(labelOrientation);
        add(ship);
        add(addShipLabel);
        add(addShipLabelName);
        add(gameField);
        add(clearingTheField);
        add(clearingTheFieldButton);
        add(exitButton);
        add(startButton);
    }

    private void initButton() {
        oneDeck = new JRadioButton();
        //вызвать для перерисовки этот метод
        setNameOneDeck(4);
        oneDeck.setBounds(55, 150, 370, 30);
        twoDeck = new JRadioButton();
        setShipText(3, twoDeck);
        twoDeck.setBounds(55, 174, 370, 30);
        threeDeck = new JRadioButton();
        setShipText(2, threeDeck);
        threeDeck.setBounds(55, 198, 370, 30);
        fourDeck = new JRadioButton();
        setShipText(1, fourDeck);
        fourDeck.setBounds(55, 223, 370, 30);
        exitButton = new JButton();
        exitButton.setFont(font);
        exitButton.setText("Выход");
        exitButton.setMargin(new Insets(2, 8, 2, 8));
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.setOpaque(false);
        exitButton.setBounds(850,600, 200, 40);
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        startButton = new JButton();
        startButton.setFont(font);
        startButton.setText("Старт");
        startButton.setMargin(new Insets(2, 8, 2, 8));
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.setOpaque(false);
        startButton.setBounds(650,600, 200, 40);
    }

    private void initOrientationAndButton() {
        labelOrientation = new JLabel();
        labelOrientation.setFont(font);
        labelOrientation.setText("Выбор ориентации");
        labelOrientation.setBounds(164, 393, 250, 30);
        ship = new JLabel();
        ship.setFont(font);
        ship.setText("корабля:");
        ship.setBounds(210, 416, 100, 30);
        vertical = new JRadioButton("Вертикальная");
        vertical.setFont(font);
        vertical.setBounds(160, 441, 200, 30);
        vertical.setOpaque(false);
        horizontal = new JRadioButton("Горизонтальная");
        horizontal.setOpaque(false);
        horizontal.setFont(font);
        horizontal.setBounds(160, 466, 200, 30);
    }

    private void initShipLabelName() {
        addShipLabelName = new JLabel();
        addShipLabelName.setFont(font);
        addShipLabelName.setText("Выбери тип корабля:");
        addShipLabelName.setBounds(105, 123, 270, 30);
        clearingTheField = new JLabel();
        clearingTheField.setFont(font);
        clearingTheField.setText("Ошибся? Начни с начала:");
        clearingTheField.setBounds(84, 270, 270,30);
        clearingTheFieldButton = new JButton();
        clearingTheFieldButton.setFont(font);
        clearingTheFieldButton.setText("Очистить поле");
        clearingTheFieldButton.setMargin(new Insets(2, 8, 2, 8));
        clearingTheFieldButton.setContentAreaFilled(false);
        clearingTheFieldButton.setFocusPainted(false);
        clearingTheFieldButton.setOpaque(false);
        clearingTheFieldButton.setBounds(100, 320, 200, 30);
        clearingTheFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameField1.getEmptyShipField();
                GameField.setOneDeckCount(4);
                GameField.setTwoDeckCount(3);
                GameField.setThreeDeckCount(2);
                GameField.setFourDeckCount(1);
                setNameOneDeck(4);
                setNameTwoDeck(3);
                setNameThreeDeck(2);
                setNameFourDeck(1);
                repaint();
            }
        });
    }

    public GameField getGameField1() {
        return gameField1;
    }

    private void addShipLabel() {
        gameField = new JLabel();
        Font font2;
        font2 = new Font("lobster", Font.BOLD, 44);
        gameField.setFont(font2);
        gameField.setText("Игровое поле");
        gameField.setBounds(700, 10, 270, 50);
        addShipLabel = new JLabel();
        addShipLabel.setFont(font);
        addShipLabel.setText("Расположение кораблей");
        addShipLabel.setBounds(90, 73, 250, 30);
    }

    private void setShipText(int count, JRadioButton button) {
        String text;
        switch (count) {
            case 4:
                text = "Однопалубный";
                break;
            case 3:
                text = "Двухпалубный";
                break;
            case 2:
                text = "Трехпалубный";
                break;
            default:
                text = "Четырехпалубный";
        }
        Font newFont = new Font("lobster", Font.BOLD, 16);
        button.setFont(newFont);
        button.setText(text + " корабль, осталось: " + count);
        button.setOpaque(false);
    }
    //установка имени радиобаттанов палубности
    public void setNameOneDeck(int count) {
        String text = "Однопалубный корабль, осталось: " + count;
        Font newFont = new Font("lobster", Font.BOLD, 16);
        oneDeck.setFont(newFont);
        oneDeck.setText(text);
        oneDeck.setOpaque(false);
    }

    public void setNameTwoDeck(int count) {
        String text = "Двухпалубный корабль, осталось: " + count;
        twoDeck.setText(text);
    }

    public void setNameThreeDeck(int count) {
        String text = "Трехпалубный корабль, осталось: " + count;
        threeDeck.setText(text);
    }

    public void setNameFourDeck(int count) {
        String text = "Четырехпалубный корабль, осталось: " + count;
        fourDeck.setText(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(getImage("background"), 0, 0, this);
        g2.drawImage(getImage("backgroundSelectPanel"), 0, 0, this);

        fillInTheField(g2);

//        int lol3 = 0;
//        for (int i = 0; i < 12; i++) {
//            int lol = 1080;
//            for (int j = 0; j < 12; j++) {
//                g2.drawImage(getImage("zero2"), lol, lol3, this);
//                lol -= 40;
//            }
//            lol3 += 40;
//        }

    }

    /**
     * метод для отрисовки поля на панели
     */
    private void fillInTheField(Graphics2D g2) {

        int height = 90;
        for (int i = 0; i < 11; i++) {
            int weight = 593;
            for (int j = 0; j < 11; j++) {
                g2.drawImage(getImage(gameField1.getShipField()[j][i].name()), weight, height, this);
                weight += IMAGE_SIZE;
            }
            height += IMAGE_SIZE;
        }
    }

    //возвращает кол-во палуб в зависимости - какой радиоБаттон выбран
    public int getCountDeck() {
        if (oneDeck.isSelected()) return 1;
        else if (twoDeck.isSelected()) return 2;
        else if (threeDeck.isSelected()) return 3;
        else if (fourDeck.isSelected()) return 4;
        else return 0;
    }

    //возвращает число обозначающее какая ориентация корабля выбрана
    public int getPlacement() {
        if (vertical.isSelected()) return 1;
        else if (horizontal.isSelected()) return 2;
        else return 0;
    }

}
