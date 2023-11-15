import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPagamento extends JFrame {

    private MetodoPagamento metodoPagamento;
    private double totalCompra;

    public TelaPagamento(double totalCompra) {
        this.totalCompra = totalCompra;
        configurarInterface();
    }

    private void configurarInterface() {
        setTitle("Pagamento");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Selecione o método de pagamento:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(label, gbc);

        JButton creditoButton = new JButton("Crédito");
        creditoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int qntParcela = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de parcelas: "));
                double taxa = 0.0; // Taxa inicial, pode ser ajustada conforme necessário
                metodoPagamento = new Credito(qntParcela, taxa, totalCompra, "1234");
                realizarPagamento();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(creditoButton, gbc);

        JButton debitoButton = new JButton("Débito");
        debitoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodoPagamento = new Debito(totalCompra, "1234");
                realizarPagamento();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(debitoButton, gbc);

        JButton pixButton = new JButton("Pix");
        pixButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodoPagamento = new Pix(totalCompra, "1234");
                realizarPagamento();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(pixButton, gbc);

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(sairButton, gbc);

        add(panel);
        setVisible(true);
    }

    private void realizarPagamento() {
        if (metodoPagamento != null) {
            metodoPagamento.processarPagamento();
            String mensagem = metodoPagamento.getMensagemProcessamento();
            metodoPagamento.gerarRecibo();
            JOptionPane.showMessageDialog(null, "Pagamento processado com sucesso!\n" + mensagem);
            dispose(); // Fecha a janela após o pagamento
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um método de pagamento!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaPagamento(500.0)); // Exemplo com um total de compra fictício
    }
}
