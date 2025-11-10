package br.com.exemplo.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calc;

    @BeforeEach
    void setUp() {
        calc = new Calculadora();
    }

    // ---------- SOMAR ----------

    @Test
    @DisplayName("Deve somar dois números positivos e retornar a soma correta")
    void somar_numerosPositivos_retornaSomaCorreta() {
        // ARRANGE
        int a = 2;
        int b = 3;
        int esperado = 5;

        // ACT
        int resultado = calc.somar(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A soma de dois números positivos deve ser correta");
    }

    @Test
    @DisplayName("Deve somar dois números negativos e retornar a soma correta")
    void somar_numerosNegativos_retornaSomaCorreta() {
        // ARRANGE
        int a = -2;
        int b = -3;
        int esperado = -5;

        // ACT
        int resultado = calc.somar(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A soma de dois números negativos deve ser correta");
    }

    @Test
    @DisplayName("Deve somar um número com zero e retornar o mesmo número")
    void somar_comZero_retornaMesmoNumero() {
        // ARRANGE
        int a = 7;
        int b = 0;
        int esperado = 7;

        // ACT
        int resultado = calc.somar(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "Somar com zero deve retornar o mesmo número");
    }

    // ---------- SUBTRAIR ----------

    @Test
    @DisplayName("Deve subtrair dois números e retornar resultado positivo")
    void subtrair_resultadoPositivo_retornaCorreto() {
        // ARRANGE
        int a = 5;
        int b = 3;
        int esperado = 2;

        // ACT
        int resultado = calc.subtrair(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A subtração deve retornar o resultado positivo correto");
    }

    @Test
    @DisplayName("Deve subtrair dois números e retornar resultado negativo")
    void subtrair_resultadoNegativo_retornaCorreto() {
        // ARRANGE
        int a = 2;
        int b = 3;
        int esperado = -1;

        // ACT
        int resultado = calc.subtrair(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A subtração deve retornar o resultado negativo correto");
    }

    @Test
    @DisplayName("Deve subtrair zero e retornar o mesmo número")
    void subtrair_zero_retornaMesmoNumero() {
        // ARRANGE
        int a = 4;
        int b = 0;
        int esperado = 4;

        // ACT
        int resultado = calc.subtrair(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "Subtrair zero deve retornar o mesmo número");
    }

    // ---------- MULTIPLICAR ----------

    @Test
    @DisplayName("Deve multiplicar dois números positivos e retornar resultado correto")
    void multiplicar_numerosPositivos_retornaCorreto() {
        // ARRANGE
        int a = 3;
        int b = 5;
        int esperado = 15;

        // ACT
        int resultado = calc.multiplicar(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A multiplicação de dois números positivos deve ser correta");
    }

    @Test
    @DisplayName("Deve multiplicar qualquer número por zero e retornar zero")
    void multiplicar_porZero_retornaZero() {
        // ARRANGE
        int a = 9;
        int b = 0;
        int esperado = 0;

        // ACT
        int resultado = calc.multiplicar(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "Multiplicar por zero deve sempre retornar zero");
    }

    @Test
    @DisplayName("Deve multiplicar números negativos e retornar resultado correto")
    void multiplicar_numerosNegativos_retornaCorreto() {
        // ARRANGE
        int a = -2;
        int b = -3;
        int esperadoPositivo = 6;
        int esperadoNegativo = -6;

        // ACT
        int resultadoPositivo = calc.multiplicar(a, b);
        int resultadoNegativo = calc.multiplicar(a, -b);

        // ASSERT
        assertEquals(esperadoPositivo, resultadoPositivo, "Multiplicação de dois negativos deve ser positiva");
        assertEquals(esperadoNegativo, resultadoNegativo, "Multiplicação de negativo por positivo deve ser negativa");
    }

    // ---------- DIVIDIR ----------

    @Test
    @DisplayName("Deve dividir dois números exatos e retornar o resultado correto")
    void dividir_divisaoExata_retornaCorreto() {
        // ARRANGE
        int a = 6;
        int b = 3;
        int esperado = 2;

        // ACT
        double resultado = calc.dividir(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A divisão exata deve retornar o quociente correto");
    }

    @Test
    @DisplayName("Deve dividir dois números e retornar apenas a parte inteira do resultado")
    void dividir_comResto_retornaResultadoInteiro() {
        // ARRANGE
        int a = 5;
        int b = 2;
        double esperado = 2.5;

        // ACT
        double resultado = calc.dividir(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A divisão com resto deve truncar o resultado para inteiro");
    }

    @Test
    @DisplayName("Deve dividir dois números e retornar apenas a parte inteira do resultado")
    void dividir_divisaoExata_negativoPorPositivo() {
        // ARRANGE
        int a = -9;
        int b = 3;
        int esperado = -3;

        // ACT
        double resultado = calc.dividir(a, b);

        // ASSERT
        assertEquals(esperado, resultado, "A divisão exata deve retornar o quociente correto");
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar dividir por zero")
    void dividir_porZero_lancaExcecao() {
        // ARRANGE
        int a = 10;
        int b = 0;

        // ACT & ASSERT
        assertThrows(IllegalArgumentException.class,
                () -> calc.dividir(a, b),
                "Dividir por zero deve lançar IllegalArgumentException");
    }
}