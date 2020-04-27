package java;

public class User {
    // id (you need to generate this id by static member variable)
    private int id;
    private static int id_gen=0;
    private static int idM =-1;
    // name, surname
    public String name;
    public String surname;
    // username
    public String username;
    // password
    public Password password;

    public static int getIdM() {
        return idM;
    }

    public static void setIdM(int idM) {
        if (idM<getIdM()){ User.idM = idM;}
        else {
            return;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public Password getPassword() {
        return password;
    }

    public void createId(){
        this.id=idM++;
    }
    public User(String name, String surname, String username, Password password) {
        createId();
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }
    public User(int id, String name, String surname, String username, Password password) {
        setId(id);
        setIdM(id);
        setName(name);
        setSurname(surname);
        setUsername(username);
        setPassword(password);
    }

    @Override
    public String toString(){
        return "Ur name:"+getName()+" Ur surname:"+getSurname()+" Ur username:"+getUsername()+" Ur password:"+getPassword();
    }
}
