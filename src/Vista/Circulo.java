package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Circulo implements Herramienta {

    private ArrayList<int[]> circulos;
    private boolean primerClick;
    private int xCentro, yCentro;
    private Color colorBorde;
    private Color colorRelleno;

    private boolean relleno;

    public Circulo() {
        circulos = new ArrayList<>();
        primerClick = true;
        colorBorde = Color.BLACK;
        colorRelleno = Color.WHITE;
        relleno = false;
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

            int x = c[0] - c[2];
            int y = c[1] - c[2];
            int diametro = c[2] * 2;

            if (relleno) {
                g.setColor(colorRelleno);

                g.fillOval(x, y, diametro, diametro);
            }

            
            g.setColor(colorBorde);
            g.drawOval(x, y, diametro, diametro);

        }
    }

    @Override
    public void setColor(Color color) {
        this.colorBorde = color;
    }

    public void setColorRelleno(Color color) {
        this.colorRelleno = color;

    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;

    }

}
