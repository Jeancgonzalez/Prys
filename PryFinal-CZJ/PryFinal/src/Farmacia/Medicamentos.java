package Farmacia;

import java.util.Scanner;

public class Medicamentos {

    private static Object[][] mMedicamento;
    private static Object[] dtsMedic = {"Codigo", "Nombre comercial", "laboratorio"};

    Scanner sLea = new Scanner(System.in);
    Scanner nLea = new Scanner(System.in);

    public void registrarMedicamento(int cant) {

        mMedicamento = new Object[cant][dtsMedic.length];

        for (int i = 0; i < mMedicamento.length; i++) {

            System.out.println("Registro " + (i + 1) + ":");

            for (int j = 0; j < dtsMedic.length; j++) {
                System.out.print(dtsMedic[j] + " del medicamento " + (i + 1) + ": ");
                mMedicamento[i][j] = sLea.next();
            }
        }
    }

    public void consultaMedi(int op) {

        if (op == 1) {
            System.out.println("\nInformacion de Medicamentos:");
            for (int i = 0; i < mMedicamento.length; i++) {
                System.out.println("\t\t\tMedicamento " + (i + 1) + "\t\t\t");
                for (int j = 0; j < dtsMedic.length; j++) {
                    System.out.print(dtsMedic[j] + " = " + mMedicamento[i][j] + "    ");
                }
                System.out.println();
            }
        }

        if (op == 2) {
            int opc;
            System.out.println("\t\t\tSubMenu Consulta\t\t\t");
            for (int i = 0; i < dtsMedic.length; i++) {
                System.out.println((i + 1) + "." + dtsMedic[i]);
            }
            System.out.println("Digite el registro en el que desea buscar:");
            opc = nLea.nextInt();

            System.out.println("\nInformacion de " + dtsMedic[opc - 1] + ":");

            for (int i = 0; i < mMedicamento.length; i++) {

                System.out.println("\n" + dtsMedic[opc - 1] + " " + (i + 1) + ": " + mMedicamento[i][opc - 1]);
            }
        }
    }

   

    public Object[][] verficaciMed() {
        return mMedicamento;
    }

    public void eliminarTablaMed(String comp) {

        Object[][] nuevosBitacora = new Object[mMedicamento.length - 1][dtsMedic.length];
        int indiceNuevo = 0;

        for (int i = 0; i < mMedicamento.length; i++) {
            if (!comp.equals(mMedicamento[i][0])) {
                nuevosBitacora[indiceNuevo++] = mMedicamento[i];
            }
        }
        mMedicamento = nuevosBitacora;
        System.out.println("Registro eliminado correctamente.");
    }

    public void modificaMedi(String comp) {
        System.out.println("Digite el codigo del registro que desea modificar:");
        comp = sLea.next();

        for (int i = 0; i < mMedicamento.length; i++) {
            if (comp.equals(mMedicamento[i][0])) {
                System.out.println("Digite los nuevos datos del registro:");
                for (int j = 0; j < dtsMedic.length; j++) {
                    System.out.print(dtsMedic[j] + " = ");
                    mMedicamento[i][j] = sLea.next();

                }
            }
        }

    }

    public void ordeMedi(char op) {
        int opc;
        int oc;

        switch (op) {

            case '1':

                System.out.println("\t\t\tSubMenu Ordenar Todo\t\t\t");
                for (int i = 0; i < dtsMedic.length; i++) {
                    System.out.println((i + 1) + "." + dtsMedic[i]);
                }

                System.out.println("\nEliga el metodo por el cual desea ordenar el campo");
                System.out.println("\n1.Burbuja"
                        + "\n2.Inserccion"
                        + "\nQ.Salir");

                oc = nLea.next().charAt(0);

                switch (oc) {
                    case '1':

                        int n = mMedicamento.length;

                        for (int i = 0; i < n - 1; i++) {
                            for (int j = 0; j < n - i - 1; j++) {

                                Integer codigoActual = Integer.valueOf((String) mMedicamento[j][0]);
                                Integer codigoSiguiente = Integer.valueOf((String) mMedicamento[j + 1][0]);

                                if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                    Object[] aux = mMedicamento[j];
                                    mMedicamento[j] = mMedicamento[j + 1];
                                    mMedicamento[j + 1] = aux;
                                }

                            }
                        }
                        System.out.println("\nInformacion ordenada de la tabla empleado:");

                        for (int i = 0; i < mMedicamento.length; i++) {
                            System.out.println("\t\t\tMedicamento " + (i + 1) + "\t\t\t");
                            for (int j = 0; j < dtsMedic.length; j++) {
                                System.out.print(dtsMedic[j] + " = " + mMedicamento[i][j] + "    ");
                            }
                            System.out.println();
                        }

                        return;
                    case '2':

                        for (int i = 0; i < mMedicamento.length - 1; i++) {

                            int minIndex = i;
                            int minCodigo = Integer.parseInt((String) mMedicamento[i][0]);

                            for (int j = i + 1; j < mMedicamento.length; j++) {
                                int codigoActual = Integer.parseInt((String) mMedicamento[j][0]);
                                if (codigoActual < minCodigo) {
                                    minCodigo = codigoActual;
                                    minIndex = j;
                                }
                            }

                            if (minIndex != i) {
                                Object[] temp = mMedicamento[minIndex];
                                mMedicamento[minIndex] = mMedicamento[i];
                                mMedicamento[i] = temp;
                            }
                        }

                        System.out.println("\nInformacion ordenada de la tabla empleado:");

                        for (int i = 0; i < mMedicamento.length; i++) {
                            System.out.println("\t\t\tMedicamento " + (i + 1) + "\t\t\t");
                            for (int j = 0; j < dtsMedic.length; j++) {
                                System.out.print(dtsMedic[j] + " = " + mMedicamento[i][j] + "    ");
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
                for (int i = 0; i < dtsMedic.length; i++) {
                    System.out.println((i + 1) + "." + dtsMedic[i]);
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
                            int n = mMedicamento.length;

                            for (int i = 0; i < n - 1; i++) {
                                for (int j = 0; j < n - i - 1; j++) {

                                    Integer codigoActual = Integer.valueOf((String) mMedicamento[j][opc - 1]);
                                    Integer codigoSiguiente = Integer.valueOf((String) mMedicamento[j + 1][opc - 1]);

                                    if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                        Object[] aux = mMedicamento[j];
                                        mMedicamento[j] = mMedicamento[j + 1];
                                        mMedicamento[j + 1] = aux;
                                    }

                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsMedic[opc - 1] + ":");

                            for (int i = 0; i < mMedicamento.length; i++) {

                                System.out.println(dtsMedic[opc - 1] + " [" + (i + 1) + "] = " + mMedicamento[i][opc - 1]);
                            }
                        }

                        if ((opc - 1) != 0) {
                            int n = mMedicamento.length;

                            for (int i = 0; i < n - 1; i++) {
                                for (int j = 0; j < n - i - 1; j++) {

                                    Comparable codigoActual = (Comparable) mMedicamento[j][opc - 1];
                                    Comparable codigoSiguiente = (Comparable) mMedicamento[j + 1][opc - 1];

                                    if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                        Object[] aux = mMedicamento[j];
                                        mMedicamento[j] = mMedicamento[j + 1];
                                        mMedicamento[j + 1] = aux;
                                    }

                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsMedic[opc - 1] + ":");

                            for (int i = 0; i < mMedicamento.length; i++) {

                                System.out.println(dtsMedic[opc - 1] + " [" + (i + 1) + "] = " + mMedicamento[i][opc - 1]);
                            }
                        }

                        return;

                    case '2':

                        if ((opc - 1) == 0) {
                            for (int i = 0; i < mMedicamento.length - 1; i++) {

                                int minIndex = i;
                                int minCodigo = Integer.parseInt((String) mMedicamento[i][opc - 1]);

                                for (int j = i + 1; j < mMedicamento.length; j++) {
                                    int codigoActual = Integer.parseInt((String) mMedicamento[j][opc - 1]);
                                    if (codigoActual < minCodigo) {
                                        minCodigo = codigoActual;
                                        minIndex = j;
                                    }
                                }

                                if (minIndex != i) {
                                    Object[] temp = mMedicamento[minIndex];
                                    mMedicamento[minIndex] = mMedicamento[i];
                                    mMedicamento[i] = temp;
                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsMedic[opc - 1] + ":");

                            for (int i = 0; i < mMedicamento.length; i++) {

                                System.out.println(dtsMedic[opc - 1] + " [" + (i + 1) + "] = " + mMedicamento[i][opc - 1]);
                            }
                        }

                        if ((opc - 1) != 0) {
                            for (int i = 0; i < mMedicamento.length - 1; i++) {
                                int minIndex = i;
                                String minCodigo = (String) mMedicamento[i][opc - 1];

                                for (int j = i + 1; j < mMedicamento.length; j++) {
                                    String codigoActual = (String) mMedicamento[j][opc - 1];
                                    if (codigoActual.compareTo(minCodigo) < 0) {
                                        minCodigo = codigoActual;
                                        minIndex = j;
                                    }
                                }

                                if (minIndex != i) {
                                    Object[] temp = mMedicamento[minIndex];
                                    mMedicamento[minIndex] = mMedicamento[i];
                                    mMedicamento[i] = temp;
                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsMedic[opc - 1] + ":");

                            for (int i = 0; i < mMedicamento.length; i++) {

                                System.out.println(dtsMedic[opc - 1] + " [" + (i + 1) + "] = " + mMedicamento[i][opc - 1]);
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
