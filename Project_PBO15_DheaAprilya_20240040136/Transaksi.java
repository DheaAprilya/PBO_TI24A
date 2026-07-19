// Transaksi.java
// Merepresentasikan satu transaksi sewa kamera.
public class Transaksi {
    private String idTransaksi;
    private Kamera kamera;
    private String namaPeminjam;
    private int lamaSewa; // dalam hari
    private double totalBiaya;
    private String status; // "Disewa" atau "Selesai"

    public Transaksi(String idTransaksi, Kamera kamera, String namaPeminjam, int lamaSewa) {
        this.idTransaksi = idTransaksi;
        this.kamera = kamera;
        this.namaPeminjam = namaPeminjam;
        this.lamaSewa = lamaSewa;
        this.totalBiaya = kamera.getHargaSewaPerHari() * lamaSewa;
        this.status = "Disewa";
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Kamera getKamera() {
        return kamera;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public String getStatus() {
        return status;
    }

    public void selesaikanTransaksi() {
        this.status = "Selesai";
    }

    public void tampilkanInfo() {
        System.out.printf("ID Transaksi: %-6s | Kamera: %-15s | Peminjam: %-12s | Lama Sewa: %d hari | Total: Rp%-10.0f | Status: %s%n",
                idTransaksi, kamera.getNama(), namaPeminjam, lamaSewa, totalBiaya, status);
    }
}
