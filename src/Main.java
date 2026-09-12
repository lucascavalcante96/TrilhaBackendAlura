import java.util.Scanner;

public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os dados da conta");
        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.print("Tipo de conta: ");
        String tipoDeConta = sc.nextLine();

        System.out.print("Digite o valor da conta: ");
        double saldo = sc.nextDouble();

        System.out.println();
        System.out.println("****************************************************");
        System.out.println("Dados Iniciais do Cliente:");
        System.out.println();
        System.out.printf("Nome:             %s\n", nome);
        System.out.printf("Tipo de conta:   %s\n", tipoDeConta);
        System.out.printf("Saldo:           R$ %.2f\n", saldo);
        System.out.println("****************************************************");


        while (true){
            System.out.println("""
                    
                    Operações
                    
                    1- Consultar saldo
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    """);
            System.out.print("Operação: ");
            int operacao = sc.nextInt();
            if(operacao == 1){
                System.out.println("Saldo: R$ " + saldo);
            }
            else if(operacao == 2){
                System.out.print("Digite o valor a receber:");
                double valor = sc.nextDouble();
                saldo += valor;
                System.out.println("Saldo: R$ " + saldo);
            }
            else if(operacao == 3){
                System.out.print("Digite o valor a transferir:");
                double valor = sc.nextDouble();
                if (saldo >= valor){
                    saldo -= valor;
                    System.out.println("Saldo: R$ " + saldo);
                }
                else {
                    System.out.println("Não foi possivel realizar a transferencia!");
                }
            }
            else if(operacao == 4){
                System.out.println("Obrigado por utilizar o Banco!");
                break;
            }
            else {
                System.out.println("Operação invalida digite novamente!");

            }

        }


    }
}
