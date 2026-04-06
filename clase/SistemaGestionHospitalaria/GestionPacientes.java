/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class GestionPacientes {
    Scanner sc=new Scanner(System.in);
    
    public void altaPaciente(Map<String, Paciente> pacientes){
        System.out.print("Introduce el dni: ");
        String dni=sc.nextLine();
        System.out.print("Introduce el nombre: ");
        String nombre=sc.nextLine();
        System.out.print("Introduce el telefono: ");
        String telefono=sc.nextLine();
        System.out.print("Introduce la fecha de Nacimiento: ");
        System.out.print("Año: ");int año=Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");int mes=Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");int dia= Integer.parseInt(sc.nextLine());
        LocalDate fechaNacimiento=LocalDate.of(año, mes, dia);
        System.out.print("Introduce el grupo sanguineo");
        String numeroSanguineo=sc.nextLine();
        System.out.print("Tiene alguna alergia?Si?o no");
        String SioNo=sc.nextLine();
        List<String>alergias=new ArrayList<>();
        if(SioNo.equalsIgnoreCase("si")){
            System.out.print("Cuantas Alergias tiene?");
            int numAlergias=Integer.parseInt(sc.nextLine());
            for (int i = 0; i < numAlergias; i++) {
                System.out.print((i+1)+"º alergia: ");
                String alergia=sc.nextLine();
                alergias.add(alergia);
            }
        }
        pacientes.put(dni, new Paciente(numeroSanguineo, alergias, dni, nombre, telefono, fechaNacimiento));
    }
    public Paciente buscarPaciente(Map<String, Paciente> pacientes){
        Paciente paciente=null;
        System.out.print("Buscarlo por dni (pon DNI) o por nombre (cualquier otra cosa): ");
        String dni_Nombre=sc.nextLine();
        if(dni_Nombre.equalsIgnoreCase("dni")){
            System.out.print("Introduce el dni: ");
            String dni=sc.nextLine();
            if(pacientes.containsKey(dni)){
                paciente=pacientes.get(dni);
            }
        }else{
            System.out.print("Introduce el nombre: ");
            String nombre=sc.nextLine();
            Set<String>clavesMapa=pacientes.keySet();
            for (String dni : clavesMapa) {
                if(pacientes.get(dni).getNombre().equalsIgnoreCase(nombre)){
                    paciente=pacientes.get(dni);
                }
            }
        }
        return paciente;
    }
    public void modificarDatos(Map<String, Paciente> pacientes){
        Paciente aux=buscarPaciente(pacientes);
        if(aux==null){
            try {
                throw new PacienteNoEncontradoException();
            } catch (PacienteNoEncontradoException ex) {
                Logger.getLogger(GestionPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }
        System.out.println("""
                          ¿Que quieres modificar?
                           1.-Nombre
                           2.-Telefono
                           3.-Grupo Sanguineo
                           """);
        int opcion=Integer.parseInt(sc.nextLine());
        switch(opcion){
            case 1 -> {
                System.out.print("Introduce el nuevo nombre: ");
                String nombre=sc.nextLine();
                aux.setNombre(nombre);
            }
            case 2 -> {
                System.out.print("Introduce el telefono nuevo: ");
                String telefono=sc.nextLine();
                aux.setTelefono(telefono);
            }
            case 3 -> {
                System.out.println("Introduce el grupo Sanguineo nuevo: ");
                String grupoSanguineo=sc.nextLine();
                aux.setGrupoSanguineo(grupoSanguineo);
            }
            default -> System.out.println("Numero Error");
        }
        pacientes.replace(aux.getDni(), aux);
    }
    public void añadirAlergias(Map<String, Paciente> pacientes){
        Paciente aux=buscarPaciente(pacientes);
        if(aux!=null){
            System.out.print("Cuantas alergias quieres añadir: ");
        int numAlergias=Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numAlergias; i++) {
            String alergia=sc.nextLine();
            aux.getAlergias().add(alergia);
        }
        pacientes.replace(aux.getDni(), aux);
        }else{
            try {
                throw new PacienteNoEncontradoException();
            } catch (PacienteNoEncontradoException ex) {
                Logger.getLogger(GestionPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void añadirHistorialClinico(Map<String, Paciente> pacientes){
        Paciente aux=buscarPaciente(pacientes);
        if(aux!=null){
            System.out.print("Introduce fecha de la consulta: ");
        System.out.print("Año: ");int año=Integer.parseInt(sc.nextLine());
        System.out.print("Mes(en numero): ");int mes=Integer.parseInt(sc.nextLine());
        System.out.print("Dia: ");int dia= Integer.parseInt(sc.nextLine());
        System.out.print("Introduce el medico Responsable: ");
        String medico=sc.nextLine();
        System.out.print("Introduce el diagnostico: ");
        String diagnostico=sc.nextLine();
        System.out.print("Introduice el tratamiento: ");
        String tratamiento=sc.nextLine();
        aux.getHistorial().add(new EntradaHistorial(LocalDate.of(año,mes, dia), medico, diagnostico, tratamiento));
        aux.setNumHistoria(String.valueOf(aux.getHistorial().size()));
        pacientes.replace(aux.getDni(), aux);
        }else{
            try {
                throw new PacienteNoEncontradoException();
            } catch (PacienteNoEncontradoException ex) {
                Logger.getLogger(GestionPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void verHistorialClinicio(Map<String, Paciente> pacientes){
        Paciente aux=buscarPaciente(pacientes);
        if(aux!=null){
            for (EntradaHistorial historial : aux.getHistorial()) {
                System.out.println(historial.toString());
            }
        }else{
            try {
                throw new PacienteNoEncontradoException();
            } catch (PacienteNoEncontradoException ex) {
                Logger.getLogger(GestionPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public void listarPacientes(Map<String, Paciente> pacientes){
        Set<String>dnis=pacientes.keySet();
        List<String>dniOrdenados=new ArrayList<>(dnis);
        Collections.sort(dniOrdenados);
        for (String dni : dniOrdenados) {
            System.out.println(pacientes.get(dni).getDescripcion());
        }
    }
}
