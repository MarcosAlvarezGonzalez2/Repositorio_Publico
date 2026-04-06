/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class FicherosDeTexto {

    public void informePacientes(Map<String, Paciente> pacientes) {
        try {
            Set<String> dni = pacientes.keySet();
            List<Paciente> pacientesOrdenados = new ArrayList<>();
            for (String s : dni) {
                pacientesOrdenados.add(pacientes.get(s));
            }
            Collections.sort(pacientesOrdenados);
            File ficheroPaciente = new File("informe_paciente.txt");
            try (Formatter f = new Formatter(ficheroPaciente)) {
                for (Paciente paciente : pacientesOrdenados) {
                    f.format("%s",paciente.toTextoExportable());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        }
    }
    public void informeCitas(List<Cita>citas,LocalDate fecha){
        try {
            String nombreFichero="Cita_["+fecha.toString()+"].txt";
            int contadorMetidos=0;
            try (Formatter f = new Formatter(new File(nombreFichero))) {
                for (Cita cita : citas) {
                    if(cita.getFecha().toLocalDate().equals(fecha)){
                        f.format("%s", cita.toTextoExportable());
                        contadorMetidos++;
                    }
                }
            }
            if(contadorMetidos!=0){
                System.out.println("Se han introducido "+contadorMetidos+" citas");
            }else{
                System.out.println("No se a introducido ninguna cita.");
            }} catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosDeTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void informeHistorialClinico(Map<String,Paciente>pacientes,String dni){
       if(pacientes.containsKey(dni)){
           try {
               Paciente pacienteAux=pacientes.get(dni);
               String nombreArchivo="historial_["+dni+"].txt";
               Formatter f=new Formatter(new File(nombreArchivo));
               f.format("Nombre del paciente:%s y DNI del paciente: %s\nHISTORIAL COMPLETO: %s"
                       , pacienteAux.getNombre(),pacienteAux.getDni(),pacienteAux.getHistorial().toString());
           } catch (FileNotFoundException ex) {
               Logger.getLogger(FicherosDeTexto.class.getName()).log(Level.SEVERE, null, ex);
           }
       } else{
           try {
               throw new PacienteNoEncontradoException();
           } catch (PacienteNoEncontradoException ex) {
               System.out.println(ex.getMessage());
           }
       }
    }
    public void infromeDepartamentos(Map<String,Departamento>departamentos){
        try {
            Set<String>nombreDepartamentos=departamentos.keySet();
            Formatter f =new Formatter(new File("indorme_departamentos.txt"));
            for (String nombre : nombreDepartamentos) {
                double salarioTotal=0;
                for (PersonalHospital persona : departamentos.get(nombre).getPersonal()) {
                    salarioTotal+=persona.calcularSalario();
                }
                String nombreJefe = (departamentos.get(nombre).getJefeDepartamento() != null) ? 
                    departamentos.get(nombre).getJefeDepartamento().getNombre() : "SIN ASIGNAR";
                f.format("NOMBRE DEL DEPARTAMENTO: %s\nJefe del departamento: %s\nNumero de Empleados: %d\nCoste Salarios:%.2f"
                        ,nombre,nombreJefe,departamentos.get(nombre).getPersonal().size(),salarioTotal);
                f.format("===================================");
            }
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FicherosDeTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
