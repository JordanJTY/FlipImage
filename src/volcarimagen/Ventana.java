package volcarimagen;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ventana extends JFrame {

    public Ventana() {
        setSize(900, 650);// Tamaño de la ventana  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //botón para voltear horizontalmente
        JButton b = new JButton("Voltear imagen horizontalmente");
        b.setBounds(610, 25, 250, 40);
        add(b);
        //botón para voltear verticalmente
        JButton c = new JButton("Voltear imagen verticalmente");
        c.setBounds(610, 75, 250, 40);
        add(c);
        //botón para rotar xº
        JButton k = new JButton("Rotar imagen");
        k.setBounds(610, 125, 250, 40);
        add(k);
        //JTextField para introducir xº
        JTextField t = new JTextField();
        t.setBounds(610, 175, 70, 40);
        add(t);
        //Instanciamos el dibujo
        Dibujo d = new Dibujo();
        add(d);
        setVisible(true);
        //Acción del botón de voltear horizontalmente
        b.addActionListener((ActionEvent e) -> {
            d.repaint();
            d.paint1 = true;
        });
        //Acción del botón de voltear verticalmente
        c.addActionListener((ActionEvent e) -> {
            d.repaint();
            d.paint2 = true;
        });
        //Acción de botón para rotar
        k.addActionListener((ActionEvent e) -> {
            d.repaint();
            d.paint3 = true;
            d.angulo = Integer.parseInt(t.getText());
        });
    }
}
