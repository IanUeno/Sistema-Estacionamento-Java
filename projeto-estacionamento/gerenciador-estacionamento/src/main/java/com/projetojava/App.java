package com.projetojava;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Estacionamento est = new Estacionamento("VAGALUGUE");


        int op = 0;

        while(op!= 4){

            for(int i = 0; i<30; i++){
                System.out.println("\n");
            }

            System.out.println("\n\n\n");
            System.out.println("========= BEM VINDO AO VAGALUGUE =========");
            System.out.println("O melhor estacionamento digital para voce!");
            System.out.println("==========================================");
            System.out.println("\n");
            System.out.println("1) Cadastrar um Novo Veiculo");
            System.out.println("2) Imprimir lista de Veiculos Cadastrados");
            System.out.println("3) Remover Veiculo");
            System.out.println("4) Encerrar Programa");
            System.out.println("\n--------------------------------------");
            System.out.println("escolha uma das opções:");
            op = scanner.nextInt();
            scanner.nextLine();

            if (op == 1) {

                for(int i = 0; i<30; i++){
                    System.out.println("\n");
                }

                if (est.myList.size() == 50) {

                    System.out.println("================  [AVISO]  ===============");
                    System.out.println("IMPOSSIVEL CADASTRAR, ESTACIONAMENTO LOTADO");
                    System.out.println("==========================================");
                    scanner.nextLine();
                    continue;
                    
                }

                    System.out.println("========= CADASTRAR VEÍCULO ========");
                    System.out.print("Digite a placa do veículo -> ");
                    String placa = scanner.nextLine();

                    System.out.print("Digite o modelo do veículo -> ");
                    String modelo = scanner.nextLine();

                    System.out.print("Digite hora de entrada -> ");
                    int horaEntrada = scanner.nextInt();
                    
                    System.out.print("Digite minutos de entrada -> ");
                    int minutoEntrada = scanner.nextInt();

                    System.out.println("\n\n");

    
                    est.cadastrarVeiculo(placa, modelo, horaEntrada, minutoEntrada);
                    scanner.nextLine();
                    scanner.nextLine();
                
            }

            if (op == 2) {

                for(int i = 0; i<30; i++){
                    System.out.println("\n");
                }

                est.listarVeiculos();
                scanner.nextLine();
            }

            if ( op == 3) {

                for(int i = 0; i<30; i++){
                    System.out.println("\n");

                }

                if (est.myList.size() < 1) {

                    System.out.println("================  [AVISO]  ===============");
                    System.out.println(" NÃO HÁ VEÍCULOS ESTACIONADOS NO MOMENTO! ");
                    System.out.println("==========================================");
                    scanner.nextLine();
                    continue;
                    
                }

                System.out.println("========= REMOVER VEICULO ========");
                    System.out.print("Digite a placa do veículo -> ");
                    String placa = scanner.nextLine();

                    System.out.print("Hora de saida -> ");
                    int horaSaida = scanner.nextInt();

                    System.out.print("Minuto de saida -> ");
                    int minutoSaida = scanner.nextInt();
                
                    System.out.println("\n\n");
    
                    est.removerVeiculo(placa, horaSaida, minutoSaida);
                    scanner.nextLine();
                    scanner.nextLine();


            }

            if (op == 4) {
                for(int i = 0; i<30; i++){
                    System.out.println("\n");

                }
                est.salvarVeiculos(); 
                System.out.println("========= [ PROGRAMA ENCERRADO ]==========");
                System.out.println("    VEÍCULOS FORAM SALVOS COM SUCESSO!   ");
                System.out.println("==========================================");
                break; 
            }
            




        }



        

                    


                
    }
}
