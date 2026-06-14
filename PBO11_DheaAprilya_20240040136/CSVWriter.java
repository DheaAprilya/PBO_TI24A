import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "new_students.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Input Data Mahasiswa ke CSV ===");
        System.out.print("Masukkan jumlah data yang ingin ditambahkan: ");
        int jumlah = Integer.parseInt(scanner.nextLine().trim());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            // Tulis header
            bw.write("NIM,NAMA,UMUR,PRODI");
            bw.newLine();

            for (int i = 1; i <= jumlah; i++) {
                System.out.println("\n--- Data Mahasiswa ke-" + i + " ---");

                System.out.print("NIM   : ");
                String nim = scanner.nextLine().trim();

                System.out.print("NAMA  : ");
                String nama = scanner.nextLine().trim();

                System.out.print("UMUR  : ");
                String umur = scanner.nextLine().trim();

                System.out.print("PRODI : ");
                String prodi = scanner.nextLine().trim();

                String dataLine = nim + "," + nama + "," + umur + "," + prodi;
                bw.write(dataLine);
                bw.newLine();

                System.out.println("Data berhasil ditambahkan.");
            }

            System.out.println("\nSemua data berhasil disimpan ke file: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
