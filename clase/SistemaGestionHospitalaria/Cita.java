/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author marqu
 */
public class Cita implements Serializable,Identificable,Exportable,Comparable<Cita>{
private static final long serialVersionUID=1L;
    private String idCita,motivo,estado;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime fecha;
    private static int contadorCita;

    public Cita(String motivo, String estado, Paciente paciente, Medico medico, LocalDateTime fecha) {
        this.idCita = String.valueOf(contadorCita);
        this.motivo = motivo;
        this.estado = estado;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        contadorCita++;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public static int getContadorCita() {
        return contadorCita;
    }

    public static void setContadorCita(int contadorCita) {
        Cita.contadorCita = contadorCita;
    }

    @Override
    public String toString() {
        return "CITA MEDICA:\nId cita: "+this.idCita+" --- Nombre del Paciente: "+this.paciente.getNombre()+" --- Medico: "+this.medico.getNombre()
                +" --- Fecha: "+this.fecha.toString()+" --- Motivo: "+this.motivo+" --- Estado: "+this.estado.toUpperCase();
    }

    @Override
    public String getId() {
           return getIdCita();
    }

    @Override
    public String toTextoExportable() {
        return toString();
    }

    @Override
    public int compareTo(Cita o) {
        return this.getFecha().compareTo(o.getFecha());
    }
    
}
