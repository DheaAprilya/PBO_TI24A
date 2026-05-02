public abstract class Tiket {
    private String idTiket;
    private String kategori;
    private double harga;
    private boolean terjual;

    public Tiket(String idTiket, String kategori, double harga) {
        this.idTiket  = idTiket;
        this.kategori = kategori;
        this.harga    = harga;
        this.terjual  = false;
    }

    public String getIdTiket()  { return idTiket; }
    public String getKategori() { return kategori; }
    public double getHarga()    { return harga; }
    public boolean isTerjual()  { return terjual; }
    protected void setTerjual(boolean status) { this.terjual = status; }

    public abstract String getInfo();
    public abstract double getHargaFinal();

    @Override
    public String toString() {
        return String.format("[%s] %s - Rp%.0f %s",
            idTiket, kategori, getHargaFinal(),
            terjual ? "(TERJUAL)" : "(TERSEDIA)");
    }
}
