/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GestorHospital g1 = new GestorHospital();
        g1.cargarDatos();
        int opcion = 0;
        //Bucle
        while (opcion != 6) {
            menuInicial();
            opcion = Integer.parseInt(sc.nextLine());
            int opcionSubMenus = 0;
            switch (opcion) {
                case 1 -> {
                    try {
                        menuPacientes();
                        opcionSubMenus = Integer.parseInt(sc.nextLine());
                        g1.gestionPacientes(opcionSubMenus);
                    } catch (PacienteNoEncontradoException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case 2 -> {
                    try {
                        menuPersonal();
                        opcionSubMenus = Integer.parseInt(sc.nextLine());
                        g1.gestionPersonal(opcionSubMenus);
                    } catch (EmpleadoNoExistente ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case 3 -> {
                    menuCitas();
                    g1.gestionCitas(opcionSubMenus);
                }
                case 4 -> {
                    menuDepartamentos();
                    g1.gestionDepartamentos(opcionSubMenus);
                }
                case 5 -> exportarFicheros(g1);
                case 6 -> System.out.println("Adios al sistema.");
                default -> System.out.println("Numero Error.");
            }
        }
        g1.guardarDatos();
    }

    private static void menuInicial() {
        System.out.println("""
                           1.-Gestor de Pacientes
                           2.-Gestion de Personal
                           3.-Gestion de Citas
                           4.-Gestion de Departamentos
                           5.-Exportar Informes
                           6.-Guardar y salir
                           opcion?¿
                           """);
    }

    private static void menuPacientes() {
        System.out.println("""
                           1.-Alta de Paciente
                           2.-Buscar Paciente
                           3.-Modificar Datos
                           4.-Añadir Alergia a un Paciente
                           5.-Añadir entrada al historial clinico
                           6.-Ver historial clinico completo
                           7.-Listar todos los pacientes
                           opcion¿?
                           """);
    }

    private static void menuPersonal() {
        System.out.println("""
                           1.-Alta del personal
                           2.-Buscar empleado
                           3.-Calcular salario de empleado
                           4.-Listar personal por tipo
                           5.-Listar personal de un departamento
                           opcion¿?
                           """);
    }

    private static void menuCitas() {
        System.out.println("""
                           1.-Crear nueva cita
                           2.-Cancelar cita
                           3.-Completar cita
                           4.-Listar citas de un dia
                           5.-Listar citas de un medico
                           6.-Listar citas de un paciente
                           opcion?¿?
                           """);
    }

    private static void menuDepartamentos() {
        System.out.println("""
                           1.-Crear departamento
                           2.-Asignar personal a un departamento
                           3.-Designar jefe de departamento
                           4.-Ver resumen de un departamento
                           opcion¿¿?¿
                           """);
    }

    private static void exportarFicheros(GestorHospital g1) {
        System.out.println("Introduce el dia cual quieres tener el informe de la citas: ");
        System.out.print("Año: ");
        int año = Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");
        int dia = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce tambien el dni, del informe historial clinico que quieres");
        String dni = sc.nextLine();
        g1.exportarInformes(LocalDate.of(año, mes, dia), dni);
    }

}
