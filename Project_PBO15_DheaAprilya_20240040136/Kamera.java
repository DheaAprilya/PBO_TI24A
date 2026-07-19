// Kamera.java
// Merepresentasikan data kamera yang disewakan.
// INHERITANCE: extends Entitas
public class Kamera extends Entitas {
    private String merek;
    private String tipe;
    private double hargaSewaPerHari;
    private boolean tersedia;

    public Kamera(String id, String nama, String merek, String tipe, double hargaSewaPerHari) {
        super(id, nama);
        this.merek = merek;
        this.tipe = tipe;
        this.hargaSewaPerHari = hargaSewaPerHari;
        this.tersedia = true; // default saat kamera baru ditambahkan
    }

    // ENCAPSULATION: getter & setter
    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public void setHargaSewaPerHari(double hargaSewaPerHari) {
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    // POLYMORPHISM: override method abstract dari Entitas
    @Override
    public void tampilkanInfo() {
        String status = tersedia ? "Tersedia" : "Sedang Disewa";
        System.out.printf("ID: %-6s | Nama: %-15s | Merek: %-10s | Tipe: %-10s | Harga/Hari: Rp%-10.0f | Status: %s%n",
                id, nama, merek, tipe, hargaSewaPerHari, status);
    }
}
