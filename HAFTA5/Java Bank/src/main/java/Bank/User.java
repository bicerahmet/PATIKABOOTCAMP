package Bank;

public class User {
    private String ID;
    public String name;
    private String birthDate;
    private String password;
    private long balance = 0;
    private long debt = 0;

    public User(String name, String ID, String birthDate, String password, long balance, long debt) {
        this.name = name;
        this.ID = ID;
        this.birthDate = birthDate;
        this.password = password;
        this.balance = balance;
        this.debt = debt;
    }

    public void printUserInfo(){
        System.out.println(name + " isimli kullanıcımızın bilgileri aşağıda gözükmektedir:\nT.C. Kimlik Numarası: " + ID + "\nDoğum tarihi: " + birthDate + "\n");
    }

    public void printAccountInfo(){
        System.out.println("Toplam bakiyeniz: " + balance + "\nToplam Borcunuz: " + debt + "\n");
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getDebt() {
        return debt;
    }

    public void setDebt(long debt) {
        this.debt = debt;
    }
}
