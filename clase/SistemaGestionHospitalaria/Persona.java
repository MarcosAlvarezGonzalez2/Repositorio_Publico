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
public abstract class Persona implements Serializable, Identificable{
    private String dni,nombre,telefono;
    private LocalDate fechaNacimiento;
    private static final long serialVersionUID=1L;

    public Persona(String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Nombre: "+this.nombre+" --- Dni: "+this.dni+" --- Telefono: "+this.telefono+" --- Fecha Nacimiento: "+this.fechaNacimiento.toString()+"\n";
    }

    @Override
    public String getId() {
        return getDni();
    }

   
    public abstract String getDescripcion();
}
