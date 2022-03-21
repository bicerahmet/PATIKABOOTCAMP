package com.company.Devices;


import java.util.List;
import java.util.Scanner;

public class CepTelefonu extends Devices {
    int pilGucu;
    String renk;

    public CepTelefonu() {
    }

    public CepTelefonu(int id, int birimFiyati, int indirimOrani, int stockMiktari,
                       String urunTuru, String urunAdi, String marka, float ekranBoyutu, int ram, int depolama, int pilGucu, String renk) {
        super(id, birimFiyati, indirimOrani, stockMiktari, urunTuru, urunAdi, marka, ekranBoyutu, ram, depolama);
        this.pilGucu = pilGucu;
        this.renk = renk;
    }

    public void showCepTelefonu(CepTelefonu cepTelefonu) {
        System.out.format("| %-4d | %-30s | %-20d | %-15d | %-20d |%-10s | %-20d | %-20d | %-20s", cepTelefonu.id, cepTelefonu.urunAdi,
                cepTelefonu.indirimOrani, cepTelefonu.stockMiktari, cepTelefonu.birimFiyati,
                cepTelefonu.getMarka().getName(), cepTelefonu.depolama, cepTelefonu.pilGucu, cepTelefonu.renk);
        System.out.println();
    }

    public List<CepTelefonu> urunSilById(int idNum, List<CepTelefonu> cepTelefonuList) {

        for (CepTelefonu cepTelefonu : cepTelefonuList) {
            if (cepTelefonu.id == idNum) {
                cepTelefonuList.remove(cepTelefonu);
                System.out.println(" Id'si  " + idNum + " olan cep telefonu silinmiştir");
                return cepTelefonuList;
            }
        }
        System.out.println(" Id'si  " + idNum + " olan cep telefonu bulunamamıştır");
        return cepTelefonuList;
    }

    public List<CepTelefonu> urunEkle(List<CepTelefonu> cepTelefonuList) {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        System.out.println("Eklemek istediğniz telefonun bilgilerini giriniz: ");
        System.out.println("Telefonun Adi: ");
        String urunAdi = scanStr.nextLine();
        System.out.println("Telefonun İndirim Oranı: ");
        int indirimOrani = scanInt.nextInt();
        System.out.println("Telefonun Stok Miktarı: ");
        int stokMiktari = scanInt.nextInt();
        System.out.println("Telefonun Birim Fiyatı: ");
        int birimFiyatı = scanInt.nextInt();
        System.out.println("Telefonun Markasi: ");
        String telefonMarkasi = scanStr.nextLine();
        System.out.println("Telefonun Hafıza Bilgisi: ");
        int hafizaBilgisi = scanInt.nextInt();
        System.out.println("Cep telefonu Ekran Boyutu: ");
        float ekranBoyutu = scanInt.nextFloat();
        System.out.println("Cep Telefonu Ram'i: ");
        int ram = scanInt.nextInt();
        System.out.println("Cep telefonu Pil Gücü: ");
        int pilGucu = scanInt.nextInt();
        System.out.println("Telefonun Rengi: ");
        String telefonRenk = scanStr.nextLine();

        int id = 0;
        for (CepTelefonu cepTelefonu : cepTelefonuList) {
            id = cepTelefonu.id;
        }

        CepTelefonu newCepTelefonu = new CepTelefonu(id + 1, birimFiyatı, indirimOrani, stokMiktari, "Cep Telefonu",
                urunAdi, telefonMarkasi, ekranBoyutu, ram, hafizaBilgisi, pilGucu, telefonRenk);
        cepTelefonuList.add(newCepTelefonu);

        return cepTelefonuList;
    }

    public void cepTelefonuListeleById(int id, List<CepTelefonu> cepTelefonuList) {
        for (CepTelefonu cepTelefonu : cepTelefonuList) {
            if (id == cepTelefonu.id) {
                showCepTelefonu(cepTelefonu);
                return;
            }
        }
        System.out.println("Bu id'ye sahip bir cep telefonu bulunmamaktadır.");
    }

    public void cepTelefonuListeleByMarka(String marka, List<CepTelefonu> cepTelefonuList) {
        for (CepTelefonu cepTelefonu : cepTelefonuList) {
            if (marka.equals(cepTelefonu.getMarka().getName())) {
                showCepTelefonu(cepTelefonu);
            }
        }
        System.out.println("Bu markaya sahip bir cep telefonu bulunmamaktadır.");

    }


}
