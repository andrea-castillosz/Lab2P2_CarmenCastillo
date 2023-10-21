/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_carmencastillo;

import java.util.ArrayList;

/**
 *
 * @author casti
 */

public class Jugadores {
    String nombre;
    ArrayList <Carros> listaCarros = new ArrayList();
    double cuantBanco;
    int puntosR;
    
    public Jugadores() {
        
        
    }
    
    public Jugadores(String nombre, double cuantBanco, int puntosR) {
        this.nombre = nombre;
        this.cuantBanco = cuantBanco;
        this.puntosR = puntosR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Carros> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(ArrayList<Carros> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public double getCuantBanco() {
        return cuantBanco;
    }

    public void setCuantBanco(double cuantBanco) {
        this.cuantBanco = cuantBanco;
    }

    public int getPuntosR() {
        return puntosR;
    }

    public void setPuntosR(int puntosR) {
        this.puntosR = puntosR;
    }

    @Override
    public String toString() {
        String cad = "";
        cad += "Jugadores{" + "Nombre: " + nombre  + ", cuantBanco=" + cuantBanco + ", puntosR=" + puntosR + '}';
        for (Carros l : listaCarros) {
            cad+=l.toString()+"\n";
        }
        return cad;
    }
    
    
    
    
}
