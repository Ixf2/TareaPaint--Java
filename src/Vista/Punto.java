/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author IXF2
 */
public class Punto implements Herramienta {

    private ArrayList<int[]> puntos;
    private Color color;


    public Punto() {
        this.puntos = new ArrayList<>();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        puntos.add(new int[]{
            e.getX(), e.getY()
        });
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        for (int[] p : puntos) {
            g.fillOval(p[0], p[1], 5, 5);

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
    
    @Override
    public void setColor(Color color){
        this.color = color;
    }
    
    

}
