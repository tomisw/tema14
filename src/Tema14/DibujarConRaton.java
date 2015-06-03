package Tema14;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.*;

public class DibujarConRaton extends Applet {
    int puntoX1;
    int puntoX2;
    int puntoY1;
    int puntoY2;
    public void init() {
        puntoX1=-1;
        puntoY1=-1;
        puntoX2=-1;
        puntoY2=-1;
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                puntoX2=puntoX1;
                puntoY2=puntoY1;
                puntoX1=getX();
                puntoY1=getY();
            }
        });
    }
    public void paint(Graphics g){
        if(puntoX2<0)
            g.drawLine(puntoX2, puntoY2, puntoX1, puntoY1);
    }

}
