
public class StoryStage {
	public void Stage01() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//ÁøÈë °ñ·½ Ã¼·Â:100, °ø°Ý·Â:ÇÃ·¹ÀÌ¾î ¹æ¾î·Â +10, ¹æ¾î·Â:10, ¹ÎÃ¸¼º:10
		Enemy dirtGolem = new Enemy();
		dirtGolem.setHealth(100);
		dirtGolem.setAttack(playerDefend+10);
		dirtGolem.setDefend(10);
		dirtGolem.setDexterity(10);
		dirtGolem.setName("DirtGolem");
		
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
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME);
		Stage02();
	}
	public void Stage02() {
		PrintMethods.ClearScreen();
		Player player = Player.getInstance();
		int playerDefend = player.getDefend();
		
		//¹ÙÀ§ °ñ·½ Ã¼·Â:200, °ø°Ý·Â:ÇÃ·¹ÀÌ¾î ¹æ¾î·Â+15, ¹æ¾î·Â:20, ¹ÎÃ¸¼º:20
		Enemy stoneGolem = new Enemy(); 
		stoneGolem.setHealth(200);
		stoneGolem.setAttack(playerDefend+15);
		stoneGolem.setDefend(20);
		stoneGolem.setDexterity(20);
		stoneGolem.setName("STONE GOLEM");
		
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
		
		characterAct.PlayerAct(enemyHP, enemyAT, enemyDF, enemyDX, enemyNAME);
		//Stage03();
	}
}
