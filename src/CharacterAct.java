import java.util.Scanner;

public class CharacterAct {
	private static final Scanner scan = new Scanner(System.in);
	public void PlayerAct(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		
		char selectAS; //������ ����
		
		int playerHP;
		playerHP = player.getHealth(); //�÷��̾��� ���� ������ �޾ƿ�
		
		while(true) { //���� ü���� 0�� �ɶ�����
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SKILL ATTACK");
			System.out.print("�� Select : ");
			selectAS = scan.nextLine().charAt(0);
			
			if(selectAS == 'A' || selectAS == 'a') { //�Ϲ� ���� ������
				enemyHP = NormalAttack(enemyHP, enemyAT, enemyDF, enemyNAME);
				playerHP = player.getHealth();
				if(enemyHP < 0 || enemyHP == 0) {
					StageClear(enemyNAME);
					break;
				} else if(playerHP < 0 || playerHP == 0) {
					GameOver();
					break;
				}
			} else if(selectAS == 'S' || selectAS == 's') { //��ų ���� ������
				enemyHP = SkillAttack(enemyHP, enemyAT, enemyDF, enemyNAME);
				playerHP = player.getHealth();
				if(enemyHP < 0 || enemyHP == 0) {
					StageClear(enemyNAME);
					break;
				} else if(playerHP < 0 || playerHP == 0) {
					GameOver();
					break;
				}
			} else {
				System.out.println("�� Please Enter right command!");
				System.out.println("");
			}
		}
	}
	//���� ���� �޼ҵ�
	public void EnemyAct(int enemyAT, int enemyDF, String enemyNAME) {
		Player player = Player.getInstance();
		int playerHP, playerDF;
		int damage;
		
		playerHP = player.getHealth(); //�÷��̾��� ���� ������ �޾ƿ�
		playerDF = player.getDefend();
		
		System.out.println("==============================");
		System.out.println("     " + enemyNAME + "'s Attack!");
		damage = enemyAT - playerDF; //������ ����
		playerHP = playerHP - damage;
		player.setHealth(playerHP);
		System.out.println("      Your left HP : " + playerHP);
		System.out.println("==============================");
		System.out.println("");
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
		damage = (playerAT*2) - enemyDF; //������ ����
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
				//scan.close();
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
		char selectYN;
		
		System.out.println("==============================");
		System.out.println("=                            =");
		System.out.println("=    GAME OVER! YOU DIED!    =");
		System.out.println("=        Retry? (Y/N)        =");
		System.out.println("=                            =");
		System.out.println("==============================");
		System.out.println("");
		System.out.print("Select : ");
		selectYN = scan.nextLine().charAt(0);
		
		if(selectYN=='Y'||selectYN=='y') {
			Player.maximumstat = 50; //���� ����Ʈ �ʱ�ȭ
			PrintMethods.ClearScreen();
			scan.close();
			MainPage.main(null); //�ٽ� ����
		} else if(selectYN=='N'||selectYN=='n') {
			System.out.println("");
			System.out.println("===============================");
			System.out.println("  Exit Game. Try Again Later!  ");
			System.out.println("===============================");
			System.exit(0);
		}
	}
}
