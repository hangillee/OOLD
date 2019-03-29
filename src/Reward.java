import java.util.Scanner;

public class Reward {
	private static final Scanner scan = new Scanner(System.in);
	private String weaponName;
	private String armourName;
	private int stagenumber = 0;
	
	public void GiveReward(int stageNumber) {
		Player player = Player.getInstance();
		stagenumber = stageNumber;
		
		String selectAD;
		int equipStat = 0;
		int playerAT = player.getAttack();
		int playerDF = player.getDefend();
		
		weaponName = setWeaponName(stagenumber);
		armourName = setArmourName(stagenumber);
		equipStat = setEquipmentStat(stagenumber);
		
		System.out.println("==============================");
		System.out.println("");
		System.out.println("  Attack Item : " + weaponName);
		System.out.println("  Defend Item : " + armourName);
		System.out.println("");
		System.out.println("==============================");
		System.out.println("");
		
		while(true) {
			System.out.println("Choose your reward!");
			System.out.println("A. " + weaponName);
			System.out.println("D. " + armourName);
			System.out.print("¢º Select : ");
			selectAD = scan.nextLine();
		
			if(selectAD.equals("A") || selectAD.equals("a")) {
				System.out.println("Now " + attackitem + " is your weapon!");
				player.setAttack(playerAT + equipStat);
				break;
			} else if(selectAD.equals("D") || selectAD.equals("d")) {
				System.out.println("Now " + defenditem + " is your armour!");
				player.setDefend(playerDF + equipStat);
				break;
			} else {
				System.out.println("Please enter right command!");
			}
		}
		
	}
	public int setEquipmentStat(int stagenumber) {
		int equipStat = 0;
		
		switch(stagenumber) {
		case 1:
			equipStat = 5;
			return equipStat;
		case 2:
			equipStat = 10;
			return equipStat;
		default:
			return 0;
		}
	}
	public String setWeaponName(int stagenumber) {
		String weaponName;
		
		switch(stagenumber) {
		case 1:
			weaponName = "Long Sword";
			return weaponName;
		case 2:
			weaponName = "Dark Spear";
			return weaponName;
		default:
			return "";
		}
	}
	public String setArmourName(int stagenumber) {
		String armourName;
		
		switch(stagenumber) {
		case 1:
			armourName = "Big Shield";
			return armourName;
		case 2:
			armourName = "Golden Helmet";
			return armourName;
		default:
			return "";
		}
	}
}
