import java.util.Scanner;

public class Player extends Character {
	private static final Scanner scan = new Scanner(System.in);
	
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

	public void SetPlayerName() { //캐릭터 이름 설정
		String name;
		char selectYN;
		
		while(true) {
			System.out.println("");
			System.out.print("▶ Enter your name (Limit 8 words): ");
			name = scan.nextLine();
			
			//게임 오버 후 재시작시 자동으로 이름에 공백 입력되는 문제 해결
			if(name.equals("")) { 
				name = scan.nextLine();
			}
			//이름 길이 제한
			if(name.length() > 8) {
				System.out.println("▶ Too long name! Please rename your name.");
				continue;
			}
		
			System.out.print("▶ " + name + " is your name? (Y/N) : ");
			selectYN = scan.nextLine().charAt(0);
		
			if(selectYN == 'N' || selectYN == 'n') {
				SetPlayerName();
				break;
			} else if(selectYN == 'Y' || selectYN == 'y') {
				PrintMethods.ClearScreen();
				System.out.println("");
				System.out.println("=============================================");
				System.out.println("");
				System.out.println("   Welcome to Only One Life DUNGEON " + name + "!");
				System.out.println("");
				System.out.println("=============================================");
				System.out.println("");
				this.setName(name);
				break;
			} else {
				System.out.println("");
				System.out.println("▶ Please Enter right command!");
			}
		}
	}
	
	public void SetPlayerAttackStat() { //캐릭터 공격력 스탯 설정 메소드
		int attack;
		
		while(true) {
			System.out.println("===================================");
			System.out.println("Your Basic Attack Stat is [ 30 ]");
			System.out.println("Remain Stat Point : [ " + maximumstat + " ]");
			System.out.println("===================================");
			System.out.println("");
			System.out.print("▶ Add Your Attack Stat : ");
			
			while(!scan.hasNextInt()) { //숫자 커맨드 입력 확인 숫자가 아닐 시 while문 실행
				scan.next();
				System.out.println("");
				System.out.println("===================================");
				System.out.println("        Please Enter Number        ");
				System.out.println("===================================");
				System.out.println("");
				System.out.print("▶ Add Your Attack Stat : ");
			}
			attack = scan.nextInt();
		
			if(attack > maximumstat || attack < 1) {
				System.out.println("▶ Please add right value.");
				System.out.println("");
			} else {
				this.setAttack(attack + 30);
				maximumstat = maximumstat - attack;
				System.out.println("▶ Your Attack stat is [ " + this.getAttack() + " ]");
				System.out.println("");
				//scan.close();
				break;
			}
		}
	}
	public void SetPlayerDefendStat() { //캐릭터 방어력 스탯 설정 메소드
		int defend;
		
		while(true) {
			System.out.println("===================================");
			System.out.println("Your Basic Defend Stat is [ 30 ]");
			if(maximumstat < 1) { //투자 가능한 스탯 포인트 모두 소진 시
				System.out.println("No more stat point remain");
				System.out.println("===================================");
				System.out.println("");
				this.setDefend(30);
				System.out.println("▶ Your Defend stat is [ " + this.getDefend() + " ]");
				System.out.println("");
				//scan.close();
				break;
			}
			System.out.println("Remain Stat Point : [ " + maximumstat + " ]");
			System.out.println("===================================");
			System.out.println("");
			System.out.print("▶ Add Your Defend Stat : ");
			
			while(!scan.hasNextInt()) { //숫자 입력 확인 숫자가 아닐 시 while문 실행
				scan.next();
				System.out.println("");
				System.out.println("===================================");
				System.out.println("        Please Enter Number        ");
				System.out.println("===================================");
				System.out.println("");
				System.out.print("▶ Add Your Defend Stat : ");
			}
			
			defend = scan.nextInt();
		
			if(defend > maximumstat || defend < 1) {
				System.out.println("▶ Please add right value.");
				System.out.println("");
			} else {
				this.setDefend(defend + 30);
				maximumstat = maximumstat - defend;
				System.out.println("▶ Your Defend stat is [ " + this.getDefend() + " ]");
				System.out.println("");
				//scan.close();
				break;
			}
		}
	}
	public void SetPlayerDexterity() {
		int dexterity;
		
		while(true) {
			System.out.println("===================================");
			System.out.println("Your Basic Dexterity Stat is [ 10 ]");
			if(maximumstat < 1) { //투자 가능한 스탯 포인트 모두 소진 시
				System.out.println("No more stat point remain");
				System.out.println("===================================");
				System.out.println("");
				this.setDexterity(10);
				System.out.println("▶ Your Dexterity stat is [ " + this.getDexterity() + " ]");
				System.out.println("");
				break;
			}
			System.out.println("Remain Stat Point : [ " + maximumstat + " ]");
			System.out.println("===================================");
			System.out.println("");
			System.out.print("▶ Add Your Dexterity Stat : ");
			
			while(!scan.hasNextInt()) { //숫자 입력 확인 숫자가 아닐 시 while문 실행
				scan.next();
				System.out.println("");
				System.out.println("===================================");
				System.out.println("        Please Enter Number        ");
				System.out.println("===================================");
				System.out.println("");
				System.out.print("▶ Add Your Defend Stat : ");
			}
			
			dexterity = scan.nextInt();
		
			if(dexterity > maximumstat || dexterity < 1) {
				System.out.println("▶ Please add right value.");
				System.out.println("");
			} else {
				this.setDexterity(dexterity + 10);
				maximumstat = maximumstat - dexterity;
				System.out.println("▶ Your Dexterity stat is [ " + this.getDexterity() + " ]");
				System.out.println("");
				break;
			}
		}
	}
}
