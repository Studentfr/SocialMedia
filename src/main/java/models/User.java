package models;

public class User {
    private int id;
    private String username, password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User copyWithoutPassword() {
        User u = new User();
        u.setId(id);
        u.setPassword("");
        return u;
    }
}