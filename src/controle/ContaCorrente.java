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

  @Override
  public void investir(double valor, Conta contaDestino) {
    throw new UnsupportedOperationException("Investimento não disponível para Conta Corrente");
  }

  @Override
  public void emprestar(double valor, Conta contaDestino) {
    JFrame f;
    f = new JFrame();

    if (valor > limiteEmprestimo) {
      JOptionPane.showMessageDialog(f, "Valor acima do limite disponível");
      return;
    }

    System.out.println("Empréstimo aceito");

    System.out.println("Saldo anterior: " + saldo);
    contaDestino.depositar(valor);

     System.out.println("=== Extrato Empréstimo ===");
    super.imprimirInfosComuns();

    debitos = valor * TAXA_JUROS;
    System.out.println("Débito bancário: " + debitos);
  }
}
