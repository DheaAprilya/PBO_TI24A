import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        String csvSplitBy = ",";
        int indeks = 0;
        int jumlahBaris = 0;

        System.out.println("NIM, NAMA, UMUR, PRODI");
        System.out.println("----------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                indeks++;
                if (indeks > 1) {
                    String[] student = line.split(csvSplitBy);
                    System.out.println(student[0] + ", " + student[1] + ", " +
                                       student[2] + ", " + student[3]);
                    jumlahBaris++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------");
        System.out.println("Jumlah baris data (tidak termasuk header): " + jumlahBaris);
    }
}
