import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeLoginCadastro extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public TelaDeLoginCadastro() {
        setTitle("Login e Cadastro de Cliente");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Nome de usuário:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Senha:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        registerButton = new JButton("Cadastrar");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui a lógica de autenticação.
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abra a tela de cadastro
                TelaCadastroCliente cadastroCliente = new TelaCadastroCliente();
                cadastroCliente.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaDeLoginCadastro tela = new TelaDeLoginCadastro();
                tela.setVisible(true);
            }
        });
    }
}

class TelaCadastroCliente extends JFrame {
    private JTextField newUserField;
    private JPasswordField newPasswordField;
    private JTextField cpfField;
    private JTextField creditCardField;
    private JButton cadastrarButton;

    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela de cadastro
        setLayout(new GridLayout(6, 2));

        JLabel newUserLabel = new JLabel("Novo usuário:");
        newUserField = new JTextField();
        JLabel newPasswordLabel = new JLabel("Nova senha:");
        newPasswordField = new JPasswordField();
        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField();
        JLabel creditCardLabel = new JLabel("Número do cartão de crédito:");
        creditCardField = new JTextField();
        cadastrarButton = new JButton("Cadastrar");

        add(newUserLabel);
        add(newUserField);
        add(newPasswordLabel);
        add(newPasswordField);
        add(cpfLabel);
        add(cpfField);
        add(creditCardLabel);
        add(creditCardField);
        add(new JLabel()); // Espaço em branco
        add(cadastrarButton);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione aqui a lógica para registrar o cliente com as informações fornecidas.
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                dispose(); // Fecha a janela de cadastro após o registro.
            }
        });
    }
}
