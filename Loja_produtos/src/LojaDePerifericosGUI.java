import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LojaDePerifericosGUI extends JFrame {

    private Map<String, String> descricaoProdutos;
    private JTextArea descricaoTextArea;
    private JLabel precoLabel;
    private DefaultListModel<String> produtosListModel;
    private JList<String> produtosList;

    public LojaDePerifericosGUI() {
        setTitle("Loja de Periféricos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        descricaoProdutos = new HashMap<>();
        descricaoProdutos.put("Mouse MX Master 3", "Mouse premium com rastreamento de alta precisão");
        descricaoProdutos.put("Teclado Mecânico K95 RGB", "Teclado mecânico com iluminação RGB personalizável");
        descricaoProdutos.put("Monitor UltraSharp u2719d", "Monitor de 27'' com resolução 2k e cores precisas");
        descricaoProdutos.put("Fone de Ouvido WH-1000XM$", "Fones de ouvido com cancelamento de ruído e qualidade de áudio excepcional");
        descricaoProdutos.put("Impressora Laserjet PRO M404dn", "Impressora de jato de tinta com tanques de tinta recarregáveis");
        descricaoProdutos.put("Processador I9-11900K", "Processador de alta performance com 8 núcleos");
        descricaoProdutos.put("Placa de vídeo GeForce RTX3080", "Placa de vídeo de última geração com ray tracing");
        descricaoProdutos.put("Memória RAM Vengeance LPX 32GB", "Módulos de memória DDR4 de alta velocidade");
        descricaoProdutos.put("Disco rígido (HD) 2TB", "Disco rígido de 2 Terabytes para armazenamento");
        descricaoProdutos.put("SSD 970 EVO 1TB", "SSD NVMe de alta velocidade para melhorar o desempenho");

        // Painel superior com rótulo de boas-vindas
        JLabel boasVindasLabel = new JLabel("Bem-vindo à Loja de Periféricos");
        boasVindasLabel.setHorizontalAlignment(JLabel.CENTER);
        add(boasVindasLabel, BorderLayout.NORTH);

        // Botão "Itens de Hardware" na parte superior
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

        // Botão "Itens Periféricos" na parte superior
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

        // Adicione os botões na parte superior
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(hardwareButton);
        buttonsPanel.add(perifericosButton);
        add(buttonsPanel, BorderLayout.NORTH);

        // Painel central com lista de produtos
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
                    }
                } else {
                    descricaoTextArea.setText("");
                    precoLabel.setText("Preço:");
                }
            }
        });

        JScrollPane produtosScrollPane = new JScrollPane(produtosList);
        add(produtosScrollPane, BorderLayout.WEST);

        // Painel com descrição e preço
        JPanel descricaoPrecoPanel = new JPanel(new GridBagLayout());
        descricaoTextArea = new JTextArea(5, 40);
        descricaoTextArea.setWrapStyleWord(true);
        descricaoTextArea.setLineWrap(true);
        descricaoTextArea.setOpaque(false);
        descricaoTextArea.setEditable(false);
        descricaoTextArea.setFont(new Font("SansSerif", Font.PLAIN, 24)); // Define a fonte para 24px
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        descricaoPrecoPanel.add(descricaoTextArea, c);
        c.gridy = 1;
        precoLabel = new JLabel("Preço:");
        descricaoPrecoPanel.add(precoLabel, c);

        add(descricaoPrecoPanel, BorderLayout.CENTER);

        // Botão "Adicionar ao Carrinho" na parte inferior
        JButton adicionarAoCarrinhoButton = new JButton("Adicionar ao Carrinho");
        adicionarAoCarrinhoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = produtosList.getSelectedValue();
                if (selectedItem != null) {
                    // Lógica para adicionar o item ao carrinho
                    // Implemente a lógica de carrinho de compras conforme necessário
                    // Por exemplo, exiba um JOptionPane para confirmar a adição ao carrinho.
                    JOptionPane.showMessageDialog(null, "Você adicionou " + selectedItem + " ao carrinho.");
                }else{
                    JOptionPane.showMessageDialog(null, "selecione um item");
             
                }
            }
        });

        add(adicionarAoCarrinhoButton, BorderLayout.SOUTH); // Posiciona o botão na parte inferior

        setVisible(true);
    }

    private String obterPrecoProduto(String produto) {
        // Implemente a lógica para obter o preço do produto com base no nome do produto.
        // Para este exemplo, estou retornando preços fixos com base nos nomes.
        switch (produto) {
            case "Mouse MX Master 3":
                return "79.99";
            case "Teclado Mecânico K95 RGB":
                return "149.90";
            case "Monitor UltraSharp u2719d":
                return "349.99";
            case "Fone de Ouvido WHi-1000XM$":
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LojaDePerifericosGUI();
            }
        });
    }
}
