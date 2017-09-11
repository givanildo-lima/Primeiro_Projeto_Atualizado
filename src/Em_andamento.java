package system;

public class Em_andamento implements RecursoState {
    Banco banco = new Banco();

    @Override
    public RecursoState recursoAlocado(Recurso r) {
        System.out.println("Operacao nao permitida!");
        return this;
    }

    @Override
    public RecursoState recursoEmAndamento(Recurso r) {
        System.out.println("Recuso ja esta em andamento!");
        return this;
    }

    @Override
    public RecursoState recursoConcluido(Recurso r) {
        if(r.getAtividade() != null || r.getAtividade().getDescricao() != "" || r.getAtividade().getDescricao() != null) {
            System.out.println("Operacao realizada com sucesso! Recurso concluido!");
            r.setStatus("Concluido");
            banco.setStatus(r);
            return new Concluido();
        }
        else {
            System.out.println("Operacao nao permitida! A atividade nao possui descricao!");
            return this;
        }
    }

    @Override
    public RecursoState recursoEmAlocacao(Recurso r) {
        // TODO Auto-generated method stub
        return null;
    }

}
