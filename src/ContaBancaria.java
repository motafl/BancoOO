import java.util.Random;

public abstract class ContaBancaria {
    private Pessoa pessoa;
    private double numeroConta;
    private double agencia;
    private String senha;
    private double saldo;

    //Construtor
    public ContaBancaria(double numeroConta, double agencia,String senha, Pessoa pessoa, double saldo){
        this.pessoa = pessoa;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = saldo;
    }


    public double getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(double numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getAgencia() {
        return agencia;
    }

    public void setAgencia(double agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getSenha() {
        return senha;
    }

    public Pessoa getPessoa() { return pessoa; }

    public String depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            return "Deposito Efetuado!\nSaldo Atualizado: R$"+saldo;
        }
        return "Valor não conforme ou insuficiente!\nSaldo Atualizado: R$"+saldo;
    }

    public String sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return "Saque Realizado! Saldo Atual: "+saldo;
        }
        return "Saldo Insuficiente";

    }

    public String pix(String chavePix, double valor) {

        ContaBancaria contaDestino = IntegracaoPix.buscarContaPorChavePix(chavePix);
        if(contaDestino == null){
            return "Chave Pix não encontrada";
        }
        if (valor > 0 && saldo >= valor){
            //subtrai valor da conta que está fazendo o pix
            this.saldo -= valor;
            //envia o valor para conta da chavePix
            contaDestino.depositar(valor);
            Random random = new Random();
            int codigoTransferenciaPix = random.nextInt(9999999);
            return "Comprovante: \nNúmero da Transição: "+codigoTransferenciaPix+"" +
                    "\nChave PIX: "+chavePix+"" +
                    "\nValor Transferido: "+valor;
        }
        return "Saldo Insuficiente";
    }

    public abstract String getTipoConta();

    public String aplicar(double valor){
        saldo += valor;
        saldo = saldo*1.01;
        return "Aplicação realizada! Saldo Atual: R$"+saldo;
    }
    public String resgatar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return "Resgate Realizado! Saldo Atual: "+saldo;
        }
        return "Saldo Insuficiente";

    }

    public String imprimirDados(){
        return "ContaBancaria{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}