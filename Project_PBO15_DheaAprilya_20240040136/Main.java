import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Kamera> daftarKamera = new ArrayList<>();
    static ArrayList<User> daftarUser = new ArrayList<>();
    static ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    static int kameraCounter = 1;
    static int transaksiCounter = 1;

    public static void main(String[] args) {
        inisialisasiData();

        System.out.println("=====================================");
        System.out.println(" APLIKASI RENTAL KAMERA (CLI)");
        System.out.println("=====================================");

        User userLogin = null;
        while (userLogin == null) {
            userLogin = login();
            if (userLogin == null) {
                System.out.println("Username/password salah. Coba lagi.\n");
            }
        }

        System.out.println("\nLogin berhasil sebagai " + userLogin.getRole() + " (" + userLogin.getUsername() + ")\n");

        boolean logout = false;
        while (!logout) {
            // POLYMORPHISM: tampilkanMenu() beda tergantung objek Admin/Member
            userLogin.tampilkanMenu();
            int pilihan = bacaInt();

            if (userLogin instanceof Admin) {
                logout = menuAdmin(pilihan);
            } else {
                logout = menuMember(pilihan, userLogin.getUsername());
            }
        }

        System.out.println("\nTerima kasih telah menggunakan aplikasi. Sampai jumpa!");
    }

    static void inisialisasiData() {
        // Data dummy user
        daftarUser.add(new Admin("admin", "admin123"));
        daftarUser.add(new Member("budi", "budi123"));

        // Data dummy kamera
        daftarKamera.add(new Kamera(genIdKamera(), "Canon EOS 90D", "Canon", "DSLR", 150000));
        daftarKamera.add(new Kamera(genIdKamera(), "Sony A7 III", "Sony", "Mirrorless", 250000));
        daftarKamera.add(new Kamera(genIdKamera(), "Fujifilm X-T4", "Fujifilm", "Mirrorless", 200000));
    }

    static String genIdKamera() {
        return "K" + String.format("%03d", kameraCounter++);
    }

    static String genIdTransaksi() {
        return "T" + String.format("%03d", transaksiCounter++);
    }

    static User login() {
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        for (User u : daftarUser) {
            if (u.getUsername().equals(username) && u.cekPassword(password)) {
                return u;
            }
        }
        return null;
    }

    static int bacaInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Input harus berupa angka, coba lagi: ");
            sc.next();
        }
        int nilai = sc.nextInt();
        sc.nextLine(); // buang newline
        return nilai;
    }

    static boolean menuAdmin(int pilihan) {
        switch (pilihan) {
            case 1: lihatDaftarKamera(); break;
            case 2: tambahKamera(); break;
            case 3: updateKamera(); break;
            case 4: hapusKamera(); break;
            case 5: sewaKamera(null); break;
            case 6: kembalikanKamera(); break;
            case 7: lihatSemuaTransaksi(); break;
            case 0: return true;
            default: System.out.println("Pilihan tidak valid.");
        }
        return false;
    }

    static boolean menuMember(int pilihan, String namaUser) {
        switch (pilihan) {
            case 1: lihatDaftarKamera(); break;
            case 2: sewaKamera(namaUser); break;
            case 3: kembalikanKamera(); break;
            case 4: lihatTransaksiUser(namaUser); break;
            case 0: return true;
            default: System.out.println("Pilihan tidak valid.");
        }
        return false;
    }

    static void lihatDaftarKamera() {
        System.out.println("\n--- DAFTAR KAMERA ---");
        if (daftarKamera.isEmpty()) {
            System.out.println("Belum ada data kamera.");
        } else {
            for (Kamera k : daftarKamera) {
                k.tampilkanInfo(); // POLYMORPHISM
            }
        }
        System.out.println();
    }

    static void tambahKamera() {
        System.out.println("\n--- TAMBAH KAMERA ---");
        System.out.print("Nama Kamera: ");
        String nama = sc.nextLine();
        System.out.print("Merek: ");
        String merek = sc.nextLine();
        System.out.print("Tipe: ");
        String tipe = sc.nextLine();
        System.out.print("Harga Sewa per Hari: ");
        double harga = bacaDouble();

        Kamera baru = new Kamera(genIdKamera(), nama, merek, tipe, harga);
        daftarKamera.add(baru);
        System.out.println("Kamera berhasil ditambahkan dengan ID " + baru.getId() + "\n");
    }

    static void updateKamera() {
        System.out.println("\n--- UPDATE KAMERA ---");
        System.out.print("Masukkan ID Kamera yang ingin diupdate: ");
        String id = sc.nextLine();
        Kamera k = cariKamera(id);

        if (k == null) {
            System.out.println("Kamera dengan ID tersebut tidak ditemukan.\n");
            return;
        }

        System.out.print("Nama baru (kosongkan jika tidak diubah): ");
        String nama = sc.nextLine();
        if (!nama.isBlank()) k.setNama(nama);

        System.out.print("Merek baru (kosongkan jika tidak diubah): ");
        String merek = sc.nextLine();
        if (!merek.isBlank()) k.setMerek(merek);

        System.out.print("Tipe baru (kosongkan jika tidak diubah): ");
        String tipe = sc.nextLine();
        if (!tipe.isBlank()) k.setTipe(tipe);

        System.out.print("Harga sewa baru (isi 0 jika tidak diubah): ");
        double harga = bacaDouble();
        if (harga > 0) k.setHargaSewaPerHari(harga);

        System.out.println("Data kamera berhasil diupdate.\n");
    }

    static void hapusKamera() {
        System.out.println("\n--- HAPUS KAMERA ---");
        System.out.print("Masukkan ID Kamera yang ingin dihapus: ");
        String id = sc.nextLine();
        Kamera k = cariKamera(id);

        if (k == null) {
            System.out.println("Kamera dengan ID tersebut tidak ditemukan.\n");
            return;
        }

        daftarKamera.remove(k);
        System.out.println("Kamera berhasil dihapus.\n");
    }

    static void sewaKamera(String namaUserLogin) {
        System.out.println("\n--- SEWA KAMERA ---");
        lihatDaftarKamera();
        System.out.print("Masukkan ID Kamera yang ingin disewa: ");
        String id = sc.nextLine();
        Kamera k = cariKamera(id);

        if (k == null) {
            System.out.println("Kamera tidak ditemukan.\n");
            return;
        }
        if (!k.isTersedia()) {
            System.out.println("Kamera sedang disewa, tidak tersedia.\n");
            return;
        }

        String namaPeminjam;
        if (namaUserLogin != null) {
            namaPeminjam = namaUserLogin;
        } else {
            System.out.print("Nama Peminjam: ");
            namaPeminjam = sc.nextLine();
        }

        System.out.print("Lama Sewa (hari): ");
        int lama = bacaInt();

        Transaksi trx = new Transaksi(genIdTransaksi(), k, namaPeminjam, lama);
        daftarTransaksi.add(trx);
        k.setTersedia(false);

        System.out.printf("Transaksi berhasil! ID Transaksi: %s | Total Biaya: Rp%.0f%n%n",
                trx.getIdTransaksi(), trx.getTotalBiaya());
    }

    static void kembalikanKamera() {
        System.out.println("\n--- KEMBALIKAN KAMERA ---");
        System.out.print("Masukkan ID Transaksi: ");
        String idTrx = sc.nextLine();

        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equalsIgnoreCase(idTrx) && t.getStatus().equals("Disewa")) {
                t.selesaikanTransaksi();
                t.getKamera().setTersedia(true);
                System.out.println("Kamera berhasil dikembalikan. Terima kasih!\n");
                return;
            }
        }
        System.out.println("Transaksi tidak ditemukan atau sudah selesai.\n");
    }

    static void lihatSemuaTransaksi() {
        System.out.println("\n--- SEMUA TRANSAKSI ---");
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (Transaksi t : daftarTransaksi) {
                t.tampilkanInfo();
            }
        }
        System.out.println();
    }

    static void lihatTransaksiUser(String namaUser) {
        System.out.println("\n--- TRANSAKSI SAYA (" + namaUser + ") ---");
        boolean ada = false;
        for (Transaksi t : daftarTransaksi) {
            if (t.getNamaPeminjam().equalsIgnoreCase(namaUser)) {
                t.tampilkanInfo();
                ada = true;
            }
        }
        if (!ada) System.out.println("Belum ada transaksi.");
        System.out.println();
    }

    static Kamera cariKamera(String id) {
        for (Kamera k : daftarKamera) {
            if (k.getId().equalsIgnoreCase(id)) return k;
        }
        return null;
    }

    static double bacaDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Input harus berupa angka, coba lagi: ");
            sc.next();
        }
        double nilai = sc.nextDouble();
        sc.nextLine();
        return nilai;
    }
}
