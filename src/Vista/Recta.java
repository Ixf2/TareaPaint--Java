package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Recta implements Herramienta {

    private ArrayList<DatosRecta> rectas = new ArrayList<>();
    private boolean primerClick = true;
    private int x1, y1;
    private Color color = Color.BLACK;

    @Override
    public void mousePressed(MouseEvent e) {

        if (primerClick) {
            x1 = e.getX();
            y1 = e.getY();
            primerClick = false;
        } else {
            rectas.add(new DatosRecta(x1, y1, e.getX(), e.getY(), color));
            primerClick = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void dibujar(Graphics g) {

        for (DatosRecta r : rectas) {
            g.setColor(r.color);
            g.drawLine(r.x1, r.y1, r.x2, r.y2);
        }
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    private class DatosRecta {

        int x1, y1, x2, y2;
        Color color;

        public DatosRecta(int x1, int y1, int x2, int y2, Color color) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color = color;
        }
    }
}