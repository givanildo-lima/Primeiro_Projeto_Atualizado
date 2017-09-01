import java.util.Scanner;

public class Sistema {

	public Sistema() {
		
	}

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Recurso recurso = new Recurso();
		System.out.println("Qual recurso voce deseja alocar?");
		String ident = scanner.nextLine();
		recurso.setIdentification(ident);
		System.out.println("Digite a data de inicio:");
		recurso.data_inicio = scanner.nextInt();
		System.out.println("Digite a data de fim:");
		recurso.data_fim = scanner.nextInt();
		System.out.println("Digite o seu nome");
		String name = scanner.nextLine();
		recurso.setResponsavel(name);
		System.out.println("Digite qual atividade você vai realizar:");
		String atv = scanner.nextLine();
		recurso.setAtividade(atv);
		System.out.println("Qual seu email?");
		String email = scanner.nextLine();
		
		Usuario usuario = new Usuario(name, email, ident, atv);
		Usuario.addU(usuario);

	}

}



	
	
	
	