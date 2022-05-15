package mvc.util;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 10.05.2022
 */
public record Coordinate(int x, int y) {

    @Override
    public boolean equals(Object o) {
        //���� ���������� ������ �������� �������� Coordinate �� ���������� ���������
        if (o instanceof Coordinate) {
            return ((Coordinate) o).x() == x() && ((Coordinate) o).y() == y();
        }
        //���� �� ��� �� ������� �������� equals
        return false;
    }
}
