import java.util.Scanner;

public class Pelanggan {
    private String id;
    private String nama;
    private String noHp;

    public Pelanggan(String id, String nama, String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp = noHp;
    }

    public void tambahData(Scanner input) {
        System.out.print("ID Pelanggan: ");
        id = input.nextLine();
        System.out.print("Nama: ");
        nama = input.nextLine();
        System.out.print("No HP: ");
        noHp = input.nextLine();
    }

    public void lihatData() {
        System.out.println("ID: " + id + ", Nama: " + nama + ", No HP: " + noHp);
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
