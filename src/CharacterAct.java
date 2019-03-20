import java.util.Scanner;

public class CharacterAct {
	public void PlayerAct(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Scanner scan = new Scanner(System.in);
		Player player = Player.getInstance();
		
		char selectAS; //������ ����
		
		int playerHP, playerAT, playerDF;
		int damage;
		
		playerHP = player.getHealth(); //�÷��̾��� ���� ������ �޾ƿ�
		playerAT = player.getAttack();
		playerDF = player.getDefend();
		
		while(enemyHP > 0 && enemyHP != 0) { //���� ���� ü���� 0�� �ɶ�����
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SKILL ATTACK");
			System.out.print("Select : ");
			selectAS = scan.nextLine().charAt(0);
			
			if(selectAS == 'A' || selectAS == 'a') { //�Ϲ� ���� ������
				System.out.println("");
				System.out.println("=========================");
				System.out.println("You hit the " + enemyNAME + "!");
				damage = playerAT - enemyDF; //������ ����
				enemyHP = enemyHP - damage; //���� �� ü�¿� ������ ���
				System.out.println(enemyNAME + "'s left HP : "+enemyHP);
				System.out.println("=========================");
				System.out.println("");
				EnemyAct(enemyAT, enemyDF, enemyNAME); //���� ���� ��
			} else if(selectAS == 'S' || selectAS == 's') { //��ų ���� ������
				System.out.println("");
				System.out.println("=========================");
				System.out.println("You use skill \"SMITE!\"");
				damage = (playerAT*2) - enemyDF; //������ ����
				enemyHP = enemyHP - damage; //���� �� ü�¿� ������ ���
				System.out.println(enemyNAME + "'s left HP : "+enemyHP);
				System.out.println("=========================");
				System.out.println("");
				EnemyAct(enemyAT, enemyDF, enemyNAME); //���� ���� ��
			} else {
				System.out.println("Please Enter right command!");
				System.out.println("");
			}
		}
		if(enemyHP == 0 || enemyHP < 0) { //�������� Ŭ���� ����
			System.out.println("=========================");
			System.out.println(enemyNAME + " DOWN! YOU WIN!");
			System.out.println("=========================");
			//scan.close();
		}
	}
	public void EnemyAct(int enemyAT, int enemyDF, String enemyNAME) { //�� ���� �޼ҵ�
		Player player = Player.getInstance();
		int playerHP, playerDF;
		int damage;
		
		playerHP = player.getHealth(); //�÷��̾��� ���� ������ �޾ƿ�
		playerDF = player.getDefend();
		
		System.out.println("=========================");
		System.out.println(enemyNAME + "'s Attack!");
		damage = enemyAT - playerDF; //������ ����
		playerHP = playerHP - damage;
		player.setHealth(playerHP);
		System.out.println("Your left HP : " + playerHP);
		System.out.println("=========================");
		System.out.println("");
	}
}
