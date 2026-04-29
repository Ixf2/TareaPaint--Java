package Vista;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;


public class Lienzo extends JPanel {

    private ArrayList<int[]> puntos;
    private String herramienta = "Punto";
    
    
    public Lienzo() {
        //Ponemos el fondo blanco totalmente.
        setBackground(java.awt.Color.WHITE);
        
        

        

        //Detecta el ratón con método de JPanel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Guardamos la posición y mandamos a repintar el panel
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    
    //Método para guardar la información cuando se repintea anteriormente.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillOval(x, y, 5, 5);
    }
    
    
    //Método Setter de Punto
    public void setHerramienta(String herramienta) {
            this.herramienta = herramienta;
        }
    
    
    
}
