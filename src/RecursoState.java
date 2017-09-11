package system;

public interface RecursoState {
    public RecursoState recursoEmAlocacao(Recurso r);
    public RecursoState recursoAlocado(Recurso r);
    public RecursoState recursoEmAndamento(Recurso r);
    public RecursoState recursoConcluido(Recurso r);
}
