package volcarimagen;

import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class VISTA {

    public static BufferedImage imagen;
    public static BufferedImage imagen2;

    public static void main(String[] args) {
        imagen = new BufferedImage(300, 300, TYPE_INT_RGB);
        imagen2 = new BufferedImage(300, 300, TYPE_INT_RGB);
        new Ventana();
    }
}
