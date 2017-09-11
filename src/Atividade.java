package system;

import java.util.ArrayList;

import system.UserPrototype;

public class Atividade {
    private String tipo;
    private String titulo;
    private String descricao;
    private ArrayList<UserPrototype> participantes;
    private String material;
    private UserPrototype responsavel;

    public Atividade(String tipo, String titulo, String descricao,
                     ArrayList<UserPrototype> participantes, String material, UserPrototype responsavel) {
        super();
        this.tipo = tipo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.participantes = participantes;
        this.material = material;
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "\nDescricao: " + descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ArrayList<UserPrototype> getParticipantes() {
        return participantes;
    }
    public void setParticipantes(ArrayList<UserPrototype> participantes) {
        this.participantes = participantes;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public UserPrototype getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(UserPrototype responsavel) {
        this.responsavel = responsavel;
    }
}
