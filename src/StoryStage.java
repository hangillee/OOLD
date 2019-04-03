
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//Builder Pattern
		//진흙 골렘 체력:100, 공격력:플레이어 방어력 +10, 방어력:10, 민첩성:10
		Enemy dirtGolem = new Enemy.EnemyCreator()
				.setHealth(100)
				.setAttack(playerDefend+10)
				.setDefend(10)
				.setDexterity(10)
				.setName("DIRT GOLEM")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //플레이어, 적의 행동 클래스
		
		//처음 진흙 골렘 능력치 데이터 받아옴
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
		System.out.println(enemyNAME + " BLOCKS YOUR WAY!");
		PrintMethods.PrintEnemyStat(enemyNAME, enemyHP, enemyAT, enemyDF);
		PrintMethods.PrintPlayerStat();
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME, 1);
		
		Stage02();
	}
	public void Stage02() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//Builder Pattern
		//바위 골렘 체력:200, 공격력:플레이어 방어력+15, 방어력:20, 민첩성:20
		Enemy stoneGolem = new Enemy.EnemyCreator()
				.setHealth(200)
				.setAttack(playerDefend+15)
				.setDefend(20)
				.setDexterity(20)
				.setName("STONE GOLEM")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //플레이어, 적의 행동 클래스
		
		//처음 바위 골렘 체력 데이터 받아옴
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
		PrintMethods.PrintEnemyStat(enemyNAME, enemyHP, enemyAT, enemyDF);
		PrintMethods.PrintPlayerStat();
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME, 2);
		Stage03();
	}
	public void Stage03() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//Builder Pattern
		//지옥불 용 체력:200, 공격력:플레이어 방어력+20, 방어력:25, 민첩성:25
		Enemy hfDragon = new Enemy.EnemyCreator()
				.setHealth(300)
				.setAttack(playerDefend+20)
				.setDefend(25)
				.setDexterity(25)
				.setName("HELLFIRE DRAGON")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //플레이어, 적의 행동 클래스
		
		//처음 바위 골렘 체력 데이터 받아옴
		int enemyHP = hfDragon.getHealth(); 
		int enemyAT = hfDragon.getAttack();
		int enemyDF = hfDragon.getDefend();
		int enemyDX = hfDragon.getDexterity();
		String enemyNAME = hfDragon.getName();
		
		System.out.println("============== Stage 03 ==============");
		System.out.println("");
		System.out.println("            HELLFIRE DRAGON           ");
		System.out.println("");
		System.out.println("======================================");
		System.out.println("");
		System.out.println(enemyNAME + " BLOCKS YOUR WAY!");
		PrintMethods.PrintEnemyStat(enemyNAME, enemyHP, enemyAT, enemyDF);
		PrintMethods.PrintPlayerStat();
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME, 3);
		//Stage04();
	}
}
