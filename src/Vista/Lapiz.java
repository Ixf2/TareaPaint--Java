package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Lapiz implements Herramienta {

    private ArrayList<DatosLapiz> puntos = new ArrayList<>();
    private Color color = Color.BLACK;

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        puntos.add(new DatosLapiz(e.getX(), e.getY(), color));
    }

    @Override
    public void dibujar(Graphics g) {

        for (DatosLapiz p : puntos) {

            g.setColor(p.color);

            g.fillOval(p.x, p.y, 5, 5);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }


    private class DatosLapiz {

        int x;
        int y;
        Color color;

        public DatosLapiz(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}