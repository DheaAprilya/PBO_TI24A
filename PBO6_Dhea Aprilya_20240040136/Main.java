import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pilih merk laptop
        System.out.println("============================");
        System.out.println("   Pilih Merk Laptop");
        System.out.println("============================");
        System.out.println("1. Lenovo");
        System.out.println("2. Toshiba");
        System.out.println("3. MacBook");
        System.out.print("Pilihan (1-3): ");

        int pilihan = sc.nextInt();
        sc.nextLine(); // flush buffer

        Laptop laptop;
        switch (pilihan) {
            case 1:  laptop = new Lenovo();  break;
            case 2:  laptop = new Toshiba(); break;
            case 3:  laptop = new MacBook(); break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        LaptopUser user = new LaptopUser(laptop);

        // Menu utama dengan Scanner
        System.out.println("\n============================");
        System.out.println("  Perintah yang tersedia:");
        System.out.println("  ON   - Menyalakan laptop");
        System.out.println("  OFF  - Mematikan laptop");
        System.out.println("  UP   - Menambah volume");
        System.out.println("  DOWN - Mengurangi volume");
        System.out.println("  EXIT - Keluar program");
        System.out.println("============================");

        while (true) {
            System.out.print("\nInput perintah: ");
            String input = sc.nextLine().trim().toUpperCase();

            switch (input) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeLaptopLouder();
                    break;
                case "DOWN":
                    user.makeLaptopSilence();
                    break;
                case "EXIT":
                    System.out.println("Program selesai. Terima kasih!");
                    sc.close();
                    return;
                default:
                    System.out.println("Perintah tidak dikenal! Gunakan: ON, OFF, UP, DOWN, EXIT");
            }
        }
    }
}