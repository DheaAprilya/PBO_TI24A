import java.util.ArrayDeque;
import java.util.ArrayList;

public class ContohCollection {

    public static void main(String[] args) {

        // ARRAYLIST
        ArrayList<String> matkul = new ArrayList<>();

        // Menambahkan data
        matkul.add("Pemrograman Lanjut");
        matkul.add("Basis Data");
        matkul.add("Jaringan Komputer");
        matkul.add("Kecerdasan Buatan");

        System.out.println("=== ArrayList - Daftar Mata Kuliah ===");
        System.out.println("Isi awal: " + matkul);

        // Menghapus data
        matkul.remove("Basis Data");
        System.out.println("Setelah hapus 'Basis Data': " + matkul);

        // Mengakses data by index
        System.out.println("Matkul index ke-0: " + matkul.get(0));

        // Iterasi
        System.out.println("Semua matkul:");
        for (String m : matkul) {
            System.out.println("  - " + m);
        }

        System.out.println("Jumlah matkul: " + matkul.size());

        // ARRAYDEQUE sebagai QUEUE (FIFO)
        System.out.println("\n=== ArrayDeque sebagai Queue (FIFO) ===");
        ArrayDeque<String> antrian = new ArrayDeque<>();

        // offer() = masuk antrian dari belakang
        antrian.offer("Mahasiswa A");
        antrian.offer("Mahasiswa B");
        antrian.offer("Mahasiswa C");

        System.out.println("Antrian: " + antrian);

        // poll() = keluar dari depan (FIFO)
        while (!antrian.isEmpty()) {
            System.out.println("Dilayani: " + antrian.poll());
        }

        // ARRAYDEQUE sebagai STACK (LIFO)
        System.out.println("\n=== ArrayDeque sebagai Stack (LIFO) ===");
        ArrayDeque<String> tumpukan = new ArrayDeque<>();

        // push() = masuk dari atas
        tumpukan.push("Lantai 1");
        tumpukan.push("Lantai 2");
        tumpukan.push("Lantai 3");

        System.out.println("Tumpukan: " + tumpukan);

        // pop() = keluar dari atas (LIFO)
        while (!tumpukan.isEmpty()) {
            System.out.println("Keluar: " + tumpukan.pop());
        }
    }
}
