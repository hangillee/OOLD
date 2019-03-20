import java.util.Scanner;

public class CharacterAct {
	public void PlayerAct(int enemyHP, int enemyAT, int enemyDF, String enemyNAME) {
		Scanner scan = new Scanner(System.in);
		Player player = Player.getInstance();
		
		char selectAS; //선택지 변수
		
		int playerHP, playerAT, playerDF;
		int damage;
		
		playerHP = player.getHealth(); //플레이어의 스탯 데이터 받아옴
		playerAT = player.getAttack();
		playerDF = player.getDefend();
		
		while(enemyHP > 0 && enemyHP != 0) { //진흙 골렘의 체력이 0이 될때까지
			System.out.println("What should you do?");
			System.out.println("A. NORMAL ATTACK");
			System.out.println("S. SKILL ATTACK");
			System.out.print("Select : ");
			selectAS = scan.nextLine().charAt(0);
			
			if(selectAS == 'A' || selectAS == 'a') { //일반 공격 선택지
				System.out.println("");
				System.out.println("=========================");
				System.out.println("You hit the " + enemyNAME + "!");
				damage = playerAT - enemyDF; //데미지 계산식
				enemyHP = enemyHP - damage; //진흙 골렘 체력에 데미지 계산
				System.out.println(enemyNAME + "'s left HP : "+enemyHP);
				System.out.println("=========================");
				System.out.println("");
				EnemyAct(enemyAT, enemyDF, enemyNAME); //적의 공격 턴
			} else if(selectAS == 'S' || selectAS == 's') { //스킬 공격 선택지
				System.out.println("");
				System.out.println("=========================");
				System.out.println("You use skill \"SMITE!\"");
				damage = (playerAT*2) - enemyDF; //데미지 계산식
				enemyHP = enemyHP - damage; //진흙 골렘 체력에 데미지 계산
				System.out.println(enemyNAME + "'s left HP : "+enemyHP);
				System.out.println("=========================");
				System.out.println("");
				EnemyAct(enemyAT, enemyDF, enemyNAME); //적의 공격 턴
			} else {
				System.out.println("Please Enter right command!");
				System.out.println("");
			}
		}
		if(enemyHP == 0 || enemyHP < 0) { //스테이지 클리어 조건
			System.out.println("=========================");
			System.out.println(enemyNAME + " DOWN! YOU WIN!");
			System.out.println("=========================");
			//scan.close();
		}
	}
	public void EnemyAct(int enemyAT, int enemyDF, String enemyNAME) { //적 공격 메소드
		Player player = Player.getInstance();
		int playerHP, playerDF;
		int damage;
		
		playerHP = player.getHealth(); //플레이어의 스탯 데이터 받아옴
		playerDF = player.getDefend();
		
		System.out.println("=========================");
		System.out.println(enemyNAME + "'s Attack!");
		damage = enemyAT - playerDF; //데미지 계산식
		playerHP = playerHP - damage;
		player.setHealth(playerHP);
		System.out.println("Your left HP : " + playerHP);
		System.out.println("=========================");
		System.out.println("");
	}
}
