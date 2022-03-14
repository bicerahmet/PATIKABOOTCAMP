import java.util.Scanner;

public class Player {
	private int damage, health, money, originalHealth;
	private String name, charName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}

	public void selectChar() {
		switch (charMenu()) {
		case 1:
			initPlayer("Samuray", 5, 21, 15);
			break;
		case 2:
			initPlayer("Okcu", 7, 18, 20);
			break;
		case 3:
			initPlayer("Sovalye", 8, 24, 5);
			break;
		default:
			initPlayer("Samuray", 5, 21, 15);
			break;
		}
		System.out.println("Karakter Olusturuldu ! Ad�=" + getCharName() + " ,Hasar=" + getDamage() + " ,Sa�l�k="
				+ getHealth() + " ,Para=" + getMoney());
	}

	public int charMenu() {
		System.out.println("Lutfen bir karakter seciniz : ");
		System.out.println("1- Samuray \t Hasar : 5 \t Saglik :21 \t Para :15");
		System.out.println("2- Okcu \t Hasar : 7 \t Saglik:18 \t Para :20");
		System.out.println("3- Sovalye \t Hasar : 8 \t Saglik :24 \t Para :5");
		System.out.print("Karater Seciminiz : ");
		int charID = scan.nextInt();

		while (charID < 1 || charID > 3) {
			System.out.print("Lutfen gecerli bir karakter seciniz : ");
			charID = scan.nextInt();
		}

		return charID;
	}

	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
	}

	public void initPlayer(String charName, int damage, int health, int money) {
		setCharName(charName);
		setDamage(damage);
		setHealth(health);
		setMoney(money);
		setOriginalHealth(health);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getOriginalHealth() {
		return originalHealth;
	}

	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}

}
