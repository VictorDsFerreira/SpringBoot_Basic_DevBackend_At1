package com.aulaback.aula;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("listaexerc")
public class ListaExerc {

    @GetMapping("/calculadora/soma/{num1}/{num2}")
    public String soma (@PathVariable double num1, @PathVariable double num2) {
        return "O resultado da soma é " + Double.toString(num1 + num2);
    }
    @GetMapping("/calculadora/subtracao")
    public String subtracao (@RequestParam ("n1")double num1, @RequestParam ("n2")double num2) {
        return "O resultado da subtração é  " + (num1 - num2);
    }
    @GetMapping("/calculadora/multiplicacao/{num1}/{num2}")
    public String multiplicacao (@PathVariable double num1, @PathVariable double num2) {
        return "O resultado da multiplicação é  " + (num1 * num2);
    }
    @GetMapping("/calculadora/divisao")
    public String divisao (@RequestParam ("n1")double num1, @RequestParam ("n2")double num2) {
        if (num2 == 0) {
            return "Impossivel divisão por 0";
        }else {
            return "O resultado da divisão é " + (num1 / num2);
        }
    }
    @GetMapping("calculadora/quadrado/{num1}")
    public String quadrado (@PathVariable double num1) {
        return "Esse número ao quadrado é: " + Double.toString(num1 * num1);
    }
    @GetMapping("/conversor/temperatura")
    public String conversorCelsius(@RequestParam ("c")double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return "A temperatura" + celsius + "º covertida para Fahrenheit é " + fahrenheit;
    }
    @GetMapping("calculadora/imc")
    public String imc (@RequestParam ("p")double peso, @RequestParam ("a")double altura) {
        double imc = peso / (altura * altura);
        return "O IMC é " + imc;
    }
    @GetMapping("/antecessor-sucessor/{num}")
    public String antecessorsucessor (@PathVariable double num) {
        return "Número antecessor: " + Double.toString(num - 1) +
                "   Número sucessor: " + Double.toString(num + 1);
    }
    @GetMapping("calculadora/desconto")
    public String desconto (@RequestParam ("v") double valor, @RequestParam ("p") double percentual) {
        double valorFinal = valor - (valor * percentual/100);
        return "O valor de " + valor + " com desconto de " +  percentual + "% fica um total de R$" + valorFinal;
    }
    @GetMapping("calculadora/tabuada/{num}")
    public List<String> tabuada (@PathVariable double num) {
        List<String> tabuada = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            tabuada.add(num + " x " + i + " = " + (num * i));
        }

        return tabuada;
    }
}
