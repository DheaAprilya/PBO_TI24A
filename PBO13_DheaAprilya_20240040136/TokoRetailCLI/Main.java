import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String URL = "jdbc:mysql://localhost:3306/toko_retail";
    static final String USER = "root";
    static final String PASSWORD = ""; // ganti kalau MySQL kamu pakai password

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            pilihan = Integer.parseInt(sc.nextLine());

            switch (pilihan) {
                case 1: tampilSemuaData(); break;
                case 2: tambahData(); break;
                case 3: cariData(); break;
                case 4: ubahData(); break;
                case 5: hapusData(); break;
                case 0: System.out.println("Terima kasih, program selesai."); break;
                default: System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    static void tampilkanMenu() {
        System.out.println("\n========================================");
        System.out.println("           MENU TOKO RETAIL");
        System.out.println("========================================");
        System.out.println("1. Tampil Semua Data");
        System.out.println("2. Tambah Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Ubah Data");
        System.out.println("5. Hapus Data");
        System.out.println("0. Keluar");
        System.out.println("========================================");
        System.out.print("Pilihan : ");
    }

    static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static void tampilSemuaData() {
        String sql = "SELECT * FROM barang";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n========== DAFTAR BARANG TOKO RETAIL ==========");
            System.out.printf("%-3s %-6s %-20s %-10s %-6s%n", "#", "Kode", "Nama Barang", "Harga", "Stok");
            int no = 1;
            while (rs.next()) {
                System.out.printf("%-3d %-6s %-20s %-10d %-6d%n",
                        no++, rs.getString("kode"), rs.getString("nama_barang"),
                        rs.getInt("harga"), rs.getInt("stok"));
            }
            System.out.println("Total: " + (no - 1) + " barang");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void tambahData() {
        System.out.print("Kode Barang    : ");
        String kode = sc.nextLine();
        System.out.print("Nama Barang    : ");
        String nama = sc.nextLine();
        System.out.print("Harga          : ");
        int harga = Integer.parseInt(sc.nextLine());
        System.out.print("Stok           : ");
        int stok = Integer.parseInt(sc.nextLine());

        String sql = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ps.setString(2, nama);
            ps.setInt(3, harga);
            ps.setInt(4, stok);
            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void cariData() {
        System.out.print("Masukkan kode barang yang dicari: ");
        String kode = sc.nextLine();

        String sql = "SELECT * FROM barang WHERE kode = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\n========== DATA DITEMUKAN ==========");
                System.out.println("Kode         : " + rs.getString("kode"));
                System.out.println("Nama Barang  : " + rs.getString("nama_barang"));
                System.out.println("Harga        : " + rs.getInt("harga"));
                System.out.println("Stok         : " + rs.getInt("stok"));
            } else {
                System.out.println("Data dengan kode " + kode + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void ubahData() {
        System.out.print("Masukkan kode barang yang mau diubah: ");
        String kode = sc.nextLine();

        System.out.print("Nama Baru      : ");
        String nama = sc.nextLine();
        System.out.print("Harga Baru     : ");
        int harga = Integer.parseInt(sc.nextLine());
        System.out.print("Stok Baru      : ");
        int stok = Integer.parseInt(sc.nextLine());

        String sql = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nama);
            ps.setInt(2, harga);
            ps.setInt(3, stok);
            ps.setString(4, kode);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Data berhasil diubah!");
            } else {
                System.out.println("Data dengan kode " + kode + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void hapusData() {
        System.out.print("Masukkan kode barang yang mau dihapus: ");
        String kode = sc.nextLine();

        String sql = "DELETE FROM barang WHERE kode = ?";
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, kode);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                System.out.println("Data dengan kode " + kode + " tidak ditemukan.");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}