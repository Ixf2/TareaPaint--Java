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
    private PoligonoRegular poligonoRegular;
    private PoligonoIrregular poligonoIrregular;

    private Herramienta herramienta;

    public Lienzo() {
        setBackground(Color.WHITE);

        lapiz = new Lapiz();
        punto = new Punto();
        recta = new Recta();
        circulo = new Circulo();
        poligonoRegular = new PoligonoRegular();
        poligonoIrregular = new PoligonoIrregular();

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

        if (herramienta != lapiz) {
            lapiz.dibujar(g);
        }

        if (herramienta != punto) {
            punto.dibujar(g);
        }

        if (herramienta != recta) {
            recta.dibujar(g);
        }

        if (herramienta != circulo) {
            circulo.dibujar(g);
        }

        if (herramienta != poligonoRegular) {
            poligonoRegular.dibujar(g);
        }

        if (herramienta != poligonoIrregular) {
            poligonoIrregular.dibujar(g);
        }

        herramienta.dibujar(g);
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

    public void usarPoligonoRegular() {
        herramienta = poligonoRegular;
    }

    public void usarPoligonoIrregular() {
        herramienta = poligonoIrregular;
    }

    public void setColorActual(Color color) {
        lapiz.setColor(color);
        punto.setColor(color);
        recta.setColor(color);

        circulo.setColor(color);
        circulo.setColorRelleno(color);

        poligonoRegular.setColor(color);
        poligonoRegular.setColorRelleno(color);

        poligonoIrregular.setColor(color);
        poligonoIrregular.setColorRelleno(color);
    }

    public void setRellenoCirculo(boolean relleno) {
        circulo.setRelleno(relleno);
    }

    public void setRellenoPoligono(boolean relleno) {
        poligonoRegular.setRelleno(relleno);
        poligonoIrregular.setRelleno(relleno);
    }

    public void setLadosPoligono(int lados) {
        poligonoRegular.setLados(lados);
        poligonoIrregular.setLados(lados);
    }

    public void nuevoDibujo() {
        lapiz = new Lapiz();
        punto = new Punto();
        recta = new Recta();
        circulo = new Circulo();
        poligonoRegular = new PoligonoRegular();
        poligonoIrregular = new PoligonoIrregular();

        herramienta = lapiz;

        repaint();
    }

    public Lapiz getLapiz() {
        return lapiz;
    }

    public Punto getPunto() {
        return punto;
    }

    public Recta getRecta() {
        return recta;
    }

    public Circulo getCirculo() {
        return circulo;
    }

    public PoligonoRegular getPoligonoRegular() {
        return poligonoRegular;
    }

    public PoligonoIrregular getPoligonoIrregular() {
        return poligonoIrregular;
    }

    
}
