package system;

public class Concluido implements RecursoState{

    @Override
    public RecursoState recursoAlocado(Recurso r) {
        System.out.println("Operacao nao permitida!");
        return new Alocado();
    }

    @Override
    public RecursoState recursoEmAndamento(Recurso r) {
        System.out.println("Operacao nao permitida!");
        return new Em_andamento();
    }

    @Override
    public RecursoState recursoConcluido(Recurso r) {
        System.out.println("Este recurso ja esta concluido!");
        return this;
    }

    @Override
    public RecursoState recursoEmAlocacao(Recurso r) {
        // TODO Auto-generated method stub
        return null;
    }
}
