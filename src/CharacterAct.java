import java.util.Random;
import java.util.Scanner;

public class CharacterAct {
	private static final Scanner scan = new Scanner(System.in);
	Reward reward = new Reward();
	public void PlayerAct(int enemyHP, int enemyAT, int enemyDF, int enemyDX, String enemyNAME, int stageNumber) {
		Player player = Player.getInstance();
		Random random = new Random(); //공격 확률 결정
		
		String selectAS; //선택지 변수
		
		int playerHP;
		playerHP = player.getHealth(); //플레이어의 스탯 데이터 받아옴
		
		while(true) { //적의 체력이 0이 될때까지
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SKILL ATTACK");
			System.out.print("▶ Select : ");
			selectAS = scan.nextLine();
			
			if(selectAS.equals("A") || selectAS.equals("a")) { //일반 공격 선택지
				
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
					reward.GiveReward(enemyNAME, stageNumber);
					break;
				}
				
			} else if(selectAS.equals("S") || selectAS.equals("s")) { //스킬 공격 선택지
				
				if(random.nextInt(100) < enemyDX) { //민첩성의 확률로 공격 or 빗나감 결정
					System.out.println("");
					System.out.println("==============================");
					System.out.println("        Attack Missed!        ");
					System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
					System.out.println("==============================");
					System.out.println("");
					EnemyAct(enemyAT, enemyDF, enemyNAME);
				} else {
					enemyHP = SkillAttack(enemyHP, enemyAT, enemyDF, enemyNAME);
				}
				playerHP = player.getHealth();
				
				if(playerHP < 0 || playerHP == 0) {
					GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					StageClear(enemyNAME);
					reward.GiveReward(enemyNAME, "Long Sword", "Big Shield", stageNumber);
					break;
				}
			} else if(selectAS.equals("")){
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
	public int SkillAttack(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		
		int playerAT;
		int damage;
		
		playerAT = player.getAttack();
		
		System.out.println("");
		System.out.println("==============================");
		System.out.println("    You use skill \"SMITE!\"   ");
		damage = (playerAT * 2) - enemyDF; //데미지 계산식
		enemyHP = enemyHP - damage; //적 체력에 데미지 계산
		System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
		System.out.println("==============================");
		System.out.println("");
		EnemyAct(enemyAT, enemyDF, enemyNAME); //적의 공격 턴
		
		return enemyHP;
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
		System.out.println("  Press Enter to continue...");
		String insert = scan.nextLine();
		
		while(true) { //Enter키를 통해 진행을 위한 조건
			if(insert.length() == 0) {
				break;
			}
			else {
				System.out.println("  Please Press ENTER to continue!");
				insert = scan.nextLine();
			}
		}
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
