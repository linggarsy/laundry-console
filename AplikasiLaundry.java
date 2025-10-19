import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiLaundry {
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();
    private ArrayList<LayananLaundry> daftarLayanan = new ArrayList<>();
    private ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    private Admin adminAktif;

    public void inisialisasiData() {
        adminAktif = new Admin("A1", "admin", "123");
        daftarLayanan.add(new LayananLaundry("L1", "Cuci Kering", 5000));
        daftarLayanan.add(new LayananLaundry("L2", "Cuci Setrika", 8000));
        daftarPelanggan.add(new Pelanggan("P1", "Budi", "08123456789"));
    }

    public boolean loginAdmin(Scanner input) {
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        if (adminAktif.login(username, password)) {
            System.out.println("Login berhasil!");
            return true;
        } else {
            System.out.println("Username atau password salah!");
            return false;
        }
    }

    public void kelolaPelanggan(Scanner input) {
        System.out.println("=== MENU PELANGGAN ===");
        System.out.println("1. Tambah Data");
        System.out.println("2. Lihat Data");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("ID Pelanggan: ");
            String id = input.nextLine();
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("No HP: ");
            String noHp = input.nextLine();
            daftarPelanggan.add(new Pelanggan(id, nama, noHp));
            System.out.println("Data pelanggan berhasil ditambahkan!");
        } else if (pilihan == 2) {
            System.out.println("=== Daftar Pelanggan ===");
            for (Pelanggan p : daftarPelanggan) p.lihatData();
        }
    }

    public void kelolaLayanan(Scanner input) {
        System.out.println("=== MENU LAYANAN ===");
        System.out.println("1. Tambah Data");
        System.out.println("2. Lihat Data");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            System.out.print("ID Layanan: ");
            String id = input.nextLine();
            System.out.print("Nama Layanan: ");
            String nama = input.nextLine();
            System.out.print("Harga per Kg: ");
            double harga = input.nextDouble();
            input.nextLine();
            daftarLayanan.add(new LayananLaundry(id, nama, harga));
            System.out.println("Data layanan berhasil ditambahkan!");
        } else if (pilihan == 2) {
            System.out.println("=== Daftar Layanan ===");
            for (LayananLaundry l : daftarLayanan) l.lihatData();
        }
    }

    public void kelolaPesanan(Scanner input) {
        System.out.println("=== MENU PESANAN ===");
        System.out.println("1. Tambah Data");
        System.out.println("2. Lihat Data");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();
        input.nextLine();

        if (pilihan == 1) {
            tambahData(input);
        } else if (pilihan == 2) {
            lihatData();
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private void tambahData(Scanner input) {
        System.out.println("\n=== Tambah Pesanan ===");
        System.out.print("ID Pesanan: ");
        String id = input.nextLine();

        System.out.println("Daftar Pelanggan:");
        for (Pelanggan p : daftarPelanggan) p.lihatData();
        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = input.nextLine();

        System.out.println("Daftar Layanan:");
        for (LayananLaundry l : daftarLayanan) l.lihatData();
        System.out.print("Masukkan ID Layanan: ");
        String idLayanan = input.nextLine();

        System.out.print("Berat (kg): ");
        double berat = input.nextDouble();
        input.nextLine();

        Pelanggan pelanggan = null;
        LayananLaundry layanan = null;
        for (Pelanggan p : daftarPelanggan)
            if (p.getId().equalsIgnoreCase(idPelanggan)) pelanggan = p;
        for (LayananLaundry l : daftarLayanan)
            if (l.getId().equalsIgnoreCase(idLayanan)) layanan = l;

        if (pelanggan != null && layanan != null) {
            Pesanan pesanan = new Pesanan(id, pelanggan, layanan, berat);
            pesanan.hitungTotal();
            daftarPesanan.add(pesanan);
            System.out.println("Pesanan berhasil dibuat!");
        } else {
            System.out.println("Data pelanggan atau layanan tidak ditemukan!");
        }
    }

    private void lihatData() {
        System.out.println("\n=== Daftar Pesanan ===");
        if (daftarPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            for (Pesanan p : daftarPesanan) p.lihatData();
        }
    }

    public void ubahStatusPesanan(Scanner input) {
        System.out.println("\n=== MENU UPDATE STATUS ===");
        System.out.print("Masukkan ID Pesanan: ");
        String id = input.nextLine();
        for (Pesanan p : daftarPesanan) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.print("Status baru (Proses/Selesai): ");
                String statusBaru = input.nextLine();
                p.ubahStatus(statusBaru);
                System.out.println("Status berhasil diubah!");
                return;
            }
        }
        System.out.println("Pesanan tidak ditemukan.");
    }

    public void lihatLaporan() {
        double total = 0;
        System.out.println("=== LAPORAN PENDAPATAN ===");
        for (Pesanan p : daftarPesanan) {
            if (p.getStatus().equalsIgnoreCase("Selesai")) {
                p.lihatData();
                total += p.getTotalHarga();
            }
        }
        System.out.println("Total Pendapatan: Rp " + total);
    }
}
