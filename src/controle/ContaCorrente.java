package controle;

import modelo.Cliente;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void emprestimo(double valor, Conta contaDestino) {
        System.out.println("=== Extrato Empréstimo ===");
        super.imprimirInfosComuns(); // Imprime informações comuns da conta

        double limite = 3000;

        if (valor > limite) {
            System.out.println("Empréstimo negado");
            return;
        }

        System.out.println("Empréstimo aceito");
        contaDestino.depositar(valor);

        JFrame f = new JFrame();
        while (true) {
            int opcaoPagamento = Integer.parseInt(JOptionPane.showInputDialog(f, "0 - Sair, 1 - pagamento à vista, 2 - Parcelado"));

            if (opcaoPagamento == 0) {
                break;
            }

            switch (opcaoPagamento) {
                case 1:
                    double jurosVista = 1 / 100.0;
                    double totalVista = valor + (valor * jurosVista);
                    this.transferir(totalVista, contaDestino);
                    contaDestino.imprimirExtrato();
                    return; // Encerra após realizar a transferência

                case 2:
                    double jurosParcelado = 5 / 100.0;
                    double totalParcelado = valor + (valor * jurosParcelado);
                    this.transferir(totalParcelado, contaDestino);
                    contaDestino.imprimirExtrato();
                    return; // Encerra após realizar a transferência

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
