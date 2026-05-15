package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Lapiz implements Herramienta {

    private ArrayList<int[]> puntos = new ArrayList<>();
    private Color color = Color.BLACK;

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        puntos.add(new int[]{
            e.getX(),
            e.getY()
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
    public void setColor(Color color) {
        this.color = color;
    }
}