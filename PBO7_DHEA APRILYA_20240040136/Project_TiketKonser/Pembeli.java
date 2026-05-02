import java.util.ArrayList;

public class Pembeli {
    private String nama;
    private String email;
    private ArrayList<Tiket> riwayatTiket;

    public Pembeli(String nama, String email) {
        this.nama         = nama;
        this.email        = email;
        this.riwayatTiket = new ArrayList<>();
    }

    public String getNama()  { return nama; }
    public String getEmail() { return email; }

    public void tambahTiket(Tiket t) {
        riwayatTiket.add(t);
    }

    public void tampilRiwayat() {
        System.out.println("\nTiket milik " + nama + " (" + email + "):");
        if (riwayatTiket.isEmpty()) {
            System.out.println("  Belum ada tiket.");
        } else {
            double total = 0;
            for (Tiket t : riwayatTiket) {
                System.out.println("  - " + t.getInfo());
                total += t.getHargaFinal();
            }
            System.out.printf("  Total bayar: Rp%.0f%n", total);
        }
    }
}
