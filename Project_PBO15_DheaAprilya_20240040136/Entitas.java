// Entitas.java
// Abstract class sebagai induk dari entitas-entitas dalam sistem (Kamera, User, dsb).
// Menerapkan konsep ABSTRACTION & INHERITANCE.
public abstract class Entitas {
    protected String id;
    protected String nama;

    public Entitas(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    // ENCAPSULATION: akses field private/protected lewat getter-setter
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method abstract, wajib di-override oleh subclass -> mendukung POLYMORPHISM
    public abstract void tampilkanInfo();
}
