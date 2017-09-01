
public class Recurso{
	
	private String identification;
	int data_inicio;
	int data_fim;
	int hora_inicio;
	int hora_fim;
	private String responsavel;
	private String atividade;
	
	public interface RecursoState {
		RecursoState recursoAlocado();
		RecursoState recursoEmAndamento();
		RecursoState recursoConcluido();
	}
	
	public Recurso(){
		
	}
	
	public Recurso(String identification, int data_inicio, int data_fim,
			int hora_inicio, int hora_fim, String responsavel, String atividade) {
		super();
		this.identification = identification;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
		this.responsavel = responsavel;
		this.atividade = atividade;
	}


	public String getIdentification() {
		return identification;
	}


	public void setIdentification(String identification) {
		this.identification = identification;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public String getAtividade() {
		return atividade;
	}


	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
	
}
