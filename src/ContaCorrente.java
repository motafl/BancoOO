public class ContaCorrente extends ContaBancaria{
    private String tipoConta;
    private String chavePix;

    public ContaCorrente(double numeroConta, double agencia, String senha, Pessoa pessoa, double saldo, String chavePix){
        super(numeroConta, agencia, senha, pessoa, saldo);
        this.tipoConta = "Conta Corrente";
        this.chavePix = chavePix;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public String getTipoConta(){
        return tipoConta;
    }
    @Override
    public String imprimirDados() {
        return "ContaCorrente{" +
                "numeroConta='" + getNumeroConta() + '\''+
                ", agencia='" + getAgencia() + '\'' +
                ", saldo=" + getSaldo() +
                ", tipoConta='" + tipoConta + '\'' +
                '}';
    }

}