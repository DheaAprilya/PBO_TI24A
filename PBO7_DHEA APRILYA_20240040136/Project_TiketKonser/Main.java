import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("===========================================");
        System.out.println("  WAR TIKET - NCT DREAM CONCERT JAKARTA   ");
        System.out.println("  The Dream Show 3 - GBK, 20 Sept 2025    ");
        System.out.println("===========================================\n");

        // -----------------------------------------------
        // GENERIC COLLECTION - Stok tiket
        // -----------------------------------------------
        Koleksi<TiketVIP>       stokVIP       = new Koleksi<>("Stok VIP");
        Koleksi<TiketRegular>   stokRegular   = new Koleksi<>("Stok Regular");
        Koleksi<TiketEarlyBird> stokEarlyBird = new Koleksi<>("Stok Early Bird");

        stokVIP.tambah(new TiketVIP("VIP-001", true));
        stokVIP.tambah(new TiketVIP("VIP-002", false));
        stokVIP.tambah(new TiketVIP("VIP-003", true));

        for (int i = 1; i <= 5; i++)
            stokRegular.tambah(new TiketRegular("REG-00" + i));

        stokEarlyBird.tambah(new TiketEarlyBird("EB-001"));
        stokEarlyBird.tambah(new TiketEarlyBird("EB-002"));

        // Polimorfisme: getInfo() berbeda tiap subclass
        ArrayList<Tiket> semuaTiket = new ArrayList<>();
        semuaTiket.addAll(stokVIP.getAll());
        semuaTiket.addAll(stokRegular.getAll());
        semuaTiket.addAll(stokEarlyBird.getAll());

        System.out.println("=== STOK TIKET TERSEDIA ===");
        for (Tiket t : semuaTiket)
            System.out.println("  " + t.getInfo());

        // -----------------------------------------------
        // ANTRIAN WAR - ArrayDeque (FIFO)
        // -----------------------------------------------
        System.out.println("\n=== WAR TIKET DIMULAI! (Antrian FIFO) ===");
        ArrayDeque<Pembeli> antrian = new ArrayDeque<>();

        antrian.offer(new Pembeli("Haechannie",  "hae@dream.com"));
        antrian.offer(new Pembeli("Renjen_fan",  "ren@nct.com"));
        antrian.offer(new Pembeli("Markeu_bby",  "mark@dream.com"));
        antrian.offer(new Pembeli("Jaemin_luv",  "jae@dream.com"));
        antrian.offer(new Pembeli("Jeno_mystar", "jeno@dream.com"));
        antrian.offer(new Pembeli("Chenle_cn",   "chenle@dream.com"));
        antrian.offer(new Pembeli("Jisung_baby", "jisung@dream.com"));

        System.out.println("Total fans dalam antrian: " + antrian.size());

        System.out.println("\n--- [EARLY BIRD PHASE] ---");
        for (TiketEarlyBird eb : stokEarlyBird.getAll()) {
            if (!antrian.isEmpty()) {
                Pembeli p = antrian.poll();
                if (eb.beli(p.getNama())) p.tambahTiket(eb);
            }
        }

        System.out.println("\n--- [VIP PHASE] ---");
        for (TiketVIP vip : stokVIP.getAll()) {
            if (!antrian.isEmpty()) {
                Pembeli p = antrian.poll();
                if (vip.beli(p.getNama())) p.tambahTiket(vip);
            }
        }

        System.out.println("\n--- [REGULAR PHASE] ---");
        for (TiketRegular reg : stokRegular.getAll()) {
            if (!antrian.isEmpty()) {
                Pembeli p = antrian.poll();
                if (reg.beli(p.getNama())) p.tambahTiket(reg);
            }
        }

        // -----------------------------------------------
        // CEK SISA ANTRIAN
        // -----------------------------------------------
        System.out.println("\n=== FANS YANG KEHABISAN TIKET ===");
        if (antrian.isEmpty()) {
            System.out.println("  Semua fans kebagian tiket!");
        } else {
            antrian.forEach(p ->
                System.out.println("  [X] " + p.getNama() + " - TIDAK KEBAGIAN TIKET"));
        }

        // -----------------------------------------------
        // STATUS AKHIR (Polimorfisme)
        // -----------------------------------------------
        System.out.println("\n=== STATUS AKHIR TIKET ===");
        for (Tiket t : semuaTiket)
            System.out.println("  " + t.getInfo());

        // -----------------------------------------------
        // SIMULASI PEMBATALAN
        // -----------------------------------------------
        System.out.println("\n=== SIMULASI PEMBATALAN ===");
        TiketRegular tiketBatal = stokRegular.getAll().get(0);
        tiketBatal.batalkan();
        System.out.println("  Status setelah batal: " + tiketBatal.getInfo());

        // -----------------------------------------------
        // STATISTIK PENJUALAN
        // -----------------------------------------------
        System.out.println("\n=== STATISTIK PENJUALAN ===");
        long terjual = semuaTiket.stream().filter(Tiket::isTerjual).count();
        double totalPendapatan = semuaTiket.stream()
            .filter(Tiket::isTerjual)
            .mapToDouble(Tiket::getHargaFinal)
            .sum();

        System.out.println("  Tiket terjual   : " + terjual + "/" + semuaTiket.size());
        System.out.printf("  Total pendapatan: Rp%.0f%n", totalPendapatan);
        System.out.println("\nSee you at GBK!");
    }
}
