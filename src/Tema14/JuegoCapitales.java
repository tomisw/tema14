
package Tema14;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class JuegoCapitales extends Applet {
    JPanel p1,p2,p3,p4,p5,p6;
    String paises[],capitales[];
    JScrollPane sp1,sp2;
    JTextArea ta1,ta2,ta3,ta4;
    JTextField tf1;
    JLabel l1,l2,l3,l4;
    JList list1;
    JButton b1,b2;
    ActionListener a;
    private final int oportunidades=3;
    private int contadorAciertos, contadorFallos;
    public void init() {
        arrayPaises();
        setLayout(new BorderLayout());
        contadorAciertos=0;
        contadorFallos=0;
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel(new BorderLayout());        
        p3 = new JPanel(new GridLayout(3,1));
        p4 = new JPanel(new BorderLayout());
        p5 = new JPanel(new GridLayout(2,1));
        p6 = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));
        ta1 = new JTextArea("Escribe en el cuadro de texto la capital de un pais de la lista central,\n seleccionalo y pulsa con el botón \"Comprobar\" con el boton izdo.\n Para borrar la capital escrita y el mensaje de acerito o error pulsa \"BORRAR\".\n Si fallas más de tres veces el programa no te dejará jugar más.\n No intentes modificar tus aciertos o errores porque no vas a poder.");
        ta2 = new JTextArea("0");
        ta3 = new JTextArea("0");
        ta4 = new JTextArea("Esperando respuesta");
        list1 = new JList();
        list1.setListData(paises);
        sp1 = new JScrollPane(ta1);
        sp2 = new JScrollPane(list1);
        tf1 = new JTextField();
        l1 = new JLabel("Escribe la capital");
        l2 = new JLabel("SELECCIONA EL PAÍS",JLabel.CENTER);
        l3 = new JLabel("Aciertos");
        l4 = new JLabel("Errores");
        b1 = new JButton("Comprobar");
        b2 = new JButton("Borrar");
        b1.addActionListener(a = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(capitales[list1.getSelectedIndex()].equalsIgnoreCase(tf1.getText())){
                    int j=0;
                    for(int i=0;i<capitales.length;i++){
                        if(i==list1.getSelectedIndex()){
                            capitales[list1.getSelectedIndex()]=null;
                            paises[list1.getSelectedIndex()]=null; 
                        }
                        else
                            j++;
                        capitales[i]=capitales[j];
                        paises[i]=paises[j];
                    }
                    list1.setListData(paises);
                    acierto();
                }
                else
                    error();
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf1.setText("");
            }
        });
        p1.add(l1,BorderLayout.NORTH);
        p1.add(tf1,BorderLayout.CENTER);
        p2.add(l2,BorderLayout.NORTH);
        p2.add(sp2,BorderLayout.CENTER);
        p3.add(b1);
        p3.add(new JPanel());
        p3.add(b2);
        p4.add(p1,BorderLayout.WEST);
        p4.add(p2,BorderLayout.CENTER);
        p4.add(p3,BorderLayout.EAST);
        p5.add(sp1);
        p5.add(p4);
        p6.add(l3);
        p6.add(ta2);
        p6.add(l4);
        p6.add(ta3);
        p6.add(ta4);
        add(p5,BorderLayout.CENTER);
        add(p6,BorderLayout.SOUTH);
        
    }
    private void arrayPaises(){
            String paises2[] = {
            "España",
            "Francia",
            "Noruega",
            "Finlandia",
            "Estados Unidos",
            "China",
            "Japon",
            "Korea del Sur",
            "Alemania",
            "Italia",
            "Gracia",
            "Rusia",
            "Marruecos",
            "Somalia",
            "Egipto",
            "Venezuela",
            "Colombia",
            "Brasil",
            "Peru",
            "Argentina",
            "Australia"};
            paises=paises2;
            String capitales2 [] = {
            "Madrid",
            "París",
            "Oslo",
            "Helsinki",
            "Washington",
            "Pekín",
            "Tokio",
            "Seúl",
            "Berlín",
            "Roma",
            "Atenas",
            "Moscú",
            "Rabat",
            "Mogadiscio",
            "El Cairo",
            "Caracas",
            "Bogotá",
            "Brasilia",
            "Lima",
            "Buenos Aires",
            "Canberra"
        };
            capitales=capitales2;
    }
    private void error(){
        contadorFallos++;
        ta3.setText(""+contadorFallos);
        if(contadorFallos>oportunidades)
            terminarPartida();
        else
            ta4.setText("Respuesta incorrecta, te quedan "+(oportunidades-contadorFallos));
    }
    private void acierto(){
        contadorAciertos++;
        ta2.setText(""+contadorAciertos);
        ta4.setText("Respuesta correcta");
    }
    private void terminarPartida(){
        b1.removeActionListener(a);
        ta4.setText("Perdiste");
    }

}
