/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class GestionCitas {

    Scanner sc = new Scanner(System.in);
    GestionPersonal trabajador = new GestionPersonal();
    GestionPacientes paciente = new GestionPacientes();

    public void crearCita(List<PersonalHospital> personal, Map<String, Paciente> pacientes, List<Cita> citas) {
        System.out.print("Introduce el motivo: ");
        String motivo = sc.nextLine();
        System.out.print("Introduce el estado: ");
        String estado = sc.nextLine();
        System.out.println("Introduce el paciente");
        Paciente auxPaciente = paciente.buscarPaciente(pacientes);
        System.out.print("Introduce el medico: ");
        for (PersonalHospital persona : personal) {
            if (persona instanceof Medico) {
                System.out.println("Nombre: " + persona.getNombre() + " DNI: " + persona.getDni() + " - es medico");
            }
        }
        System.out.println("Introduce el dni del medico que quieres que sea asignado");
        String dni = sc.nextLine();
        Medico asignado = null;
        for (PersonalHospital persona : personal) {
            if (persona.getDni().equalsIgnoreCase(dni)) {
                if (persona instanceof Medico m) {
                    asignado = m;
                    break;
                } else {
                    System.out.println("No es medico error");
                    break;
                }

            }
        }
        if (asignado != null) {
            asignado.setDisponible(true);
        } else {
            System.out.println("No se ha introducido ninguno.");
        }
        System.out.print("Introduce la fecha de la cita: ");
        System.out.print("Año: ");
        int año = Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");
        int dia = Integer.parseInt(sc.nextLine());
        System.out.print("Hora: ");
        int hora = Integer.parseInt(sc.nextLine());
        System.out.print("minuto: ");
        int minuto = Integer.parseInt(sc.nextLine());
        citas.add(new Cita(motivo, estado, auxPaciente, asignado, LocalDateTime.of(LocalDate.of(año, mes, dia), LocalTime.of(hora, minuto))));
    }

    public void cancelarCita(List<Cita> citas) {
        System.out.println("Introduce el id de la cita.");
        String id = sc.nextLine();
        Iterator<Cita> it_citas = citas.iterator();
        while (it_citas.hasNext()) {
            Cita citaAux = it_citas.next();
            if (citaAux.getId().equalsIgnoreCase(id)) {
                citaAux.getMedico().setDisponible(false);
                it_citas.remove();
                break;
            }
        }
    }
    public void completarCita(List<Cita> citas){
        //NI PUTA IDEA
    }
    public void listarCitasDia(List<Cita> citas){
        System.out.print("Introduce la fecha de la cita: ");
        System.out.print("Año: ");
        int año = Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");
        int mes = Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");
        int dia = Integer.parseInt(sc.nextLine());
        for (Cita cita : citas) {
            if(cita.getFecha().getYear()==año &&cita.getFecha().getMonthValue()==mes&& cita.getFecha().getDayOfMonth()==dia){
                System.out.println(cita.toString());
            }
        }
    }
    public void listarCitasMedico(List<Cita> citas,List<PersonalHospital> personal){
        System.out.print("Introduce el medico: ");
        for (PersonalHospital persona : personal) {
            if (persona instanceof Medico) {
                System.out.println("Nombre: " + persona.getNombre() + " DNI: " + persona.getDni() + " - es medico");
            }
        }
        System.out.println("Introduce el dni del medico que quieres listar");
        String dni = sc.nextLine();
        Medico asignado = null;
        for (PersonalHospital persona : personal) {
            if (persona.getDni().equalsIgnoreCase(dni)) {
                if (persona instanceof Medico m) {
                    asignado = m;
                    break;
                } else {
                    System.out.println("No es medico error");
                    return;
                }
            }
    }
        for (Cita cita : citas) {
            if(cita.getMedico().equals(asignado)){
                System.out.println(cita.toString());
            }
        }

        
}
    public void listarCitaPaciente(List<Cita> citas,Map<String, Paciente> pacientes){
            System.out.println("Introduce el paciente:");
            Paciente aux=paciente.buscarPaciente(pacientes);
            if(aux!=null){
                for (Cita cita : citas) {
                    if(cita.getPaciente().equals(aux)){
                        System.out.println(cita.toString());
                    }
                }
            }else{
                try {
                    throw new PacienteNoEncontradoException();
                } catch (PacienteNoEncontradoException ex) {
                    Logger.getLogger(GestionCitas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
