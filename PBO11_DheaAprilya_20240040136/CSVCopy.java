import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String sourceFile = "students.csv";
        String destinationFile = "students_copy.csv";
        String line;
        int jumlahBaris = 0;

        System.out.println("=== Program Copy File CSV ===");
        System.out.println("Sumber      : " + sourceFile);
        System.out.println("Tujuan      : " + destinationFile);
        System.out.println("-----------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile))) {

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                jumlahBaris++;
            }

            System.out.println("Berhasil menyalin " + jumlahBaris + " baris (termasuk header).");
            System.out.println("File berhasil disimpan ke: " + destinationFile);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
