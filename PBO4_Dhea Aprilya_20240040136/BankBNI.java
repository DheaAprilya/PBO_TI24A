// ============================================================
//  Kelas BankBNI - Method Overriding
// ============================================================
public class BankBNI extends Bank {

    // Override sukuBunga() → BNI = 4%
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BNI adalah 4%");
    }

    // Override transferUang(jumlah, rekeningTujuan, bankTujuan)
    // Bank tujuan otomatis diisi "BNI"
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI"; // nilai dikunci ke BNI
        int biaya  = hitungBiayaTransfer(bankTujuan);
        System.out.println("=== [BNI] Transfer Berhasil ===");
        System.out.println("Jumlah       : Rp " + jumlah);
        System.out.println("Rek. Tujuan  : " + rekeningTujuan);
        System.out.println("Bank Tujuan  : " + bankTujuan);
        System.out.println("Biaya Admin  : Rp " + biaya);
        System.out.println("Total Bayar  : Rp " + (jumlah + biaya));
        System.out.println();
    }
}
