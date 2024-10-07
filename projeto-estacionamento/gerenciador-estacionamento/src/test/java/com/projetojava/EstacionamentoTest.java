package com.projetojava;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class EstacionamentoTest {

    private Estacionamento estacionamento;

    @Before
    public void setUp() {
        estacionamento = new Estacionamento("VAGALUGUE");
    }

    @Test
    public void testCadastrarVeiculo() {
        boolean resultado = estacionamento.cadastrarVeiculo("ASD123", "FUSCA", 10, 30);
        assertTrue(resultado);  
        assertEquals(1, estacionamento.myList.size());  
    }

    @Test
    public void testCadastrarVeiculoLimiteExcedido() {

        for (int i = 0; i < 50; i++) {
            estacionamento.cadastrarVeiculo("PLACA" + i, "Modelo" + i, 10, 30);
        }
      
        boolean resultado = estacionamento.cadastrarVeiculo("ERT1234", "CELTA", 11, 45);
        assertFalse(resultado); 
    }

    @Test
    public void testRemoverVeiculo() {
        estacionamento.cadastrarVeiculo("ASD123", "HYUDAI", 9, 15);
        boolean resultado = estacionamento.removerVeiculo("ASD123", 11, 45);
        assertTrue(resultado);
        assertEquals(0, estacionamento.myList.size());  
    }

    public void testCalcularTarifa() {
        double tarifa = Estacionamento.calcularTarifa(10, 0, 11, 0);
        Assertions.assertEquals(5.0, tarifa, 0.01);
    }
}