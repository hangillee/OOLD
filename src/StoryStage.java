
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//���� �� ü��:100, ���ݷ�:�÷��̾� ���� +10, ����:10, ��ø��:10
		Enemy dirtGolem = new Enemy();
		dirtGolem.setHealth(100);
		dirtGolem.setAttack(playerDefend+10);
		dirtGolem.setDefend(10);
		dirtGolem.setDexterity(10);
		dirtGolem.setName("DirtGolem");
		
		CharacterAct characterAct = new CharacterAct(); //�÷��̾�, ���� �ൿ Ŭ����
		
		int enemyHP, enemyAT, enemyDF, enemyDX;
		String enemyNAME;
		
		//ó�� ���� �� �ɷ�ġ ������ �޾ƿ�
		enemyHP = dirtGolem.getHealth(); 
		enemyAT = dirtGolem.getAttack();
		enemyDF = dirtGolem.getDefend();
		enemyDX = dirtGolem.getDexterity();
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
		System.out.println("�� " + enemyNAME + "'s DEX : " + enemyDX); //���� �� ��ø��
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME);
		Stage02();
	}
	public void Stage02() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//���� �� ü��:200, ���ݷ�:�÷��̾� ����+15, ����:20, ��ø��:20
		Enemy stoneGolem = new Enemy(); 
		stoneGolem.setHealth(200);
		stoneGolem.setAttack(playerDefend+15);
		stoneGolem.setDefend(20);
		stoneGolem.setDexterity(20);
		stoneGolem.setName("STONE GOLEM");
		
		CharacterAct characterAct = new CharacterAct(); //�÷��̾�, ���� �ൿ Ŭ����
		
		int enemyHP, enemyAT, enemyDF, enemyDX;
		String enemyNAME;
		
		//ó�� ���� �� ü�� ������ �޾ƿ�
		enemyHP = stoneGolem.getHealth(); 
		enemyAT = stoneGolem.getAttack();
		enemyDF = stoneGolem.getDefend();
		enemyDX = stoneGolem.getDexterity();
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
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME);
		//Stage03();
	}
}
