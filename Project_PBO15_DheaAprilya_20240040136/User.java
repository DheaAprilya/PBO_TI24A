// User.java
// Abstract class induk untuk Admin dan Member.
// INHERITANCE & ABSTRACTION
public abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    // ENCAPSULATION: password tidak diekspos langsung, hanya lewat method cek
    public boolean cekPassword(String password) {
        return this.password.equals(password);
    }

    // Method abstract -> tiap role punya menu berbeda (POLYMORPHISM)
    public abstract void tampilkanMenu();

    public abstract String getRole();
}
