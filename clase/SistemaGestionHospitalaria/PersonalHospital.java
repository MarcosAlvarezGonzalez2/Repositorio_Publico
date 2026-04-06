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
public abstract class PersonalHospital extends Persona implements Serializable{
    private String numEmpleado, departamento;
    private double salarioBase;
    private LocalDate fechaAlta;
    private static final long serialVersionUID=1L;


    public PersonalHospital(String numEmpleado, String departamento, double salarioBase, LocalDate fechaAlta, String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        super(dni, nombre, telefono, fechaNacimiento);
        this.numEmpleado = numEmpleado;
        this.departamento = departamento;
        this.salarioBase = salarioBase;
        this.fechaAlta = fechaAlta;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return super.toString()+"Numero de empleado: "+this.numEmpleado+" --- Departamento: "
                +this.departamento+" --- Fecha de alta: "+this.fechaAlta.toString()+" --- Salario Base: "+this.salarioBase+"\n";
    }

   
    public abstract double calcularSalario();
}
