package br.com.udemy.springboot;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class PrimeiroTest {

    Calculadora calculadora;
    int numero1 = 10, numero2 = 8;

    @Before
    //TODO - @Before: é uma anotation para usar para criar um setUp para executar antes dos testes
    public void setUp(){
        calculadora = new Calculadora();
    }
    @Test
    //TODO - @Test: é uma anotation para criar os testes do JUnit
    public void deveSomar2NumerosTest(){
        // execução
        int resultado = numero1 + numero2;

        // verificações
        //Assert.assertEquals(15, resultado);

        //TODO - Assertj
        Assertions.assertThat(resultado).isBetween(15,20);
        Assertions.assertThat(resultado).isGreaterThan(10);
        Assertions.assertThat(resultado).isEqualTo(18);
    }

    @Test(expected = RuntimeException.class)
    //TODO - expected: é um parametro o qual você espera dar um erro do tipo do seu método.
    public void naoDeveSomarNumerosNegativos(){
        //Execução
        calculadora.somar(-100,-200);
    }

    @Test
    public void deveSubtrair2Numeros(){
        //Execução
        int resultado = calculadora.subtrair(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        //Execução
        int resultado = calculadora.multiplicar(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isEqualTo(80);
    }

    @Test
    public void deveDividir2Numeros(){
        //Execução
        float resultado = calculadora.divisao(numero1, numero2);

        //Verificação
        Assertions.assertThat(resultado).isEqualTo(1.0f);
    }

    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero(){
        //Cénario
        int numero1 = 10, numero2 = 0;

        //Execução
        calculadora.divisao(numero1, numero2);
    }
}

class Calculadora{
    int somar(int num1, int num2){
        if (num1 < 0 || num2 <0){
            throw new RuntimeException("Não é permitido somar números negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2){
        if (num1 < 0 || num2 <0){
            throw new RuntimeException("Não é permitido somar números negativos");
        }
        return num1 - num2;
    }

    int multiplicar(int num1, int num2){
        return num1 * num2;
    }

    float divisao(int num1, int num2){
        return num1 / num2;
    }
}
