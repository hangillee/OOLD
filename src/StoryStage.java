
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		Enemy dirtGolem = new Enemy(100, playerDefend+10, 10, "DIRT GOLEM"); //���� �� ü��:100, ���ݷ�:�÷��̾� ���� + 10, ����:10
		CharacterAct characterAct = new CharacterAct();
		
		int enemyHP, enemyAT, enemyDF;
		String enemyNAME;
		
		enemyHP = dirtGolem.getHealth(); //ó�� ���� �� ü�� ������ �޾ƿ�
		enemyAT = dirtGolem.getAttack();
		enemyDF = dirtGolem.getDefend();
		enemyNAME = dirtGolem.getName();
		
		System.out.println("============== Stage 01 ==============");
		System.out.println("");
		System.out.println("              DIRT GOLEM              ");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println("DIRT GOLEM BLOCKS YOUR WAY!");
		System.out.println("�� " + enemyNAME + "'s HP : " + enemyHP); //���� �� ü��
		System.out.println("�� " + enemyNAME + "'s STR : " + enemyAT); //���� �� ���ݷ�
		System.out.println("�� " + enemyNAME + "'s DEF : " + enemyDF); //���� �� ����
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyNAME);
		Stage02();
	}
	public void Stage02() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		Enemy stoneGolem = new Enemy(200, playerDefend+15, 20, "STONE GOLEM"); //���� �� ü��:200, ���ݷ�:�÷��̾� ����+15, ����:20
		CharacterAct characterAct = new CharacterAct();
		
		int enemyHP, enemyAT, enemyDF;
		String enemyNAME;
		
		enemyHP = stoneGolem.getHealth(); //ó�� ���� �� ü�� ������ �޾ƿ�
		enemyAT = stoneGolem.getAttack();
		enemyDF = stoneGolem.getDefend();
		enemyNAME = stoneGolem.getName();
		
		System.out.println("============== Stage 02 ==============");
		System.out.println("");
		System.out.println("             STONE GOLEM              ");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println(enemyNAME + " BLOCKS YOUR WAY!");
		System.out.println("�� " + enemyNAME + "'s HP : " + enemyHP); //���� �� ü��
		System.out.println("�� " + enemyNAME + "'s STR : " + enemyAT); //���� �� ���ݷ�
		System.out.println("�� " + enemyNAME + "'s DEF : " + enemyDF); //���� �� ����
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyNAME);
		//Stage03();
	}
}
