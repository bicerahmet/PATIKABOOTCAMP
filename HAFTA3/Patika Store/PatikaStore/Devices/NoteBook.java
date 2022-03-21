package PatikaStore.Devices;

import PatikaStore.Marka;

import java.util.List;
import java.util.Scanner;

public class NoteBook extends Devices {
    public NoteBook() {
    }

    public NoteBook(int id, int birimFiyati, int indirimOrani,
                    int stockMiktari, String urunTuru, String urunAdi, String marka,float ekranBoyutu,int ram, int depolama) {
        super(id, birimFiyati, indirimOrani, stockMiktari, urunTuru, urunAdi, marka, ekranBoyutu, ram, depolama);
    }


    public void showNotebook(NoteBook noteBook) {

        System.out.format("| %-4d | %-30s | %-20d | %-15d | %-20d |%-10s | %-10d",
                noteBook.id, noteBook.urunAdi, noteBook.indirimOrani, noteBook.stockMiktari, noteBook.birimFiyati, noteBook.getMarka().getName(), noteBook.depolama);
        System.out.println();

    }

    public List<NoteBook> urunSilById(int idNum, List<NoteBook> noteBookList) {
        for (NoteBook noteBook : noteBookList) {
            if (noteBook.id == idNum) {
                noteBookList.remove(noteBook);
                System.out.println(" Id'si  " + idNum + " olan notebook silinmiştir");
                return noteBookList;            }
        }
        System.out.println(" Id'si  " + idNum + " olan notebook bulunamamıştır");
        return noteBookList;

    }

    public List<NoteBook> urunEkle(List<NoteBook> noteBookList) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Eklemek istediğniz notebook'un bilgilerini giriniz");
        System.out.println("Notebook'un Adi: ");
        String urunAdi = scan.nextLine();
        System.out.println("Notebook İndirim Oranı: ");
        int indirimOrani = scan.nextInt();
        System.out.println("Notebook Stok Miktarı: ");
        int stokMiktari = scan.nextInt();
        System.out.println("Notebook Birim Fiyatı: ");
        int birimFiyatı = scan.nextInt();
        System.out.println("Notebook Markasi: ");
        String notebookMarkasi = scan.nextLine();
        System.out.println("Notebook Ekran Boyutu: ");
        float ekranBoyutu = scan.nextFloat();
        System.out.println("Notebook Ram'i: ");
        int ram = scan.nextInt();
        System.out.println("Notebook Depolama Alanaı: ");
        int depolama = scan.nextInt();

        int id=0;
        for (NoteBook noteBook: noteBookList){
            id=noteBook.id;
        }

        NoteBook newNotebook = new NoteBook(id+1,birimFiyatı,indirimOrani,stokMiktari,  "Notebook",urunAdi,notebookMarkasi,ekranBoyutu,ram,depolama);
        noteBookList.add(newNotebook);
        return noteBookList;
    }

    public void notebookListeleById(int idAranan, List<NoteBook> noteBookList) {
        for (NoteBook noteBook : noteBookList) {
            if (noteBook.id == idAranan) {
                showNotebook(noteBook);
                return;
            }
        }
        System.out.println("Bu id'ye sahip bir notebook bulunmamaktadır.");
    }

    public void notebookListeleByMarka(String marka,  List<NoteBook> noteBookList) {
        for (NoteBook noteBook : noteBookList) {
            if (marka.equals(noteBook.getMarka().getName())) {
                showNotebook(noteBook);
                return;
            }
        }
        System.out.println("Bu markaya sahip bir notebook bulunmamaktadır.");
    }


}
