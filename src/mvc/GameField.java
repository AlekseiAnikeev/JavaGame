package mvc;

import mvc.panels.OnePlayerPanel;
import mvc.util.CheckUtils;
import mvc.util.Coordinate;
import mvc.util.GameObject;
import mvc.util.Ranges;
import java.util.List;

import static mvc.util.CheckUtils.*;
import static mvc.util.GameObject.*;
import static seabattle.SeaBattle.COLS;
import static seabattle.SeaBattle.ROWS;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 06.05.2022
 */
public class GameField {
    private GameObject[][] shipField;
    private GameObject[][] shotField;
    //оставшееся количество кораблей
    private static int oneDeckCount = 4;
    private static int twoDeckCount = 3;
    private static int threeDeckCount = 2;
    private static int fourDeckCount = 1;

    public GameField() {
        shipEmptyFieldFilling();
        shotEmptyFieldFilling();

    }

    /**
     * метод заполнения пустого игрового поля
     */
    private void shipEmptyFieldFilling() {
        shipField = new GameObject[COLS][ROWS];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    shipField[i][j] = GameObject.ZERO;
                    //если это первый столбец то присваиваем значение картинок с буквами
                } else if (i == 0 && j != 0) {
                    String text = "LETTER" + j;
                    shipField[j][i] = GameObject.valueOf(text);
                } else if (i != 0 && j == 0) {
                    String text = "NUMBER" + i;
                    shipField[j][i] = GameObject.valueOf(text);
                } else
                    shipField[i][j] = GameObject.ZERO;
            }
        }
    }

    /**
     * Метод заполнения пустого поля для выстрелов
     */
    private void shotEmptyFieldFilling() {
        shotField = new GameObject[COLS][ROWS];
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0 && j == 0) {
                    shotField[i][j] = GameObject.ZERO;
                    //если это первый столбец то присваиваем значение картинок с буквами
                } else if (i == 0) {
                    String text = "LETTER" + j;
                    shotField[i][j] = GameObject.valueOf(text);
                } else if (j == 0) {
                    String text = "NUMBER" + i;
                    shotField[i][j] = GameObject.valueOf(text);
                } else
                    shotField[i][j] = GameObject.ZERO;
            }
        }
    }

    public GameObject[][] getShipField() {
        return shipField;
    }

    public GameObject[][] getEmptyShipField() {
        shipEmptyFieldFilling();
        return shipField;
    }

    public GameObject[][] getShotField() {
        return shotField;
    }

    public void addObjectInField(GameObject[][] field, Coordinate coord, GameObject object) {
        //по координатам заменяем значение на поле(в Матрице)
        field[coord.x()][coord.y()] = object;
    }

    public void addPairObjectInField(GameObject[][] field, List<Coordinate> coordinate, GameObject object, int countOfDeck) {
        //по координатам заменяем значение на поле(в Матрице)
        GameObject obj = object;
        for (Coordinate coord : coordinate) {
            field[coord.x()][coord.y()] = obj;
            obj = GameObject.values()[obj.getNumber()-1];
        }

    }

    public void addHaloShipInField(GameObject[][] field, Coordinate coordinate) {
        List<Coordinate> aroundCoord = Ranges.getCoordinateAround(coordinate);
        for (Coordinate c : aroundCoord) {
            field[c.x()][c.y()] = GameObject.OREOL;
        }
    }

    public void addHaloPairShipInField(GameObject[][] field, List<Coordinate> aroundCoord) {
        System.out.println(aroundCoord);
        for (Coordinate c : aroundCoord) {
            field[c.x()][c.y()] = OREOL;
        }
    }

    public static void drawShip(OnePlayerPanel panel, Coordinate coord) {
        GameObject gameObject;
        if (panel.getCountDeck() == 1) {
            if (oneDeckCount != 0) {
                if (isIntersection(panel.getGameField1(), coord)) {
                    panel.setNameOneDeck(--oneDeckCount);
                    if(panel.getPlacement() == 1){
                        gameObject = ONE_DECK_SHIP_V;
                    } else {
                        gameObject = ONE_DECK_SHIP;
                    }
                    panel.getGameField1().addObjectInField(panel.getGameField1().getShipField(), coord, gameObject);
                    panel.getGameField1().addHaloShipInField(panel.getGameField1().getShipField(), coord);
                } else {
                    CheckUtils.callInformationWindow("Между кораблями должна быть минимум одна клетка, корабли не должны пересекаться!");
                }
            } else {
                CheckUtils.callInformationWindow("Кораблей данного типа может быть только 4.");
            }
        } else if (panel.getCountDeck() > 1) {
            List<Coordinate> shipCoord;
            switch (panel.getCountDeck()) {
                case 2:
                    if (twoDeckCount != 0) {
                        shipCoord = getCoordinates(panel, coord);
                        if (shipCoord == null) return;
                        panel.setNameTwoDeck(--twoDeckCount);
                        if(panel.getPlacement() == 1){
                            gameObject = NOS_V_2;
                        } else {
                            gameObject = ZAD_2;
                        }
                    } else {
                        CheckUtils.callInformationWindow("Кораблей данного типа может быть только 3.");
                        return;
                    }
                    break;
                case 3:
                    if (threeDeckCount != 0) {
                        shipCoord = getCoordinates(panel, coord);
                        if (shipCoord == null) return;
                        panel.setNameThreeDeck(--threeDeckCount);
                        if(panel.getPlacement() == 1){
                            gameObject = NOS_V_3;
                        } else {
                            gameObject = ZAD_3;
                        }
                    } else {
                        CheckUtils.callInformationWindow("Кораблей данного типа может быть только 2.");
                        return;
                    }
                    break;
                default:
                    if (fourDeckCount != 0) {
                        shipCoord = getCoordinates(panel, coord);
                        if (shipCoord == null) return;
                        panel.setNameFourDeck(--fourDeckCount);
                        if(panel.getPlacement() == 1){
                            gameObject = NOS_V_4;
                        } else {
                            gameObject = GameObject.ZAD_4;
                        }
                    } else {
                        CheckUtils.callInformationWindow("Кораблей данного типа может быть только 1.");
                        return;
                    }
            }
            panel.getGameField1().addPairObjectInField(panel.getGameField1().getShipField(), shipCoord, gameObject, panel.getCountDeck());
            panel.getGameField1().addHaloPairShipInField(panel.getGameField1().getShipField(), Ranges.getCoordinateAroundPair(shipCoord));
        }
    }

    public static int getOneDeckCount() {
        return oneDeckCount;
    }

    public static void setOneDeckCount(int oneDeckCount) {
        GameField.oneDeckCount = oneDeckCount;
    }

    public static int getTwoDeckCount() {
        return twoDeckCount;
    }

    public static void setTwoDeckCount(int twoDeckCount) {
        GameField.twoDeckCount = twoDeckCount;
    }

    public static int getThreeDeckCount() {
        return threeDeckCount;
    }

    public static void setThreeDeckCount(int threeDeckCount) {
        GameField.threeDeckCount = threeDeckCount;
    }

    public static int getFourDeckCount() {
        return fourDeckCount;
    }

    public static void setFourDeckCount(int fourDeckCount) {
        GameField.fourDeckCount = fourDeckCount;
    }
}
