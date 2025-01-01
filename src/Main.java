import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);        
    private static List<Pessoa> clientes = new ArrayList<>();
    protected static List<ContaBancaria> contas = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        //Cria mock de contas para testes
        criarContasFixas();

        //Vincular chavePix as contas bancárias. Contas bancárias/clientes adicionados posteriormente também funcionam normalmente.
        IntegracaoPix.setContas(contas);

        //Abre App
        menuAppBanco();
    }

    // MENU DO APP
    private static void menuAppBanco() throws InterruptedException {
        System.out.println("|    Bem vindo ao Banco Orientado a Objeto    |");
        boolean continuar = true;

        while (continuar) {
            System.out.println("|                                             |\n" +
                    "|--------------------MENU---------------------|\n" +
                    "|      1.Cadastrar Conta                      |\n" +
                    "|      2.Acessar Conta                        |\n" +
                    "|      3.Sair                                 |\n" +
                    "|---------------------------------------------|\n"
            );
            String opcaoSelecionada = scanner.nextLine();
            switch (opcaoSelecionada) {
                case "1":
                    cadastrarConta();
                    break;
                case "2":
                    acessarConta();
                    break;
                case "3":
                    sair();
                    continuar = false;
                    break;
                default:
                    try {
                        System.out.println("Opção inválida, retornando ao menu...");
                        Thread.sleep(3000);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    break;
            }
        }
    }

    private static void sair() {
        System.out.println("Finalizando App");
    }

    // LOGIN DA CONTA
    private static void acessarConta() throws InterruptedException {
        System.out.println("\n|                                             |\n" +
                "|-------------- ACESSAR CONTA ----------------|\n" +
                "|          Informe os dados a seguir:         |\n" +
                "|                                             |\n"
        );
        System.out.print("| Agência: ");
        double agenciaInformada = scanner.nextDouble();
        System.out.print("| Número da Conta: ");
        double contaInformada = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha pendente
        System.out.print("| Senha: ");
        String senhaInformada = scanner.nextLine();

        boolean contaEncontrada = false;
        boolean menuDaConta = false;
        ContaBancaria contaParaRemover = null;

        for (ContaBancaria conta : contas) {
            if (    conta.getAgencia() == agenciaInformada &&
                    conta.getNumeroConta() == contaInformada &&
                    conta.getSenha().equals(senhaInformada)) {
                contaEncontrada = true;
                menuDaConta = true;


                System.out.println("\n| Bem-vindo(a), " + conta.getPessoa().getNome() + ".");

                //VERIFICA SE É CONTA CORRENTE OU POUPANÇA
                if (conta.getTipoConta().equals("Conta Corrente")){

                    while (menuDaConta) {
                        System.out.println("\n" +
                                "|                                              |\n" +
                                "|------------MENU DA CONTA CORRENTE----------- |\n" +
                                "|      1.Depositar                             |\n" +
                                "|      2.Sacar                                 |\n" +
                                "|      3.PIX                                   |\n" +
                                "|      4.Verificar Saldo                       |\n" +
                                "|      5.Sair da Conta Corrente                |\n" +
                                "|--------------------------------------------- |\n"
                        );
                        String opcaoMenuConta = scanner.nextLine();
                        switch (opcaoMenuConta) {
                            case "1":
                                System.out.println("\n" + menuDepositar(conta) + "\n");
                                Thread.sleep(2000);
                                break;
                            case "2":
                                System.out.println("\n" + menuSacar(conta) + "\n");
                                Thread.sleep(2000);
                                break;
                            case "3":
                                System.out.println("\n" + menuPix(conta) + "\n");
                                Thread.sleep(2000);
                                break;
                            case "4":
                                System.out.println("\nSeu saldo atual é de: R$" + conta.getSaldo());
                                Thread.sleep(2000);
                                break;
                            case "5":
                                menuDaConta = false;
                                System.out.println("Voltando ao Menu Inicial");
                                Thread.sleep(2000);
                                break;
                            default:
                                try {
                                    System.out.println("Opção inválida, retornando ao menu...");
                                    Thread.sleep(3000);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                                break;
                        }
                    }
                }
                if (conta.getTipoConta().equals("Conta Poupança")) {
                    while (menuDaConta) {
                        System.out.println("\n" +
                                "|                                              |\n" +
                                "|------------MENU DA CONTA POUPANÇA----------- |\n" +
                                "|      1.Aplicar                               |\n" +
                                "|      2.Resgatar                              |\n" +
                                "|      3.Verificar Saldo                       |\n" +
                                "|      4.Encerrar conta                        |\n" +
                                "|      5.Sair da Conta Poupança                |\n" +
                                "|--------------------------------------------- |\n"
                        );
                        String opcaoMenuConta = scanner.nextLine();
                        switch (opcaoMenuConta) {
                            case "1":
                                System.out.println("\n" + menuAplicar(conta) + "\n");
                                Thread.sleep(2000);
                                break;
                            case "2":
                                System.out.println("\n" + menuResgatar(conta) + "\n");
                                Thread.sleep(2000);
                                break;
                            case "3":
                                System.out.println("\nSeu saldo atual é de: R$" + conta.getSaldo());
                                Thread.sleep(2000);
                                break;
                            case "4":
                                System.out.println("\nOrdem de encerramento de conta enviada\n");
                                //Marcar conta para remoção fora do loop
                                contaParaRemover = conta;
                                menuDaConta = false;
                                Thread.sleep(500);
                                break;
                            case "5":
                                menuDaConta = false;
                                System.out.println("Voltando ao Menu Inicial");
                                Thread.sleep(2000);
                                break;
                            default:
                                try {
                                    System.out.println("Opção inválida, retornando ao menu...");
                                    Thread.sleep(3000);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                                break;
                        }
                    }
                }
            }
        }
        //chamada de remoção de conta fora do loop
        if (contaParaRemover != null) {
            System.out.println(menuEncerrarConta(contaParaRemover));
            System.out.println("Retornando ao Menu Inicial");
            Thread.sleep(2000);
        }

        //Conta não encontrada
        if (!contaEncontrada) {
            try {
                System.out.println("\nDados Incorretos.\nRetornando ao Menu...");
                Thread.sleep(2000);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    // Criar Nova Conta Bancária
    private static void cadastrarConta() {
        Random aleatorio = new Random();
        System.out.println("Cadastrar Nova Conta Bancária\n" +
                "Para comecarmos, digite o número referente ao tipo de Conta que deseja criar:\n" +
                "1. Conta Corrente \n2. Conta Poupança");
        String tipoConta = scanner.nextLine();
        System.out.println("Informe o nome completo do Cliente:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Informe o CPF completo do Cliente:");
        String cpfCliente = scanner.nextLine();

        System.out.println("Informe o endereço do Cliente:");
        String enderecoCliente = scanner.nextLine();

        System.out.println("Informe o telefone com ddd do Cliente:");
        String telefoneCliente = scanner.nextLine();

        System.out.println("Informe a senha do Cliente:");
        String senhaCliente = scanner.nextLine();

        System.out.println("Informe o saldo do Cliente, com duas casas decimais:");
        float saldoCliente = scanner.nextFloat();
        scanner.nextLine(); // Consumir a nova linha pendente

        Pessoa novoCliente = new Pessoa(nomeCliente, cpfCliente, enderecoCliente, telefoneCliente);
        clientes.add(novoCliente);

        int numAgenciaCliente = aleatorio.nextInt(9999);
        int numContaCliente = aleatorio.nextInt(99999);

        switch (tipoConta) {
            case "1":
                System.out.println("Cadastre uma chave Pix");
                String chavePix = scanner.nextLine();
                ContaCorrente novaCC = new ContaCorrente(numContaCliente, numAgenciaCliente, senhaCliente, novoCliente, saldoCliente, chavePix);
                contas.add(novaCC);
                System.out.println("Nova Conta Corrente Criada no nome de: " + nomeCliente + ", CPF: " + cpfCliente + "\nAg: " + numAgenciaCliente + "\nCC: " + numContaCliente);
                break;
            case "2":
                ContaPoupanca novaCP = new ContaPoupanca(numContaCliente, numAgenciaCliente, senhaCliente, saldoCliente, novoCliente);
                contas.add(novaCP);
                System.out.println("Nova Conta Poupança Criada no nome de: " + nomeCliente + ", CPF: " + cpfCliente + "\nAg: " + numAgenciaCliente + "\nCC: " + numContaCliente);
                break;
            default:
                System.out.println("Tipo de conta inválida");
                return;
        }
        System.out.println("Retornando ao menu...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Menu Depositar
    private static String menuDepositar(ContaBancaria conta) {
        System.out.print("Digite o valor do depósito: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha pendente
        return conta.depositar(valor);
    }

    // Menu Sacar
    private static String menuSacar(ContaBancaria conta) {
        System.out.print("Digite o valor do saque: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha pendente
        return conta.sacar(valor);
    }

    // Menu PIX
    private static String menuPix(ContaBancaria conta) {
        System.out.print("Digite a chave PIX que você deseja enviar: ");
        String chavePix = scanner.nextLine();
        System.out.print("Digite o valor que deseja enviar para a chave PIX '" + chavePix + "' : R$");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha pendente
        return conta.pix(chavePix, valor);
    }

    //Menu Aplicar
    private static String menuAplicar(ContaBancaria conta){
        System.out.print("Digite o valor que deseja aplicar: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return conta.aplicar(valor);
    }

    //Menu Resgatar
    private static String menuResgatar(ContaBancaria conta){
        System.out.print("Digite o valor que deseja resgatar: R$");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return conta.resgatar(valor);
    }

    //Menu Encerrar Conta
    private static String menuEncerrarConta(ContaBancaria conta) {
        if(conta != null){
            contas.remove(conta);
            return "Conta Removida com Sucesso!";
        }else
            return "Erro ao remover a conta";
    }

    // Imprimir todos Clientes
    private static void imprimirTodosClientes() {
        System.out.println("Lista de todos Clientes");
        for (Pessoa cliente : clientes) {
            System.out.println(cliente.getNome());
        }
    }

    //Cria contas para testes
    private static void criarContasFixas() {
        Pessoa pessoa1 = new Pessoa("João Silva", "12345678900", "Rua A, 123", "111111111");
        ContaCorrente conta1 = new ContaCorrente(10001, 1234, "senha123", pessoa1, 100, "joao@pix.com");
        clientes.add(pessoa1);
        contas.add(conta1);

        Pessoa pessoa2 = new Pessoa("Maria Oliveira", "09876543211", "Rua B, 456", "222222222");
        ContaCorrente conta2 = new ContaCorrente(10002, 1234, "senha456", pessoa2, 100, "maria@pix.com");
        clientes.add(pessoa2);
        contas.add(conta2);

        Pessoa pessoa3 = new Pessoa("Fabio Mota", "09876543211", "Rua B, 456", "222222222");
        ContaPoupanca conta3 = new ContaPoupanca(10003, 1234, "senha456",100, pessoa3);
        clientes.add(pessoa3);
        contas.add(conta3);
    }
}