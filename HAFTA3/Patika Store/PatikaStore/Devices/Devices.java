package PatikaStore.Devices;

import PatikaStore.Marka;

public class Devices {
    int id;
    int birimFiyati;
    int indirimOrani;
    int stockMiktari;
    String urunTuru;
    String urunAdi;
    Marka marka = new Marka();
    float ekranBoyutu;
    int ram;
    int depolama;

    public Devices() {
    }

    public Devices(int id, int birimFiyati, int indirimOrani, int stockMiktari, String urunTuru,
                   String urunAdi, String marka, float ekranBoyutu, int ram, int depolama) {
        this.id = id;
        this.birimFiyati = birimFiyati;
        this.indirimOrani = indirimOrani;
        this.stockMiktari = stockMiktari;
        this.urunTuru = urunTuru;
        this.urunAdi = urunAdi;
        this.marka.setName(marka);
        this.ekranBoyutu = ekranBoyutu;
        this.ram = ram;
        this.depolama = depolama;
    }

    public Marka getMarka() {
        return marka;
    }

}
