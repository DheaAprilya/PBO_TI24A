import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   SISTEM INFORMASI AKADEMIK - PBO TUGAS 4 ");
        System.out.println("       Materi: Encapsulation                ");
        System.out.println("============================================");

        // ── Input Data Dosen 
        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Nama Dosen   : ");
        String teacherName = scanner.nextLine();
        System.out.print("Alamat Dosen : ");
        String teacherAddress = scanner.nextLine();

        Teacher teacher = new Teacher(teacherName, teacherAddress);
        System.out.println("\nData dosen berhasil dibuat: " + teacher);

        // ── Input Mata Kuliah yang Diampu 
        System.out.println("\n--- Input Mata Kuliah yang Diampu ---");
        System.out.print("Berapa mata kuliah yang ingin ditambahkan? ");
        int numMatkul = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numMatkul; i++) {
            System.out.print("Mata Kuliah " + (i + 1) + " : ");
            String matkul = scanner.nextLine();
            teacher.addCourse(matkul);
        }

        // ── Simulasi Hapus Mata Kuliah 
        System.out.println("\n--- Simulasi Hapus Mata Kuliah ---");
        System.out.print("Masukkan nama mata kuliah yang ingin dihapus: ");
        String removeMatkul = scanner.nextLine();
        teacher.removeCourse(removeMatkul);

        // ── Tampilkan Daftar Mata Kuliah Dosen 
        System.out.println("\n--- Daftar Mata Kuliah Dosen ---");
        System.out.println(teacher.tpString());

        // ── Input Data Mahasiswa 
        System.out.println("\n--- Input Data Mahasiswa ---");
        System.out.print("Nama Mahasiswa   : ");
        String studentName = scanner.nextLine();
        System.out.print("Alamat Mahasiswa : ");
        String studentAddress = scanner.nextLine();

        Student student = new Student(studentName, studentAddress);
        System.out.println("\nData mahasiswa berhasil dibuat: " + student);

        // ── Input Nilai Mahasiswa 
        System.out.println("\n--- Input Nilai Mahasiswa ---");
        System.out.print("Berapa mata kuliah yang ingin diinputkan nilainya? ");
        int numNilai = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numNilai; i++) {
            System.out.print("Mata Kuliah " + (i + 1) + " : ");
            String matkul = scanner.nextLine();
            System.out.print("Nilai          : ");
            int nilai = Integer.parseInt(scanner.nextLine().trim());
            student.addCourseGrade(matkul, nilai);
        }

        // ── Tampilkan Rekap Nilai 
        System.out.println("\n--- Rekap Nilai Mahasiswa ---");
        student.printGrades();
        System.out.printf("Rata-rata Nilai : %.2f%n", student.getAverageGrade());

        // ── Simulasi Update Alamat 
        System.out.println("\n--- Update Alamat Mahasiswa ---");
        System.out.print("Masukkan alamat baru mahasiswa: ");
        String newAddress = scanner.nextLine();
        student.setAddress(newAddress);
        System.out.println("Alamat berhasil diperbarui.");
        System.out.println("Data terbaru: " + student);

        // ── Ringkasan Akhir 
        System.out.println("\n============================================");
        System.out.println("             RINGKASAN AKHIR                ");
        System.out.println("============================================");
        System.out.println("Dosen   : " + teacher);
        System.out.println("Student : " + student);
        System.out.printf("IPK Sementara %s : %.2f%n", student.getName(), student.getAverageGrade());
        System.out.println("============================================");

        scanner.close();
    }
}
