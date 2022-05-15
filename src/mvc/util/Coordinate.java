package mvc.util;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 10.05.2022
 */
public record Coordinate(int x, int y) {

    @Override
    public boolean equals(Object o) {
        //если переданный обьект €вл€етс€ обьектом Coordinate то возвращ€ем сравнение
        if (o instanceof Coordinate) {
            return ((Coordinate) o).x() == x() && ((Coordinate) o).y() == y();
        }
        //если не так то возврат базового equals
        return false;
    }
}
