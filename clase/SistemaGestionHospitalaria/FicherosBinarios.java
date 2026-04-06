/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class FicherosBinarios {

    public void guardarPacientes(Map<String, Paciente> pacientes) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("hospital_pacientes.dat")))) {
            output.writeObject(pacientes);
            System.out.println("Pacientes guardados");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarPersonal(List<PersonalHospital> personal) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("hospital_personal.dat")))) {
            output.writeObject(personal);
            System.out.println("Personal guardados");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarCitas(List<Cita> citas) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("hospital_citas.dat")))) {
            output.writeObject(citas);
            System.out.println("Citas guardadas");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarDepartamentos(Map<String, Departamento> departamentos) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("hospital_departamentos.dat")))) {
            output.writeObject(departamentos);
            System.out.println("Departamentos guardados");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<String, Paciente> cargarPacientes() {
        File archivo = new File("hospital_pacientes.dat");

        if (!archivo.exists()) {
            return new HashMap<>();
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Map<String, Paciente>) input.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error al cargar los pacientes: " + ex.getMessage());
            return new HashMap<>();
        }
    }

    public List<PersonalHospital> cargarPersonal() {
        List<PersonalHospital> personal = new ArrayList<>();
        File archivo = new File("hospital_personal.dat");
        if (!archivo.exists()) {
            return personal;
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo))) {
            personal = (List<PersonalHospital>) input.readObject();
            System.out.println("Personal cargado");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personal;
    }

    public List<Cita> cargarCitas() {
        List<Cita> citas = new ArrayList<>();
        File archivo = new File("hospital_citas.dat");
        if (!archivo.exists()) {
            return citas;
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo))) {
            citas = (List<Cita>) input.readObject();
            Cita.setContadorCita(citas.size());
            System.out.println("Citas cargadas");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        return citas;
    }

    public Map<String, Departamento> cargarDepartamentos() {
        Map<String, Departamento> departamentos = new HashMap<>();
                File archivo = new File("hospital_departamentos.dat");
        if (!archivo.exists()) {
            return departamentos;
        }
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo))) {
            departamentos = (Map<String, Departamento>) input.readObject();
            System.out.println("Departamentos cargados");
        } catch (IOException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FicherosBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamentos;
    }
}
