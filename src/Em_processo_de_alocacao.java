package system;


public class Em_processo_de_alocacao implements RecursoState {
    Banco banco = new Banco();

    @Override
    public RecursoState recursoAlocado(Recurso r) {
        //Verifica se os dados foram preenchidos
        if(r.getAtividade()!=null && r.getResponsavel()!= null && r.getData_fim()!= null && r.getData_inicio()!=null
                && r.getHora_inicio()!=null && r.getHora_fim()!=null)
        {
            System.out.println("Operacao realizada com sucesso! Recurso alocado!");
            r.setStatus("Alocado");
            banco.setStatus(r);
            return new Alocado();
        }
        else {
            System.out.println("Operacao nao permitida! Nao foi possivel alocar o recurso!");
            return this;
        }

    }

    @Override
    public RecursoState recursoEmAndamento(Recurso r) {
        System.out.println("Operacao nao permitida!");
        return this;
    }

    @Override
    public RecursoState recursoConcluido(Recurso r) {
        System.out.println("Operacao nao permitida!");
        return this;
    }

    @Override
    public RecursoState recursoEmAlocacao(Recurso r) {
        // TODO Auto-generated method stub
        return null;
    }
}
