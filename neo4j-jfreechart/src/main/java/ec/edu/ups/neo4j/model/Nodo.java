/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.neo4j.model;

/**
 *
 * @author jmurillo
 */
public class Nodo {
 
    private int codigo;
    private String nombre;
    private double similitud;

    public Nodo() {
    }

    public Nodo(String nombre, double similitud) {
        this.nombre = nombre;
        this.similitud = similitud;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSimilitud() {
        return similitud;
    }

    public void setSimilitud(double similitud) {
        this.similitud = similitud;
    }

    @Override
    public String toString() {
        return "NodoSimilar{" + "nombre=" + nombre + ", similitud=" + similitud + '}';
    }
}
