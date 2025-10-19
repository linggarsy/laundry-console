public class Pesanan {
    private String id;
    private Pelanggan pelanggan;
    private LayananLaundry layanan;
    private double berat;
    private double totalHarga;
    private String status;

    public Pesanan(String id, Pelanggan pelanggan, LayananLaundry layanan, double berat) {
        this.id = id;
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.berat = berat;
        this.totalHarga = 0;
        this.status = "Proses";
    }

    public void hitungTotal() {
        totalHarga = berat * layanan.getHargaPerKg();
    }

    public void ubahStatus(String statusBaru) {
        this.status = statusBaru;
    }

    public void lihatData() {
        System.out.println("ID Pesanan: " + id +
                ", Pelanggan: " + pelanggan.getNama() +
                ", Layanan: " + layanan.getNamaLayanan() +
                ", Berat: " + berat + " kg" +
                ", Total: " + totalHarga +
                ", Status: " + status);
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }
}
