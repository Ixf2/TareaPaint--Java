package Vista;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Recta implements Herramienta {

    private ArrayList<int[]> rectas
            = new ArrayList<>();

    private boolean primerClick
            = true;

    private int x1, y1;

    @Override
    public void mousePressed(
            MouseEvent e) {

        if (primerClick) {

            x1 = e.getX();
            y1 = e.getY();

            primerClick = false;

        } else {

            rectas.add(
                    new int[]{
                        x1,
                        y1,
                        e.getX(),
                        e.getY()
                    });

            primerClick = true;

        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void dibujar(
            Graphics g) {
        for (int[] r
                : rectas) {
            g.drawLine(r[0], r[1], r[2], r[3]);
        }

    }

}
