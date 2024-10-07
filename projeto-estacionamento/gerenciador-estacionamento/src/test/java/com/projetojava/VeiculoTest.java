package com.projetojava;

import org.junit.Test;
import static org.junit.Assert.*;

public class VeiculoTest {

    @Test
    public void testCriarVeiculo() {
        Veiculo veiculo = new Veiculo("XYZ1234", "SUV", 10, 15);
        assertEquals("XYZ1234", veiculo.getPlaca());
        assertEquals("SUV", veiculo.getModelo());
        assertEquals(10, veiculo.getHoraEntrada());
        assertEquals(15, veiculo.getMinutoEntrada());
    }

    @Test
    public void testeSetModelo() {
        Veiculo veiculo = new Veiculo(null, null, 0, 0);
        veiculo.setModelo("CELTA");
        assertEquals("CELTA", veiculo.getModelo());
        
    }

    

}