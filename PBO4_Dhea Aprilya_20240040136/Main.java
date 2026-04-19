// ============================================================
//  Kelas Main - Menguji semua metode
// ============================================================
public class Main {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║      SISTEM TRANSAKSI PERBANKAN          ║");
        System.out.println("║      Polimorfisme - OOP                  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        // ── 1. METHOD OVERLOADING (kelas Bank) ──────────────────
        System.out.println("━━━━━━ 1. METHOD OVERLOADING (Bank) ━━━━━━");

        Bank bank = new Bank();

        // Suku bunga standar
        bank.sukuBunga();
        System.out.println();

        // Variasi 1 – sesama bank
        System.out.println("[Variasi 1] Transfer sesama bank:");
        bank.transferUang(500_000, "1234567890");

        // Variasi 2 – beda bank
        System.out.println("[Variasi 2] Transfer ke bank lain:");
        bank.transferUang(1_000_000, "0987654321", "BRI");

        // Variasi 3 – dengan berita
        System.out.println("[Variasi 3] Transfer dengan berita:");
        bank.transferUang(2_000_000, "1122334455", "MANDIRI", "Pembayaran sewa bulan April");

        // ── 2. METHOD OVERRIDING (BankBNI & BankBCA) ────────────
        System.out.println("━━━━━━ 2. METHOD OVERRIDING (BankBNI) ━━━━━━");

        BankBNI bni = new BankBNI();
        bni.sukuBunga();
        System.out.println();

        System.out.println("[BNI] Transfer (bankTujuan dikunci ke BNI):");
        bni.transferUang(3_000_000, "7788990011", "APA_SAJA");

        // Metode yang tidak di-override masih diwariskan
        System.out.println("[BNI] Transfer dengan berita (diwarisi dari Bank):");
        bni.transferUang(500_000, "7788990011", "BNI", "Cicilan motor");

        System.out.println("━━━━━━ 2. METHOD OVERRIDING (BankBCA) ━━━━━━");

        BankBCA bca = new BankBCA();
        bca.sukuBunga();
        System.out.println();

        System.out.println("[BCA] Transfer (bankTujuan dikunci ke BCA):");
        bca.transferUang(5_000_000, "6655443322", "APA_SAJA");

        System.out.println("[BCA] Transfer dengan berita (diwarisi dari Bank):");
        bca.transferUang(750_000, "6655443322", "BCA", "Bayar kontrakan");

        // ── 3. BONUS – Polimorfisme via referensi Bank ───────────
        System.out.println("━━━━━━ 3. BONUS – Polimorfisme (upcasting) ━━━━━━");
        Bank[] banks = { new Bank(), new BankBNI(), new BankBCA() };
        for (Bank b : banks) {
            b.sukuBunga(); // memanggil versi yang sesuai (dynamic dispatch)
        }
        System.out.println();

        System.out.println("Program selesai. Terima kasih!");
    }
}
