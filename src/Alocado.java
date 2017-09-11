package system;

import java.util.ArrayList;
import java.util.Date;

public class Alocado implements RecursoState {
    Banco banco = new Banco();
    ArrayList<Recurso> recursos = banco.getlRecursos();

    @Override
    public RecursoState recursoAlocado(Recurso r){
        System.out.println("Recuso ja esta alocado");
        return this;
    }

    @Override
    public RecursoState recursoEmAndamento(Recurso r){
        if(contRecursoAlocadosUser(r.getResponsavel().getId())==0){
            Date date = new Date();
            if(date.getYear() <= r.getData_inicio().getYear()) {
                if(date.getMonth()<= r.getData_inicio().getMonth()) {
                    if(date.getDay()< r.getData_inicio().getDay()){
                        System.out.println("Operacao realizada com sucesso! Recurso em Andamento!");
                        r.setStatus("Em andamento");
                        banco.setStatus(r);
                        return new Em_andamento();
                    }
                    else if(date.getDay() == r.getData_inicio().getDay()) {
                        if(date.getHours()<= r.getHora_inicio().getHours()) {
                            if(date.getMinutes() <= r.getHora_inicio().getMinutes()) {
                                System.out.println("Operacao realizada com sucesso! Recurso em Andamento!");
                                r.setStatus("Em andamento");
                                banco.setStatus(r);
                                return new Em_andamento();
                            }
                            else {
                                System.out.println("Operacao nao permitida! Data e/ou horas nao sao mais validos!");
                                return this;
                            }
                        }
                        else {
                            System.out.println("Operacao nao permitida! Data e/ou horas nao sao mais validos!");
                            return this;
                        }
                    }
                    else {
                        System.out.println("Operacao nao permitida! Data e/ou horas nao sao mais validos!");
                        return this;
                    }
                }
                else {
                    System.out.println("Operacao nao permitida! Data e/ou horas nao sao mais validos!");
                    return this;
                }
            }

            else
            {
                System.out.println("Operacao nao permitida! Data e/ou horas nao sao mais validos!");
                return this;
            }
        }
        else {
            System.out.println("Operacao nao permitida! Usuario com mais de um recurso em andamento");
            return this;
        }
    }

    @Override
    public RecursoState recursoConcluido(Recurso r){
        System.out.println("Operacao nao permitada!");
        return this;
    }

    //Verificar numero de recursos em andamento do usuario
    public int contRecursoAlocadosUser(int idUser) {
        int contRA = 0;
        for(int i = 0;i<recursos.size();i++) {
            if(recursos.get(i).getResponsavel().getId() == idUser && recursos.get(i).getStatus().toUpperCase().equals("EM ANDAMENTO")) {
                contRA++;
            }
        }
        return contRA;
    }

    @Override
    public RecursoState recursoEmAlocacao(Recurso r) {
        System.out.println("Recurso ja foi alterado para Em andamento!");
        return null;
    }
}
