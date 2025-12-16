package com.example.onlineeducationplatform.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    // Getter 和 Setter 方法 (必须生成，否则MyBatis无法赋值)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}