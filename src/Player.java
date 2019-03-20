import java.util.Scanner;

public class Player extends Character {
	//Singleton
	private Player() {}
	private static class CreatePlayer {
		private static final Player player = new Player();
	}
	public static Player getInstance() {
		return CreatePlayer.player;
	}
	//Singleton
	
	static int maximumstat = 50;
	
	public void SetPlayerHealth() {
		this.setHealth(100);
	}

	public void SetPlayerName() {
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
				this.setName(name);
				break;
			} else {
				System.out.println("Please Enter right command!");
				System.out.println("");
			}
		}
	}
	
	public void SetPlayerAttackStat() { //캐릭터 공격력 스탯 설정 메소드
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
				this.setAttack(attack + 30);
				maximumstat = maximumstat - attack;
				System.out.println("");
				System.out.println("=========================");
				System.out.println("Your Attack stat is [ " + this.getAttack() + " ]");
				System.out.println("=========================");
				System.out.println("");
				//scan.close();
				break;
			}
		}
	}
	public void SetPlayerDefendStat() { //캐릭터 방어력 스탯 설정 메소드
		Scanner scan = new Scanner(System.in);
		
		int defend;
		
		while(true) {
			System.out.println("Your Basic Defend Stat is [ 30 ]");
			if(maximumstat == 0) { //투자 가능한 스탯 포인트 모두 소진 시
				System.out.println("No more stat point remain");
				this.setDefend(30);
				System.out.println("");
				System.out.println("=========================");
				System.out.println("Your Defend stat is [ " + this.getDefend() + " ]");
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
				this.setDefend(defend + 30);
				System.out.println("");
				System.out.println("=========================");
				System.out.println("Your Defend stat is [ " + this.getDefend() + " ]");
				System.out.println("=========================");
				System.out.println("");
				//scan.close();
				break;
			}
		}
		
	}
}
