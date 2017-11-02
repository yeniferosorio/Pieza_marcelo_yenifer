package model;


import java.util.Scanner;


/**
 *
 * @author XZeroMarx
 */
public class Mueble implements Objetox{
    
    Scanner scan = new Scanner(System.in);
    String identificador = "M";
    int c1,c2,c3,c4;
    String coordenada;
    String[] separador;
    

    @Override
    public void ubicacionX() {
        while(true){
        System.out.println("Ingrese coordenada superior izquierda donde desea poner el mueble:");
        try {
        coordenada = scan.nextLine();
            
         
        separador = coordenada.split(",");

        for (int i = 0; i < separador.length; i++) {
            if (i == 0) {
                c1 = Integer.parseInt(separador[i]);
              

            } else if (i == 1) {
                c2 = Integer.parseInt(separador[i]);
                
            }
            
        }
        break;
    }catch (Exception e) {
            System.out.println("no ingrese simbolos e ingrese un numero valido");
        }
    }
    }

    
    @Override
    public int getFila() {
         return c1;
    }

    @Override
    public int getCol() {
         return c2;
    }

    
    
    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void ubicacionX(int contador) {
        while(true){
        System.out.println("Ingrese coordenada inferior derecha donde desea poner el mueble:");
        try {
        coordenada = scan.nextLine();
            
        
        separador = coordenada.split(",");

        for (int i = 0; i < separador.length; i++) {
            if (i == 0) {
                c3 = Integer.parseInt(separador[i]);
                

            } else if (i == 1) {
                c4 = Integer.parseInt(separador[i]);
                
            }
            

        }
        break;
        }catch (Exception e) {
            System.out.println("no ingrese simbolos e ingrese un numero valido");
        }
        
        }
    }
    
    @Override
    public int getC3() {
        return c3;
    }

    @Override
    public int getC4() {
        return c4;
    }
}
