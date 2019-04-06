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
		
		System.out.println("=============================================");
		System.out.println("                 Reward Item                 ");
		System.out.println("    Attack Item : " + weaponName + " (Attack + " + equipStat + ")");
		System.out.println("    Defend Item : " + armourName + " (Defend + " + equipStat + ")");
		System.out.println("=============================================");
		System.out.println("");
		
		while(true) {
			System.out.println("Choose your reward!");
			System.out.println("A. " + weaponName);
			System.out.println("D. " + armourName);
			System.out.print("▶ Select : ");
			selectAD = scan.nextLine();
		
			if(selectAD.equals("A") || selectAD.equals("a")) {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("  Now " + weaponName + " is your weapon!");
				System.out.println("            Attack + " + equipStat);
				System.out.println("===================================");
				player.setAttack(playerAT + equipStat);
				player.SetPlayerWeapon(weaponName);
				System.out.println("");
				PrintMethods.PressEnterToContinue();
				break;
			} else if(selectAD.equals("D") || selectAD.equals("d")) {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("  Now " + armourName + " is your armour!");
				System.out.println("            Defend + " + equipStat);
				System.out.println("===================================");
				player.setDefend(playerDF + equipStat);
				player.SetPlayerArmour(armourName);
				System.out.println("");
				PrintMethods.PressEnterToContinue();
				break;
			} else {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("    Please Enter Right Command!    ");
				System.out.println("===================================");
				System.out.println("");
			}
		}
		
	}
	public void UpgradeSkill(int stagenumber) {
		Player player = Player.getInstance();
		
		String selectUA;
		int skillStat = 0;
		
		//스테이지 클리어 별 주어지는 스킬 업그레이드 스탯
		switch(stagenumber) {
		case 1:
			skillStat = 15;
			break;
		case 2:
			skillStat = 20;
			break;
		case 3:
			skillStat = 25;
			break;
		default:
			skillStat = 0;
			break;
		}
		
		System.out.println("===================================");
		System.out.println("         Upgrade Your Skill        ");
		System.out.println("      Utility Skill : \"HEAL\"");
		System.out.println("      Attack Skill : \"SMITE\"");
		System.out.println("===================================");
		
		while(true) {
			System.out.println("");
			System.out.println("Select skill to upgrade!");
			System.out.println("U. Utility Skill");
			System.out.println("A. Attack Skill");
			System.out.print("▶ Select : ");
			selectUA = scan.nextLine();
			
			if(selectUA.equals("U") || selectUA.equals("u")) {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("  You upgrade utility skill \"HEAL\"");
				System.out.println("          HEAL + " + skillStat);
				System.out.println("===================================");
				player.setPlayerSkillStat(skillStat);
				break;
			} else if(selectUA.equals("A") || selectUA.equals("a")) {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("  You upgrade attack skill \"SMITE\"");
				System.out.println("          SMITE + " + skillStat);
				System.out.println("===================================");
				player.setPlayerSkillStat(skillStat);
				break;
			} else {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("    Please Enter Right Command!    ");
				System.out.println("===================================");
				System.out.println("");
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
		case 3:
			equipStat = 15;
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
		case 3:
			weaponName = "Blood Axe";
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
			armourName = "Golden Helm";
			return armourName;
		case 3:
			armourName = "Plate Armour";
			return armourName;
		default:
			return "";
		}
	}
}
