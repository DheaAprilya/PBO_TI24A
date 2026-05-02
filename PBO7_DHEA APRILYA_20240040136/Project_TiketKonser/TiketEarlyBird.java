public class TiketEarlyBird extends Tiket implements DapatDibeli {
    private static final double DISKON = 0.20;
    private String namaPembeli;

    public TiketEarlyBird(String idTiket) {
        super(idTiket, "Early Bird", 850_000);
    }

    @Override
    public double getHargaFinal() {
        return getHarga() * (1 - DISKON);
    }

    @Override
    public String getInfo() {
        return String.format("Early Bird (hemat 20%%) | [%s] - Rp%.0f %s%s",
            getIdTiket(), getHargaFinal(),
            isTerjual() ? "(TERJUAL)" : "(TERSEDIA)",
            namaPembeli != null ? " | Pembeli: " + namaPembeli : "");
    }

    @Override
    public boolean beli(String namaPembeli) {
        if (isTerjual()) {
            System.out.println("  [X] Tiket Early Bird " + getIdTiket() + " sudah habis!");
            return false;
        }
        this.namaPembeli = namaPembeli;
        setTerjual(true);
        System.out.printf("  [OK] %s berhasil beli Early Bird %s (Rp%.0f - hemat Rp%.0f!)%n",
            namaPembeli, getIdTiket(), getHargaFinal(), getHarga() * DISKON);
        return true;
    }

    @Override
    public void batalkan() {
        System.out.println("  [<] Tiket Early Bird " + getIdTiket() + " dibatalkan.");
        namaPembeli = null;
        setTerjual(false);
    }
}
