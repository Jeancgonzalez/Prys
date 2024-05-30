package Imeco;

import Farmacia.Cliente;
import Farmacia.Empleado;
import Farmacia.Medicamentos;
import java.util.Scanner;

public class Insertar {

    public Scanner sLea = new Scanner(System.in);
    public Scanner nLea = new Scanner(System.in);
    public Scanner aLea = new Scanner(System.in);
    public char op;
    public int cnt;

    Medicamentos medicamentos = new Medicamentos();
    Empleado empleado = new Empleado();
    Cliente cliente = new Cliente();

    public void subMenu() {
       do{
            System.out.println("\n\t\t\tSubMenu Insertar\t\t\t"
                    + "\n1.Medicamentos"
                    + "\n2.Empleado"
                    + "\n3.Cliente"
                    + "\nQ.Salir"
                    + "\nDigite opcion");
            op = sLea.next().charAt(0);

            switch (op) {

                case '1':
                    System.out.println("Digite la cantidad de medicamentos que desea registrar");
                    cnt = nLea.nextInt();
                    medicamentos.registrarMedicamento(cnt);

                    break;

                case '2':
                    System.out.println("Digite la cantidad de empleados que desea registrar");
                    cnt = nLea.nextInt();

                    empleado.rgtrEmpleado(cnt);

                    break;

                case '3':

                 System.out.println("Digite la cantidad de clientes que desea registrar");
                    cnt = nLea.nextInt();

                    cliente.rgtrClientes(cnt);
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

