
public class Alocado implements RecursoState {
	
	@Override
	public RecursoState recursoAlocado(){
		//Não faz nada
	}
	
	@Override
	public RecursoState recursoEmAndamento(){
		System.out.println("Recurso em Andamento");
		return new Em_andamento();
	}
	
	@Override
	public RecursoState recursoConcluido(){
		//Não existe essa transição direta
	}
}
