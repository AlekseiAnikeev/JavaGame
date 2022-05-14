package seabattle;

import mvc.ViewGUI;
import mvc.util.Coordinate;
import mvc.util.Ranges;

/**
 * Основной класс
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class SeaBattle {
    //количество столбцов
    public static final int COLS = 11;
    //количество строк
    public static final int ROWS = 11;
    //размер картинки в пикселях, которые у нас будут = 50x50
    public static final int IMAGE_SIZE = 40;

    public static void main(String[] args) {
        ViewGUI view = new ViewGUI();
        //задаем размер поля для проверок в классе Ranges
        Ranges.setSize(new Coordinate(COLS, ROWS));
        view.initMainMenu();
    }
}
