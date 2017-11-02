package model;

import java.util.Scanner;

/**
 * Clase para construir la habitacion, sirve para poder entregar los numeros y
 * que estos sean utilizados para poder dar el largo y el ancho a la misma.
 *
 * @author XZeroMarx
 */
public class Habitacion {

    Scanner scan = new Scanner(System.in);
    int c1, c2, c3, c4, contC, contF, maximo, minimo;
    boolean v1, v2;
    String disponibilidad;
    Objetox[][] pieza;
    String[] separador;
    String objetoPresente;

    public boolean formarHabitacionPorDefecto() {
        maximo = 20;
        minimo = 4;
        boolean correcto;

        while (true) {

            System.out.println("Ingrese ancho y alto de la pieza");
            System.out.print("(maximo ancho y alto 20): ");
            String coordenada = scan.nextLine();
            separador = coordenada.split(",");

            for (int i = 0; i < separador.length; i++) {

                if (i == 0) {
                    if (separador[i] == null) {
                        System.out.println("rellene ambos espacios, si solo escribió un numero");
                        System.out.println("ingreselo separado por coma");
                        System.out.println("Ejemplo: 4,4");
                    }
                    try {
                        c1 = Integer.parseInt(separador[i]);
                        v1 = true;
                    } catch (Exception e) {
                        System.out.println("no ingrese otra cosa que no sean numeros");
                        v1 = false;
                    }

                } else if (i == 1) {
                    if (separador[i] == null) {
                        System.out.println("rellene ambos espacios, si solo escribió un numero");
                        System.out.println("ingreselo separado por coma");
                        System.out.println("Ejemplo: 4,4");
                    }
                    try {
                        c2 = Integer.parseInt(separador[i]);
                        v2 = true;
                    } catch (Exception e) {
                        System.out.println("no ingrese otra cosa que no sean numeros");
                        v2 = false;
                    }
                }

            }
            if (c1 > maximo && c2 > maximo) {

                System.out.println("no ingrese numeros mayores al limite");

            } else {
                if (c1 < minimo && c2 < minimo) {
                    System.out.println("el tamaño de la habitacion es muy pequeño");
                    System.out.println("porfavor ingrese desde 4 x 4 hacia arriba");

                } else if (v1 == true && v2 == true) {
                    pieza = new Objetox[c1 + 1][c2 + 1];
                    break;
                }
            }

        }
        correcto = true;
        return correcto;
    }

    public void ubicarCosa(int fila, int columna, Objetox cosa) {

        for (int i = 0; i < pieza.length; i++) {
            for (int j = 0; j < pieza[i].length; j++) {
                if (i == fila && j == columna) {
                    pieza[i][j] = cosa;

                }
            }
        }
    }

    public void dibujarHabitacion() {

        for (int i = 0; i < pieza.length; i++) {
            for (int j = 0; j < pieza[i].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("f/c ");
                } else if (i == 0) {
                    if (contC >= 10) {
                        System.out.print("" + contC + " ");
                    } else {
                        System.out.print("0" + contC + " ");
                    }
                    contC += 1;

                } else if (j == 0) {
                    if (contF >= 10) {
                        System.out.print("" + contF + " ");
                    } else {
                        System.out.print("0" + contF + " ");
                    }
                    contF += 1;

                } else {
                    if (pieza[i][j] == null) {
                        System.out.print(" " + "-" + " ");
                    } else if ("R".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" R ");
                    } else if ("G".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" G ");
                    } else if ("M".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" M ");
                    }
                }

            }
            System.out.println("");
        }
        contF = 0;
        contC = 0;
    }

    public void ubicarMueble(int cordI1, int cordI2, int cordD1, int cordD2, Objetox mueble) {
        for (int i = cordI1; i < pieza.length; i++) {
            if (i > cordD2) {
                break;
            }
            for (int j = cordI2; j < pieza[i].length; j++) {
                if (j > cordD1) {
                    break;
                } else {
                    pieza[i][j] = mueble;

                }

            }
        }

    }

    public int getC1() {
        return c1;
    }

    public int getC2() {
        return c2;
    }

    public void dibujarx1(int fila1, int columna1) {
        for (int i = 0; i < pieza.length; i++) {
            for (int j = 0; j < pieza[i].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("f/c ");
                } else if (i == 0) {
                    if (contC >= 10) {
                        System.out.print("" + contC + " ");
                    } else {
                        System.out.print("0" + contC + " ");
                    }
                    contC += 1;

                } else if (j == 0) {
                    if (contF >= 10) {
                        System.out.print("" + contF + " ");
                    } else {
                        System.out.print("0" + contF + " ");
                    }
                    contF += 1;

                } else {
                    if (pieza[i][j] == null) {
                        if (fila1 == i && columna1 == j) {
                            System.out.print(" X ");
                        } else {
                            System.out.print(" " + "-" + " ");
                        }
                    } else if ("R".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" R ");
                    } else if ("G".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" G ");
                    } else if ("M".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" M ");
                    }
                }

            }
            System.out.println("");
        }
        contF = 0;
        contC = 0;
    }

    public void dibujarx2(int fila1, int columna1, int fila2, int columna2) {
        for (int i = 0; i < pieza.length; i++) {
            for (int j = 0; j < pieza[i].length; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("f/c ");
                } else if (i == 0) {
                    if (contC >= 10) {
                        System.out.print("" + contC + " ");
                    } else {
                        System.out.print("0" + contC + " ");
                    }
                    contC += 1;

                } else if (j == 0) {
                    if (contF >= 10) {
                        System.out.print("" + contF + " ");
                    } else {
                        System.out.print("0" + contF + " ");
                    }
                    contF += 1;

                } else {
                    if (pieza[i][j] == null) {
                        if (fila2 == i && columna2 == j) {
                            System.out.print(" X ");

                        } else if (fila1 == i && columna1 == j) {
                            System.out.print(" X ");

                        } else {

                            System.out.print(" " + "-" + " ");

                        }

                    } else if ("R".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" R ");
                    } else if ("G".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" G ");
                    } else if ("M".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        System.out.print(" M ");
                    }
                }

            }
            System.out.println("");
        }
        contF = 0;
        contC = 0;
    }

    public void revisarDisponibilidad(int cordI1, int cordI2, int cordD1, int cordD2) {
        for (int i = cordI1; i < pieza.length; i++) {
            if ("no".equals(disponibilidad)) {
                break;
            }
            if (i > cordD2) {
                break;
            }
            for (int j = cordI2; j < pieza[i].length; j++) {
                if (j > cordD1) {
                    break;
                } else {
                    if (pieza[i][j] == null) {
                        disponibilidad = "si";
                    } else if ("R".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        disponibilidad = "no";
                        break;
                    } else if ("G".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        disponibilidad = "no";
                        break;
                    } else if ("M".equalsIgnoreCase(pieza[i][j].getIdentificador())) {
                        disponibilidad = "no";
                        break;
                    }
                }
            }
        }
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad() {
        disponibilidad = "X";
    }

    public void revisarObjetos(int fila, int columna) {
        try {
            if ("G".equalsIgnoreCase(pieza[fila][columna].getIdentificador())) {
                objetoPresente = "si";
            }else if ("R".equalsIgnoreCase(pieza[fila][columna].getIdentificador())) {
                objetoPresente = "si";
            }
        } catch (Exception e) {
            objetoPresente = "no";
        }
    }

    public String dObjetos() {
        return objetoPresente;
    }

}
