package system;

public class Professor extends UserPrototype{

    public Professor(String name, String email) {
        super(name, email);
    }

    @Override
    public Recurso alocarRecurso(Recurso r) {
        System.out.println("Recurso disponivel para alocacao! Entrando em processo de alocacao!");
        return r;
    }
}
