package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PoligonoIrregular implements Herramienta {

    private ArrayList<DatosPoligonoIrregular> poligonos;
    private ArrayList<int[]> puntosActuales;

    private int lados;
    private Color colorBorde;
    private Color colorRelleno;
    private boolean relleno;

    public PoligonoIrregular() {
        poligonos = new ArrayList<>();
        puntosActuales = new ArrayList<>();
        lados = 5;
        colorBorde = Color.BLACK;
        colorRelleno = Color.WHITE;
        relleno = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int nuevoX = e.getX();
        int nuevoY = e.getY();

        if (puntosActuales.size() >= 2) {
            int[] ultimo = puntosActuales.get(puntosActuales.size() - 1);

            if (hayCruce(ultimo[0], ultimo[1], nuevoX, nuevoY)) {
                System.out.println("Ese lado cruza otro lado. Punto rechazado.");
                return;
            }
        }

        puntosActuales.add(new int[]{nuevoX, nuevoY});

        if (puntosActuales.size() == lados) {

            int[] ultimo = puntosActuales.get(puntosActuales.size() - 1);
            int[] primero = puntosActuales.get(0);

            if (hayCruceCierre(ultimo[0], ultimo[1], primero[0], primero[1])) {
                System.out.println("El cierre cruza otro lado. Último punto rechazado.");
                puntosActuales.remove(puntosActuales.size() - 1);
                return;
            }

            Polygon poligono = new Polygon();

            for (int[] p : puntosActuales) {
                poligono.addPoint(p[0], p[1]);
            }

            poligonos.add(new DatosPoligonoIrregular(
                    poligono,
                    colorBorde,
                    colorRelleno,
                    relleno
            ));

            puntosActuales.clear();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void dibujar(Graphics g) {

        for (DatosPoligonoIrregular p : poligonos) {

            if (p.relleno) {
                g.setColor(p.colorRelleno);
                g.fillPolygon(p.poligono);
            }

            g.setColor(p.colorBorde);
            g.drawPolygon(p.poligono);
        }

        g.setColor(colorBorde);

        for (int[] p : puntosActuales) {
            g.fillOval(p[0] - 3, p[1] - 3, 6, 6);
        }

        for (int i = 0; i < puntosActuales.size() - 1; i++) {
            int[] p1 = puntosActuales.get(i);
            int[] p2 = puntosActuales.get(i + 1);
            g.drawLine(p1[0], p1[1], p2[0], p2[1]);
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
        puntosActuales.clear();
    }

    private boolean hayCruce(int x1, int y1, int x2, int y2) {

        for (int i = 0; i < puntosActuales.size() - 2; i++) {

            int[] p1 = puntosActuales.get(i);
            int[] p2 = puntosActuales.get(i + 1);

            if (lineasSeCruzan(
                    x1, y1,
                    x2, y2,
                    p1[0], p1[1],
                    p2[0], p2[1]
            )) {
                return true;
            }
        }
        return false;
    }

    private boolean hayCruceCierre(int x1, int y1, int x2, int y2) {

        for (int i = 1; i < puntosActuales.size() - 2; i++) {

            int[] p1 = puntosActuales.get(i);
            int[] p2 = puntosActuales.get(i + 1);

            if (lineasSeCruzan(
                    x1, y1,
                    x2, y2,
                    p1[0], p1[1],
                    p2[0], p2[1]
            )) {
                return true;
            }
        }

        return false;
    }

    private boolean lineasSeCruzan(
            int x1, int y1, int x2, int y2,
            int x3, int y3, int x4, int y4) {

        int d1 = direccion(x3, y3, x4, y4, x1, y1);
        int d2 = direccion(x3, y3, x4, y4, x2, y2);
        int d3 = direccion(x1, y1, x2, y2, x3, y3);
        int d4 = direccion(x1, y1, x2, y2, x4, y4);

        return d1 * d2 < 0 && d3 * d4 < 0;
    }

    private int direccion(int ax, int ay, int bx, int by, int cx, int cy) {
        return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
    }

    private class DatosPoligonoIrregular {

        Polygon poligono;
        Color colorBorde;
        Color colorRelleno;
        boolean relleno;

        public DatosPoligonoIrregular(Polygon poligono, Color colorBorde, Color colorRelleno, boolean relleno) {
            this.poligono = poligono;
            this.colorBorde = colorBorde;
            this.colorRelleno = colorRelleno;
            this.relleno = relleno;
        }
    }
}
