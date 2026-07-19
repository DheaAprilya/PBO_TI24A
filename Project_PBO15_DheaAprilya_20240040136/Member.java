// Member.java
// INHERITANCE: extends User
public class Member extends User {

    public Member(String username, String password) {
        super(username, password);
    }

    // POLYMORPHISM: menu Member lebih terbatas dibanding Admin
    @Override
    public void tampilkanMenu() {
        System.out.println("===== MENU MEMBER =====");
        System.out.println("1. Lihat Daftar Kamera");
        System.out.println("2. Sewa Kamera");
        System.out.println("3. Kembalikan Kamera");
        System.out.println("4. Lihat Riwayat Transaksi Saya");
        System.out.println("0. Logout");
        System.out.print("Pilih menu: ");
    }

    @Override
    public String getRole() {
        return "Member";
    }
}
