package Vista;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Lapiz implements Herramienta {

    private ArrayList<int[]> puntos = new ArrayList<>();

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
    public void dibujar(Graphics g){
          for (int[] p : puntos) {
            g.fillOval(p[0], p[1], 5, 5);
        }
        
    }

}

