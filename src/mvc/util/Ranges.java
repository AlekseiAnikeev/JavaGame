package mvc.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 28.04.2022
 */
public class Ranges {
    private static Coordinate size;
    //описание всех координат
    private static List<Coordinate> allCoordinates;
    //статическое поле для генератора случайных цифер

    private static final Random random = new Random();

    public static void setSize(Coordinate sized) {
        size = sized;
        allCoordinates = new ArrayList<>();
        for (int y = 0; y < size.y(); y++) {
            for (int x = 0; x < size.x(); x++) {
                allCoordinates.add(new Coordinate(x, y));
            }
        }
    }

    public static List<Coordinate> getAllCoordinates() {
        return allCoordinates;
    }

    public static Coordinate getSize() {
        return size;
    }

    /**
     * /проверка на координаты, дабы не выйти за пределы поля
     */
    public static boolean inRange(Coordinate coord) {
        return coord.x() >= 1 && coord.x() < size.x() &&
                coord.y() >= 1 && coord.y() < size.y();
    }


    /**
     * метод возвращяющий случайную координату
     */
    static Coordinate getRandomCoordinate() {
        return new Coordinate(random.nextInt(size.x()),
                random.nextInt(size.y()));
    }

    /**
     * метод для перебора клеток расположенных вокруг заданной
     */
    public static List<Coordinate> getCoordinateAround(Coordinate coordinate) {
        Coordinate around;
        List<Coordinate> list = new ArrayList<>();
        //проходим от х -1 до х + 1
        for (int x = coordinate.x() - 1; x <= coordinate.x() + 1; x++) {
            //проходим от у -1 до у + 1
            for (int y = coordinate.y() - 1; y <= coordinate.y() + 1; y++) {
                //проверка что координаты есть на поле
                if (inRange(around = new Coordinate(x, y))) {
                    //исключаем вводную координату, в классе Coordinate метод equals переопределен дабы сравнивать координаты, а не объекты.
                    if (!around.equals(coordinate)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }

    /**
     * метод для перебора клеток расположенных вокруг заданных точек
     */
    public static List<Coordinate> getCoordinateAroundPair(List<Coordinate> coordinate) {
        //находим минимальную и максимальную координату
        Coordinate start = coordinate.get(0).x() < coordinate.get(coordinate.size() - 1).x()
                || coordinate.get(0).y() < coordinate.get(coordinate.size() - 1).y() ? coordinate.get(0) : coordinate.get(coordinate.size() - 1);
        Coordinate finish = coordinate.get(0).x() > coordinate.get(coordinate.size() - 1).x()
                || coordinate.get(0).y() > coordinate.get(coordinate.size() - 1).y() ? coordinate.get(0) : coordinate.get(coordinate.size() - 1);
        System.out.println(coordinate);
        System.out.println(start);
        System.out.println("x = " + start.x() + " , y = " + start.y());
        System.out.println(finish);
        System.out.println("x = " + finish.x() + " , y = " + finish.y());
        Coordinate around;
        List<Coordinate> list = new ArrayList<>();
        //проходим от х -1 до х + 1
        for (int x = start.x() - 1; x <= finish.x() + 1; x++) {
            //проходим от у -1 до у + 1
            for (int y = start.y() - 1; y <= finish.y() + 1; y++) {
                //проверка что координаты есть на поле
                if (inRange(around = new Coordinate(x, y))) {
                    //исключаем вводную координату, в классе Coordinate метод equals переопределен дабы сравнивать координаты, а не объекты.
                    if (!coordinate.contains(around)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }
}
