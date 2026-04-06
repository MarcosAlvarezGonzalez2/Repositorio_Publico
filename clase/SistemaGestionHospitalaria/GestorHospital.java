/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marqu
 */
public class GestorHospital implements Serializable {

    //Atributos
    private Map<String, Paciente> pacientes;//Guardar
    private List<PersonalHospital> personal;//Guardar
    private List<Cita> citas;//Guardar
    private Map<String, Departamento> departamentos;//Guardar
    private Set<String> dnisRegistrados;
    private Map<String, ArrayList<Cita>> citasPorMedico;
    //Serializable
    private static final long serialVersionUID = 1L;
    //Conectar todos las clases externas
    private static final FicherosBinarios ficheros = new FicherosBinarios();
    private static final FicherosDeTexto ficherosTexto = new FicherosDeTexto();
    private static final GestionPacientes gestorPacientes = new GestionPacientes();
    private static final GestionPersonal gestorPersonal = new GestionPersonal();
    private static final GestionCitas gestorCitas = new GestionCitas();
    private static final GestionDepartamentos gestorDepartamentos = new GestionDepartamentos();

    public GestorHospital() {
        this.pacientes = new HashMap<>();
        this.personal = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.departamentos = new TreeMap<>();
        this.dnisRegistrados = new HashSet<>();
        this.citasPorMedico = new HashMap<>();
    }

    public Map<String, Paciente> getPacientes() {
        return pacientes;
    }

    public List<PersonalHospital> getPersonal() {
        return personal;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public Map<String, Departamento> getDepartamentos() {
        return departamentos;
    }

    public Set<String> getDnisRegistrados() {
        return dnisRegistrados;
    }

    public Map<String, ArrayList<Cita>> getCitasPorMedico() {
        return citasPorMedico;
    }

    public void setPacientes(Map<String, Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void setPersonal(List<PersonalHospital> personal) {
        this.personal = personal;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public void setDepartamentos(Map<String, Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    /**
     * Los dos metodos de aqui abajo los de guardar y cargar, se haran
     * automaticos nada mas iniciar el main.
     */
    public void guardarDatos() {
        ficheros.guardarPacientes(pacientes);
        ficheros.guardarPersonal(personal);
        ficheros.guardarCitas(citas);
        ficheros.guardarDepartamentos(departamentos);
    }

    public void cargarDatos() {
        setPacientes(ficheros.cargarPacientes());
        setPersonal(ficheros.cargarPersonal());
        setCitas(ficheros.cargarCitas());
        setDepartamentos(ficheros.cargarDepartamentos());
    }

    /**
     * Ahora ir llendo poco a poco haciendo la gestion del menu.
     *
     * @param opcionSubMenus
     * @throws SistemaGestionHospitalaria.PacienteNoEncontradoException
     */
    public void gestionPacientes(int opcionSubMenus) throws PacienteNoEncontradoException {
        switch (opcionSubMenus) {
            case 1 ->
                gestorPacientes.altaPaciente(pacientes);
            case 2 -> {
                Paciente aux = gestorPacientes.buscarPaciente(pacientes);
                if (aux != null) {
                    System.out.println(aux.toString());
                } else {
                    throw new PacienteNoEncontradoException();
                }
            }
            case 3 ->
                gestorPacientes.modificarDatos(pacientes);
            case 4 ->
                gestorPacientes.añadirAlergias(pacientes);
            case 5 ->
                gestorPacientes.añadirHistorialClinico(pacientes);
            case 6 ->
                gestorPacientes.verHistorialClinicio(pacientes);
            case 7 ->
                gestorPacientes.listarPacientes(pacientes);
            default ->
                System.out.println("Numero Error");
        }
    }

    public void gestionPersonal(int opcionSubMenus) throws EmpleadoNoExistente {
        switch (opcionSubMenus) {
            case 1 ->
                gestorPersonal.darAltaPersonal(personal);
            case 2 -> {
                PersonalHospital aux = gestorPersonal.buscarEmpleado(personal);
                if (aux != null) {
                    System.out.println(aux.toString());
                } else {
                    throw new EmpleadoNoExistente();
                }
            }
            case 3 ->
                gestorPersonal.calcularSalarioEmpleado(personal);
            case 4 ->
                gestorPersonal.listarPersonalPorTipo(personal);
            case 5 ->
                gestorPersonal.listarPersonalDeUnDepartamento(departamentos);
            default ->
                System.out.println("Numero Error");

        }
    }

    public void gestionCitas(int opcionSubMenus) {
        switch (opcionSubMenus) {
            case 1 ->
                gestorCitas.crearCita(personal, pacientes, citas);
            case 2 ->
                gestorCitas.cancelarCita(citas);
            case 3 ->
                gestorCitas.completarCita(citas);
            case 4 ->
                gestorCitas.listarCitasDia(citas);
            case 5 ->
                gestorCitas.listarCitasMedico(citas, personal);
            case 6 ->
                gestorCitas.listarCitaPaciente(citas, pacientes);

        }
    }

    public void gestionDepartamentos(int opcionSubMenus) {
        switch (opcionSubMenus) {
            case 1 ->
                gestorDepartamentos.crearDepartamento(departamentos);
            case 2 ->
                gestorDepartamentos.asignarPersonal(departamentos, personal);
            case 3 ->
                gestorDepartamentos.desifnarJefe(departamentos);
            case 4 ->
                gestorDepartamentos.verResumen(departamentos);
            default ->
                System.out.println("NUMERO ERROR");
        }
    }

    public void exportarInformes(LocalDate dia, String dni) {
        ficherosTexto.informePacientes(pacientes);
        ficherosTexto.informeCitas(citas, dia);
        ficherosTexto.informeHistorialClinico(pacientes, dni);
        ficherosTexto.infromeDepartamentos(departamentos);
    }
}
