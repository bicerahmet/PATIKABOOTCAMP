package PatikaStore;

import PatikaStore.Devices.CepTelefonu;
import PatikaStore.Devices.NoteBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class StatikUrunVeMarkaEkleme {

    public TreeSet<Marka> markalarListesi;
    public List<CepTelefonu> telefonlarListesi = new ArrayList<>();
    public List<NoteBook> notebooklarListesi = new ArrayList<>();

    public TreeSet<Marka> addMarka() {
        markalarListesi = new TreeSet<>(new Comparator<Marka>() {
            @Override
            public int compare(Marka o1, Marka o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        markalarListesi.add(new Marka(1, "Samsung"));
        markalarListesi.add(new Marka(2, "Lenovo"));
        markalarListesi.add(new Marka(3, "Apple"));
        markalarListesi.add(new Marka(4, "Huawei"));
        markalarListesi.add(new Marka(5, "Casper"));
        markalarListesi.add(new Marka(6, "Asus"));
        markalarListesi.add(new Marka(7, "HP"));
        markalarListesi.add(new Marka(8, "Xiaomi"));
        markalarListesi.add(new Marka(9, "Moster"));
        return markalarListesi;
    }

    public List<CepTelefonu> addCeptelefonu() {
        telefonlarListesi.add(new CepTelefonu(1, 3000, 20, 100, "Cep Telefonu",
                "Samsung Galaxy A51", "Samsung", 6, 8, 128, 4300, "Kırmızı"));
        telefonlarListesi.add(new CepTelefonu(2, 10000, 15, 100, "Cep Telefonu",
                "Iphone 11", "Apple", 5, 8, 128, 4500, "Mavi"));
        telefonlarListesi.add(new CepTelefonu(3, 7500, 20, 100, "Cep Telefonu",
                "Redmi Note 10 Pro 8 GB", "Xiaomi", 7, 16, 128, 4500, "Siyah"));
        telefonlarListesi.add(new CepTelefonu(4, 1200, 30, 100, "Cep Telefonu",
                "Samsung A01", "Samsung", 5, 8, 64, 4000, "Gold"));
        return telefonlarListesi;
    }


    public List<NoteBook> addNoteBook() {
        notebooklarListesi.add(new NoteBook(1, 7000, 20, 100, "Notebook",
                "Huawei Matebook", "Huawei", 15, 16, 512));
        notebooklarListesi.add(new NoteBook(2, 8000, 14, 80, "Notebook",
                "Lenovo V14 IGL", "Lenovo", 14, 32, 1024));
        notebooklarListesi.add(new NoteBook(3, 8500, 23, 100, "Notebook",
                "Asus Tuf Gamin", "Asus", 14, 8, 256));
        notebooklarListesi.add(new NoteBook(4, 10000, 5, 80, "Notebook",
                "Macbook", "Apple", 15, 32, 1024));
        return notebooklarListesi;

    }
}

