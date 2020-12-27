package Model;

import java.util.Objects;

public class User {
    private int id;
    private String Username;
    private String Password;
    private String Gmail;
    private String Phone;
    private String Avatar;
    private int role;
    private int status;

    public User(int id, String username, String password, String gmail, String phone, String avatar, int role, int status) {
        this.id = id;
        Username = username;
        Password = password;
        Gmail = gmail;
        Phone = phone;
        Avatar = avatar;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    public int hashCodePassword(String password) {
//        return (Objects.hash(password) + 26) * 6;
//    }
}
