package Farmacia;

import java.util.Scanner;

public class Empleado {

    private static Object[][] mEmpleados;
    private static Object[] dtsEmpleados = {"Codigo", "Nombre", "Cargo"};

    Scanner sLea = new Scanner(System.in);
    Scanner nLea = new Scanner(System.in);

    public void rgtrEmpleado(int cant) {

        mEmpleados = new Object[cant][dtsEmpleados.length];

        for (int i = 0; i < mEmpleados.length; i++) {
            System.out.println("Registro " + (i + 1) + ":");
            for (int j = 0; j < dtsEmpleados.length; j++) {

                System.out.print(dtsEmpleados[j] + " del empleado " + (i + 1) + ": ");
                mEmpleados[i][j] = sLea.next();

            }

        }

    }

    public void consultEmpleados(int op) {

        if (op == 1) {
            System.out.println("\nInformacion de Empleados:");
            for (int i = 0; i < mEmpleados.length; i++) {
                System.out.println("\t\t\tEmpleado " + (i + 1) + "\t\t\t");
                for (int j = 0; j < dtsEmpleados.length; j++) {
                    System.out.print(dtsEmpleados[j] + " = " + mEmpleados[i][j] + "    ");
                }
                System.out.println();
            }
        }

        if (op == 2) {

            int opc;
            System.out.println("\t\t\tSubMenu Consulta\t\t\t");
            for (int i = 0; i < dtsEmpleados.length; i++) {
                System.out.println((i + 1) + "." + dtsEmpleados[i]);
            }
            System.out.println("Digite el registro en el que desea buscar:");
            opc = nLea.nextInt();

            System.out.println("\nInformacion de " + dtsEmpleados[opc - 1] + ":");

            for (int i = 0; i < mEmpleados.length; i++) {

                System.out.println("\n" + dtsEmpleados[opc - 1] + " " + (i + 1) + ": " + mEmpleados[i][opc - 1]);
            }

        }
    }



    public Object[][] verficaciEMple() {
        return mEmpleados;
    }

    public void eliminarTablaEmpl(String comp) {

        Object[][] nuevosBitacora = new Object[mEmpleados.length - 1][dtsEmpleados.length];
        int indiceNuevo = 0;

        for (int i = 0; i < mEmpleados.length; i++) {
            if (!comp.equals(mEmpleados[i][0])) {
                nuevosBitacora[indiceNuevo++] = mEmpleados[i];
            }
        }
        mEmpleados = nuevosBitacora;
        System.out.println("Registro eliminado correctamente.");
    }

    public void modificarEmpl(String comp) {
        System.out.println("Digite el codigo del registrro que desea modificar:");
        comp = sLea.next();

        for (int i = 0; i < mEmpleados.length; i++) {
            if (comp.equals(mEmpleados[i][0])) {
                System.out.println("Digite los nuevos datos del registro:");
                for (int j = 0; j < dtsEmpleados.length; j++) {
                    System.out.print(dtsEmpleados[j] + " = ");
                    mEmpleados[i][j] = sLea.next();

                }
            }
        }

    }

    public void ordeEmpl(char op) {
        int opc;
        char oc;

        switch (op) {

            case '1':

                System.out.println("\t\t\tSubMenu Ordenar Todo\t\t\t");
                for (int i = 0; i < dtsEmpleados.length; i++) {
                    System.out.println((i + 1) + "." + dtsEmpleados[i]);
                }

                System.out.println("\nEliga el metodo por el cual desea ordenar el campo");
                System.out.println("\n1.Burbuja"
                        + "\n2.Inserccion"
                        + "\nQ.Salir");

                oc = nLea.next().charAt(0);

                switch (oc) {
                    case '1':

                        int n = mEmpleados.length;

                        for (int i = 0; i < n - 1; i++) {
                            for (int j = 0; j < n - i - 1; j++) {

                                Integer codigoActual = Integer.valueOf((String) mEmpleados[j][0]);
                                Integer codigoSiguiente = Integer.valueOf((String) mEmpleados[j + 1][0]);

                                if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                    Object[] aux = mEmpleados[j];
                                    mEmpleados[j] = mEmpleados[j + 1];
                                    mEmpleados[j + 1] = aux;
                                }

                            }
                        }
                        System.out.println("\nInformacion ordenada de la tabla empleado:");

                        for (int i = 0; i < mEmpleados.length; i++) {
                            System.out.println("\t\t\tEmpleado " + (i + 1) + "\t\t\t");
                            for (int j = 0; j < dtsEmpleados.length; j++) {
                                System.out.print(dtsEmpleados[j] + " = " + mEmpleados[i][j] + "    ");
                            }
                            System.out.println();
                        }

                        return;
                    case '2':

                        for (int i = 0; i < mEmpleados.length - 1; i++) {

                            int minIndex = i;
                            int minCodigo = Integer.parseInt((String) mEmpleados[i][0]);

                            for (int j = i + 1; j < mEmpleados.length; j++) {
                                int codigoActual = Integer.parseInt((String) mEmpleados[j][0]);
                                
                                if (codigoActual < minCodigo) {
                                    minCodigo = codigoActual;
                                    minIndex = j;
                                }
                            }

                            if (minIndex != i) {
                                Object[] temp = mEmpleados[minIndex];
                                mEmpleados[minIndex] = mEmpleados[i];
                                mEmpleados[i] = temp;
                            }
                        }

                        System.out.println("\nInformacion ordenada de la tabla empleado:");

                        for (int i = 0; i < mEmpleados.length; i++) {
                            System.out.println("\t\t\tEmpleado " + (i + 1) + "\t\t\t");
                            for (int j = 0; j < dtsEmpleados.length; j++) {
                                System.out.print(dtsEmpleados[j] + " = " + mEmpleados[i][j] + "    ");
                            }
                            System.out.println();
                        }

                        return;

                    case 'Q':
                    case 'q':

                        if (oc == 'Q' || oc == 'q') {
                            System.out.println("¿Desea salir? (Y/N)");
                            char respuesta = sLea.next().charAt(0);
                            if (respuesta == 'y' || respuesta == 'Y') {
                                return;
                            } else if (respuesta == 'n' || respuesta == 'N') {
                                System.out.println("Continue...");
                            }
                        }
                        break;
                    default:
                        System.out.println("ERROR: digite una opcion correcta");
                        break;
                }

            case '2':

                System.out.println("\t\t\tSubMenu Ordenamiento Por Campo\t\t\t");
                for (int i = 0; i < dtsEmpleados.length; i++) {
                    System.out.println((i + 1) + "." + dtsEmpleados[i]);
                }
                System.out.println("Digite el campo o columna que desea ordenar:");
                opc = nLea.nextInt();

                System.out.println("\nEliga el metodo por el cual desea ordenar el campo seleccionado");

                System.out.println("\n1.Burbuja"
                        + "\n2.Inserccion"
                        + "\nQ.Salir");

                oc = nLea.next().charAt(0);

                switch (oc) {

                    case '1':

                        if ((opc - 1) == 0) {
                            int n = mEmpleados.length;

                            for (int i = 0; i < n - 1; i++) {
                                for (int j = 0; j < n - i - 1; j++) {

                                    Integer codigoActual = Integer.valueOf((String) mEmpleados[j][opc - 1]);
                                    Integer codigoSiguiente = Integer.valueOf((String) mEmpleados[j + 1][opc - 1]);

                                    if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                        Object[] aux = mEmpleados[j];
                                        mEmpleados[j] = mEmpleados[j + 1];
                                        mEmpleados[j + 1] = aux;
                                    }

                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsEmpleados[opc - 1] + ":");

                            for (int i = 0; i < mEmpleados.length; i++) {

                                System.out.println(dtsEmpleados[opc - 1] + " [" + (i + 1) + "] = " + mEmpleados[i][opc - 1]);
                            }
                        }

                        if ((opc - 1) != 0) {
                            int n = mEmpleados.length;

                            for (int i = 0; i < n - 1; i++) {
                                for (int j = 0; j < n - i - 1; j++) {

                                    Comparable codigoActual = (Comparable) mEmpleados[j][opc - 1];
                                    Comparable codigoSiguiente = (Comparable) mEmpleados[j + 1][opc - 1];

                                    if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                        Object[] aux = mEmpleados[j];
                                        mEmpleados[j] = mEmpleados[j + 1];
                                        mEmpleados[j + 1] = aux;
                                    }

                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsEmpleados[opc - 1] + ":");

                            for (int i = 0; i < mEmpleados.length; i++) {

                                System.out.println(dtsEmpleados[opc - 1] + " [" + (i + 1) + "] = " + mEmpleados[i][opc - 1]);
                            }
                        }

                        return;

                    case '2':

                        if ((opc - 1) == 0) {
                            for (int i = 0; i < mEmpleados.length - 1; i++) {

                                int minIndex = i;
                                int minCodigo = Integer.parseInt((String) mEmpleados[i][opc - 1]);

                                for (int j = i + 1; j < mEmpleados.length; j++) {
                                    int codigoActual = Integer.parseInt((String) mEmpleados[j][opc - 1]);
                                    if (codigoActual < minCodigo) {
                                        minCodigo = codigoActual;
                                        minIndex = j;
                                    }
                                }

                                if (minIndex != i) {
                                    Object[] temp = mEmpleados[minIndex];
                                    mEmpleados[minIndex] = mEmpleados[i];
                                    mEmpleados[i] = temp;
                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsEmpleados[opc - 1] + ":");

                            for (int i = 0; i < mEmpleados.length; i++) {

                                System.out.println(dtsEmpleados[opc - 1] + " [" + (i + 1) + "] = " + mEmpleados[i][opc - 1]);
                            }
                        }

                        if ((opc - 1) != 0) {
                            for (int i = 0; i < mEmpleados.length - 1; i++) {
                                int minIndex = i;
                                String minCodigo = (String) mEmpleados[i][opc - 1];

                                for (int j = i + 1; j < mEmpleados.length; j++) {
                                    String codigoActual = (String) mEmpleados[j][opc - 1];
                                    if (codigoActual.compareTo(minCodigo) < 0) {
                                        minCodigo = codigoActual;
                                        minIndex = j;
                                    }
                                }

                                if (minIndex != i) {
                                    Object[] temp = mEmpleados[minIndex];
                                    mEmpleados[minIndex] = mEmpleados[i];
                                    mEmpleados[i] = temp;
                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsEmpleados[opc - 1] + ":");

                            for (int i = 0; i < mEmpleados.length; i++) {

                                System.out.println(dtsEmpleados[opc - 1] + " [" + (i + 1) + "] = " + mEmpleados[i][opc - 1]);
                            }

                        }

                        return;

                    case 'q':
                    case 'Q':
                        if (oc == 'Q' || oc == 'q') {
                            System.out.println("¿Desea salir? (Y/N)");
                            char respuesta = sLea.next().charAt(0);
                            if (respuesta == 'y' || respuesta == 'Y') {
                                return;
                            } else if (respuesta == 'n' || respuesta == 'N') {
                                System.out.println("Continue...");
                            }
                        }
                        break;
                    default:
                        System.out.println("ERROR: digite una opcion correcta");
                        break;

                }

            case 'q':
            case 'Q':

                if (op == 'Q' || op == 'q') {
                    System.out.println("¿Desea salir? (Y/N)");
                    char respuesta = sLea.next().charAt(0);
                    if (respuesta == 'y' || respuesta == 'Y') {
                        return;
                    } else if (respuesta == 'n' || respuesta == 'N') {
                        System.out.println("Continue...");
                    }
                }
                break;

            default:
                System.out.println("ERROR: digite una opcion correcta");
                break;

        }
    }
}
