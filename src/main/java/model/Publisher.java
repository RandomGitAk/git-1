package model;

public class Publisher {
    private String name;
    private long id;

    public Publisher() {
    }

    public Publisher(String name, long id) {

        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //+1
    @Override
    public String toString() {
        return name ;
    }


}


