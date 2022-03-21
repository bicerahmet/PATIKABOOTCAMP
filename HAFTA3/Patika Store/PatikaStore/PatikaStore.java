package PatikaStore;

import PatikaStore.Devices.CepTelefonu;
import PatikaStore.Devices.NoteBook;

import java.util.*;

public class PatikaStore {

    public StatikUrunVeMarkaEkleme statikUrunVeMarkaEkleme = new StatikUrunVeMarkaEkleme();
    public CepTelefonu cepTelefonu = new CepTelefonu();
    public NoteBook noteBook = new NoteBook();
    Scanner scan = new Scanner(System.in);

    public TreeSet<Marka> markalarListesi = statikUrunVeMarkaEkleme.addMarka();
    public List<CepTelefonu> cepTelefonListesi = statikUrunVeMarkaEkleme.addCeptelefonu();
    ;
    public List<NoteBook> notebookListesi = statikUrunVeMarkaEkleme.addNoteBook();

    //PatikaStore'un giris ekranidir.
    public void giris() {
        System.out.println("PatikaStore Ürün Yönetim Paneline Hoşgeldiniz ! \n" +
                "1 - Notebook İşlemleri\n" +
                "2 - Cep Telefonu İşlemleri\n" +
                "3 - Marka Listele\n" +
                "0 - Çıkış Yap\n" +
                "Tercihiniz: ");

        int customerSelection = scan.nextInt();
        menu(customerSelection);
    }

    //musterinin cep telefonları ve notebooklar ile yapacakları işlemleri seçmelerini sağlar
    public int musteriIslemleri(String urun) {
        System.out.println("1- " + urun + " listele");
        System.out.println("2- Yeni " + urun + " ekle");
        System.out.println("3- Var olan bir " + urun + " sil");
        System.out.println("4- Id ile " + urun + " ara");
        System.out.println("5- Marka adıyla " + urun + " ara");
        System.out.println("6- Ana menüye dön");
        int customerChoice = scan.nextInt();
        return customerChoice;
    }

    public void menu(int selection) {
        int choice;
        switch (selection) {
            case 0:
                System.out.println("Çıkış yapıldı. PatikaStore ailesi olarak iyi günler dileriz. ");
                break;
            case 1:
                choice = musteriIslemleri("Notebook");
                notebookIslemleri(choice);
                break;
            case 2:
                choice = musteriIslemleri("Cep telefonu");
                cepTelefonuIslemleri(choice);
                break;
            case 3:
                for (Marka marka : markalarListesi) {
                    System.out.println(marka.getName());
                }
                baskaIslem();
                break;
            default:
                System.out.println("Geçersiz bir seçim yaptınız. ");
                giris();
                break;
        }
    }

    public void notebookIslemleri(int choice) {
        Scanner scan = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Notebooklar listeleniyor:");
                System.out.println("| ID   | Ürün Adı                       | İndirim Oranı        | Stok Miktarı    | Fiyatı               | Marka     | Depolama ");
                for (NoteBook noteBook : notebookListesi) {
                    noteBook.showNotebook(noteBook);
                }
                baskaIslem();
                break;
            case 2:
                notebookListesi = noteBook.urunEkle(notebookListesi);
                for (NoteBook noteBook : notebookListesi) {
                    noteBook.showNotebook(noteBook);
                }
                baskaIslem();
                break;
            case 3:
                System.out.println("Silmek istediğiniz notebook'un id numarasını girin: ");
                int id = scan.nextInt();
                notebookListesi = noteBook.urunSilById(id, notebookListesi);

                for (NoteBook noteBook : notebookListesi) {
                    noteBook.showNotebook(noteBook);
                }
                baskaIslem();
                break;
            case 4:
                System.out.println("Filtreleme için id girin:");
                id = scan.nextInt();
                noteBook.notebookListeleById(id, notebookListesi);
                baskaIslem();
                break;
            case 5:
                System.out.println("Filtreleme için marka girin:");
                String marka = scan.nextLine();
                noteBook.notebookListeleByMarka(marka, notebookListesi);
                baskaIslem();
                break;
            case 6:
                giris();
            default:
                System.out.println("Geçersiz bir işlem sectiniz.");
                musteriIslemleri("Notebbok");
        }
    }

    public void cepTelefonuIslemleri(int choice) {
        Scanner scan = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println("Cep telefonları listeleniyor:");
                System.out.println("| ID   | Ürün Adı                       | İndirim Oranı        | Stok Miktarı    | Fiyatı               | Marka     | Depolama             | Pil Gücü             | Renk ");

                for (CepTelefonu cepTelefonu : cepTelefonListesi) {
                    cepTelefonu.showCepTelefonu(cepTelefonu);
                }
                baskaIslem();
                break;
            case 2:
                cepTelefonListesi = cepTelefonu.urunEkle(cepTelefonListesi);
                for (CepTelefonu cepTelefonu : cepTelefonListesi) {
                    cepTelefonu.showCepTelefonu(cepTelefonu);
                }
                baskaIslem();
                break;
            case 3:
                System.out.println("Silmek istediğiniz cep telefonun id numarasını girin: ");
                int id = scan.nextInt();
                cepTelefonListesi = cepTelefonu.urunSilById(id, cepTelefonListesi);

                for (CepTelefonu cepTelefonu : cepTelefonListesi) {
                    cepTelefonu.showCepTelefonu(cepTelefonu);
                }

                baskaIslem();
                break;
            case 4:
                System.out.println("Filtreleme için id girin:");
                id = scan.nextInt();
                cepTelefonu.cepTelefonuListeleById(id, cepTelefonListesi);
                baskaIslem();
                break;
            case 5:
                System.out.println("Filtreleme için marka girin:");
                String marka = scan.nextLine();
                cepTelefonu.cepTelefonuListeleByMarka(marka, cepTelefonListesi);
                baskaIslem();
                break;
            default:
                System.out.println("Geçersiz bir işlem sectiniz.");
                musteriIslemleri("Cep Telefonu");
        }
    }

    public void baskaIslem() {
        System.out.println("Başka bir işlem yapmak istiyor musunuz? ");
        System.out.println("E(evet) / H(hayır)");
        Scanner scan = new Scanner(System.in);
        String eVeyaH = scan.nextLine();
        eVeyaH = eVeyaH.toUpperCase();
        if (eVeyaH.equals("E")) {
            giris();
        } else {
            System.out.println("Çıkış yapıldı. PatikaStore ailesi olarak iyi günler dileriz. ");
        }
    }


}
