import controle.Conta;
import controle.ContaCorrente;
import controle.ContaPoupanca;
import modelo.Cliente;
import javax.swing.*;

public class Main {
  public static void main(String[] args) {

    CriarBanco();
  }

  private static void CriarBanco() {
    JFrame f;
    f = new JFrame();
    String nome = JOptionPane.showInputDialog(f, "Entre o Nome do Cliente");
    Cliente cliente = new Cliente();
    cliente.setNome(nome);
    Conta cc = new ContaCorrente(cliente);
    Conta pp = new ContaPoupanca(cliente);
    boolean fim=true;
    while (fim) {
      int tipoConta =
          Integer.parseInt(
              JOptionPane.showInputDialog(f,"Entre  com o tipo da conta: 0 - Sair, 1 - Conta Corrente, 2 - Conta Poupança "));
      switch (tipoConta) {
        case 0:
        fim = false;
        JOptionPane.showMessageDialog(f, "Obrigada!");
          break;
        case 1:
          int movimentoC =
              Integer.parseInt(
                  JOptionPane.showInputDialog(
                      f,
                      "0 - Sair, 1 - Saldo, 2 - Sacar, 3 - Deposito, 4 - Transferencia para Poupança, 5 - Emprestimo"));
          if (movimentoC == 0) break;
          if (movimentoC == 1) cc.imprimirExtrato();
          if (movimentoC == 2) {
            double valor =
                Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da saque"));
            cc.sacar(valor);
            cc.imprimirExtrato();
          }
          if (movimentoC == 3) {
            double valor =
                Double.parseDouble(
                    JOptionPane.showInputDialog(f, "Entre com o valor do DEPÓSITO "));
            cc.depositar(valor);
            cc.imprimirExtrato();
          }
          if (movimentoC == 4) {
            double valor =
                Double.parseDouble(
                    JOptionPane.showInputDialog(f, "Entre com o valor da TRANSFERENCIA "));
            cc.transferir(valor, pp);
            cc.imprimirExtrato();
          }
          if (movimentoC == 5) {
            double valor =
                Double.parseDouble(
                    JOptionPane.showInputDialog(f, "Entre com o PERCENTUAL DE JUROS"));
            cc.emprestar(valor, cc);
            cc.imprimirExtrato();
          }

        case 2:
          int movimentoP =
              Integer.parseInt(
                  JOptionPane.showInputDialog(
                      f,
                      "0 - Sair, 1 - Saldo, 2 - Sacar, 3 - Deposito, 4 - Transferencia para Conta Corrente, 5 - Juros sobre o saldo da Poupança"));
          if (movimentoP == 0) {
          JOptionPane.showMessageDialog(f,"Obrigada!");
                      break;
          }
          if (movimentoP == 1) pp.imprimirExtrato();
          if (movimentoP == 2) {
            double valor =
                Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da SAQUE"));
            pp.sacar(valor);
            pp.imprimirExtrato();
          }
          if (movimentoP == 3) {
            double valor =
                Double.parseDouble(
                    JOptionPane.showInputDialog(f, "Entre com o valor do DEPÓSITO "));
            pp.depositar(valor);
            pp.imprimirExtrato();
          }
          if (movimentoP == 4) {
            double valor =
            Double.parseDouble(
            JOptionPane.showInputDialog(f, "Entre com o valor da TRANSFERENCIA "));
            pp.transferir(valor, cc);
            pp.imprimirExtrato();
          }

          if (movimentoP == 5) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor para poupar."));
            pp.investir(valor, pp);
            pp.imprimirExtrato();
            }
          break;
        
      }
    }
  }
}
