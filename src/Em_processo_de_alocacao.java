import Recurso.RecursoState;


public class Em_processo_de_alocacao implements RecursoState{
	
	@Override
	public RecursoState recursoAlocado(){
		System.out.println("Recurso alocado com sucesso.");
		return new Alocado();
	}
	
	@Override
	public RecursoState recursoEmAndamento(){
		//Não existe essa transição direta
	}
	
	@Override
	public RecursoState recursoConcluido(){
		//Não existe essa transição direta
	}
	
}
