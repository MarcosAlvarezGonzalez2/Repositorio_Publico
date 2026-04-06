/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author marqu
 */
public class Medico extends PersonalHospital implements Serializable,Exportable{
    private String especialidad,numColegiado;
    private boolean disponible;
    private static final long serialVersionUID=1L;

    public Medico(String especialidad, String numColegiado, String numEmpleado, String departamento, double salarioBase, LocalDate fechaAlta, String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        super(numEmpleado, departamento, salarioBase, fechaAlta, dni, nombre, telefono, fechaNacimiento);
        this.especialidad = especialidad;
        this.numColegiado = numColegiado;
        this.disponible=false;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNumColegiado() {
        return numColegiado;
    }

    public void setNumColegiado(String numColegiado) {
        this.numColegiado = numColegiado;
    }

    @Override
    public double calcularSalario() {
        String []splitEspecialidades=getEspecialidad().split("[ ,;.]+");
        return getSalarioBase()+(500*splitEspecialidades.length);
    }

    @Override
    public String getDescripcion() {
       return String.format("PERSONAL MEDICO:\n %s Especialidades: %s --- Numero de colegiado: %s"
               ,super.toString(),this.especialidad, this.numColegiado);
    }

    @Override
    public String toTextoExportable() {
        return getDescripcion();
    }
    
}
