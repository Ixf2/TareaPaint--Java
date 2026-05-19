
import Controlador.Controlador;
import Modelo.Modelo;
import Vista.VentanaPrincipal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joana
 */
public class Main {
    public static void main(String[] args) {
       Modelo modelo = new Modelo();
       VentanaPrincipal vista = new VentanaPrincipal();
       Controlador controlador = new Controlador(modelo, vista);
       
       vista.setVisible(true);
        
        
        
    }
}
