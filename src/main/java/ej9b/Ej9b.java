/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9b;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Ej9b {
    
     private static ArrayList<Vehiculo> ListaVehiculos = new ArrayList<>();
     
    public static void main(String[] args) throws IOException {
       crearListaVehiculo();
       
       recorrerLista();

        
    }
   
    private static void escribirFichero(String direccion,ArrayList<Vehiculo> Lista) throws FileNotFoundException, IOException{
        
        String ruta = direccion;
        File f = new File(ruta);
        FileOutputStream fw = new FileOutputStream(f);
        try (ObjectOutputStream escritura = new ObjectOutputStream(fw)) {
            for (Vehiculo o : Lista) {

                escritura.writeObject( o + "\n");

            }
        }

        
    }
    
    public static void crearListaVehiculo(){
        for (int i = 0; i < 15; i++) {
            ListaVehiculos.add(new Turismo(2, true, "seat", "toledo", "rojo", 34324.4, true));

        }

        for (int i = 0; i < 15; i++) {

            ListaVehiculos.add(new Deportivo(344, "porsche", "911", "verde", 234241.5, true));
        }
    }
    
    public static void recorrerLista() throws IOException{
        ArrayList<Vehiculo> ListaDeportivo = new ArrayList<>();
        ArrayList<Vehiculo> Listaturismo = new ArrayList<>();
        for(Vehiculo o: ListaVehiculos){
            
            if(o instanceof Turismo){
                Listaturismo.add(o);
            }
            
            if(o instanceof Deportivo){
               ListaDeportivo.add(o);
            }
                
            
        }
        
        escribirFichero("Turismo.csv",Listaturismo);
        escribirFichero("Deportivo.csv",ListaDeportivo);
        
        
        
    }
}
