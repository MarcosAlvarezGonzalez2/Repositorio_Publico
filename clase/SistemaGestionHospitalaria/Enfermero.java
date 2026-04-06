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
public class Enfermero extends PersonalHospital implements Serializable {

    private static final long serialVersionUID = 1L;
    private int planta;
    private String turno;

    public Enfermero(int planta, String turno, String numEmpleado, String departamento, double salarioBase, LocalDate fechaAlta, String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        super(numEmpleado, departamento, salarioBase, fechaAlta, dni, nombre, telefono, fechaNacimiento);
        this.planta = planta;
        this.turno = turno;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (this.turno.equalsIgnoreCase("Noche") ? 200 : 0);
    }

    @Override
    public String getDescripcion() {
        return String.format("PERSONAL Enfermero:\n %s Planta: %d --- Turno de trabajo: %s", super.toString(), this.planta, this.turno);
    }

}
