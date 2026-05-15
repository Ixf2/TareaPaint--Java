package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PoligonoRegular implements Herramienta {

    private ArrayList<DatosPoligono> poligonos;

    private boolean primerClick;
    private int xCentro, yCentro;

    private int lados;
    private Color colorBorde;
    private Color colorRelleno;
    private boolean relleno;

    public PoligonoRegular() {
        poligonos = new ArrayList<>();
        primerClick = true;
        lados = 5;
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

            int xVertice = e.getX();
            int yVertice = e.getY();

            int radio = (int) Math.sqrt(
                    Math.pow(xVertice - xCentro, 2)
                    + Math.pow(yVertice - yCentro, 2)
            );

            double anguloInicial = Math.atan2(
                    yVertice - yCentro,
                    xVertice - xCentro
            );

            poligonos.add(new DatosPoligono(
                    xCentro,
                    yCentro,
                    radio,
                    lados,
                    anguloInicial,
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

        for (DatosPoligono p : poligonos) {

            Polygon poligono = new Polygon();

            for (int i = 0; i < p.lados; i++) {

                double angulo = p.anguloInicial + i * 2 * Math.PI / p.lados;

                int x = (int) Math.round(p.xCentro + p.radio * Math.cos(angulo));
                int y = (int) Math.round(p.yCentro + p.radio * Math.sin(angulo));

                poligono.addPoint(x, y);
            }

            if (p.relleno) {
                g.setColor(p.colorRelleno);
                g.fillPolygon(poligono);
            }

            g.setColor(p.colorBorde);
            g.drawPolygon(poligono);
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

    public void setLados(int lados) {
        this.lados = lados;
    }

    private class DatosPoligono {

        int xCentro;
        int yCentro;
        int radio;
        int lados;
        double anguloInicial;

        Color colorBorde;
        Color colorRelleno;

        boolean relleno;

        public DatosPoligono(int xCentro, int yCentro, int radio, int lados,
                             double anguloInicial, Color colorBorde,
                             Color colorRelleno, boolean relleno) {

            this.xCentro = xCentro;
            this.yCentro = yCentro;
            this.radio = radio;
            this.lados = lados;
            this.anguloInicial = anguloInicial;
            this.colorBorde = colorBorde;
            this.colorRelleno = colorRelleno;
            this.relleno = relleno;
        }
    }
}