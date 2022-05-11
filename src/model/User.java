package model;

public class User {
    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        System.out.printf("\"| %-10s| %-10s|\n\"", "TÊN", "USER");
        System.out.println("----------------------------");
        return String.format("\"| %-10s| %-10s|\n\"",name,password);
    }
}

