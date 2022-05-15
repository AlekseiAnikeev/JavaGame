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
    //�������� ���� ���������
    private static List<Coordinate> allCoordinates;
    //����������� ���� ��� ���������� ��������� �����

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
     * /�������� �� ����������, ���� �� ����� �� ������� ����
     */
    public static boolean inRange(Coordinate coord) {
        return coord.x() >= 1 && coord.x() < size.x() &&
                coord.y() >= 1 && coord.y() < size.y();
    }


    /**
     * ����� ������������ ��������� ����������
     */
    static Coordinate getRandomCoordinate() {
        return new Coordinate(random.nextInt(size.x()),
                random.nextInt(size.y()));
    }

    /**
     * ����� ��� �������� ������ ������������� ������ ��������
     */
    public static List<Coordinate> getCoordinateAround(Coordinate coordinate) {
        Coordinate around;
        List<Coordinate> list = new ArrayList<>();
        //�������� �� � -1 �� � + 1
        for (int x = coordinate.x() - 1; x <= coordinate.x() + 1; x++) {
            //�������� �� � -1 �� � + 1
            for (int y = coordinate.y() - 1; y <= coordinate.y() + 1; y++) {
                //�������� ��� ���������� ���� �� ����
                if (inRange(around = new Coordinate(x, y))) {
                    //��������� ������� ����������, � ������ Coordinate ����� equals ������������� ���� ���������� ����������, � �� �������.
                    if (!around.equals(coordinate)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }

    /**
     * ����� ��� �������� ������ ������������� ������ �������� �����
     */
    public static List<Coordinate> getCoordinateAroundPair(List<Coordinate> coordinate) {
        //������� ����������� � ������������ ����������
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
        //�������� �� � -1 �� � + 1
        for (int x = start.x() - 1; x <= finish.x() + 1; x++) {
            //�������� �� � -1 �� � + 1
            for (int y = start.y() - 1; y <= finish.y() + 1; y++) {
                //�������� ��� ���������� ���� �� ����
                if (inRange(around = new Coordinate(x, y))) {
                    //��������� ������� ����������, � ������ Coordinate ����� equals ������������� ���� ���������� ����������, � �� �������.
                    if (!coordinate.contains(around)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }
}
