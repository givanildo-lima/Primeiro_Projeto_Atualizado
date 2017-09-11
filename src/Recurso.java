package system;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import system.UserPrototype;

public class Recurso {

    private int identification;
    private Date data_inicio;
    private Date  data_fim;
    private Time  hora_inicio;
    private Time hora_fim;
    private UserPrototype responsavel;
    private Atividade atividade;
    private String status;
    private RecursoState estado;

    public Recurso(){

    }

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt","BR"));
        return 	"Id: " + identification + "\nData de inicio: " +df.format(data_inicio)
                + "\nData de termino: " + df.format(data_fim) + "\nHora de inicio: "
                + hora_inicio + "\nHora de termino: " + hora_fim + "\nResponsavel: "
                + responsavel.getName() + "\nAtividade: " + atividade.getTitulo()+"\nStatus: "+status+"";
    }

    public Recurso(int identification, Date data_inicio, Date data_fim,
                   Time hora_inicio, Time hora_fim, UserPrototype responsavel,
                   Atividade atividade, String status) {
        super();
        this.identification = identification;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.responsavel = responsavel;
        this.atividade = atividade;
        this.status = status;
        estado = new Em_processo_de_alocacao();
    }

    public Recurso(int identification, Date data_inicio, Date data_fim,
                   Time hora_inicio, Time hora_fim, UserPrototype responsavel) {
        super();
        this.identification = identification;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.responsavel = responsavel;
    }

    public int getIdentification() {
        return identification;
    }


    public void setIdentification(int identification) {
        this.identification = identification;
    }


    public UserPrototype getResponsavel() {
        return responsavel;
    }


    public void setResponsavel(UserPrototype responsavel) {
        this.responsavel = responsavel;
    }


    public Atividade getAtividade() {
        return atividade;
    }


    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public Time getHora_fim() {
        return hora_fim;
    }

    public RecursoState getEstado() {
        return estado;
    }

    public void recursoEmAlocacao(Recurso r) {
        estado = estado.recursoAlocado(r);
    }
    public void recursoAlocado(Recurso r){
        estado = estado.recursoEmAndamento(r);
    }
    public void recursoEmAndamento(Recurso r) {
        estado = estado.recursoConcluido(r);
    }
    //public void recursoConcluido() {
    //estado = estado.recursoConcluido(this);
    //}
}
