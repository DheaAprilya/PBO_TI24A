public class HandPhone {
    String jenis_hp;
    int tahun_pembuatan;

    // PERBAIKAN 1: Hapus "String" di depan, tambah "public void"
    public void setDataHP(String jenis_hp, int tahun_pembuatan) {
        this.jenis_hp = jenis_hp;                        // PERBAIKAN 2: tambah "this."
        this.tahun_pembuatan = tahun_pembuatan;          // PERBAIKAN 2: tambah "this."
    }

    // PERBAIKAN 3: Tambah "public" dan isi body method dengan return
    public String getJenisHP() {
        return jenis_hp;
    }

    // PERBAIKAN 4: Tambah "public" dan return, ubah return type ke String
    public String getTahunPembuatan() {
        return String.valueOf(tahun_pembuatan);
    }

    public static void main(String[] args) {
        HandPhone hp = new HandPhone();

        // PERBAIKAN 5: Ganti variabel dengan nilai konkret
        hp.setDataHP("Samsung", 2023);

        // PERBAIKAN 6: Tambah System.out.println() dan tanda semicolon
        System.out.println(hp.getJenisHP());
        System.out.println(hp.getTahunPembuatan());
    }
}