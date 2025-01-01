import java.util.List;

public class IntegracaoPix {
    private static List<ContaBancaria> contas;

    public static void setContas(List<ContaBancaria> contas) {
        IntegracaoPix.contas = contas;
    }

    public static ContaBancaria buscarContaPorChavePix(String chavePix) {
        for (ContaBancaria conta : contas) {
            if (conta instanceof ContaCorrente) {
                ContaCorrente contaCorrente = (ContaCorrente) conta;
                if (contaCorrente.getChavePix().equals(chavePix)) {
                    return contaCorrente;
                }
            }
        }
        return null;
    }
}