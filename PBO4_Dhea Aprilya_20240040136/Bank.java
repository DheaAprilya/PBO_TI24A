// ============================================================
//  Kelas Bank - Method Overloading + Bonus: biaya transfer
// ============================================================
public class Bank {

    // ---------- METHOD OVERLOADING ----------

    // Variasi 1: Transfer ke rekening lain (bank yang sama)
    public void transferUang(int jumlah, String rekeningTujuan) {
        int biaya = hitungBiayaTransfer("SAMA");
        System.out.println("=== Transfer Berhasil ===");
        System.out.println("Jumlah       : Rp " + jumlah);
        System.out.println("Rek. Tujuan  : " + rekeningTujuan);
        System.out.println("Bank Tujuan  : (bank yang sama)");
        System.out.println("Biaya Admin  : Rp " + biaya);
        System.out.println("Total Bayar  : Rp " + (jumlah + biaya));
        System.out.println();
    }

    // Variasi 2: Transfer ke rekening lain di bank berbeda
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiayaTransfer(bankTujuan);
        System.out.println("=== Transfer Berhasil ===");
        System.out.println("Jumlah       : Rp " + jumlah);
        System.out.println("Rek. Tujuan  : " + rekeningTujuan);
        System.out.println("Bank Tujuan  : " + bankTujuan);
        System.out.println("Biaya Admin  : Rp " + biaya);
        System.out.println("Total Bayar  : Rp " + (jumlah + biaya));
        System.out.println();
    }

    // Variasi 3: Transfer dengan tambahan berita/keterangan
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = hitungBiayaTransfer(bankTujuan);
        System.out.println("=== Transfer Berhasil ===");
        System.out.println("Jumlah       : Rp " + jumlah);
        System.out.println("Rek. Tujuan  : " + rekeningTujuan);
        System.out.println("Bank Tujuan  : " + bankTujuan);
        System.out.println("Berita       : " + berita);
        System.out.println("Biaya Admin  : Rp " + biaya);
        System.out.println("Total Bayar  : Rp " + (jumlah + biaya));
        System.out.println();
    }

    // Variasi 4: Menampilkan suku bunga standar
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // ---------- BONUS: Hitung biaya transfer berdasarkan bank tujuan ----------
    public int hitungBiayaTransfer(String bankTujuan) {
        switch (bankTujuan.toUpperCase()) {
            case "BNI":   return 6500;
            case "BCA":   return 6500;
            case "BRI":   return 6500;
            case "MANDIRI": return 6500;
            case "SAMA":  return 0;      // sesama bank = gratis
            default:      return 5000;   // bank lain
        }
    }
}
