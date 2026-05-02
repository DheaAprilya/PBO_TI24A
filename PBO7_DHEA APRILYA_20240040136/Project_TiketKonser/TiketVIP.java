public class TiketVIP extends Tiket implements DapatDibeli {
    private String namaPembeli;
    private boolean includeMeetGreet;

    public TiketVIP(String idTiket, boolean includeMeetGreet) {
        super(idTiket, "VIP", 2_500_000);
        this.includeMeetGreet = includeMeetGreet;
    }

    @Override
    public double getHargaFinal() {
        return includeMeetGreet ? getHarga() + 500_000 : getHarga();
    }

    @Override
    public String getInfo() {
        return String.format("VIP%s | [%s] - Rp%.0f %s%s",
            includeMeetGreet ? "+M&G" : "",
            getIdTiket(), getHargaFinal(),
            isTerjual() ? "(TERJUAL)" : "(TERSEDIA)",
            namaPembeli != null ? " | Pembeli: " + namaPembeli : "");
    }

    @Override
    public boolean beli(String namaPembeli) {
        if (isTerjual()) {
            System.out.println("  [X] Tiket VIP " + getIdTiket() + " sudah habis!");
            return false;
        }
        this.namaPembeli = namaPembeli;
        setTerjual(true);
        System.out.printf("  [OK] %s berhasil beli tiket VIP%s %s (Rp%.0f)%n",
            namaPembeli, includeMeetGreet ? "+M&G" : "",
            getIdTiket(), getHargaFinal());
        return true;
    }

    @Override
    public void batalkan() {
        System.out.println("  [<] Tiket VIP " + getIdTiket() + " dibatalkan oleh " + namaPembeli);
        namaPembeli = null;
        setTerjual(false);
    }
}
