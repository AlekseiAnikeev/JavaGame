package mvc.util;

import javax.swing.*;
import java.awt.*;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 04.05.2022
 */
public enum GameObject {
    ZERO,
    LETTER1,
    NUMBER1,
    LETTER2,
    NUMBER2,
    LETTER3,
    NUMBER3,
    LETTER4,
    NUMBER4,
    LETTER5,
    NUMBER5,
    LETTER6,
    NUMBER6,
    LETTER7,
    NUMBER7,
    LETTER8,
    NUMBER8,
    LETTER9,
    NUMBER9,
    LETTER10,
    NUMBER10;
    public Object image;
    /**
     * метод для получения картинки при помощи имя из перечислений
     */
    public GameObject getNextNumberBox() {
        return GameObject.values()[this.ordinal() + 1];
    }

    public int getNumber() {
        return this.ordinal();
    }
    public static Image getImage(String nameImage) {
        //определяем имя картинки(выбираем директорию, имя и расширение(у нас все png в директории img))
        String fileName = "res/img/" + nameImage.toLowerCase() + ".png";
        //создадим объект ImageIcon из нашего файла
        ImageIcon icon = new ImageIcon(fileName);
        //возврат картинке через getImage()
        return icon.getImage();
    }


}
