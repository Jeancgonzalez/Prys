package Farmacia;

import Imeco.Consultar;
import Imeco.Modificar;
import Imeco.Ordenar;
import Imeco.Insertar;
import Imeco.Eliminar;
import java.util.Scanner;

public class MainMenu {

    public static char op;

    public static void main(String[] args) {

        Scanner sLea = new Scanner(System.in);
        
        Insertar insertar = new Insertar();
        Modificar modificar = new Modificar();
        Eliminar eliminar = new Eliminar();
        Consultar consultar = new Consultar();
        Ordenar ordenar = new Ordenar();

        do {
            System.out.println("\n\t\t\tMain Menu\t\t\t"
                    + "\n1.Insertar"
                    + "\n2.Modificar"
                    + "\n3.Eliminar"
                    + "\n4.Consultar"
                    + "\n5.Ordenamiento"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {
                case '1':
                    insertar.subMenu();
                    break;
                case '2':
                    modificar.subMenu();
                    break;

                case '3':
                    eliminar.subMenu();
                    break;

                case '4':
                    consultar.subMenu();
                    break;
                case '5':
                    ordenar.subMenu();
                    break;

                case 'q':
                case 'Q':

                    if (op == 'Q' || op == 'q') {
                        System.out.println("¿Desea salir? (Y/N)");
                        char respuesta = sLea.next().charAt(0);
                        if (respuesta == 'y' || respuesta == 'Y') {
                            System.out.println("Gracias por utilizar el sistema");
                            System.exit(0);
                        } else if (respuesta == 'n' || respuesta == 'N') {
                            System.out.println("Continue...");
                        }
                    }
                    break;

                default:
                    System.out.println("ERROR: digite una opcion correcta");
                    break;

            }

        } while (op != 'Q' || op != 'q');
    }

}
