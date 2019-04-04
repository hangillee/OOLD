import java.util.Random;
import java.util.Scanner;

public class CharacterAct {
	private static final Scanner scan = new Scanner(System.in);
	Reward reward = new Reward();
	public void PlayerAct(int enemyHP, int enemyAT, int enemyDF, int enemyDX, String enemyNAME, int stageNumber) {
		Player player = Player.getInstance();
		Random random = new Random(); //공격 확률 결정
		
		String selectACT; //선택지 변수
		
		int playerHP;
		playerHP = player.getHealth(); //플레이어의 스탯 데이터 받아옴
		
		while(true) { //적의 체력이 0이 될때까지
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SELECT SKILL");
			System.out.println("E. EQUIPMENT CHECK");
			System.out.println("T. STATUS CHECK");
			System.out.print("▶ Select : ");
			selectACT = scan.nextLine();
			
			if(selectACT.equals("A") || selectACT.equals("a")) { //일반 공격 선택지
				
				if(random.nextInt(100) < enemyDX) { //민첩성의 확률로 공격 or 빗나감 결정
					System.out.println("");
					System.out.println("==============================");
					System.out.println("        Attack Missed!        ");
					System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
					System.out.println("==============================");
					System.out.println("");
					EnemyAct(enemyAT, enemyDF, enemyNAME);
				} else {
					enemyHP = NormalAttack(enemyHP, enemyAT, enemyDF, enemyNAME);
				}
				playerHP = player.getHealth();
				
				//플레이어의 체력이 0이나 0보다 작아지면 적이 쓰러져도 무조건 게임 오버
				if(playerHP < 0 || playerHP == 0) {
					GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					StageClear(enemyNAME);
					reward.GiveReward(stageNumber);
					break;
				}
				
			} else if(selectACT.equals("S") || selectACT.equals("s")) { //스킬 공격 선택지
				enemyHP = SkillSelect(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME);
				playerHP = player.getHealth();
				
				if(playerHP < 0 || playerHP == 0) {
					GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					StageClear(enemyNAME);
					reward.GiveReward(stageNumber);
					break;
				}
			} else if(selectACT.equals("E") || selectACT.equals("e")) {
				EquipmentCheck();
			} else if(selectACT.equals("T") || selectACT.equals("t")) {
				System.out.println("");
				PrintMethods.PrintEnemyStat(enemyNAME, enemyHP, enemyAT, enemyDF);
				PrintMethods.PrintPlayerStat();
			} else if(selectACT.equals("")) {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			}
		}
	}
	//적의 공격 메소드
	public void EnemyAct(int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		Random random = new Random();
		
		//플레이어의 스탯 데이터 받아옴
		int playerHP = player.getHealth();
		int playerDF = player.getDefend();
		int playerDX = player.getDexterity();
		int damage = 0;
		
		if(random.nextInt(100) < playerDX) { //민첩성의 확률로 공격 or 빗나감 결정
			System.out.println("==============================");
			System.out.println("   " + enemyNAME + " Attack Missed!");
			System.out.println("      Your left HP : " + playerHP);
			System.out.println("==============================");
			System.out.println("");
		} else {
			System.out.println("==============================");
			System.out.println("     " + enemyNAME + "'s Attack!");
			damage = enemyAT - playerDF; //데미지 계산식
			playerHP = playerHP - damage;
			player.setHealth(playerHP);
			System.out.println("      Your left HP : " + playerHP);
			System.out.println("==============================");
			System.out.println("");
		}
		
	}
	//일반 공격 메소드
	public int NormalAttack(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		
		int playerAT;
		int damage;
		
		playerAT = player.getAttack();
		
		System.out.println("");
		System.out.println("==============================");
		System.out.println("   You hit the " + enemyNAME + "!");
		damage = playerAT - enemyDF; //데미지 계산식
		enemyHP = enemyHP - damage; //적 체력에 데미지 계산
		System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
		System.out.println("==============================");
		System.out.println("");
		EnemyAct(enemyAT, enemyDF, enemyNAME); //적의 공격 턴
		
		return enemyHP;
	}
	//스킬 공격 메소드
	public int SkillSelect(int enemyHP, int enemyAT, int enemyDF, int enemyDX, String enemyNAME) {
		Player player = Player.getInstance();
		Random random = new Random(); //공격 확률 결정
		
		int playerAT = player.getAttack();
		int playerHP = player.getHealth();
		
		int damage;
		int overHP;
		String selectUA;
		
		while(true) {
			System.out.println("");
			System.out.println("What kind of skill you use?");
			System.out.println("U. Utility Skill");
			System.out.println("A. Attack Skill");
			System.out.print("▶ Select : ");
			selectUA = scan.nextLine();
			
			if(selectUA.equals("U") || selectUA.equals("u")) {
				if(playerHP == 100) {
					System.out.println("");
					System.out.println("==============================");
					System.out.println("   Your HP is already FULL!   ");
					System.out.println("==============================");
					continue;
				}
				System.out.println("");
				System.out.println("==============================");
				System.out.println("     You use skill \"HEAL!\"    ");
				playerHP += 10;
				overHP = playerHP - 100;
				if(playerHP > 100) {
					playerHP = playerHP - overHP;
				}
				player.setHealth(playerHP);
				System.out.println("      Your left HP : " + playerHP);
				System.out.println("==============================");
				System.out.println("");
				
				EnemyAct(enemyAT, enemyDF, enemyNAME); //적의 공격 턴
				break;
			} else if(selectUA.equals("A") || selectUA.equals("a")) {
				if(random.nextInt(100) < enemyDX+10) { //민첩성의 확률로 공격 or 빗나감 결정
					System.out.println("");
					System.out.println("==============================");
					System.out.println("        Attack Missed!        ");
					System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
					System.out.println("==============================");
					System.out.println("");
					EnemyAct(enemyAT, enemyDF, enemyNAME);
				} else {
					System.out.println("");
					System.out.println("==============================");
					System.out.println("    You use skill \"SMITE!\"   ");
					damage = (playerAT * 2) - enemyDF; //데미지 계산식
					enemyHP = enemyHP - damage; //적 체력에 데미지 계산
					System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
					System.out.println("==============================");
					System.out.println("");
					EnemyAct(enemyAT, enemyDF, enemyNAME); //적의 공격 턴
				}
				
				break;
			} else {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			}
		}
		return enemyHP;
	}
	public void EquipmentCheck() {
		Player player = Player.getInstance();
		
		String weapon = player.GetPlayerWeapon();
		String armour = player.GetPlayerArmour();
		
		if(weapon == null && armour == null) {
			System.out.println("");
			System.out.println("===================================");
			System.out.println("   You don't have any EQUIPMENT!   ");
			System.out.println("===================================");
			System.out.println();
		} else if(weapon != null && armour == null) {
			System.out.println("");
			System.out.println("===================================");
			System.out.println("          Your EQUIPMENT           ");
			System.out.println("       Weapon : " + weapon);
			System.out.println("===================================");
			System.out.println("");
		} else if(weapon == null && armour != null) {
			System.out.println("");
			System.out.println("===================================");
			System.out.println("          Your EQUIPMENT           ");
			System.out.println("       Armour : " + armour);
			System.out.println("===================================");
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("===================================");
			System.out.println("          Your EQUIPMENT           ");
			System.out.println("       Weapon : " + weapon);
			System.out.println("       Armour : " + armour);
			System.out.println("===================================");
			System.out.println("");
		}
	}
	//Stage 클리어 시 출력 메소드
	public void StageClear(String enemyNAME) {
		Player player = Player.getInstance();
		
		player.setHealth(100); //플레이어 클리어 후 체력 초기화
		System.out.println("==============================");
		System.out.println("                              ");
		System.out.println("  " + enemyNAME + " DOWN! YOU WIN!  ");
		System.out.println("                              ");
		System.out.println("==============================");
		System.out.println("");
	}
	//게임 오버 시 출력 메소드
	public void GameOver() {
		String selectYN;
		
		System.out.println("==============================");
		System.out.println("=                            =");
		System.out.println("=    GAME OVER! YOU DIED!    =");
		System.out.println("=        Retry? (Y/N)        =");
		System.out.println("=                            =");
		System.out.println("==============================");
		System.out.println("");
		while(true) {
			System.out.print("Select : ");
			selectYN = scan.nextLine();
			
			if(selectYN.equals("Y") || selectYN.equals("y")) {
				Player.maximumstat = 50; //스탯 포인트 초기화
				PrintMethods.ClearScreen();
				MainPage.main(null); //다시 시작
				break;
			} else if(selectYN.equals("N") || selectYN.equals("n")) {
				System.out.println("");
				System.out.println("===============================");
				System.out.println("  Exit Game. Try Again Later!  ");
				System.out.println("===============================");
				System.exit(0);
			} else if(selectYN.equals("")) {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			}
		}
	}
	
}
