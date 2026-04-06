/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marqu
 */
public class Departamento implements Serializable,Identificable,Comparable<Departamento>{
    private static final long serialVersionUID=1L;
    private String nombre;
    private Medico jefeDepartamento;
    private List<PersonalHospital>personal;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.jefeDepartamento = null;
        this.personal = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Medico getJefeDepartamento() {
        return jefeDepartamento;
    }

    public void setJefeDepartamento(Medico jefeDepartamento) {
        this.jefeDepartamento = jefeDepartamento;
    }

    public List<PersonalHospital> getPersonal() {
        return personal;
    }

    public void setPersonal(List<PersonalHospital> personal) {
        this.personal = personal;
    }

    @Override
    public String getId() {
        return getNombre();
    }

    @Override
    public int compareTo(Departamento o) {
        return this.getNombre().compareTo(o.getNombre());
    }
    
    
}
