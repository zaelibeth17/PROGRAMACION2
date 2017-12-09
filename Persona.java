/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Persona {
    private String cedula;
    private String nombre;
    private int edad;
    private float sueldo;
    private boolean isCasado;    

    public Persona(String cedula, String nombre, int edad, float sueldo, boolean isCasado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.isCasado = isCasado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public void setIsCasado(boolean isCasado) {
        this.isCasado = isCasado;
    }
    
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public boolean isIsCasado() {
        return isCasado;
    }
    
    public ArrayList toArrayList() {
        ArrayList al = new ArrayList();
        al.add(cedula);
        al.add(nombre);
        al.add(edad);
        al.add(sueldo);
        al.add(isCasado);
        return al;
    }
}
