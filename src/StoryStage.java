
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//Builder Pattern
		//ÁøÈë °ñ·½ Ã¼·Â:100, °ø°Ý·Â:ÇÃ·¹ÀÌ¾î ¹æ¾î·Â +10, ¹æ¾î·Â:10, ¹ÎÃ¸¼º:10
		Enemy dirtGolem = new Enemy.EnemyCreator()
				.setHealth(100)
				.setAttack(playerDefend+10)
				.setDefend(10)
				.setDexterity(10)
				.setName("DIRT GOLEM")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //ÇÃ·¹ÀÌ¾î, ÀûÀÇ Çàµ¿ Å¬·¡½º
		
		//Ã³À½ ÁøÈë °ñ·½ ´É·ÂÄ¡ µ¥ÀÌÅÍ ¹Þ¾Æ¿È
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
		System.out.println("¢º " + enemyNAME + "'s HP : " + enemyHP); //ÁøÈë °ñ·½ Ã¼·Â
		System.out.println("¢º " + enemyNAME + "'s STR : " + enemyAT); //ÁøÈë °ñ·½ °ø°Ý·Â
		System.out.println("¢º " + enemyNAME + "'s DEF : " + enemyDF); //ÁøÈë °ñ·½ ¹æ¾î·Â
		System.out.println("¢º " + enemyNAME + "'s DEX : " + enemyDX); //ÁøÈë °ñ·½ ¹ÎÃ¸¼º
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME, 1);
		
		Stage02();
	}
	public void Stage02() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//Builder Pattern
		//¹ÙÀ§ °ñ·½ Ã¼·Â:200, °ø°Ý·Â:ÇÃ·¹ÀÌ¾î ¹æ¾î·Â+15, ¹æ¾î·Â:20, ¹ÎÃ¸¼º:20
		Enemy stoneGolem = new Enemy.EnemyCreator()
				.setHealth(200)
				.setAttack(playerDefend+15)
				.setDefend(20)
				.setDexterity(20)
				.setName("STONE GOLEM")
				.Create();
		
		CharacterAct characterAct = new CharacterAct(); //ÇÃ·¹ÀÌ¾î, ÀûÀÇ Çàµ¿ Å¬·¡½º
		
		//Ã³À½ ¹ÙÀ§ °ñ·½ Ã¼·Â µ¥ÀÌÅÍ ¹Þ¾Æ¿È
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
		System.out.println("¢º " + enemyNAME + "'s HP : " + enemyHP); //¹ÙÀ§ °ñ·½ Ã¼·Â
		System.out.println("¢º " + enemyNAME + "'s STR : " + enemyAT); //¹ÙÀ§ °ñ·½ °ø°Ý·Â
		System.out.println("¢º " + enemyNAME + "'s DEF : " + enemyDF); //¹ÙÀ§ °ñ·½ ¹æ¾î·Â
		System.out.println("");
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME, 2);
		//Stage03();
	}
}
