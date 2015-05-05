package Tema14;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
public class EjercicioHistorialPulsaciones extends JFrame{
    int alto;
    int ancho;
    JTextArea ta1,ta2;
    JButton b1;
    JButton b2;
    JPanel p1,p2,p3;
    JScrollPane sp1;
    int Contadora;
    int Contadorb;
    static int asd;
    public static void main(String args[]){
        EjercicioHistorialPulsaciones e = new EjercicioHistorialPulsaciones();
    }
    EjercicioHistorialPulsaciones(){
        super();
        alto=250;
        ancho=400;
        setBounds(0, 0, ancho, alto);
        setResizable(false);
        setLayout(new GridLayout(3,0));
        ta2=new JTextArea();
        ta2.setEditable(false);
        sp1= new JScrollPane(ta2);
        p1=new JPanel(new FlowLayout());
        p2=new JPanel(new FlowLayout());
        add(p1);
        add(p2);
        add(sp1);
        ta1=new JTextArea();
        ta1.setEditable(false);
        ta1.setText("Pulsado 0 veces el botón primero");
        ta1.setSize(30,30);
        p1.add(ta1);
        b1=new JButton("Primero");    
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Contadora++;
                cambiarTexto("Primero",Contadora);
            }
        });
        b2=new JButton("Segundo");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Contadorb++;
                cambiarTexto("Segundo",Contadorb);
            }
        });
        p2.add(b1);
        p2.add(b2);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               cerrarVentana();
           } 
        });
        
    }
    public void cambiarTexto(String t, int b){
        ta1.setText("Pulsado"+b+" veces el botón "+ t +"");
        ta2.setText(ta2.getText()+"Pulsado"+b+" veces el botón "+ t +"\n");
        if(b==10)
            if(t.matches("Primero"))
                new VentanaSecundaria(0);
            else
                new VentanaSecundaria(1);
    }
    public void cerrarVentana(){
        dispose();
        
    }
}
class VentanaSecundaria extends Frame{
    VentanaSecundaria(int a){
        if(a==0){
            setName("Boton Primero");
        }
        else{
            setName("Boton Segundo");
        }
        setVisible(true);
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               dispose();
           } 
        });
    }
}
