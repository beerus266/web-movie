package Model;

public class Category {
    private int id ;
    private String Name ;
    private int status ;

    public Category(int id, String name, int status) {
        this.id = id;
        Name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
