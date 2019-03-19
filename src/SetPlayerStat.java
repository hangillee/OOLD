import java.util.Scanner;

public class SetPlayerStat {
	static CharacterInfo player = new CharacterInfo();
	static int maximumstat = 50;
	
	public static void SetPlayerHealth() {
		player.setHealth(100);
	}

	public static void SetPlayerName() {
		Scanner scan = new Scanner(System.in);
		String name;
		char selectYN;
		
		while(true) {
			System.out.println("");
			System.out.print("Enter your name : ");
			name = scan.nextLine();
		
			System.out.print(name + " is your name? (Y/N) : ");
			selectYN = scan.nextLine().charAt(0);
		
			if(selectYN == 'N' || selectYN == 'n') {
				SetPlayerName();
			} else if(selectYN == 'Y' || selectYN == 'y') {
				System.out.println("");
				System.out.println("===================================");
				System.out.println("Welcome to the JAVA DUNGEON " + name + "!");
				System.out.println("===================================");
				System.out.println("");
				break;
			} else {
				System.out.println("Please Enter right command!");
				System.out.println("");
			}
		}
	}
	
	public static void SetPlayerAttackStat() { //캐릭터 공격력 스탯 설정 메소드
		Scanner scan = new Scanner(System.in);
		int attack;
		
		while(true) {
			System.out.println("Your Basic Attack Stat is [ 30 ]");
			System.out.println("Remain Stat Point : [ " + maximumstat + " ]");
			System.out.print("Set Your Attack Stat : ");
			attack = scan.nextInt();
		
			if(attack > maximumstat || attack < 1) {
				System.out.println("Please set right value.");
				System.out.println("");
			} else {
				player.setAttack(attack + 30);
				maximumstat = maximumstat - attack;
				System.out.println("");
				System.out.println("=========================");
				System.out.println("Your Attack stat is [ " + player.getAttack() + " ]");
				System.out.println("=========================");
				System.out.println("");
				//scan.close();
				break;
			}
		}
	}
	public static void SetPlayerDefendStat() { //캐릭터 방어력 스탯 설정 메소드
		Scanner scan = new Scanner(System.in);
		
		int defend;
		
		while(true) {
			System.out.println("Your Basic Defend Stat is [ 30 ]");
			if(maximumstat == 0) {
				System.out.println("No more stat point remain");
				player.setDefend(30);
				System.out.println("");
				System.out.println("=========================");
				System.out.println("Your Defend stat is [ " + player.getDefend() + " ]");
				System.out.println("=========================");
				System.out.println("");
				//scan.close();
				break;
			}
			System.out.println("Remain Stat Point : [ " + maximumstat + " ]");
			System.out.print("Set Your Defend Stat : ");
			defend = scan.nextInt();
		
			if(defend > maximumstat || defend < 1) {
				System.out.println("Please set right value.");
				System.out.println("");
			} else {
				player.setDefend(defend + 30);
				System.out.println("");
				System.out.println("=========================");
				System.out.println("Your Defend stat is [ " + player.getDefend() + " ]");
				System.out.println("=========================");
				System.out.println("");
				//scan.close();
				break;
			}
		}
		
	}
}
