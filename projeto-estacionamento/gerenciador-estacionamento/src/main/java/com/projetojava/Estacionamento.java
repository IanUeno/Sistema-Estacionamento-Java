package com.projetojava;

import java.util.ArrayList;
import java.util.Iterator;


public class Estacionamento {

    private String nomeEstacionamento;
    private int capacidadeMaxima = 50;


    ArrayList<Veiculo> myList;
    private Backup persistencia;

    public Estacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
        this.myList = new ArrayList<>();
        this.persistencia = new Backup();

        // Carregar veículos do arquivo ao iniciar
        this.myList = (ArrayList<Veiculo>) persistencia.carregarVeiculos();
    }
    public void add(Veiculo veiculo){
        myList.add(veiculo);
    }

 // CADASTRAR VEICULO ------------------------------------------------------------------------------------------
    public boolean cadastrarVeiculo(String placa, String modelo, int horaEntrada, int minutoEntrada) {
        if (myList.size() < capacidadeMaxima) {
            Veiculo novoVeiculo = new Veiculo(placa, modelo, horaEntrada, minutoEntrada);
            myList.add(novoVeiculo);
            System.out.println("--------------------------------");
            System.out.println("VEÍCULO CADASTRADO COM SUCESSO!");
            System.out.println("--------------------------------");
            return true;
        } else {
            System.out.println("-------------------------------------------------");
            System.out.println("ESTACIONAMENTO LOTADO! NÃO FOI POSSIVEL CADASTRAR");
            System.out.println("-------------------------------------------------");
            return false;
        }
    }
 // LISTAR VEICULOS ------------------------------------------------------------------------------------------
    public void listarVeiculos() {
        if (myList.isEmpty()) {
            System.out.println("-----------------------------------------");
            System.out.println(  "NENHUM VEÍCULO ESTACIONADO NO MOMENTO.");
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("========== LISTA DE VEÍCULOS ESTACIONADOS ==========");
            System.out.println("\n");
            System.out.println("[ "+myList.size()+" ] Veículo(s) estacionado(s) no momento!");
            System.out.println("-----------------------------------------");
            for (Veiculo v : myList) {
                System.out.println("Placa: " + v.getPlaca() + ", Modelo: " + v.getModelo());
                System.out.println("Entrada: " + v.getHoraEntrada() + ":" + v.getMinutoEntrada() + "h");
                System.out.println("-----------------------------------------");
            }
        }
    }

    // REMOVER VEICULO ------------------------------------------------------------------------------------------
    public boolean removerVeiculo(String placa, int horaSaida, int minutoSaida) {
        Iterator<Veiculo> iterator = myList.iterator();

        while (iterator.hasNext()) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getPlaca().equals(placa)) {
                // CALCULO
                System.out.println("CALCULANDO VALOR DA TARIFA , VEÍCULO: " + placa);
                calcularTarifa(veiculo.getHoraEntrada(), veiculo.getMinutoEntrada(), horaSaida, minutoSaida);

                // REMOVER
                iterator.remove();
                System.out.println("\n-----------------------------------------");
                System.out.println("   O VEÍCULO FOI REMOVIDO COM SUCESSO!   ");
                System.out.println("-----------------------------------------");
                return true;
            }
           
        }

        System.out.println("\n-----------------  [ AVISO ] -----------------");
        System.out.println("   VEÍCULO " + placa + " NÃO FOI ENCONTRADO !");
        System.out.println("----------------------------------------------");
        return false;
    }

 // FUNCAO CALCULO ------------------------------------------------------------------------------------------
    public static double calcularTarifa(int horaEntrada, int minutoEntrada, int horaSaida, int minutoSaida) {
        double tarifaPorHora = 5.0;
      
        int totalMinutosEntrada = (horaEntrada * 60) + minutoEntrada;
        int totalMinutosSaida = (horaSaida * 60) + minutoSaida;

        int minutosEstacionados = totalMinutosSaida - totalMinutosEntrada;

        int horasEstacionadas = minutosEstacionados / 60;
        int minutosRestantes = minutosEstacionados % 60;

        if (minutosRestantes > 0) {
            horasEstacionadas++;
        }
        double valorTotal = horasEstacionadas * tarifaPorHora;
        
        System.out.println("---------------------------------------------");
        System.out.println("Tempo estacionado: " + horasEstacionadas + " h");
        System.out.println("Valor a pagar: R$ " + valorTotal);
        System.out.println("---------------------------------------------");
        return horasEstacionadas * tarifaPorHora;
        
    }

    public String getNomeEstacionamento() {
        return nomeEstacionamento;
    }

    public void setNomeEstacionamento(String nomeEstacionamento) {
        this.nomeEstacionamento = nomeEstacionamento;
    }

    public void salvarVeiculos() {
        persistencia.salvarVeiculos(myList);
    }
}