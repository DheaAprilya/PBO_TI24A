// ============================================================
//  Kelas BankBCA - Method Overriding
// ============================================================
public class BankBCA extends Bank {

    // Override sukuBunga() → BCA = 4.5%
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BCA adalah 4.5%");
    }

    // Override transferUang(jumlah, rekeningTujuan, bankTujuan)
    // Bank tujuan otomatis diisi "BCA"
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA"; // nilai dikunci ke BCA
        int biaya  = hitungBiayaTransfer(bankTujuan);
        System.out.println("=== [BCA] Transfer Berhasil ===");
        System.out.println("Jumlah       : Rp " + jumlah);
        System.out.println("Rek. Tujuan  : " + rekeningTujuan);
        System.out.println("Bank Tujuan  : " + bankTujuan);
        System.out.println("Biaya Admin  : Rp " + biaya);
        System.out.println("Total Bayar  : Rp " + (jumlah + biaya));
        System.out.println();
    }
}
