package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Punto implements Herramienta {

    private ArrayList<DatosPunto> puntos;
    private Color color = Color.BLACK;

    public Punto() {puntos = new ArrayList<>();}

    @Override
    public void mousePressed(MouseEvent e) {

        puntos.add(new DatosPunto(
                e.getX(),
                e.getY(),
                color
        ));

    }

    @Override
    public void dibujar(Graphics g) {

        for (DatosPunto p : puntos) {

            g.setColor(p.color);

            g.fillOval(
                    p.x,
                    p.y,
                    5,
                    5
            );
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }


    private class DatosPunto {

        int x;
        int y;
        Color color;

        public DatosPunto(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

    }

}