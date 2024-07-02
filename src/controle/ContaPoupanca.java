package controle;

import modelo.Cliente;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void emprestimo(double valor, Conta contaDestino) {
        throw new UnsupportedOperationException("Empréstimo não disponível para Conta Poupança");
    }
}
