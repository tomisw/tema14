package Tema14;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

import java.awt.*;
public class EjercicioHistorialPulsaciones extends Applet{
    private int alto;
    private int ancho;
    JTextArea ta1,ta2;
    JButton b1;
    JButton b2;
    JPanel p1,p2,p3;
    JScrollPane sp1;
    int Contadora;
    int Contadorb;
    static int asd;
    public void init(){
        ancho=400;
        alto=250;
        setBounds(0, 0, ancho, alto);
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
    }
    public void cambiarTexto(String t, int b){
        ta1.setText("Pulsado"+b+" veces el botón "+ t +"");
        ta2.setText(ta2.getText()+"Pulsado"+b+" veces el botón "+ t +"\n");
        if(b==10 && t.matches("Primero")){
                new VentanaSecundaria(0,getX(),getY(),getHeight(),getWidth());
                Toolkit.getDefaultToolkit().beep();
        }
        if(b==5 && t.matches("Segundo")){
                new VentanaSecundaria(1,getX(),getY(),getHeight(),getWidth());
                Toolkit.getDefaultToolkit().beep();
        }
    }
}
class VentanaSecundaria extends Frame{
    int x;
    int y;
    VentanaSecundaria(int a, int x,int y,int alto, int ancho){
        this.x=x;
        this.y=y;
        if(a==0){
            setName("Boton Primero");
            setBounds(x+5,y+alto+85,ancho/2,alto/2);
            repaint();
        }
        else{
            setName("Boton Segundo");
            setBounds(x+ancho/2+10,y+alto+85,ancho/2,alto/2);
            Panel p = new Panel();
            p.setBackground(Color.yellow);
            add(p);
        }
        setVisible(true);
        setResizable(false);
        addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               dispose();
           } 
        });
        
    }
    public void paint(Graphics g){
        g.drawImage(getToolkit().getImage(getClass().getResource("imagen05.gif")), x, y, getWidth(), getHeight(), this);
    }
}
