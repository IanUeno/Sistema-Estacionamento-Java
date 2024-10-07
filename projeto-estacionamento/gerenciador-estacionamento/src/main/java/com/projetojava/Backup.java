package com.projetojava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Backup {

    private static final String ARQUIVO_VEICULOS = "veiculos.csv";

 
    public void salvarVeiculos(List<Veiculo> veiculos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_VEICULOS))) {
            for (Veiculo veiculo : veiculos) {
                String linha = veiculo.getPlaca() + "," + veiculo.getModelo() + ","
                        + veiculo.getHoraEntrada() + "," + veiculo.getMinutoEntrada();
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("******* ERROR AO SALVAR VEÍCULOS *******: " + e.getMessage());
        }
    }


    public List<Veiculo> carregarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_VEICULOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String placa = dados[0];
                String modelo = dados[1];
                int horaEntrada = Integer.parseInt(dados[2]);
                int minutoEntrada = Integer.parseInt(dados[3]);
                Veiculo veiculo = new Veiculo(modelo, placa, horaEntrada, minutoEntrada);
                veiculos.add(veiculo);
            }
        } catch (IOException e) {
            System.err.println("******* ERROR AO CARREGAR VEÍCULOS *******: " + e.getMessage());
        }

        return veiculos;
    }
}
