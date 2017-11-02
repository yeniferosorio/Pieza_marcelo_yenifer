package model;

import java.util.Scanner;

/**
 *
 * @author XZeroMarx
 */
public class Raton implements Objetox {

    Scanner scan = new Scanner(System.in);
    String identificador = "R";

    int fila;
    int col;
    int contRaton;
    @Override
    public void ubicacionX(int contador) {
        
        System.out.println("----------");
        System.out.println("Raton N°" + contador);
        System.out.println("----------");
        System.out.println("Ingrese fila y columna:");

        String coordenada = scan.nextLine();
        String[] separador = coordenada.split(",");

        for (int i = 0; i < separador.length; i++) {
            if (i == 0) {
                int c1 = Integer.parseInt(separador[i]);
                fila = c1;

            } else if (i == 1) {
                int c2 = Integer.parseInt(separador[i]);
                col = c2;
            }

        }
    }

    @Override
    public int getFila() {
        return fila;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public String getIdentificador() {
        return identificador;
    }

    @Override
    public int getC3() {
        return 0;
    }

    @Override
    public int getC4() {
        return 0;
    }

    @Override
    public void ubicacionX() {
    }
}
