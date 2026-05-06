package Vista;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Lienzo extends JPanel {

    private ArrayList<int[]> puntos;
    private ArrayList<int[]> rectas;
    private ArrayList<int[]> circulos;
    private String herramienta = "Punto";
    
    
    public Lienzo() {
        //Ponemos el fondo blanco totalmente.
        setBackground(java.awt.Color.WHITE);

        puntos = new ArrayList<>();  
        rectas = new ArrayList<>();  
        circulos = new ArrayList<>();  
        
        
        

        

        //Detecta el ratón con método de JPanel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (herramienta.equals("Punto")) {
                    puntos.add(new int[]{e.getX(), e.getY()});
                }

                repaint();
            }
        });
    }

    
    //Método para guardar la información cuando se repintea anteriormente.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int[] punto : puntos) {
            g.fillOval(punto[0], punto[1], 5, 5);
        }
    }
    
    
    //Método Setter de Punto
    public void setHerramienta(String herramienta) {
            this.herramienta = herramienta;
        }
    
    
    
}
