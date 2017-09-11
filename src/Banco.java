package system;

import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import system.UserPrototype;



public class Banco  {
    private ArrayList<UserPrototype> lUsers = new ArrayList<>();
    private ArrayList<Atividade> lActivitys = new ArrayList<>();
    private ArrayList<Recurso> lRecursos = new ArrayList<>();
    private int idUser = 1;
    private int idRecurso = 1;
    private int idActivity = 1;

    //1 - Adicionar Usuario
    public void addUser(UserPrototype user) {
        user.setId(idUser);
        lUsers.add(user);
        idUser++;
        System.out.println("Usuario "+user.getName()+" cadastrado com sucesso!");
    }

    //2 - Listar Usuarios
    public void listUsers()
    {
        for(int i = 0;i<lUsers.size();i++)
        {
            System.out.println(lUsers.get(i));
        }
    }

    //3 - Buscar Usuario
    public void getUser(int id) {
        UserPrototype resultado = null;
        for(int i=0; i<lUsers.size(); ++i){
            if(id == lUsers.get(i).getId()){
                resultado = (lUsers.get(i));
            }
        }
        System.out.println(resultado);
        System.out.println("**************HISTORICO**************");
        //Procurando o recurso associado a este user
        System.out.println("***********RECURSOS ALOCADOS*********");
        for(int i = 0;i<lRecursos.size();i++) {
            if(lRecursos.get(i).getResponsavel().getId() == id) {
                System.out.println(lRecursos.get(i)+"\n");
            }
        }
        //Procurando atividades asssociadas a este user
        System.out.println("********ATIVIDADES REALIZADAS********");
        for(int i = 0;i<lActivitys.size();i++) {
            if(lActivitys.get(i).getResponsavel().getId() == id) {
                System.out.println(lActivitys.get(i)+"\n");
            }
        }
    }

    //4 - Retorna Usuario
    public UserPrototype searchUser(int id) {
        UserPrototype resultado = null;
        for(int i=0; i<lUsers.size(); ++i){
            if(id == lUsers.get(i).getId()){
                resultado = (lUsers.get(i));
            }
        }
        return resultado;
    }

    //5 - Cadastrar Recurso
    public void addRecurso(String dI,String dF,String hI,String hF,UserPrototype resp,Atividade atv) throws ParseException
    {
        //Conversoes para data e hora
        SimpleDateFormat formatadorHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

        Date dataFinal = formatadorData.parse(dI);
        Date dataInicial = formatadorData.parse(dF);
        Date hInicial = formatadorHora.parse(hI);
        Date hFinal = formatadorHora.parse(hF);

        Time horaInicial = new Time(hInicial.getTime());
        Time horaFinal = new Time(hFinal.getTime());

        Recurso r = new Recurso(idRecurso,dataInicial,dataFinal,horaInicial,horaFinal,resp,atv,"Em processo de alocacao");
        if(resp.alocarRecurso(r) != null) {
            lActivitys.add(atv);
            lRecursos.add(r);
            idRecurso++;
            idActivity++;
        }
    }

    //6 - Buscar recurso
    public void getRecurso(int atv) {
        Recurso recurso = null;
        System.out.println("LISTA DE RECURSOS");
        for(int i=0; i<lRecursos.size(); ++i){
            if(atv == 1){
                if(lRecursos.get(i).getAtividade().getTipo().toUpperCase().equals("AULA")){
                    System.out.println("***************Recurso "+(i+1)+"***************");
                    recurso = (lRecursos.get(i));
                    System.out.println(recurso);
                }
            }
            else if(atv == 2){
                if(lRecursos.get(i).getAtividade().getTipo().toUpperCase().equals("APRESENTACOES")){
                    System.out.println("***************Recurso "+(i+1)+"***************");
                    recurso = (lRecursos.get(i));
                    System.out.println(recurso);
                }
            }
            else if(atv == 3){
                if(lRecursos.get(i).getAtividade().getTipo().toUpperCase().equals("LABORATORIO")){
                    System.out.println("***************Recurso "+(i+1)+"***************");
                    recurso = (lRecursos.get(i));
                    System.out.println(recurso);
                }
            }
        }
    }

    //7 - Relatorio de atividade
    public void relAtividades() {
        System.out.println("***************RELATORIO DE ATIVIDADES***************");
        System.out.println("\nNº de usuarios: "+lUsers.size());

        //Recursos por tipo
        int contR_Aloc  = 0;
        int contR_EmAloc = 0;
        int contR_EmAnd = 0;
        int contR_Conc = 0;

        for(int i = 0;i<lRecursos.size();i++) {
            if(lRecursos.get(i).getStatus().toUpperCase().equals("ALOCADO")) {
                contR_Aloc++;
            }
            else if(lRecursos.get(i).getStatus().toUpperCase().equals("EM PROCESSO DE ALOCACAO")) {
                contR_EmAloc++;
            }
            else if(lRecursos.get(i).getStatus().toUpperCase().equals("EM ANDAMENTO")) {
                contR_EmAnd++;
            }
            else if(lRecursos.get(i).getStatus().toUpperCase().equals("CONCLUIDO")) {
                contR_Conc++;
            }
        }

        System.out.println("\nNº de recursos alocados: "+contR_Aloc);
        System.out.println("\nNº de recursos em alocacao: "+contR_EmAloc);
        System.out.println("\nNº de recursos em andamento: "+contR_EmAnd);
        System.out.println("\nNº de recursos concluidos: "+contR_Conc);
        System.out.println("\nTotal de recursos: "+lRecursos.size());

        //Atividades por tipo
        int contA_Aula  = 0;
        int contA_Apres = 0;
        int contA_Lab = 0;

        for(int i = 0;i<lActivitys.size();i++) {
            if(lActivitys.get(i).getTipo().toUpperCase().equals("AULA")) {
                contA_Aula++;
            }
            else if(lActivitys.get(i).getTipo().toUpperCase().equals("APRESENTACOES")) {
                contA_Apres++;
            }
            else if(lActivitys.get(i).getTipo().toUpperCase().equals("LABORATORIO")) {
                contA_Lab++;
            }
        }
        System.out.println("\nNº de atividades do tipo aula: "+contA_Aula);
        System.out.println("\nNº de atividades do tipo apresentacoes: "+contA_Apres);
        System.out.println("\nNº de atividades do tipo laboratorio: "+contA_Lab);

    }

    //8 - Retorna recurso
    public Recurso searchRecurso(int id) {
        Recurso resultado = null;
        for(int i=0; i<lRecursos.size(); ++i){
            if(id == lRecursos.get(i).getIdentification()){
                resultado = (lRecursos.get(i));
            }
        }
        return resultado;
    }

    //9 - Set Status
    public void setStatus(Recurso r) {
        for(int i = 0;i<lRecursos.size();i++) {
            if(lRecursos.get(i).getIdentification()==r.getIdentification())
            {
                lRecursos.get(i).setStatus(r.getStatus());
            }
        }
    }

    public ArrayList<Recurso> getlRecursos() {
        return lRecursos;
    }

}
