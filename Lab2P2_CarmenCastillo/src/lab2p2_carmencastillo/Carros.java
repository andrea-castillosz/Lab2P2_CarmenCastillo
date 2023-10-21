/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_carmencastillo;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author casti
 */

public class Carros {
    String marca;
    String modelo;
    Color color;
    double precio;
    ArrayList <String> mejoras = new ArrayList();
    boolean marcador;
    
    public Carros(){
        
    }
    
    public Carros(String marcaN, String modeloN, Color colorN, double precioN, boolean marcadorN){
        this.modelo = modeloN;
        this.marca = marcaN;
        this.color = colorN;
        this.precio = precioN;
        this.marcador = marcadorN;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getMejoras() {
        return mejoras;
    }

    public void setMejoras(ArrayList<String> mejoras) {
        this.mejoras = mejoras;
    }

    public boolean getMarcador() {
        return marcador;
    }

    public void setMarcador(boolean marcador) {
        this.marcador = marcador;
    }

    @Override
    public String toString() {
        String cad = "";
        cad += "Carros{" + "marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio=" + precio + ", marcador=" + marcador + '}';
        for (String m : mejoras) {
            cad+=m.toString()+"\n";
        }
        
        return cad;
    }
    
    
    
    
}
