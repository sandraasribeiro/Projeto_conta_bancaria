package controle;

import modelo.Cliente;

public class ContaPoupanca extends Conta {

  private static final double RENDIMENTO = 0.05;

  public ContaPoupanca(Cliente cliente) {
    super(cliente);
  }

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Poupança ===");
    super.imprimirInfosComuns();
  }

/*  @Override
  public void emprestimo(double valor, Conta contaDestino) {
    rendimentos = valor * RENDIMENTO;
    System.out.println("Rendimentos: " + rendimentos);

    System.out.println("Saldo antigo: " + saldo);
    saldo -= valor;
    System.out.println("Novo saldo: " + saldo);
  }*/

  @Override
  public void emprestar(double valor, Conta contaDestino) {
    throw new UnsupportedOperationException("Empréstimo não disponível para Conta Poupança");
  }

  @Override
  public void investir(double valor, Conta contaDestino) {
    rendimentos = valor * RENDIMENTO;
    System.out.println("Rendimentos: " + rendimentos);

    System.out.println("Saldo antigo: " + saldo);
    saldo += valor;
    System.out.println("Novo saldo: " + saldo);
  }
}
