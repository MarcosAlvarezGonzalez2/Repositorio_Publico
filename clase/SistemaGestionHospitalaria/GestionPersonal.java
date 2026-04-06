/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class GestionPersonal {

    Scanner sc = new Scanner(System.in);

    public void darAltaPersonal(List<PersonalHospital> personal) {
        System.out.print("Introduce el dni: ");
        String dni = sc.nextLine();
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el telefono: ");
        String telefono = sc.nextLine();
        System.out.print("Introduce la fecha de Nacimiento: ");
        System.out.print("Año: ");
        int año = Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");
        int dia = Integer.parseInt(sc.nextLine());
        LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);
        System.out.print("Introduce el numero de Empleado: ");
        String numEmpleado = sc.nextLine();
        System.out.print("Introduce el numero de departamento: ");
        String departamento = sc.nextLine();
        System.out.print("Introduce el salario base del Empleado: ");
        double salarioBase = Double.parseDouble(sc.nextLine());
        System.out.print("Introduce la fecha de alta: ");
        System.out.print("Año: ");
        int añoAlta = Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");
        int mesAlta = Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");
        int diaAlta = Integer.parseInt(sc.nextLine());
        LocalDate fechaALta = LocalDate.of(añoAlta, mesAlta, diaAlta);
        int opcion = miniMenu();
        boolean personaAñadida = false;
        do {
            switch (opcion) {
                case 1:
                    System.out.print("Introduce la especialidad: ");
                    String especialidad = sc.nextLine();
                    System.out.print("Introduce el numero de colegiado: ");
                    String numColegiado = sc.nextLine();
                    personal.add(new Medico(especialidad, numColegiado, numEmpleado, departamento, salarioBase, fechaALta, dni, nombre, telefono, fechaNacimiento));
                    personaAñadida = true;
                    break;
                case 2:
                    System.out.print("Introduce el turno: ");
                    String turno = sc.nextLine();
                    System.out.print("Introduce la planta en la cual trabaja: ");
                    int planta = Integer.parseInt(sc.nextLine());
                    personal.add(new Enfermero(planta, turno, numEmpleado, departamento, salarioBase, fechaALta, dni, nombre, telefono, fechaNacimiento));
                    personaAñadida = true;

                    break;
                case 3:
                    System.out.print("Introduce el puesto: ");
                    String puesto = sc.nextLine();
                    personal.add(new Administrativo(puesto, numEmpleado, departamento, salarioBase, fechaALta, dni, nombre, telefono, fechaNacimiento));
                    personaAñadida = true;

                    break;
                default:
                    System.out.println("Opcion incorrecta, introducela de nuevo");
                    opcion = miniMenu();
            }
        } while (!personaAñadida);

    }

    private int miniMenu() {
        System.out.println("""
                           1.-Introduce 1 si es medico.
                           2.-Introduce 2 si es enfermero.
                           3.-Introduce 3 si es administrativo
                           """);
        return Integer.parseInt(sc.nextLine());
    }
  public PersonalHospital buscarEmpleado(List<PersonalHospital>personal){
        PersonalHospital personaBuscada=null;
        System.out.print("Buscarlo por numEmpleado (pon el numero 1) o por nombre (cualquier otra numero): ");
        int opcion=Integer.parseInt(sc.nextLine());
        if(opcion==1){
            System.out.print("Introduce el numero de Empleado: ");
            String numEmpleado=sc.nextLine();
            for (PersonalHospital persona : personal) {
                if(persona.getNumEmpleado().equalsIgnoreCase(numEmpleado)){
                    personaBuscada=persona;
                }
            }
        }else{
            System.out.print("Introduce el nombre: ");
            String nombre=sc.nextLine();
            for (PersonalHospital persona : personal) {
                if(persona.getNombre().equalsIgnoreCase(nombre)){
                    personaBuscada=persona;
                }
            }
        }
        return personaBuscada;
    }
  public void calcularSalarioEmpleado(List<PersonalHospital>personal){
      PersonalHospital aux=buscarEmpleado(personal);
      if(aux!=null){
          System.out.println("El salario es del "+aux.getNombre()+" es: "+aux.calcularSalario());
      }else{
          try {
              throw new EmpleadoNoExistente();
          } catch (EmpleadoNoExistente ex) {
              Logger.getLogger(GestionPersonal.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  }
  public void listarPersonalPorTipo(List<PersonalHospital>personal){
      List<PersonalHospital>listaMedicos=new ArrayList<>();
      List<PersonalHospital>listaEnfermeros=new ArrayList<>();
      List<PersonalHospital>listaAdministrativos=new ArrayList<>();
      for (PersonalHospital persona : personal) {
          if(persona instanceof Medico){
              listaMedicos.add(persona);
          }else if(persona instanceof Enfermero){
              listaEnfermeros.add(persona);
          }else{
             listaAdministrativos.add(persona);
          }
      }
      System.out.println("""
                         ¿Que lista quieres ver?
                         1.-Lista de medicos
                         2.-Lista de enfermeros
                         3.-Lista de administrativos
                         4 u otro numeros.-Ninguno
                         """);
     int opcion=0;
      try {
          opcion=Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
          System.out.println("No es un numero");
      }
      switch(opcion){
          case 1:
              System.out.println("MEDICOS");
              if(listaMedicos.isEmpty()){
                  System.out.println("Esta vacia la lista");
              }
              for (PersonalHospital medico : listaMedicos) {
                  System.out.println(medico.getDescripcion());
              }
              break;
          case 2:
              System.out.println("ENFERMEROS");
              if(listaEnfermeros.isEmpty()){
                  System.out.println("Esta vacia la lista");
              }
              for (PersonalHospital enfermero : listaEnfermeros) {
                  System.out.println(enfermero.getDescripcion());
              }
              break;
          case 3:
              System.out.println("ADMINISTRATIVO");
              if(listaAdministrativos.isEmpty()){
                  System.out.println("Esta vacia la lista");
              }
              for (PersonalHospital administrativa : listaAdministrativos) {
                  System.out.println(administrativa.getDescripcion());
              }
              break;
              default:
                  System.out.println("Numero incorrecto");
      }
  }
  public void listarPersonalDeUnDepartamento(Map<String, Departamento> departamento){
      System.out.print("Introduce el nombre del departamento: ");
      String nombreDepartamento=sc.nextLine();
      if(departamento.containsKey(nombreDepartamento)){
          for (PersonalHospital persona : departamento.get(nombreDepartamento).getPersonal()) {
              System.out.println(persona.getDescripcion());
              System.out.println("===================================");
          }
      }else{
          System.out.println("Departamento no existe");
      }
  }
}
