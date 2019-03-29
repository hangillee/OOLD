import java.util.Random;
import java.util.Scanner;

public class CharacterAct {
	private static final Scanner scan = new Scanner(System.in);
	Reward reward = new Reward();
	public void PlayerAct(int enemyHP, int enemyAT, int enemyDF, int enemyDX, String enemyNAME, int stageNumber) {
		Player player = Player.getInstance();
		Random random = new Random(); //���� Ȯ�� ����
		
		String selectAS; //������ ����
		
		int playerHP;
		playerHP = player.getHealth(); //�÷��̾��� ���� ������ �޾ƿ�
		
		while(true) { //���� ü���� 0�� �ɶ�����
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SKILL ATTACK");
			System.out.print("�� Select : ");
			selectAS = scan.nextLine();
			
			if(selectAS.equals("A") || selectAS.equals("a")) { //�Ϲ� ���� ������
				
				if(random.nextInt(100) < enemyDX) { //��ø���� Ȯ���� ���� or ������ ����
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
				
				//�÷��̾��� ü���� 0�̳� 0���� �۾����� ���� �������� ������ ���� ����
				if(playerHP < 0 || playerHP == 0) {
					GameOver();
					break;
				} else if(enemyHP < 0 || enemyHP == 0) {
					StageClear(enemyNAME);
					reward.GiveReward(enemyNAME, stageNumber);
					break;
				}
				
			} else if(selectAS.equals("S") || selectAS.equals("s")) { //��ų ���� ������
				
				if(random.nextInt(100) < enemyDX) { //��ø���� Ȯ���� ���� or ������ ����
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
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			}
		}
	}
	//���� ���� �޼ҵ�
	public void EnemyAct(int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		Random random = new Random();
		
		//�÷��̾��� ���� ������ �޾ƿ�
		int playerHP = player.getHealth();
		int playerDF = player.getDefend();
		int playerDX = player.getDexterity();
		int damage = 0;
		
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
	public int NormalAttack(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		
		int playerAT;
		int damage;
		
		playerAT = player.getAttack();
		
		System.out.println("");
		System.out.println("==============================");
		System.out.println("   You hit the " + enemyNAME + "!");
		damage = playerAT - enemyDF; //������ ����
		enemyHP = enemyHP - damage; //�� ü�¿� ������ ���
		System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
		System.out.println("==============================");
		System.out.println("");
		EnemyAct(enemyAT, enemyDF, enemyNAME); //���� ���� ��
		
		return enemyHP;
	}
	//��ų ���� �޼ҵ�
	public int SkillAttack(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		
		int playerAT;
		int damage;
		
		playerAT = player.getAttack();
		
		System.out.println("");
		System.out.println("==============================");
		System.out.println("    You use skill \"SMITE!\"   ");
		damage = (playerAT * 2) - enemyDF; //������ ����
		enemyHP = enemyHP - damage; //�� ü�¿� ������ ���
		System.out.println("  " + enemyNAME + "'s left HP : "+enemyHP);
		System.out.println("==============================");
		System.out.println("");
		EnemyAct(enemyAT, enemyDF, enemyNAME); //���� ���� ��
		
		return enemyHP;
	}
	//Stage Ŭ���� �� ��� �޼ҵ�
	public void StageClear(String enemyNAME) {
		Player player = Player.getInstance();
		
		player.setHealth(100); //�÷��̾� Ŭ���� �� ü�� �ʱ�ȭ
		System.out.println("==============================");
		System.out.println("                              ");
		System.out.println("  " + enemyNAME + " DOWN! YOU WIN!  ");
		System.out.println("                              ");
		System.out.println("==============================");
		System.out.println("");
		System.out.println("  Press Enter to continue...");
		String insert = scan.nextLine();
		
		while(true) { //EnterŰ�� ���� ������ ���� ����
			if(insert.length() == 0) {
				break;
			}
			else {
				System.out.println("  Please Press ENTER to continue!");
				insert = scan.nextLine();
			}
		}
	}
	//���� ���� �� ��� �޼ҵ�
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
				Player.maximumstat = 50; //���� ����Ʈ �ʱ�ȭ
				PrintMethods.ClearScreen();
				MainPage.main(null); //�ٽ� ����
				break;
			} else if(selectYN.equals("N") || selectYN.equals("n")) {
				System.out.println("");
				System.out.println("===============================");
				System.out.println("  Exit Game. Try Again Later!  ");
				System.out.println("===============================");
				System.exit(0);
			} else if(selectYN.equals("")) {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			} else {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			}
		}
		
	}
}
