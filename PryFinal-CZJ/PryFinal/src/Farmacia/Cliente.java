package Farmacia;

import java.util.Scanner;

public class Cliente {

    //Se creo una matriz bidimencional con un estado de nombramiento, en la cual se trabajaran
    // todas las opciones del menu principal (Matriz principal).
    private static Object[][] mClientes;

    //se creo una matriz unidimencional con un estado de inicializacion o "quemada"
    // con el fin de representar las columnas o datos (Matriz quemada)
    //que almacena la matriz anteriormente presentada.
    private static Object[] dtsClientes = {"Codigo", "Nombre", "Edad", "Genero"};

    //Se hizieron dos scanner para poder ingresar los datos que se desean 
    //guardan en la matriz principal
    Scanner sLea = new Scanner(System.in);
    Scanner nLea = new Scanner(System.in);

    //(metodo para registrar los datos dentro de la tabla principal)
    //este metodo cuenta con un argumento tipo entero llamado "cant" con el cual
    //se le definira la cantidad de filas con las que trabajara la matriz principal
    //--Se hizo uso de dos estructuras condicionales iterativas de naturaleza 
    //numerica con el fin de poder almacenar los datos registrado en la matriz
    //principal.
    //con la estructuras condicionales iterativas "i" y "j" podemos definir la pocision en la 
    //que queremos registrar cierto dato.
    //"i" representan las fila y la "j" representa la columna.
    public void rgtrClientes(int cant) {

        mClientes = new Object[cant][dtsClientes.length];

        for (int i = 0; i < mClientes.length; i++) {
            System.out.println("Registro " + (i + 1) + ":");
            for (int j = 0; j < dtsClientes.length; j++) {

                System.out.print(dtsClientes[j] + " del cliente " + (i + 1) + ": ");
                mClientes[i][j] = sLea.next();

            }

        }

    }

    //(metodo para consultar los datos registrados en la tabla principal)
//    Este metodo cuenta con un argumento tipo entero "op" con el cual se elegira 
//     la linea de codigo que se desea ejecutar a travez de una estructura condicional
//    selectiva de naturalezs mixta existen dos opciones.
    
//    1. Se hizo uso de dos estructuras condicionales iterativas de naturaleza 
//    numerica con el fin de poder visualizar los datos registrados en la matriz
//    principal o en la tabla de cliente.
//    
//    con las estructuras condicionales iterativas "i" y "j" podemos definir la pocision
//    que queremos visualizar.
    
    //2.Se creo una variable con un estado de nombramiento "opc" con el objetivo
    // de que el usuario pueda ingresar el campo especifico en el que desea buscar
    //con la estructura condicional iterativa "i" de naturaleza numerica servira para
    //presentar los campos con los que puede trabajar el usuario osea los de la 
    // matriz quemada "dtsClientes".
//    con la estructura condicional "j" de naturaleza numerica servira para
//    presentar o visualizar la columna de cada uno de los datos registrados en 
//    la tabla cliente.
    public void consultaCli(int op) {

        if (op == 1) {
            System.out.println("\nInformacion de Clientes:");
            for (int i = 0; i < mClientes.length; i++) {
                System.out.println("\t\t\tCliente " + (i + 1) + "\t\t\t");
                for (int j = 0; j < dtsClientes.length; j++) {
                    System.out.print(dtsClientes[j] + " = " + mClientes[i][j] + "    ");
                }
                System.out.println();
            }
        }
        if (op == 2) {

            int opc;
            System.out.println("\t\t\tSubMenu Consulta\t\t\t");
            for (int i = 0; i < dtsClientes.length; i++) {
                System.out.println((i + 1) + "." + dtsClientes[i]);
            }
            System.out.println("Digite el registro en el que desea buscar:");
            opc = nLea.nextInt();

            System.out.println("\nInformacion de " + dtsClientes[opc - 1] + ":");

            for (int j = 0; j < mClientes.length; j++) {

                System.out.println("\n" + dtsClientes[opc - 1] + " " + (j + 1) + ": " + mClientes[j][opc - 1]);
            }

        }

    }

  

    //(metodo usado para ver si existe algun valor dentro de la tabla)
    public Object[][] verficaciCli() {
        return mClientes;
    }

    //(metodo para eliminar algun registro dentro de la tabla cliente)
    //este metodo cuenta con un argumento tipo string llamado "comp" con el cual
    //buscaremos el registro que deseamos eliminar.
    
//    se creo una nueva matirz bidimencional "nuevos" con un estado de incializacion, ademas
//    esta contara una fila menos que la "matriz princial" pero con la misma 
//    cantidad de columnas.
    
    //Tambien se creo una variable en estado de inicializacion "indiceNuevo"con el fin de poder
    //mantener una posicion exacta en la matriz "nuevos".
//    
//    despues se utilizo una estructura condicional iterativa "i" con el fin de poder 
//    recorrer todos los valores de la primera columna de la tabla principal.
    
    //despues se utilizo una estrucutura condicional selectiva con el fin de poder
    //comparar el valor del argumento "comp" con todos los valores de la primera columna.
    //de la tabla principal en caso tal de que esta estrcutura se cumpliera se 
    //ejecutaria la linea de codigo denttro de ella.
    
//    En caso tal de que se cumpla esta estructura selectiva se identificara el 
//    valor de la fila con la primera columna igual a "comp" si esto ocurre 
//    no se ingresara o copiara la fila con el mismo valor de "comp" esto lo haremos 
//    en la matriz "nuevo".
    
//    al terminar el proceso haremos que la matriz principal sea igual a la matriz
//    "nuevo" dado que la matriz "nuevo" es en la que realiza se realiza la modificacion.
//     si no se cumple lo que esta dentro de la estructura selectiva la matriz 
//     principal sera igual.
    //y se imprimira un mensaje.
    public void eliminarTablaCli(String comp) {

        Object[][] nuevos = new Object[mClientes.length - 1][dtsClientes.length];
        int indiceNuevo = 0;

        for (int i = 0; i < mClientes.length; i++) {
            if (!comp.equals(mClientes[i][0])) {
                nuevos[indiceNuevo++] = mClientes[i];
            }
        }
        mClientes = nuevos;
        System.out.println("Registro eliminado correctamente.");
    }

    //(metodo para modificar algun registro de la tabla cliente)
//    este metodo cuenta con un argumento tipo string llamado "comp" con el cual
//    buscaremos el registro que deseamos modificar.
//    En este caso haremos uso de un escaner para poder ingresar el valor que tendra
//    "comp".
    
    //despues se utilizo una estructura condicional iterativa "i" con el fin de poder 
    //recorrer todos los valores de la primera columna de la tabla cliente.
    //despues se utilizo una estrucutura condicional selectiva con el fin de poder
    //comparar el valor del argumento "comp" con todos los valores de la primera columna.
    //En caso tal de que se cumpla esta estructura selectiva se identificara el 
    //valor de la fila con la primera columna igual a "comp" si esto ocurre.
    // Se impirmira un mensaje.
    // y se utiliza una estructura condicional iterativa "j" para
    //presentar o visualizar la columna de cada uno de los datos registrados.
    //con la estructura condicional "i" y "j" podemos definir la pocision en la 
    //que queremos modificar los datos.
    //"i" representan las fila y la "j" representa la columna.
    public void modificarCli(String comp) {
        System.out.println("Digite el codigo del registro que desea modificar:");
        comp = sLea.next();

        for (int i = 0; i < mClientes.length; i++) {
            if (comp.equals(mClientes[i][0])) {
                System.out.println("Digite los nuevos datos del registro:");
                for (int j = 0; j < dtsClientes.length; j++) {
                    System.out.print(dtsClientes[j] + " = ");
                    mClientes[i][j] = sLea.next();

                }
            }
        }

    }

    public void ordeCli(char op) {
        int opc;
        int oc;

        switch (op) {

            case '1':

                System.out.println("\t\t\tSubMenu Ordenar Todo\t\t\t");
                for (int i = 0; i < dtsClientes.length; i++) {
                    System.out.println((i + 1) + "." + dtsClientes[i]);
                }

                System.out.println("\nEliga el metodo por el cual desea ordenar el campo");
                System.out.println("\n1.Burbuja"
                        + "\n2.Inserccion"
                        + "\nQ.Salir");

                oc = nLea.next().charAt(0);

                switch (oc) {
                    case '1':

                        int n = mClientes.length;

                        for (int i = 0; i < n - 1; i++) {
                            for (int j = 0; j < n - i - 1; j++) {

                                Integer codigoActual = Integer.valueOf((String) mClientes[j][0]);
                                Integer codigoSiguiente = Integer.valueOf((String) mClientes[j + 1][0]);

                                if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                    Object[] aux = mClientes[j];
                                    mClientes[j] = mClientes[j + 1];
                                    mClientes[j + 1] = aux;
                                }

                            }
                        }
                        System.out.println("\nInformacion ordenada de la tabla empleado:");

                        for (int i = 0; i < mClientes.length; i++) {
                            System.out.println("\t\t\tMedicamento " + (i + 1) + "\t\t\t");
                            for (int j = 0; j < dtsClientes.length; j++) {
                                System.out.print(dtsClientes[j] + " = " + mClientes[i][j] + "    ");
                            }
                            System.out.println();
                        }

                        return;
                    case '2':

                        for (int i = 0; i < mClientes.length - 1; i++) {

                            int minIndex = i;
                            int minCodigo = Integer.parseInt((String) mClientes[i][0]);

                            for (int j = i + 1; j < mClientes.length; j++) {
                                int codigoActual = Integer.parseInt((String) mClientes[j][0]);
                                if (codigoActual < minCodigo) {
                                    minCodigo = codigoActual;
                                    minIndex = j;
                                }
                            }

                            if (minIndex != i) {
                                Object[] temp = mClientes[minIndex];
                                mClientes[minIndex] = mClientes[i];
                                mClientes[i] = temp;
                            }
                        }

                        System.out.println("\nInformacion ordenada de la tabla empleado:");

                        for (int i = 0; i < mClientes.length; i++) {
                            System.out.println("\t\t\tMedicamento " + (i + 1) + "\t\t\t");
                            for (int j = 0; j < dtsClientes.length; j++) {
                                System.out.print(dtsClientes[j] + " = " + mClientes[i][j] + "    ");
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
                for (int i = 0; i < dtsClientes.length; i++) {
                    System.out.println((i + 1) + "." + dtsClientes[i]);
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
                            int n = mClientes.length;

                            for (int i = 0; i < n - 1; i++) {
                                for (int j = 0; j < n - i - 1; j++) {

                                    Integer codigoActual = Integer.valueOf((String) mClientes[j][opc - 1]);
                                    Integer codigoSiguiente = Integer.valueOf((String) mClientes[j + 1][opc - 1]);

                                    if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                        Object[] aux = mClientes[j];
                                        mClientes[j] = mClientes[j + 1];
                                        mClientes[j + 1] = aux;
                                    }

                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsClientes[opc - 1] + ":");

                            for (int i = 0; i < mClientes.length; i++) {

                                System.out.println(dtsClientes[opc - 1] + " [" + (i + 1) + "] = " + mClientes[i][opc - 1]);
                            }
                        }

                        if ((opc - 1) != 0) {
                            int n = mClientes.length;

                            for (int i = 0; i < n - 1; i++) {
                                for (int j = 0; j < n - i - 1; j++) {

                                    Comparable codigoActual = (Comparable) mClientes[j][opc - 1];
                                    Comparable codigoSiguiente = (Comparable) mClientes[j + 1][opc - 1];

                                    if (codigoActual.compareTo(codigoSiguiente) > 0) {

                                        Object[] aux = mClientes[j];
                                        mClientes[j] = mClientes[j + 1];
                                        mClientes[j + 1] = aux;
                                    }

                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsClientes[opc - 1] + ":");

                            for (int i = 0; i < mClientes.length; i++) {

                                System.out.println(dtsClientes[opc - 1] + " [" + (i + 1) + "] = " + mClientes[i][opc - 1]);
                            }
                        }

                        return;

                    case '2':

                        if ((opc - 1) == 0) {
                            for (int i = 0; i < mClientes.length - 1; i++) {

                                int minIndex = i;
                                int minCodigo = Integer.parseInt((String) mClientes[i][opc - 1]);

                                for (int j = i + 1; j < mClientes.length; j++) {
                                    int codigoActual = Integer.parseInt((String) mClientes[j][opc - 1]);
                                    if (codigoActual < minCodigo) {
                                        minCodigo = codigoActual;
                                        minIndex = j;
                                    }
                                }

                                if (minIndex != i) {
                                    Object[] temp = mClientes[minIndex];
                                    mClientes[minIndex] = mClientes[i];
                                    mClientes[i] = temp;
                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsClientes[opc - 1] + ":");

                            for (int i = 0; i < mClientes.length; i++) {

                                System.out.println(dtsClientes[opc - 1] + " [" + (i + 1) + "] = " + mClientes[i][opc - 1]);
                            }
                        }

                        if ((opc - 1) != 0) {
                            for (int i = 0; i < mClientes.length - 1; i++) {
                                int minIndex = i;
                                String minCodigo = (String) mClientes[i][opc - 1];

                                for (int j = i + 1; j < mClientes.length; j++) {
                                    String codigoActual = (String) mClientes[j][opc - 1];
                                    if (codigoActual.compareTo(minCodigo) < 0) {
                                        minCodigo = codigoActual;
                                        minIndex = j;
                                    }
                                }

                                if (minIndex != i) {
                                    Object[] temp = mClientes[minIndex];
                                    mClientes[minIndex] = mClientes[i];
                                    mClientes[i] = temp;
                                }
                            }

                            System.out.println("\nInformacion ordenada de " + dtsClientes[opc - 1] + ":");

                            for (int i = 0; i < mClientes.length; i++) {

                                System.out.println(dtsClientes[opc - 1] + " [" + (i + 1) + "] = " + mClientes[i][opc - 1]);
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
