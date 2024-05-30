package Imeco;

import Farmacia.Cliente;
import Farmacia.Empleado;
import Farmacia.Medicamentos;
import java.util.Scanner;

public class Ordenar {

    public Scanner sLea = new Scanner(System.in);
    public Scanner nLea = new Scanner(System.in);
    public char op;
    public char opOrde;


    Medicamentos medicamentos = new Medicamentos();
    Empleado empleado = new Empleado();
    Cliente cliente = new Cliente();

    public void subMenu() {
        do {
            System.out.println("\n\t\t\tSubMenu de Ordenamiento\t\t\t"
                    + "\n1.Medicamentos"
                    + "\n2.Empleado"
                    + "\n3.Cliente"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {

                case '1':
                    if (medicamentos.verficaciMed() == null) {

                        System.out.println("Asegurese de haber registrado informacion"
                                + "en la seccion medicamento ");
                    }
                    
                    if (medicamentos.verficaciMed() != null) {
                    System.out.println("Tabla de medicamentos sin ordenar");
                    medicamentos.consultaMedi(1);

                    System.out.println( "\n1.Ordenar todo"
                                       + "\n2.Ordenar por campo"
                                       + "\nQ.salir");
                    
                    opOrde = nLea.next().charAt(0);
                    medicamentos.ordeMedi(opOrde);
                    }
                    break;

                case '2':
                    if (empleado.verficaciEMple()== null) {

                        System.out.println("Asegurese de haber registrado informacion"
                                + "en la seccion empleado ");
                    }
                    
                    if (empleado.verficaciEMple() != null) {
                    System.out.println("Tabla de empleado sin ordenar");
                    empleado.consultEmpleados(1);

                    System.out.println( "\n1.Ordenar todo"
                                       + "\n2.Ordenar por campo"
                                       + "\nQ.salir");
                    
                    opOrde = nLea.next().charAt(0);
                    empleado.ordeEmpl(opOrde);
                    }

                    break;

                case '3':
                    if (cliente.verficaciCli()== null) {

                        System.out.println("Asegurese de haber registrado informacion"
                                + "en la seccion cliente ");
                    }
                    
                    if (cliente.verficaciCli()!= null) {
                    System.out.println("Tabla de cliente sin ordenar");
                    cliente.consultaCli(1);

                    System.out.println( "\n1.Ordenar todo"
                                       + "\n2.Ordenar por campo"
                                       + "\nQ.salir");
                    
                    opOrde = nLea.next().charAt(0);
                    cliente.ordeCli(opOrde);
                    }
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