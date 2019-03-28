
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//Builder Pattern
		//���� �� ü��:100, ���ݷ�:�÷��̾� ���� +10, ����:10, ��ø��:10
		Enemy dirtGolem = new Enemy.EnemyCreator()
				.setHealth(100)
				.setAttack(playerDefend+10)
				.setDefend(10)
				.setDexterity(10)
				.setName("DIRT GOLEM")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //�÷��̾�, ���� �ൿ Ŭ����
		
		//ó�� ���� �� �ɷ�ġ ������ �޾ƿ�
		int enemyHP = dirtGolem.getHealth(); 
		int enemyAT = dirtGolem.getAttack();
		int enemyDF = dirtGolem.getDefend();
		int enemyDX = dirtGolem.getDexterity();
		String enemyNAME = dirtGolem.getName();
		
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
		
		//Builder Pattern
		//���� �� ü��:200, ���ݷ�:�÷��̾� ����+15, ����:20, ��ø��:20
		Enemy stoneGolem = new Enemy.EnemyCreator()
				.setHealth(200)
				.setAttack(playerDefend+15)
				.setDefend(20)
				.setDexterity(20)
				.setName("STONE GOLEM")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //�÷��̾�, ���� �ൿ Ŭ����
		
		//ó�� ���� �� ü�� ������ �޾ƿ�
		int enemyHP = stoneGolem.getHealth(); 
		int enemyAT = stoneGolem.getAttack();
		int enemyDF = stoneGolem.getDefend();
		int enemyDX = stoneGolem.getDexterity();
		String enemyNAME = stoneGolem.getName();
		
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
