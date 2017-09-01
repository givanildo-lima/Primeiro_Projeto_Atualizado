import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String email;
	private String recurso;
	private String atividade;
	
	public Usuario(String nome, String email, String recurso, String atividade) {
		super();
		this.nome = nome;
		this.email = email;
		this.recurso = recurso;
		this.atividade = atividade;
	}
	
	ArrayList<Usuario> lUsuario = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
	//1 - Adicionar Usuário
	public static void addU(Usuario f) {
		lUsuario.add(f); //Aqui o usuario eh adicionado na lista geral de todos os tipos de funcionarios
		System.out.println("Funcionario "+f.getNome()+" cadastrado com sucesso!");
	}
	
	
	
}
