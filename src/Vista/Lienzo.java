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
    private int x1, y1;
    private boolean primerClick = true;
    private long ultimoClick=0;
    
    
    public Lienzo() {
        //Ponemos el fondo blanco totalmente.
        setBackground(java.awt.Color.WHITE);

        puntos = new ArrayList<>();  
        rectas = new ArrayList<>();  
        circulos = new ArrayList<>();  
        this.x1 = x1;
        this.y1 = y1;
        
        
        
        

        

        //Detecta el ratón con método de JPanel
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                long tiempoActual = System.currentTimeMillis();
                
                //Botón izquiedo
                
                //Clickeos muy rápidos
                if (tiempoActual - ultimoClick < 200){
                    return;
                }
                
                ultimoClick = tiempoActual;
                
                
                if (herramienta.equals("Punto")) {
                    puntos.add(new int[]{e.getX(), e.getY()});
                } else if (herramienta.equals("Recta")){
                    if (primerClick){
                        x1 = e.getX();
                        y1 = e.getY();
                        primerClick = false;
                    } else {
                        rectas.add(new int[]{x1, y1, e.getX(), e.getY()});
                    }
                
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
        
        for (int[] recta: rectas){
            g.drawLine(recta[0], recta[1], recta[2], recta[3]);
        }
        
    }
    
    
    //Método Setter de Punto
    public void setHerramienta(String herramienta) {
            this.herramienta = herramienta;
            primerClick = true;
        }
    
    
    
    //Setter Recta
    public void setRectas(ArrayList<int[]> rectas) {
        this.rectas = rectas;
    }
    
    
    
    
}
