package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Circulo implements Herramienta {

    private ArrayList<DatosCirculo> circulos;

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

            circulos.add(new DatosCirculo(
                    xCentro,
                    yCentro,
                    radio,
                    colorBorde,
                    colorRelleno,
                    relleno
            ));

            primerClick = true;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void dibujar(Graphics g) {

        for (DatosCirculo c : circulos) {

            int x = c.xCentro - c.radio;
            int y = c.yCentro - c.radio;
            int diametro = c.radio * 2;

            if (c.relleno) {
                g.setColor(c.colorRelleno);
                g.fillOval(x, y, diametro, diametro);
            }

            g.setColor(c.colorBorde);
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

    private class DatosCirculo {

        int xCentro;
        int yCentro;
        int radio;

        Color colorBorde;
        Color colorRelleno;

        boolean relleno;

        public DatosCirculo(int xCentro, int yCentro, int radio, Color colorBorde, Color colorRelleno, boolean relleno) {
            this.xCentro = xCentro;
            this.yCentro = yCentro;
            this.radio = radio;
            this.colorBorde = colorBorde;
            this.colorRelleno = colorRelleno;
            this.relleno = relleno;
        }
    }
}