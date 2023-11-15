import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            iniciarTelaLoginCadastro();
        });
    }

    private static void iniciarTelaLoginCadastro() {
        TelaLoginCadastro telaLoginCadastro = new TelaLoginCadastro();
        telaLoginCadastro.setVisible(true);
    }
}
