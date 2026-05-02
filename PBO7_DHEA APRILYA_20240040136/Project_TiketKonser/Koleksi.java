import java.util.ArrayList;

public class Koleksi<T> {
    private String nama;
    private ArrayList<T> daftar = new ArrayList<>();

    public Koleksi(String nama) { this.nama = nama; }

    public void tambah(T item)   { daftar.add(item); }
    public void hapus(T item)    { daftar.remove(item); }
    public ArrayList<T> getAll() { return daftar; }
    public int size()            { return daftar.size(); }

    public void tampilSemua() {
        System.out.println("\n" + nama + " (" + size() + " tiket):");
        System.out.println("-------------------------------------------------------");
        daftar.forEach(System.out::println);
    }
}
