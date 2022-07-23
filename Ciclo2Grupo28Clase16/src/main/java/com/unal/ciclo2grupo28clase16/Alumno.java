
package com.unal.ciclo2grupo28clase16;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Alumno {
    
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Integer edad;
    private String grupoSangineo;
    private Character RH;
    private String estadoCivil;
    
    public Alumno() {

    }

    public Alumno(String nombre, String apellido, Date fechaNacimiento, Integer edad, String grupoSangineo, Character RH, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.grupoSangineo = grupoSangineo;
        this.RH = RH;
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGrupoSangineo() {
        return grupoSangineo;
    }

    public void setGrupoSangineo(String grupoSangineo) {
        this.grupoSangineo = grupoSangineo;
    }

    public Character getRH() {
        return RH;
    }

    public void setRH(Character RH) {
        this.RH = RH;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
}
