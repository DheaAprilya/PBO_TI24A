import java.util.ArrayList;
import java.util.Scanner;

// =============================================
// CLASS INDUK (Parent Class)
// =============================================
class Mahasiswa {
    protected String nim;
    protected String nama;
    protected double nilai;

    public Mahasiswa(String nim, String nama, double nilai) {
        this.nim   = nim;
        this.nama  = nama;
        this.nilai = nilai;
    }

    public String getNim()   { return nim; }
    public String getNama()  { return nama; }
    public double getNilai() { return nilai; }
}

// =============================================
// CLASS ANAK (Child Class) - mewarisi Mahasiswa
// =============================================
class MahasiswaPBO extends Mahasiswa {

    public MahasiswaPBO(String nim, String nama, double nilai) {
        super(nim, nama, nilai);
    }

    // Method menentukan grade
    public String getGrade() {
        if (nilai < 0 || nilai > 100) return "INPUT SALAH";
        else if (nilai >= 80)         return "A";
        else if (nilai >= 70)         return "B";
        else if (nilai >= 60)         return "C";
        else if (nilai >= 50)         return "D";
        else                          return "E";
    }

    // Method menentukan status kelulusan
    public boolean isLulus() {
        String g = getGrade();
        return g.equals("A") || g.equals("B") || g.equals("C");
    }

    // Method menampilkan data per mahasiswa
    public void tampilkanData() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + (int) nilai);
        if (nilai < 0 || nilai > 100) {
            System.out.println("Grade : Input nilai anda salah");
        } else {
            System.out.println("Grade : " + getGrade());
        }
        System.out.println("========================================");
    }
}

// =============================================
// CLASS MAIN
// =============================================
public class Inheritance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<MahasiswaPBO> list = new ArrayList<MahasiswaPBO>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        // Input data mahasiswa
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\n--- Mahasiswa ke-" + (i + 1) + " ---");
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Nilai : ");
            double nilai = sc.nextDouble();
            sc.nextLine();
            list.add(new MahasiswaPBO(nim, nama, nilai));
        }

        // Tampilkan data tiap mahasiswa
        System.out.println("\n========================================");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).tampilkanData();
        }

        // ---- Hitung statistik ----
        ArrayList<String> namaLulus      = new ArrayList<String>();
        ArrayList<String> namaTidakLulus = new ArrayList<String>();
        ArrayList<String> namaA          = new ArrayList<String>();
        ArrayList<String> namaB          = new ArrayList<String>();
        ArrayList<String> namaC          = new ArrayList<String>();
        ArrayList<String> namaD          = new ArrayList<String>();
        ArrayList<String> namaE          = new ArrayList<String>();
        ArrayList<String> nilaiStr       = new ArrayList<String>();
        double totalNilai = 0;

        for (int i = 0; i < list.size(); i++) {
            MahasiswaPBO mhs = list.get(i);
            double n = mhs.getNilai();

            if (n >= 0 && n <= 100) {
                totalNilai += n;
                nilaiStr.add(String.valueOf((int) n));

                if (mhs.isLulus()) {
                    namaLulus.add(mhs.getNama());
                } else {
                    namaTidakLulus.add(mhs.getNama());
                }

                String g = mhs.getGrade();
                if (g.equals("A"))      namaA.add(mhs.getNama());
                else if (g.equals("B")) namaB.add(mhs.getNama());
                else if (g.equals("C")) namaC.add(mhs.getNama());
                else if (g.equals("D")) namaD.add(mhs.getNama());
                else if (g.equals("E")) namaE.add(mhs.getNama());
            }
        }

        int validCount = namaA.size() + namaB.size() + namaC.size()
                       + namaD.size() + namaE.size();
        double rataRata = validCount > 0 ? totalNilai / validCount : 0;

        // ---- Tampilkan ringkasan ----
        System.out.println("Jumlah Mahasiswa : " + list.size());

        System.out.print("Jumlah Mahasiswa yg Lulus : " + namaLulus.size());
        if (!namaLulus.isEmpty()) System.out.print(" yaitu " + gabung(namaLulus));
        System.out.println();

        System.out.print("Jumlah Mahasiswa yg Tidak Lulus : " + namaTidakLulus.size());
        if (!namaTidakLulus.isEmpty()) System.out.print(" yaitu " + gabung(namaTidakLulus));
        System.out.println();

        if (!namaA.isEmpty())
            System.out.println("Jumlah Mahasiswa dengan Nilai A = " + namaA.size() + " yaitu " + gabung(namaA));
        if (!namaB.isEmpty())
            System.out.println("Jumlah Mahasiswa dengan Nilai B = " + namaB.size() + " yaitu " + gabung(namaB));
        if (!namaC.isEmpty())
            System.out.println("Jumlah Mahasiswa dengan Nilai C = " + namaC.size() + " yaitu " + gabung(namaC));
        if (!namaD.isEmpty())
            System.out.println("Jumlah Mahasiswa dengan Nilai D = " + namaD.size() + " yaitu " + gabung(namaD));
        if (!namaE.isEmpty())
            System.out.println("Jumlah Mahasiswa dengan Nilai E = " + namaE.size() + " yaitu " + gabung(namaE));

        // Rumus rata-rata
        String rumus = gabungPlus(nilaiStr);
        System.out.println("Rata-rata nilai mahasiswa adalah : "
                + rumus + " / " + validCount + " = " + rataRata);

        sc.close();
    }

    // Helper: gabung list dengan koma
    static String gabung(ArrayList<String> arr) {
        String hasil = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i > 0) hasil += ", ";
            hasil += arr.get(i);
        }
        return hasil;
    }

    // Helper: gabung list dengan tanda +
    static String gabungPlus(ArrayList<String> arr) {
        String hasil = "";
        for (int i = 0; i < arr.size(); i++) {
            if (i > 0) hasil += "+";
            hasil += arr.get(i);
        }
        return hasil;
    }
}
