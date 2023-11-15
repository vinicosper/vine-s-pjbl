import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class LojaDePerifericosGUI extends JFrame {
    private Map<String, Produto> produtos;
    private Map<String, String> descricaoProdutos;
    private Map<String, Integer> carrinho;
    private Map<String, String> caminhoImagens;
    private JTextArea descricaoTextArea;
    private JLabel precoLabel;
    private JLabel quantidadeLabel;
    private JLabel imagemLabel;
    private DefaultListModel<String> produtosListModel;
    private JList<String> produtosList;

    private Connection connection;

    public LojaDePerifericosGUI() {
        conectarBancoDeDados();
        inicializarComponentes();
    }

    private void conectarBancoDeDados() {
        try {
            // Utiliza a classe Conexao para obter a conexão com o banco de dados
            connection = Conexao.getConexao();
            if (connection == null || connection.isClosed()) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.");
                System.exit(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.");
            System.exit(1);
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    
    public void exibirTela() {
        setVisible(true);
    }

    private void inicializarComponentes() {
        setTitle("Loja de Periféricos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.put("OptionPane.background", Color.WHITE);
        UIManager.put("Panel.background", Color.WHITE);

        // Dentro do método inicializarComponentes da classe LojaDePerifericosGUI

        // Inicializar o mapa de produtos vazio
        produtos = new HashMap<>();

        try {
            Connection conn = Conexao.getConexao();

            // Consulta para periféricos
            String perifericosQuery = "SELECT * FROM perifericos";
            PreparedStatement perifericosStmt = conn.prepareStatement(perifericosQuery);
            ResultSet perifericosRS = perifericosStmt.executeQuery();

            while (perifericosRS.next()) {
                int id = perifericosRS.getInt("ID_periferico");
                String nome = perifericosRS.getString("nome_per");
                Double preco = perifericosRS.getDouble("preco");
                int quantidade = perifericosRS.getInt("quantidade");
                String descricao = perifericosRS.getString("descricao");
                String marca = perifericosRS.getString("marca");

                produtos.put(nome, new Perifericos(id, nome, preco, quantidade, descricao, marca));
            }

            // Consulta para hardware
            String hardwareQuery = "SELECT * FROM hardware";
            PreparedStatement hardwareStmt = conn.prepareStatement(hardwareQuery);
            ResultSet hardwareRS = hardwareStmt.executeQuery();

            while (hardwareRS.next()) {
                int id = hardwareRS.getInt("ID_Hardware");
                String nome = hardwareRS.getString("Nome_Har");
                Double preco = hardwareRS.getDouble("preco");
                int quantidade = hardwareRS.getInt("quantidade");
                String descricao = hardwareRS.getString("descricao");
                String marca = hardwareRS.getString("marca");

                produtos.put(nome, new Hardware(id, nome, preco, quantidade, descricao, marca));
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
        descricaoProdutos.put("Disco rigido(HD) 2TB", "Disco rígido de 2 Terabytes para armazenamento");
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
        caminhoImagens.put("Disco rigido(HD) 2TB", "hd.jpeg");
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
                produtosListModel.addElement("Disco rigido(HD) 2TB");
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
        produtosListModel.addElement("Disco rigido(HD) 2TB");
        produtosListModel.addElement("SSD 970 EVO 1TB");
        // Adicione outros produtos conforme necessário

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
                double total = calcularTotalCompra();
                if (total > 0) {
                    exibirResumoCompra(total);
                    atualizarQuantidadeNoBanco(carrinho); // Atualiza a quantidade no banco de dados
                    carrinho.clear();
                    atualizarRotuloQuantidade();
                    SwingUtilities.invokeLater(() -> {
                        new TelaPagamento(total);
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Seu carrinho está vazio. Adicione itens para continuar.");
                }
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
        try {
            Connection conn = Conexao.getConexao();
            String preco = "Preço não disponível";

            String queryPerifericos = "SELECT preco FROM perifericos WHERE nome_per = ?";
            PreparedStatement stmtPerifericos = conn.prepareStatement(queryPerifericos);
            stmtPerifericos.setString(1, produto);
            ResultSet rsPerifericos = stmtPerifericos.executeQuery();

            if (rsPerifericos.next()) {
                double precoPeriferico = rsPerifericos.getDouble("preco");
                preco = String.format("%.2f", precoPeriferico);
            } else {
                String queryHardware = "SELECT preco FROM hardware WHERE Nome_Har LIKE ?";
                PreparedStatement stmtHardware = conn.prepareStatement(queryHardware);
                stmtHardware.setString(1, "%" + produto + "%");
                ResultSet rsHardware = stmtHardware.executeQuery();

                if (rsHardware.next()) {
                    double precoHardware = rsHardware.getDouble("preco");
                    preco = String.format("%.2f", precoHardware);
                }
            }

            return preco;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao obter preço";
        }
    }

    private void exibirImagem(String produto) {
        String caminhoImagem = caminhoImagens.get(produto);
        if (caminhoImagem != null) {
            ImageIcon imagemIcon = new ImageIcon(getClass().getResource(caminhoImagem));
            Image imagemRedimensionada = imagemIcon.getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH);
            imagemIcon = new ImageIcon(imagemRedimensionada);
            imagemLabel.setIcon(imagemIcon);
        } else {
            imagemLabel.setIcon(null);
        }
    }

    private double calcularTotalCompra() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
            String produto = entry.getKey();
            int quantidade = entry.getValue();
            String precoString = obterPrecoProduto(produto);
            precoString = precoString.replace(",", "."); // Substituir vírgula por ponto
            double precoUnitario = Double.parseDouble(precoString);
            total += quantidade * precoUnitario;
        }
        return total;
    }

    private void exibirResumoCompra(double total) {
        StringBuilder mensagem = new StringBuilder("Itens no Carrinho:\n");
        for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
            String produto = entry.getKey();
            int quantidade = entry.getValue();
            mensagem.append(produto).append(" x ").append(quantidade).append("\n");
        }
        mensagem.append("\nTotal: R$ ").append(total);
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    private void atualizarQuantidadeNoBanco(Map<String, Integer> carrinho) {
        try {
            Connection conn = Conexao.getConexao();

            for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
                String produto = entry.getKey();
                int quantidadeComprada = entry.getValue();

                // Atualizar a quantidade no banco de dados
                String updateQuery = "UPDATE perifericos SET quantidade = quantidade - ? WHERE nome_per = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setInt(1, quantidadeComprada);
                updateStmt.setString(2, produto);
                updateStmt.executeUpdate();
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
