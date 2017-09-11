package system;

public class Aluno extends UserPrototype{

    public Aluno(String name, String email) {
        super(name, email);
    }

    @Override
    public Recurso alocarRecurso(Recurso r) {
        if(!r.getAtividade().getTipo().toUpperCase().equals("APRESENTACOES")) {
            System.out.println("Recurso indisponivel para alocacao! Alunos so podem alocar Apresentacoes");
            return null;
        }

        else {
            System.out.println("Recurso disponivel para alocacao! Entrando em processo de alocacao!");
            return r;
        }
    }

}
