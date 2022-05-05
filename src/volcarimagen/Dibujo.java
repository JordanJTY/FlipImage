package volcarimagen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static volcarimagen.VISTA.imagen;
import static volcarimagen.VISTA.imagen2;

public class Dibujo extends Canvas {

    boolean paint0, paint1, paint2, paint3;
    int angulo;

    int azar(int x) {
        return (int) Math.floor(Math.random() * x);
    }

    public Dibujo() {
        setSize(600, 600);
        this.setBackground(Color.cyan);
        this.repaint();
        paint0 = true;
        paint1 = false;
        paint2 = false;
        paint3 = false;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D k;
        //Dibujamos la imagen inicial una única vez
        if (paint0) {
            int t, x, y;
            int xa, ya;
            float radio = 100;
            int lados = 5;
            double a = 0; //ángulo   
            xa = (int) radio; // ABSCISA DEL PRIMER PUNTO
            ya = 0; // ORDENADA DEL PRIMER PUNTO
            k = (Graphics2D) imagen.getGraphics();
            k.setColor(Color.cyan);
            k.fillRect(0, 0, 300, 300);
            k.setColor(Color.black);
            k.setColor(Color.black);
            for (t = 1; t <= lados; t++) {
                a += ((double) 2 / lados) * Math.PI; // ÁNGULO DEL SIGUIENTE PUNTO
                x = (int) (radio * Math.cos(a));
                y = (int) (radio * Math.sin(a));
                k.drawLine(160 + xa, 160 + ya, 160 + x, 160 + y);
                xa = x;
                ya = y;
            }
            g.drawImage(imagen, 0, 0, null);//Dibujamos la imagen
            //Setteamos todo a false para que no haya problemas al ejecutar la siguiente acción
            paint0 = false;
            paint1 = false;
            paint2 = false;
            paint3 = false;
        }
        //Voltear horizontalmente
        if (paint1) {
            for (int o = 0; o < 300; o++) {
                for (int p = 0; p < 300; p++) {
                    int gg = imagen.getRGB(o, p);
                    imagen2.setRGB(299 - o, p, gg);
                }
            }
            
            g.drawImage(imagen2, 0, 0, null);//Dibujamos la imagen
            //Guardamos el estado de la imagen2 en la variable de imagen para poder manipularla tras haber hecho el cambio
            for (int o = 0; o < 300; o++) {
                for (int p = 0; p < 300; p++) {
                    int gg = imagen2.getRGB(o, p);
                    imagen.setRGB(o, p, gg);
                }
            }
            //Setteamos todo a false para que no haya problemas al ejecutar la siguiente acción
            paint0 = false;
            paint1 = false;
            paint2 = false;
            paint3 = false;
        }
        //Volteamos verticalmente
        if (paint2) {
            for (int o = 0; o < 300; o++) {
                for (int p = 0; p < 300; p++) {
                    int gg = imagen.getRGB(o, p);
                    imagen2.setRGB(o, 299 - p, gg);
                }
            }
            
            g.drawImage(imagen2, 0, 0, null);//Dibujamos la imagen
            //Guardamos el estado de la imagen2 en la variable de imagen para poder manipularla tras haber hecho el cambio
            for (int o = 0; o < 300; o++) {
                for (int p = 0; p < 300; p++) {
                    int gg = imagen2.getRGB(o, p);
                    imagen.setRGB(o, p, gg);
                }
            }
            //Setteamos todo a false para que no haya problemas al ejecutar la siguiente acción
            paint0 = false;
            paint1 = false;
            paint2 = false;
            paint3 = false;
        }
        //Rotamos imagen con los grados que el usuario elija
        if (paint3) {
            int rgb;
            for (int r = 0; r < 300; r++) {
                for (int e = 0; e < 300; e++) {
                    try {
                        rgb = imagen.getRGB(r, e);//Adquirimos los RGB de cada pixel
                        double ang = angulo * Math.PI / 180;//Transformamos el número del usuario en un ángulo
                        //Aplicamos formulas matemáticas para que rote la imagen
                        double x1 = r - 300 / 2;
                        double y1 = e - 300 / 2;

                        double x2 = Math.ceil(x1 * Math.cos(ang) - y1 * Math.sin(ang));
                        double y2 = Math.ceil(x1 * Math.sin(ang) + y1 * Math.cos(ang));

                        double x3 = Math.ceil(x2 + 300 / 2);
                        double y3 = Math.ceil(y2 + 300 / 2);

                        imagen2.setRGB((int) x3, (int) y3, rgb);//Le setteamos cada pixel con el RGB adquirido en la coordenada adecuada
                    } catch (Exception w) {
                    }
                }
            }
            g.drawImage(imagen2, 0, 0, null);//Dibujamos la imagen
            /*for (int r = 0; r < 300; r++) {
                for (int e = 0; e < 300; e++) {
                    try {
                        rgb = imagen2.getRGB(r, e);
                        imagen.setRGB(r, e, rgb);
                    } catch (Exception w) {
                    }
                }
            }*/
            //Setteamos todo a false para que no haya problemas al ejecutar la siguiente acción
            paint0 = false;
            paint1 = false;
            paint2 = false;
            paint3 = false;
        }
    }

    private void setSize(double x3, double y3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
