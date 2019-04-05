import java.util.Random;
import java.util.Scanner;

public class CharacterAct {
	private static final Scanner scan = new Scanner(System.in);
	Reward reward = new Reward();
	//�÷��̾� �ൿ �޼ҵ�
	public void PlayerAct(Enemy enemy, int stageNumber) {
		Player player = Player.getInstance();
		Random random = new Random(); //���� Ȯ�� ����
		
		String selectACT; //������ ����
		
		int playerHP = player.getHealth(); //�÷��̾��� ���� ������ �޾ƿ�
		
		//���� ���� ������ �޾ƿ�
		int enemyDX = enemy.getDexterity();
		int enemyHP = enemy.getHealth();
		String enemyNAME = enemy.getName();
		
		while(true) { //���� ü���� 0�� �ɶ�����
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SELECT SKILL");
			System.out.println("E. EQUIPMENT CHECK");
			System.out.println("T. STATUS CHECK");
			System.out.print("�� Select : ");
			selectACT = scan.nextLine();
			
			if(selectACT.equals("A") || selectACT.equals("a")) { //�Ϲ� ���� ������
				
				if(random.nextInt(100) < enemyDX) { //��ø���� Ȯ���� ���� or ������ ����
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
				
				//�÷��̾��� ü���� 0�̳� 0���� �۾����� ���� �������� ������ ���� ����
				if(playerHP < 0 || playerHP == 0) {
					PrintMethods.GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					PrintMethods.StageClear(enemyNAME);
					reward.GiveReward(stageNumber);
					break;
				}
				
			} else if(selectACT.equals("S") || selectACT.equals("s")) { //��ų ���� ������
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
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			}
		}
	}
	//���� ���� �޼ҵ�
	public void EnemyAct(Enemy enemy) {
		Player player = Player.getInstance();
		Random random = new Random();
		
		//�÷��̾��� ���� ������ �޾ƿ�
		int playerHP = player.getHealth();
		int playerDF = player.getDefend();
		int playerDX = player.getDexterity();
		int damage = 0;
		
		//���� ���� ������ �޾ƿ�
		int enemyAT = enemy.getAttack();
		String enemyNAME = enemy.getName();
		
		if(random.nextInt(100) < playerDX) { //��ø���� Ȯ���� ���� or ������ ����
			System.out.println("==============================");
			System.out.println("   " + enemyNAME + " Attack Missed!");
			System.out.println("      Your left HP : " + playerHP);
			System.out.println("==============================");
			System.out.println("");
		} else {
			System.out.println("==============================");
			System.out.println("     " + enemyNAME + "'s Attack!");
			damage = enemyAT - playerDF; //������ ����
			playerHP = playerHP - damage;
			player.setHealth(playerHP);
			System.out.println("      Your left HP : " + playerHP);
			System.out.println("==============================");
			System.out.println("");
		}
		
	}
	//�Ϲ� ���� �޼ҵ�
	public int NormalAttack(Enemy enemy) {
		Player player = Player.getInstance();
		
		int playerAT = player.getAttack();
		int damage;
		
		//���� ���� ������ �޾ƿ�
		int enemyDF = enemy.getDefend();
		int enemyHP = enemy.getHealth();
		String enemyNAME = enemy.getName();
		
		System.out.println("");
		System.out.println("==============================");
		System.out.println("   You hit the " + enemyNAME + "!");
		damage = playerAT - enemyDF; //������ ����
		enemyHP = enemyHP - damage; //�� ü�¿� ������ ���
		enemy.setHealth(enemyHP);
		System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
		System.out.println("==============================");
		System.out.println("");
		EnemyAct(enemy); //���� ���� ��
		
		return enemyHP;
	}
	//��ų ���� �޼ҵ�
	public int SkillSelect(Enemy enemy) {
		//������ ����
		String selectUA;
		
		//���� ���� ������ �޾ƿ�
		int enemyHP = enemy.getHealth();
		
		while(true) {
			System.out.println("");
			System.out.println("What kind of skill you use?");
			System.out.println("U. Utility Skill");
			System.out.println("A. Attack Skill");
			System.out.print("�� Select : ");
			selectUA = scan.nextLine();
			
			if(selectUA.equals("U") || selectUA.equals("u")) {
				UtilitySkill();
				EnemyAct(enemy); //���� ���� ��
				break;
			} else if(selectUA.equals("A") || selectUA.equals("a")) {
				AttackSkill(enemy);
				enemyHP = enemy.getHealth();
				break;
			} else {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			}
		}
		return enemyHP;
	}
	//��ƿ��Ƽ ��ų �޼ҵ�
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
	//���� ��ų �޼ҵ�
	public void AttackSkill(Enemy enemy) {
		Player player = Player.getInstance();
		Random random = new Random(); //���� Ȯ�� ����
		
		int playerAT = player.getAttack();
		int damage;
		
		//���� ���� ������ �޾ƿ�
		int enemyDF = enemy.getDefend();
		int enemyDX = enemy.getDexterity();
		int enemyHP = enemy.getHealth();
		String enemyNAME = enemy.getName();
		
		if(random.nextInt(100) < enemyDX+10) { //��ø���� Ȯ���� ���� or ������ ����
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
			damage = (playerAT * 2) - enemyDF; //������ ����
			enemyHP = enemyHP - damage; //�� ü�¿� ������ ���
			enemy.setHealth(enemyHP);
			System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
			System.out.println("==============================");
			System.out.println("");
			EnemyAct(enemy); //���� ���� ��
		}
	}
	//��� Ȯ�� �޼ҵ�
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
