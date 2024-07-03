package controle;

import modelo.Cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {

  public ContaCorrente(Cliente cliente) {
    super(cliente);
  }

  private static final double TAXA_JUROS = 1.02;

  @Override
  public void imprimirExtrato() {
    System.out.println("=== Extrato Conta Corrente ===");
    super.imprimirInfosComuns();
  }

/*  @Override
  public void emprestimo(double valor, Conta contaDestino) {
    System.out.println("=== Extrato Empréstimo ===");
    super.imprimirInfosComuns(); // Imprime informações comuns da conta

    if (valor > limiteEmprestimo) {
      System.out.println("Empréstimo negado");
      return;
    }

    System.out.println("Empréstimo aceito");

    System.out.println("Saldo anterior: " + saldo);
    contaDestino.depositar(valor);
    System.out.println("Saldo atual: " + saldo);

    debitos = valor * TAXA_JUROS;
    System.out.println("Débito bancário: " + debitos);
  }*/

  @Override
  public void investir(double valor, Conta contaDestino) {
    throw new UnsupportedOperationException("Investimento não disponível para Conta Corrente");
  }

  @Override
  public void emprestar(double valor, Conta contaDestino) {

    System.out.println("=== Extrato Empréstimo ===");
    super.imprimirInfosComuns(); // Imprime informações comuns da conta

    if (valor > limiteEmprestimo) {
      System.out.println("Empréstimo negado");
      return;
    }

    System.out.println("Empréstimo aceito");

    System.out.println("Saldo anterior: " + saldo);
    contaDestino.depositar(valor);
    System.out.println("Saldo atual: " + saldo);

    debitos = valor * TAXA_JUROS;
    System.out.println("Débito bancário: " + debitos);
  }
}
