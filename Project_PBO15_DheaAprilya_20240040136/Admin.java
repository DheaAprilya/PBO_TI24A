// Admin.java
// INHERITANCE: extends User
public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    // POLYMORPHISM: override tampilkanMenu() beda dengan Member
    @Override
    public void tampilkanMenu() {
        System.out.println("===== MENU ADMIN =====");
        System.out.println("1. Lihat Daftar Kamera");
        System.out.println("2. Tambah Kamera");
        System.out.println("3. Update Kamera");
        System.out.println("4. Hapus Kamera");
        System.out.println("5. Sewa Kamera");
        System.out.println("6. Kembalikan Kamera");
        System.out.println("7. Lihat Semua Transaksi");
        System.out.println("0. Logout");
        System.out.print("Pilih menu: ");
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
