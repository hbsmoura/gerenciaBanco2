/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hbsmoura.gerenciabanco2;

import static com.hbsmoura.gerenciabanco2.GerenciaBanco2.*;
import entidades.Usuario;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author hbsmoura
 */
public class AplicarBanco {

    public static boolean executar(ProcessBuilder pb, Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        boolean repete = true;
        limparTela(pb);
        System.out.println("""
                            Selecione uma das opções abaixo e insira o dígito correspondente:
                            ********************************************
                            1 - CDB (10% ao ano)
                            2 - LCI (8% ao ano)
                                                                          
                            0 - Sair
                            ********************************************
                            """);
        int opcao = sc.nextInt();

        double taxaAnual = 0d;
        switch (opcao) {
            case 1 ->
                taxaAnual = .1;
            case 2 ->
                taxaAnual = .08;
            case 0 ->
                repete = false;
            default -> {
                opcaoInvalida();
                pressioneEnter();
            }
        }

        if (taxaAnual == 0d) {
            return repete;
        }

        double taxaMensal = Math.pow(1d + taxaAnual, (1d / 12d)) - 1d;

        limparTela(pb);
        System.out.println((opcao < 2 ? "CBD" : "LCI") + " do Gerencia Banco");
        System.out.println("Por favor, insira o valor a ser investido:");
        String valor = sc.next();
        
        BigDecimal aporte = new BigDecimal(valor);
        
        System.out.println("Agora insira a quantidade de parcelas (número de meses do investimento):");
        int numeroParcelas = sc.nextInt();
        
        BigDecimal total = aporte.multiply(new BigDecimal(1+taxaMensal).pow(numeroParcelas));

        String formato = "| %-10s | %-13.2f | %-10d | %-13.2f | %-10.2f |%n";

        System.out.format("+------------+---------------+------------+---------------+------------+%n");
        System.out.format("|  Aplicação |     Aporte    |  Parcelas  |     Total     | Rendimento |%n");
        System.out.format("+------------+---------------+------------+---------------+------------+%n");

        System.out.format(formato,
                opcao < 2 ? "CBD" : "LCI",
                aporte,
                numeroParcelas,
                total,
                total.subtract(aporte)
        );
        System.out.format("+------------+---------------+------------+---------------+------------+%n");
        System.out.println();
        
        pressioneEnter();

        return repete;
    }

}
