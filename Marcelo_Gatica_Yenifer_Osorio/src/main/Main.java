package main;

import java.util.Scanner;
import model.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Objetox g, r, m;
        int nuevoLimiteG;
        int contGatos = 0;
        int nuevoLimiteR;
        int contRatones = 0;
        String resp = null;
        int limiteMuebles = 0;
        int muebles = 0;
        
        
        System.out.println("--------------------------------");
        System.out.println("Bienvenido al creador de planos");
        System.out.println("--------------------------------");
        System.out.println("Regla: Todo lo que sea coordenada");
        System.out.println("Lo debe ingresar separado por una");
        System.out.println("coma. EJ: 1,4");
        System.out.println("--------------------------------");

        Habitacion cuarto = new Habitacion();

        while (true) {

            if (cuarto.formarHabitacionPorDefecto() == true) {
                break;
            }

        }
        cuarto.dibujarHabitacion();

        double porcentaje_gatos = ((cuarto.getC1()) * (cuarto.getC2()) * 0.1);
        int limGatos = (int) porcentaje_gatos;
        while (true) {
            try {
                while (true) {
                    System.out.println("Puede ingresar [" + limGatos + "] gatos.");
                    System.out.print("Cuantos gatos?: ");

                    nuevoLimiteG = Integer.parseInt(scan.nextLine());

                    if (nuevoLimiteG <= limGatos && nuevoLimiteG >= 0) {
                        break;
                    } else {
                        System.err.println("no pude ingresar más gatos que el limite.");
                    }

                }

                while (contGatos < nuevoLimiteG) {
                    g = new Gato();
                    g.ubicacionX(contGatos + 1);

                    cuarto.revisarObjetos(g.getFila() + 1, g.getCol() + 1);
                    if ("si".equalsIgnoreCase(cuarto.dObjetos())) {
                        System.err.println("Hay un objeto en el lugar que indicó");
                    } else {
                        cuarto.ubicarCosa(g.getFila() + 1, g.getCol() + 1, g);
                        contGatos++;
                        cuarto.dibujarHabitacion();
                    }
                }
                break;

            } catch (Exception e) {
                System.out.println("elija un numero valido y no ingrese simbolos");
            }

        }

        double porcentaje_ratones = ((cuarto.getC1()) * (cuarto.getC2()) * 0.25);
        int limRatones = (int) porcentaje_ratones;

        while (true) {
            try {
                while (true) {
                    System.out.println("Puede ingresar [" + limRatones + "] ratones.");
                    System.out.print("Cuantos ratones?: ");

                    nuevoLimiteR = Integer.parseInt(scan.nextLine());

                    if (nuevoLimiteR <= limRatones && nuevoLimiteR >= 0) {
                        break;
                    } else {
                        System.err.println("no pude ingresar más ratones que el limite.");
                    }

                }

                while (contRatones < nuevoLimiteR) {
                    r = new Raton();

                    r.ubicacionX(contRatones + 1);//aqui se empieza a preguntar la coordenada

                    //comprobacion de si hay gatos o no   
                    cuarto.revisarObjetos(r.getFila() + 1, r.getCol() + 1);
                    //comprobacion de si hay gatos o no   
                    if ("si".equalsIgnoreCase(cuarto.dObjetos())) {
                        System.err.println("Hay un objeto en el lugar que indicó");//si hay gatos, pasa esto

//                    //si no hay, pasa lo siguiente
                    } else {
                        cuarto.ubicarCosa(r.getFila() + 1, r.getCol() + 1, r);
                        contRatones++;
                        cuarto.dibujarHabitacion();
                    }

                }
                break;

            } catch (Exception e) {
                System.out.println("elija un numero valido y no ingrese simbolos");
            }

        }

        int cantTotalMuebles = ((cuarto.getC1()) * (cuarto.getC2()) - ((nuevoLimiteG) + (nuevoLimiteR)));

        while(true){
        System.out.println("Cuantos muebles?");
        System.out.print("puede poner " + cantTotalMuebles + " muebles: ");
        try {
        muebles = Integer.parseInt(scan.nextLine());
        limiteMuebles=0;
            break;
        } catch (Exception e) {
            System.out.println("no ingrese simbolos ni comas");
        }
        }
        if (muebles > cantTotalMuebles && muebles < 0) {
            System.out.print("No puede ingresar mas de " + cantTotalMuebles + " y menos de 0 muebles: ");
        } else {

            while (limiteMuebles < muebles) {
                //dibujo de las x para proceder a ubicar el mueble
                System.out.println("--------------");
                System.out.println("MUEBLE N°"+(limiteMuebles+1));
                System.out.println("--------------");
                m = new Mueble();
                m.ubicacionX();

                //primera x
                cuarto.dibujarx1(m.getFila() + 1, m.getCol() + 1);

                m.ubicacionX(0);

                //segunda x
                cuarto.dibujarx2(m.getFila() + 1, m.getCol() + 1, m.getC3() + 1, m.getC4() + 1);

                
                System.out.println("* nota: si se queda sin espacios, ingrese " + 3 + "en las opciones");
                System.out.println("para finalizar el posicionamiento de los muebles");
                System.out.println("--------------");
                System.out.println("   PROCEDER?  ");
                System.out.println("--------------");
                System.out.println("1.- SI");
                System.out.println("2.- NO");
                try {
                    resp = scan.nextLine();

                } catch (Exception e) {
                    System.out.println("Ingrese opcion valida");
                }
                if ("1".equalsIgnoreCase(resp)) {
                    cuarto.setDisponibilidad();
                    cuarto.revisarDisponibilidad(m.getFila() + 1, m.getCol() + 1, m.getC3() + 1, m.getC4() + 1);

                    if ("no".equalsIgnoreCase(cuarto.getDisponibilidad())) {
                        System.err.println("[ERROR] ya hay un lugar ocupado entre los que elijió");

                    } else if ("si".equalsIgnoreCase(cuarto.getDisponibilidad())) {
                        System.out.println("--");
                        limiteMuebles++;
                        cuarto.ubicarMueble(m.getFila() + 1, m.getCol() + 1, m.getC3() + 1, m.getC4() + 1, m);
                        cuarto.dibujarHabitacion();
                        
                    }
                } else if ("3".equalsIgnoreCase(resp)) {
                    break;
                } else {
                    System.out.println("Ingrese una opcion válida");
                }
            }
        }

    }

}
