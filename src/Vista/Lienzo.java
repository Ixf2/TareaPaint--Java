package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

    private Lapiz lapiz;
    private Punto punto;
    private Recta recta;
    private Circulo circulo;

    private Herramienta herramienta;
    private PoligonoRegular poligonoRegular;

    public Lienzo() {
        poligonoRegular = new PoligonoRegular();
        setBackground(Color.WHITE);

        lapiz = new Lapiz();
        punto = new Punto();
        recta = new Recta();
        circulo = new Circulo();

        herramienta = lapiz;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                herramienta.mousePressed(e);
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                herramienta.mouseDragged(e);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        lapiz.dibujar(g);
        punto.dibujar(g);
        recta.dibujar(g);
        circulo.dibujar(g);
        poligonoRegular.dibujar(g);
    }

    public void usarLapiz() {
        herramienta = lapiz;
    }

    public void usarPunto() {
        herramienta = punto;
    }

    public void usarRecta() {
        herramienta = recta;
    }

    public void usarCirculo() {
        herramienta = circulo;
    }

    public void setColorActual(Color color) {
        lapiz.setColor(color);
        punto.setColor(color);
        recta.setColor(color);
        circulo.setColor(color);
        circulo.setColorRelleno(color);
        poligonoRegular.setColor(color);
        poligonoRegular.setColorRelleno(color);
    }

    public void setRellenoCirculo(boolean relleno) {
        circulo.setRelleno(relleno);
    }

    public void usarPoligonoRegular() {
        herramienta = poligonoRegular;
    }

    public void setLadosPoligono(int lados) {
        poligonoRegular.setLados(lados);
    }

    public void setRellenoPoligono(boolean relleno) {
        poligonoRegular.setRelleno(relleno);
    }

}
