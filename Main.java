import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AplikasiLaundry app = new AplikasiLaundry();
        app.inisialisasiData();

        System.out.println("=== LOGIN ADMIN ===");
        boolean login = false;
        while (!login) {
            login = app.loginAdmin(input);
        }

        int pilih;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Kelola Pelanggan");
            System.out.println("2. Kelola Layanan");
            System.out.println("3. Kelola Pesanan");
            System.out.println("4. Ubah Status Cucian");
            System.out.println("5. Lihat Laporan Pendapatan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = input.nextInt(); input.nextLine();

            switch (pilih) {
                case 1 -> app.kelolaPelanggan(input);
                case 2 -> app.kelolaLayanan(input);
                case 3 -> app.kelolaPesanan(input);
                case 4 -> app.ubahStatusPesanan(input);
                case 5 -> app.lihatLaporan();
                case 6 -> System.out.println("Keluar dari aplikasi...");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 6);

        input.close();
    }
}
