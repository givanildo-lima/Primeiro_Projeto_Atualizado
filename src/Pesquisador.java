package system;

public class Pesquisador extends UserPrototype{

    public Pesquisador(String name, String email) {
        super(name, email);
    }

    @Override
    public Recurso alocarRecurso(Recurso r) {
        if(!r.getAtividade().getTipo().toUpperCase().equals("APRESENTACOES")) {
            System.out.println("Recurso indisponivel para alocacao! Pesquisadores so podem alocar Apresentacoes");
            return null;
        }

        else {
            System.out.println("Recurso disponivel para alocacao! Entrando em processo de alocacao! ");
            return r;
        }
    }
}
