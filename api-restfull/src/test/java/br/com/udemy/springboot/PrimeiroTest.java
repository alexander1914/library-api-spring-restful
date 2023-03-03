package br.com.udemy.springboot;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroTest {
    @Test
    //@Test: é uma anotation para criar os testes do JUnit
    public void estruturaDeUmTeste(){
        // cenário
        int numero1 = 10, numero2 = 5;

        // execução
        int resultado = numero1 + numero2;

        // verificações
        //Assert.assertEquals(15, resultado);

        //Assertj
        Assertions.assertThat(resultado).isBetween(14,16);
        Assertions.assertThat(resultado).isGreaterThan(10);
    }
}
