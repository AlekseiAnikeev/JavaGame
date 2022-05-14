package seabattle;

import mvc.ViewGUI;
import mvc.util.Coordinate;
import mvc.util.Ranges;

/**
 * �������� �����
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public class SeaBattle {
    //���������� ��������
    public static final int COLS = 11;
    //���������� �����
    public static final int ROWS = 11;
    //������ �������� � ��������, ������� � ��� ����� = 50x50
    public static final int IMAGE_SIZE = 40;

    public static void main(String[] args) {
        ViewGUI view = new ViewGUI();
        //������ ������ ���� ��� �������� � ������ Ranges
        Ranges.setSize(new Coordinate(COLS, ROWS));
        view.initMainMenu();
    }
}
