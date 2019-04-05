import java.util.Random;
import java.util.Scanner;

public class CharacterAct {
	private static final Scanner scan = new Scanner(System.in);
	Reward reward = new Reward();
	//플레이어 행동 메소드
	public void PlayerAct(Enemy enemy, int stageNumber) {
		Player player = Player.getInstance();
		Random random = new Random(); //공격 확률 결정
		
		String selectACT; //선택지 변수
		
		int playerHP = player.getHealth(); //플레이어의 스탯 데이터 받아옴
		
		//적의 스탯 데이터 받아옴
		int enemyDX = enemy.getDexterity();
		int enemyHP = enemy.getHealth();
		String enemyNAME = enemy.getName();
		
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
					EnemyAct(enemy);
				} else {
					enemyHP = NormalAttack(enemy);
				}
				playerHP = player.getHealth();
				
				//플레이어의 체력이 0이나 0보다 작아지면 적이 쓰러져도 무조건 게임 오버
				if(playerHP < 0 || playerHP == 0) {
					PrintMethods.GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					PrintMethods.StageClear(enemyNAME);
					reward.GiveReward(stageNumber);
					break;
				}
				
			} else if(selectACT.equals("S") || selectACT.equals("s")) { //스킬 공격 선택지
				enemyHP = SkillSelect(enemy);
				playerHP = player.getHealth();
				
				if(playerHP < 0 || playerHP == 0) {
					PrintMethods.GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					PrintMethods.StageClear(enemyNAME);
					reward.GiveReward(stageNumber);
					break;
				}
			} else if(selectACT.equals("E") || selectACT.equals("e")) {
				EquipmentCheck();
			} else if(selectACT.equals("T") || selectACT.equals("t")) {
				System.out.println("");
				PrintMethods.PrintEnemyStat(enemy);
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
	public void EnemyAct(Enemy enemy) {
		Player player = Player.getInstance();
		Random random = new Random();
		
		//플레이어의 스탯 데이터 받아옴
		int playerHP = player.getHealth();
		int playerDF = player.getDefend();
		int playerDX = player.getDexterity();
		int damage = 0;
		
		//적의 스탯 데이터 받아옴
		int enemyAT = enemy.getAttack();
		String enemyNAME = enemy.getName();
		
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
	public int NormalAttack(Enemy enemy) {
		Player player = Player.getInstance();
		
		int playerAT = player.getAttack();
		int damage;
		
		//적의 스탯 데이터 받아옴
		int enemyDF = enemy.getDefend();
		int enemyHP = enemy.getHealth();
		String enemyNAME = enemy.getName();
		
		System.out.println("");
		System.out.println("==============================");
		System.out.println("   You hit the " + enemyNAME + "!");
		damage = playerAT - enemyDF; //데미지 계산식
		enemyHP = enemyHP - damage; //적 체력에 데미지 계산
		enemy.setHealth(enemyHP);
		System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
		System.out.println("==============================");
		System.out.println("");
		EnemyAct(enemy); //적의 공격 턴
		
		return enemyHP;
	}
	//스킬 공격 메소드
	public int SkillSelect(Enemy enemy) {
		//선택지 변수
		String selectUA;
		
		//적의 스탯 데이터 받아옴
		int enemyHP = enemy.getHealth();
		
		while(true) {
			System.out.println("");
			System.out.println("What kind of skill you use?");
			System.out.println("U. Utility Skill");
			System.out.println("A. Attack Skill");
			System.out.print("▶ Select : ");
			selectUA = scan.nextLine();
			
			if(selectUA.equals("U") || selectUA.equals("u")) {
				UtilitySkill();
				EnemyAct(enemy); //적의 공격 턴
				break;
			} else if(selectUA.equals("A") || selectUA.equals("a")) {
				AttackSkill(enemy);
				enemyHP = enemy.getHealth();
				break;
			} else {
				System.out.println("▶ Please Enter right command!");
				System.out.println("");
			}
		}
		return enemyHP;
	}
	//유틸리티 스킬 메소드
	public void UtilitySkill() {
		Player player = Player.getInstance();

		int playerHP = player.getHealth();
		int overHP;
		
		if(playerHP == 100) {
			System.out.println("");
			System.out.println("==============================");
			System.out.println("   Your HP is already FULL!   ");
			System.out.println("==============================");
			return;
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
	}
	//공격 스킬 메소드
	public void AttackSkill(Enemy enemy) {
		Player player = Player.getInstance();
		Random random = new Random(); //공격 확률 결정
		
		int playerAT = player.getAttack();
		int damage;
		
		//적의 스탯 데이터 받아옴
		int enemyDF = enemy.getDefend();
		int enemyDX = enemy.getDexterity();
		int enemyHP = enemy.getHealth();
		String enemyNAME = enemy.getName();
		
		if(random.nextInt(100) < enemyDX+10) { //민첩성의 확률로 공격 or 빗나감 결정
			System.out.println("");
			System.out.println("==============================");
			System.out.println("        Attack Missed!        ");
			System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
			System.out.println("==============================");
			System.out.println("");
			EnemyAct(enemy);
		} else {
			System.out.println("");
			System.out.println("==============================");
			System.out.println("    You use skill \"SMITE!\"   ");
			damage = (playerAT * 2) - enemyDF; //데미지 계산식
			enemyHP = enemyHP - damage; //적 체력에 데미지 계산
			enemy.setHealth(enemyHP);
			System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
			System.out.println("==============================");
			System.out.println("");
			EnemyAct(enemy); //적의 공격 턴
		}
	}
	//장비 확인 메소드
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
}
