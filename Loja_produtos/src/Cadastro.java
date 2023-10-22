import java.util.Scanner ;

public class Cadastro extends Cliente{

    protected String usuario;
    protected String senha;
    protected String confirmarSenha;

    public Cadastro (String usuario, String senha, String confirmarSenha, String nome, int cpf){
        super(nome, cpf);
        this.usuario = usuario;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }
    
    void cadastrar(){
        
    }
   

}
