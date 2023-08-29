/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hbsmoura.gerenciabanco2;

import static com.hbsmoura.gerenciabanco2.GerenciaBanco2.*;
import entidades.Usuario;
import java.util.Scanner;

/**
 *
 * @author hbsmoura
 */
public class Calculos {

    public static boolean run(ProcessBuilder pb, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        
        boolean repete = true;

        limparTela(pb);
        System.out.println("Olá, " + usuario.getPrenome());
        System.out.println("""
                           Aproveite nossa calculadora para auxiliar nas suas fincanças
                           
                           Selecione uma das operações e insira o dígito correspondente:
                           ********************************************
                           1 - Adição
                           2 - Subtração
                           3 - Divisão
                           4 - Multiplicação
                           5 - Radiciação
                           
                           0 - Sair
                           ********************************************
                           """);

        int opcao = sc.nextInt();

        limparTela(pb);
        switch (opcao) {
            case 1 -> {
                System.out.println("Calculadora: Adição\nInforme o primeiro valor:");
                double primeiroTermo = sc.nextDouble();
                System.out.println("Informe o segundo valor:");
                double segundoTermo = sc.nextDouble();
                double resultado = primeiroTermo + segundoTermo;
                System.out.printf("\nResultado da adição: %.2f", resultado);
            }
            case 2 -> {
                System.out.println("Calculadora: Subtração\nInforme o primeiro valor (minuendo):");
                double primeiroTermo = sc.nextDouble();
                System.out.println("Informe o segundo valor (subtraendo):");
                double segundoTermo = sc.nextDouble();
                double resultado = primeiroTermo - segundoTermo;
                System.out.printf("\nResultado da subtração: %.2f", resultado);
            }
            case 3 -> {
                System.out.println("Calculadora: Divisão\nInforme o primeiro valor (dividendo):");
                double primeiroTermo = sc.nextDouble();
                System.out.println("Informe o segundo valor (divisor):");
                double segundoTermo = sc.nextDouble();
                double resultado = primeiroTermo / segundoTermo;
                System.out.printf("\nResultado da divisão: %.2f", resultado);
            }
            case 4 -> {
                System.out.println("Calculadora: Multiplicação\nInforme o primeiro valor:");
                double primeiroTermo = sc.nextDouble();
                System.out.println("Informe o segundo valor:");
                double segundoTermo = sc.nextDouble();
                double resultado = primeiroTermo - segundoTermo;
                System.out.printf("\nResultado da multiplicação: %.2f", resultado);
            }
            case 5 -> {
                System.out.println("Informe o número a ser calculado:");
                double termo = sc.nextDouble();
                double resultado = Math.sqrt(termo);

                System.out.println("Resultado da raiz quadrada de " + termo + ": " + resultado);
            }
            case 0 -> {
                repete = false;
            }
            default -> {
                opcaoInvalida();
            }
        }
        
        pressioneEnter();

        return true;
    }
}
