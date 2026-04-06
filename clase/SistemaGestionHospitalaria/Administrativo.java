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
public class Administrativo extends PersonalHospital implements Serializable {

    private static final long serialVersionUID = 1L;
    private String puesto;

    public Administrativo(String puesto, String numEmpleado, String departamento, double salarioBase, LocalDate fechaAlta, String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        super(numEmpleado, departamento, salarioBase, fechaAlta, dni, nombre, telefono, fechaNacimiento);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }

    @Override
    public String getDescripcion() {
        return String.format("PERSONAL Administrativo:\n %s Puesto: %s ", super.toString(), this.puesto);
    }

}
