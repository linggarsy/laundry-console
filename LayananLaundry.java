import java.util.Scanner;

public class LayananLaundry {
    private String id;
    private String namaLayanan;
    private double hargaPerKg;

    public LayananLaundry(String id, String namaLayanan, double hargaPerKg) {
        this.id = id;
        this.namaLayanan = namaLayanan;
        this.hargaPerKg = hargaPerKg;
    }

    public void tambahData(Scanner input) {
        System.out.print("ID Layanan: ");
        id = input.nextLine();
        System.out.print("Nama Layanan: ");
        namaLayanan = input.nextLine();
        System.out.print("Harga per Kg: ");
        hargaPerKg = input.nextDouble();
        input.nextLine(); // clear buffer
    }

    public void lihatData() {
        System.out.println("ID: " + id + ", Nama Layanan: " + namaLayanan + ", Harga/kg: " + hargaPerKg);
    }

    public String getId() {
        return id;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public double getHargaPerKg() {
        return hargaPerKg;
    }
}
