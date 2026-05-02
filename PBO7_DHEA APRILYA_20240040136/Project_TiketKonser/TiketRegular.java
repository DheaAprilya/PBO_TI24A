public class TiketRegular extends Tiket implements DapatDibeli {
    private String namaPembeli;

    public TiketRegular(String idTiket) {
        super(idTiket, "Regular", 850_000);
    }

    @Override
    public double getHargaFinal() {
        return getHarga();
    }

    @Override
    public String getInfo() {
        return "Regular | " + this +
            (namaPembeli != null ? " | Pembeli: " + namaPembeli : "");
    }

    @Override
    public boolean beli(String namaPembeli) {
        if (isTerjual()) {
            System.out.println("  [X] Tiket " + getIdTiket() + " sudah habis!");
            return false;
        }
        this.namaPembeli = namaPembeli;
        setTerjual(true);
        System.out.println("  [OK] " + namaPembeli + " berhasil beli tiket Regular " + getIdTiket());
        return true;
    }

    @Override
    public void batalkan() {
        System.out.println("  [<] Tiket " + getIdTiket() + " dibatalkan oleh " + namaPembeli);
        namaPembeli = null;
        setTerjual(false);
    }
}
