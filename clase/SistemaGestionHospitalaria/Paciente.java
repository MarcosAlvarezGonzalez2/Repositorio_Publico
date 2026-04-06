/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marqu
 */
public class Paciente extends Persona implements Serializable,Exportable,Comparable<Paciente>{
    private String numHistoria,grupoSanguineo;
    private List<String>alergias;
    private List<EntradaHistorial>historial;
    private static final long serialVersionUID=1L;

    public Paciente( String grupoSanguineo, List<String> alergias,String dni, String nombre, String telefono, LocalDate fechaNacimiento) {
        super(dni, nombre, telefono, fechaNacimiento);
        this.historial = new ArrayList<>();
        this.numHistoria = String.valueOf(historial.size());
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = alergias;
    }

    public String getNumHistoria() {
        return numHistoria;
    }

    public void setNumHistoria(String numHistoria) {
        this.numHistoria = numHistoria;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }

    public List<EntradaHistorial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<EntradaHistorial> historial) {
        this.historial = historial;
    }

    @Override
    public String getDescripcion() {
        return String.format("PACIENTE:\n %s Numero de historias: %s --- Grupo sanguineo: %s \nLista de alergias: %s\n Lista de hitorial:%s"
                ,super.toString(),this.numHistoria,this.grupoSanguineo,this.alergias.toString(),this.historial.toString());
    }

    @Override
    public String toTextoExportable() {
        return getDescripcion();
    }

    @Override
    public int compareTo(Paciente o) {
        return this.getNombre().compareTo(o.getNombre());
    }
    
}
