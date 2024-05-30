package Imeco;

import Farmacia.Cliente;
import Farmacia.Empleado;
import Farmacia.Medicamentos;
import java.util.Scanner;

public class Consultar {

    public  Scanner sLea = new Scanner(System.in);
    public  Scanner nLea = new Scanner(System.in);
    public  char op;
    public  int opConsul;
    
    Medicamentos medicamentos = new Medicamentos();
    Empleado empleado = new Empleado();
    Cliente cliente = new Cliente();

    public void subMenu() {
        do {
            System.out.println("\n\t\t\tSubMenu Consulta\t\t\t"
                    + "\n1.Medicamentos"
                    + "\n2.Empleado"
                    + "\n3.Cliente"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {

                case '1':
                    System.out.println( "\n1.Consultar todo"
                                       + "\n2.Consultar por campo");
                    
                    opConsul = nLea.nextInt();
                    medicamentos.consultaMedi(opConsul);
                    
                    
                    break;

                case '2':
                    System.out.println( "\n1.Consultar todo"
                                       + "\n2.Consultar por campo");
                    
                    opConsul = nLea.nextInt();
                    empleado.consultEmpleados(opConsul);
                    break;

                case '3':
                    System.out.println( "\n1.Consultar todo"
                                       + "\n2.Consultar por campo");
                    
                    
                    opConsul = nLea.nextInt();
                    cliente.consultaCli(opConsul);
                    
                    break;
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

        } while (op != 'Q' || op != 'q');

    }

    private void subMenuconsultar() {
        do {
            System.out.println("\n\t\t\tConsultar\t\t\t"
                    + "\n1.Consultar todo"
                    + "\n2.Consultar por campo"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {
                case '1':
                    
                    break;

                case '2':
                    consultaPorCampo();
                    break;

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
        } while (op != 'Q' || op != 'q');
    }
    
    private void consultaPorCampo(){
         do {
            System.out.println("\n\t\t\tConsultar Por\t\t\t"
                    + "\n1.Identificacion"
                    + "\n2.nombre"
                    + "\n3.apellido"
                    + "\n4.Codigo"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {
                case '1':
                    
                    break;

                case '2':
                    
                    break;
                    
                case '3':
                    
                    break;
                    
                case '4':
                    
                    break;

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
        } while (op != 'Q' || op != 'q');
    }
}
