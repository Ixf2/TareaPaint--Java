package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

    private Herramienta lapiz = new Lapiz();
    private Herramienta punto = new Punto();
    private Herramienta recta = new Recta();
    private Herramienta circulos = new Circulo();

    private Herramienta herramienta = lapiz;

    public Lienzo() {
        setBackground(java.awt.Color.WHITE);

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
        circulos.dibujar(g);
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
        herramienta = circulos;
    }
    
    public void setColorActual(Color color){
        lapiz.setColor(color);
        punto.setColor(color);
        recta.setColor(color);
        circulos.setColor(color);
    }
    
    
}
