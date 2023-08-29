/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hbsmoura.gerenciabanco2;

import static com.hbsmoura.gerenciabanco2.GerenciaBanco2.*;
import entidades.Usuario;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author hbsmoura
 */
public class ContaBanco {

    public static boolean executar(ProcessBuilder pb, Usuario usuario) {
        
        Scanner sc = new Scanner(System.in);
        
        boolean repete = true;

        limparTela(pb);
        System.out.println("""
                            Selecione uma das operações e insira o dígito correspondente:
                            ********************************************
                            1 - Saldo
                            2 - Depósito
                            3 - Saque
                            4 - Histórico
                                               
                            0 - Sair
                            ********************************************
                            """);
        int opcao = sc.nextInt();

        limparTela(pb);
        String valor;
        switch (opcao) {

            case 1 -> {
                System.out.println(usuario.getConta());
                System.out.println("Saldo: " + usuario.getConta().getSaldo());
                System.out.println("********************************************");
            }
            case 2 -> {
                System.out.println("Insira o valor a ser depositado:");
                valor = sc.next();
                usuario.getConta().depositar(valor);
                System.out.println("\nDepósito efetuado com sucesso.");
            }
            case 3 -> {
                System.out.println("Insira o valor a ser sacado:");
                valor = sc.next();
                System.out.println(
                        usuario.getConta().sacar(valor) ? "Retire as cédulas no local indicado." : "Saldo insuficiente."
                );
            }
            case 4 -> {
                System.out.println(usuario.getConta());
                System.out.println("Histórico de movimentações: ");
                String formato = "| %-15s | %-9.2f | %-10s | %-7s | %-9.2f |%n";

                System.out.format("+-----------------+-----------+------------+---------+-----------+%n");
                System.out.format("|   Movimentação  |   Valor   |    Data    | Horário |   Saldo   |%n");
                System.out.format("+-----------------+-----------+------------+---------+-----------+%n");
                usuario.getConta().obterHistorico().forEach(operacao -> {
                    System.out.format(formato,
                            operacao.getTipo(),
                            operacao.getValor(),
                            operacao.getHorario().toLocalDate()
                                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            operacao.getHorario().toLocalTime()
                                    .format(DateTimeFormatter.ofPattern("H:m")),
                            operacao.getSaldoRemanescente()
                    );
                });
                System.out.format("+-----------------+-----------+------------+---------+-----------+%n");
            }
            case 0 -> {
                repete = false;
            }
            default -> {
                opcaoInvalida();
            }
        }
        pressioneEnter();
        
        return repete;
    }
}
