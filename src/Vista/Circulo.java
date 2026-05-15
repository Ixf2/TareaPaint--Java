package Vista;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Circulo implements Herramienta {

    private ArrayList<int[]> circulos;
    private boolean primerClick;
    private int xCentro, yCentro;

    public Circulo() {
        circulos = new ArrayList<>();
        primerClick = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (primerClick) {
            xCentro = e.getX();
            yCentro = e.getY();
            primerClick = false;
        } else {
            int radio = (int) Math.sqrt(
                    Math.pow(e.getX() - xCentro, 2)
                    + Math.pow(e.getY() - yCentro, 2)
            );

            circulos.add(new int[]{
                xCentro,
                yCentro,
                radio
            });

            primerClick = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void dibujar(Graphics g) {
        for (int[] c : circulos) {
            g.drawOval(
                    c[0] - c[2],
                    c[1] - c[2],
                    c[2] * 2,
                    c[2] * 2
            );
        }
    }
}
