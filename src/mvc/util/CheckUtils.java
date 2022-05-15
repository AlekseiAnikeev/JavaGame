package mvc.util;

import mvc.GameField;
import mvc.panels.OnePlayerPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 11.05.2022
 */
public class CheckUtils {

    //ѕересечение с ореолом либо кораблем
    public static boolean isIntersection(GameField shipField, Coordinate coordinate) {
        return shipField.getShipField()[coordinate.x()][coordinate.y()].getNumber() == 0;
    }

    public static boolean isIntersectionPair(GameField shipField, List<Coordinate> coordinate) {
        for (Coordinate coord : coordinate) {
            if (shipField.getShipField()[coord.x()][coord.y()].getNumber() != 0) {
                return false;
            }
        }
        return true;
    }


    //метод дл€ вызова информационного диалогового окна с заданным текстом
    public static void callInformationWindow(String message) {
        JOptionPane.showMessageDialog(
                null, message,
                "¬нимание!", JOptionPane.ERROR_MESSAGE
        );
    }

    /**
     * метод получени€ координат корабл€ в зависимости от количества палуб
     */
    public static List<Coordinate> getShipCoordinates(OnePlayerPanel panel, Coordinate coord) {
        List<Coordinate> shipCoord = new ArrayList<>();
        if (panel.getPlacement() == 1) {
            if (panel.getCountDeck() == 2) {
                if (coord.y() > 9) {
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 1));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                        shipCoord.add(coord);
                    }
                }
            } else if (panel.getCountDeck() == 3) {
                if (coord.y() > 8) {
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 2));
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 1));
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 2));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        shipCoord.add(new Coordinate(coord.x(), coord.y() - 2));
                        shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                        shipCoord.add(coord);
                    }
                }
            } else if (panel.getCountDeck() == 4) {
                if (coord.y() > 7) {
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 3));
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 2));
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 1));
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 2));
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 3));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        shipCoord.add(new Coordinate(coord.x(), coord.y() - 3));
                        shipCoord.add(new Coordinate(coord.x(), coord.y() - 2));
                        shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                        shipCoord.add(coord);
                    }
                }
            }
        } else {
            if (panel.getCountDeck() == 2) {
                if (coord.x() > 9) {
                    shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x() + 1, coord.y()));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                        shipCoord.add(coord);
                    }
                }
            } else if (panel.getCountDeck() == 3) {
                if (coord.x() > 8) {
                    shipCoord.add(new Coordinate(coord.x() - 2, coord.y()));
                    shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x() + 1, coord.y()));
                    shipCoord.add(new Coordinate(coord.x() + 2, coord.y()));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        shipCoord.add(new Coordinate(coord.x() - 2, coord.y()));
                        shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                        shipCoord.add(coord);
                    }
                }
            } else if (panel.getCountDeck() == 4) {
                if (coord.x() > 7) {
                    shipCoord.add(new Coordinate(coord.x() - 3, coord.y()));
                    shipCoord.add(new Coordinate(coord.x() - 2, coord.y()));
                    shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x() + 1, coord.y()));
                    shipCoord.add(new Coordinate(coord.x() + 2, coord.y()));
                    shipCoord.add(new Coordinate(coord.x() + 3, coord.y()));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        shipCoord.add(new Coordinate(coord.x() - 3, coord.y()));
                        shipCoord.add(new Coordinate(coord.x() - 2, coord.y()));
                        shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                        shipCoord.add(coord);
                    }
                }
            }
        }
        return shipCoord;
    }

    public static String numberOfShips(int countOfDecks) {
        String text;
        switch (countOfDecks) {
            case 1:
                text = "4";
                break;
            case 2:
                text = "3";
                break;
            case 3:
                text = "2";
                break;
            case 4:
                text = "1";
                break;
            default:
                text = "ќшибка";
        }
        return text;
    }

    public static void printImg(GameObject[][] gameField) {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {

                System.out.print("[" + gameField[j][i].getNumber() + "]" + " ");
            }
            System.out.println();
        }
    }

    public static List<Coordinate> getCoordinates(OnePlayerPanel panel, Coordinate coord) {
        List<Coordinate> shipCoord = CheckUtils.getShipCoordinates(panel, coord);
        //если координата кос€чна€ выдаем сабж
        if (shipCoord.size() > 1 && !isIntersectionPair(panel.getGameField1(), shipCoord)) {
            CheckUtils.callInformationWindow("ћежду корабл€ми должна быть минимум одна клетка, корабли не должны пересекатьс€!");
            return null;
        }
        return shipCoord;
    }
}
