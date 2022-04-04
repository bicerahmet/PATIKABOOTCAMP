package Bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {


    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args){

        boolean again = true;
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);


        //Hoşgeldiniz
        System.out.println("\n\nSpring Bank'a Hoşgeldiniz.\n");
        System.out.println("Bankamızda henüz hiçbir kullanıcı bulunmamaktadır. Yeni kullanıcı eklemeniz gerekmektedir.\n");
        System.out.println("Devam etmek için herhangi bir tuşa basınız.\n...");
        String c = scannerString.nextLine();

        //İlk kullanıcı ile programın başlangıcı yapılıyor.
        users.add(addUser());

        while(again) {

                //Ana menü
                System.out.println("1.) Yeni bir kullanıcı oluştur.\n" +
                                "2.) Hesap İşlemleri.\n" +
                                "3.) Çıkış Yapmak için.\n");
                
                switch (scannerInt.nextInt()) {
                    case 1 -> {
                        users.add(addUser());
                    }
                    case 2 -> {
                        accountOperations();
                    }
                    case 3 -> {
                        again = false;
                    }
                    default -> {
                    }
                }



        }

    }

    //Bankaya müşteri/kullanıcı ekleme
    public static User addUser(){
        //Yeni hesap ekleme

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerLong = new Scanner(System.in);

        String name;
        String Id;
        String birthDate;
        String password = "";
        long balance;
        long debt;

        //Kullanıcı bilgileri
        System.out.println("İsim ve soyisim: ");
        name = scannerString.nextLine();
        System.out.println("T.C. Kimlik numaranızı giriniz: ");
        Id = scannerString.nextLine();
        System.out.println("Lütfen doğum tarihinizi gg/aa/yy formatında girin: ");
        birthDate = scannerString.nextLine();
        //BirthDate format checker ekle
        String[] tempBirthDate = birthDate.split("/");

        boolean birthChecker = true;

        //Şifre ile doğum tarihi bağlantısı kontrol ediliyor
        while(birthChecker) {
            System.out.println("İçerisinde doğum tarihinizin olmadığı bir şifre belirleyiniz: ");
            password = scannerString.nextLine();

            birthChecker = false;
            for (String s : tempBirthDate) {
                if (password.contains(s)) {
                    System.out.println("Şifreniz doğum tarihinizi içeremez!\n");
                    birthChecker = true;
                    break;
                }
            }

        }

        System.out.println(name + " isimli kullanıcı başarıyla oluşturulmuştur.\n");

        
        //Borç ve bakiye bilgileri
        System.out.println(name + "isimli kullanıcının hesap bakiyesini girin.");
        balance = scannerLong.nextLong();
        System.out.println(name + "isimli kullanıcının bankamıza olan borcunu girin.");
        debt = scannerLong.nextLong();

        //Oluşturulan kullanıcı döndürülüyor
        return new User(name, Id, birthDate, password, balance, debt);

    }

    
    public static void accountOperations(){

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerLong = new Scanner(System.in);

        boolean userFound = true;

        //Hesaba giriş yapmak isteyen kişinin kimliği doğrulanıyor
        System.out.println("İşlem yapmak istediğiniz kullanıcıya ait İsim veya T.C. Kimlik numarası giriniz:\n");
        String nameOrId = scannerString.nextLine();
        User temp = findUser(nameOrId);
        System.out.println("Merhaba " + temp.name + "!\nGiriş yapmak için lütfen şifrenizi girin.");

        //Hesaba giriş yapmak için parola doğrulaması yapılıyor
        for(int i=0; i<3; i++){
            if(temp.getPassword().equals(scannerString.nextLine())){
                System.out.println("Sayın " + temp.name + ", Java Bank hesabınıza hoşgeldiniz.\n");
                break;
            } else{
                System.out.println("Hatalı şifre! Lütfen tekrar deneyiniz. Kalan deneme hakkınız: " + (2-i));
                if(i == 2) return;
            }
        }

        //Hesap işlemleri
        System.out.println("1.) Kullanıcı Bilgilerini Görüntüle.");
        System.out.println("2.) Hesap Bilgilerini Göüntüle.");
        System.out.println("3.) Para Yatırma.");
        System.out.println("4.) Para Çekme.");
        System.out.println("5.) Para Transferi.");
        System.out.println("6.) Kredi Kartı Borcu Ödeme.");
        System.out.println("7.) Kredi Çekme.");
        System.out.println("8.) Ana Menüye Dön.");

        switch (scannerInt.nextInt()) {
            case 1 ->{
                temp.printUserInfo();
            }
            case 2 -> {
                temp.printAccountInfo();
            }
            case 3 -> {
                System.out.println("Yatırmak istediğiniz para miktarı:");
                deposit(temp, scannerLong.nextLong());
            }
            case 4 -> {
                System.out.println("Çekmek istediğiniz para miktarı:");
                withdraw(temp, scannerLong.nextLong());
            }
            case 5 -> {
                balanceTransfer(temp);
            }
            case 6 -> {
                System.out.println("Almak istediğiniz kredi miktarını girin.");
                loan(temp, scannerLong.nextLong());
            }
            case 7 -> {
                System.out.println("Ödemek istediğiniz kredi kart borcu miktarını girin.");
                loanPayment(temp, scannerLong.nextLong());
            }
            case 8 -> {

            }
            default -> {

            }
        }
    }

    //Para transferi
    public static void balanceTransfer(User user){

        System.out.println("Lütfen paranızı transfer etmek istediğiniz kullanıcının ismini girin.");

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerLong = new Scanner(System.in);
        
        String name = scannerString.nextLine();
        User temp = findUser(name);
        System.out.println("Parayı göndermek istediğiniz hesabın sahibi: " + temp.name);
        boolean flag = true;

        while(flag) {
            System.out.println("Göndermek istediğiniz miktarı girin.");

            long transfer = scannerLong.nextLong();

            if(user.getBalance() < transfer){
                System.out.println("Bakiyeniz yetersiz. Miktarı tekrar giriniz.");
            }
            else{
                user.setBalance(user.getBalance()-transfer);
                temp.setBalance(temp.getBalance()+transfer);
                System.out.println(user.name + "isimli kullanıcıdan " + temp.name + " isimli kullanıcıya " + transfer + " tl transfer edilmiştir.");
                break;
            }

        }

    }

    //Para yatırma
    public static void deposit(User user, long money){
        user.setBalance(user.getBalance() + money);
    }

    //Para Çekme
    public static void withdraw(User user, long money){
        user.setBalance(user.getBalance() - money);
    }

    //Listemizden kullanıcı bulan metod
    public static User findUser(String name){

        boolean userFound = true;
        User temp;
        Scanner scannerString = new Scanner(System.in);

        while(userFound) {
            Iterator<User> iter = users.iterator();

            while (iter.hasNext()) {
                temp = iter.next();
                if (temp.getID().equals(name) || temp.name.equals(name)) {
                    userFound = false;
                    return temp;
                }
            }
            if (userFound) {
                System.out.println("Aradığınız kullanıcı bulunamadı. Tekrar Deneyin.\n");

                name = scannerString.nextLine();
            }
        }

        return null;

    }

    //Bankadan borç almak için kullanılan metod
    public static void loan(User user, long money){
        System.out.println("Bankamızdan " + money + " miktarında kredi çektiniz..");
        user.setDebt(user.getBalance()+money);
        user.setBalance(user.getBalance()+money);
        System.out.println("Hesabınızdaki güncel borç miktarı: " + user.getDebt() + "\nHesabınızın güncel bakiyesi: " + user.getBalance());
    }

    //bankaya olan borcu ödemek için kullanılan metod
    public static void loanPayment(User user, long money){
        System.out.println("Bankamızdaki " + user.getDebt() + " olan borcunuzun " + money + " kadarını ödediniz..");
        user.setDebt(user.getBalance()-money);
        user.setBalance(user.getBalance()-money);
        System.out.println("Hesabınızdaki güncel borç miktarı: " + user.getDebt() + "\nHesabınızın güncel bakiyesi: " + user.getBalance());
    }


}


