import java.util.Random;
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	private Random random = new Random();

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("�uan buradas�n�z : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " ya��yor !");
		System.out.print("<S>ava� veya <K>a� :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " b�lgesindeki t�m d��manlar� temizlediniz !");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Kazand�n�z! ");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Kazand�n�z! ");
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Kazand�n�z! ");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			
			if(player.getHealth() <= 0) {
				System.out.println("�ld�n�z !");
				return false;
			}
		
		}
		return true;
	}


	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerState();
			obstacleState(i);
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {


				System.out.print("<V>ur veya <K>a� :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();


				int randomStart = random.nextInt(2) + 1;

				// if randomStart is 2, the player will hit first
				if (randomStart == 2) {

					//hit = playerHitFirst();

					if (selCase.equals("V")) {
						System.out.println("Önce siz vurdunuz !");
						if( obstacle.getHealth() - player.getTotalDamage() <0){
							obstacle.setHealth(0);
						}else {
							obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
						}
						afterHit();
						if (obstacle.getHealth() > 0) {
							System.out.println();
							System.out.println("Canavar size vurdu !");
							if(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()) < 0){
								obstacle.setHealth(0);
							}else {
								player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
							}
							afterHit();
						}
					} else {
						return false;
					}

				}

				else if (randomStart == 1){

					if (obstacle.getHealth() > 0 && selCase.equals("V")) {
						System.out.println();
						System.out.println("Önce canavar size vurdu !");
						if(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()) < 0){
							obstacle.setHealth(0);
						}else {
							player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
						}						afterHit();
					}
					else if(selCase.equals("K")){
						System.out.println("Kaçtınız..");
						return false;
					}
					System.out.println("Siz vurdunuz !");
					if( obstacle.getHealth() - player.getTotalDamage() <0){
						obstacle.setHealth(0);
					}else {
						obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					}
					afterHit();

				}

			}

			if (obstacle.getHealth() < player.getHealth()) {
				System.out.println("D��man� yendiniz !");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("G�ncel Paran�z : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}


	public void playerState() {
		System.out.println("Oyuncu Degerleri\n--------------");
		System.out.println("Can:" + player.getHealth());
		System.out.println("Hasar:" + player.getTotalDamage());
		System.out.println("Para:" + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah:" + player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zırh:" + player.getInv().getArmorName());
		}
	}

	public void obstacleState(int i) {
		System.out.println("\n" + i +". "+ obstacle.getName() + " Degerleri\n--------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("Odul:" + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Oyuncu Cani:" + player.getHealth());
		System.out.println(obstacle.getName() + " Cani:" + obstacle.getHealth());
		System.out.println();
	}

}
