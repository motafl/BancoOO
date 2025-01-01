public class ContaPoupanca extends ContaBancaria{
    private String tipoConta;

    public ContaPoupanca(double numeroConta, double agencia, String senha, double saldo, Pessoa pessoa){
        super(numeroConta, agencia, senha, pessoa, saldo);
        this.tipoConta = "Conta Poupança";
    }

    @Override
    public String getTipoConta(){
        return tipoConta;
    }

    @Override
    public String imprimirDados(){
        return "ContaPoupanca{" +
                "numeroConta='" + getNumeroConta() + '\'' +
                ", agencia='" + getAgencia() + '\'' +
                ", saldo=" + getSaldo() +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }
}