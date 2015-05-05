package Tema14;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class VentanaMadre extends JFrame{
    private JButton boton;
    int ancho;
    int alto;
    ArrayList a;
    public static void main(String args[]){
        VentanaMadre v = new VentanaMadre("Ventana Madre");
    }
    VentanaMadre(String titulo){
        super(titulo);
        ancho=200;
        alto=200;
        a=new ArrayList();
        setBounds(0, 0, alto, ancho);
        setVisible(true);
        setLayout(new BorderLayout());
        boton = new JButton("Abrir Ventana");
        JPanel centro = new JPanel(new FlowLayout());
        centro.setBackground(Color.red);     
        centro.add(boton);
        add(centro,BorderLayout.CENTER);
        boton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                crearVentana();
            }
        });
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                VentanaHija h;
                for(int i=0;i<a.size();i++){
                    h=(VentanaHija)a.get(i);
                    h.dispose();
                }
                a.clear();
                dispose();
            }
        });
        
    }
    private void crearVentana(){
        a.add(new VentanaHija(a.size()*60,a.size()*60));
    }
}
class VentanaHija extends JFrame{
    int ancho;
    int alto;
    VentanaHija(int x, int y){
        super("Ventana Hija");
        ancho=200;
        alto=200;
        setBounds(x, y, alto, ancho);
        setVisible(true);
        JPanel centro = new JPanel(new FlowLayout());
        centro.setBackground(Color.YELLOW);
        add(centro,BorderLayout.CENTER);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
    }
}
