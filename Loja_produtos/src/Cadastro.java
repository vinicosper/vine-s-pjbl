import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends Cliente {

    private String usuario;
    private String senha;

    public Cadastro(String usuario, String senha, String nome, int cpf, String numeroCartao) {
        super(nome,cpf, numeroCartao);
        this.usuario = usuario;
        this.senha = senha;
    }

    public void cadastrar() {
        String url = "jdbc:mysql://seuservidor:porta/seubanco";
        String username = "seuusuario";
        String password = "suasenha";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO clientes (nome, cpf, usuario, senha) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, this.nome);
                preparedStatement.setInt(2, this.cpf);
                preparedStatement.setString(3, this.usuario);
                preparedStatement.setString(4, this.senha);

                preparedStatement.executeUpdate();
                System.out.println("Cliente cadastrado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Cadastro de Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        frame.add(panel);

        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField(20);

        JLabel cpfLabel = new JLabel("CPF:");
        JTextField cpfField = new JTextField(20);

        JLabel usuarioLabel = new JLabel("Usuário:");
        JTextField usuarioField = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha:");
        JPasswordField senhaField = new JPasswordField(20);

        JButton cadastrarButton = new JButton("Cadastrar");

        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                int cpf = Integer.parseInt(cpfField.getText());
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                Cadastro cliente = new Cadastro(usuario, senha, nome, cpf);
                cliente.cadastrar();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}
