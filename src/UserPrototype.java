package system;

public abstract class UserPrototype {

    public String name;
    public String email;
    public int id;


    public UserPrototype(String name, String email) {
        super();
        this.name = name;
        this.email = email;
    }

    public abstract Recurso alocarRecurso(Recurso r);

    @Override
    public String toString() {
        return "Id: "+id+"\nNome: " + name +"\nEmail: " + email ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
