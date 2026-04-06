/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaGestionHospitalaria;

import java.util.*;

/**
 *
 * @author marqu
 */
public class GestionDepartamentos {
        Scanner sc = new Scanner(System.in);
        private static final GestionPersonal gestorPersonal=new GestionPersonal();
public void crearDepartamento(Map<String, Departamento> departamentos){
    System.out.print("Introduce el nombre del departamento: ");
    String nombre=sc.nextLine();
    departamentos.put(nombre, new Departamento(nombre));
}
public void asignarPersonal(Map<String, Departamento> departamentos, List<PersonalHospital> personal){
    System.out.print("Introduce el nombre del departamento: ");
    String nombre=sc.nextLine();
    if(departamentos.containsKey(nombre)){
        System.out.print("Introduce el numero del personal que vas a introducir: ");
    int numeroIntroducir;
    try {
        numeroIntroducir=Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("No es un numero");
        return;
    }
    for (int i = 0; i < numeroIntroducir; i++) {
        PersonalHospital aux=gestorPersonal.buscarEmpleado(personal);
        if(aux!=null){
            departamentos.get(nombre).getPersonal().add(aux);
        }else{
            System.out.println("Mal introducido");
            i--;
        }
    }
    }else{
        System.out.println("No existe el departamento");
    }
    
}
public void desifnarJefe(Map<String, Departamento> departamentos){
    System.out.print("Introduce el nombre del departamento: ");
    String nombre=sc.nextLine();
    if(departamentos.containsKey(nombre)){
        if(!departamentos.get(nombre).getPersonal().isEmpty()){
            System.out.println("Lista de los empleados del departamento");
            for (PersonalHospital persona : departamentos.get(nombre).getPersonal()) {
                if(persona instanceof Medico){
                    System.out.println("Nombre: "+persona.getNombre()+" DNI: "+persona.getDni()+" - es medico");
                }
            }
            System.out.println("Introduce el dni del medico que quieres que sea el jefe");
            String dni=sc.nextLine();
            Medico jefe=null;
            for (PersonalHospital persona : departamentos.get(nombre).getPersonal()) {
                if(persona.getDni().equalsIgnoreCase(dni)){
                    if(persona instanceof Medico m){
                    jefe=m;
                    break;
                    }else{
                        System.out.println("No es medico error");
                        break;
                    }
                    
                }
            }
            if(jefe!=null){
                departamentos.get(nombre).setJefeDepartamento(jefe);
            }else{
                System.out.println("No se ha introducido ninguno.");
            }
        }else{
            System.out.println("Esta vacio el departamento");
        }
    }else{
        System.out.println("No existe el departamento");
    }
}

public void verResumen(Map<String, Departamento> departamentos){
    System.out.print("Introduce el nombre del departamento: ");
    String nombre=sc.nextLine();
    if(departamentos.containsKey(nombre)){
        System.out.println("NOMBRE DEL DEPARTAMENTO: "+nombre);
        System.out.println("JEFE DEL DEPARTAMENTO: "+departamentos.get(nombre).getJefeDepartamento()!=null?departamentos.get(nombre).getJefeDepartamento():"No tiene");
        System.out.println("EMPLEADOS DEL DEPARTAMENTO: ");
        double costeSalarial=0;
        for (PersonalHospital persona : departamentos.get(nombre).getPersonal()) {
            System.out.println(persona.getDescripcion());
            costeSalarial+=persona.calcularSalario();
        }
        System.out.println("TOTAL DE SALARIO: "+costeSalarial);
    }else{
        System.out.println("No exioste el departamento");
    }
}
}
