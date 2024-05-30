package Imeco;

import Farmacia.Cliente;
import Farmacia.Empleado;
import Farmacia.Medicamentos;
import java.util.Scanner;

public class Modificar {

    public  Scanner sLea = new Scanner(System.in);
    public  Scanner nLea = new Scanner(System.in);
    public  char op;

    Medicamentos medicamentos = new Medicamentos();
    Empleado empleado = new Empleado();
    Cliente cliente = new Cliente();
    
    public void subMenu() {
        do {
            System.out.println("\n\t\t\tSubMenu Modificar\t\t\t"
                    + "\n1.Medicamentos"
                    + "\n2.Empleado"
                    + "\n3.Cliente"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {

                case '1':
                    
                    if (medicamentos.verficaciMed()== null) {

                        System.out.println("Asegurese de haber registrado informacion"
                                + "en la seccion de medicamentos ");
                    }

                    if (medicamentos.verficaciMed() != null) {

                        medicamentos.consultaMedi(1);
                        System.out.println("Ingrese el codigo del registro desea modificar");
                        String cMedi = sLea.next();

                        System.out.println("¿Esta seguro que desea modificar el registro con codgio? " + cMedi + " (Y/N)");
                        char respuesta = nLea.next().charAt(0);

                        if (respuesta == 'y' || respuesta == 'Y') {
                            medicamentos.modificaMedi(cMedi);
                        } else if (respuesta == 'n' || respuesta == 'N') {
                            return;
                        }
                    }

                    break;

                case '2':
                    
                    if (empleado.verficaciEMple()== null) {

                        System.out.println("Asegurese de haber registrado informacion"
                                + "en la seccion de empleados ");
                    }

                    if (empleado.verficaciEMple() != null) {

                        empleado.consultEmpleados(1);
                        System.out.println("Ingrese el codigo del registro desea modificar");
                        String cEmple = sLea.next();

                        System.out.println("¿Esta seguro que desea modificar el registro con codgio? " + cEmple + " (Y/N)");
                        char respuesta = nLea.next().charAt(0);

                        if (respuesta == 'y' || respuesta == 'Y') {
                            empleado.modificarEmpl(cEmple);
                        } else if (respuesta == 'n' || respuesta == 'N') {
                            return;
                        }
                    }
                    break;

                case '3':
                    
                    if (cliente.verficaciCli()== null) {

                        System.out.println("Asegurese de haber registrado informacion"
                                + "en la seccion de clientes ");
                    }

                    if (cliente.verficaciCli() != null) {

                        empleado.consultEmpleados(1);
                        System.out.println("Ingrese el codigo del registro desea modificar");
                        String cCli = sLea.next();

                        System.out.println("¿Esta seguro que desea modificar el registro con codgio? " + cCli + " (Y/N)");
                        char respuesta = nLea.next().charAt(0);

                        if (respuesta == 'y' || respuesta == 'Y') {
                            cliente.modificarCli(cCli);
                        } else if (respuesta == 'n' || respuesta == 'N') {
                            return;
                        }
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

        } while (op != 'Q' || op != 'q');

    }
}
