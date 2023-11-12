import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.HashMap;
import java.util.Map;

public class LojaDePerifericosGUI extends JFrame {

    private Map<String, String> descricaoProdutos;
    private Map<String, Integer> carrinho;
    private Map<String, String> caminhoImagens;
    private JTextArea descricaoTextArea;
    private JLabel precoLabel;
    private JLabel quantidadeLabel;
    private JLabel imagemLabel;
    private DefaultListModel<String> produtosListModel;
    private JList<String> produtosList;

    public LojaDePerifericosGUI() {
        setTitle("Loja de Periféricos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        descricaoProdutos = new HashMap<>();
        descricaoProdutos.put("Mouse MX Master 3", "Mouse premium com rastreamento de alta precisão");
        descricaoProdutos.put("Teclado Mecânico K95 RGB", "Teclado mecânico com iluminação RGB personalizável");
        descricaoProdutos.put("Monitor UltraSharp u2719d", "Monitor de 27'' com resolução 2k e cores precisas");
        descricaoProdutos.put("Fone de Ouvido WH-1000XM$",
                "Fones de ouvido com cancelamento de ruído e qualidade de áudio excepcional");
        descricaoProdutos.put("Impressora Laserjet PRO M404dn",
                "Impressora de jato de tinta com tanques de tinta recarregáveis");
        descricaoProdutos.put("Processador I9-11900K", "Processador de alta performance com 8 núcleos");
        descricaoProdutos.put("Placa de vídeo GeForce RTX3080", "Placa de vídeo de última geração com ray tracing");
        descricaoProdutos.put("Memória RAM Vengeance LPX 32GB", "Módulos de memória DDR4 de alta velocidade");
        descricaoProdutos.put("Disco rígido (HD) 2TB", "Disco rígido de 2 Terabytes para armazenamento");
        descricaoProdutos.put("SSD 970 EVO 1TB", "SSD NVMe de alta velocidade para melhorar o desempenho");

        carrinho = new HashMap<>();

        caminhoImagens = new HashMap<>();
        caminhoImagens.put("Mouse MX Master 3", "mouse.png");
        caminhoImagens.put("Teclado Mecânico K95 RGB", "teclado.jpg");
        caminhoImagens.put("Monitor UltraSharp u2719d", "monitor.jpg");
        caminhoImagens.put("Fone de Ouvido WH-1000XM$", "fone.jpg");
        caminhoImagens.put("Impressora Laserjet PRO M404dn", "impressora.jpeg");
        caminhoImagens.put("Processador I9-11900K", "processador.jpg");
        caminhoImagens.put("Placa de vídeo GeForce RTX3080", "placa.jpg");
        caminhoImagens.put("Memória RAM Vengeance LPX 32GB", "ram.jpg");
        caminhoImagens.put("Disco rígido (HD) 2TB", "hd.jpeg");
        caminhoImagens.put("SSD 970 EVO 1TB", "ssd.jpg");

        JLabel boasVindasLabel = new JLabel("Bem-vindo à Loja de Periféricos");
        boasVindasLabel.setHorizontalAlignment(JLabel.CENTER);
        add(boasVindasLabel, BorderLayout.NORTH);

        JButton hardwareButton = new JButton("Itens de Hardware");
        hardwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtosListModel.clear();
                produtosListModel.addElement("Processador I9-11900K");
                produtosListModel.addElement("Placa de vídeo GeForce RTX3080");
                produtosListModel.addElement("Memória RAM Vengeance LPX 32GB");
                produtosListModel.addElement("Disco rígido (HD) 2TB");
                produtosListModel.addElement("SSD 970 EVO 1TB");
            }
        });

        JButton perifericosButton = new JButton("Itens Periféricos");
        perifericosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                produtosListModel.clear();
                produtosListModel.addElement("Monitor UltraSharp u2719d");
                produtosListModel.addElement("Impressora Laserjet PRO M404dn");
                produtosListModel.addElement("Mouse MX Master 3");
                produtosListModel.addElement("Teclado Mecânico K95 RGB");
                produtosListModel.addElement("Fone de Ouvido WH-1000XM$");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(hardwareButton);
        buttonsPanel.add(perifericosButton);
        add(buttonsPanel, BorderLayout.NORTH);

        produtosListModel = new DefaultListModel<>();
        produtosListModel.addElement("Mouse MX Master 3");
        produtosListModel.addElement("Teclado Mecânico K95 RGB");
        produtosListModel.addElement("Monitor UltraSharp u2719d");
        produtosListModel.addElement("Fone de Ouvido WH-1000XM$");
        produtosListModel.addElement("Impressora Laserjet PRO M404dn");
        produtosListModel.addElement("Processador I9-11900K");
        produtosListModel.addElement("Placa de vídeo GeForce RTX3080");
        produtosListModel.addElement("Memória RAM Vengeance LPX 32GB");
        produtosListModel.addElement("Disco rígido (HD) 2TB");
        produtosListModel.addElement("SSD 970 EVO 1TB");

        produtosList = new JList<>(produtosListModel);
        produtosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        produtosList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String selectedItem = produtosList.getSelectedValue();
                if (selectedItem != null) {
                    String produto = selectedItem;
                    String descricao = descricaoProdutos.get(produto);
                    if (descricao != null) {
                        descricaoTextArea.setText(descricao);
                        precoLabel.setText("Preço: R$ " + obterPrecoProduto(produto));
                        exibirImagem(produto);
                    }
                } else {
                    descricaoTextArea.setText("");
                    precoLabel.setText("Preço:");
                    imagemLabel.setIcon(null);
                }
            }
        });

        JScrollPane produtosScrollPane = new JScrollPane(produtosList);
        add(produtosScrollPane, BorderLayout.WEST);

        JPanel descricaoPrecoPanel = new JPanel(new GridBagLayout());
        descricaoTextArea = new JTextArea(5, 40);
        descricaoTextArea.setWrapStyleWord(true);
        descricaoTextArea.setLineWrap(true);
        descricaoTextArea.setOpaque(false);
        descricaoTextArea.setEditable(false);
        descricaoTextArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        descricaoPrecoPanel.add(descricaoTextArea, c);
        c.gridy = 1;
        precoLabel = new JLabel("Preço:");
        descricaoPrecoPanel.add(precoLabel, c);
        c.gridy = 2;
        imagemLabel = new JLabel();
        descricaoPrecoPanel.add(imagemLabel, c);

        add(descricaoPrecoPanel, BorderLayout.CENTER);

        JButton adicionarAoCarrinhoButton = new JButton("Adicionar ao Carrinho");
        adicionarAoCarrinhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = produtosList.getSelectedValue();
                if (selectedItem != null) {
                    carrinho.put(selectedItem, carrinho.getOrDefault(selectedItem, 0) + 1);
                    atualizarRotuloQuantidade();
                    JOptionPane.showMessageDialog(null, "Você adicionou " + selectedItem + " ao carrinho.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um item");
                }
            }
        });

        add(adicionarAoCarrinhoButton, BorderLayout.SOUTH);

        quantidadeLabel = new JLabel("Itens no Carrinho: 0");
        buttonsPanel.add(quantidadeLabel);

        JButton finalizarCompraButton = new JButton("Finalizar Compra");
        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder mensagem = new StringBuilder("Itens no Carrinho:\n");
                double total = 0;
                for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
                    String produto = entry.getKey();
                    int quantidade = entry.getValue();
                    double precoUnitario = Double.parseDouble(obterPrecoProduto(produto));
                    total += quantidade * precoUnitario;
                    mensagem.append(produto).append(" x").append(quantidade).append("\n");
                }
                mensagem.append("\nTotal: R$ ").append(total);
                JOptionPane.showMessageDialog(null, mensagem.toString());
                carrinho.clear();
                atualizarRotuloQuantidade();
            }
        });

        buttonsPanel.add(finalizarCompraButton);

        JPanel bottomButtonsPanel = new JPanel(new GridLayout(1, 2));
        bottomButtonsPanel.add(adicionarAoCarrinhoButton);
        bottomButtonsPanel.add(finalizarCompraButton);
        adicionarAoCarrinhoButton.setBackground(Color.WHITE);
        finalizarCompraButton.setBackground(Color.WHITE);
        add(bottomButtonsPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private String obterPrecoProduto(String produto) {
        switch (produto) {
            case "Mouse MX Master 3":
                return "79.99";
            case "Teclado Mecânico K95 RGB":
                return "149.90";
            case "Monitor UltraSharp u2719d":
                return "349.99";
            case "Fone de Ouvido WH-1000XM$":
                return "299.99";
            case "Impressora Laserjet PRO M404dn":
                return "199.99";
            case "Processador I9-11900K":
                return "499.99";
            case "Placa de vídeo GeForce RTX3080":
                return "799.99";
            case "Memória RAM Vengeance LPX 32GB":
                return "129.99";
            case "Disco rígido (HD) 2TB":
                return "69.99";
            case "SSD 970 EVO 1TB":
                return "149.99";
            default:
                return "Preço não disponível";
        }
    }

    private void exibirImagem(String produto) {
        String caminhoImagem = caminhoImagens.get(produto);
        if (caminhoImagem != null) {
            ImageIcon imagemIcon = new ImageIcon(getClass().getResource(caminhoImagem));
            // Redimensiona a imagem para 200x200 pixels
            Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH);
            imagemIcon = new ImageIcon(imagemRedimensionada);
            imagemLabel.setIcon(imagemIcon);
        } else {
            imagemLabel.setIcon(null);
        }
    }

    private void atualizarRotuloQuantidade() {
        int totalItens = carrinho.values().stream().mapToInt(Integer::intValue).sum();
        quantidadeLabel.setText("Itens no Carrinho: " + totalItens);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LojaDePerifericosGUI();
            }
        });
    }
}
