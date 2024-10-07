package com.projetojava;

public class Veiculo {

    private String placa;
    private String modelo;
    private int horaEntrada;
    private int minutoEntrada;

  
    public Veiculo(String placa, String modelo, int horaEntrada, int minutoEntrada) {
        this.placa = placa;
        this.modelo = modelo;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public int getHoraEntrada() {
        return horaEntrada;
    }


    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }


    public int getMinutoEntrada() {
        return minutoEntrada;
    }


    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }

    

    
    
}
