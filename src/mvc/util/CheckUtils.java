package mvc.util;

import mvc.GameField;
import mvc.panels.OnePlayerPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static mvc.GameField.*;
import static mvc.util.GameObject.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 11.05.2022
 */
public class CheckUtils {
    private static final Random random = new Random();

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
    public static List<Coordinate> getShipCoordinates(OnePlayerPanel panel, Coordinate coord, int placement, int countOfDecks) {
        List<Coordinate> shipCoord = new ArrayList<>();
        if (placement == 1) {
            if (panel.getCountDeck() == 2 || countOfDecks == 2) {
                if (coord.y() > 9) {
                    shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x(), coord.y() + 1));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        if (coord.y() >= 2) {
                            shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                            shipCoord.add(coord);
                        } else
                            return null;
                    }
                }
            } else if (panel.getCountDeck() == 3 || countOfDecks == 3) {
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
                        if (coord.y() >= 3) {
                            shipCoord.add(new Coordinate(coord.x(), coord.y() - 2));
                            shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                            shipCoord.add(coord);
                        } else
                            return null;
                    }
                }
            } else if (panel.getCountDeck() == 4 || countOfDecks == 4) {
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
                        if (coord.y() >= 4) {
                            shipCoord.add(new Coordinate(coord.x(), coord.y() - 3));
                            shipCoord.add(new Coordinate(coord.x(), coord.y() - 2));
                            shipCoord.add(new Coordinate(coord.x(), coord.y() - 1));
                            shipCoord.add(coord);
                        } else
                            return null;
                    }
                }
            }
        } else {
            if (panel.getCountDeck() == 2 || countOfDecks == 2) {
                if (coord.x() > 9) {
                    shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                    shipCoord.add(coord);
                } else {
                    shipCoord.add(coord);
                    shipCoord.add(new Coordinate(coord.x() + 1, coord.y()));
                    if (!isIntersectionPair(panel.getGameField1(), shipCoord)) {
                        shipCoord.clear();
                        if (coord.x() >= 2) {
                            shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                            shipCoord.add(coord);
                        } else
                            return null;
                    }
                }
            } else if (panel.getCountDeck() == 3 || countOfDecks == 3) {
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
                        if (coord.x() >= 3) {
                            shipCoord.add(new Coordinate(coord.x() - 2, coord.y()));
                            shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                            shipCoord.add(coord);
                        } else
                            return null;
                    }
                }
            } else if (panel.getCountDeck() == 4 || countOfDecks == 4) {
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
                        if (coord.x() >= 4) {
                            shipCoord.add(new Coordinate(coord.x() - 3, coord.y()));
                            shipCoord.add(new Coordinate(coord.x() - 2, coord.y()));
                            shipCoord.add(new Coordinate(coord.x() - 1, coord.y()));
                            shipCoord.add(coord);
                        } else
                            return null;
                    }
                }
            }
        }
        return shipCoord;
    }

    public static String numberOfShips(int countOfDecks) {
        String text = switch (countOfDecks) {
            case 1 -> "4";
            case 2 -> "3";
            case 3 -> "2";
            case 4 -> "1";
            default -> "ќшибка";
        };
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
        List<Coordinate> shipCoord = CheckUtils.getShipCoordinates(panel, coord, panel.getPlacement(), panel.getCountDeck());
        //если координата кос€чна€ выдаем сабж
        if (Objects.requireNonNull(shipCoord).size() > 1 && !isIntersectionPair(panel.getGameField1(), shipCoord)) {
            CheckUtils.callInformationWindow("ћежду корабл€ми должна быть минимум одна клетка, корабли не должны пересекатьс€!");
            return null;
        }
        return shipCoord;
    }

    /**
     * метод дл€ проверки о заполнение кораблей на поле
     */
    public static boolean fieldIsFilled() {
        return GameField.getOneDeckCount() == 0 && GameField.getTwoDeckCount() == 0
                && GameField.getThreeDeckCount() == 0 && GameField.getFourDeckCount() == 0;
    }

    /**
     * метод авто заполнени€ пол€
     */
    public static void autoCompletionOfTheField(OnePlayerPanel panel) {
        boolean isVertical;
        int placement;
        int countDeck;
        int countOfDecks;
        GameObject gameObject;
        Coordinate coord;
        List<Coordinate> listCoord;
        while (getFourDeckCount() != 0) {
            countOfDecks = getFourDeckCount();
            isVertical = random.nextInt(2) == 0;
            placement = isVertical ? 1 : 2;
            countDeck = 4;
            coord = new Coordinate(random.nextInt(10) + 1, random.nextInt(10) + 1);
            listCoord = getShipCoordinates(panel, coord, placement, countDeck);
            if (listCoord == null) {
                continue;
            }
            if (placement == 1) {
                gameObject = NOS_V_4;
            } else {
                gameObject = GameObject.ZAD_4;
            }

            if (isIntersectionPair(panel.getGameField1(), listCoord)) {
                panel.getGameField1().addPairObjectInField(panel.getGameField1().getShipField(), listCoord, gameObject, countDeck);
                panel.getGameField1().addHaloPairShipInField(panel.getGameField1().getShipField(), Ranges.getCoordinateAroundPair(listCoord));
            } else {
                continue;
            }
            setFourDeckCount(--countOfDecks);
            panel.setNameFourDeck(countOfDecks);
        }
        while (getThreeDeckCount() != 0) {
            countOfDecks = getThreeDeckCount();
            isVertical = random.nextInt(2) == 0;
            placement = isVertical ? 1 : 2;
            countDeck = 3;
            coord = new Coordinate(random.nextInt(10) + 1, random.nextInt(10) + 1);
            listCoord = getShipCoordinates(panel, coord, placement, countDeck);
            if (listCoord == null) {
                continue;
            }
            if (placement == 1) {
                gameObject = NOS_V_3;
            } else {
                gameObject = GameObject.ZAD_3;
            }
            if (isIntersectionPair(panel.getGameField1(), listCoord)) {
                panel.getGameField1().addPairObjectInField(panel.getGameField1().getShipField(), listCoord, gameObject, countDeck);
                panel.getGameField1().addHaloPairShipInField(panel.getGameField1().getShipField(), Ranges.getCoordinateAroundPair(listCoord));
            } else {
                continue;
            }
            setThreeDeckCount(--countOfDecks);
            panel.setNameThreeDeck(countOfDecks);
        }
        while (getTwoDeckCount() != 0) {
            countOfDecks = getTwoDeckCount();
            isVertical = random.nextInt(2) == 0;
            placement = isVertical ? 1 : 2;
            countDeck = 2;
            coord = new Coordinate(random.nextInt(10) + 1, random.nextInt(10) + 1);
            listCoord = getShipCoordinates(panel, coord, placement, countDeck);
            if (listCoord == null) {
                continue;
            }
            if (placement == 1) {
                gameObject = NOS_V_2;
            } else {
                gameObject = GameObject.ZAD_2;
            }
            if (isIntersectionPair(panel.getGameField1(), listCoord)) {
                panel.getGameField1().addPairObjectInField(panel.getGameField1().getShipField(), listCoord, gameObject, countDeck);
                panel.getGameField1().addHaloPairShipInField(panel.getGameField1().getShipField(), Ranges.getCoordinateAroundPair(listCoord));
            } else {
                continue;
            }
            setTwoDeckCount(--countOfDecks);
            panel.setNameTwoDeck(countOfDecks);
        }
        while (getOneDeckCount() != 0) {
            countOfDecks = getOneDeckCount();
            isVertical = random.nextInt(2) == 0;
            coord = new Coordinate(random.nextInt(10) + 1, random.nextInt(10) + 1);
            if (isIntersection(panel.getGameField1(), coord)) {
                if (isVertical) {
                    panel.getGameField1().getShipField()[coord.x()][coord.y()] = GameObject.ONE_DECK_SHIP_V;
                } else {
                    panel.getGameField1().getShipField()[coord.x()][coord.y()] = GameObject.ONE_DECK_SHIP;
                }
                panel.getGameField1().addHaloShipInField(panel.getGameField1().getShipField(), coord);
                setOneDeckCount(--countOfDecks);
                panel.setNameOneDeck(countOfDecks);
            }
        }
    }
}
