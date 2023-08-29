/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hbsmoura.gerenciabanco2;

import entidades.Usuario;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author humbe
 */
public class GerenciaBanco2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");

        limparTela(pb);
        System.out.println("""
                           Olá, prezado cliente,
                           Para continuar com o atendimento nos informe seu CPF:""");
        String cpf = sc.next();
        sc.nextLine();
        System.out.println("Agora nos informe seu primeiro nome:");
        String prenome = sc.nextLine();
        System.out.println("Por fim, nos informe seu sobrenome nome:");
        String sobrenome = sc.nextLine();

        Usuario usuario = new Usuario(prenome, sobrenome, cpf);

        limparTela(pb);
        System.out.println("""
                           Parabéns! Agora você é cliente do nosso banco.
                           Confira seus dados pessoais e sua nova conta junto à insituição.
                           ********************************************
                           """);
        System.out.println(usuario);
        System.out.println("--------------------------------------------");
        System.out.println(usuario.getConta());
        System.out.println("********************************************");
        pressioneEnter();

        boolean repete = true;

        do {
            limparTela(pb);
            System.out.println("Deseja realizar mais alguma operação (s/n)?");
            char opcaoLetra = sc.next().charAt(0);

            switch (opcaoLetra) {
                case 's' -> {
                    limparTela(pb);
                    System.out.println("Boas vindas, " + usuario.getPrenome() + "!");
                    System.out.println(usuario.getConta());
                    System.out.println("""
                                       Por favor, selecione uma das opções abaixo e insira o dígito correspondente:
                                       ********************************************
                                       1 - Transações comuns
                                       2 - Investimentos
                                       3 - Calculadora
                                       
                                       0 - Sair
                                       ********************************************
                                       """);
                    int primeiraEscolhaNumero = sc.nextInt();

                    switch (primeiraEscolhaNumero) {
                        case 1 -> repete = ContaBanco.executar(pb, usuario);
                        case 2 -> repete = AplicarBanco.executar(pb, usuario);
                        case 3 -> repete = Calculos.run(pb, usuario);
                        case 0 ->
                            repete = false;
                        default -> {
                            opcaoInvalida();
                            pressioneEnter();
                        }
                    }
                }
                case 'n' -> {
                    repete = false;
                    continue;
                }
                default -> {
                    opcaoInvalida();
                    pressioneEnter();
                }
            }

        } while (repete);

        System.out.println("Agradecemos a preferência, volte sempre!");

        sc.close();
    }

    private static String logo = """
                                                                  _         ____                        \r\n   __ _  ___ _ __ ___ _ __   ___(_) __ _  | __ )  __ _ _ __   ___ ___  \r\n  / _` |/ _ \\ '__/ _ \\ '_ \\ / __| |/ _` | |  _ \\ / _` | '_ \\ / __/ _ \\ \r\n | (_| |  __/ | |  __/ | | | (__| | (_| | | |_) | (_| | | | | (_| (_) |\r\n  \\__, |\\___|_|  \\___|_| |_|\\___|_|\\__,_| |____/ \\__,_|_| |_|\\___\\___/ \r\n  |___/                                                                \r\n
                                 """;

    public static void limparTela(ProcessBuilder pb) {
        try{
            pb.inheritIO().start().waitFor();

            System.out.println(logo);
        } catch (Exception e) {}
        
    }

    public static void opcaoInvalida() {
        System.out.println("Opção inválida! Verifique o conjunto de opçoes válidas e tente novamente");        
    }
    
    public static void pressioneEnter() {
        System.out.println("Pressione 'Enter' para prosseguir.");
        try {
            System.in.read();
        } catch (IOException ex) {}
    }  
    
}
