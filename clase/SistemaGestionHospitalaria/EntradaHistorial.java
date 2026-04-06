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
public class EntradaHistorial implements Serializable{
    private static final long serialVersionUID=1L;
    private LocalDate fecha;
    private String medicoResponsable,diagnostico,tratamiento;

    public EntradaHistorial(LocalDate fecha, String medicoResponsable, String diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.medicoResponsable = medicoResponsable;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(String medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Entrada Historial:\nFecha: "+this.fecha+"\nMedico Responsable"+this.medicoResponsable
                +"\nDiagnostico: "+this.diagnostico+"\nTratamiento: "+this.tratamiento;
    }
    
}
