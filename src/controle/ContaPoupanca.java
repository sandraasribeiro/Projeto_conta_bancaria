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
  public void emprestar(double valor, Conta contaDestino) {
    throw new UnsupportedOperationException("Empréstimo não disponível para Conta Poupança");
  }

  @Override
  public void investir(double percentualJuros, Conta contaDestino) {
    rendimentos = (saldo * percentualJuros/100);
    System.out.println("Rendimentos: " + rendimentos);

    System.out.println("Saldo antigo: " + saldo);
    saldo += rendimentos;
    System.out.println("Novo saldo: " + saldo);
  }
}
