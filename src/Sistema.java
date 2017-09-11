package system;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import system.UserPrototype;

public class Sistema {
    static Banco banco = new Banco();

    public static void main(String[] args) throws ParseException{
        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        int login;

        while(true) {
            System.out.println("_______________________________________________________________");

            System.out.println("Bem Vindo ao Sistema de Alocacao de Recursos Academicos! \n" +
                    "Identifique-se para prosseguir:" +
                    "\n1 - Administrador: \n2 - Aluno (Graduando/Mestrando/Doutorando):" +
                    "\n3 - Pesquisador:\n4 - Professor:");
            System.out.println("_______________________________________________________________");
            login = Integer.parseInt(sc.nextLine());


            if(login == 1) {
                while(true) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("Bem Vindo, Administrador! \n" +
                            "Digite uma operação:\n1 - Cadastrar usuario:\n2 - Alocar recurso:" +
                            "\n3 - Consultar usuario:\n4 - Consultar recurso:\n5 - Relatório de atividades:" +
                            "\n6 - Alterar status: \n7 - Confirmar alocacao: \n8 - SAIR:");
                    System.out.println("_______________________________________________________________");
                    opcao = Integer.parseInt(sc.nextLine());
                    if(opcao == 8){
                        break;
                    }
                    operacoesAdm(opcao);
                }
            }
            else if(login == 2) {
                while(true) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("Bem Vindo, Aluno! \n" +
                            "Digite uma operação:\n1 - Alocar recurso:" +
                            "\n2 - Consultar usuario:\n3 - Consultar recurso:\n4 - Relatório de atividades:" +
                            "\n5 - Confirmar alocacao:\n6 - SAIR:");
                    System.out.println("_______________________________________________________________");
                    opcao = Integer.parseInt(sc.nextLine());
                    if(opcao == 6){
                        break;
                    }
                    operacoesUsers(opcao);
                }
            }
            else if(login == 3) {
                while(true) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("Bem Vindo, Pesquisador! \n" +
                            "Digite uma operação:\n1 - Alocar recurso:" +
                            "\n2 - Consultar usuario:\n3 - Consultar recurso:\n4 - Relatório de atividades:" +
                            "\n5 - Confirmar alocacao:\n6 - SAIR:");
                    System.out.println("_______________________________________________________________");
                    opcao = Integer.parseInt(sc.nextLine());
                    if(opcao == 6){
                        break;
                    }
                    operacoesUsers(opcao);
                }
            }
            else if(login == 4) {
                while(true) {
                    System.out.println("_______________________________________________________________");
                    System.out.println("Bem Vindo, Professor! \n" +
                            "Digite uma operação:\n1 - Alocar recurso:" +
                            "\n2 - Consultar usuario:\n3 - Consultar recurso:\n4 - Relatório de atividades:" +
                            "\n5 - Confirmar alocacao:\n6 - SAIR:");
                    System.out.println("_______________________________________________________________");
                    opcao = Integer.parseInt(sc.nextLine());
                    if(opcao == 6){
                        break;
                    }
                    operacoesUsers(opcao);
                }
            }
        }
    }

    //OPERACOES ADMINISTRADOR
    public static void operacoesAdm(int opcao) throws ParseException {
        Scanner sc = new Scanner(System.in);
        switch(opcao) {
            case 1:
                System.out.println("Digite seu nome:");
                String nome = sc.nextLine();
                System.out.println("Digite seu email:");
                String email = sc.nextLine();
                System.out.println("Informe o tipo de usuario:"  +
                        "\n1 - Aluno (Graduando/Mestrando/Doutorando):" +
                        "\n2 - Pesquisador:\n3 - Professor:");
                int type = Integer.parseInt(sc.nextLine());
                if(type == 1) {
                    banco.addUser(new Aluno(nome,email));
                }
                else if (type == 2) {
                    banco.addUser(new Pesquisador(nome,email));
                }
                else if (type == 3) {
                    banco.addUser(new Professor(nome,email));
                }
                break;
            case 2:
                System.out.println("(*)Datas no formato 'dd/MM/yyyy' e hora 'HH:mm'" +
                        "\nData de inicio:");
                String dataInicio = sc.nextLine();
                System.out.println("Data de termino:");
                String dataTermino = sc.nextLine();
                System.out.println("Hora de inicio:");
                String horaInicio = sc.nextLine();
                System.out.println("Hora de termino:");
                String horaTermino = sc.nextLine();
                System.out.println("Id do responsavel:");
                int idUser = Integer.parseInt(sc.nextLine());
                UserPrototype responsavel = banco.searchUser(idUser);
                System.out.println("(**)Detalhe a seguir atividade associada a este recurso" +
                        "\nTipo (Aula/Apresentacoes/Laboratorio):");
                String tipo = sc.nextLine();
                System.out.println("Titulo:");
                String titulo = sc.nextLine();
                System.out.println("Descricao:");
                String descricao = sc.nextLine();
                System.out.println("Material de apoio:");
                String material = sc.nextLine();
                System.out.println("(***)Informe a seguir os participantes da atividade, mas primeiro informa a quantidade: ");
                int quant = Integer.parseInt(sc.nextLine());

                ArrayList<UserPrototype> participantes = new ArrayList<>();
                int idParticipante;
                System.out.println("Informe os idS dos participantes (um por linha):");
                for(int i=0;i<quant;i++)
                {
                    idParticipante = Integer.parseInt(sc.nextLine());
                    participantes.add(banco.searchUser(idParticipante));
                }
                Atividade atividade = new Atividade(tipo,titulo,descricao,participantes,material,responsavel);

                banco.addRecurso(dataInicio, dataTermino, horaInicio, horaTermino, responsavel,atividade);
                break;
            case 3:
                System.out.println("Digite o id do usuario:");
                int getId = Integer.parseInt(sc.nextLine());
                banco.getUser(getId);
                break;
            case 4:
                System.out.println("Digite o tipo recurso:\n1 - Aula\n2 - Apresentacoes\n3 - Laboratorio:");
                int tipoRecurso = Integer.parseInt(sc.nextLine());
                banco.getRecurso(tipoRecurso);
                break;
            case 5:
                banco.relAtividades();
                break;
            case 6:
                System.out.println("Informe o id do recurso: ");
                int idRecurso = Integer.parseInt(sc.nextLine());
                Recurso r = banco.searchRecurso(idRecurso);
                if(r.getStatus().toUpperCase().equals("EM PROCESSO DE ALOCACAO")) {
                    System.out.println("Recurso em processo de alocacao, deseja alterar para Alocado? (1-SIM/2-NAO)");
                    int op = Integer.parseInt(sc.nextLine());
                    if(op == 1 ) {
                        r.recursoEmAlocacao(r);
                    }
                }
                else if(r.getStatus().toUpperCase().equals("EM ANDAMENTO")) {
                    System.out.println("Recurso em andamento, deseja alterar para Concluido? (1-SIM/2-NAO)");
                    int op = Integer.parseInt(sc.nextLine());
                    if(op == 1 ) {
                        r.recursoEmAndamento(r);
                    }
                }
                else if(r.getStatus().toUpperCase().equals("ALOCADO")) {
                    System.out.println("Recurso Alocado! Confirme primeiro a alocacao!");
                }
                else {
                    System.out.println("Recurso ja se encontra em status Concluido! Nao eh possivel realizar mais alteracoes!");
                }
                break;
            case 7:
                System.out.println("Informe o id do recurso: ");
                int idRec = Integer.parseInt(sc.nextLine());
                Recurso rU = banco.searchRecurso(idRec);
                if(rU.getStatus().toUpperCase().equals("ALOCADO")) {
                    System.out.println("Recurso alocado, deseja alterar para Em andamento? (1-SIM/2-NAO)");
                    int op = Integer.parseInt(sc.nextLine());
                    if(op == 1 ) {
                        rU.recursoAlocado(rU);
                    }
                }
                else {
                    System.out.println("Nao foi possivel realizar esta alteracao, recurso encontra-se "+rU.getStatus()+"!");
                }
                break;
            case 8:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Desculpe, mas parace que voce escolheu uma opcao indisponivel" +
                        ", por favor, tente novamente!");
        }
    }

    //OPERACOES ALUNO/PROFESSOR/PESQUISADOR
    public static void operacoesUsers(int opcao) throws ParseException {
        Scanner sc = new Scanner(System.in);
        switch(opcao) {
            case 1:
                System.out.println("(*)Datas no formato 'dd/MM/yyyy' e hora 'HH:mm'" +
                        "\nData de inicio:");
                String dataInicio = sc.nextLine();
                System.out.println("Data de termino:");
                String dataTermino = sc.nextLine();
                System.out.println("Hora de inicio:");
                String horaInicio = sc.nextLine();
                System.out.println("Hora de termino:");
                String horaTermino = sc.nextLine();
                System.out.println("Id do responsavel:");
                int idUser = Integer.parseInt(sc.nextLine());
                UserPrototype responsavel = banco.searchUser(idUser);
                System.out.println("(**)Detalhe a seguir atividade associada a este recurso" +
                        "\nTipo (Aula/Apresentacoes/Laboratorio):");
                String tipo = sc.nextLine();
                System.out.println("Titulo:");
                String titulo = sc.nextLine();
                System.out.println("Descricao:");
                String descricao = sc.nextLine();
                System.out.println("Material de apoio:");
                String material = sc.nextLine();
                System.out.println("(***)Informe a seguir os participantes da atividade, mas primeiro informa a quantidade: ");
                int quant = Integer.parseInt(sc.nextLine());

                ArrayList<UserPrototype> participantes = new ArrayList<>();
                int idParticipante;
                System.out.println("Informe os idS dos participantes (um por linha):");
                for(int i=0;i<quant;i++)
                {
                    idParticipante = Integer.parseInt(sc.nextLine());
                    participantes.add(banco.searchUser(idParticipante));
                }
                Atividade atividade = new Atividade(tipo,titulo,descricao,participantes,material,responsavel);

                banco.addRecurso(dataInicio, dataTermino, horaInicio, horaTermino, responsavel,atividade);
                break;
            case 2:
                System.out.println("Digite o id do usuario:");
                int getId = Integer.parseInt(sc.nextLine());
                banco.getUser(getId);
                break;
            case 3:
                System.out.println("Digite o tipo recurso:\n1 - Aula\n2 - Apresentacoes\n3 - Laboratorio:");
                int tipoRecurso = Integer.parseInt(sc.nextLine());
                banco.getRecurso(tipoRecurso);
                break;
            case 4:
                banco.relAtividades();
                break;
            case 5:
                System.out.println("Informe o id do recurso: ");
                int idRec = Integer.parseInt(sc.nextLine());
                Recurso rU = banco.searchRecurso(idRec);
                if(rU.getStatus().toUpperCase().equals("ALOCADO")) {
                    System.out.println("Recurso alocado, deseja alterar para Em andamento? (1-SIM/2-NAO)");
                    int op = Integer.parseInt(sc.nextLine());
                    if(op == 1 ) {
                        rU.recursoAlocado(rU);
                    }
                }
                else {
                    System.out.println("Nao foi possivel realizar esta alteracao, recurso encontra-se "+rU.getStatus()+"!");
                }
                break;
            case 6:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Desculpe, mas parace que voce escolheu uma opcao indisponivel" +
                        ", por favor, tente novamente!");
        }
    }

}
